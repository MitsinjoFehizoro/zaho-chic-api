package edu.mitsinjo.zahochic.service.user;

import edu.mitsinjo.zahochic.EnumUserRole;
import edu.mitsinjo.zahochic.exception.AlreadyExistException;
import edu.mitsinjo.zahochic.jwt.JwtUtil;
import edu.mitsinjo.zahochic.model.User;
import edu.mitsinjo.zahochic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User addUser(User user) {
        if (getUserByUsername(user.getUsername()) != null) {
            throw new AlreadyExistException("Utilisateur " + user.getUsername() + " déja enregistré.");
        }
        user.createCart();
        user.setRole(EnumUserRole.USER_CLIENT.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Map<String, Object> authenticateUser(User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Map<String, Object> dataResponse = new HashMap<>();
        dataResponse.put("token", jwtUtil.generateToken(userDetails.getUsername()));
        dataResponse.put("type", "Bearer");
        dataResponse.put("username", user.getUsername());
        dataResponse.put("role", userDetails.getAuthorities());
        return dataResponse;
    }
}

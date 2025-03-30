package edu.mitsinjo.zahochic.service.user;

import edu.mitsinjo.zahochic.exception.AlreadyExistException;
import edu.mitsinjo.zahochic.model.User;
import edu.mitsinjo.zahochic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return Optional.ofNullable(user)
                .map(u -> new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(u.getRole()))))
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur " + username + " non trouvé."));
    }
}

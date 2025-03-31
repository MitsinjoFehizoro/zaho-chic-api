package edu.mitsinjo.zahochic.controller;

import edu.mitsinjo.zahochic.model.Image;
import edu.mitsinjo.zahochic.response.ApiResponse;
import edu.mitsinjo.zahochic.service.image.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/images")
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addImage(@Valid @RequestBody Image image, @RequestParam String productId) {
       Image savedImage = imageService.addImage(image, productId);
        return ResponseEntity.ok(new ApiResponse("Inage added successfully.", savedImage));
    }
}

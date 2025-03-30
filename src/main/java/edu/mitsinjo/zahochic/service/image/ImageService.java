package edu.mitsinjo.zahochic.service.image;

import edu.mitsinjo.zahochic.model.Image;
import edu.mitsinjo.zahochic.model.Product;
import edu.mitsinjo.zahochic.repository.ImageRepository;
import edu.mitsinjo.zahochic.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService implements IImageService {
    private final ImageRepository imageRepository;
    private final ProductService productService;

    @Override
    public Image addImage(Image image, Long productId) {
        Product product = productService.getProductById(productId);
        image.setProduct(product);
        return imageRepository.save(image);
    }
}

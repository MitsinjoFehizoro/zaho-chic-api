package edu.mitsinjo.zahochic.service.image;

import edu.mitsinjo.zahochic.model.Image;

public interface IImageService {
    Image addImage(Image image, String productId);
}

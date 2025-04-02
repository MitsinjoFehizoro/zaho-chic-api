package edu.mitsinjo.zahochic;

import edu.mitsinjo.zahochic.service.product.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZahoChicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZahoChicApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductService productService) {
		return (args) -> {productService.loadDefaultProducts();};
	}
}

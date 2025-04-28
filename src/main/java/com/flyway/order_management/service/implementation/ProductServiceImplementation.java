package com.flyway.order_management.service.implementation;

import com.flyway.order_management.exception.customExceptions.ProductNotFoundException;
import com.flyway.order_management.mapper.specification.ProductMapper;
import com.flyway.order_management.model.dto.ProductDTO;
import com.flyway.order_management.model.entity.Product;
import com.flyway.order_management.repository.ProductRepository;
import com.flyway.order_management.service.specification.ProductService;

import java.util.List;

/**
 * ProductServiceImplementation class that implements the ProductService interface.
 */
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    /**
     * All argument Constructor for injecting necessary dependencies in ProductServiceImplementation.
     *
     * @param productRepository the product service to be injected.
     * @param productMapper     the product mapper to be injected.
     */
    public ProductServiceImplementation(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to be retrieved.
     * @return the product data transfer object.
     */
    @Override
    public ProductDTO getProductById(int id) {
        return productRepository.findById(id)
                .map(product -> new ProductDTO(product.getProductId(), product.getName(), product.getPrice(), product.getStock()))
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    /**
     * Retrieves all products in the system.
     *
     * @return an iterable collection of product data transfer objects.
     */
    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductDTO(product.getProductId(), product.getName(), product.getPrice(), product.getStock()))
                .toList();
    }

    /**
     * Adds a new product to the system.
     *
     * @param productDTO the product data transfer object containing product details.
     * @return the added product data transfer object.
     */
    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        return productMapper.mapToProductDTO(productRepository.save(productMapper.mapToProduct(productDTO)));
    }

    /**
     * Updates an existing product in the system.
     *
     * @param productDTO the product data transfer object containing updated product details.
     * @return the updated product data transfer object.
     */
    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (productDTO.getName() != null) {
            product.setName(productDTO.getName());
        }
        if (productDTO.getPrice() != null) {
            product.setPrice(productDTO.getPrice());
        }
        if (productDTO.getStock() != 0) {
            product.setStock(productDTO.getStock());
        }
        Product updatedProduct = productRepository.save(product);
        return productMapper.mapToProductDTO(updatedProduct);
    }

    /**
     * Deletes a product from the system by its ID.
     *
     * @param id the ID of the product to be deleted.
     */
    @Override
    public void deleteProduct(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        productRepository.delete(product);
    }
}

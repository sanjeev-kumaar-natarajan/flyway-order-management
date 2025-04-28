package com.flyway.order_management.service.specification;

import com.flyway.order_management.model.dto.ProductDTO;

import java.util.List;

/**
 * ProductService interface that serves as a marker interface for product service.
 */
public interface ProductService {

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to be retrieved.
     * @return the product data transfer object.
     */
    ProductDTO getProductById(int id);

    /**
     * Retrieves all products in the system.
     *
     * @return an iterable collection of product data transfer objects.
     */
    List<ProductDTO> getAllProducts();

    /**
     * Adds a new product to the system.
     *
     * @param productDTO the product data transfer object containing product details.
     * @return the added product data transfer object.
     */
    ProductDTO addProduct(ProductDTO productDTO);

    /**
     * Updates an existing product in the system.
     *
     * @param productDTO the product data transfer object containing updated product details.
     * @return the updated product data transfer object.
     */
    ProductDTO updateProduct(ProductDTO productDTO);

    /**
     * Deletes a product from the system by its ID.
     *
     * @param id the ID of the product to be deleted.
     */
    void deleteProduct(int id);

}

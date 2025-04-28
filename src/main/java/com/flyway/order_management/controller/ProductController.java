package com.flyway.order_management.controller;

import com.flyway.order_management.model.dto.ProductDTO;
import com.flyway.order_management.service.specification.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    /**
     * All Argument constructor to inject all the dependencies.
     *
     * @param productService Product Service object for fetching products related data.
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Get Mapping Find All method to fetch all the products data.
     *
     * @return A list of all products data stored in ProductDTO object.
     */
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    /**
     * Get Mapping Find By Id method to fetch a product data by its id.
     *
     * @param id the id of the product to be fetched.
     * @return A ProductDTO object containing the product data.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(int id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    /**
     * Post Mapping Add Product method to add a new product.
     *
     * @param productDTO the product data to be added.
     * @return A ProductDTO object containing the added product data.
     */
    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.addProduct(productDTO), HttpStatus.CREATED);
    }

    /**
     * Put Mapping Update Product method to update an existing product.
     *
     * @param productDTO the product data to be updated.
     * @return A ProductDTO object containing the updated product data.
     */
    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.updateProduct(productDTO), HttpStatus.OK);
    }

    /**
     * Delete Mapping Delete Product method to delete a product by its id.
     *
     * @param id the id of the product to be deleted.
     * @return A ResponseEntity indicating the result of the deletion operation.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

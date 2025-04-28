package com.flyway.order_management.mapper.specification;

import com.flyway.order_management.model.dto.ProductDTO;
import com.flyway.order_management.model.entity.Product;

/**
 * ProductMapper interface that serves as a marker interface for product mapping.
 */
public interface ProductMapper {

    /**
     * Maps a ProductDTO object to a Product entity.
     *
     * @param productDTO the ProductDTO object to be mapped.
     * @return the mapped Product entity.
     */
    public Product mapToProduct(ProductDTO productDTO);

    /**
     * Maps a Product entity to a ProductDTO object.
     *
     * @param product the Product entity to be mapped.
     * @return the mapped ProductDTO object.
     */
    public ProductDTO mapToProductDTO(Product product);

}

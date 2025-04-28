package com.flyway.order_management.mapper.implementation;

import com.flyway.order_management.mapper.specification.ProductMapper;
import com.flyway.order_management.model.dto.ProductDTO;
import com.flyway.order_management.model.entity.Product;
import org.springframework.stereotype.Component;

/**
 * ProductMapperImplementation class that implements the ProductMapper interface.
 */
@Component
public class ProductMapperImplementation implements ProductMapper {

    /**
     * Maps a ProductDTO object to a Product entity.
     *
     * @param productDTO the ProductDTO object to be mapped.
     * @return the mapped Product entity.
     */
    @Override
    public Product mapToProduct(ProductDTO productDTO) {
        return new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getStock());
    }

    /**
     * Maps a Product entity to a ProductDTO object.
     *
     * @param product the Product entity to be mapped.
     * @return the mapped ProductDTO object.
     */
    @Override
    public ProductDTO mapToProductDTO(Product product) {
        return new ProductDTO(product.getProductId(), product.getName(), product.getPrice(), product.getStock());
    }
}

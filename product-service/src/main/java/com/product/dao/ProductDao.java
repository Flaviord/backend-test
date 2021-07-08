package com.product.dao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    @SqlQuery("SELECT product_id FROM products WHERE product_id = :productId")
    Optional<String> findProductById(@Bind("productId") String productId);

    @SqlQuery("SELECT product_id FROM products")
    Optional<List<String>> getAllProducts();

    @SqlUpdate("INSERT INTO products VALUES (:productId)")
    int insertProduct(@Bind("productId") String productId);
}

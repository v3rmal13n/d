package com.parsing.demo.repo;

import com.parsing.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
//    Page<Products> findByTitleContaining(String title, Pageable pageable);

//    @Query(value = "SELECT * FROM products p WHERE p.title LIKE %:query% ORDER BY p.price ASC", countQuery = "SELECT COUNT(*) FROM products p WHERE p.title LIKE %:query%", nativeQuery = true)
//    Page<Products> searchProducts(@Param("query") String query, Pageable pageable);


//    List<Products> findByTitleContaining(String title, Sort sort);

//    @Query(value = "SELECT p.id, p.name, p.categoryid, p.imagepath, p.price, p.url " +
//            "FROM prod p WHERE p.name LIKE %:query% " +
//            "ORDER BY CASE WHEN :sortByPriceAscending = true THEN p.price END ASC, " +
//            "CASE WHEN :sortByPriceAscending = false THEN p.price END DESC",
//            countQuery = "SELECT COUNT(*) FROM prod p WHERE p.name LIKE %:query%",
//            nativeQuery = true)
//    Page<ProductsProjection> searchProducts(@Param("query") String query, @Param("sortByPriceAscending") boolean sortByPriceAscending, Pageable pageable);

    @Query(value = "SELECT p.id, p.name, p.categoryid, p.imagepath, p.price, p.url " +
            "FROM product p " +
            "WHERE p.name LIKE %:query% " +
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice) " +
            "ORDER BY CASE WHEN :sortByPriceAscending = true THEN p.price END ASC, " +
            "CASE WHEN :sortByPriceAscending = false THEN p.price END DESC",
            countQuery = "SELECT COUNT(*) FROM product p WHERE p.name LIKE %:query%",
            nativeQuery = true)
    Page<ProductsProjection> searchProducts(
            @Param("query") String query,
            @Param("sortByPriceAscending") boolean sortByPriceAscending,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            Pageable pageable);


    List<Product> findByNameContaining(String query, Sort sort);

    @Query("SELECT p FROM Product p WHERE p.categoryid = :categoryId")
    List<Product> findByCategory(@Param("categoryId") Integer categoryId);


}

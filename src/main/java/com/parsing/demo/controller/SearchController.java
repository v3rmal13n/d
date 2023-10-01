package com.parsing.demo.controller;

import com.parsing.demo.dto.ProductDTO;
import com.parsing.demo.model.Product;
import com.parsing.demo.repo.CategoryRepo;
import com.parsing.demo.repo.ProductRepo;
import com.parsing.demo.repo.ProductsProjection;
import com.parsing.demo.repo.SubcategoryRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SearchController {

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
    private final CategoryRepo categoryRepo;
    private final ProductRepo productRepo;
    private final SubcategoryRepo subcategoryRepo;


    @GetMapping("/search")
    public Page<ProductDTO> searchProducts(
            @RequestParam("query") String query,
            @RequestParam("sortByPriceAscending") boolean sortByPriceAscending,
            @RequestParam(value = "minPrice", required = false) BigDecimal minPrice,
            @RequestParam(value = "maxPrice", required = false) BigDecimal maxPrice,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductsProjection> result = productRepo.searchProducts(query, sortByPriceAscending, minPrice, maxPrice, pageable);
        Page<ProductDTO> productsDTOPage = result.map(
                projection -> new ProductDTO(
                        projection.getId(),
                        projection.getName(),
                        projection.getSubcategoryid(),
                        projection.getImagepath(),
                        projection.getPrice(),
                        projection.getUrl()
                )
        );

        return productsDTOPage;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Optional<Product> result = productRepo.findById(id);

        if (result.isPresent()) {
            Product product = result.get();
            return ResponseEntity.ok(product);
        } else {
            return null;
        }
    }

    @GetMapping("/product")
    public ResponseEntity<Optional<Product>> findById(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(productRepo.findById(id));
    }


}

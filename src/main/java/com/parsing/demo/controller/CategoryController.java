package com.parsing.demo.controller;


import com.parsing.demo.model.Category;
import com.parsing.demo.model.Product;
import com.parsing.demo.model.Subcategory;
import com.parsing.demo.repo.CategoryRepo;
import com.parsing.demo.repo.ProductRepo;
import com.parsing.demo.repo.SubcategoryRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
    private final CategoryRepo categoryRepo;
    private final ProductRepo productRepo;
    private final SubcategoryRepo subcategoryRepo;

    @GetMapping("/search/bySubcategory")
    public List<Product> getProductsBySubcategory(@RequestParam("subcategoryId") Integer subcategoryId) {
        List<Product> products = productRepo.findBySubcategory(subcategoryId);
        logger.info(products.toString());
        return products;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryRepo.findAll());
    }

    @GetMapping("/subcategories")
    public ResponseEntity<List<Subcategory>> subcategoriesByCategoryId(@RequestParam("categoryId") int categoryId) {
        return ResponseEntity.ok(subcategoryRepo.findByCategoryid(categoryId));
    }

}

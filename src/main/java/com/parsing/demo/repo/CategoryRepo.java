package com.parsing.demo.repo;

import com.parsing.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

//    @Query(value = "SELECT name, GROUP_CONCAT(subcategory) FROM category GROUP BY name", nativeQuery = true)
//    List<Object[]> findCategoryNamesWithConcatenatedSubcategories();
}

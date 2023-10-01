package com.parsing.demo.repo;

import com.parsing.demo.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubcategoryRepo extends JpaRepository<Subcategory, Integer> {
    public List<Subcategory> findByCategoryid(int categoryId);
}

package com.dev.zine.dao;

import com.dev.zine.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesDAO extends JpaRepository<Categories,String> {

}

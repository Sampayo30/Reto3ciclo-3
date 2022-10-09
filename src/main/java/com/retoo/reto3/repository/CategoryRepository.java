package com.retoo.reto3.repository;

import com.retoo.reto3.entidades.Category;
import com.retoo.reto3.repository.crudRepository.CategoryCrudRepositoory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepositoory categoryCrudRepositoory;
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepositoory.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryCrudRepositoory.findById(id);
    }

    public Category save(Category c){
        return categoryCrudRepositoory.save(c);
    }
    public void delete(Category c){
        categoryCrudRepositoory.delete(c);
    }


}

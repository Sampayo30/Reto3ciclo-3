package com.retoo.reto3.repository;

import com.retoo.reto3.entidades.Category;
import com.retoo.reto3.entidades.Library;
import com.retoo.reto3.repository.crudRepository.LibraryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LibraryRepository {

    @Autowired
    private LibraryCrudRepository libraryCrudRepositoory;
    public List<Library> getAll(){
        return (List<Library>) libraryCrudRepositoory.findAll();
    }

    public Optional<Library> getLibrary(int id){
        return libraryCrudRepositoory.findById(id);
    }

    public Library save(Library c){
        return libraryCrudRepositoory.save(c);
    }
    public void delete(Library c){
        libraryCrudRepositoory.delete(c);
    }


}

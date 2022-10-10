package com.retoo.reto3.service;

import com.retoo.reto3.entidades.Category;
import com.retoo.reto3.entidades.Library;
import com.retoo.reto3.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class LibreryService {
    @Autowired
    private LibraryRepository LibraryRepository;

    public List<Library> getALL(){
        return LibraryRepository.getAll();
    }
    public Optional<Library> getProducto(int id){
        return LibraryRepository.getLibrary(id);
    }

    public Library save(Library p){
        if(p.getId()==null){
            return LibraryRepository.save(p);
        }else {
            Optional<Library> e = LibraryRepository.getLibrary(p.getId());
            if(e.isPresent()){
                return p;
            }else {
                return LibraryRepository.save(p);
            }
        }
    }

    public Library update(Library p){
        if(p.getId()!=null){
            Optional<Library> q = LibraryRepository.getLibrary(p.getId());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                if(p.getTarget()!=null){
                    q.get().setTarget(p.getTarget());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }
                LibraryRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Library>p= LibraryRepository.getLibrary(id);
        if(p.isPresent()){
            LibraryRepository.delete(p.get());
            flag=true;
        }

        return flag;

    }

}

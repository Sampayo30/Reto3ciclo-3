package com.retoo.reto3.repository;

import com.retoo.reto3.entidades.Client;
import com.retoo.reto3.entidades.Producto;
import com.retoo.reto3.repository.crudRepository.ClientCrudRepositoory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepositoory clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    public  Client save(Client p){
        return clientCrudRepository.save(p);
    }
    public void delete(Client p){
        clientCrudRepository.delete(p);
    }

}

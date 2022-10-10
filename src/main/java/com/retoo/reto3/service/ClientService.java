package com.retoo.reto3.service;

import com.retoo.reto3.entidades.Category;
import com.retoo.reto3.entidades.Client;
import com.retoo.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getALL(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client p){
        if(p.getIdClient()==null){
            return clientRepository.save(p);
        }else {
            Optional<Client> e = clientRepository.getClient(p.getIdClient());
            if(e.isPresent()){
                return p;
            }else {
                return clientRepository.save(p);
            }
        }
    }

    public Client update(Client p){
        if(p.getIdClient()!=null){
            Optional<Client> q = clientRepository.getClient(p.getIdClient());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                clientRepository.save(q.get());
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
        Optional<Client>p= clientRepository.getClient(id);
        if(p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }

        return flag;

    }

}

package com.anatolii.webShopApp.service;

import com.anatolii.webShopApp.model.Client;
import com.anatolii.webShopApp.repository.ClientJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {

    private final ClientJPARepository clientJPARepository;
    
    @Autowired
    public ClientService(ClientJPARepository clientJPARepository) {
        this.clientJPARepository = clientJPARepository;
    }

    public Client findById(int id) {
        return clientJPARepository.getOne(id);
    }

    public List<Client> findAll(){
        return clientJPARepository.findAll();
    }

    public Client saveClient(Client newClient){
        return clientJPARepository.save(newClient);
    }


    public void deleteClient(int id){
        clientJPARepository.deleteById(id);
    }
}

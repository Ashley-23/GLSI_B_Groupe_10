package com.example.projet_mysql.Service;

import com.example.projet_mysql.Model.Client;
import com.example.projet_mysql.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public void saveClient(Client client){
        //Fait l'ajout des rôles
        clientRepository.save(client);
    }

    public void deleteClient(int id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()){
            clientRepository.deleteById(clientOptional.get().getId());
        }
        else throw new RuntimeException("La suprresion de ce client est impossible");
    }

    public List<Client> allClient(){return clientRepository.findAll();}

    public Client oneClient(int id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent()){
            return clientOptional.get();
        }
        else
        throw new RuntimeException("L'identifiant ne correspond à aucun client");
    }
}

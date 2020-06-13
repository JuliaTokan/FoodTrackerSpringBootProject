package ua.external.spring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.external.spring.dto.ClientDTO;
import ua.external.spring.entity.Client;
import ua.external.spring.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client createClient(ClientDTO client){
        Client saveClient = clientRepository.saveAndFlush(Client.fromDTO(client));
        return saveClient;
    }

    public boolean updateClient(ClientDTO client){
        clientRepository.save(Client.fromDTO(client));
        return true;
    }

    public Optional<Client> findClientById(Long id){
        return clientRepository.findById(id);
    }

    public Optional<Client> findClientByName(String name){
        return clientRepository.findByName(name);
    }
}

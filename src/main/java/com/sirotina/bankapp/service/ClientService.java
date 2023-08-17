package com.sirotina.bankapp.service;

import com.sirotina.bankapp.entity.Client;
import com.sirotina.bankapp.entity.enums.ClientStatus;
import com.sirotina.bankapp.service.exception.ClientExistException;
import com.sirotina.bankapp.service.exception.ClientNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    List<Client> getAllClientsByStatus(ClientStatus status) throws ClientNotFoundException;

    Client getClientById(UUID id) throws ClientNotFoundException;

    List<Client> getAllClients();

    Client addNewClient(Client clientDto) throws ClientExistException;


    void deleteClientById(UUID id);

}

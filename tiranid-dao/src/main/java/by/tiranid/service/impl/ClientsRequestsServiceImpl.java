package by.apertura.service.impl;

import by.apertura.dao.ClientsRequestsRepository;
import by.apertura.model.ClientsRequestsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.apertura.service.ClientsRequestsService;

import java.sql.Timestamp;
import java.util.List;


@Service
public class ClientsRequestsServiceImpl implements ClientsRequestsService {

    private ClientsRequestsRepository clientsRequestsRepository;

    @Autowired
    public ClientsRequestsServiceImpl(ClientsRequestsRepository clientsRequestsRepository) {
        this.clientsRequestsRepository = clientsRequestsRepository;
    }


    
    public ClientsRequestsEntity addRequest(ClientsRequestsEntity request) {
        return clientsRequestsRepository.save(request);
    }

    
    public void delete(long id) {
        clientsRequestsRepository.delete(id);
    }

    
    public ClientsRequestsEntity editRequest(ClientsRequestsEntity request) {
        // hibernate will update it
        return clientsRequestsRepository.save(request);
    }


    public List<ClientsRequestsEntity> getAll() {
        return clientsRequestsRepository.findAll();
    }

    
    public ClientsRequestsEntity getFirstById(long id) {
        return clientsRequestsRepository.findFirstById(id);
    }

    
    public ClientsRequestsEntity getFirstByLogin(String login) {
        return clientsRequestsRepository.findFirstByLogin(login);
    }

    
    public ClientsRequestsEntity getFirstByReqNumber(long reqNumber) {
        return clientsRequestsRepository.findFirstByReqNumber(reqNumber);
    }

    
    public ClientsRequestsEntity getFirstByMessage(String message) {
        return clientsRequestsRepository.findFirstByMessage(message);
    }


    
    public ClientsRequestsEntity getFirstByDate(Timestamp date) {
        return clientsRequestsRepository.findFirstByDate(date);
    }



    
    public List<ClientsRequestsEntity> getByLogin(String login) {
        return clientsRequestsRepository.findByLogin(login);
    }

    
    public List<ClientsRequestsEntity> getByReqNumber(long reqNumber) {
        return  clientsRequestsRepository.findByReqNumber(reqNumber);
    }

    
    public List<ClientsRequestsEntity> getByMessage(String message) {
        return  clientsRequestsRepository.findByMessage(message);
    }

    
    public List<ClientsRequestsEntity> getByDate(Timestamp date) {
        return  clientsRequestsRepository.findByDate(date);
    }

    


    public ClientsRequestsEntity getFirst() {
        return clientsRequestsRepository.findAll().get(0);
    }

    
    public ClientsRequestsEntity getLast() {
        List<ClientsRequestsEntity> list = clientsRequestsRepository.findAll();
        return list.get(list.size()-1);
    }

}

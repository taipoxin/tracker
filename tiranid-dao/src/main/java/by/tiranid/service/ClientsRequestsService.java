package by.apertura.service;


import by.apertura.model.ClientsRequestsEntity;

import java.sql.Timestamp;
import java.util.List;


public interface ClientsRequestsService {
    ClientsRequestsEntity addRequest(ClientsRequestsEntity req);
    void delete(long id);
    ClientsRequestsEntity editRequest(ClientsRequestsEntity req);
    List<ClientsRequestsEntity> getAll();

    ClientsRequestsEntity getFirstById(long id);
    ClientsRequestsEntity getFirstByLogin(String login);
    ClientsRequestsEntity getFirstByReqNumber(long reqNumber);
    ClientsRequestsEntity getFirstByMessage(String message);
    ClientsRequestsEntity getFirstByDate(Timestamp date);


    List<ClientsRequestsEntity> getByLogin(String login);
    List<ClientsRequestsEntity> getByReqNumber(long reqNumber);
    List<ClientsRequestsEntity> getByMessage(String message);
    List<ClientsRequestsEntity> getByDate(Timestamp date);

    ClientsRequestsEntity getLast();
    ClientsRequestsEntity getFirst();

}

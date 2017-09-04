package by.tiranid.dao;

import by.tiranid.model.ClientsRequestsEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;


public interface ClientsRequestsRepository extends CrudRepository<ClientsRequestsEntity, Long> {


    ClientsRequestsEntity findFirstById(long id);
    ClientsRequestsEntity findFirstByLogin(String login);
    ClientsRequestsEntity findFirstByReqNumber(long reqNumber);
    ClientsRequestsEntity findFirstByMessage(String message);
    ClientsRequestsEntity findFirstByDate(Timestamp date);



    List<ClientsRequestsEntity> findByLogin(String login);
    List<ClientsRequestsEntity> findByReqNumber(long reqNumber);
    List<ClientsRequestsEntity> findByMessage(String message);
    List<ClientsRequestsEntity> findByDate(Timestamp date);
    List<ClientsRequestsEntity> findAll();


}

package by.apertura.dao;

import by.apertura.model.MasterResponsesEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;


public interface MasterResponsesRepository extends CrudRepository<MasterResponsesEntity, Long> {

    MasterResponsesEntity findFirstById(long id);
    MasterResponsesEntity findFirstByLogin(String login);
    MasterResponsesEntity findFirstByReqNumber(long reqNumber);
    MasterResponsesEntity findFirstByMessage(String message);
    MasterResponsesEntity findFirstByDate(Timestamp date);


    List<MasterResponsesEntity> findByLogin(String login);
    List<MasterResponsesEntity> findByReqNumber(long reqNumber);
    List<MasterResponsesEntity> findByMessage(String message);
    List<MasterResponsesEntity> findByDate(Timestamp date);
    List<MasterResponsesEntity> findAll();
}


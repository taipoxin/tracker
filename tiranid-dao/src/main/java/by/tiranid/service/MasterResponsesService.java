package by.apertura.service;

import by.apertura.model.MasterResponsesEntity;

import java.sql.Timestamp;
import java.util.List;


public interface MasterResponsesService {
    MasterResponsesEntity addResponse(MasterResponsesEntity resp);
    void delete(Long id);
    MasterResponsesEntity editResponse(MasterResponsesEntity resp);
    List<MasterResponsesEntity> getAll();

    MasterResponsesEntity getFirstById(Long id);
    MasterResponsesEntity getFirstByLogin(String login);
    MasterResponsesEntity getFirstByReqNumber(Long reqNumber);
    MasterResponsesEntity getFirstByMessage(String message);
    MasterResponsesEntity getFirstByDate(Timestamp date);


    List<MasterResponsesEntity> getByLogin(String login);
    List<MasterResponsesEntity> getByReqNumber(Long reqNumber);
    List<MasterResponsesEntity> getByMessage(String message);
    List<MasterResponsesEntity> getByDate(Timestamp date);

    MasterResponsesEntity getLast();
    MasterResponsesEntity getFirst();
}

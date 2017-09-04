package by.apertura.service.impl;

import by.apertura.dao.MasterResponsesRepository;
import by.apertura.model.MasterResponsesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.apertura.service.MasterResponsesService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MasterResponsesServiceImpl implements MasterResponsesService {

    private MasterResponsesRepository masterResponsesRepository;

    @Autowired
    public MasterResponsesServiceImpl(MasterResponsesRepository masterResponsesRepository) {
        this.masterResponsesRepository = masterResponsesRepository;
    }

    
    public MasterResponsesEntity addResponse(MasterResponsesEntity response) {
        return masterResponsesRepository.save(response);
    }

    
    public void delete(Long id) {
        masterResponsesRepository.delete(id);
    }

    
    public MasterResponsesEntity editResponse(MasterResponsesEntity response) {
        // hibernate will update it
        return masterResponsesRepository.save(response);
    }


    
    public MasterResponsesEntity getFirstById(Long id) {
        return masterResponsesRepository.findFirstById(id);
    }

    
    public MasterResponsesEntity getFirstByLogin(String login) {
        return masterResponsesRepository.findFirstByLogin(login);
    }

    
    public MasterResponsesEntity getFirstByReqNumber(Long reqNumber) {
        return masterResponsesRepository.findFirstByReqNumber(reqNumber);
    }

    
    public MasterResponsesEntity getFirstByMessage(String message) {
        return masterResponsesRepository.findFirstByMessage(message);
    }


    
    public MasterResponsesEntity getFirstByDate(Timestamp date) {
        return masterResponsesRepository.findFirstByDate(date);
    }

    

    
    public List<MasterResponsesEntity> getByLogin(String login) {
        return masterResponsesRepository.findByLogin(login);
    }

    
    public List<MasterResponsesEntity> getByReqNumber(Long reqNumber) {
        return masterResponsesRepository.findByReqNumber(reqNumber);
    }

    
    public List<MasterResponsesEntity> getByMessage(String message) {
        return masterResponsesRepository.findByMessage(message);
    }

    
    public List<MasterResponsesEntity> getByDate(Timestamp date) {
        return masterResponsesRepository.findByDate(date);
    }

    
    public List<MasterResponsesEntity> getAll() {
        return masterResponsesRepository.findAll();
    }



    public MasterResponsesEntity getFirst() {
        return masterResponsesRepository.findAll().get(0);
    }


    public MasterResponsesEntity getLast() {
        List<MasterResponsesEntity> list = masterResponsesRepository.findAll();
        return list.get(list.size()-1);
    }
}

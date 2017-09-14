package by.tiranid.service.impl;

import by.tiranid.dao.WorkItersRepository;
import by.tiranid.model.WorkItersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.tiranid.service.WorkItersService;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;


@Service
public class WorkItersServiceImpl implements WorkItersService {

    private WorkItersRepository WorkItersRepository;

    @Autowired
    public WorkItersServiceImpl(WorkItersRepository WorkItersRepository) {
        this.WorkItersRepository = WorkItersRepository;
    }

    
	// поиск по ddate в промежутке от до и просто от и просто до

    
    public WorkItersEntity addRecord(WorkItersEntity record) {
        return WorkItersRepository.save(record);
    }

    
    public void delete(Long id) {
        WorkItersRepository.delete(id);
    }

    
    public WorkItersEntity editRecord(WorkItersEntity record) {
        // hibernate will update it
        return WorkItersRepository.save(record);
    }


    public List<WorkItersEntity> getAll() {
        return WorkItersRepository.findAll();
    }

    
    public WorkItersEntity getFirstById(Long id) {
        return WorkItersRepository.findFirstById(id);
    }

    
    public WorkItersEntity getFirstByDdate(Date ddate) {
        return WorkItersRepository.findFirstByDdate(ddate);
    }

    
    public WorkItersEntity getFirstByTtime(Time ttime) {
        return WorkItersRepository.findFirstByTtime(ttime);
    }



    
    public List<WorkItersEntity> getByDdate(Date ddate) {
        return WorkItersRepository.findByDdate(ddate);
    }
    


    public WorkItersEntity getFirst() {
        return WorkItersRepository.findAll().get(0);
    }

    
    public WorkItersEntity getLast() {
        List<WorkItersEntity> list = WorkItersRepository.findAll();
        return list.get(list.size()-1);
    }

}
package by.tiranid.service;


import by.tiranid.model.WorkItersEntity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;


public interface WorkItersService {
	
	WorkItersEntity addRecord(WorkItersEntity record);
    void delete(Long id);
    WorkItersEntity editRecord(WorkItersEntity record);
    List<WorkItersEntity> getAll();
	
	

    WorkItersEntity getFirstById(Long id);
    WorkItersEntity getFirstByDdate(Date ddate);
    WorkItersEntity getFirstByTtime(Time ttime);



    List<WorkItersEntity> getByDdate(Date ddate);

	
    WorkItersEntity getLast();
    WorkItersEntity getFirst();
    
	// поиск по ddate в промежутке от до и просто от и просто до

}

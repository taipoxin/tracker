package by.tiranid.dao;

import by.tiranid.model.WorkItersEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;


public interface WorkItersRepository extends CrudRepository<WorkItersEntity, Long> {


	


    WorkItersEntity findFirstById(Long id);
    WorkItersEntity findFirstByDdate(Date ddate);
    WorkItersEntity findFirstByTtime(Time ttime);



    List<WorkItersEntity> findByDdate(Date ddate);
    
	// поиск по ddate в промежутке от до и просто от и просто до
	
	
	
    List<WorkItersEntity> findAll();


}
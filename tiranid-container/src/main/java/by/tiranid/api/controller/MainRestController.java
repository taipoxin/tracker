package by.tiranid.api.controller;

import by.tiranid.config.HttpLoggingFilter;
import by.tiranid.dao.WorkDaysRepository;
import by.tiranid.dao.WorkItersRepository;
import by.tiranid.model.WorkItersEntity;
import by.tiranid.service.WorkDaysService;
import by.tiranid.service.WorkItersService;
import by.tiranid.service.impl.WorkItersServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;


@RestController
public class MainRestController {

    private static final Logger log = LoggerFactory.getLogger(HttpLoggingFilter.class);
    private static int userHash = -442696469;
    @Autowired
    private WorkDaysRepository workDaysRepository;
    private WorkDaysService workDaysService;
    @Autowired
    private WorkItersRepository workItersRepository;
    private WorkItersService workItersService;

    @RequestMapping(value = {"/postIter"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity.BodyBuilder postIter(@RequestParam String hash, @RequestParam String time) {
        log.info("retrieved hash: " + hash);
        log.info("retrieved time: " + time);
        if (Integer.valueOf(hash) == -442696469) {
            userHash = Integer.valueOf(hash);
            if (workItersService == null) {
                workItersService = new WorkItersServiceImpl(workItersRepository);
            }
            long t = Long.valueOf(time);
            WorkItersEntity entity = new WorkItersEntity();
            entity.setDdate(new Date(t));
            entity.setTtime(new Time(t));
            log.info("adding new entity: ");
            log.info(entity.getDdate().toString());
            log.info(entity.getTtime().toString());
            workItersService.addRecord(entity);
            return ResponseEntity.ok();
        } else {
            log.warn("sorry");
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = {"/postIter"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity.BodyBuilder getToPostIter() {
        log.info("get request to postIter");
        log.info("Returning OK Http Code");
        return ResponseEntity.ok();
    }


}
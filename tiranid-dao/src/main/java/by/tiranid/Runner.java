package by.tiranid;

import by.tiranid.dao.WorkDaysRepository;
import by.tiranid.model.EntityUtils;
import by.tiranid.model.WorkDaysEntity;
import by.tiranid.service.WorkDaysService;
import by.tiranid.service.impl.WorkDaysServiceImpl;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class Runner implements CommandLineRunner {

    private static final String recordSampleWorkDate     = "2007-09-02";
    private static final Byte   recordSampleIterations   = 7;
    private static final String recordSampleWorkTime     = "9:13;16:18;";

    private static final String recordSampleDdate        = "2007-09-02";
    private static final String recordSampleTtime        = "04:20:00";

    @Autowired
    private WorkDaysRepository workDaysRepository;

    private WorkDaysService workDaysService;


    private void initService() {
        workDaysService = new WorkDaysServiceImpl(workDaysRepository);
    }


    /**
     * Main application thread
     * @param args default args
     */
    public void run(String... args) {
        initService();


        WorkDaysEntity entity = workDaysService.addRecord(
                EntityUtils.createTestWorkDaysEntity(recordSampleWorkDate, (byte) 5, recordSampleWorkTime));

        WorkDaysEntity entity1 = workDaysService.getFirst();
        Assert.assertEquals(entity1, entity);


    }

}
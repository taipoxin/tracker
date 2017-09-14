package by.tiranid.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import by.tiranid.config.TestDataBaseConfig;
import by.tiranid.dao.WorkItersRepository;
import by.tiranid.model.WorkItersEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import by.tiranid.service.impl.WorkItersServiceImpl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class, loader = AnnotationConfigContextLoader.class)
@DatabaseTearDown(value = "/data/work_iters/dbTearDown.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })

public class WorkItersServiceTest {

    // see data.record.sampleTestData
    private static final Long recordSampleId = 1L;
    private static final String recordSampleDdate = "2007-09-02";
    private static final String recordSampleTtime = "04:20:00";


    @Autowired
    private WorkItersRepository workItersRepository;

    private WorkItersService workItersService;

    @Before
    public void setUp() throws Exception {
        workItersService = new WorkItersServiceImpl(workItersRepository);
    }


    public WorkItersEntity createTestWorkItersEntity() throws Exception {
        WorkItersEntity record = new WorkItersEntity();
        record.setDdate(Date.valueOf(recordSampleDdate));
        record.setTtime(Time.valueOf(recordSampleTtime));
        return record;
    }


    @Test
    public void testAddRecord() throws Exception {
        WorkItersEntity record = createTestWorkItersEntity();
        workItersService.addRecord(record);
        WorkItersEntity record2 = workItersService.getFirst();
        Assert.assertEquals(record, record2);
    }


    @Test
    public void testEditRecord() throws Exception {
        WorkItersEntity record = createTestWorkItersEntity();
        record.setDdate(Date.valueOf("1488-08-14"));
        record = workItersService.addRecord(record);
        Date dt = Date.valueOf("1488-08-01");
        record.setDdate(dt);
        // with addRecord the same editing
        workItersService.editRecord(record);
        Assert.assertEquals(dt, workItersService.getFirst().getDdate());
    }


    @Test
    @DatabaseSetup("/data/work_iters/sampleTestData.xml")
    public void testGetFirstById() throws Exception {
        WorkItersEntity entity = workItersService.getFirstById(recordSampleId);
        Assert.assertEquals(recordSampleId, entity.getId());
    }


    @Test
    @DatabaseSetup("/data/work_iters/sampleTestData.xml")
    public void testGetFirstByDdate() throws Exception {
        Date dt = Date.valueOf(recordSampleDdate);
        WorkItersEntity entity = workItersService.getFirstByDdate(dt);
        Assert.assertEquals(dt, entity.getDdate());
    }


    @Test
    @DatabaseSetup("/data/work_iters/sampleTestData.xml")
    public void testGetFirstByTtime() throws Exception {
        Time t = Time.valueOf(recordSampleTtime);
        WorkItersEntity entity = workItersService.getFirstByTtime(t);
        Assert.assertEquals(t, entity.getTtime());
    }


    @Test
    @DatabaseSetup("/data/work_iters/sampleTestData.xml")
    public void testGetLast() throws Exception {
        WorkItersEntity record1 = createTestWorkItersEntity();
        workItersService.addRecord(record1);
        WorkItersEntity record = workItersService.getLast();
        Assert.assertEquals(record1, record);
    }

    @Test
    @DatabaseSetup("/data/work_iters/sampleTestData.xml")
    public void testGetFirst() throws Exception {
        workItersService.addRecord(createTestWorkItersEntity());
        WorkItersEntity record = workItersService.getFirst();
        Assert.assertEquals(recordSampleId, record.getId());
    }

    @Test
    @DatabaseSetup("/data/work_iters/sampleTestData.xml")
    public void testDelete() throws Exception {
        workItersService.delete(recordSampleId);
        WorkItersEntity record2 = workItersService.getFirstById(recordSampleId);
        Assert.assertNull(record2);
    }

    @Test
    @DatabaseSetup("/data/work_iters/sampleTestData.xml")
    public void testGetByDdate() throws Exception {
        workItersService.addRecord(createTestWorkItersEntity());
        List<WorkItersEntity> list = workItersService.getByDdate(Date.valueOf(recordSampleDdate));
        Assert.assertEquals(2, list.size());
    }
}

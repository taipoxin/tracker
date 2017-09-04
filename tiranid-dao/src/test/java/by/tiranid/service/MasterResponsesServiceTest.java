package by.tiranid.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import by.tiranid.config.TestDataBaseConfig;
import by.tiranid.dao.MasterResponsesRepository;
import by.tiranid.model.MasterResponsesEntity;
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
import by.tiranid.service.impl.MasterResponsesServiceImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class, loader = AnnotationConfigContextLoader.class)
@DatabaseTearDown(value = "/data/master/dbTearDown.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class MasterResponsesServiceTest {


    private static final Long   masterSampleId          = 1L;
    private static final String masterSampleLogin       = "test_user";
    private static final Long   masterSampleReqNumber   = 54879682L;
    private static final String masterSampleMessage     = "sample_message";
    private static final String masterSampleDate        = "2007-09-02 04:20:00";

    @Autowired
    private MasterResponsesRepository masterResponsesRepository;

    private MasterResponsesService masterResponsesService;

    @Before
    public void setUp() throws Exception {
        masterResponsesService = new MasterResponsesServiceImpl(masterResponsesRepository);
    }



    public MasterResponsesEntity createTestMasterResponsesEntity() throws Exception {
        MasterResponsesEntity master = new MasterResponsesEntity();
        master.setLogin(masterSampleLogin);
        master.setReqNumber(masterSampleReqNumber);
        master.setMessage(masterSampleMessage);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp timestamp = new Timestamp(dateFormat.parse(masterSampleDate).getTime());
        master.setDate(timestamp);
        return master;
    }




    @Test
    public void testAddResponse() throws Exception {
        MasterResponsesEntity master = createTestMasterResponsesEntity();
        masterResponsesService.addResponse(master);
        MasterResponsesEntity master1 = masterResponsesService.getFirst();
        Assert.assertEquals(master, master1);
    }


    @Test
    public void testEditResponse() throws Exception {
        MasterResponsesEntity client = createTestMasterResponsesEntity();
        client.setLogin("bad_login");
        client = masterResponsesService.addResponse(client);
        client.setLogin("good_login");
        // with addResponse the same editing
        masterResponsesService.editResponse(client);
        Assert.assertEquals(masterResponsesService.getFirst().getLogin(), "good_login");

    }



    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testGetFirstById() throws Exception {
        MasterResponsesEntity entity = masterResponsesService.getFirstById(masterSampleId);
        Assert.assertEquals(entity.getId(), masterSampleId);
    }



    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testGetFirstByLogin() throws Exception {
        MasterResponsesEntity entity = masterResponsesService.getFirstByLogin(masterSampleLogin);
        Assert.assertEquals(entity.getLogin(), masterSampleLogin);
    }





    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testGetFirstByReqNumber() throws Exception {
        MasterResponsesEntity entity = masterResponsesService.getFirstByReqNumber(masterSampleReqNumber);
        Assert.assertEquals(entity.getReqNumber(), masterSampleReqNumber);
    }


    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testGetFirstByMessage() throws Exception {
        MasterResponsesEntity entity = masterResponsesService.getFirstByMessage(masterSampleMessage);
        Assert.assertEquals(entity.getMessage(), masterSampleMessage);
    }


    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testGetFirstByDate() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp timestamp = new Timestamp(dateFormat.parse(masterSampleDate).getTime());
        MasterResponsesEntity entity = masterResponsesService.getFirstByDate(timestamp);
        Assert.assertEquals(entity.getDate(), timestamp);
    }




    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testGetLast() throws Exception {
        MasterResponsesEntity  client1 = createTestMasterResponsesEntity();
        masterResponsesService.addResponse(client1);
        MasterResponsesEntity client = masterResponsesService.getLast();
        Assert.assertEquals(client1, client);
    }

    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testGetFirst() throws Exception {
        masterResponsesService.addResponse(createTestMasterResponsesEntity());
        MasterResponsesEntity client = masterResponsesService.getFirst();
        Assert.assertEquals(client.getId(), masterSampleId);
    }

    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testDelete() throws Exception {
        masterResponsesService.delete(masterSampleId);
        MasterResponsesEntity client2 = masterResponsesService.getFirstById(masterSampleId);
        Assert.assertNull(client2);
    }




    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testGetByLogin() throws Exception {
        masterResponsesService.addResponse(createTestMasterResponsesEntity());
        List<MasterResponsesEntity> list = masterResponsesService.getByLogin(masterSampleLogin);
        Assert.assertEquals(list.size(), 2);
    }

    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testGetByReqNumber() throws Exception {
        masterResponsesService.addResponse(createTestMasterResponsesEntity());
        List<MasterResponsesEntity> list = masterResponsesService.getByReqNumber(masterSampleReqNumber);
        Assert.assertEquals(list.size(), 2);
    }

    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testGetByMessage() throws Exception {
        masterResponsesService.addResponse(createTestMasterResponsesEntity());
        List<MasterResponsesEntity> list = masterResponsesService.getByMessage(masterSampleMessage);
        Assert.assertEquals(list.size(), 2);
    }

    @Test
    @DatabaseSetup("/data/master/sampleTestData.xml")
    public void testGetByDate() throws Exception {
        masterResponsesService.addResponse(createTestMasterResponsesEntity());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp timestamp = new Timestamp(dateFormat.parse(masterSampleDate).getTime());
        List<MasterResponsesEntity> list = masterResponsesService.getByDate(timestamp);
        Assert.assertEquals(list.size(), 2);
    }



}


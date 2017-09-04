package by.apertura.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import by.apertura.config.TestDataBaseConfig;
import by.apertura.dao.ClientsRequestsRepository;
import by.apertura.model.ClientsRequestsEntity;
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
import by.apertura.service.impl.ClientsRequestsServiceImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class, loader = AnnotationConfigContextLoader.class)
@DatabaseTearDown(value = "/data/client/dbTearDown.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })

public class ClientsRequestsServiceTest {

    // see data.client.sampleTestData
    private static final Long   clientSampleId          = 1L;
    private static final String clientSampleLogin       = "test_user";
    private static final Long   clientSampleReqNumber   = 54879682L;
    private static final String clientSampleMessage     = "sample_message";
    private static final String clientSampleDate        = "2007-09-02 04:20:00";





    @Autowired
    private ClientsRequestsRepository clientsRequestsRepository;

    private ClientsRequestsService clientsRequestsService;

    @Before
    public void setUp() throws Exception {
        clientsRequestsService = new ClientsRequestsServiceImpl(clientsRequestsRepository);
    }



    public ClientsRequestsEntity createTestClientsRequestsEntity() throws Exception {
        ClientsRequestsEntity client = new ClientsRequestsEntity();
        client.setLogin(clientSampleLogin);
        client.setReqNumber(clientSampleReqNumber);
        client.setMessage(clientSampleMessage);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp timestamp = new Timestamp(dateFormat.parse(clientSampleDate).getTime());
        client.setDate(timestamp);
        return client;
    }





    @Test
    public void testAddRequest() throws Exception {
        ClientsRequestsEntity client = createTestClientsRequestsEntity();
        clientsRequestsService.addRequest(client);
        ClientsRequestsEntity client2 = clientsRequestsService.getFirst();
        Assert.assertEquals(client, client2);
    }


    @Test
    public void testEditRequest() throws Exception {
        ClientsRequestsEntity client = createTestClientsRequestsEntity();
        client.setLogin("bad_login");
        client = clientsRequestsService.addRequest(client);
        client.setLogin("good_login");
        // with addRequest the same editing
        clientsRequestsService.editRequest(client);
        Assert.assertEquals(clientsRequestsService.getFirst().getLogin(), "good_login");
    }



    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testGetFirstById() throws Exception {
        ClientsRequestsEntity entity = clientsRequestsService.getFirstById(clientSampleId);
        Assert.assertEquals(entity.getId(), clientSampleId);
    }



    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testGetFirstByLogin() throws Exception {
        ClientsRequestsEntity entity = clientsRequestsService.getFirstByLogin(clientSampleLogin);
        Assert.assertEquals(entity.getLogin(), clientSampleLogin);
    }





    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testGetFirstByReqNumber() throws Exception {
        ClientsRequestsEntity entity = clientsRequestsService.getFirstByReqNumber(clientSampleReqNumber);
        Assert.assertEquals(entity.getReqNumber(), clientSampleReqNumber);
    }


    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testGetFirstByMessage() throws Exception {
        ClientsRequestsEntity entity = clientsRequestsService.getFirstByMessage(clientSampleMessage);
        Assert.assertEquals(entity.getMessage(), clientSampleMessage);
    }


    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testGetFirstByDate() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp timestamp = new Timestamp(dateFormat.parse(clientSampleDate).getTime());
        ClientsRequestsEntity entity = clientsRequestsService.getFirstByDate(timestamp);
        Assert.assertEquals(entity.getDate(), timestamp);
    }




    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testGetLast() throws Exception {
        ClientsRequestsEntity  client1 = createTestClientsRequestsEntity();
        clientsRequestsService.addRequest(client1);
        ClientsRequestsEntity client = clientsRequestsService.getLast();
        Assert.assertEquals(client1, client);
    }

    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testGetFirst() throws Exception {
        clientsRequestsService.addRequest(createTestClientsRequestsEntity());
        ClientsRequestsEntity client = clientsRequestsService.getFirst();
        Assert.assertEquals(client.getId(), clientSampleId);
    }

    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testDelete() throws Exception {
        clientsRequestsService.delete(clientSampleId);
        ClientsRequestsEntity client2 = clientsRequestsService.getFirstById(clientSampleId);
        Assert.assertNull(client2);
    }




    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testGetByLogin() throws Exception {
        clientsRequestsService.addRequest(createTestClientsRequestsEntity());
        List<ClientsRequestsEntity> list = clientsRequestsService.getByLogin(clientSampleLogin);
        Assert.assertEquals(list.size(), 2);
    }

    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testGetByReqNumber() throws Exception {
        clientsRequestsService.addRequest(createTestClientsRequestsEntity());
        List<ClientsRequestsEntity> list = clientsRequestsService.getByReqNumber(clientSampleReqNumber);
        Assert.assertEquals(list.size(), 2);
    }

    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testGetByMessage() throws Exception {
        clientsRequestsService.addRequest(createTestClientsRequestsEntity());
        List<ClientsRequestsEntity> list = clientsRequestsService.getByMessage(clientSampleMessage);
        Assert.assertEquals(list.size(), 2);
    }

    @Test
    @DatabaseSetup("/data/client/sampleTestData.xml")
    public void testGetByDate() throws Exception {
        clientsRequestsService.addRequest(createTestClientsRequestsEntity());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Timestamp timestamp = new Timestamp(dateFormat.parse(clientSampleDate).getTime());
        List<ClientsRequestsEntity> list = clientsRequestsService.getByDate(timestamp);
        Assert.assertEquals(list.size(), 2);
    }


}

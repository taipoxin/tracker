package by.apertura.api.util;

import by.apertura.api.model.JobStatus;
import by.apertura.api.model.Location;
import by.apertura.api.model.MasterRequestType;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class ActiveMasterPoolTest {
    private static final Long MASTER_ID = 105L;
    private static final JobStatus MASTER_JOB_STATUS = JobStatus.FREE;
    private static final String MASTER_NAME = "Victor";
    private static final Location LOCATION = new Location();
    private ActiveMasterPool pool;

    @Before
    public void setUp(){
        LOCATION.setX(104L);
        LOCATION.setY(106L);
        pool = ActiveMasterPool.getInstance();
        pool.putActiveMaster(initJaxbObject());
    }

    @Test
    public void putActiveMaster() throws Exception {
        MasterRequestType activeMaster = pool.getActiveMaster(MASTER_ID);
        Assert.assertNotNull(activeMaster);
        Assert.assertThat("Invalid master id", activeMaster.getMasterId(), is(MASTER_ID));
        Assert.assertThat("Invalid master name", activeMaster.getMasterName(), is(MASTER_NAME));
        Assert.assertThat("Invalid master job status", activeMaster.getCurrentStatus(), is(MASTER_JOB_STATUS));
        Assert.assertThat("Invalid master location", activeMaster.getLocation(), is(LOCATION));
    }

    @Test
    public void getMasterLocation() throws Exception {
        Location masterLocation = pool.getMasterLocation(MASTER_ID);
        Assert.assertThat("Invalid master location", masterLocation, is(LOCATION));
    }

    @Test
    public void updateMasterLocation() throws Exception {
        pool.updateMasterLocation(MASTER_ID, 100L, 101L);
        Location masterLocation = pool.getMasterLocation(MASTER_ID);
        Assert.assertThat("Invalid x", masterLocation.getX(), is(100L));
        Assert.assertThat("Invalid y", masterLocation.getY(), is(101L));
    }

    @Test(expected = RuntimeException.class)
    public void removeActiveMaster() throws Exception {
        pool.removeActiveMaster(MASTER_ID);
        MasterRequestType activeMaster = pool.getActiveMaster(MASTER_ID);
    }

    private MasterRequestType initJaxbObject(){
        MasterRequestType masterRequestType = new MasterRequestType();
        masterRequestType.setMasterId(MASTER_ID);
        masterRequestType.setCurrentStatus(MASTER_JOB_STATUS);
        masterRequestType.setMasterName(MASTER_NAME);
        masterRequestType.setLocation(LOCATION);
        return masterRequestType;
    }
}
package by.tiranid.api.util;
/*
import by.apertura.api.model.Location;
import by.apertura.api.model.MasterRequestType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/*
@Component
*/
public class ActiveMasterPool {}
/*
    private Map<String, MasterRequestType> pool;

    private ActiveMasterPool(){
        pool = new HashMap<>();
    }

    private static class Seed {
        public static final ActiveMasterPool INSTANCE = new ActiveMasterPool();
    }

    public static ActiveMasterPool getInstance(){
        return Seed.INSTANCE;
    }

    public boolean putActiveMaster(MasterRequestType masterRequestType){
        String masterKey = masterRequestType.getMasterId().toString();
        if (pool.containsKey(masterKey)) {
            return false;
        }
        pool.put(masterKey, masterRequestType);
        return true;
    }

    public MasterRequestType getActiveMaster(Long masterId){
        String masterKey = masterId.toString();
        if (pool.containsKey(masterKey)) {
            return pool.get(masterKey);
        }
        throw new RuntimeException("Can't find active master with id: " + masterId);
    }

    public Location getMasterLocation(Long masterId) {
        String masterKey = masterId.toString();
        if (pool.containsKey(masterKey)) {
            return pool.get(masterKey).getLocation();
        }
        throw new RuntimeException("Can't find active master with id: " + masterId);
    }

    public boolean updateMasterLocation(Long masterId, Long x, Long y) {
        String masterKey = masterId.toString();
        if (pool.containsKey(masterKey)) {
            MasterRequestType masterRequestType = pool.get(masterKey);
            Location location = masterRequestType.getLocation();
            location.setX(x);
            location.setY(y);
            return true;
        }
        return false;
    }

    public void removeActiveMaster(Long masterId){
        String masterKey = masterId.toString();
        pool.remove(masterKey);
    }
}
*/
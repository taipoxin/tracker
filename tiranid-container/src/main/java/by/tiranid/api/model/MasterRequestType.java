package by.tiranid.api.model;

/**
 * Created by Yayheniy_Lepkovich on 8/22/2017.
 */
public class MasterRequestType {
    public Long masterId;
    public String masterName;
    public JobStatus currentStatus;
    public Location location;

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public JobStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(JobStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MasterRequestType that = (MasterRequestType) o;

        if (masterId != null ? !masterId.equals(that.masterId) : that.masterId != null) return false;
        if (masterName != null ? !masterName.equals(that.masterName) : that.masterName != null) return false;
        if (currentStatus != that.currentStatus) return false;
        return location != null ? location.equals(that.location) : that.location == null;
    }

    @Override
    public int hashCode() {
        int result = masterId != null ? masterId.hashCode() : 0;
        result = 31 * result + (masterName != null ? masterName.hashCode() : 0);
        result = 31 * result + (currentStatus != null ? currentStatus.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}

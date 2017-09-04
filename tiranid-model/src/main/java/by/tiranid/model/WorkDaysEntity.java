package by.tiranid.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "work_days", schema = "test", catalog = "")
public class WorkDaysEntity {
    private int id;
    private Date workDate;
    private byte iterations;
    private String workTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "work_date", nullable = false)
    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    @Basic
    @Column(name = "iterations", nullable = false)
    public byte getIterations() {
        return iterations;
    }

    public void setIterations(byte iterations) {
        this.iterations = iterations;
    }

    @Basic
    @Column(name = "work_time", nullable = false, length = -1)
    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkDaysEntity that = (WorkDaysEntity) o;

        if (id != that.id) return false;
        if (iterations != that.iterations) return false;
        if (workDate != null ? !workDate.equals(that.workDate) : that.workDate != null) return false;
        if (workTime != null ? !workTime.equals(that.workTime) : that.workTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (workDate != null ? workDate.hashCode() : 0);
        result = 31 * result + (int) iterations;
        result = 31 * result + (workTime != null ? workTime.hashCode() : 0);
        return result;
    }
}

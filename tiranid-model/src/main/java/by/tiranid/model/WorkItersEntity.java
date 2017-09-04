package by.tiranid.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "work_iters", schema = "test", catalog = "")
public class WorkItersEntity {
    private int id;
    private Date ddate;
    private Time ttime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ddate", nullable = false)
    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    @Basic
    @Column(name = "ttime", nullable = false)
    public Time getTtime() {
        return ttime;
    }

    public void setTtime(Time ttime) {
        this.ttime = ttime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkItersEntity that = (WorkItersEntity) o;

        if (id != that.id) return false;
        if (ddate != null ? !ddate.equals(that.ddate) : that.ddate != null) return false;
        if (ttime != null ? !ttime.equals(that.ttime) : that.ttime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ddate != null ? ddate.hashCode() : 0);
        result = 31 * result + (ttime != null ? ttime.hashCode() : 0);
        return result;
    }
}

package by.tiranid.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "work_iters")
public class WorkItersEntity {
    private Long id;
    private Date ddate;
    private Time ttime;

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ddate != null ? !ddate.equals(that.ddate) : that.ddate != null) return false;
        if (ttime != null ? !ttime.equals(that.ttime) : that.ttime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (ddate != null ? ddate.hashCode() : 0);
        result = 31 * result + (ttime != null ? ttime.hashCode() : 0);
        return (int) result;
    }
	
	@Override
    public String toString() {
        return new StringBuilder()
                .append("id: " + this.id + "\n")
                .append("ddate: " + this.ddate + "\n")
                .append("ttime: " + this.ttime + "\n")
                .toString();
    }
}

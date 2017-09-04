package by.apertura.model;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "clients_requests")
public class ClientsRequestsEntity {
    private Long id;
    private String login;
    private Long reqNumber;
    private String message;
    private Timestamp date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "login", nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    @Column(name = "req_number", nullable = false)
    public Long getReqNumber() {
        return reqNumber;
    }

    public void setReqNumber(Long reqNumber) {
        this.reqNumber = reqNumber;
    }


    @Column(name = "message", nullable = false)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsRequestsEntity that = (ClientsRequestsEntity) o;

        if (!id.equals(that.id)) return false;
        if (!reqNumber.equals(that.reqNumber)) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + reqNumber;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return (int)result;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id: " + this.id + "\n")
                .append("login: " + this.login + "\n")
                .append("request number: " + this.reqNumber + "\n")
                .append("message: " + this.message + "\n")
                .append("date: " + this.date.toString() + "\n")
                .toString();
    }
}
package com.sbrtest.app1.domain;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "recivedmessages") // задаем имя таблицы

public class RecivedMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //стратегия автогенерация таблицы
    @Column(name = "id")
    private Integer ID; //уникальный идентификатор сообщения

    @Column(name = "name")
    private String Name; //Имя

    @Column(name = "second_name")
    private String SecondName; //Фамилия

    @Column(name = "body")
    private String Body; // текст сообщения

    @Column(name = "date")
    private Date Timestamp; //дата

    public RecivedMessage() {
    }

    //Getters and Setters
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public Date getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Date timestamp) {
        Timestamp = timestamp;
    }
}

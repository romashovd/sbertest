//Data transfer object
//Служит для обмена сообщениями между двумя системами объектом Message

package com.sbrtest.app1.service.dto;


public class MessageDto {

    private String name;
    private String secondname;
    private String body;

    public MessageDto(String name, String secondname, String body) {
        this.name = name;
        this.secondname = secondname;
        this.body = body;
    }

    public MessageDto(String name) {
    }

    public MessageDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

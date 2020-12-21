package com.sbrtest.app1.service.dto;

public class MessageBodyDto extends MessageDto{
    private String body;

    public MessageBodyDto() {
    }

    public MessageBodyDto(String secondname, String name, String body){
        super.setSecondname(secondname);
        super.setName(name);
        this.body = body;

    }

    public String getBody() {

        return body;
    }

    public void setBody(String body) {

        this.body = body;
    }
}

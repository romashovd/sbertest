package com.sbrtest.app1.service.mapper;

import com.sbrtest.app1.domain.RecivedMessage;
import com.sbrtest.app1.service.dto.MessageBodyDto;
import com.sbrtest.app1.service.dto.MessageDto;
import org.springframework.stereotype.Service;

@Service
public class MessageMapper {

    public RecivedMessage toEntity(MessageDto dto){
        RecivedMessage entity = new RecivedMessage();
        entity.setName(dto.getName());
        entity.setBody(dto.getBody());
        entity.setSecondName(dto.getSecondname());
        
        return entity;
    }

    public MessageDto toDto(RecivedMessage entity){
        return new MessageDto(entity.getName());
    }

    public MessageBodyDto toDtoBody(RecivedMessage message){
        return  new MessageBodyDto(message.getSecondName(), message.getName(), message.getBody());
    }

}

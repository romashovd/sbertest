package com.sbrtest.app1.service.mapper;

import com.sbrtest.app1.domain.Message;
import com.sbrtest.app1.service.dto.Mesdto;
import org.springframework.stereotype.Service;

@Service
public class MessageMapper {

    public Message toEntity(Mesdto dto){
        Message entity = new Message();
        return entity;
    }

}

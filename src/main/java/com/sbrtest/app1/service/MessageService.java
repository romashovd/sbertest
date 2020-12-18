package com.sbrtest.app1.service;

import com.sbrtest.app1.domain.Message;
import com.sbrtest.app1.repos.MessageRepo;
import com.sbrtest.app1.service.dto.Mesdto;
import com.sbrtest.app1.service.mapper.MessageMapper;
import org.springframework.stereotype.Service;

//сервис передачи сообщений
@Service
public class MessageService {

    private MessageRepo messageRepo;
    private MessageMapper messageMapper;

    public MessageService(MessageRepo messageRepo, MessageMapper messageMapper) {
        this.messageRepo = messageRepo;
        this.messageMapper = messageMapper;
    }

    public Message addMessage(Mesdto mesdto) {
        Message savedMessage = messageRepo.save(messageMapper.toEntity(mesdto));
        return savedMessage;
    }

}
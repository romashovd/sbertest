package com.sbrtest.app1.service;

import com.sbrtest.app1.domain.RecivedMessage;
import com.sbrtest.app1.repository.MessagesRepository;
import com.sbrtest.app1.service.dto.MessageBodyDto;
import com.sbrtest.app1.service.dto.MessageDto;
import com.sbrtest.app1.service.mapper.MessageMapper;
import org.springframework.stereotype.Service;

//сервис передачи сообщений
@Service
public  class MessageService {

    private MessagesRepository messagesRepository;
    private MessageMapper messageMapper;


    public MessageService(MessagesRepository messagesRepository, MessageMapper messageMapper){

        this.messagesRepository = messagesRepository;
        this.messageMapper = messageMapper;
    }

    //метод добавляет сообщение
    public RecivedMessage addMessage(MessageDto messageDto){
        RecivedMessage savedMessage = messagesRepository.save(messageMapper.toEntity(messageDto));
        return savedMessage;
    }

    //принимает имя, фамилию, тело сообщения и сохраняет в репозиторий
    public MessageBodyDto confirmBody(String secondname, String name, Integer id){
        RecivedMessage recivedMessage = messagesRepository.findByID(id);
        recivedMessage.setBody(secondname);
        recivedMessage.setBody(name);
        //recivedMessage.setBody(body);
        messagesRepository.save(recivedMessage);
        return messageMapper.toDtoBody(recivedMessage);

    }
    //взаимодествие с приложением App2 (кривое)
    public MessageBodyDto getMessageForApp2(){
        RecivedMessage message = messagesRepository.findByID(1);
        return messageMapper.toDtoBody(message);

    }
}



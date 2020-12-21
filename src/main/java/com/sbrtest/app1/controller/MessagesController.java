package com.sbrtest.app1.controller;


import com.sbrtest.app1.domain.RecivedMessage;
import com.sbrtest.app1.service.MessageService;
import com.sbrtest.app1.service.dto.MessageBodyDto;
import com.sbrtest.app1.service.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping гарантирует, что HTTP-запросы на /recived_message будут сопоставлены методу
@RequestMapping("/recived_message")
public class MessagesController {

    private MessageService messageService;

    public MessagesController(MessageService messageService) {

        this.messageService = messageService;
    }

    //добавляет сообщение отправляет сообщение в JSon-формате
    @PostMapping("/add")
    //считывает статус но ничего не возвращает
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewRecivedMessage(@RequestBody MessageDto message){
        messageService.addMessage(message);

    }
    //принимает URL и выводит JSon с заданными в ULRe параметрами
    @GetMapping("/confirm/{secondname}/{name}/{id}/{body}")
    public ResponseEntity<MessageBodyDto> confirmId(
            @PathVariable String secondname,
            @PathVariable String name,
            @PathVariable Integer id){
        var messageBodyDto =  messageService.confirmBody(secondname, name, id);
        return new ResponseEntity<MessageBodyDto>(messageBodyDto, HttpStatus.OK);
    }

    //принимает сообщения от приложения App2
    @GetMapping("/get_message")
    public ResponseEntity<MessageBodyDto> sendConfirm(){
        var messageForApp2 = messageService.getMessageForApp2();

        return new ResponseEntity<MessageBodyDto>(messageForApp2, HttpStatus.OK);
    }

}

package com.sbrtest.app1.control;

import com.sbrtest.app1.domain.Message;
import com.sbrtest.app1.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;
//Вывод Страницы приветствия с названием сервера
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="Server") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }
//Вывод сообщений веб
    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }
//Запись сообщений веб
    @PostMapping
    public String add(@RequestParam String fname,
                      @RequestParam String lname,
                      @RequestParam String text,
                      Map<String, Object> model) {
        Message message = new Message(fname, lname, text);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

}

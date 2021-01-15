package com.sbrtest.app1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication

//Точка входа приложения
public class App1Application {
    static Logger log = LogManager.getLogger(App1Application.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(App1Application.class, args);

        log.info("Приложение успешно запущено.");

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy kk:mm:ss");

        System.out.println("Текущая дата " + formatForDateNow.format(dateNow));

    }
}

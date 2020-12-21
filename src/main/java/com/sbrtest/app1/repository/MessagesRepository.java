package com.sbrtest.app1.repository;

import com.sbrtest.app1.domain.RecivedMessage;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<RecivedMessage, String> {

    RecivedMessage findByID(Integer id);
}

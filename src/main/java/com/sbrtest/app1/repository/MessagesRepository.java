package com.sbrtest.app1.repository;

import com.sbrtest.app1.domain.RecivedMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<RecivedMessage, String> {
    RecivedMessage findAllRecivedMessage();
}

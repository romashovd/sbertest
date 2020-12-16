package com.sbrtest.app1.repos;

import com.sbrtest.app1.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {
    Iterable<Message> findByLname(String filter);
}


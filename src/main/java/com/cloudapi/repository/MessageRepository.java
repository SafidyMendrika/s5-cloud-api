package com.cloudapi.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cloudapi.model.Message;


public interface MessageRepository extends MongoRepository<Message, String>{


    @Query("{ $or: [ { idutilisateur1: ?0, idutilisateur2: ?1 }, { idutilisateur1: ?1, idutilisateur2: ?0 } ] }")
    List<Message> findMessagesBetweenUsers(int idutilisateur1, int idutilisateur2);
}

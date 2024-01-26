package com.cloudapi.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cloudapi.model.Discussion;
import com.cloudapi.model.Message;


public interface DiscussionRepository extends MongoRepository<Discussion, String>{

    
    @Query("{'users.id_utilisateur': ?0 ,  'closed': false}")
    List<Discussion> findDiscussionByUserId(int userId);
}

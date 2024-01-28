package com.cloudapi.handler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import com.sun.security.auth.UserPrincipal;

public class UserHandshakeHandler extends DefaultHandshakeHandler{


    @Override
    protected Principal determineUser(ServerHttpRequest request,WebSocketHandler wsHandler,Map<String,Object> object){
        String randomId = UUID.randomUUID().toString();

        return new UserPrincipal(randomId);
    }
}

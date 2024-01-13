package com.cloudapi.json;

import lombok.Data;

@Data
public class Response {
    int code;
    String message;
    Object data;



    public void error(Exception e){
        setCode(100);
        setMessage(e.getMessage());
    }

    public void success(String message,Object data){
        setCode(200);
        setMessage(message);
        setData(data);
    }
}

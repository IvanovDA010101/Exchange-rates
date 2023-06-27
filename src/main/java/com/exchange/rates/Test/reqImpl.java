package com.exchange.rates.Test;

import java.io.File;

import org.springframework.http.ResponseEntity;

public class reqImpl implements req{
    private req req;
    @Override
    public ResponseEntity<String> put(String code, Object file) {
        file = new File("test.txt");
        return req.put("test.txt",file);
    }
}


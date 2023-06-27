package com.exchange.rates.Test;

import java.io.File;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import jakarta.servlet.annotation.HttpMethodConstraint;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "tes", url = "ftp://smev3-n0.test.gosuslugi.ru")
public interface req {
//    @RequestLine("PUT")
    @RequestMapping(method = RequestMethod.PUT,value = "/{code}",consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @Headers({"Content-Type","application/octet-stream"})
//    @GetMapping("/{code}")
    ResponseEntity<String> put(@PathVariable String code, @Param Object file);
}

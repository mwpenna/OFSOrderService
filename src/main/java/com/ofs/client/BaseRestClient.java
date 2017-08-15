package com.ofs.client;

import com.ofs.server.rest.RestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

@Slf4j
public abstract class BaseRestClient<T> extends RestService{

    public HttpHeaders getHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        return headers;
    }

    public T sendRequest(RequestEntity request, Class clazz) {
        try {
            ResponseEntity e = this.exchange(request, clazz);
            return (T)e.getBody();
        } catch (Exception ex) {
            log.error("Exception occurred when getting user: {}", ex);
            throw ex;
        }
    }
}

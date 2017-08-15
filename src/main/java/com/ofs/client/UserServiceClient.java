package com.ofs.client;

import com.ofs.model.userservice.User;
import com.ofs.server.rest.RestService;
import com.ofs.server.security.SecurityContext;
import com.ofs.server.security.Subject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Optional;

@Component
@Slf4j
public class UserServiceClient extends RestService {

    @Value("${userServiceBaseURL}")
    private String userServiceBaseURL;

    public Optional<User> getUserById(String id) {
        Subject subject = SecurityContext.getSubject();
        URI requestUri = URI.create(userServiceBaseURL + "/user/id/" + id);
        HttpHeaders headers = this.getHeaders(subject.getToken());
        RequestEntity request = new RequestEntity(headers, HttpMethod.GET, requestUri);
        return Optional.of(this.sendRequest(request));
    }

    private HttpHeaders getHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        return headers;
    }

    private User sendRequest(RequestEntity request) {
        try {
            ResponseEntity e = this.exchange(request, User.class);
            return (User)e.getBody();
        } catch (Exception ex) {
            log.error("Exception occurred when getting user: {}", ex);
            throw ex;
        }
    }
}

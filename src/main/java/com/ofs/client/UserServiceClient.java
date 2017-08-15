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
public class UserServiceClient extends BaseRestClient<User> {

    @Value("${userServiceBaseURL}")
    private String userServiceBaseURL;

    public Optional<User> getUserById(String id) {
        Subject subject = SecurityContext.getSubject();
        URI requestUri = URI.create(userServiceBaseURL + "/users/id/" + id);
        HttpHeaders headers = this.getHeaders("Bearer " + subject.getToken());
        RequestEntity request = new RequestEntity(headers, HttpMethod.GET, requestUri);
        return Optional.of(this.sendRequest(request, User.class));
    }
}

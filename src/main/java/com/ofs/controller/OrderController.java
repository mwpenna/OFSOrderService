package com.ofs.controller;

import com.ofs.model.Order;
import com.ofs.repository.OrderRepository;
import com.ofs.server.OFSController;
import com.ofs.server.OFSServerId;
import com.ofs.server.form.OFSServerForm;
import com.ofs.server.form.ValidationSchema;
import com.ofs.server.security.Authenticate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@OFSController
@RequestMapping(value="/order", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Authenticate
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ValidationSchema(value = "/order-create.json")
    @CrossOrigin(origins = "*")
    public ResponseEntity create(@OFSServerId URI id, OFSServerForm<Order> form) throws Exception{
        Order order = form.create(id);

        orderRepository.addInventory(order);
        return ResponseEntity.created(id).build();
    }
}

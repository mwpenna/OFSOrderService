package com.ofs.controller;

import com.ofs.model.Order;
import com.ofs.repository.OrderRepository;
import com.ofs.server.OFSController;
import com.ofs.server.OFSServerId;
import com.ofs.server.errors.NotFoundException;
import com.ofs.server.form.OFSServerForm;
import com.ofs.server.form.ValidationSchema;
import com.ofs.server.form.search.SearchContext;
import com.ofs.server.model.OFSErrors;
import com.ofs.server.security.Authenticate;
import com.ofs.server.security.SecurityContext;
import com.ofs.utils.StringUtils;
import com.ofs.validators.OrderCreateValidator;
import com.ofs.validators.OrderGetValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.Optional;

@OFSController
@RequestMapping(value="/order", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderCreateValidator orderCreateValidator;

    @Autowired
    private OrderGetValidator orderGetValidator;

    @Authenticate
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ValidationSchema(value = "/order-create.json")
    @CrossOrigin(origins = "*")
    public ResponseEntity create(@OFSServerId URI id, OFSServerForm<Order> form) throws Exception{
        Order order = form.create(id);

        defaultFields(order);

        OFSErrors ofsErrors = new OFSErrors();
        orderCreateValidator.validate(order, ofsErrors);

        orderRepository.addInventory(order);
        return ResponseEntity.created(id).build();
    }

    private void defaultFields(Order order) {
        order.setCompanyId(StringUtils.getIdFromURI(SecurityContext.getSubject().getCompanyHref()));
    }

    @GetMapping(value = "/id/{id}")
    @Authenticate
    public Order getOrderById(@PathVariable("id") String id) throws Exception {
        log.info("Retrieving Order item with id: {}", id);
        Optional<Order> orderOptional = orderRepository.getOrderById(id);

        if(orderOptional.isPresent()) {
            Order order = orderOptional.get();

            OFSErrors ofsErrors = new OFSErrors();
            orderGetValidator.validate(order, ofsErrors);

            return order;
        }
        else {
            log.warn("Order with id: {} not found", id);
            throw new NotFoundException();
        }
    }
}

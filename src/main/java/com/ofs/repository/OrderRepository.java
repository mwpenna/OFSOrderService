package com.ofs.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ofs.model.Order;
import com.ofs.server.repository.BaseCouchbaseRepository;
import com.ofs.server.repository.ConnectionManager;
import com.ofs.server.repository.OFSRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@OFSRepository("order")
public class OrderRepository extends BaseCouchbaseRepository<Order> {

    @Autowired
    ConnectionManager connectionManager;

    public void addInventory(Order order) throws JsonProcessingException {
        Objects.requireNonNull(order);

        log.info("Attempting to add order with id: {}", order.getId());
        add(order.getId().toString(), connectionManager.getBucket("order"), order);
        log.info("Order with id: {} has been added", order.getId());
    }
}

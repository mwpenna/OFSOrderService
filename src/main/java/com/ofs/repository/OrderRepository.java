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
import java.util.Optional;

@Slf4j
@Component
@OFSRepository("orders")
public class OrderRepository extends BaseCouchbaseRepository<Order> {

    @Autowired
    ConnectionManager connectionManager;

    public void addInventory(Order order) throws JsonProcessingException {
        Objects.requireNonNull(order);

        log.info("Attempting to add order with id: {}", order.getId());
        add(order.getId().toString(), connectionManager.getBucket("orders"), order);
        log.info("Order with id: {} has been added", order.getId());
    }

    public Optional<Order> getOrderById(String id) {
        if(id == null) {
            log.warn("Cannot get order by id with null id");
            return Optional.empty();
        }

        return queryForObjectById(id, connectionManager.getBucket("orders"), Order.class);
    }
}

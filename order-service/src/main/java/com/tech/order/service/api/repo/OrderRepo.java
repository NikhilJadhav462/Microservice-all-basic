package com.tech.order.service.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tech.order.service.api.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}

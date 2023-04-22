package com.cartsy.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import com.cartsy.ecom.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.product_s_desc LIKE %:text% OR p.product_l_desc LIKE %:text% OR p.brand LIKE %:text%")
    List<Order> search(@Param("text") String searchText);

}

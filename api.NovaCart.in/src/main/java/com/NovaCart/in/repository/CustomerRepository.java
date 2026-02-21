package com.NovaCart.in.repository;

import com.NovaCart.in.entity.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomersEntity,Long> {

}

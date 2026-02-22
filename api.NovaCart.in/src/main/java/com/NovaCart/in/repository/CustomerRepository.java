package com.NovaCart.in.repository;

import com.NovaCart.in.entity.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomersEntity,Long> {

    @Query("SELECT c FROM CustomersEntity c WHERE c.email = :email AND c.deletedAt IS NULL")
    Optional<CustomersEntity> findActiveCustomerByEmail(@Param("email") String email);
}

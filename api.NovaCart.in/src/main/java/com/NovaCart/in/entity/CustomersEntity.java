package com.NovaCart.in.entity;

import com.NovaCart.in.utils.CustomerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers",
        indexes = {
        @Index(name = "idx_customer_email",columnList = "email")
        }
)
public class CustomersEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "name",unique = true,nullable = false)
    private String name;

    @Column(name = "email",unique = true,nullable = false)
    private  String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_active")
    private CustomerStatus status;

    @Column(name = "age")
    private  Integer age;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;


}

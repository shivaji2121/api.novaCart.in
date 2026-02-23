package com.NovaCart.in.entity;

import com.NovaCart.in.utils.CustomerStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers",
        indexes = {
        @Index(name = "idx_customer_email",columnList = "email")
        }
)
public class CustomersEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",unique = true,nullable = false)
    private  String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_active")
    private CustomerStatus customerStatus;

    @Column(name = "age")
    private  Integer age;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private  LocalDateTime deletedAt;

}

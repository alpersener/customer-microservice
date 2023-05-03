package com.proje.customer.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Customers")
public class Customer {
    @Id
    @SequenceGenerator(name="customer_id_sequence",sequenceName ="customer_id_sequence")
    @GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "customer_id_sequence")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="eMail")
    private String eMail;

    @Column(name="phoneNumber")
    private int phoneNumber;

}

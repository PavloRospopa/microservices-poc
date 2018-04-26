package edu.kpi.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column
    private String name;

    @Column
    private String address;

}

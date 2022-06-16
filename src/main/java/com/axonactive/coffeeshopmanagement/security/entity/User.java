package com.axonactive.coffeeshopmanagement.security.entity;

import com.axonactive.coffeeshopmanagement.entities.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "users")
    private List<UserRoleAssignment> roles = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Employee employee;

}

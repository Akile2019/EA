package edu.mum.cs.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userAccount;
    private String fName;
    private String lName;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
}

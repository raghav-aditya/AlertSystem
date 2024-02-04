package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee")
public class Employee extends BaseModel {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id ;

    @Column(name = "first_name")
    private String firstName ;
    @Column(name = "last_name")
    private String lastName ;
    @Column(name = "phone_num")
    private String phoneNum ;
    @Column(name = "team")
    private String Team ;
    @Column(name = "on_cal")
    private boolean onCall ;

}

package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee")
public class Employee extends BaseModel {

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

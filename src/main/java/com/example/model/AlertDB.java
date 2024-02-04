package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "alert_db")
public class AlertDB extends BaseModel {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id ;
    @Column(name = "alert_name")
    private String alertName ;
    @Column(name = "team")
    private String team ;
    @Column(name = "severity")
    private String severity ;
}

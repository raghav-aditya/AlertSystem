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
@Table( name = "alert_db")
public class AlertDB extends BaseModel {

    @Column(name = "alert_name")
    private String alertName ;
    @Column(name = "team")
    private String team ;
    @Column(name = "severity")
    private String severity ;
}

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
@Table(name="instances_occurred_table")
public class InstancesOccuredTable {

    @Column(name="incident")
    private String incident ;
    @Column(name ="is_picked")
    private Boolean isPicked ;

}

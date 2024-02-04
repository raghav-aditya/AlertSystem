package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="instances_occurred")
public class InstancesOccured {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id ;
    @Column(name="incident")
    private String incident ;
    @Column(name ="is_picked")
    private Boolean isPicked ;

}

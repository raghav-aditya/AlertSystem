package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseModel implements Serializable {


@Column(name="created_at" , nullable = false )
@CreationTimestamp
private Date createdAt ;

@Column(name = "created_by" , nullable = false )
private String createdBy ;

@Column(name = "updated_at" , nullable = false )
@UpdateTimestamp
private Date updatedAt ;

@Column(name="updated_by" , nullable = false )
private String updatedBy ;

}

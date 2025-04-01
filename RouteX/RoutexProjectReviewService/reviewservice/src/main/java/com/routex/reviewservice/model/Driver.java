package com.routex.reviewservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "booking"})
@Entity
public class  Driver extends Basemodel{

    private String dname;
    
    @Column(nullable = false,unique = true)
    private String dlicences_Number;

     private String phoneNumber;

    @Builder.Default
    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)// driver has many booking
    private List<Booking>booking=new ArrayList<>();

}
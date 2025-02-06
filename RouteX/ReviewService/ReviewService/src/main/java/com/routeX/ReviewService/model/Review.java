package com.routeX.ReviewService.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookingreview")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{


    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private double rating;





    @Override
    public String toString() {
        return "Review{" +

                ", content='" + content + '\'' +
                ", rating=" + rating +
                '}';
    }

}

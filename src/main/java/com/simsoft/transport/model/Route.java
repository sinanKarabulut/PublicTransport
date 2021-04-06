package com.simsoft.transport.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ROUTE")
@ToString
@NoArgsConstructor //boş bir constructure otomatik yapar
@AllArgsConstructor
@Data
public class Route  extends BaseEntity {
    @Id
    @Column(name = "ROUTE_ID", unique = true, nullable = false, precision = 12, scale = 0)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private  long routeId;
    @Column(name = "ROUTE_NAME")
    private String routeName;

}

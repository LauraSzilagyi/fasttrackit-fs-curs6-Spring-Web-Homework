package ro.fasttrackit.curs6homework.ex1.entity;

import lombok.*;
import ro.fasttrackit.curs6homework.ex1.ProductCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private double price;
    private String description;
    private ProductCategory category;
}

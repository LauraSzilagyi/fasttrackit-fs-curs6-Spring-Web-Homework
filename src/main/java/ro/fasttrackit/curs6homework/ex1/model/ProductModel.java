package ro.fasttrackit.curs6homework.ex1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.fasttrackit.curs6homework.ex1.ProductCategory;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    private int id;
    private String name;
    private double price;
    private String description;
    private ProductCategory category;
}

package ro.fasttrackit.curs6homework.ex1;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs6homework.ex1.entity.Product;
import ro.fasttrackit.curs6homework.ex1.entity.ProductRepository;

import java.util.List;

import static ro.fasttrackit.curs6homework.ex1.ProductCategory.*;

@Component
@RequiredArgsConstructor
public class ProductDataProvider implements CommandLineRunner {
    private final ProductRepository repository;

    private List<Product> getProducts() {
        return List.of(
                new Product(null, "Apple", 1.99, "Healthy food", FOOD),
                new Product(null, "Hamburger", 5.50, "Fast food", FOOD),
                new Product(null, "Water", 1, "Healthy", DRINK),
                new Product(null, "Sponge", 2.00, "Cleaning", HOUSEHOLD),
                new Product(null, "Ball", 9.50, "Outdoor activity", GAME)
        );
    }

    @Override
    public void run(String... args) {
        repository.saveAll(getProducts());
    }
}

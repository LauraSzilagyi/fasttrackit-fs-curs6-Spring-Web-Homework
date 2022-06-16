package ro.fasttrackit.curs6homework.ex1.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs6homework.ex1.entity.Product;
import ro.fasttrackit.curs6homework.ex1.entity.ProductRepository;
import ro.fasttrackit.curs6homework.ex1.exception.InvalidProductFoundException;
import ro.fasttrackit.curs6homework.ex1.model.ProductModel;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getAll(String category, Double maxPrice) {
        List<Product> products = repository.findAll();
        return products.stream()
                .filter(product -> isNull(category) || category.equalsIgnoreCase(product.getCategory().toString()))
                .filter(product -> isNull(maxPrice) || product.getPrice() <= maxPrice)
                .toList();
    }

    public Optional<Product> getProduct(int id) {
        return repository.findById(id);
    }

    public Product addProduct(ProductModel product) {
        validateProduct(product);
        Product entity = Product.builder()
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .category(product.getCategory())
                .build();

        return repository.save(entity);
    }

    private void validateProduct(ProductModel product) {
        if (StringUtils.isEmpty(product.getName()) || product.getPrice() <= 0) {
            throw new InvalidProductFoundException("Product must contains name and price!");
        }
    }

    public Optional<Product> deleteProduct(int id) {
        Optional<Product> product = repository.findById(id);
        product.ifPresent(repository::delete);
        return product;
    }
}

package ro.fasttrackit.curs6homework.ex2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Profile;

@Profile("file")
@ConstructorBinding
@ConfigurationProperties(prefix = "country")
public record CountryFileConfiguration(String filePath) {
}

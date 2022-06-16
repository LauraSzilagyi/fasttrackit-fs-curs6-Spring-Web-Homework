package ro.fasttrackit.curs6homework.ex2.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs6homework.ex2.Country;
import ro.fasttrackit.curs6homework.ex2.config.CountryFileConfiguration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.regex.Pattern.quote;

@Profile("file")
@Component
@RequiredArgsConstructor
public class FileCountryProviderImpl implements CountryProvider {

    private final CountryFileConfiguration configuration;

    @Override
    public List<Country> getCountries() {
        try {
            List<String> lines = Files.readAllLines(Path.of(configuration.filePath()));
            return IntStream.range(0, lines.size())
                    .filter(index -> lines.get(index).split(quote("|")).length >= 5)
                    .mapToObj(index -> getCountryFormat(lines.get(index), index))
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    private Country getCountryFormat(String line, int id) {
        String[] tokens = line.split(quote("|"));
        String[] neighbours = getNeighbours(tokens);

        return new Country(++id, tokens[0], tokens[1], Long.parseLong(tokens[2]),
                Integer.parseInt(tokens[3]), tokens[4], List.of(neighbours));
    }

    private String[] getNeighbours(String[] tokens) {
        if (tokens.length == 6) {
            return tokens[5].split(quote("~"));
        } else {
            return new String[0];
        }
    }
}

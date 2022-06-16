package ro.fasttrackit.curs6homework.ex2.reader;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs6homework.ex2.Country;

import java.util.List;

@Profile("memory")
@Component
public class InMemoryCountryProviderImpl implements CountryProvider {

    @Override
    public List<Country> getCountries() {
        return List.of(
                new Country(1,
                        "Romania",
                        "Bucharest",
                        19_861_408,
                        238391,
                        "Europe",
                        List.of("HUN", "UKR")),
                new Country(2,
                        "Portugal",
                        "Lisbon",
                        10374822,
                        92090,
                        "Europe",
                        List.of("ESP")),
                new Country(3,
                        "Somalia",
                        "Mogadishu",
                        11079000,
                        637657,
                        "Africa",
                        List.of("DJI", "ETH", "KEN")
                )
        );
    }
}

import java.util.*;

public class Exercise5 {

    public static void main(String[] args) {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();
       //write your answer here 
    Optional<City> highestPopulousCapital = countryDao.findAllCountries().stream()
            .map(country -> country.getCities().stream()
                .filter(city -> city.getId() == country.getCapital()) 
                .findFirst()) 
            .filter(Optional::isPresent) 
            .map(Optional::get) // 
            .max(Comparator.comparing(City::getPopulation));

    
        highestPopulousCapital.ifPresent(city -> 
            System.out.println("Highest populated capital city: " + city)
        );
    }
    }


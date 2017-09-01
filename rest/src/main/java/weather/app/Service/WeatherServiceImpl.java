package weather.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.app.Entity.WeatherDetails;
import weather.app.Repository.WeatherRepository;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    WeatherRepository repository;

    @Transactional
    public WeatherDetails post(WeatherDetails weather) {
/*        WeatherDetails existing = repository.findbyCity(weather.getCity());
        if (existing != null) {
            throw new BadRequestException("Employee with email " + emp.getEmail() + " already exists.");
        }*/
        return repository.post(weather);
    }
    public WeatherDetails findbyCity(String city) {
        return repository.findbyCity(city);
    }

    public int findbyCity(String city, String property) {
        return repository.findbyCity(city, property);
    }

    public List<String> findAllCities() {
        return repository.findAllCities();
    }
}

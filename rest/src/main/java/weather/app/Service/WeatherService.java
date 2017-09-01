package weather.app.Service;

import org.springframework.stereotype.Service;
import weather.app.Entity.WeatherDetails;

import java.util.List;

public interface WeatherService {
    public WeatherDetails post(WeatherDetails weather);
    public WeatherDetails findbyCity(String city);
    public int findbyCity(String city, String property);
    public List<String> findAllCities();
}

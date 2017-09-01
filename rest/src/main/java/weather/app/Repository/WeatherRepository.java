package weather.app.Repository;

import org.springframework.stereotype.Repository;
import weather.app.Entity.WeatherDetails;

import java.util.List;
public interface WeatherRepository {
    public WeatherDetails post(WeatherDetails weather);
    public WeatherDetails findbyCity(String city);
    public int findbyCity(String city, String property);
    public List<String> findAllCities();
}

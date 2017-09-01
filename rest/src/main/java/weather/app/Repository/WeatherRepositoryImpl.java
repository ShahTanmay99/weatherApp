package weather.app.Repository;

import org.springframework.stereotype.Repository;
import weather.app.Entity.WeatherDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public WeatherDetails post(WeatherDetails weather) {
        entityManager.persist(weather.getWind());
        entityManager.persist(weather);
        return weather;
    }

    public WeatherDetails findbyCity(String city) {
        TypedQuery<WeatherDetails> query = entityManager.createNamedQuery("WeatherDetails.findbyCity",WeatherDetails.class);
        query.setParameter("paramCity", city);
        List<WeatherDetails> resultList = query.getResultList();
        if (resultList != null) {
            System.out.print(resultList.get(0).toString());
            return resultList.get(0);
        } else {
            return null;
        }
    }
    public int findbyCity(String city, String property) {
        TypedQuery<WeatherDetails> query = entityManager.createNamedQuery("WeatherDetails.findbyCity",WeatherDetails.class);
        query.setParameter("paramCity", city);
        List<WeatherDetails> resultList = query.getResultList();
        if (resultList != null) {
            System.out.print(resultList.get(0).toString());
            if(property.equals("humidity"))
                return resultList.get(0).getHumidity();
            else if(property.equals("tempreture"))
                return resultList.get(0).getTemperature();
            else
                return resultList.get(0).getPressure();
        } else {
            return 0;
        }
    }

    public List<String> findAllCities() {
        Query query = entityManager.createNativeQuery("SELECT DISTINCT weather.city FROM  WeatherDetails weather");
        List<String> resultList = query.getResultList();
        if (resultList != null ) {
            System.out.print(resultList);
            return resultList;
        } else {
            return null;
        }
    }
}

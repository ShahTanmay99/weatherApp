package weather.app.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "WeatherDetails.findbyCity",
                query = "SELECT w FROM WeatherDetails w WHERE w.city=:paramCity ORDER BY w.timestamp DESC")
})
public class WeatherDetails {

    @Id
    private String id;
    private String city;
    private String description;
    private int humidity;
    private int pressure;
    private int temperature;
    private Timestamp timestamp;

    @OneToOne
    private WindDetails wind;

    public WeatherDetails(){
        this.id= UUID.randomUUID().toString();
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public WindDetails getWind() {
        return wind;
    }

    public void setWind(WindDetails wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "WeatherDetails{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", temperature=" + temperature +
                ", timestamp=" + timestamp +
                ", wind=" + wind +
                '}';
    }
}

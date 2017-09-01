package weather.app.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class WindDetails {

    @Id
    private String id;
    private int degree;
    private float speed;

    public WindDetails(){
        this.id= UUID.randomUUID().toString();
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "WindDetails{" +
                "id='" + id + '\'' +
                ", degree=" + degree +
                ", speed=" + speed +
                '}';
    }
}

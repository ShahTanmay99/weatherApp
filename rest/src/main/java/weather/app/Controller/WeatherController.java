package weather.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import weather.app.Entity.WeatherDetails;
import weather.app.Service.WeatherService;

import java.util.List;

@RestController
@RequestMapping(value = "/weather")
@CrossOrigin(origins = "http://mocker.egen.io")
public class WeatherController {

    @Autowired WeatherService service;

    @RequestMapping(method = RequestMethod.GET, value = "/cities", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> findAll() {
        return service.findAllCities();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{city}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public WeatherDetails findOne(@PathVariable("city") String city) {
        return service.findbyCity(city);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{city}/{property}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int findOne(@PathVariable("city") String city,@PathVariable("property") String property) {
        return service.findbyCity(city, property);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public WeatherDetails create(@RequestBody WeatherDetails weather) {
        return service.post(weather);
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public Employee update(@PathVariable("id") String empId, @RequestBody Employee emp) {
//        return service.update(empId, emp);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
//    public void delete(@PathVariable("id") String empId) {
//        service.delete(empId);
//    }

}

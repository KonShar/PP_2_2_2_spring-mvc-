package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Nissan", "Skyline", 1999));
        cars.add(new Car("Toyota", "Supra", 2999));
        cars.add(new Car("BMW", "520i", 1499));
        cars.add(new Car("Mercedes", "W140", 1899));
        cars.add(new Car("Lexus", "LX", 2599));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}

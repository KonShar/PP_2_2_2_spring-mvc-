package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarDAO carDAO;

    @Autowired
    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getCars() {
        return carDAO.getCars();
    }

    public List<Car> getCars(Integer count) {
        if (count > 5) {
           return carDAO.getCars();
        } else if (count > 0){
            return carDAO.getCars().subList(0, count);
        }
        return new ArrayList<Car>();
    }
}

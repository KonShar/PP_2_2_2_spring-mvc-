package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.models.Car;

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
        if (count == null || count > 5) {
           return carDAO.getCars();
        } else {
            return carDAO.getCars().subList(0, count);
        }
    }
}

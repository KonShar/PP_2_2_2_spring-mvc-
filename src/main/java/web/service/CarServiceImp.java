package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.dao.CarDAOImp;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private CarDAO carDAO;

    @Autowired
    public CarServiceImp(CarDAOImp carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> getCars() {
        return carDAO.getCars();
    }

    @Override
    public List<Car> getCars(Integer count) {
        if (count > 5) {
           return carDAO.getCars();
        } else if (count > 0){
            return carDAO.getCars().subList(0, count);
        }
        return new ArrayList<Car>();
    }
}

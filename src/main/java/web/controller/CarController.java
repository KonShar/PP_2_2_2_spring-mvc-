package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;
import web.models.Car;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

//    @GetMapping
//    public String getCars(HttpServletRequest request, Model model ) {
//        List<Car> cars = carDAO.getCars().subList(0, count);
//        model.addAttribute("cars", cars);
//        return "car/cars";
//    }
    @GetMapping
    public String getCars(Model model) {
        model.addAttribute("cars", carService.getCars());
        return "car/cars";
    }

    @GetMapping(params = "count")
    public String getCars(Integer count, Model model ) {
        if (count == null || count > 5) {
            model.addAttribute("cars", carService.getCars());
            return "car/cars";
        } else {
            List<Car> cars = carService.getCars().subList(0, count);
            model.addAttribute("cars", cars);
            return "car/cars";
        }
    }
}

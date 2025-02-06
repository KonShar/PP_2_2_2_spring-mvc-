package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarService;
import web.service.CarServiceImp;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarServiceImp carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(Model model) {
        model.addAttribute("cars", carService.getCars());
        return "car/cars";
    }

    @GetMapping(params = "count")
    public String getCars(Integer count, Model model ) {
        model.addAttribute("cars", carService.getCars(count));
        return "car/cars";
    }
}

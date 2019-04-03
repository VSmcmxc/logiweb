/*
package com.mcmxc.controller;

import com.mcmxc.controller.exceptions.FormParamaterParsingException;
import com.mcmxc.entities.City;
import com.mcmxc.entities.Truck;
import com.mcmxc.entities.enums.TruckStatus;
import com.mcmxc.service.api.CityService;
import com.mcmxc.service.api.TruckService;
import com.mcmxc.service.exceprions.LogiwebServiceException;
import com.mcmxc.service.exceprions.ServiceValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TruckController {

    private static final Logger logger = LoggerFactory.getLogger(TruckController.class);

    @Autowired
    private TruckService truckService;

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/dispatcher/trucks", method = RequestMethod.GET)
    public String listTrucks(Model model) throws LogiwebServiceException{
        model.addAttribute("truck", new Truck());
        model.addAttribute("listTrucks", this.truckService.getAll());

        return "dispatcher/trucks";
    }


    @RequestMapping(value = "/dispatcher/trucks/newTruck")
    public ModelAndView showForm() {
        ModelAndView model=new ModelAndView();
        model.setViewName("dispatcher/newTruck");
        model.addObject("truck",new Truck());
        model.addObject("listCities",cityService.getAll());
        model.addObject("city",new City());
        return model;
    }



    @RequestMapping(value = "/dispatcher/trucks/newTruck/add", method = RequestMethod.POST)
    public String addDispatcher(@RequestParam("truck") Truck truck,
                                @RequestParam("city") City city,
                                BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "error";
        }


        City currentCity= cityService.findUniqueByName(city);
        model.addAttribute("number", truck.getNumber());
        model.addAttribute("driverCapacity", truck.getDriverCapacity());
        model.addAttribute("truckSize", truck.getTruckSize());
        model.addAttribute("truckStatus", truck.getTruckStatus());
        model.addAttribute("currentCity", new City());
        model.addAttribute("truckShift", truck.getTruckShift());

        //truck.setCurrentCity(cityService.findUniqueByName(city.getName()));
        truck.setCurrentCity(cityService.findUniqueByName(truck.getName()));
        truckService.add(truck);

        return "redirect:/dispatcher/trucks";

    }


}
*/

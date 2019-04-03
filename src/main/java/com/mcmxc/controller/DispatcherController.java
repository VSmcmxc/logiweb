package com.mcmxc.controller;

import com.mcmxc.entities.City;
import com.mcmxc.entities.Driver;
import com.mcmxc.service.api.CityService;
import com.mcmxc.service.api.DriverService;
import com.mcmxc.service.exceprions.LogiwebServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class DispatcherController {


    @Autowired
    private DriverService driverService;

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/dispatcher", method = RequestMethod.GET)
    public String dispatcher(Model model) {
        return "dispatcher/dispatcher";
    }

    @RequestMapping(value = "/dispatcher/drivers", method = RequestMethod.GET)
    public String listUsers(Model model)throws LogiwebServiceException {
        model.addAttribute("driver", new Driver());
        model.addAttribute("listDrivers", this.driverService.getAll());

        return "dispatcher/drivers";
    }

    @RequestMapping(value = "/dispatcher/newDriver", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("dispatcher/newDriver", "driver", new Driver());
    }

    @RequestMapping(value = "/dispatcher/newDriver/add", method = RequestMethod.POST)
    public String addDriver(@Valid @ModelAttribute("driver") Driver driver,
                            BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("firstName", driver.getFirstName());
        model.addAttribute("lastName", driver.getLastName());
        model.addAttribute("status", driver.getStatus());
        /*model.addAttribute("currentCity", driver.getCurrentCity());
        model.addAttribute("currentTruck", driver.getCurrentTruck());*/
        if (driver.getId() == 0) {
            this.driverService.add(driver);
        } else {
            this.driverService.update(driver);
        }
        return "redirect:/dispatcher/drivers";

    }

    @RequestMapping(value = "/dispatcher/cities", method = RequestMethod.GET)
    public String listCities(Model model)throws LogiwebServiceException {
        model.addAttribute("city", new City());
        model.addAttribute("listCities", this.cityService.getAll());

        return "dispatcher/cities";
    }
}

package com.mcmxc.controller;


import com.mcmxc.entities.User;
import com.mcmxc.service.api.SecurityService;
import com.mcmxc.service.api.UserService;
import com.mcmxc.service.exceprions.LogiwebServiceException;
import com.mcmxc.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.addDispathcer(userForm);

        securityService.autoLogin(userForm.getUserName(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin/admin";
    }


    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String listUsers(Model model)throws LogiwebServiceException {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.getAll());

        return "admin/users";
    }


    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {

        this.userService.remove(this.userService.get(id));

        return "redirect:/admin/users";
    }


    @RequestMapping(value = "/admin/newUser", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("admin/newUser", "user", new User());
    }

    @RequestMapping(value = "/admin/newUser/add", method = RequestMethod.POST)
    public String addDispatcher(@Valid @ModelAttribute("user") User user,
                                BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("role", user.getRole().toString());
        model.addAttribute("password", user.getPassword());
        if (user.getId() == 0) {
            this.userService.add(user);
        } else {
            this.userService.update(user);
        }
        return "redirect:/admin/users";

    }

    @RequestMapping("admin/userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.get(id));

        return "admin/userdata";
    }

    @RequestMapping(value = "admin/editUser/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.get(id));
        return "admin/editUser";
    }

    @RequestMapping(value = "admin/editUser/edit/{id}", method = RequestMethod.POST)
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.get(id));
        userService.saveOrUpdate(this.userService.get(id));

        return "redirect:/admin/users";
    }


}

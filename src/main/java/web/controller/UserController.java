package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/")
    public ModelAndView home() {
        List<User> lu = userService.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listUser", lu);
        return mav;
    }

    @GetMapping("/users/new_user")
    public String newUserForm(User user) {
        return "new_user";
    }

    @PostMapping("/users/new_user")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/users/";
    }



    @PostMapping("/users/edit/{id}")
    public String  editUserForm(@PathVariable("id") long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }
    @PostMapping("/users/update/{id}")
    public String editUser(@PathVariable("id") long id, User user){
        userService.update(user);
        return "redirect:/users/";
    }
    @PostMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        System.out.println("delete");
        return "redirect:/users/";
    }


}

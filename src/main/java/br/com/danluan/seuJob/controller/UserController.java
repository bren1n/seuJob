package br.com.danluan.seuJob.controller;

import br.com.danluan.seuJob.model.User;
import br.com.danluan.seuJob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/listUser";
    }

    @RequestMapping(value = {"/form", "/form/{id}"})
    public String showFormUser(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("user", userService.getUser(id));
            model.addAttribute("action", "edit");
        } else {
            model.addAttribute("user", new User());
            model.addAttribute("action", "create");
        }

        return "user/formUser";
    }

    @RequestMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user, @PathVariable int id) {
        userService.updateUser(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword(),
            user.getPhoneNumber()
        );

        return "redirect:/user/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }
}

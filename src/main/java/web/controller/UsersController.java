package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String usersList(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/show-user")
    public String showUser(@RequestParam(name = "id") int id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUserById(id));
        return "showUser";
    }


    @GetMapping("/new")
    public String showFormForAddUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/get-user")
    public String getUser(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

}

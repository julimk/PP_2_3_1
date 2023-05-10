package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import web.model.User;
import web.service.UserService;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getStartPage(Model model) {
        model.addAttribute("titleText", "CRUD-Операции");
        model.addAttribute("H1_Text", "Работа с базами данных");

        return "home";
    }

    @GetMapping("/users")
    public String getAllUsersPage(Model model) {
        model.addAttribute("titleText", "CRUD-Операции");
        model.addAttribute("H1_Text", "Список пользователей");
        model.addAttribute("users", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/user/create")
    public String getNewUserPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("titleText", "Добавление");
        model.addAttribute("H1", "Добавление нового пользователя");

        return "create";
    }

    @PostMapping("/user/create")
    public String createNewUser(Model model, @ModelAttribute("user") User user) {
        userService.saveUser(user);
        model.addAttribute("users", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/user/delete")
    public String getDeleteUserPage(Model model) {
        model.addAttribute("titleText", "Удаление");
        model.addAttribute("H1", "Удаление пользователя по ID");

        return "delete";
    }

    @PostMapping("/user/delete")
    public String deleteUser(Model model, @RequestParam("id") Long id) {
        userService.deleteUser(id);
        model.addAttribute("users", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/user/update")
    public String getUpdateUserPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("titleText", "Обновление");
        model.addAttribute("H1", "Обновление пользователя по ID");

        return "update";
    }

    @PostMapping("/user/update")
    public String updateUser(Model model, @ModelAttribute("user") User user) {
        userService.updateUser(user);
        model.addAttribute("users", userService.getAllUsers());

        return "users";
    }
}

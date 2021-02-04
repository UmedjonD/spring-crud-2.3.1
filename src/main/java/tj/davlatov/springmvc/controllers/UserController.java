package tj.davlatov.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tj.davlatov.springmvc.dao.UserDaoImpl;
import tj.davlatov.springmvc.models.User;
import tj.davlatov.springmvc.service.UserService;
import tj.davlatov.springmvc.service.UserServiceImpl;

import javax.validation.Valid;


@Controller
@RequestMapping("/page")
public class UserController {

    private final UserService userDAO;

    @Autowired
    public UserController(UserService userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDAO.index());
        return "page/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.show(id));
        return "page/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "page/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userDAO.save(user);
        return "redirect:/page";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDAO.show(id));
        return "page/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDAO.update(id, user);
        return "redirect:/page";
    }


    @DeleteMapping("/{id}")
    public  String delete(@PathVariable("id") int id) {
        userDAO.delete(id);
        return "redirect:/page";
    }

}

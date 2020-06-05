package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model, @ModelAttribute User user) {
//        model.addAttribute("users", UserData.getAll());

        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if(user.getPassword().equals(verify)) {
          //model.addAttribute(new User());
            model.addAttribute("users", UserData.getAll());
            UserData.addUser(user);
            return "user/index";
        }

        model.addAttribute("errorMsg", "Passwords are not a match");
        return "user/add";
    }

    @GetMapping("/{userId}")
    public String getUserProfile(Model model, @PathVariable int userId) {
        model.addAttribute("aUser", UserData.getById(userId));
        return "user/userProfile";
    }


}

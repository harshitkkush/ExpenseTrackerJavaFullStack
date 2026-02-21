package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entities.Expense;
import com.backend.entities.User;
import com.backend.services.ExpenseService;
import com.backend.services.UserService;

@RestController
@CrossOrigin()
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ExpenseService expenseService;

    @PostMapping("/register")
    public User add(@RequestBody User user) {
        System.out.println(user);

        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        // ... login logic
        System.out.println(user.toString());
        User foundUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (foundUser != null) {
            // Successful login
            System.out.println("user found!! :" + foundUser);
            return foundUser;
        } else {
            // Invalid credential
            System.out.println("No user");
            return null;
        }
    }

    @GetMapping("/expenses")
    public List<Expense> getExpenses(@RequestParam Long user_id) {
        return expenseService.getByUserId(user_id);
    }

}

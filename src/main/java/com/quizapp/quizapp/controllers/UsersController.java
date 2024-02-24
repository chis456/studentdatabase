package com.quizapp.quizapp.controllers;

import java.util.List;
import java.util.Map;

import com.quizapp.quizapp.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UsersController {
    
    @Autowired
    private UserRepository userRepo;

    @GetMapping("users/view")

    public String getAllUsers(Model model) 
    {
        System.out.println("Getting all users");

        //TDODO GET ALL UESR FRFOM DATABASE!!!

        List<User> users = userRepo.findAll();
        for(int i = 0; i < users.size(); i++)
        {
            System.out.println(users.get(i).getName());
        }

        model.addAttribute("us", users);
        return "users/showAll";
    }

    @PostMapping("users/add")
    public String addUser(@RequestParam Map<String, String> newUser, HttpServletResponse response)
    {
        System.out.println("add user peepe");
        String newName = newUser.get("name");
        int newWeight = Integer.parseInt(newUser.get("weight"));
        int newHeight = Integer.parseInt(newUser.get("height"));
        String newHColour = newUser.get("hColour");
        double newGPA = Double.parseDouble(newUser.get("gpa"));

        userRepo.save(new User(newName, newWeight, newHeight, newHColour, newGPA));

        response.setStatus(201);
        return "users/addedUser";
    }
    
}

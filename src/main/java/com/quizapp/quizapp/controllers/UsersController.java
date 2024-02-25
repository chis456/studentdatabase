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
        double newGPA = Double.parseDouble(newUser.get("gpa"));
        String newHColour = newUser.get("hColour");
       
        String newInternational = newUser.get("international");

        userRepo.save(new User(newName, newWeight, newHeight, newHColour, newGPA, newInternational));

        response.setStatus(201);
        return "users/addedUser";
    }
    
    @PostMapping("users/remove")
    public String removeUser(@RequestParam("uid") int uid)
    {
        System.out.println("test");
        System.out.println("removing " + uid);

        userRepo.deleteById(uid);
        return "users/addedUser";
    }
}

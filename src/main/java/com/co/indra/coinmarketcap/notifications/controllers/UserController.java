package com.co.indra.coinmarketcap.notifications.controllers;


import com.co.indra.coinmarketcap.notifications.config.Routes;
import com.co.indra.coinmarketcap.notifications.model.entities.Users;
import com.co.indra.coinmarketcap.notifications.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.NOTIFICATION_USER_PATH)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void registerUser(@RequestBody Users user){
        userService.registerUser(user);
    }

    @GetMapping(Routes.NOTIFICATION_USER_GETALL)
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(Routes.NOTIFICATION_USER_PATH_PARAM)
    public List<Users> getUserById(
            @PathVariable("userId") String userId){
            return userService.getUserById(userId);
    }


}

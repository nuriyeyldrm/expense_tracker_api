package com.expensetracker.resources;

import com.expensetracker.domain.Users;
import com.expensetracker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
@AllArgsConstructor
public class UserResource {

    public UserService userService;

    @PostMapping
    public String register(@RequestBody Users users){
        return userService.register(users);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return userService.confirmToken(token);
    }
}

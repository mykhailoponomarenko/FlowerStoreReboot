package ua.edu.ucu.apps.lab8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.edu.ucu.apps.lab8.model.AppUser;
import ua.edu.ucu.apps.lab8.service.AppUserService;



@RestController
@RequestMapping("/api/v1")
public class AppUserController {
    private AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/user")
    public List<AppUser> get() {
        return appUserService.getUsers();
    }

    @PostMapping("/user")
    public AppUser createAppUser(@RequestBody AppUser appUser) {
        return appUserService.createUser(appUser);
    }

    @GetMapping("/user/email")
    public ResponseEntity<AppUser> getuserByEmail(@RequestParam String email) {
        AppUser userByEmail = appUserService.getuserByEmail(email);
        if (userByEmail != null) {
            return ResponseEntity.ok(userByEmail);
        }
        return ResponseEntity.notFound().build();
    }

}
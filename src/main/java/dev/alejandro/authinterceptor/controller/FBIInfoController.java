package dev.alejandro.authinterceptor.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/fbi")
public class FBIInfoController {

    @GetMapping("/public")
    public Map<String, String> foo(HttpServletRequest request) {
        return Map.of("message", "Summer is very hot");
    }

    @GetMapping("/secret")
    public Map<String, String> faa(HttpServletRequest request) {
        return Map.of("message", "Martians are among as");
    }
}

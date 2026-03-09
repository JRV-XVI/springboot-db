
package com.springboot.db.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.db.controller.TestDBController;
import com.springboot.db.service.FirebaseService;

@RestController
public class TestDBController {
    private final FirebaseService firebaseService;

    public TestDBController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @GetMapping("/firebase-test")
    public String testFirebase() {

        firebaseService.guardarDato();
        return "Dato enviado a Firebase";
    }
}

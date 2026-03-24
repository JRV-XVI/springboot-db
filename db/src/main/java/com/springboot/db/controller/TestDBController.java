
package com.springboot.db.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.db.controller.TestDBController;
import com.springboot.db.service.FirebaseService;

import java.util.Random;

@RestController
public class TestDBController {
    private final FirebaseService firebaseService;
    private final Random random = new Random();

    public TestDBController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @GetMapping("/firebase-test")
    public String testFirebase() {

        System.out.println("Holaaaaa");
        firebaseService.guardarDato();

        
        //pruebas de actualizar vidas de pokemones
        int vida1 = random.nextInt(100);
        int vida2 = random.nextInt(100);
        System.out.println("Actualizando vidas: " + vida1 + " y " + vida2);
        firebaseService.actualizarVidas(vida1, vida2);

        return "Dato enviado a Firebase";
    }
}

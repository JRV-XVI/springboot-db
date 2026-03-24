package com.springboot.db.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {

    public String guardarDato() {

        try {

            // obtener instancia de Firestore
            Firestore db = FirestoreClient.getFirestore();

            // datos a guardar
            Map<String, Object> data = new HashMap<>();
            data.put("mensaje", "Conexion exitosa con Firestore");
            data.put("estado", "ok");

            // guardar en colección
            db.collection("test")
                .document("doc1")
                .set(data);

            return "Datos guardados correctamente";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al guardar datos";
        }
    }


    // Obtener datos de Pokemones de Firestore
    public Map<String, Object> obtenerVidas() {
        try {
            Firestore db = FirestoreClient.getFirestore();
            Map<String, Object> data = db.collection("test")
                .document("doc1")
                .get()
                .get()
                .getData();

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Actualizar vidas de Pokemones en Firestore
    public void actualizarVidas(int vida1, int vida2) {
        try {
            Firestore db = FirestoreClient.getFirestore();
            Map<String, Object> datapok = new HashMap<>();
            datapok.put("vida1", vida1);
            datapok.put("vida2", vida2);

            db.collection("pokemon")
                .document("12345")
                .set(datapok);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



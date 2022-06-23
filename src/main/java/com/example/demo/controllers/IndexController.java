package com.example.demo.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ch.qos.logback.classic.Logger;

import java.util.Map;

import static org.apache.logging.slf4j.SLF4JLoggerContextFactory.LOGGER;

@Controller

public class IndexController {
    //  Ejercicio 8
    //  1
    @RequestMapping("/hola")
    public String index() {
        return "index.html";
    }

    //  Ejercicio 8
    //  2
    @ResponseBody
    @RequestMapping("/ejercicio82")
    public TextToJson ejercicio82() {
        return new TextToJson("Ejercicio", "8-2");
    }

    //  Ejercicio 8
    //  4
    //  whitelabel.enabled = false

    //  Ejercicio 8
    //  5
    //  mvn spring-boot:run

    //  Ejercicio 8
    //  6
    //  mvn dependency:tree


    //  Ejercicio 9
    //  1
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/salut")
    public String salut() {
        return "salut";
    }

    //  Ejercicio 10
    //  1

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome(@RequestParam String name) {
        return "Welcome " + name;
    }
    // http://localhost:8080/welcome?name=hector

    //  Ejercicio 10
    //  2

    @GetMapping("/welcome2")
    @ResponseBody
    public TextToJson welcome2(@RequestParam String name, String surname) {
        TextToJson welcome2 = new TextToJson(name, surname);
        return welcome2;
    }
    // http://localhost:8080/welcome2?name=hector&surname=marcos

    //  Ejercicio 10
    //  3

    @GetMapping("/welcome3")
    @ResponseBody
    public TextToJson welcome3
            (@RequestParam(name="name", required = false, defaultValue = "EMPTY") String name, @RequestParam(name="surname", required = false, defaultValue = "EMPTY") String surname) {
        TextToJson welcome3 = new TextToJson(name, surname);
        return welcome3;
    }
    // http://localhost:8080/welcome3?name=hector&surname=marcos

    //  Ejercicio 11
    //  1
    @GetMapping("/ejercicio11")
    @ResponseBody
    public String updateFoos(@RequestParam Map<String,String> allParams){

        if(!allParams.isEmpty()){
            return "Params are " + allParams.entrySet();
            for (int i = 0; i < allParams.size(); i++) {

                    LOGGER.info("This is message 1");
                //TODO por aqui voy

            }
        }else{
            return "La zona de paramtro esta vacia! No has enviado nada!";
        }
    }
    // http://localhost:8080/ejercicio11?name=hector&surname=marcos

}

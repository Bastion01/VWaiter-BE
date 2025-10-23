package com.vwaiter;

import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//TODO after start implementation
@RestController
@RequestMapping("/api/v1")
public class TestApi {
    @GetMapping(path = "/hello",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloWorld(){
        HelloWorld aa = new HelloWorld("Chego podgladivaem :)");
        return aa.toString();
    }
}

@Getter
class HelloWorld {
   private static int countOfExecution;
   private String value;

    public HelloWorld(String value) {
        this.value = value;
        countOfExecution++;
    }

    @Override
    public String toString() {
        return "{" +
                "\"value\"  : \"" + value + '\"' + ',' +
                "\"countOfExecution\" : \"" + countOfExecution + '\"' +
                '}';
    }
}

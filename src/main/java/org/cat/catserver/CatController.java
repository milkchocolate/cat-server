package org.cat.catserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CatController {
    private final List<Cat> cats = new ArrayList<>();
    private int counter = 0;

    public CatController() {
        cats.add(new Cat("white"));
        cats.add(new Cat("black"));
    }

    @GetMapping("/counter")
    public int getCounter() {
        counter++;
        System.out.println(counter);
        return counter;
    }

    @GetMapping("/cats")
    public List<Cat> getCats() {
        return cats;
    }

    @PostMapping("/cats")
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat) {
        cats.add(cat);
        return ResponseEntity.created(URI.create("?")).body(cat);
    }

    @GetMapping("/headers")
    public Map<String, String> getCats(@RequestHeader Map<String, String> headers) {
        return headers;
    }
}

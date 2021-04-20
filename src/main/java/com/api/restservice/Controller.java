package com.api.restservice;
import java.util.concurrent.atomic.AtomicLong;

import com.api.restservice.modele.Building;
import com.api.restservice.modele.Exploitation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller{

//     // @GetMapping("/cgu")
//     // public void cgu(){
//     //     return 0;
//     // }

    private final AtomicLong counter = new AtomicLong();    

    @PostMapping("/exploitation")
    public ResponseEntity<Void> exploitation(@RequestBody Exploitation exploitation){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/building")
    public ResponseEntity<Void> building(@RequestBody Building building){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/charge")
    public Building building(@RequestParam String name){
        return new Building(counter.incrementAndGet(), name);
    }

    @PostMapping("/employee")
    public Employee employee(@RequestParam String name){
        return new Employee(counter.incrementAndGet(), name);
    }

    @PostMapping("/employee")
    public Employee employee(@RequestParam String name){
        return new Employee(counter.incrementAndGet(), name);
    }
//     // @PostMapping("/employee")
//     // public void 




    


 }
package com.saha.amit.controller;

import com.saha.amit.dto.Response;
import com.saha.amit.service.GetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("getAPI")
public class GetController {

    @Autowired
    private GetService getService;



    @GetMapping(value = "/public/test")    //Can also use @GetMapping(value = "public/test")
    public ResponseEntity<String> test() {
        //http://localhost:8080/mainService/getAPI/public/test2
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("hello2");
    }

    @GetMapping(value = "/table/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> getMultiplicationTableStream(@PathVariable int input) {
        //http://localhost:8080/mainService/getAPI/table/5/stream
        return getService.getMultiplicationTable(input);
    }

    @GetMapping(value = "a_plus_b_wholeSquare/{a}/{b}")
    public Mono<Response> a_plus_b_wholeSquare(@PathVariable int a,@PathVariable int b) {
        //http://localhost:8080/mainService/getAPI/a_plus_b_wholeSquare/5/6
        return getService.a_plus_b_wholeSquare(a, b);
    }

    @GetMapping(value = "addAndGenerateTable",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> addAndGenerateTable(@RequestParam int a, @RequestParam int b){
        return getService.addAndGenerateTable(a,b);
    }




}

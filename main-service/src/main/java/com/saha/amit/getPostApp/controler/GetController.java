package com.saha.amit.getPostApp.controler;

import com.saha.amit.getPostApp.dto.ErrorResponse;
import com.saha.amit.getPostApp.dto.Response;
import com.saha.amit.getPostApp.exception.CustomException;
import com.saha.amit.getPostApp.service.GetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("getAPI")
public class GetController {

    @Autowired
    private GetService getService;


    @GetMapping(value = "/public/test")    //Can also use @GetMapping(value = "public/test")
    public ResponseEntity<String> test() {
        //http://localhost:8080/mainService/getAPI/public/test
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("hello");
    }

    @GetMapping(value = "/singlePathVariableStream/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> singlePathVariableStream(@PathVariable int input) {
        //http://localhost:8080/mainService/getAPI/table/5/stream
        return getService.getMultiplicationTable(input);
    }

    @GetMapping(value = "multiplePathVariable/{a}/{b}")
    public Mono<Response> multiplePathVariable(@PathVariable int a,@PathVariable int b) {
        //http://localhost:8080/mainService/getAPI/a_plus_b_wholeSquare/5/6
        return getService.a_plus_b_wholeSquare(a, b);
    }

    @GetMapping(value = "multipleRequestParamStream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> multipleRequestParamStream(@RequestParam int a, @RequestParam int b){
        //http://localhost:8080/mainService/getAPI/addAndGenerateTable?a=5&b=6
        return getService.addAndGenerateTable(a,b);
    }

    @GetMapping("/requiredFalse")
    @ResponseBody
    public String requiredFalse(@RequestParam(required = false) String id) {
        //http://localhost:8080/mainService/getAPI/requiredFalse?id=7
        //http://localhost:8080/mainService/getAPI/requiredFalse
        return "ID: " + id;
    }

    @GetMapping("/optionalParam/{id}")
    @ResponseBody
    public String optionalParam(@RequestParam Optional<String> id){
        //http://localhost:8080/mainService/getAPI/optionalParam?id=7
        //http://localhost:8080/mainService/getAPI/optionalParam
        return "ID: " + id.orElseGet(() -> "not provided");
    }

    @GetMapping("/defaultValue")
    @ResponseBody
    public String defaultValue(@RequestParam(defaultValue = "test") String id) {
        //http://localhost:8080/mainService/getAPI/optionalParam
        return "ID: " + id;
    }

    @GetMapping(value = "exception/{a}")
    public ResponseEntity exception(@PathVariable int a){
        //http://localhost:8080/mainService/getAPI/exception/7
        if (a%2 ==0 )
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("ok");
        else
            throw new CustomException("Odd values not accepted");
    }

//    @ExceptionHandler
//    public ResponseEntity<ErrorResponse> handelException(CustomException customException){
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setMessage(customException.getMessage());
//        errorResponse.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
//        errorResponse.setTimeStamp(System.currentTimeMillis());
//
//        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);
//
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<ErrorResponse> handelException2(RuntimeException exception){
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setMessage(exception.getMessage());
//        errorResponse.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
//        errorResponse.setTimeStamp(System.currentTimeMillis());
//
//        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);
//
//    }
}

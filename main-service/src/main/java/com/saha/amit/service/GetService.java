package com.saha.amit.service;

import com.saha.amit.dto.Response;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class GetService {

    public Flux<Response> getMultiplicationTable(int n){
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> new Response(i*n));
    }

    public Mono<Response> a_plus_b_wholeSquare(int a, int b){
        return Mono.just(new Response(a*a +b*b+ 2*a*b));
    }

    public Flux<Response> addAndGenerateTable(int a, int b){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> new Response(i*(a+b)));
    }
}

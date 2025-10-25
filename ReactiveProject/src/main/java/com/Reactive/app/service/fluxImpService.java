package com.Reactive.app.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class fluxImpService {

    public Flux<String> impFlux(){

        Flux<String> stringFlux = Flux.just("deepak","gupta","sumit","ashish");
        Flux<String> flux = stringFlux.filter(data->data.startsWith("g"));
        Flux<String> stringFlux1 = stringFlux.flatMap(name->Flux.just(name.split(" ")));
        return stringFlux1;

            }

    public Flux<String> concateFlux(){

        Flux<String> stringFlux = Flux.just("deepak","gupta","sumit","ashish");
        Flux<String> stringFlux2 = Flux.just("gupta", "deepak", "Panday","Bhasker");

        Flux<String> concateFlux = stringFlux.concatWith(stringFlux2);
        return concateFlux;
    }

}

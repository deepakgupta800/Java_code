package com.Reactive.app;

import com.Reactive.app.repository.BookRepository;
import com.Reactive.app.service.fluxImpService;
import io.micrometer.observation.annotation.Observed;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

import java.util.Observable;

@SpringBootTest
class ReactiveProjectApplicationTests {

	@Autowired
	BookRepository bookRepository;

//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	void WorkingWithMono() {
//
//		{
////			Mono<String> m1 = Mono
////					.just("Hello World")
////					.log();
////
////			m1.subscribe(data->{
////
////				System.out.println("Data is" + " " + data);
////
////			});
//
//			Mono<String> m1 = Mono.just("Hello");
//			Mono<String> m2 = Mono.just("World");
//
//			Mono<Tuple2<String, String>> combined = Mono.zip(m1,m2);
//
//			combined.subscribe(data -> {
//				System.out.println(data.getT1());
//				System.out.println(data.getT2());
//			});
//		}
//	}

	@Autowired
	fluxImpService service;

	@Test
	void createTest(){

		Flux<String> stringFlux = service.impFlux();
//		stringFlux.subscribe(data->{
//			System.out.println(data);
//		});

		StepVerifier.create(stringFlux)
				.expectNext("deepak","gupta","sumit","ashish")
				.verifyComplete();
	}

	@Test
	void createTest2() {

		Flux<String> stringFlux = service.concateFlux();
//		stringFlux.subscribe(data->{
//			System.out.println(data);
//		});


		StepVerifier.create(stringFlux)
				.expectNextCount(8)
				.verifyComplete();
	}
//	@Test
//	public void queryMethodeTest(){
//      bookRepository.getAllBooksByAuthor("CRICKET")
//			  .as(StepVerifier::create)
//			  .	expectNextCount(1)
//			  .verifyComplete();
//	}

	@Test
	public void queryMethodeTest2(){
		StepVerifier.create(bookRepository.searchByName("c"))
				.expectNextCount(1)  // or however many match (likely 3 in your case)
				.expectComplete()
				.verify();
	}

	@Test
	public void emitTenInt(){
		Flux<Integer> num = Flux.range(1, 10);
		num.subscribe(System.out::println);
	}

	@Test
	public void emit(){
		Observable<String> stream1 = Observable.just("A", "B", "C");
	}


}

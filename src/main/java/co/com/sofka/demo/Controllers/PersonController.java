package co.com.sofka.demo.Controllers;

import java.util.List;

import co.com.sofka.demo.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.demo.Models.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public Mono<Void> post(@RequestBody Mono<Person> personMono){
        return personMono.flatMap(service::insert);
    } 
    
    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable("id") String id) {
        return Mono.just(new Person());        
    }

    @PutMapping
    public Mono<Void> update(@RequestBody Mono<Person> personMono) {
        return Mono.empty();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return Mono.empty();
    }

    @GetMapping
    public Flux<Person> list(){
//        var persons = List.of(
//            new Person("Raul Alzate"),
//            new Person("Pedro")
//        );
//        return Flux.fromStream(persons.stream());
        return service.listAll();
    }
    
}

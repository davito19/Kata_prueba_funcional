package co.com.sofka.demo.Repositories;

import co.com.sofka.demo.Models.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {

    Mono<Person> findByName(String name);
}

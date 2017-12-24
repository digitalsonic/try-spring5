package me.digitalsonic.tryspring5;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReactiveBookRepository extends ReactiveCrudRepository<Book, Long> {
}

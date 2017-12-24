package me.digitalsonic.tryspring5;

import org.springframework.data.repository.CrudRepository;

public interface StandardBookRepository extends CrudRepository<Book, String> {
}

package walter.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import walter.springframework.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}

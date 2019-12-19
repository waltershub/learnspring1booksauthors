package walter.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import walter.springframework.spring5webapp.model.Author;
import walter.springframework.spring5webapp.model.Book;
import walter.springframework.spring5webapp.model.Publisher;
import walter.springframework.spring5webapp.repositories.AuthorRepository;
import walter.springframework.spring5webapp.repositories.BookRepository;
import walter.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper Collins" , "1221 east 22 brooklyn NY ");
        Book ddd = new Book("Domain Driven Design", "1234",harperCollins);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        publisherRepository.save(harperCollins);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher wrox = new Publisher("Wrox" , "50 east 22 brooklyn NY");
        Book noEJB = new Book("J2EE Development without EJB", "23444",wrox);

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(wrox);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}

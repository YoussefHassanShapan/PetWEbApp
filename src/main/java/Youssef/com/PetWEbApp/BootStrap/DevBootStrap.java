package Youssef.com.PetWEbApp.BootStrap;

import Youssef.com.PetWEbApp.Models.Author;
import Youssef.com.PetWEbApp.Models.Book;
import Youssef.com.PetWEbApp.Models.Publisher;
import Youssef.com.PetWEbApp.Repositories.AuthorRepository;
import Youssef.com.PetWEbApp.Repositories.BookRepository;
import Youssef.com.PetWEbApp.Repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    private  void  initData(){
        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisher.setAddress("23 Maadi ,Ammar Ibn yaser");
        publisherRepository.save(publisher);
//Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Wrox" );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
this.initData();
    }
}



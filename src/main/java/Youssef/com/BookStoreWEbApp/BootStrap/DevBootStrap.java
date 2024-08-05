package Youssef.com.BookStoreWEbApp.BootStrap;

import Youssef.com.BookStoreWEbApp.Models.Author;
import Youssef.com.BookStoreWEbApp.Models.Book;
import Youssef.com.BookStoreWEbApp.Models.Publisher;
import Youssef.com.BookStoreWEbApp.Repositories.AuthorRepository;
import Youssef.com.BookStoreWEbApp.Repositories.BookRepository;
import Youssef.com.BookStoreWEbApp.Repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    public DevBootStrap(AuthorRepository authorRepository,
                        BookRepository bookRepository,
                        PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    private  void  initData(){
        try {

            Publisher publisher = new Publisher();
            publisher.setName("foo");
            publisher.setAddress("23 Maadi ,Ammar Ibn yaser");
            publisherRepository.save(publisher);

            //Eric
            Book ddd = new Book("Domain Driven Design", "1234", publisher);
            bookRepository.save(ddd);
            Author eric = new Author("Eric", "Evans");
            ddd.getAuthors().add(eric);
            eric.getBooks().add(ddd);
            authorRepository.save(eric);

            //Rod
            Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
            Author rod = new Author("Rod", "Johnson");
            noEJB.getAuthors().add(rod);
            bookRepository.save(noEJB);
            rod.getBooks().add(noEJB);
            authorRepository.save(rod);
        }
        catch (Exception ex){

        }
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
this.initData();
    }
}



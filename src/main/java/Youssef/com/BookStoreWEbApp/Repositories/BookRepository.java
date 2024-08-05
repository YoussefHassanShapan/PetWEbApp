package Youssef.com.BookStoreWEbApp.Repositories;

import Youssef.com.BookStoreWEbApp.Models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}

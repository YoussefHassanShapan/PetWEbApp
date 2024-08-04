package Youssef.com.PetWEbApp.Repositories;

import Youssef.com.PetWEbApp.Models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}

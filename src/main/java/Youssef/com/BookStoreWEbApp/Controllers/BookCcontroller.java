package Youssef.com.BookStoreWEbApp.Controllers;

import Youssef.com.BookStoreWEbApp.Repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookCcontroller {
    private BookRepository bookRepository;

    public BookCcontroller(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
    return  "books";
    }
}

package com.example.axsos.spring.bookapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.axsos.spring.bookapi.model.Book;
import com.example.axsos.spring.bookapi.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	
	public List<Book> allBooks() {
        return bookRepository.findAll();
    }
	
	public Book createBook(Book b) {
        return bookRepository.save(b);
    }
	
	public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
    // to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			bookRepository.deleteById(id);
		}
	}
}


package com.example.axsos.login.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.axsos.login.models.Book;
import com.example.axsos.login.repositories.BookRepository;
@Service
public class BookService {
		private final BookRepository bookrepository;

		public BookService(BookRepository bookrepository) {
			this.bookrepository = bookrepository;
		}
		public List<Book> allbooks(){
			return bookrepository.findAll();
		}
		
		public Book createBook(Book a) {
			return bookrepository.save(a);
		}
		
		 public Book findBook(Long id) {
		        Optional<Book> optionalBook = bookrepository.findById(id);
		        if(optionalBook.isPresent()) {
		            return optionalBook.get();
		        } else {
		            return null;
		        }
		    }
		
		 public Book updateBook(Book b) {
				return this.bookrepository.save(b);
				
			}
		 
		 public void deleteBook(Long id) {
			 bookrepository.deleteById(id);
		 }
		 
	}

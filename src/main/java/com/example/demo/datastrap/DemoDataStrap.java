package com.example.demo.datastrap;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoDataStrap implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public DemoDataStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author author = new Author("Eric", "Smith");
        Book book = new Book("The Book", "The Book");

        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        Book book2 = new Book("The Book2", "The Book2");
        Author author2 = new Author("Eric2", "Smith2");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Started in DemoDataStrap");
        System.out.println("Book count: " + bookRepository.count());

        Publisher publisher = new Publisher("The Publisher", "The Publisher", "The Publisher", "The Publisher", 3);

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());
        System.out.println("Author count: " + authorRepository.count());
    }
}

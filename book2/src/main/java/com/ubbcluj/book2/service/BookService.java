package com.ubbcluj.book2.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.ubbcluj.book2.domain.Book;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class BookService {
    private List<Book> books=new ArrayList<>(Arrays.asList(new Book("Mistborn","Brandon Sanderson",10),
            new Book("Harry Potter","J.K. Rowling",10),
            new Book("A Study in Drowning","Ava Reid",10),
            new Book("Lord of the Rings","J.R.R. Tolkien",10),
            new Book("The Trial","Franz Kafka",10)));

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBookByTitle(String title) throws IOException, TimeoutException {
        List<Book> bookList=new ArrayList<>();
        for(Book b:books){
            if(title.equalsIgnoreCase(b.getTitle())){
                //rabbit mq; anytime a book is called by title, also its reviews will be shown
                try {
                    ConnectionFactory factory = new ConnectionFactory();
                    factory.setHost(System.getenv("RABBITMQ_URI"));
                    factory.setPort(5672);
                    Connection connection = factory.newConnection();
                    Channel channel = connection.createChannel();
                    channel.queueDeclare("book_queue", false, false, false, null);
                    String message = b.toString();
                    channel.basicPublish("", "book_queue", null, message.getBytes());
                    System.out.println("Producer generated: " + message);
                    channel.close();
                    connection.close();
                }catch(Exception e){
                    System.out.println("connection failed" +e);
                }
                bookList.add(b);
            }
        }
        return bookList;
    }

    public void borrowBook(String title){
        for(Book b:books){
            if(title.equalsIgnoreCase(b.getTitle())){
                b.setNumberOfProducts(b.getNumberOfProducts()-1);
                break;
            }
        }
    }
}

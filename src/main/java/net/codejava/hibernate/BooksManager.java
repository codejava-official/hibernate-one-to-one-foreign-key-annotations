package net.codejava.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * This program demonstrates using Hibernate framework to manage
 * a one-to-one mapping with foreign key using annotations. 
 * @author www.codejava.net
 *
 */
public class BooksManager {

	public static void main(String[] args) {
		
		// loads configuration and mappings
		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
		
		// builds a session factory from the service registry
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		// obtains the session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// creates a Book entity
		Book newBook = new Book();
		newBook.setTitle("Hibernate Made Easy");
		newBook.setDescription("Simplified Data Persistence with Hibernate and JPA");
		newBook.setPublishedDate(new Date());
		
		newBook.setAuthor(new Author("Cameron Wallace McKenzie", "Cameron@gmail.com"));
		
		// persists the book entity
		Long bookId = (Long) session.save(newBook);
		
		// gets the book entity back
		Book book = (Book) session.get(Book.class, bookId);
		System.out.println("Book's Title: " + book.getTitle());
		System.out.println("Book's Description: " + book.getTitle());
		
		Author author = book.getAuthor();
		System.out.println("Author's Name: " + author.getName());
		System.out.println("Author's Email: " + author.getEmail());
		
		session.getTransaction().commit();
		session.close();		
	}
}
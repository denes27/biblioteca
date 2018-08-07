package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitys.Livro;


public class LivroDao {
	
	public void insertLivro(Livro livro) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("sistemabancariohibernate");
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(livro);
			manager.getTransaction().commit();
		} finally {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		manager.close();
		factory.close();
	}
	
	
	public void removeLivro(Livro livro) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AcervoDB");

		EntityManager manager = factory.createEntityManager();

		livro = manager.find(Livro.class, livro.get_id());
		try {
			manager.getTransaction().begin();
			manager.remove(livro);
			manager.getTransaction().commit();
		} finally {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		manager.close();
		factory.close();
	}
}

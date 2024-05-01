package br.com.fiap.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.CategoriaModel;

//NÃO USAR O LOAD, USAR APENAS O CREATEQUERY

@Repository
public class CategoriaRepository  {

	private static final String FIND_ALL = "SELECT * FROM TB_CATEGORIA";
	private static final String FIND_BY_ID = "SELECT * FROM TB_CATEGORIA WHERE ID_CATEGORIA = ?";
	private static final String SAVE = "INSERT INTO TB_CATEGORIA (NOME_CATEGORIA) VALUES (?)";
	private static final String UPDATE = "UPDATE TB_CATEGORIA SET NOME_CATEGORIA = ? WHERE ID_CATEGORIA = ?";
	private static final String DELETE_BY_ID = "DELETE FROM TB_CATEGORIA WHERE ID_CATEGORIA = ?";

	private Session session;
	private Transaction tx;

	public CategoriaRepository() {
	}

	public List<CategoriaModel> findAll()  {
		List<CategoriaModel> retorno = null;
		try {
			startOperation();
			Query<CategoriaModel> query = session.createQuery("FROM CategoriaModel");
			retorno = query.list();
			tx.commit();
			
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>Erro no FindAll - Categorias:" + e);
		} finally {
			session.close();
		}
		return retorno;
	}
	
	public CategoriaModel findById(long id) {
		CategoriaModel retorno = null;
		try {
			startOperation();
			Query<CategoriaModel> query = session.createQuery("FROM CategoriaModel WHERE idCategoria ='" + id+"'");
			retorno = query.getSingleResult();
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>>Erro no FindById - Categorias:" + e);
		} finally {
			session.close();
		}
		return retorno;
	}

	public void saveCategoria(CategoriaModel categoria) {
		try {
			startOperation();
			session.save(categoria);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("Erro no Save - Categoria");
		} finally {
			session.close();
		}
	}

	public void updateCategoria(CategoriaModel categoria) {
		try {
			startOperation();
			session.update(categoria);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("Erro no update - Categoria");
		} finally {
			session.close(); 
		}
	}

	public void startOperation() {
		Configuration cfg = new Configuration().configure();
		session = cfg.buildSessionFactory().openSession();
		System.out.println("\n >>>>>>>>>>>>>>> método startOperation > Session: " + session.toString());
		tx = session.beginTransaction();
	}

}

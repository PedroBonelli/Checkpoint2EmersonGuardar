package br.com.fiap.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.AlbumModel;

@Repository
public class AlbumRepository {

	private Session session;
	private Transaction tx;
	
	public AlbumRepository() {
		
	}
	
	public void startOperation() {
		Configuration cfg = new Configuration().configure();
		this.session = cfg.buildSessionFactory().openSession();
		System.out.println("\n >>>>>>>>>>>>>>>>>> método startOperation > Session: "+session.toString());
		this.tx = session.beginTransaction();
	}
	
	public List<AlbumModel> findAll(){
		List<AlbumModel> retorno = null;
		
		try {
			startOperation();
			Query<AlbumModel> query = session.createQuery("FROM AlbumModel");
			retorno = query.list();
			tx.commit(); 
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>> Erro no findAll - Albums" + e);
		} finally {
			this.session.close();
		}
		
		return retorno;
	}
	
	public AlbumModel findById(Long id) {
		AlbumModel retorno = null;
		
		try {
			startOperation();
			Query<AlbumModel> query = session.createQuery("FROM AlbumModel WHERE ID = '" +id+"'");
			retorno = query.getSingleResult();
			tx.commit(); 
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>> Erro no findById - Albums" + e);
		} finally {
			this.session.close();
		}
		return retorno;
	}
	
	public void saveAlbum(AlbumModel album) {
		try {
			startOperation();
			session.save(album);
			tx.commit(); 
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>>> Erro no save - Albums"+e);
		} finally {
			this.session.close();
		}
	}
	
	public void updateAlbum(AlbumModel album) {
		try {
			startOperation();
			session.update(album);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>>>>>>>>> Erro no update - Albums");
		} finally {
			session.close();
		}
	}
	
	public void deleteAlbum(AlbumModel album) {
		try {
			startOperation();
			session.delete(album);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>>>> Erro no delete - Albums");
		} finally {
			this.session.close();
		}
	}
}

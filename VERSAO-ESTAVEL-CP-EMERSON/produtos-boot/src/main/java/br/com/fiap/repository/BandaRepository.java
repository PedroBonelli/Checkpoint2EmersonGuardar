package br.com.fiap.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.BandaModel;

@Repository
public class BandaRepository {
	
	private Session session;
	private Transaction tx;
	
	public BandaRepository() {
		
	}
	
	public void startOperation() {
		Configuration cfg = new Configuration().configure();
		this.session = cfg.buildSessionFactory().openSession();
		System.out.println("\n >>>>>>>>>>> método startOperation > Session: "+session.toString());
		this.tx = session.beginTransaction();
	}
	
	public List<BandaModel> findAll() {
		List<BandaModel> retorno = null;
		
		try {
			startOperation();
			Query<BandaModel> query = session.createQuery("FROM BandaModel");
			retorno = query.list(); 
			tx.commit();
			
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>> Erro no findAll - Bandas" + e);
		} finally {
			this.session.close();
		}
		
		return retorno;
	}
	
	public BandaModel findById(Long id) {
		BandaModel retorno = null;
		try {
			startOperation();
			Query<BandaModel> query = session.createQuery("FROM BandaModel WHERE ID = '" +id+"'");
			retorno = query.getSingleResult();
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>> Erro no findById - Bandas" + e);
		} finally {
			this.session.close();
		}
		return retorno;
	}
	
	public void saveBanda(BandaModel banda) {
		try {
			startOperation();
			session.save(banda);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>>>> Erro no save - Bandas");
		} finally {
			this.session.close();
			
		}
	}
	
	public void updateBanda(BandaModel banda) {
		try {
			startOperation();
			session.update(banda);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>>>>> Erro no update - Bandas");
		} finally {
			this.session.close();
		}
	}
	
	public void deleteBanda(BandaModel banda) {
		try {
			startOperation();
			session.delete(banda);
			tx.commit(); 
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>>>>> Erro no delete - Bandas");
		} finally {
			this.session.close();
		}
	}
	
	
	
}

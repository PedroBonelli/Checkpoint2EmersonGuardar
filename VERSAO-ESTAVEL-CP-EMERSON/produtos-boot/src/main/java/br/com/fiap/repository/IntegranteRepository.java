package br.com.fiap.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.IntegranteModel;

@Repository
public class IntegranteRepository {

	private Session session;
	private Transaction tx;
	
	public IntegranteRepository() {
		
	}
	
	public void startOperation() {
		Configuration cfg = new Configuration().configure();
		this.session = cfg.buildSessionFactory().openSession();
		System.out.println("\n >>>>>>>>>>>>>> método startOperation > Session: "+session.toString());
		this.tx = session.beginTransaction();
	}
	
	public List<IntegranteModel> findAll(){
		List<IntegranteModel> retorno = null;
		
		try {
			startOperation();
			Query<IntegranteModel> query = session.createQuery("FROM IntegranteModel");
			retorno = query.list();
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>> Erro no findAll - Integrantes");
		} finally {
			this.session.close();
		}
		
		return retorno;
	}
	
	public IntegranteModel findById(Long id) {
		IntegranteModel retorno = null;
		
		try {
			startOperation();
			Query<IntegranteModel> query = session.createQuery("FROM IntegranteModel WHERE ID = '"+id+"'");
			retorno = query.getSingleResult();
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>>> Erro no findById - Integrantes");
		} finally {
			this.session.close();
		}
		
		return retorno;
	}
	
	public void saveIntegrante(IntegranteModel integrante) {
		try {
			startOperation();
			session.save(integrante);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>> Erro no save - Integrantes");
		} finally {
			this.session.close();
		}
	}
	
	public void updateIntegrante(IntegranteModel integrante) {
		try {
			startOperation();
			session.update(integrante);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>>>>> Erro no update - Integrantes");
		} finally {
			this.session.close();
		}
	}
	
	public void deleteIntegrante(IntegranteModel integrante) {
		try {
			startOperation();
			session.delete(integrante);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("\n >>>>>>>>>>>>>>>>> Erro no delete - Integrantes");
		} finally {
			this.session.close();
		}
	}
	
}

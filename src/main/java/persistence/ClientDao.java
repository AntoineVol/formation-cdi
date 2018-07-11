package persistence;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Client;

/**
 * Bean CDI déclaré avec named par le "Default" Qualifier et de scope
 * ApplicationScoped -> "singleton"
 * 
 * @author Adminl
 *
 */
@Named
@ApplicationScoped
public class ClientDao implements Serializable{

	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER=LoggerFactory.getLogger(ClientDao.class);
	private EntityManager entityManager;

	public ClientDao() {
		LOGGER.debug("Instanciation de clientDao");
		this.entityManager = HibernateUtil.getSessionFactory().createEntityManager();
	}

	public void create(Client client) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(client);
		this.entityManager.getTransaction().commit();
	}
}

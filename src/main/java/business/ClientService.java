package business;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.Client;
import persistence.ClientDao;

@Named
@ApplicationScoped
public class ClientService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private transient ClientDao clientDao;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ClientService.class); 
	
	public String createClient(String name) {
		LOGGER.debug("Appel du service Client");
		final Client client = new Client();
		client.setFirstName(name);
		this.clientDao.create(client);
		return "Client créé : " + client.getFirstName();
	}
}

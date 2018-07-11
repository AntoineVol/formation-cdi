package persistence;

public class ClientDao {
	private String test;
	
	public ClientDao() {
		this.setTest("Ceci est une phrase de test");
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}

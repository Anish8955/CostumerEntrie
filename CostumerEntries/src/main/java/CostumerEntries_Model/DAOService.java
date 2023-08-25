package CostumerEntries_Model;

import java.sql.ResultSet;

public interface DAOService {

	
	public void ConnectDB();
	
	public boolean verifyCredentials(String email ,String password);
	
	public void SaveLead(String name,String city,String productName,String price );

	public ResultSet getAllReg();

	public void deleteByName(String name);
	public void updateByName(String name, String city);

	public void savesignup(String emailid, String passwordd);

	

	
	
}

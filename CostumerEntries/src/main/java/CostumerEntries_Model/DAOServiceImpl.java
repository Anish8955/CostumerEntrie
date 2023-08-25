package CostumerEntries_Model;

import java.sql.*;

public class DAOServiceImpl implements DAOService {

	private Connection con;
	private Statement stmnt;
	
	@Override
	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"'and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void ConnectDB() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/costumerentry","root","anish8955");
        	stmnt = con.createStatement(); 		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void SaveLead(String name, String city, String productName, String price) {
		try {
			stmnt.executeUpdate("insert into newlead values('"+name+"','"+city+"','"+productName+"','"+price+"')");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	

		
	}

	@Override
	public ResultSet getAllReg() {
		try {
			ResultSet result = stmnt.executeQuery("select * from newlead");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteByName(String name) {
		try {
			stmnt.executeUpdate("delete from newlead where name ='"+name+"'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void updateByName(String name, String city) {
		try {
			stmnt.executeUpdate("update newlead set city ='"+city+"' where name = '"+name+"'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void savesignup(String emailid, String passwordd) {
		try {
			stmnt.executeUpdate("insert into login values('"+emailid+"','"+passwordd+"')");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}



}

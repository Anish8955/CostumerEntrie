package CostumerEntries_Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CostumerEntries_Model.DAOService;
import CostumerEntries_Model.DAOServiceImpl;

@WebServlet("/update")
public class update_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public update_controller() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {response.getWriter().append("Served at: ").append(request.getContextPath());
	String name = request.getParameter("name");
	String city = request.getParameter("city");
	request.setAttribute("name", name);
	request.setAttribute("city", city);
	
	  RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_registration.jsp");
	  rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("name");
	String city = request.getParameter("city");
	
	DAOService service = new DAOServiceImpl();
	service.ConnectDB();
	service.updateByName(name , city);
	
    ResultSet result = service.getAllReg();
	request.setAttribute("result", result);
    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/list_product.jsp");
	rd.forward(request, response);
	
	}

}

package CostumerEntries_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CostumerEntries_Model.DAOService;
import CostumerEntries_Model.DAOServiceImpl;

@WebServlet("/addlead")
public class addproduct_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public addproduct_controller() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {response.getWriter().append("Served at: ").append(request.getContextPath());
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/NewLead.jsp");
	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 try {
		HttpSession session = request.getSession(false);
		
		   if(request.getAttribute("email")==null) {

			 String name = request.getParameter("customerName");
			 String city  = request.getParameter("city");
			 String productName = request.getParameter("productName");
			 String price = request.getParameter("price");
			 
			 DAOService service = new DAOServiceImpl();
			 service.ConnectDB();
			 
			 service.SaveLead(name , city, productName, price);
			 request.setAttribute("msg", "Record is save");
			    
			    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/NewLead.jsp");
			    rd.forward(request, response);
		} else {
			 RequestDispatcher rd = request.getRequestDispatcher("OwnerLogin.jsp");
			  rd.forward(request, response);
		}
	} catch (Exception e) {
		 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		  rd.forward(request, response);
	}
	
	 
	}

}

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

@WebServlet("/VerifyLogin")
public class OwnerLogin_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public OwnerLogin_Controller() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);
	  String email = request.getParameter("email");
	  String password = request.getParameter("password");
	  
	  DAOService service = new DAOServiceImpl();
	  service.ConnectDB();
	  
	  boolean status = service.verifyCredentials(email, password);
	
	  if (status==true) {
		  HttpSession session = request.getSession(true);
		session.setAttribute("email", email);
		  RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/NewLead.jsp");
		  rd.forward(request, response);
		  
	} else {
		request.setAttribute("error","invalid email/password");
		RequestDispatcher rd = request.getRequestDispatcher("OwnerLogin.jsp");
        rd.forward(request, response);
	}
	
	}

}

package CostumerEntries_Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public logout_controller() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 HttpSession session = request.getSession(false);
		  session.invalidate();
		  
		  RequestDispatcher rd = request.getRequestDispatcher("OwnerLogin.jsp");
		  rd.forward(request, response);
	}

}

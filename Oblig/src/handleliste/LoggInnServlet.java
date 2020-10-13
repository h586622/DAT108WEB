package handleliste;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logginn")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*	PrintWriter out = response.getWriter();
		
		String passord = (String) request.getSession().getAttribute("passord");
		
		String servleturl = "http://localhost:8080/Oblig/handle";
		
		if (passord.equals("Pa55ord")){
			response.sendRedirect(servleturl);
		} else {
			out.print("Feil passord"); */
	//	}
				
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String passord = request.getParameter("passord");
		PrintWriter out = response.getWriter();
		if (passord.equals("Pa55ord")){
		
		request.getSession().setAttribute("handle", passord);		
		response.sendRedirect("handle");
		}  else {
			out.print("Feil passord");
		}
		
		

	}

}

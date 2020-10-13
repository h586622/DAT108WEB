package handleliste;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "handle", urlPatterns = { "/handle" })
public class HandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private HandleListe handleliste = new HandleListe();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		String handling = (String) request.getSession().getAttribute("handling");
		String vare = (String) request.getSession().getAttribute("vare");	
		
		System.out.println(handling + " " +vare);
		
		if (handling != null && vare != null) {
		
		if (handling.equals("Legg til")) {
			handleliste.addItem(vare);
		} else if (handling.equals("Slett")) {
			handleliste.slettItem(vare);
		}}
		
		
        List<String> strings = handleliste.getItems();	
		
        response.setContentType("text/html; charset=ISO-8859-1");

        java.io.PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Handlelisten</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Min handleliste </h1>");
        out.println("<form action=\"" + "handle" + "\" method=\"post\">");
        out.println("<p><input type=\"submit\" value=\"Legg til\" /> Legg til vare: <input type=\"text\" name=\"vare\" /><input type=\"hidden\" name=\"handling\"</p>");
        out.println("</form>");
        
        if (strings != null) {
        
        for (String s : strings) {
        	out.println("<form action=\"" + "handle" + "\" method=\"post\">");
        	out.println("<input type=\"submit\" value=\"Slett\" />");
        	out.println("<input type=\"hidden\" name=\"handling\" />");
        	out.println(s + "</br></br>");
        	out.println("</form>");
        }
        }
        
        out.println("<p>" +  "</p>");
        out.println("</body>");
        out.println("</html>");
		
		

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String input = request.getParameter("handling");	
		String vare = request.getParameter("vare");
		request.getSession().setAttribute("handling", input);	
		request.getSession().setAttribute("vare", vare);
		response.sendRedirect("handle");
		
		
		
		
		
	}

}

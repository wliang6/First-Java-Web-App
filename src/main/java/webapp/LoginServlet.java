
// * Browser sends Http Request to Web Server
// * 
// * Code in Web Server => Input:HttpRequest, Output: HttpResponse
// * JEE with Servlets
// * 
// * Web Server responds with Http Response
// */
//
////Java Platform, Enterprise Edition (Java EE) JEE6
//
////Servlet is a Java programming language class 
////used to extend the capabilities of servers 
////that host applications accessed by means of 
////a request-response programming model.
//
////1. extends javax.servlet.http.HttpServlet
////2. @WebServlet(urlPatterns = "/login.do")
////3. doGet(HttpServletRequest request, HttpServletResponse response)
////4. How is the response created?


package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//login.do provides the url for this web servlet
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{
	
	private UserValidationService service = new UserValidationService();
	
	/***************GET REQUEST************/
//	server gets the http request to login.do from the browser
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Yahoo</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>" + "My First Servlet" + "</h1>");
//		out.println("<h3>" + "Author: Winnie" + "</h3>");
//		out.println("</body>");
//		out.println("</html>");
		
		//Passing a parameter between browser and app server in http://localhost:8080/?name=helloitsme
		//The servlet takes parameter and puts an attribute into the request so JSP can see it and show it on the page..
		
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		request.setAttribute("name", name);
//		request.setAttribute("password", password);
		//http://localhost:8080/?name=helloitsme&password=somepassword
		
		
		//redirects the request/response to the JSP file with html inside
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	
	/******************POST REQUEST**************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		boolean isUserValid = service.isUserValid(name, password);
		if(isUserValid){
			request.setAttribute("name", name);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		} else{
			request.setAttribute("errorMessage", "Invalid credentials");
			//if user is not valid, we send him back to the login screen
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
		}
		
		
	}
}
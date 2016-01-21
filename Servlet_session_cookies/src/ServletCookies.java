

import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCookies
 */
@WebServlet("/ServletCookies")
public class ServletCookies extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
	// TODO Auto-generated method stub
	response.setContentType("text/html");
	PrintStream pout = new PrintStream(response.getOutputStream());
	// Check to see if there are any cookies
	Cookie[] cookieArray = request.getCookies();
	int count = 0;
	if (cookieArray != null)
	{
	for (int i =0; i< cookieArray.length; i++)
	{
	Cookie c = cookieArray[i];
	
	// Check for the count cookie
	if (c.getName().equals("count"))
	{
	// Parse cookie value and assign to count
	try
	{
	Integer num = new Integer (c.getValue());
	count = num.intValue();
	}
	catch (NumberFormatException nfe) {}
	}
	}
	}
	count++;
	// Send updated cookie to the browser
	response.addCookie(new Cookie ("count", String.valueOf(count)));
	pout.println ("You have visited this page " + count +
	" times since your web browser started");
	pout.flush(); }
	}
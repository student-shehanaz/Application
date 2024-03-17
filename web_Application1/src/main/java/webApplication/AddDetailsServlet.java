package webApplication;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.regex.Pattern;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/index")
public class AddDetailsServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
	
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		UserBean ub=new UserBean();
		
		//ub.setName(req.getParameter("name"));
		// ub.setEmail(req.getParameter("email"));
		// ub.setAge(req.getParameter("age"));
		
		String email=req.getParameter("email");
	int value=Integer.parseInt(req.getParameter("age"));
				
				
//		if(email == null || email.isEmpty())
//		{
//			pw.println("Invalid Email Address...<br>");
//			RequestDispatcher rd=req.getRequestDispatcher("Index.html");
//			rd.include(req, res);
//		}
				
				
		String emailreg ="^[a-zA-Z0-9_+&*-]+(?:\\."+
		"[a-zA-Z0-9_+&*-]+)*@"+
				"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern p=Pattern.compile(emailreg);
		if(p.matcher(email).matches())
		{
			ub.setEmail(email);
			 if(value>0)
			{
				ub.setAge(value);
				ub.setName(req.getParameter("name"));

				 Date date=Date.valueOf(req.getParameter("dob"));
				 ub.setDob( date);
				 AddDetailsDAO ad=new AddDetailsDAO();
					int k=ad.insertdetails(ub);
					if(k>0)
					{
						pw.println("Details added Successfully...<br>");
						RequestDispatcher rd=req.getRequestDispatcher("View.html");
						rd.include(req, res);
					}	
			}
			 else if(value<=0)
				{

					pw.println("Plese check the number is Negative...<br>");
					RequestDispatcher rd=req.getRequestDispatcher("Index.html");
					rd.include(req, res);
				}
		}
		else
		{
			pw.println("Invalid Email Address type correct email...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Index.html");
			rd.include(req, res);
		}
		
		
	}
}

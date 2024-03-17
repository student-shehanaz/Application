package webApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewDetail extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	         
			   throws ServletException,IOException{
		
				   PrintWriter pw = res.getWriter();
				   res.setContentType("text/html");
				   HttpSession hs = req.getSession(true);//Accessing existing Session
				  			RetrieveDetails rd=new RetrieveDetails();
			LinkedList<UserBean> al = rd.retrieve();
			
			hs.setAttribute("list", al);
			Iterator<UserBean> it = al.iterator();
			RequestDispatcher rd1 = req.getRequestDispatcher("View.html");
			   rd1.include(req, res);
			pw.println("<html><body>");
			   pw.println("<table align=center border=1 width=70% height=50%>");
			   pw.println("<h2 align=center>Details</h2>");
			   pw.println("<tr><th> S.No</th><th>Name</th><th>Email</th><th>Age</th><th>Date of Birth</th>");
			   int i=1 ;
			   while(it.hasNext())
			   {
				   UserBean pb = it.next();
				   pw.println("<tr><td>"+i++ +"</td><td>"+pb.getName()+"</td><td>"+
						             pb.getEmail()+"</td><td>"+
						             pb.getAge()+"</td><td>"+
						            
						             pb.getDob());
					   }//end of loop
				
			   }
			
		
	
}

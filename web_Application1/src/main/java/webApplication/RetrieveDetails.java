package webApplication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
public class RetrieveDetails 
{
	public LinkedList<UserBean> al = new LinkedList<UserBean>();
	 public LinkedList<UserBean> retrieve()
	 {
		 
  	 try 
  	 {
  		 Connection con = DataBaseConnection.getCon();
  		 PreparedStatement ps = con.prepareStatement
  				 ("select * from detail1");
  		 ResultSet rs = ps.executeQuery();
  		 while(rs.next())
  		 {
  			 UserBean pb = new UserBean();
  			
  			 pb.setName(rs.getString(1));
  			 pb.setEmail(rs.getString(2));
  			 pb.setAge(rs.getInt(3));
  			 pb.setDob(rs.getDate(4));

  			 al.add(pb);//Adding Bean to ArrayList
  		 }//end of loop
  	 }catch(Exception e)
  	 {
  		 e.printStackTrace();
  		 }
  	 return al;
   }
}

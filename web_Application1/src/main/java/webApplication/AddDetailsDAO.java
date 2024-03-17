package webApplication;

import java.sql.Connection;


import java.sql.PreparedStatement;
public class AddDetailsDAO 
{
	public int k = 0;

	public int insertdetails(UserBean ub)
	{
	try{
		Connection con=DataBaseConnection.getCon();
		PreparedStatement ps=con.prepareStatement("insert into detail1 values(?,?,?,?)");

	 ps.setString(1,  ub.getName());
	 ps.setString(2, ub.getEmail());
	 ps.setInt(3, ub.getAge());
	 ps.setDate(4, ub.getDob());
	 System.out.println("AddDetailsDAO");
	 k=ps.executeUpdate();
	 
	}

	catch(Exception e)
	{
		e.printStackTrace();
	}

   return k;
}
}

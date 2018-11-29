package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import bean.MessageBean;
import dao.dbconnection;

public class GetMessageDao {
	
	static List<MessageBean> messageList= new ArrayList<>();
	
	public static List<MessageBean> getMessage (MessageBean messagebean) {	
	
		try {
			Connection con =null;
			con = dbconnection.createconnection();
			ResultSet rs;		
			PreparedStatement ps=con.prepareStatement("SELECT username,date,message FROM message");
			rs=ps.executeQuery();
			while(rs.next()) {
				
				messagebean.setMusername(rs.getString("username"));
				messagebean.setMdate(rs.getString("date"));
				messagebean.setMmesage(rs.getString("message"));
				messageList.add(messagebean); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
		
		
		
	}

	
}

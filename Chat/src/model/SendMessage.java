package model;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.MessageBean;
import dao.SendMessageDao;
import dao.GetMessageDao;

import com.mysql.cj.Session;

@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String message = req.getParameter("message");
		req.setAttribute("message",message);
		
		
		HttpSession session=req.getSession();
		session.setAttribute("date", new java.util.Date());
		java.util.Date uDate =(java.util.Date)session.getAttribute("date");
		DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
		Date date =convertUtilToSql(uDate);
		String convertedDate = convertStringToDate(date);
		
		String username= (String)session.getAttribute("username");
		
		MessageBean messagebean= new MessageBean();
		messagebean.setMdate(convertedDate);
		messagebean.setMmesage(message);
		messagebean.setMusername(username);
		
		
	    SendMessageDao sendmessage = new SendMessageDao();
	    sendmessage.usermessage(messagebean);
	    
	    MessageBean nullpointer = new MessageBean();
	    nullpointer.setMdate("15/07/1994");
	    nullpointer.setMusername("furkanberkayvat");
	    nullpointer.setMmesage("hosgeldiniz");
	    List<MessageBean> messageList1= new ArrayList<>();
	    messageList1.add(nullpointer);
	    MessageBean getmessagebean = new MessageBean();
	    messageList1 = GetMessageDao.getMessage(getmessagebean);
	    MessageBean bridge =new MessageBean();
	    int listsize = messageList1.size();
	    for (int i = 0; i < listsize; i++) {
	    	
			bridge= messageList1.get(i);
			req.setAttribute("bridge", bridge);
		}
	    
	   
	    
	    RequestDispatcher dispatcher=req.getRequestDispatcher("/home.jsp");
	    dispatcher.forward(req,resp);    
	    
	    
	
	}
	 
	private static Date convertUtilToSql(java.util.Date uDate) 
	{
		 
		         java.sql.Date sDate = new java.sql.Date(uDate.getTime());		 
		         return sDate;
    }

	
	private String convertStringToDate(Date indate)
	{
	   String date = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
	  
	   try{
		date = sdfr.format( indate );
	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return date;
	}

}

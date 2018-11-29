<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
    margin: 10;
    padding: 0;
    align-items: center;
    justify-content: center;
    text-align: center;
    overflow: hidden;
}
.leftwrapper{
border: 2px solid pink;
position: relative;
height: 900px;
width: 300px;

}
.sendmessage{

width: 100%;
position: relative;
top: -25%;

text-align: center;
}
.h2{
text-align: center;
position: relative;
top: 10%;
}
.Center{
	text-align: center;
    width:250px;
    height:200px;
    background:#0088cc;
    margin: auto;
    border-radius:5%;
    display: flex;
 	 align-items: center;
  	justify-content: center;
}
.middlewrapper{

overflow: scroll;
left: 15%;
position: relative;
margin-left: 400px;
height: 900px;
width: 500px;
float: left;
border: 2px solid purple;

}
.a{
text-align: center;
border: 2px solid teal;
height: 50px;
width: 100%;
margin: auto;
}
</style>
</head>
<body>
	<div class="middlewrapper">
	
		<h2>Chat Messages</h2>
		
			<div class="a">
    			${bridge.musername}<br>
    			${bridge.mmesage}<br>
    			${bridge.mdate}<br>
    		</div>
		
	</div>
<form action="SendMessage" method ="post">
	<div class="leftwrapper">
		
		<div class="sendmessage">
				<div class='Center' align='center'>
					<textarea rows="4" cols="50" class="text" name="message" required></textarea>
					<br/>
					<input type="submit" class="btn"> 
				</div>		
	    </div>
	</div>
</form>
</body>
</html>
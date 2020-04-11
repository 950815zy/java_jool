<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	this will be a login page..
</h1>

	<form name="loginform">
		<input type="text" name="uname">
		<input type="text" name="pass">
	</form>
	<button onclick="sendLogin()">send</button>

	<p></p>
	<form name="testform">
			<input type="text" name="name">
			<input type="text" name="id">
	</form>
	<button onclick="sendTest()">sendtest</button>
</body>
</html>

<script>
	function sendLogin() {
		var date=new Date();
		var inp_uname=document["loginform"]["uname"].value;
		var inp_pass=document["loginform"]["pass"].value;
		var reg_date=date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate();

		console.log(inp_uname+","+inp_pass+","+reg_date);

		var user={uname:inp_uname,pass:inp_pass,register_date:reg_date};
		var myJson=JSON.stringify(user);
		console.log(myJson);

		var xhr=new XMLHttpRequest();
		xhr.open("POST","/Project1-1.0.0-BUILD-SNAPSHOT/login");
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.send(myJson);
	}

	function sendTest() {
		var date=new Date();

		var inp_name=document["testform"]["name"].value;
		var inp_id=document["testform"]["id"].value;

		console.log(inp_name+","+inp_id);

		var obj={name:inp_name,id:inp_id};
		var myJson=JSON.stringify(obj);
		console.log(myJson);

		var xhr=new XMLHttpRequest();
		xhr.open("POST","/Project1-1.0.0-BUILD-SNAPSHOT/testobj");
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send("name="+inp_name+"&id="+inp_id);

		xhr.onreadystatechange=function() {
				if(xhr.readyState==4 && xhr.status==200)
					console.log(xhr.responseText);		
		};
	}
</script>
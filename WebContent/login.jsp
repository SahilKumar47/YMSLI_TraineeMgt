<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
${param.message}<br/> 
	<form action="LoginController" method="post">
		<table>
			<tr>
				<td>username</td>
				<td><input type="text" name="username" id="unId" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password" id="pwId" /></td>
			</tr>
			<tr>

				<td><input type="submit" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
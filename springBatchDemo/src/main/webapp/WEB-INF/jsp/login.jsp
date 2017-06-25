<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<br>
<h1>Login page</h1>
<form:form action="verifyLogin" method="post" commandName="loginUser">
<table>
<tr><td>USERNAME</td>
<td><form:input path="username"/></td>
<td><font color="red" size="5"></font><form:errors path="username"/></font></td>
</tr>
<tr><td>Password</td>
<td><form:input path="password"/></td>
<td><font color="red" size="5"><form:errors path="password"/></font></td>
</tr>
</table>
<br>
<input type="submit" value="login">
</form:form>
</body>
</html>  




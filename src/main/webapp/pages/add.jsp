<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add item</title>
</head>
<body>
	<div>
		<h1> ADD Item </h1>
	</div>
	<form method="post">
		<label>Stock name
			<input type="text" name="name"><br />
		</label>

		<label>Emitent
			<input type="text" name="emitent"><br />
		</label>

		<label>Amount
			<input type="text" name="amount"><br />
		</label>

		<label>Cost
			<input type="text" name="cost"><br />
		</label>

		<button type="submit">Submit</button>
	</form>
	<div>
		<%
			String stockInfo;
			if (( stockInfo = (String) request.getAttribute("stockInfo") ) != null) {
				out.println("<p>" + stockInfo + " successfully added!</p>");
			}
		%>
	</div>
	<div>
		<button onclick="location.href='/StocksMonitor'">Back</button>
	</div>
</body>
</html>
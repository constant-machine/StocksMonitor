<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List" import="java.math.BigDecimal"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List items</title>
</head>
<body>
	<div>
		<h1> LIST of Items </h1>
	</div>

	<table>
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>EMITENT</th>
		<th>AMOUNT</th>
		<th>COST</th>
	</tr>
	<tr>
		<td>
			<ul>
				<%
					List<Long> ids = (List<Long>) request.getAttribute("ids");

					if ( ids != null && !ids.isEmpty() ) {
						for (Long id : ids) {
							out.println("<li>" + id + "</li>");
						}
					}
					else {
						out.println("<p>No stocks to display!</p>");
					}
				%>
			</ul>
		</td>
		<td>
			<ul>
				<%
					List<String> names = (List<String>) request.getAttribute("names");

					if ( names != null && !names.isEmpty() ) {
						for (String name : names) {
							out.println("<li>" + names + "</li>");
						}
					}
				%>
			</ul>
		</td>
		<td>
			<ul>
				<%
					List<String> emitents = (List<String>) request.getAttribute("emitents");

					if ( emitents != null && !emitents.isEmpty() ) {
						for (String emitent : emitents) {
							out.println("<li>" + emitent + "</li>");
						}
					}
				%>
			</ul>
		</td>
		<td>
			<ul>
				<%
					List<Long> amounts = (List<Long>) request.getAttribute("amounts");

					if ( amounts != null && !amounts.isEmpty() ) {
						for (Long amount : amounts) {
							out.println("<li>" + amount + "</li>");
						}
					}
				%>
			</ul>
		</td>
		<td>
			<ul>
				<%
					List<BigDecimal> costs = (List<BigDecimal>) request.getAttribute("costs");

					if ( costs != null && !costs.isEmpty() ) {
						for (BigDecimal cost : costs) {
							out.println("<li>" + cost + "</li>");
						}
					}
				%>
			</ul>
		</td>
	</tr>
	</table>
	<div>
		<button onclick="location.href='/StocksMonitor'">Back</button>
	</div>
</body>
</html>
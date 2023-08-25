<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<html lang="en">
<head>
<%@ include file="Menu.jsp" %>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Information</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    body {
      background-color: #f4f4f4;
    }
    .container {
      margin-top: 50px;
    }
    table {
      background-color: #ffffff;
    }
    th, td {
      padding: 10px;
      text-align: center;
    }
    th {
      background-color: #343a40;
      color: #ffffff;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2 class="text-center">Product Information</h2>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Name</th>
          <th>City</th>
          <th>Product Name</th>
          <th>Price</th>
          <th>Delete</th>
          <th>Update</th>
        </tr>
      </thead>
      <tbody>
        <%
  ResultSet result = (ResultSet)request.getAttribute("result");
  while(result.next()){%>
	   <tr>
 <td><%=result.getString(1) %></td>
 <td><%=result.getString(2) %></td>
 <td><%=result.getString(3) %></td>
 <td><%=result.getString(4) %></td>
 <td><a href="delete?name=<%=result.getString(1)%>">Delete</a></td>
 <td><a href="update?name=<%=result.getString(1)%>&city=<%=result.getString(2)%>">Update</a></td>
</tr>
<%  }%>
      </tbody>
    </table>
  </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <title>Update Product Name</title>
  <style>
    /* CSS styling */
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }

    .container {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    h2 {
      text-align: center;
      margin-bottom: 20px;
    }

    label {
      display: block;
      margin-bottom: 10px;
    }

    input[type="text"],
    input[type="email"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
      margin-bottom: 20px;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: #fff;
      border: none;
      padding: 10px 20px;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Update product Name</h2>
    <form action="update" method="post">
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" placeholder="Enter new name"value=<%=request.getAttribute("name")%>>

      <label for="city">City:</label>
      <input type="text" id="city" name="city" placeholder="Enter new city"value=<%=request.getAttribute("city")%>>

      <input type="submit" value="Update">
    </form>
  </div>
</body>
</html>

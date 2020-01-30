<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Manager Home</title>
        <style>
        table.steelBlueCols {
  border: 4px solid #555555;
  background-color: #555555;
  width: 400px;
  text-align: center;
  border-collapse: collapse;
}
table.steelBlueCols td, table.steelBlueCols th {
  border: 1px solid #555555;
  padding: 5px 10px;
}
table.steelBlueCols tbody td {
  font-size: 12px;
  font-weight: bold;
  color: #FFFFFF;
}
table.steelBlueCols td:nth-child(even) {
  background: #398AA4;
}
table.steelBlueCols thead {
  background: #398AA4;
  border-bottom: 10px solid #398AA4;
}
table.steelBlueCols thead th {
  font-size: 15px;
  font-weight: bold;
  color: #FFFFFF;
  text-align: left;
  border-left: 2px solid #398AA4;
}
table.steelBlueCols thead th:first-child {
  border-left: none;
}

table.steelBlueCols tfoot td {
  font-size: 13px;
}
table.steelBlueCols tfoot .links {
  text-align: right;
}
table.steelBlueCols tfoot .links a{
  display: inline-block;
  background: #FFFFFF;
  color: #398AA4;
  padding: 2px 8px;
  border-radius: 5px;
}
        </style>
    </head>
    <body>
        <div>
            <h1>List of all the Employees</h1>
            <table border="1" class="steelBlueCols">
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Telephone</th>
                <th colspan="2">Action</th>
                 
                <c:forEach var="employee" items="${listEmployee}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${employee.f_name}</td>
                    <td>${employee.l_name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.telephone}</td>
                    <td> <a href="/MVCSpring/editEmployee?id=${employee.id}">Edit</a> </td>      
                    <td> <a href="/MVCSpring/deleteEmployee?id=${employee.id}">Delete</a> </td>
                </tr>
                </c:forEach>             
            </table>
                        <h3><a href="/MVCSpring/EmployeeForm">Do you think this list needs new names? Click here!</a></h3>
            
        </div>
    </body>
</html>
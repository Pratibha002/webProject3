<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--  language="java": Specifies that the scripting language used in the JSP page is Java.
contentType="text/html; charset=UTF-8": Sets the MIME type of the response as HTML and the character encoding as UTF-8.
pageEncoding="UTF-8": Defines the character encoding for the JSP page itself, ensuring that the page is read as UTF-8.-->


<%@ page import="java.util.List" %>
<!--  Imports the List interface from the java.util package. 
This allows you to use the List type in your JSP page without needing to fully qualify it. -->

<%@ page import="configuration.testDao" %>
<!-- Imports the testDao class from the configuration package. 
This allows you to use testDao objects directly in your JSP page. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Data</title>
</head>
<body>
<h1>Student Data</h1>
<table border="1">
<!--  Starts a table with a border of 1 pixel width. Tables are used to display tabular data.
 -->
    <thead> <!-- Groups the header content in the table, which typically contains column names. -->
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Marks</th>
            <th>City</th>
        </tr>
    </thead>
    <tbody>
        <%
        //<%: Starts a JSP scriptlet, where Java code can be embedded into the HTML.
            List<testDao> students = (List<testDao>) request.getAttribute("students");
            
//      List<testDao> students: Declares a variable students of type List<testDao>.
//      (List<testDao>) request.getAttribute("students"): Retrieves the attribute named "students" from the request and casts it to a List<testDao>.
//      This list is expected to be populated by a servlet or controller.
            if (students != null) {
            	
            	//if (students != null): Checks if the students list is not null (i.e., if data was successfully passed to the JSP).
            	
            	
                for (testDao student : students) {
                	
                	//for (testDao student : students): Iterates over each testDao object in the students list.
        %>
        <tr>
            <td><%= student.getId() %></td>
            
          <!-- <td>: Creates a table cell. -->
          <!-- %=student.getid(): Evaluates and inserts the student’s ID into the cell. -->
            
            <td><%= student.getName() %></td>
            <!-- <td>: Creates a table cell. -->
          <!-- %=student.getName(): Evaluates and inserts the student’s name into the cell. -->
            
            <td><%= student.getMarks() %></td>
            <!-- <td>: Creates a table cell. -->
          <!-- %=student.getMarks(): Evaluates and inserts the student’s marks into the cell. -->
            
            
            <td><%= student.getCity() %></td>
            <!-- <td>: Creates a table cell. -->
          <!-- %=student.getCity(): Evaluates and inserts the student’s city into the cell. -->
            
        </tr>
        <% 
                }
            }
        %>
    </tbody>
</table>
</body>
</html>

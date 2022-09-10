<html xmlns:th="https://thymeleaf.org">    
<table>
<tr>    
<td><h4>Id: </h4></td>    
<td><h4 th:text="${f.id}"></h4></td>    
</tr>        
<tr>    
<td><h4>Faculty Name: </h4></td>    
<td><h4 th:text="${f.name}"></h4></td>    
</tr>    
<tr>    
<td><h4>Address: </h4></td>    
<td><h4 th:text="${f.address}"></h4></td>    
</tr>    
</table>    
</html>  
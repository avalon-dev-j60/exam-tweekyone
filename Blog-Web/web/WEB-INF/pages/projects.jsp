<%-- 
    Document   : projects
    Created on : 01.07.2019, 20:17:28
    Author     : JAVA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>

<!DOCTYPE html>
<core:layout title="Projects">
    
    <c:choose>
        <c:when test="${not empty projects}">
            <c:forEach items="${projects}" var="item">
                <div class="row">
                    ${item}<br/>
                </div>
            </c:forEach>
        </c:when>
            
        <c:otherwise>
            <p>
                There are no projects currently under ddevelopment...
            </p>
        </c:otherwise>
      
    </c:choose>
    
</core:layout>

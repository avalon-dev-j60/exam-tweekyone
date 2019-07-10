<%-- 
    Document   : register
    Created on : 01.07.2019, 16:39:22
    Author     : Ponyuhov
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/"%>

<fmt:setBundle basename="resources.labels"/>

<form action="${pageContext.servletContext.contextPath}/register"
      method="post">
    
    <core:error/>
    
    <dev class="row bottm">
        <input type="text"
               name="name"
               value="${param.name}"
               placeholder="Enter your name here"
               required>
    </dev>
    
    <dev class="row bottm">
        <input type="password"
               name="password"
               placeholder="Enter your password here"
               required>
    </dev>    

    <dev class="row bottm">
        <input type="password"
               name="confirmation"
               placeholder="Password confirmation"
               required>
    </dev>

    <dev class="row bottom">
        <button type="submit" class="pull-right">
                <fmt:message key="reg.reg"/>
        </button>
                

</form>
<%-- 
    Document   : login
    Created on : 01.07.2019, 16:39:09
    Author     : Ponyuhov
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>

<fmt:setBundle basename="resources.labels"/>

<form action="${pageContext.servletContext.contextPath}/sign-in"
      method="post">
    
    <core:error/>
    
    <dev class="row bottom">
        <input type="text"
               name="name"
               placeholder="Enter Your name"
               required>
    </dev>
    
    <dev class="row bottom">
        <input type="password"
               name="password"
               placeholder="Enter Your password"
               required>
    </dev>
    
    <dev class="row">
        <a href="${pageContext.servletContext.contextPath}/register">
            <fmt:message key="reg.reg"/>
        </a>
        <button class="pull-right">
            <fmt:message key="menu.signin"/>
        </button>
    </dev>
</form>
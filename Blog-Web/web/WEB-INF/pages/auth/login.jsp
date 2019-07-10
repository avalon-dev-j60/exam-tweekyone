<%-- 
    Document   : login
    Created on : 22.06.2019, 13:15:06
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>
<!DOCTYPE html>

<core:layout title="Sign in">
    
    <div class="two fourth centered">
        <h2>Login</h2>
        
        <auth:login/>
        
    </div>
</core:layout>

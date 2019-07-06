<%-- 
    Document   : login
    Created on : 01.07.2019, 15:27:45
    Author     : Ponyuhov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>
<!DOCTYPE html>

<core:layout title="Sign in">
    <div>
        <h2 class="middle"> Login </h2>
        <auth:login />
    </div>
</core:layout>

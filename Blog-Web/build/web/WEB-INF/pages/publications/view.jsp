<%-- 
    Document   : list
    Created on : 06.07.2019, 12:13:41
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/"%>
<%@taglib prefix="publications" tagdir="/WEB-INF/tags/publications/"%>

<core:layout title="${publication.title}">
    
    <publications:view publication="${publications}"/>
    
    
</core:layout>

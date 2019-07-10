<%-- 
    Document   : create
    Created on : 06.07.2019, 12:25:19
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/"%>

<%@taglib prefix="publications" tagdir="/WEB-INF/tags/publications/"%>

<core:layout title="Creating publication">
    
    <h2>
        Creating publication
    </h2>
    
    <publications:edit action="/publication/create"/>
    
</core:layout>

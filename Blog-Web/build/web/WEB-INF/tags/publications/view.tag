<%-- 
    Document   : view
    Created on : 06.07.2019, 11:19:29
    Author     : JAVA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="publication" type="ru.avalon.java.blog.entities.Publication"
             required="true"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/"%>

<p>
    <h2>${publication.title}</h2>

    ${publication.content}
</p>

<div>
    <c:if test="${sessionScope.user == publication.author.email}">
        <core:link location="/publication/edit?id=${publication.id}" title="Edit publication" classes = "button"/>
        <core:link location="/publication/delete?id=${publication.id}" title="Delete publication" classes = "button"/>
    </c:if>
</div>
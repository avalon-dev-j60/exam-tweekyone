<%-- 
    Document   : location
    Created on : 01.07.2019, 16:09:48
    Author     : Ponyuhov
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="location" required="true"%>
<%@attribute name="title" required="true"%>

<a href="${pageContext.servletContext.contextPath}${location}">
    ${title}
</a>

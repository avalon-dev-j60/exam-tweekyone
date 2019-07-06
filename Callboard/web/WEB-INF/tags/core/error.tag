<%-- 
    Document   : error
    Created on : 03.07.2019, 19:11:00
    Author     : Ponyuhov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="exception" %>

<c:if test="${not empty exception}">
    <span class="invalid row">
        ${exception.message}
    </span>
</c:if>
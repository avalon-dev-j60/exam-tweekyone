<%-- 
    Document   : error
    Created on : 29.06.2019, 15:14:54
    Author     : JAVA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="exception"%>

<c:if test="${not empty exception}">
    <span class="box error gapped">
        ${exception.message}
    </span>
</c:if>

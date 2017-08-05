<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.theme.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">
</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="myProfile">个人信息</a></li>
                <li role="presentation" class="active"><a href="myPassword">设置密码</a></li>
            </ul>
            <div class="tab-content">
                <form:form method="post" commandName="userPassword">
                    <div class="form-group">
                        <form:label path="oldPassword" cssClass="control-label">原密码</form:label>
                        <form:password path="oldPassword" cssClass="form-control" placeholder="原密码"></form:password>
                    </div>
                    <div class="form-group">
                        <form:label path="newPassword" cssClass="control-label">新密码</form:label>
                        <form:password path="newPassword" cssClass="form-control" placeholder="新密码"></form:password>
                    </div>
                    <div class="form-group">
                        <form:label path="confirmPassword" cssClass="control-label">确认新密码</form:label>
                        <form:password path="confirmPassword" cssClass="form-control" placeholder="确认新密码"></form:password>
                    </div>
                    <spring:hasBindErrors name="userPassword">
                        <div class="alert alert-danger" role="alert">
                            <c:forEach var="error" items="${errors.allErrors}">
                                <b><spring:message message="${error}"/> </b>
                                <br/>
                            </c:forEach>
                        </div>
                    </spring:hasBindErrors>
                    <c:if test="${!empty success}">
                        <div class="alert alert-success" role="alert">
                            <b>${success}</b>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">保存密码</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../includes/footer.jsp"/>
<script src="<c:url value="/statics/jquery-1.12.4/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/statics/bootstrap-3.3.0/js/bootstrap.js"/>"></script>
<script src="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.js"/>"></script>
<script src="<c:url value="/statics/jquery-ui-1.12.1/datepicker-zh-CN.js"/>"></script>
</body>
</html>

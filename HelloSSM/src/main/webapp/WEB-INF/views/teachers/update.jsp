<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Edit</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">
</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-6"><h4>${mode == 'create' ? '添加' : '编辑'}学生信息</h4></div>
        <div class="col-xs-6"></div>
    </div>
    <form:form method="post" commandName="teacher">
        <div class="row">
            <div class="col-xs-12">
                <c:if test="${mode == 'update'}">
                    <div class="form-group">
                        <form:label path="id" cssClass="control-label">ID</form:label>
                        <form:input path="id" cssClass="form-control" readonly="true"></form:input>
                    </div>
                </c:if>
                <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label path="name" cssClass="control-label">姓名</form:label>
                        <form:input path="name" cssClass="form-control" placeholder="请输入姓名"></form:input>
                        <form:errors path="name" cssClass="help-block"></form:errors>
                    </div>
                </spring:bind>
                <spring:bind path="mobile">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label path="mobile" cssClass="control-label">手机</form:label>
                        <form:input path="mobile" cssClass="form-control" placeholder="请输入手机号码"></form:input>
                        <form:errors path="mobile" cssClass="help-block"></form:errors>
                    </div>
                </spring:bind>
                <spring:bind path="email">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label path="email" cssClass="control-label">邮箱</form:label>
                        <form:input path="email" cssClass="form-control" placeholder="请输入邮箱"></form:input>
                        <form:errors path="email" cssClass="help-block"></form:errors>
                    </div>
                </spring:bind>
                <spring:bind path="genderId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label path="genderId" cssClass="control-label">性别</form:label>
                        <form:select path="genderId" cssClass="form-control" items="${genders}" itemValue="id" itemLabel="name">

                        </form:select>
                        <form:errors path="genderId" cssClass="help-block"></form:errors>
                    </div>
                </spring:bind>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3">
                <c:choose>
                    <c:when test="${mode == 'create'}">
                        <button type="submit" class="btn btn-primary" name="action" value="create">新建</button>
                    </c:when>
                    <c:when test="${mode == 'update'}">
                        <button type="submit" class="btn btn-primary" name="action" value="update">修改</button>
                    </c:when>
                </c:choose>
            </div>
            <div class="col-xs-3">
                <c:if test="${mode=='update'}">
                    <button type="submit" class="btn btn-primary" name="action" value="delete">删除</button>
                </c:if>
            </div>
            <div class="col-xs-6"><a class="btn btn-primary" href="list">返回</a></div>
        </div>
    </form:form>
</div>
<jsp:include page="../includes/footer.jsp"/>
<script src="<c:url value="/statics/jquery-1.12.4/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/statics/bootstrap-3.3.0/js/bootstrap.js"/>"></script>
</body>
</html>

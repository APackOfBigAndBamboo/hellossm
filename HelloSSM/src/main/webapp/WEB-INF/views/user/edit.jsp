<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Edit</title>
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
                <li role="presentation" class="active"><a href="edit?id=${param.id}">基本信息</a></li>
                <li role="presentation"><a href="password?id=${param.id}">重置密码</a></li>
                <li role="presentation"><a href="authority?id=${param.id}">设置权限</a></li>
            </ul>
            <div class="tab-content">
                <form:form method="post" commandName="user">
                    <form:hidden path="id"></form:hidden>
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
                            <form:input path="mobile" cssClass="form-control"
                                        placeholder="请输入手机号码"></form:input>
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
                            <form:select path="genderId" cssClass="form-control" items="${genders}"
                                         itemValue="id" itemLabel="name">
                            </form:select>
                            <form:errors path="genderId" cssClass="help-block"></form:errors>
                        </div>
                    </spring:bind>
                    <div class="form-group">
                        <form:label path="registerDate" cssClass="control-label">注册时间</form:label>
                        <form:input path="registerDate" cssClass="form-control" readonly="true"></form:input>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">保存</button>
                        <a class="btn btn-success pull-right" href="list">返回</a>
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

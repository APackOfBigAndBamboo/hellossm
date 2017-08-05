<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>Student Add</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">
</head>
<body>
<!-- Static navbar -->
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">首页</a></li>
                <li><a href="#">学生信息管理</a></li>
                <li><a href="#">xxx信息管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">用户1234</a></li>
                <li><a href="#">退出</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container">
    <div class="row">

        <div class="col-xs-6"><h4>学生信息管理</h4></div>
        <div class="col-lg-6"></div>
    </div>
    <form:form method="post" commandName="student">
    <div class="row">
        <div class="col-xs-12">
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
            <div class=" form-group ${status.error ? 'has-error' : ''}">
                <form:label path="email" cssClass="control-label">邮箱</form:label>
                <form:input path="email" cssClass="form-control" placeholder="请输入邮箱"></form:input>
                <form:errors path="email" cssClass="help-block"></form:errors>
            </div>
            </spring:bind>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-6">
            <button type="submit" class="btn btn-primary" value="">保存添加</button>
        </div>
        <div class="col-xs-6"><a class="btn btn-primary" href="list">返回</a>
        </div>

    </div>
    </form:form>

    <%--<div class="row">--%>
    <%--<div class="col-xs-12">--%>
    <%--<form method="post">--%>
    <%--<div class="form-group">--%>
    <%--<label>姓名</label>--%>
    <%--<input type="text" class="form-control" name="name" placeholder="请输入姓名">--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
    <%--<label>手机</label>--%>
    <%--<input type="text" class="form-control" name="mobile" placeholder="请输入手机号码">--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
    <%--<label>邮箱</label>--%>
    <%--<input type="text" class="form-control" name="email" placeholder="请输入邮箱">--%>
    <%--</div>--%>
    <%--<button type="submit" class="btn btn-primary" value="">保存添加</button>--%>
    <%--<a class="btn btn-primary"  href="/Student/list"/>返回</a>--%>
    <%--</form>--%>

    <%--</div>--%>
    <%--</div>--%>

    <footer class="footer">
        <p><a href="http://www.northgatecode.com">North Gate Code</a> 版权所有 ©️ 2016</p>
    </footer>
    <script src="<c:url value="/statics/jquery-1.12.4/jquery-1.12.4.js"/>"></script>
    <script src="<c:url value="/statics/bootstrap-3.3.0/js/bootstrap.js"/>"></script>
</body>
</html>

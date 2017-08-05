<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            <a class="navbar-brand" href="#">学生管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/"/>">首页</a></li>
                <li><a href="<c:url value="/Student/list"/>">学生信息管理</a></li>

                <sec:authorize access="hasAnyRole({'USER' , 'ADMIN'})">
                <li><a href="<c:url value="/teachers/list"/>">教师信息管理</a></li>
                </sec:authorize>

                <sec:authorize access="hasRole('ADMIN')">
                    <li><a href="<c:url value="/user/list"/>">系统用户管理</a> </li>
                </sec:authorize>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/user/myProfile"/>"><sec:authentication property="principal.name"></sec:authentication></a></li>
                <li><a href="<c:url value="/logout"/>">退出</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
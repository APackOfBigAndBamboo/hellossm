<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">
</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-6"><h4>学生信息管理</h4></div>
        <div class="col-xs-6"><a class="btn btn-primary pull-right" href="<c:url value="/teachers/update?mode=create"/>">添加</a></div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>手机</th>
                    <th>删除</th>
                </tr>
                <c:forEach var="teacher" items="${teachers}">
                    <tr>
                        <td>${teacher.id}</td>
                        <td><a href="update?mode=update&id=${teacher.id}">${teacher.name}</a></td>
                        <td>${teacher.mobile}</td>
                        <td><a href="delete?id=${teacher.id}" onclick="return confirm('确定删除老师 ${teacher.name}?')" >删除</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../includes/footer.jsp"/>
<script src="<c:url value="/statics/jquery-1.12.4/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/statics/bootstrap-3.3.0/js/bootstrap.js"/>"></script>
</body>
</html>
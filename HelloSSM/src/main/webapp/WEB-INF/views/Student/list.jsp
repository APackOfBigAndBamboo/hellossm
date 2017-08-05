<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <div class="col-xs-6"><a class="btn btn-primary pull-right" href="<c:url value="/Student/update?mode=create"/>">添加</a>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <form class="form-horizontal" method="get">
                <div class="form-group">
                    <label class="control-label col-sm-1">搜索</label>
                    <div class="col-sm-11">
                        <input type="text" class="form-control" id="searchText" name="name" value="${name}"
                               placeholder="姓名,手机，邮箱">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-1">性别</label>
                    <div class="col-sm-11">
                        <select name="genderId" class="form-control">
                            <option value="0">unknow</option>
                            <c:forEach var="gender" items="${genders}">
                                <option value="${gender.id}" ${gender.id == genderId ? 'selected="selected"' : ''}>${gender.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-11">
                        <button type="submit" class="btn btn-primary">搜索</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>手机</th>
                    <th>邮箱</th>
                    <th>生日</th>
                    <th>性别</th>
                    <th>删除</th>
                </tr>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.id}</td>
                        <td><a href="update?mode=update&id=${student.id}">${student.name}</a></td>
                        <td>${student.mobile}</td>
                        <td>${student.email}</td>
                        <td><fmt:formatDate pattern="yyyy_MM_dd" value="${student.birthday}"/></td>
                        <td>${student.gender.name}</td>
                        <td><a href="delete?id=${student.id}" onclick="return confirm('确定删除学生 ${student.name}?')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <nav>
            <ul class="pager">
                <c:choose>
                    <c:when test="${offest>=pageSize}">
                        <li class="previous">
                            <a href="list?name=${name}&genderId=${genderId}&offest=${offest - pageSize}">上一页</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="previous disabled"><a href="#">上一页</a></li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${students.size() >=pageSize}">
                        <li class="next ${students.size() <pageSize?'disabled' : ''}">
                            <a href="list?name=${name}&genderId=${genderId}&offest=${offest + pageSize}">下一页</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="next disabled"><a href="#">下一页</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>

    </div>
</div>
<jsp:include page="../includes/footer.jsp"/>
<script src="<c:url value="/statics/jquery-1.12.4/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.js"/>"></script>


</body>
</html>


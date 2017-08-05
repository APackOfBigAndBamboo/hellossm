<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">
</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-6"><h4>系统用户管理</h4></div>
        <div class="col-xs-6"><a class="btn btn-primary pull-right"
                                 href="<c:url value="/user/create"/>">添加</a></div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <form class="form-horizontal" action="list" method="get">
                <div class="form-group">
                    <label class="control-label col-sm-1">搜索</label>
                    <div class="col-sm-11">
                        <input type="text" class="form-control" id="searchText" name="searchText" value="${param.searchText}"
                               placeholder="姓名, 手机, 邮箱">
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
                    <th>姓名</th>
                    <th>手机</th>
                    <th>邮箱</th>
                    <th>注册时间</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td><a href="edit?id=${user.id}">${user.name}</a></td>
                        <td>${user.mobile}</td>
                        <td>${user.email}</td>
                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.registerDate}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <nav>
            <ul class="pager">
                <c:choose>
                    <c:when test="${offset >= limit}">
                        <li class="previous">
                            <a href="list?searchText=${searchText}&offset=${offset - limit}">上一页</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="previous disabled"><a href="#">上一页</a></li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${users.size() >= limit}">
                        <li class="next">
                            <a href="list?searchText=${searchText}&offset=${offset + limit}">下一页</a>
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
<script src="<c:url value="/statics/bootstrap-3.3.0/js/bootstrap.js"/>"></script>
</body>
</html>

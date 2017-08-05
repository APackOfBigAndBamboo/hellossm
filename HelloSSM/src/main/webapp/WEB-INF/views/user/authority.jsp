<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Authority</title>
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
                <li role="presentation"><a href="edit?id=${param.id}">基本信息</a></li>
                <li role="presentation"><a href="password?id=${param.id}">重置密码</a></li>
                <li role="presentation" class="active"><a href="authority?id=${param.id}">设置权限</a></li>
            </ul>
            <div class="tab-content">
                <form method="post">
                    <input type="hidden" name="id" value="${user.id}">
                    <div class="form-group">
                        <label class="control-label">当前用户</label>
                        <span>${user.name}</span>
                    </div>
                    <div class="form-group">
                        <label class="control-label">用户角色</label>
                        <c:forEach var="role" items="${roles}">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="userRoleIds" value="${role.id}" ${role.checked ? 'checked' : ''}>
                                    ${role.name}
                                </label>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">保存</button>
                        <a class="btn btn-success pull-right" href="list">返回</a>
                    </div>
                </form>
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
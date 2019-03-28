<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="generator" content="Bootply" />
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link
            href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
            rel="stylesheet" media="screen">
    <link
            href="${pageContext.request.contextPath}/resources/styles/main.css"
            rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="//cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
    <script type="text/javascript">
        $(document).ready(function() {
            $('#example').dataTable();
        });
    </script>
</head>

<body>
<nav class="navbar navbar-default sidebar" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-sidebar-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse"
             id="bs-sidebar-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a
                        href="${pageContext.request.contextPath}/home">Главная<span
                        style="font-size: 16px;"
                        class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
                <li class="dropdown"><a href="#" class="dropdown-toggle"
                                        data-toggle="dropdown">Таблицы <span class="caret"></span><span
                        style="font-size: 16px;"
                        class="pull-right hidden-xs showopacity glyphicon glyphicon-th"></span></a>
                    <ul class="dropdown-menu forAnimate" role="menu">
                        <c:forEach items="${tableDTOs}" var="tableDTO">
                            <li><a
                                    href="${pageContext.request.contextPath}/admin/${tableDTO.path}">${tableDTO.name}</a></li>
                        </c:forEach>
                    </ul></li>
                <li class="dropdown"><a href="#" class="dropdown-toggle"
                                        data-toggle="dropdown">Графики <span class="caret"></span><span
                        style="font-size: 16px;"
                        class="pull-right hidden-xs showopacity glyphicon glyphicon-stats"></span></a>
                    <ul class="dropdown-menu forAnimate" role="menu">
                        <c:forEach items="${tableDTOs}" var="tableDTO">
                            <li><a
                                    href="${pageContext.request.contextPath}/${tableDTO.path}">${tableDTO.name}</a></li>
                        </c:forEach>
                    </ul></li>
            </ul>
        </div>
    </div>
</nav>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
        src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript"
        src="//cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
        src="//cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"></script>
</body>
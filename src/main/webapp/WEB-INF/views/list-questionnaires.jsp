<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Опросы</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css"/>

    <script type="text/javascript" src="/resources/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a href="http://localhost:8080" class="navbar-brand">
        <img src="/resources/img/lightbox/logo.png" width="30" height="30" alt="logo">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <collapse class="navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a href="/admin" class="nav-link">Home</a>
            </li>
            <li class="nav-item">
                <a href="/admin/workers" class="nav-link">Сотрудники</a>
            </li>
            <li class="nav-item">
                <a href="/admin/questionnaire" class="nav-link">Опросы</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input type="text" class="form-control mr-sm-2" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0">Search</button>
        </form>
    </collapse>
</nav>
<div class="container-fluid">
    <h1>Hello, world!</h1>
    <div class="row">
        <div class="col col-lg-2">
            <div class="panel panel-info">
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-dark">
                        <!-- loop over and print our district -->
                        <c:forEach var="district" items="${districts}">

                            <!-- construct an "update" link with district id -->
                            <c:url var="listLink" value="/admin/district/questoinnaire">
                                <c:param name="districtId" value="${district.id}"/>
                            </c:url>

                            <tr>
                                <td>
                                    <a href="${listLink}">${district.name}</a>
                                </td>

                            </tr>

                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <div class="col col-lg-10">
            <b>Всего поселений: ${countSettlement}</b><br>
            <b>Всего опросов: ${countQnaireNum}</b>

            <ul id="treeview">
                <c:forEach var="questionnaireWorkerDTO" items="${questionnaireWorkerDTOs}">
                    <li data-expanded="true">${questionnaireWorkerDTO.settlementName}. ${questionnaireWorkerDTO.lastName} ${questionnaireWorkerDTO.firstName}
                        - ${questionnaireWorkerDTO.phoneName}. Количество опросов -${questionnaireWorkerDTO.countQnaire}
                        <ul>
                            <div class="panel-group" id="accordion">
                                <c:forEach var="qnaireNumWorkerDTO" items="${questionnaireWorkerDTO.qnaireNumWorkerDTOs}">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse${qnaireNumWorkerDTO.idQnaireNum}">${qnaireNumWorkerDTO.idQnaireNum}</a>
                                            </h3>
                                        </div>
                                        <div class="panel-collapse collapse in" id="collapse${qnaireNumWorkerDTO.idQnaireNum}"}>
                                            <c:forEach var="questionnaireStrDTO" items="${qnaireNumWorkerDTO.questionnaireStrDTOs}">
                                                <div class="panel-body">ВОПРОС: ${questionnaireStrDTO.questionName}. ОТВЕТ: ${questionnaireStrDTO.answerName}.</div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <!-- you need to include the ShieldUI CSS and JS assets in order for the TreeView widget to work -->
    <link rel="stylesheet" type="text/css"
          href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css"/>
    <script type="text/javascript"
            src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <script type="text/javascript">
        jQuery(function ($) {
            $("#treeview").shieldTreeView();
        });
    </script>
    <!-- Tree View - END -->

</div>

</body>
</html>
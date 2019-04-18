<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Material Design Bootstrap -->
    <link href="/resources/css/mdb.min.css" rel="stylesheet">

    <title>Сотрудники</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a href="#" class="navbar-brand">
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
                <a href="#" class="nav-link">Опросы</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input type="text" class="form-control mr-sm-2" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0">Search</button>
        </form>
    </collapse>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col col-lg-2">
            <div class="panel panel-info">
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-dark">
                        <!-- loop over and print our district -->
                        <c:forEach var="district" items="${districts}">

                            <!-- construct an "update" link with district id -->
                            <c:url var="listLink" value="/admin/district/workers">
                                <c:param name="districtId" value="${district.id}" />
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
            <table id="dtMaterialDesignExample" class="table table-striped" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th class="th-sm">Фамилия</th>
                    <th class="th-sm">Имя</th>
                    <th class="th-sm">Телефон</th>
                    <th class="th-sm">Кол-во опросов</th>
                    <th class="th-sm">Поселение</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="worker" items="${workerDTOs}" >
                <tr>
                    <td>${worker.lastName}</td>
                    <td>${worker.firstName}</td>
                    <td>${worker.phone}</td>
                    <td>${worker.count}</td>
                    <td>${worker.settlement}</td>
                </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <th class="th-sm">Фамилия</th>
                    <th class="th-sm">Имя</th>
                    <th class="th-sm">Телефон</th>
                    <th class="th-sm">Кол-во опросов</th>
                    <th class="th-sm">Поселение</th>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>

</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#dtMaterialDesignExample').DataTable();
        $('#dtMaterialDesignExample_wrapper').find('label').each(function () {
            $(this).parent().append($(this).children());
        });
        $('#dtMaterialDesignExample_wrapper .dataTables_filter').find('input').each(function () {
            $('input').attr("placeholder", "Search");
            $('input').removeClass('form-control-sm');
        });
        $('#dtMaterialDesignExample_wrapper .dataTables_length').addClass('d-flex flex-row');
        $('#dtMaterialDesignExample_wrapper .dataTables_filter').addClass('md-form');
        $('#dtMaterialDesignExample_wrapper select').removeClass(
            'custom-select custom-select-sm form-control form-control-sm');
        $('#dtMaterialDesignExample_wrapper select').addClass('mdb-select');
        $('#dtMaterialDesignExample_wrapper .mdb-select').materialSelect();
        $('#dtMaterialDesignExample_wrapper .dataTables_filter').find('label').remove();
    });
</script>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script type="text/javascript" src="/resources/js/mdb.min.js"></script>
</body>
</html>
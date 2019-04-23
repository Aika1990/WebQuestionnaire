<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Сотрудники</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.bootstrap4.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap4.min.css">
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
    <br>
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
        <table id="example" class="table table-striped table-bordered dt-responsive nowrap" style="width:100%">
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
        </table>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.bootstrap4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.colVis.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.2.3/js/responsive.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        var table = $('#example').DataTable( {
            lengthChange: false,
            buttons: [ 'copy', 'excel', 'csv', 'pdf', 'colvis' ]
        } );

        table.buttons().container()
            .appendTo( '#example_wrapper .col-md-6:eq(0)' );
    } );
</script>
</body>
</html>
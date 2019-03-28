<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Районы</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <%@ page isELIgnored="false"%>
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h3 class="text-center">Районы</h3>
        <hr />

        <input type="button" value="Добавление района"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary" /> <br />
        <br />
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Список районов</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Наименование</th>
                    </tr>

                    <!-- loop over and print our district -->
                    <c:forEach var="district" items="${districts}">

                        <!-- construct an "update" link with district id -->
                        <c:url var="updateLink" value="/district/updateForm">
                            <c:param name="districtId" value="${district.id}" />
                        </c:url>

                        <!-- construct an "delete" link with district id -->
                        <c:url var="deleteLink" value="/district/delete">
                            <c:param name="districtId" value="${district.id}" />
                        </c:url>

                        <tr>
                            <td>${district.name}</td>

                            <td>
                                <!-- display the update link --> <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Вы уверены, что хотите удалить район?'))) return false">Delete</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </div>

</div>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Районы</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    <script>
        function myFunc() {
            var selectedValue=$("#mySelect").val();
            alert(selectedValue);
        }
    </script>
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h3 class="text-center">Поселения</h3>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Добавление поселения</div>
            </div>
            <div class="panel-body">
                <form:form action="saveSettlement" cssClass="form-horizontal"
                           method="post" modelAttribute="settlementDTO">

                    <!-- нужно связать эти данные с идентификатором района-->
                    <form:hidden path="id" />
                    <div class="form-group">
                        <label class="col-md-3 control-label">Наименование района</label>
                        <div class="col-md-9">
                            <form:select path="district">
                                <c:forEach items="${districts}" var="district">
                                    <c:choose>
                                        <c:when test="${district.name == settlementDTO.district}">
                                            <option selected value="${district.id}"><c:out value="${district.name}"></c:out></option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${district.id}"><c:out value="${district.name}"></c:out></option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="name" class="col-md-3 control-label">Наименование поселения</label>
                        <div class="col-md-9">
                            <form:input path="name" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">OK</form:button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

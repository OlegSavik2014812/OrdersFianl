<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="i18n.MessageBundle"/>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>
    <fmt:message key="edituser.title"/>
  </title>
  <c:import url="../css_import.jsp"/>
  <link href="<c:url value="/css/login.css"/>" rel="stylesheet" type="text/css">
</head>

<body><c:import url="../NavBar.jsp"/>
<div class="container">
  <div class="row">

    <form class="" method="POST" action="../action?name=add_discount">
      <input type="hidden" name="name" value="add_track">

      <h2 class="form-signin-heading"><fmt:message key="editdiscount.add_dicount"/></h2>

      <div class="form-group">
        <label for="percent" class="sr-only">
          <fmt:message key="editdiscount.percent"/>
        </label>
        <input type="text" id="percent" name="percent" class="form-control"
               placeholder="<fmt:message key="editdiscount.enter_percent"/> " required="" autofocus="">
      </div>

      <div class="form-group">
        <label for="effectiveFrom" class="sr-only">
          <fmt:message key="editdiscount.date_begin"/>
        </label>
        <input type="date" id="effectiveFrom" name="effectiveFrom" class="form-control"
               placeholder="<fmt:message key="editdiscount.date_begin"/>" required="">
      </div>

      <div class="form-group">
        <label for="effectiveTo" class="sr-only">
          <fmt:message key="editdiscount.date_end"/>
        </label>
        <input type="date" id="effectiveTo" name="effectiveTo" class="form-control"
               placeholder="<fmt:message key="editdiscount.date_end"/>">
      </div>

      <button class="btn btn-lg btn-primary btn-block" type="submit" data-toggle="modal"
              data-target=".bd-example-modal-sm">
        <fmt:message key="editdiscount.add"/>
      </button>

    </form>
  </div>
</div>

<div class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
     aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

    </div>
  </div>
</div>
<c:import url="../js_import.jsp"/>

</body>
</html>

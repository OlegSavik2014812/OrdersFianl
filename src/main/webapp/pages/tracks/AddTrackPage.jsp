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
    <fmt:message key="index.title"/>
  </title>
  <c:import url="../css_import.jsp"/>
  <link href="<c:url value="/css/login.css"/>" rel="stylesheet" type="text/css">

</head>

<body><c:import url="../NavBar.jsp"/>

<div class="container">

  <div class="row">

    <form class="" method="POST" action="../action?name=add_track">
      <input type="hidden" name="name" value="add_track">

      <h2 class="form-signin-heading"><fmt:message key="addtrack.title"/></h2>

      <div class="form-group">
        <label for="trackname" class="sr-only">
          <fmt:message key="addtrack.name_track"/>
        </label>
        <input type="text" id="trackname" name="trackName" class="form-control"
               placeholder="<fmt:message key="addtrack.name_track"/> " required="" autofocus="">
      </div>

      <div class="form-group">
        <label for="artist" class="sr-only">
          <fmt:message key="addtrack.name_artist"/>
        </label>
        <input type="text" id="artist" name="artist" class="form-control"
               placeholder="<fmt:message key="addtrack.name_artist"/>" required="">
      </div>

      <div class="form-group">
        <label for="album" class="sr-only">
          <fmt:message key="addtrack.name_album"/>
        </label>
        <input type="text" id="album" name="album" class="form-control"
               placeholder="<fmt:message key="addtrack.name_album"/>">
      </div>

      <div class="form-group">
        <label for="popularity" class="sr-only">
          <fmt:message key="addtrack.popularity"/>
        </label>
        <input type="text" id="popularity" name="popularity" class="form-control"
               placeholder="<fmt:message key="addtrack.popularity"/> ">
      </div>

      <div class="form-group">
        <label for="uri" class="sr-only">
          <fmt:message key="addtrack.uri"/>
        </label>
        <input type="text" id="uri" name="uri" class="form-control"
               placeholder="<fmt:message key="addtrack.uri"/> ">
      </div>

      <div class="form-group">
        <label for="price" class="sr-only">
          <fmt:message key="addtrack.price"/>
        </label>
        <input type="text" id="price" name="price" class="form-control"
               placeholder="<fmt:message key="addtrack.price"/> ">
      </div>

      <div class="form-group">
        <label for="duration" class="sr-only">
          <fmt:message key="addtrack.duration"/>
        </label>
        <input type="text" id="duration" name="duration" class="form-control"
               placeholder="<fmt:message key="addtrack.duration"/> ">
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit" data-toggle="modal"
              data-target=".bd-example-modal-sm">
        <fmt:message key="addtrack.add"/>
      </button>

    </form>

  </div>

</div>

<div class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
     aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <fmt:message key="info.add_track_success"/>
    </div>
  </div>
</div>
<c:import url="../js_import.jsp"/>

</body>

</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="i18n.MessageBundle"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <title><fmt:message key="index.title"/></title>
  <c:import url="../css_import.jsp"/>
  <link href="<c:url value="/css/login.css"/>" rel="stylesheet" type="text/css">
  <script>
    window.onload = function () {
      var field = document.getElementById("username");

      field.onblur = function () {
        var xmlhttp = new XMLHttpRequest();
        var url = "action?name=search_user&userName=" + getUserName();
        xmlhttp.onreadystatechange = function () {
          if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            if (xmlhttp.URL) {
              document.getElementById("isE").style.color = "red";
              document.getElementById("submitButton").disabled = true;
            }
            else {
              document.getElementById("isE").style.color = "green";
              document.getElementById("submitButton").disabled = false;
            }
          }
        };

        try {
          xmlhttp.open("GET", url, true);
          xmlhttp.send();
        }

        catch (e) {
          alert("unable to connect to server");
        }
      };
    };

    function getUserName() {
      return document.getElementById("username").value;
    }
  </script>
</head>

<body>
<c:import url="../NavBar.jsp"/>

<div class="container">
  <div class="row">
    <span id="isE">vrtgrsf</span>
    <form class="form-signin" method="POST" action="action" name="sign_up_form">
      <input type="hidden" name="name" value="sign_up">


      <h2 class="form-signin-heading"><fmt:message key="signup.please_signup"/></h2>

      <div class="form-group">
        <label for="username" class="sr-only"><fmt:message
          key="signin.email_address_msg"/> </label>
        <span>
        <c:if test="${requestScope.error=='exist'}">
          <div class="alert alert-danger">
            <strong><fmt:message key="error.user_already_exist"/></strong>
          </div>
        </c:if>
      </span>
        <input type="text" name="userName" id="username" class="form-control"
               placeholder="<fmt:message key="signin.email_address_msg"/> " required=""
               pattern=^[a-zA-Z][a-zA-Z0-9-_\.]{4,20}$ autofocus="">
      </div>
      <div class="form-group">
        <label for="inputPassword1" class="sr-only"><fmt:message key="signin.password"/> </label>
        <input type="password" id="inputPassword1" name="password1" class="form-control"
               placeholder="<fmt:message key="signin.password"/>"
               required="">
      </div>

      <div class="form-group">
        <label for="inputPassword2" class="sr-only"><fmt:message key="signin.password"/> </label>
        <input type="password" id="inputPassword2" name="password2" class="form-control"
               placeholder="<fmt:message key="signin.password"/>"
               required="">
      </div>

      <div class="form-group">
        <label for="inputFirstName" class="sr-only"><fmt:message key="signup.firstname"/> </label>
        <input type="text" id="inputFirstName" name="firstName" class="form-control" pattern=^[A-Z][a-z\.]{1,20}$
               placeholder="<fmt:message key="signup.firstname"/> ">
      </div>

      <div class="form-group">
        <label for="inputLastName" class="sr-only"><fmt:message key="signup.lastname"/> </label>
        <input type="text" id="inputLastName" name="lastName" class="form-control" pattern=^[A-Z][a-z\.]{1,20}$
               placeholder="<fmt:message key="signup.lastname"/> ">
      </div>

      <button class="btn btn-lg btn-primary btn-block" id="submitButton" type="submit"><fmt:message
        key="button.signup"/></button>
    </form>
  </div>
</div>
<c:import url="../../js/validate.jsp"/>
<c:import url="../js_import.jsp"/>
</body>
</html>
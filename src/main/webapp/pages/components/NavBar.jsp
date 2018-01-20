<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <fmt:requestEncoding value="UTF-8"/>
  <fmt:setLocale value="${sessionScope.local}"/>
  <fmt:setBundle basename="i18n.MessageBundle"/>


<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
  <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
          data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
          aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="<c:url value="/"/>">
    <img src="<c:url value="/img/logo.png"/>" width="30" height="30">
    <fmt:message key="navbar.head_name"/>
  </a>
  <div class="collapse navbar-collapse">
    <ul class="navbar-nav mr-auto">
      <c:if test="${sessionScope.USER == null }">

        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/action?name=sign_in"/>"><fmt:message key="button.signin"/></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/action?name=sign_up"/> "><fmt:message key="button.signup"/></a>
        </li>
      </c:if>

      <c:if test="${sessionScope.USER != null && sessionScope.USER.role=='CLIENT'}">

        <li class="nav-item">
          <a class="nav-link" href="#"><fmt:message key="index.hello"/><c:out
            value="${sessionScope.USER.username}"/></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/action?name=sign_out"/> "><fmt:message key="button.signout"/></a>
        </li>
        <li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/action?name=order_list"/> "><fmt:message
            key="button.order_list"/></a>
        </li>
      </c:if>
      <c:if test="${sessionScope.USER!=null &&sessionScope.USER.role=='ADMIN'}">
        <li class="nav-item">
          <a class="nav-link" href="#"><fmt:message key="index.hello"/><c:out
            value="${sessionScope.USER.username}"/></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/action?name=sign_out"/> "><fmt:message key="button.signout"/></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="" /> "><fmt:message key="button.purchases"/> </a>
        </li>
      </c:if>
    </ul>

    <form method="get" action="action">
      <input type="hidden" name="name" value="search_track">
      <div class="input-group mb-1">

        <input type="text" class="form-control" aria-label="Text input with segmented dropdown button" name="trackname"
               placeholder="<fmt:message key="search.enter_track_name"/>">
        <button type="submit" class="btn btn-outline-secondary"><fmt:message key="button.search"/></button>
      </div>
    </form>

    <div class="btn-group dropleft">
      <div class=""></div>
      <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
              aria-expanded="false">
        <fmt:message key="localization.language"/>
      </button>
      <div class="dropdown-menu">
        <a href="<c:url value="/action?name=change_local&local=en&page=${pageContext.request.servletPath}"/>"
           class="dropdown-item"><fmt:message
          key="localization.english"/> </a>
        <a href="<c:url value="/action?name=change_local&local=ru&page=${pageContext.request.servletPath}"/>"
           class="dropdown-item"><fmt:message
          key="localization.russian"/> </a>
      </div>
    </div>
  </div>
</nav>









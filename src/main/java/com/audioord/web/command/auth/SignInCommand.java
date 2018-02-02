package com.audioord.web.command.auth;

import com.audioord.dao.AuthInfoDao;
import com.audioord.dao.DAOException;
import com.audioord.dao.OrderDiscountDAO;
import com.audioord.dao.UserDAO;
import com.audioord.model.account.AuthInfo;
import com.audioord.model.account.User;
import com.audioord.model.order.OrderDiscount;
import com.audioord.web.command.Command;
import com.audioord.web.command.Pages;
import com.audioord.web.http.Request;
import com.audioord.web.http.Response;

import java.io.IOException;

public class SignInCommand implements Command {

  public static final String NAME = "sign_in";

  private final AuthInfoDao authInfoDao = new AuthInfoDao();
  private final UserDAO userDAO = new UserDAO();
  private final OrderDiscountDAO orderDiscountDAO = new OrderDiscountDAO();

  @Override
  public String execute(Request request, Response response) throws IOException, DAOException {
    if (!request.hasAllParameters("userName", "password")) {
      return Pages.SIGN_IN_PAGE;
    }

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    if (userName.isEmpty() || password.isEmpty()) { // required fields
      return Pages.SIGN_IN_PAGE;
    }

    AuthInfo authInfo = authInfoDao.getById(userName);
    if (authInfo == null) { // unknown user
      return Pages.SIGN_IN_PAGE;
    }

    if (!authInfo.getPassword().equals(password)) { // wrong password
      return Pages.SIGN_IN_PAGE;
    }

    User user = userDAO.getByUsername(authInfo.getUserName());
    OrderDiscount orderDiscount = orderDiscountDAO.getByUserId(user.getId());
    if (user != null) {
      request.setSessionAttribute("USER", user);
      request.setSessionAttribute("BONUS", orderDiscount);
    }

    return Pages.INDEX_PAGE;
  }
}

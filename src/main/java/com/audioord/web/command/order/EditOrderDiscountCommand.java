package com.audioord.web.command.order;

import com.audioord.dao.DAOException;
import com.audioord.dao.OrderDiscountDAO;
import com.audioord.dao.UserDAO;
import com.audioord.model.account.User;
import com.audioord.model.order.OrderDiscount;
import com.audioord.utils.DateUtil;
import com.audioord.web.command.Command;
import com.audioord.web.command.Pages;
import com.audioord.web.http.Request;
import com.audioord.web.http.Response;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class describes the object-command, which assigns discount to chosen user and returns to user list page
 * implementation of {@link Command}
 */
public class EditOrderDiscountCommand implements Command {
  public static final String NAME = "add_discount";

  private static final String PRM_USER = "username";
  private static final String PRM_DATE_FROM = "date_from";
  private static final String PRM_DATE_TO = "date_to";
  private static final String PRM_PERCENT = "percent";
  private static final String FORWARD_USER_LIST = "/action?name=user_list&page=1";
  private final OrderDiscountDAO orderDiscountDAO = new OrderDiscountDAO();
  private final UserDAO userDAO = new UserDAO();
  private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


  /**
   * There is initialization of user with session param
   * then validation of input params for {@link OrderDiscount }object and its creation
   * if command is successful, then creation of {@link OrderDiscount} object and redirection to user list page
   *
   * @param request  {@link Request}
   * @param response {@link Response}
   * @return string name of page
   * @throws IOException  in case, when params incorrect
   * @throws DAOException {@link DAOException}
   */
  @Override
  public String execute(Request request, Response response) throws DAOException, IOException {
    if (!request.hasAllParameters(PRM_PERCENT, PRM_USER, PRM_DATE_FROM, PRM_DATE_TO)) {
      return FORWARD_USER_LIST;
    }
    User user = userDAO.getByUsername(request.getParameter(PRM_USER));
    if (user == null) {
      return Pages.INDEX_PAGE;
    }
    if (orderDiscountDAO.getByUserId(user.getId()) != null) {
      return Pages.INDEX_PAGE;
    }
    if (!validateDiscount(request.getParameter(PRM_PERCENT))) {
      return Pages.INDEX_PAGE;
    }
    Double percent = Double.parseDouble(request.getParameter(PRM_PERCENT));
    if (percent < 0 || percent > 100) {
      return Pages.INDEX_PAGE;
    }

    Date dateFrom = DateUtil.parseDate(request.getParameter(PRM_DATE_FROM), simpleDateFormat);

    Date dateTo = DateUtil.parseDate(request.getParameter(PRM_DATE_TO), simpleDateFormat);
    if (dateFrom == null || dateTo == null) {
      return Pages.INDEX_PAGE;
    }
    OrderDiscount orderDiscount = new OrderDiscount(percent, dateFrom, dateTo, user);
    if (!orderDiscountDAO.create(orderDiscount)) {
      return Pages.USER_LIST_PAGE;
    }

    return FORWARD_USER_LIST;
  }

  private boolean validateDiscount(String discount) {
    Pattern pattern = Pattern.compile("^([0-9]+([.][0-9]{1,2})?)$");
    Matcher matcher = pattern.matcher(discount);
    return matcher.find();
  }
}

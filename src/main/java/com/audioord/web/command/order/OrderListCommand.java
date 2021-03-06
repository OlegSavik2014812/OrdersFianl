package com.audioord.web.command.order;


import com.audioord.dao.DAOException;
import com.audioord.dao.OrderDAO;
import com.audioord.model.order.Order;
import com.audioord.model.order.OrderStatus;
import com.audioord.utils.DateUtil;
import com.audioord.web.command.Command;
import com.audioord.web.command.Pages;
import com.audioord.web.http.Request;
import com.audioord.web.http.Response;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Class describes the object-command, which shows order list with different status in time period
 * and returns to order list page
 * implementation of {@link Command}
 */
public class OrderListCommand implements Command {

  public static final String NAME = "order_list";

  private static final String PRM_DATE_FROM = "date_from";
  private static final String PRM_DATE_TO = "date_to";
  private static final String PRM_ORDERS = "orders";
  private static final String PRM_SORT = "sort";


  private final OrderDAO orderDAO = new OrderDAO();

  /**
   * There is a validation and parsing of input params for list of {@link Order}
   * if command is successful, then creation of list of {@link Order} and redirection to order list page
   *
   * @param request  {@link Request}
   * @param response {@link Response}
   * @return string name of page
   * @throws IOException  in case, when params incorrect
   * @throws DAOException {@link DAOException}
   */
  @Override
  public String execute(Request request, Response response) throws DAOException, IOException {

    Date dateFrom = DateUtil.parseDate(request.getParameter(PRM_DATE_FROM));
    Date dateTo = DateUtil.parseDate(request.getParameter(PRM_DATE_TO));
    OrderStatus status = OrderStatus.fromString(request.getParameter(PRM_SORT));

    if (dateTo == null) {
      dateTo = new Date();
    }
    if (dateFrom == null) {
      dateFrom = DateUtil.addDays(dateTo, -2);
    }

    List<Order> orders;
    if (status == null) {
      orders = orderDAO.getOrders(dateFrom, dateTo);
    } else {
      orders = orderDAO.getOrders(dateFrom, dateTo, status);
    }

    request.addAttribute(PRM_ORDERS, orders);

    return Pages.ORDER_LIST_PAGE;
  }
}

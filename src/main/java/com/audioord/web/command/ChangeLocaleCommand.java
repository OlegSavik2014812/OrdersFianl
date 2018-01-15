package com.audioord.web.command;

import com.audioord.dao.DAOException;
import com.audioord.web.http.Request;
import com.audioord.web.http.Response;

import java.io.IOException;

public class ChangeLocaleCommand implements Command {

  public static final String NAME = "change_local";
  private static final String PRM_LOCALE = "local";
  private static final String PRM_PAGE = "page";

  @Override
  public String execute(Request request, Response response) throws IOException, DAOException {
    String lang = request.getParameter(PRM_LOCALE);
    if (lang == null || lang.isEmpty()) {
      // need to stay on current page in case locale value is not provided
      return request.getParameter(PRM_PAGE);
    }
    request.setSessionAttribute(PRM_LOCALE, lang);

    return request.getParameter(PRM_PAGE);
  }


}

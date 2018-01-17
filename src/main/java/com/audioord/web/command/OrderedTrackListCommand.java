package com.audioord.web.command;

import com.audioord.dao.DAOException;
import com.audioord.dao.TrackDAO;
import com.audioord.model.account.User;
import com.audioord.model.audio.Track;
import com.audioord.model.order.OrderStatus;
import com.audioord.web.http.Request;
import com.audioord.web.http.Response;

import java.io.IOException;
import java.util.List;

public class OrderedTrackListCommand implements Command {
  public static final String NAME = "order_list";
  private static final String ORDER_STATUS_FILTER = "filter";
  private TrackDAO trackDAO = new TrackDAO();

  @Override
  public String execute(Request request, Response response) throws IOException, DAOException {
    OrderStatus status = OrderStatus.valueOf(request.getParameter(ORDER_STATUS_FILTER));

    User user = request.getSessionAttribute("USER", User.class);
    if (user == null) {
      // user not authorized
      return Pages.SIGN_IN_PAGE;
    }

    List<Track> trackList = null;
    String username = user.getUsername();
    switch (status) {
      case COMPLETED: {
        trackList = trackDAO.getUserTracks(username, status);
        break;
      }
      case REJECTED: {
        trackList = trackDAO.getUserTracks(username, status);
        break;
      }
      case SUBMITTED: {
        trackList = trackDAO.getUserTracks(username, status);
        break;
      }
      default: {
        trackList = trackDAO.getAllUserTracks(username);
        break;
      }
    }

    request.addAttribute("TrackList", trackList);
    return Pages.PURCHASES_PAGE;
  }
}
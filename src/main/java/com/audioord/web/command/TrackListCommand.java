package com.audioord.web.command;

import com.audioord.dao.DAOException;
import com.audioord.dao.TrackDAO;
import com.audioord.model.audio.Track;
import com.audioord.web.http.Request;
import com.audioord.web.http.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrackListCommand implements Command {

  public static final String NAME = "track_list";
  private static final String PRM_FILTER = "filter";

  private TrackDAO trackDAO = new TrackDAO();

  @Override
  public String execute(Request request, Response response) throws IOException, DAOException {
    TrackFilter trackFilter = TrackFilter.fromString(request.getParameter(PRM_FILTER));

    List<Track> trackList = new ArrayList<>();

    switch (trackFilter) {
      case MOST_POPULAR: {
        trackList = trackDAO.getMostPopularTracks();
        break;
      }
      case BRAND_NEW: {
        trackList = trackDAO.getBrandNewTracks();
        break;
      }
      case BEST_SELLING: {
        trackList = trackDAO.getBestSellingTracks();
        break;
      }
    }
    request.addAttribute("TrackList", trackList);

    return Pages.INDEX_PAGE;
  }

  private enum TrackFilter {
    MOST_POPULAR,
    BEST_SELLING,
    BRAND_NEW;

    public static TrackFilter fromString(String value) {
      for (TrackFilter v : TrackFilter.values()) {
        if (v.name().equalsIgnoreCase(value)) {
          return v;
        }
      }
      return MOST_POPULAR;
    }
  }
}

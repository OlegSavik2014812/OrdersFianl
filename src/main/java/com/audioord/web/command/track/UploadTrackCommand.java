package com.audioord.web.command.track;


import com.audioord.dao.DAOException;
import com.audioord.model.audio.Track;
import com.audioord.utils.FileUtils;
import com.audioord.web.command.Command;
import com.audioord.web.command.Pages;
import com.audioord.web.http.Request;
import com.audioord.web.http.Response;
import com.mpatric.mp3agic.*;
import org.apache.commons.fileupload.FileItem;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class UploadTrackCommand implements Command {

  public static final String NAME = "upload_track";
  private static final String UPLOAD_DIR_PATH = "WEB-INF/uploads";
  private static final String PRM_TRACK = "track";

  @Override
  public String execute(Request request, Response response) throws DAOException, IOException {
    FileItem fileItem = request.getFileItem("file");
    if (fileItem == null) {
      return Pages.ADD_TRACK_PAGE;
    }

    File tFile = FileUtils.writeFile(fileItem, getUploadDirPath(request));
    if (tFile == null) {
      return Pages.ADD_TRACK_PAGE; // something gos wrong, stop processing
    }

    Track track = new Track();
    if (!parseMp3File(tFile, track)) { // delete file that can't be parsed
      FileUtils.deleteFile(tFile);
      return Pages.ADD_TRACK_PAGE;
    }

    // add track meta to request for editing
    request.setSessionAttribute(PRM_TRACK, track);
    return Pages.ADD_TRACK_PAGE;
  }

  private boolean parseMp3File(File f, Track track) {
    try {
      Mp3File mp3file = new Mp3File(f);
      if (mp3file.hasId3v1Tag()) {
        ID3v1 tag = mp3file.getId3v1Tag();
        track.setName(tag.getTitle());
        track.setArtist(tag.getArtist());
        track.setAlbum(tag.getAlbum());

      } else if (mp3file.hasId3v2Tag()) {
        ID3v2 tag = mp3file.getId3v2Tag();
        track.setName(tag.getTitle());
        track.setArtist(tag.getArtist());
        track.setAlbum(tag.getAlbum());
      }

      track.setUri(f.getPath());
      track.setDuration(new Time(mp3file.getLengthInMilliseconds()));
      return true;
    } catch (IOException | UnsupportedTagException | InvalidDataException e) {
      return false;
    }
  }

  private String getUploadDirPath(Request req) {
    return req.raw().getServletContext().getRealPath(UPLOAD_DIR_PATH);
  }
}

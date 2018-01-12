package com.audioord.dao.sql;

public interface ConnectionSource {

  java.sql.Connection getConnection() throws java.sql.SQLException;

  void returnConnection(java.sql.Connection con);

  void freeConnection(java.sql.Connection con);
}
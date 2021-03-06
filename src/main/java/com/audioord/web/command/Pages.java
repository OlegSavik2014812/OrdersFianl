package com.audioord.web.command;

/**
 * provides system with directory pathways of jsp pages
 */
public final class Pages {

  public static final String INDEX_PAGE = "/index.jsp";

  public static final String NOT_FOUND_PAGE = "/404.jsp";
  public static final String FORBIDDEN_PAGE = "/403.jsp";

  public static final String SIGN_IN_PAGE = "/pages/auth/SignInPage.jsp";
  public static final String SIGN_UP_PAGE = "/pages/auth/SignUpPage.jsp";

  public static final String TRACK_LIST_PAGE = "/pages/tracks/TracksPage.jsp";
  public static final String ADD_TRACK_PAGE = "/pages/tracks/EditTrackPage.jsp";
  public static final String USER_TRACKS_PAGE = "/pages/tracks/UserTracksPage.jsp";

  public static final String CART_LIST_PAGE = "/pages/cart/CartPage.jsp";

  public static final String ORDER_LIST_PAGE = "/pages/order/OrderPage.jsp";

  public static final String USER_LIST_PAGE = "/pages/user/UserListPage.jsp";
  public static final String FEEDBACK_PAGE = "/pages/feedback/FeedbackPage.jsp";
  public static final String EDIT_PACK_PAGE = "/pages/pack/EditPack.jsp";
  public static final String PACK_PAGE = "/pages/pack/PackPage.jsp";
  public static final String PACK_LIST = "/pages/pack/PacksList.jsp";
  public static final String PACK_TRACK_LIST = "/pages/pack/PackTrackListPage.jsp";
  public static final String ALBUM_LIST = "/pages/album/AlbumsList.jsp";
  public static final String ALBUM_TRACK_LIST = "/pages/album/AlbumTracksList.jsp";
  // public static final String PURCHASES_PAGE = "/pages/UserPurchasedTracks.jsp";

  // public static final String ADD_DISCOUNT_PAGE = "/pages/EditUserDiscountPage.jsp";
//  public static final String USER_LIST = "/pages/UsersPage.jsp";
  // public static final String ALL_PURCHASES = "/pages/MyOrdersPage.jsp";

  private Pages() {
    super();
  }
}

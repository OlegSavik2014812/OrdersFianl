package com.audioord.model.order;

import com.audioord.model.Entity;
import com.audioord.model.account.User;

import java.util.Date;

public class OrderDiscount extends Entity<Long> {

  private double discountPercent;
  private Date effectiveFrom;
  private Date effectiveTo;
  private User user;

  public OrderDiscount(double discountPercent, Date effectiveFrom, Date effectiveTo, User user) {
    this.discountPercent = discountPercent;
    this.effectiveFrom = effectiveFrom;
    this.effectiveTo = effectiveTo;
    this.user = user;
  }

  public double getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(double discountPercent) {
    this.discountPercent = discountPercent;
  }

  public Date getEffectiveFrom() {
    return effectiveFrom;
  }

  public void setEffectiveFrom(Date effectiveFrom) {
    this.effectiveFrom = effectiveFrom;
  }

  public Date getEffectiveTo() {
    return effectiveTo;
  }

  public void setEffectiveTo(Date effectiveTo) {
    this.effectiveTo = effectiveTo;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}

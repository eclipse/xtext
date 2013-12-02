/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 */
package example5;

import java.math.BigDecimal;
import java.math.MathContext;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class Time {
  private final BigDecimal _msec;
  
  public BigDecimal getMsec() {
    return this._msec;
  }
  
  public Time operator_plus(final Time other) {
    BigDecimal _msec = this.getMsec();
    BigDecimal _msec_1 = other.getMsec();
    BigDecimal _plus = _msec.add(_msec_1);
    Time _time = new Time(_plus);
    return _time;
  }
  
  public Time operator_minus(final Time other) {
    BigDecimal _msec = this.getMsec();
    BigDecimal _msec_1 = other.getMsec();
    BigDecimal _minus = _msec.subtract(_msec_1);
    Time _time = new Time(_minus);
    return _time;
  }
  
  public Time operator_multiply(final int times) {
    BigDecimal _msec = this.getMsec();
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _multiply = _msec.multiply(_bigDecimal);
    Time _time = new Time(_multiply);
    return _time;
  }
  
  public Time operator_divide(final int times) {
    BigDecimal _msec = this.getMsec();
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _divide = _msec.divide(_bigDecimal, MathContext.DECIMAL128);
    Time _time = new Time(_divide);
    return _time;
  }
  
  public static Time msec(final int msec) {
    BigDecimal _bigDecimal = new BigDecimal(msec);
    Time _time = new Time(_bigDecimal);
    return _time;
  }
  
  public static Time sec(final int sec) {
    Time _msec = Time.msec((sec * 1000));
    return _msec;
  }
  
  public static Time min(final int min) {
    Time _sec = Time.sec((min * 60));
    return _sec;
  }
  
  public static Time h(final int h) {
    Time _min = Time.min((h * 60));
    return _min;
  }
  
  public static Time h() {
    Time _h = Time.h(1);
    return _h;
  }
  
  public Time(final BigDecimal msec) {
    super();
    this._msec = msec;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_msec== null) ? 0 : _msec.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Time other = (Time) obj;
    if (_msec == null) {
      if (other._msec != null)
        return false;
    } else if (!_msec.equals(other._msec))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}

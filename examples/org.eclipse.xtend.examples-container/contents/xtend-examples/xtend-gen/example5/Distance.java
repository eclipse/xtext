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
public class Distance {
  private final BigDecimal _mm;
  
  public BigDecimal getMm() {
    return this._mm;
  }
  
  public Distance operator_plus(final Distance other) {
    BigDecimal _mm = this.getMm();
    BigDecimal _mm_1 = other.getMm();
    BigDecimal _plus = _mm.add(_mm_1);
    Distance _distance = new Distance(_plus);
    return _distance;
  }
  
  public Distance operator_minus(final Distance other) {
    BigDecimal _mm = this.getMm();
    BigDecimal _mm_1 = other.getMm();
    BigDecimal _minus = _mm.subtract(_mm_1);
    Distance _distance = new Distance(_minus);
    return _distance;
  }
  
  public Distance operator_multiply(final int times) {
    BigDecimal _mm = this.getMm();
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _multiply = _mm.multiply(_bigDecimal);
    Distance _distance = new Distance(_multiply);
    return _distance;
  }
  
  public Distance operator_divide(final int times) {
    BigDecimal _mm = this.getMm();
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _divide = _mm.divide(_bigDecimal, MathContext.DECIMAL128);
    Distance _distance = new Distance(_divide);
    return _distance;
  }
  
  public static Distance mm(final int millimeters) {
    BigDecimal _bigDecimal = new BigDecimal(millimeters);
    Distance _distance = new Distance(_bigDecimal);
    return _distance;
  }
  
  public static Distance cm(final int centimeters) {
    Distance _mm = Distance.mm((centimeters * 10));
    return _mm;
  }
  
  public static Distance m(final int meters) {
    Distance _cm = Distance.cm((meters * 100));
    return _cm;
  }
  
  public static Distance km(final int kilometers) {
    Distance _m = Distance.m((kilometers * 1000));
    return _m;
  }
  
  public Distance(final BigDecimal mm) {
    super();
    this._mm = mm;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_mm== null) ? 0 : _mm.hashCode());
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
    Distance other = (Distance) obj;
    if (_mm == null) {
      if (other._mm != null)
        return false;
    } else if (!_mm.equals(other._mm))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}

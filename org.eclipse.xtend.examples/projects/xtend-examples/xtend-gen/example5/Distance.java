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
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class Distance {
  private final BigDecimal mm;
  
  public Distance operator_plus(final Distance other) {
    BigDecimal _plus = this.mm.add(other.mm);
    return new Distance(_plus);
  }
  
  public Distance operator_minus(final Distance other) {
    BigDecimal _minus = this.mm.subtract(other.mm);
    return new Distance(_minus);
  }
  
  public Distance operator_multiply(final int times) {
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _multiply = this.mm.multiply(_bigDecimal);
    return new Distance(_multiply);
  }
  
  public Distance operator_divide(final int times) {
    BigDecimal _bigDecimal = new BigDecimal(times);
    BigDecimal _divide = this.mm.divide(_bigDecimal, MathContext.DECIMAL128);
    return new Distance(_divide);
  }
  
  public static Distance mm(final int millimeters) {
    BigDecimal _bigDecimal = new BigDecimal(millimeters);
    return new Distance(_bigDecimal);
  }
  
  public static Distance cm(final int centimeters) {
    return Distance.mm((centimeters * 10));
  }
  
  public static Distance m(final int meters) {
    return Distance.cm((meters * 100));
  }
  
  public static Distance km(final int kilometers) {
    return Distance.m((kilometers * 1000));
  }
  
  public Distance(final BigDecimal mm) {
    super();
    this.mm = mm;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.mm== null) ? 0 : this.mm.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Distance other = (Distance) obj;
    if (this.mm == null) {
      if (other.mm != null)
        return false;
    } else if (!this.mm.equals(other.mm))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("mm", this.mm);
    return b.toString();
  }
  
  @Pure
  public BigDecimal getMm() {
    return this.mm;
  }
}

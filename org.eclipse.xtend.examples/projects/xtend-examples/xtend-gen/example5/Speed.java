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

import example5.Distance;
import example5.Time;
import java.math.BigDecimal;
import java.math.MathContext;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class Speed {
  private final BigDecimal mmPerMsec;
  
  public static Speed operator_divide(final Distance d, final Time t) {
    BigDecimal _mm = d.getMm();
    BigDecimal _msec = t.getMsec();
    BigDecimal _divide = _mm.divide(_msec, MathContext.DECIMAL128);
    return new Speed(_divide);
  }
  
  public Speed(final BigDecimal mmPerMsec) {
    super();
    this.mmPerMsec = mmPerMsec;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.mmPerMsec== null) ? 0 : this.mmPerMsec.hashCode());
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
    Speed other = (Speed) obj;
    if (this.mmPerMsec == null) {
      if (other.mmPerMsec != null)
        return false;
    } else if (!this.mmPerMsec.equals(other.mmPerMsec))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("mmPerMsec", this.mmPerMsec);
    return b.toString();
  }
  
  @Pure
  public BigDecimal getMmPerMsec() {
    return this.mmPerMsec;
  }
}

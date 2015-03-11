package org.eclipse.xtend.caliper.tests.visitors;

import org.eclipse.xtend.caliper.tests.visitors.CaliperArrayTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperCompoundTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperFunctionTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperParameterizedTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperUnboundTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperUnknownTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperWildcardTypeReference;

@SuppressWarnings("all")
public class Visitor {
  public int visitCaliperTypeReference(final CaliperTypeReference visitable, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  public int visitCaliperParameterizedTypeReference(final CaliperParameterizedTypeReference visitable, final int i, final long k) {
    return visitCaliperTypeReference(visitable, i, k);
  }
  
  public int visitCaliperArrayTypeReference(final CaliperArrayTypeReference visitable, final int i, final long k) {
    return visitCaliperTypeReference(visitable, i, k);
  }
  
  public int visitCaliperFunctionTypeReference(final CaliperFunctionTypeReference visitable, final int i, final long k) {
    return visitCaliperParameterizedTypeReference(visitable, i, k);
  }
  
  public int visitCaliperUnknownTypeReference(final CaliperUnknownTypeReference visitable, final int i, final long k) {
    return visitCaliperTypeReference(visitable, i, k);
  }
  
  public int visitCaliperCompoundTypeReference(final CaliperCompoundTypeReference visitable, final int i, final long k) {
    return visitCaliperTypeReference(visitable, i, k);
  }
  
  public int visitCaliperUnboundTypeReference(final CaliperUnboundTypeReference visitable, final int i, final long k) {
    return visitCaliperTypeReference(visitable, i, k);
  }
  
  public int visitCaliperWildcardTypeReference(final CaliperWildcardTypeReference visitable, final int i, final long k) {
    return visitCaliperTypeReference(visitable, i, k);
  }
}

package org.eclipse.xtend.caliper.tests.visitors;

import org.eclipse.xtend.caliper.tests.visitors.CaliperTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.Visitor;

@SuppressWarnings("all")
public class CaliperArrayTypeReference extends CaliperTypeReference {
  public int specializeAllCasesInstanceMethod(final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  public int specializeSomeCasesInstanceMethod(final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  /**
   * Returns the kind constant of this CaliperTypeReference.
   * @return the kind constant '3'.
   */
  public int getKind() {
    return KIND_CALIPER_ARRAY_TYPE_REFERENCE;
  }
  
  public int acceptVisitor(final Visitor visitor, final int i, final long k) {
    return visitor.visitCaliperArrayTypeReference(this, i, k);
  }
}

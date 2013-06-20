package org.eclipse.xtend.caliper.tests.visitors;

import org.eclipse.xtend.caliper.tests.visitors.CaliperParameterizedTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.Visitor;

@SuppressWarnings("all")
public class CaliperFunctionTypeReference extends CaliperParameterizedTypeReference {
  public int specializeAllCasesInstanceMethod(final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  /**
   * Returns the kind constant of this CaliperTypeReference.
   * @return the kind constant '4'.
   */
  public int getKind() {
    return KIND_CALIPER_FUNCTION_TYPE_REFERENCE;
  }
  
  public int acceptVisitor(final Visitor visitor, final int i, final long k) {
    return visitor.visitCaliperFunctionTypeReference(this, i, k);
  }
}

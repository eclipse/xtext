package org.eclipse.xtend.caliper.tests.visitors;

@SuppressWarnings("all")
public class CaliperTypeReference {
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
  
  public int acceptVisitor(final Visitor visitor, final int i, final long k) {
    return visitor.visitCaliperTypeReference(this, i, k);
  }
  
  protected final static int KIND_CALIPER_TYPE_REFERENCE = 1;
  
  /**
   * Returns the kind constant of this CaliperTypeReference.
   * @return the kind constant '1'.
   */
  public int getKind() {
    return KIND_CALIPER_TYPE_REFERENCE;
  }
  
  protected final static int KIND_CALIPER_PARAMETERIZED_TYPE_REFERENCE = 2;
  
  protected final static int KIND_CALIPER_ARRAY_TYPE_REFERENCE = 3;
  
  protected final static int KIND_CALIPER_FUNCTION_TYPE_REFERENCE = 4;
  
  protected final static int KIND_CALIPER_UNKNOWN_TYPE_REFERENCE = 5;
  
  protected final static int KIND_CALIPER_COMPOUND_TYPE_REFERENCE = 6;
  
  protected final static int KIND_CALIPER_UNBOUND_TYPE_REFERENCE = 7;
  
  protected final static int KIND_CALIPER_WILDCARD_TYPE_REFERENCE = 8;
}

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
public class EmfVisitor {
  public final int switchCaliperTypeReference(final CaliperTypeReference visitable, final int i, final long k) {
    final int kind = visitable.getKind();
    switch(kind) {
      case CaliperTypeReference.KIND_CALIPER_TYPE_REFERENCE: {
        return doSwitchCaliperTypeReference(visitable, i, k);
      }
      case CaliperTypeReference.KIND_CALIPER_PARAMETERIZED_TYPE_REFERENCE: {
        return doSwitchCaliperParameterizedTypeReference((CaliperParameterizedTypeReference) visitable, i, k);
      }
      case CaliperTypeReference.KIND_CALIPER_ARRAY_TYPE_REFERENCE: {
        return doSwitchCaliperArrayTypeReference((CaliperArrayTypeReference) visitable, i, k);
      }
      case CaliperTypeReference.KIND_CALIPER_FUNCTION_TYPE_REFERENCE: {
        return doSwitchCaliperFunctionTypeReference((CaliperFunctionTypeReference) visitable, i, k);
      }
      case CaliperTypeReference.KIND_CALIPER_UNKNOWN_TYPE_REFERENCE: {
        return doSwitchCaliperUnknownTypeReference((CaliperUnknownTypeReference) visitable, i, k);
      }
      case CaliperTypeReference.KIND_CALIPER_COMPOUND_TYPE_REFERENCE: {
        return doSwitchCaliperCompoundTypeReference((CaliperCompoundTypeReference) visitable, i, k);
      }
      case CaliperTypeReference.KIND_CALIPER_UNBOUND_TYPE_REFERENCE: {
        return doSwitchCaliperUnboundTypeReference((CaliperUnboundTypeReference) visitable, i, k);
      }
      case CaliperTypeReference.KIND_CALIPER_WILDCARD_TYPE_REFERENCE: {
        return doSwitchCaliperWildcardTypeReference((CaliperWildcardTypeReference) visitable, i, k);
      }
      default: throw new IllegalArgumentException();
    }
  }
  
  public int doSwitchCaliperTypeReference(final CaliperTypeReference visitable, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  public int doSwitchCaliperParameterizedTypeReference(final CaliperParameterizedTypeReference visitable, final int i, final long k) {
    return doSwitchCaliperTypeReference(visitable, i, k);
  }
  
  public int doSwitchCaliperArrayTypeReference(final CaliperArrayTypeReference visitable, final int i, final long k) {
    return doSwitchCaliperTypeReference(visitable, i, k);
  }
  
  public int doSwitchCaliperFunctionTypeReference(final CaliperFunctionTypeReference visitable, final int i, final long k) {
    return doSwitchCaliperParameterizedTypeReference(visitable, i, k);
  }
  
  public int doSwitchCaliperUnknownTypeReference(final CaliperUnknownTypeReference visitable, final int i, final long k) {
    return doSwitchCaliperTypeReference(visitable, i, k);
  }
  
  public int doSwitchCaliperCompoundTypeReference(final CaliperCompoundTypeReference visitable, final int i, final long k) {
    return doSwitchCaliperTypeReference(visitable, i, k);
  }
  
  public int doSwitchCaliperUnboundTypeReference(final CaliperUnboundTypeReference visitable, final int i, final long k) {
    return doSwitchCaliperTypeReference(visitable, i, k);
  }
  
  public int doSwitchCaliperWildcardTypeReference(final CaliperWildcardTypeReference visitable, final int i, final long k) {
    return doSwitchCaliperTypeReference(visitable, i, k);
  }
}

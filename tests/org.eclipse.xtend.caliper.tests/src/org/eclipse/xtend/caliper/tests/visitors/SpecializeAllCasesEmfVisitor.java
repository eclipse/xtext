package org.eclipse.xtend.caliper.tests.visitors;

import org.eclipse.xtend.caliper.tests.visitors.CaliperArrayTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperCompoundTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperFunctionTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperParameterizedTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperUnboundTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperUnknownTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperWildcardTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.EmfVisitor;

@SuppressWarnings("all")
public class SpecializeAllCasesEmfVisitor extends EmfVisitor {
  public int doSwitchCaliperArrayTypeReference(final CaliperArrayTypeReference visitable, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  public int doSwitchCaliperCompoundTypeReference(final CaliperCompoundTypeReference visitable, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  public int doSwitchCaliperFunctionTypeReference(final CaliperFunctionTypeReference visitable, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  public int doSwitchCaliperParameterizedTypeReference(final CaliperParameterizedTypeReference visitable, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  public int doSwitchCaliperTypeReference(final CaliperTypeReference visitable, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  public int doSwitchCaliperUnboundTypeReference(final CaliperUnboundTypeReference visitable, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  public int doSwitchCaliperUnknownTypeReference(final CaliperUnknownTypeReference visitable, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  public int doSwitchCaliperWildcardTypeReference(final CaliperWildcardTypeReference visitable, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
}

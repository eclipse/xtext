package org.eclipse.xtend.caliper.tests.visitors;

import java.util.Arrays;
import org.eclipse.xtend.caliper.tests.visitors.CaliperArrayTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperCompoundTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperFunctionTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperParameterizedTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperUnboundTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperUnknownTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperWildcardTypeReference;

@SuppressWarnings("all")
public class SpecializeAllCasesPolymorphicDispatcher {
  protected int _accept(final CaliperTypeReference reference, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  protected int _accept(final CaliperParameterizedTypeReference reference, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  protected int _accept(final CaliperArrayTypeReference reference, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  protected int _accept(final CaliperFunctionTypeReference reference, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  protected int _accept(final CaliperUnknownTypeReference reference, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  protected int _accept(final CaliperCompoundTypeReference reference, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  protected int _accept(final CaliperUnboundTypeReference reference, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  protected int _accept(final CaliperWildcardTypeReference reference, final int i, final long k) {
    long _plus = (k + 200L);
    int _intValue = Long.valueOf(_plus).intValue();
    int _plus_1 = (i + _intValue);
    return _plus_1;
  }
  
  public int accept(final CaliperTypeReference reference, final int i, final long k) {
    if (reference instanceof CaliperFunctionTypeReference) {
      return _accept((CaliperFunctionTypeReference)reference, i, k);
    } else if (reference instanceof CaliperArrayTypeReference) {
      return _accept((CaliperArrayTypeReference)reference, i, k);
    } else if (reference instanceof CaliperCompoundTypeReference) {
      return _accept((CaliperCompoundTypeReference)reference, i, k);
    } else if (reference instanceof CaliperParameterizedTypeReference) {
      return _accept((CaliperParameterizedTypeReference)reference, i, k);
    } else if (reference instanceof CaliperUnboundTypeReference) {
      return _accept((CaliperUnboundTypeReference)reference, i, k);
    } else if (reference instanceof CaliperUnknownTypeReference) {
      return _accept((CaliperUnknownTypeReference)reference, i, k);
    } else if (reference instanceof CaliperWildcardTypeReference) {
      return _accept((CaliperWildcardTypeReference)reference, i, k);
    } else if (reference != null) {
      return _accept(reference, i, k);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(reference, i, k).toString());
    }
  }
}

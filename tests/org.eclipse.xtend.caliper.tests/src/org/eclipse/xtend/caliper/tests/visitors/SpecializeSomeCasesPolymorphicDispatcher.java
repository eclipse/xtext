package org.eclipse.xtend.caliper.tests.visitors;

import java.util.Arrays;
import org.eclipse.xtend.caliper.tests.visitors.CaliperArrayTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperParameterizedTypeReference;
import org.eclipse.xtend.caliper.tests.visitors.CaliperTypeReference;

@SuppressWarnings("all")
public class SpecializeSomeCasesPolymorphicDispatcher {
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
  
  public int accept(final CaliperTypeReference reference, final int i, final long k) {
    if (reference instanceof CaliperArrayTypeReference) {
      return _accept((CaliperArrayTypeReference)reference, i, k);
    } else if (reference instanceof CaliperParameterizedTypeReference) {
      return _accept((CaliperParameterizedTypeReference)reference, i, k);
    } else if (reference != null) {
      return _accept(reference, i, k);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(reference, i, k).toString());
    }
  }
}

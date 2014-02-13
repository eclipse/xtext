/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.util;

import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.typesystem.conformance.RawTypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypesOrderUtil {
  @Inject
  private CommonTypeComputationServices services;
  
  public boolean isHandled(final LightweightTypeReference actualTypeReference, final Collection<LightweightTypeReference> collection) {
    boolean _xblockexpression = false;
    {
      for (final LightweightTypeReference previousTypeReference : collection) {
        boolean _isHandled = this.isHandled(actualTypeReference, previousTypeReference);
        if (_isHandled) {
          return true;
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean isHandled(final LightweightTypeReference actualTypeReference, final LightweightTypeReference previousTypeReference) {
    boolean _xblockexpression = false;
    {
      @Extension
      final TypeConformanceComputer typeConformanceComputer = this.services.getTypeConformanceComputer();
      int _bitwiseOr = (RawTypeConformanceComputer.ALLOW_BOXING_UNBOXING | RawTypeConformanceComputer.ALLOW_PRIMITIVE_WIDENING);
      int _bitwiseOr_1 = (_bitwiseOr | RawTypeConformanceComputer.ALLOW_RAW_TYPE_CONVERSION);
      final int conformant = typeConformanceComputer.isConformant(previousTypeReference, actualTypeReference, _bitwiseOr_1);
      int _bitwiseAnd = (conformant & RawTypeConformanceComputer.SUCCESS);
      _xblockexpression = (_bitwiseAnd != 0);
    }
    return _xblockexpression;
  }
}

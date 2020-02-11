/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
 * Small utilitiy class that allows to check whether a given type was already handled in a chain
 * of instanceof checks, e.g to validate catch-clauses or switch expressions.
 * 
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
      final int conformant = typeConformanceComputer.isConformant(previousTypeReference, actualTypeReference, 
        ((RawTypeConformanceComputer.ALLOW_BOXING_UNBOXING | RawTypeConformanceComputer.ALLOW_PRIMITIVE_WIDENING) | RawTypeConformanceComputer.ALLOW_RAW_TYPE_CONVERSION));
      _xblockexpression = ((conformant & RawTypeConformanceComputer.SUCCESS) != 0);
    }
    return _xblockexpression;
  }
}

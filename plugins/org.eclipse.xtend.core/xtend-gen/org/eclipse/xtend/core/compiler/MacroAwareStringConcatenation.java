/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.compiler;

import java.util.Arrays;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.output.ImportingStringConcatenation;
import org.eclipse.xtext.xbase.compiler.output.SharedAppendableState;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class MacroAwareStringConcatenation extends ImportingStringConcatenation {
  public MacroAwareStringConcatenation(final SharedAppendableState state, final ITypeReferenceOwner typeReferenceOwner) {
    super(state, typeReferenceOwner);
  }
  
  protected String _getStringRepresentation(final TypeReferenceImpl object) {
    LightweightTypeReference _delegate = object.getDelegate();
    return this._getStringRepresentation(_delegate);
  }
  
  protected String getStringRepresentation(final Object object) {
    if (object instanceof JvmType) {
      return _getStringRepresentation((JvmType)object);
    } else if (object instanceof TypeReferenceImpl) {
      return _getStringRepresentation((TypeReferenceImpl)object);
    } else if (object instanceof JvmTypeReference) {
      return _getStringRepresentation((JvmTypeReference)object);
    } else if (object instanceof Class) {
      return _getStringRepresentation((Class<?>)object);
    } else if (object instanceof LightweightTypeReference) {
      return _getStringRepresentation((LightweightTypeReference)object);
    } else if (object != null) {
      return _getStringRepresentation(object);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(object).toString());
    }
  }
}

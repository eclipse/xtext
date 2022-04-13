/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.compiler;

import java.util.Arrays;
import org.eclipse.xtend.core.macro.declaration.JvmTypeDeclarationImpl;
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
    return this._getStringRepresentation(object.getDelegate());
  }

  protected String _getStringRepresentation(final JvmTypeDeclarationImpl<?> object) {
    final JvmType type = object.getDelegate();
    return this._getStringRepresentation(type);
  }

  protected String getStringRepresentation(final Object object) {
    if (object instanceof JvmTypeDeclarationImpl) {
      return _getStringRepresentation((JvmTypeDeclarationImpl<?>)object);
    } else if (object instanceof JvmType) {
      return _getStringRepresentation((JvmType)object);
    } else if (object instanceof Class) {
      return _getStringRepresentation((Class<?>)object);
    } else if (object instanceof TypeReferenceImpl) {
      return _getStringRepresentation((TypeReferenceImpl)object);
    } else if (object instanceof JvmTypeReference) {
      return _getStringRepresentation((JvmTypeReference)object);
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

/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.macro.declaration.PrimitiveType;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;

@SuppressWarnings("all")
public class PrimitiveTypeImpl extends AbstractElementImpl<JvmPrimitiveType> implements PrimitiveType {
  @Override
  public PrimitiveType.Kind getKind() {
    PrimitiveType.Kind _switchResult = null;
    String _simpleName = this.getSimpleName();
    if (_simpleName != null) {
      switch (_simpleName) {
        case "boolean":
          _switchResult = PrimitiveType.Kind.BOOLEAN;
          break;
        case "int":
          _switchResult = PrimitiveType.Kind.INT;
          break;
        case "char":
          _switchResult = PrimitiveType.Kind.CHAR;
          break;
        case "double":
          _switchResult = PrimitiveType.Kind.DOUBLE;
          break;
        case "long":
          _switchResult = PrimitiveType.Kind.LONG;
          break;
        case "short":
          _switchResult = PrimitiveType.Kind.SHORT;
          break;
        case "float":
          _switchResult = PrimitiveType.Kind.FLOAT;
          break;
        case "byte":
          _switchResult = PrimitiveType.Kind.BYTE;
          break;
      }
    }
    return _switchResult;
  }

  @Override
  public String getSimpleName() {
    return this.getDelegate().getIdentifier();
  }

  @Override
  public boolean isAssignableFrom(final Type otherType) {
    if ((otherType == null)) {
      return false;
    }
    final TypeReference thisTypeRef = this.getCompilationUnit().getTypeReferenceProvider().newTypeReference(this);
    final TypeReference thatTypeRef = this.getCompilationUnit().getTypeReferenceProvider().newTypeReference(otherType);
    return thisTypeRef.isAssignableFrom(thatTypeRef);
  }

  @Override
  public String getQualifiedName() {
    return this.getSimpleName();
  }
}

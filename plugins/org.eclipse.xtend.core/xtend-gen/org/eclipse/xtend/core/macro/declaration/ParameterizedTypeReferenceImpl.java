/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeReferenceImpl;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.type.ParameterizedTypeReference;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ParameterizedTypeReferenceImpl extends JvmTypeReferenceImpl<JvmParameterizedTypeReference> implements ParameterizedTypeReference {
  public List<TypeReference> getActualTypeArguments() {
    JvmParameterizedTypeReference _delegate = this.getDelegate();
    EList<JvmTypeReference> _arguments = _delegate.getArguments();
    final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
        public TypeReference apply(final JvmTypeReference it) {
          CompilationUnitImpl _compilationUnit = ParameterizedTypeReferenceImpl.this.getCompilationUnit();
          TypeReference _typeReference = _compilationUnit.toTypeReference(it);
          return _typeReference;
        }
      };
    List<TypeReference> _map = ListExtensions.<JvmTypeReference, TypeReference>map(_arguments, _function);
    return _map;
  }
  
  public Type getType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmParameterizedTypeReference _delegate = this.getDelegate();
    JvmType _type = _delegate.getType();
    Type _type_1 = _compilationUnit.toType(_type);
    return _type_1;
  }
}

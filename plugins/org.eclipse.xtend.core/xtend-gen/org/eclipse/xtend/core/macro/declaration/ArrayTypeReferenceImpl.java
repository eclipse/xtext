/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeReferenceImpl;
import org.eclipse.xtend.lib.macro.type.ArrayTypeReference;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

@SuppressWarnings("all")
public class ArrayTypeReferenceImpl extends JvmTypeReferenceImpl<JvmGenericArrayTypeReference> implements ArrayTypeReference {
  public int getDimensions() {
    JvmGenericArrayTypeReference _delegate = this.getDelegate();
    int _dimensions = _delegate.getDimensions();
    return _dimensions;
  }
  
  public TypeReference getComponentType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmGenericArrayTypeReference _delegate = this.getDelegate();
    JvmTypeReference _componentType = _delegate.getComponentType();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_componentType);
    return _typeReference;
  }
}

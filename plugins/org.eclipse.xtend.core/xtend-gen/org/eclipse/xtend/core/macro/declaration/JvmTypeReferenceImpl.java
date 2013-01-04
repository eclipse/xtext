/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.AbstractDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;

@SuppressWarnings("all")
public abstract class JvmTypeReferenceImpl<T extends JvmTypeReference> extends AbstractDeclarationImpl<T> implements TypeReference {
  private TypeReferenceSerializer _serializer;
  
  public TypeReferenceSerializer getSerializer() {
    return this._serializer;
  }
  
  public void setSerializer(final TypeReferenceSerializer serializer) {
    this._serializer = serializer;
  }
  
  public Type getType() {
    return null;
  }
  
  public String toString() {
    StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable();
    final StringBuilderBasedAppendable appendable = _stringBuilderBasedAppendable;
    TypeReferenceSerializer _serializer = this.getSerializer();
    JvmTypeReference _delegate = this.getDelegate();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendFile _xtendFile = _compilationUnit.getXtendFile();
    _serializer.serialize(_delegate, _xtendFile, appendable);
    return appendable.toString();
  }
}

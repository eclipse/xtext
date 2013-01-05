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
import org.eclipse.xtend.core.macro.declaration.SourceMemberDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.lib.macro.declaration.SourceConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class SourceConstructorDeclarationImpl extends SourceMemberDeclarationImpl<XtendConstructor> implements SourceConstructorDeclaration {
  public Expression getBody() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendConstructor _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    Visibility _visibility_1 = _compilationUnit.toVisibility(_visibility);
    return _visibility_1;
  }
  
  public String getName() {
    SourceTypeDeclaration _declaringType = this.getDeclaringType();
    String _simpleName = _declaringType.getSimpleName();
    return _simpleName;
  }
  
  public boolean isVarArgs() {
    XtendConstructor _delegate = this.getDelegate();
    EList<XtendParameter> _parameters = _delegate.getParameters();
    final Function1<XtendParameter,Boolean> _function = new Function1<XtendParameter,Boolean>() {
        public Boolean apply(final XtendParameter it) {
          boolean _isVarArgs = SourceConstructorDeclarationImpl.this.isVarArgs();
          return Boolean.valueOf(_isVarArgs);
        }
      };
    boolean _exists = IterableExtensions.<XtendParameter>exists(_parameters, _function);
    return _exists;
  }
  
  public List<TypeReference> getExceptions() {
    XtendConstructor _delegate = this.getDelegate();
    EList<JvmTypeReference> _exceptions = _delegate.getExceptions();
    final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
        public TypeReference apply(final JvmTypeReference it) {
          CompilationUnitImpl _compilationUnit = SourceConstructorDeclarationImpl.this.getCompilationUnit();
          TypeReference _typeReference = _compilationUnit.toTypeReference(it);
          return _typeReference;
        }
      };
    List<TypeReference> _map = ListExtensions.<JvmTypeReference, TypeReference>map(_exceptions, _function);
    return _map;
  }
  
  public List<SourceParameterDeclaration> getParameters() {
    XtendConstructor _delegate = this.getDelegate();
    EList<XtendParameter> _parameters = _delegate.getParameters();
    final Function1<XtendParameter,SourceParameterDeclaration> _function = new Function1<XtendParameter,SourceParameterDeclaration>() {
        public SourceParameterDeclaration apply(final XtendParameter it) {
          CompilationUnitImpl _compilationUnit = SourceConstructorDeclarationImpl.this.getCompilationUnit();
          SourceParameterDeclaration _sourceParameterDeclaration = _compilationUnit.toSourceParameterDeclaration(it);
          return _sourceParameterDeclaration;
        }
      };
    List<SourceParameterDeclaration> _map = ListExtensions.<XtendParameter, SourceParameterDeclaration>map(_parameters, _function);
    return _map;
  }
  
  public List<SourceTypeParameterDeclaration> getTypeParameters() {
    List<SourceTypeParameterDeclaration> _emptyList = CollectionLiterals.<SourceTypeParameterDeclaration>emptyList();
    return _emptyList;
  }
}

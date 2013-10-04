/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.ExpressionImpl;
import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class JvmFieldDeclarationImpl extends JvmMemberDeclarationImpl<JvmField> implements MutableFieldDeclaration {
  public Expression getInitializer() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
    JvmTypesBuilder _jvmTypesBuilder = _compilationUnit_1.getJvmTypesBuilder();
    JvmField _delegate = this.getDelegate();
    XExpression _expression = _jvmTypesBuilder.getExpression(_delegate);
    Expression _expression_1 = _compilationUnit.toExpression(_expression);
    return _expression_1;
  }
  
  public void setInitializer(final Expression initializer) {
    boolean _equals = Objects.equal(initializer, null);
    if (_equals) {
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      JvmTypesBuilder _jvmTypesBuilder = _compilationUnit.getJvmTypesBuilder();
      JvmField _delegate = this.getDelegate();
      _jvmTypesBuilder.removeExistingBody(_delegate);
    } else {
      CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
      JvmTypesBuilder _jvmTypesBuilder_1 = _compilationUnit_1.getJvmTypesBuilder();
      JvmField _delegate_1 = this.getDelegate();
      XExpression _delegate_2 = ((ExpressionImpl) initializer).getDelegate();
      _jvmTypesBuilder_1.setInitializer(_delegate_1, _delegate_2);
    }
  }
  
  public void setInitializer(final CompilationStrategy initializer) {
    boolean _notEquals = (!Objects.equal(initializer, null));
    Preconditions.checkArgument(_notEquals, "initializer cannot be null");
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    _compilationUnit.setCompilationStrategy(_delegate, initializer);
  }
  
  public void setInitializer(final StringConcatenationClient template) {
    boolean _notEquals = (!Objects.equal(template, null));
    Preconditions.checkArgument(_notEquals, "template cannot be null");
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    _compilationUnit.setCompilationTemplate(_delegate, template);
  }
  
  public boolean isFinal() {
    JvmField _delegate = this.getDelegate();
    boolean _isFinal = _delegate.isFinal();
    return _isFinal;
  }
  
  public boolean isStatic() {
    JvmField _delegate = this.getDelegate();
    boolean _isStatic = _delegate.isStatic();
    return _isStatic;
  }
  
  public boolean isTransient() {
    JvmField _delegate = this.getDelegate();
    boolean _isTransient = _delegate.isTransient();
    return _isTransient;
  }
  
  public boolean isVolatile() {
    JvmField _delegate = this.getDelegate();
    boolean _isVolatile = _delegate.isVolatile();
    return _isVolatile;
  }
  
  public TypeReference getType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    JvmTypeReference _type = _delegate.getType();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_type);
    return _typeReference;
  }
  
  public void setFinal(final boolean isFinal) {
    JvmField _delegate = this.getDelegate();
    _delegate.setFinal(isFinal);
  }
  
  public void setStatic(final boolean isStatic) {
    JvmField _delegate = this.getDelegate();
    _delegate.setStatic(isStatic);
  }
  
  public void setTransient(final boolean isTransient) {
    JvmField _delegate = this.getDelegate();
    _delegate.setTransient(isTransient);
  }
  
  public void setVolatile(final boolean isVolatile) {
    JvmField _delegate = this.getDelegate();
    _delegate.setVolatile(isVolatile);
  }
  
  public void setType(final TypeReference type) {
    boolean _notEquals = (!Objects.equal(type, null));
    Preconditions.checkArgument(_notEquals, "type cannot be null");
    JvmField _delegate = this.getDelegate();
    LightweightTypeReference _lightWeightTypeReference = ((TypeReferenceImpl) type).getLightWeightTypeReference();
    JvmTypeReference _javaCompliantTypeReference = _lightWeightTypeReference.toJavaCompliantTypeReference();
    _delegate.setType(_javaCompliantTypeReference);
  }
}

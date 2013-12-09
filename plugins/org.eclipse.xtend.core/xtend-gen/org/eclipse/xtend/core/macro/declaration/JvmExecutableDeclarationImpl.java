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
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.ExpressionImpl;
import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.MutableExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class JvmExecutableDeclarationImpl<T extends JvmExecutable> extends JvmMemberDeclarationImpl<T> implements MutableExecutableDeclaration {
  public Iterable<? extends MutableTypeParameterDeclaration> getTypeParameters() {
    T _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,MutableTypeParameterDeclaration> _function = new Function1<JvmTypeParameter,MutableTypeParameterDeclaration>() {
      public MutableTypeParameterDeclaration apply(final JvmTypeParameter it) {
        CompilationUnitImpl _compilationUnit = JvmExecutableDeclarationImpl.this.getCompilationUnit();
        MutableTypeParameterDeclaration _typeParameterDeclaration = _compilationUnit.toTypeParameterDeclaration(it);
        return _typeParameterDeclaration;
      }
    };
    List<MutableTypeParameterDeclaration> _map = ListExtensions.<JvmTypeParameter, MutableTypeParameterDeclaration>map(_typeParameters, _function);
    return _map;
  }
  
  public boolean isVarArgs() {
    T _delegate = this.getDelegate();
    boolean _isVarArgs = _delegate.isVarArgs();
    return _isVarArgs;
  }
  
  public Iterable<? extends MutableParameterDeclaration> getParameters() {
    T _delegate = this.getDelegate();
    EList<JvmFormalParameter> _parameters = _delegate.getParameters();
    final Function1<JvmFormalParameter,MutableParameterDeclaration> _function = new Function1<JvmFormalParameter,MutableParameterDeclaration>() {
      public MutableParameterDeclaration apply(final JvmFormalParameter it) {
        CompilationUnitImpl _compilationUnit = JvmExecutableDeclarationImpl.this.getCompilationUnit();
        MutableParameterDeclaration _parameterDeclaration = _compilationUnit.toParameterDeclaration(it);
        return _parameterDeclaration;
      }
    };
    List<MutableParameterDeclaration> _map = ListExtensions.<JvmFormalParameter, MutableParameterDeclaration>map(_parameters, _function);
    return _map;
  }
  
  public Iterable<? extends TypeReference> getExceptions() {
    T _delegate = this.getDelegate();
    EList<JvmTypeReference> _exceptions = _delegate.getExceptions();
    final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
      public TypeReference apply(final JvmTypeReference it) {
        CompilationUnitImpl _compilationUnit = JvmExecutableDeclarationImpl.this.getCompilationUnit();
        TypeReference _typeReference = _compilationUnit.toTypeReference(it);
        return _typeReference;
      }
    };
    List<TypeReference> _map = ListExtensions.<JvmTypeReference, TypeReference>map(_exceptions, _function);
    return _map;
  }
  
  public Expression getBody() {
    Expression _xblockexpression = null;
    {
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      JvmTypesBuilder _jvmTypesBuilder = _compilationUnit.getJvmTypesBuilder();
      T _delegate = this.getDelegate();
      final XExpression expression = _jvmTypesBuilder.getExpression(_delegate);
      CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
      Expression _expression = _compilationUnit_1.toExpression(expression);
      _xblockexpression = (_expression);
    }
    return _xblockexpression;
  }
  
  public void setBody(final Expression body) {
    boolean _equals = Objects.equal(body, null);
    if (_equals) {
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      JvmTypesBuilder _jvmTypesBuilder = _compilationUnit.getJvmTypesBuilder();
      T _delegate = this.getDelegate();
      _jvmTypesBuilder.removeExistingBody(_delegate);
    } else {
      CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
      JvmTypesBuilder _jvmTypesBuilder_1 = _compilationUnit_1.getJvmTypesBuilder();
      T _delegate_1 = this.getDelegate();
      XExpression _delegate_2 = ((ExpressionImpl) body).getDelegate();
      _jvmTypesBuilder_1.setBody(_delegate_1, _delegate_2);
    }
  }
  
  public void setExceptions(final TypeReference... exceptions) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(exceptions)), "exceptions");
    T _delegate = this.getDelegate();
    EList<JvmTypeReference> _exceptions = _delegate.getExceptions();
    _exceptions.clear();
    for (final TypeReference exceptionType : exceptions) {
      boolean _notEquals = (!Objects.equal(exceptionType, null));
      if (_notEquals) {
        T _delegate_1 = this.getDelegate();
        EList<JvmTypeReference> _exceptions_1 = _delegate_1.getExceptions();
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        JvmTypeReference _jvmTypeReference = _compilationUnit.toJvmTypeReference(exceptionType);
        _exceptions_1.add(_jvmTypeReference);
      }
    }
  }
  
  public void setVarArgs(final boolean isVarArgs) {
    T _delegate = this.getDelegate();
    _delegate.setVarArgs(isVarArgs);
  }
  
  public MutableTypeParameterDeclaration addTypeParameter(final String name, final TypeReference... upperBounds) {
    ConditionUtils.checkJavaIdentifier(name, "name");
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(upperBounds)), "upperBounds");
    final JvmTypeParameter param = TypesFactory.eINSTANCE.createJvmTypeParameter();
    param.setName(name);
    T _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    _typeParameters.add(param);
    for (final TypeReference upper : upperBounds) {
      {
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        final JvmTypeReference typeRef = _compilationUnit.toJvmTypeReference(upper);
        final JvmUpperBound jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
        jvmUpperBound.setTypeReference(typeRef);
        EList<JvmTypeConstraint> _constraints = param.getConstraints();
        _constraints.add(jvmUpperBound);
      }
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    return _compilationUnit.toTypeParameterDeclaration(param);
  }
  
  public void setBody(final CompilationStrategy compilationStrategy) {
    boolean _notEquals = (!Objects.equal(compilationStrategy, null));
    Preconditions.checkArgument(_notEquals, "compilationStrategy cannot be null");
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    T _delegate = this.getDelegate();
    _compilationUnit.setCompilationStrategy(_delegate, compilationStrategy);
  }
  
  public void setBody(final StringConcatenationClient compilationTemplate) {
    boolean _notEquals = (!Objects.equal(compilationTemplate, null));
    Preconditions.checkArgument(_notEquals, "compilationTemplate cannot be null");
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    T _delegate = this.getDelegate();
    _compilationUnit.setCompilationTemplate(_delegate, compilationTemplate);
  }
  
  public MutableParameterDeclaration addParameter(final String name, final TypeReference type) {
    ConditionUtils.checkJavaIdentifier(name, "name");
    boolean _notEquals = (!Objects.equal(type, null));
    Preconditions.checkArgument(_notEquals, "type cannot be null");
    final JvmFormalParameter param = TypesFactory.eINSTANCE.createJvmFormalParameter();
    param.setName(name);
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmTypeReference _jvmTypeReference = _compilationUnit.toJvmTypeReference(type);
    param.setParameterType(_jvmTypeReference);
    T _delegate = this.getDelegate();
    EList<JvmFormalParameter> _parameters = _delegate.getParameters();
    _parameters.add(param);
    CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
    return _compilationUnit_1.toParameterDeclaration(param);
  }
}

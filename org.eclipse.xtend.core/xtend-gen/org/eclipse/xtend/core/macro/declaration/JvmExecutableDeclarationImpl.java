/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Preconditions;
import java.util.List;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class JvmExecutableDeclarationImpl<T extends JvmExecutable> extends JvmMemberDeclarationImpl<T> {
  public Iterable<? extends TypeParameterDeclaration> getTypeParameters() {
    final Function1<JvmTypeParameter, TypeParameterDeclaration> _function = (JvmTypeParameter it) -> {
      return this.getCompilationUnit().toTypeParameterDeclaration(it);
    };
    return ListExtensions.<JvmTypeParameter, TypeParameterDeclaration>map(this.getDelegate().getTypeParameters(), _function);
  }

  public boolean isVarArgs() {
    return this.getDelegate().isVarArgs();
  }

  public Iterable<? extends ParameterDeclaration> getParameters() {
    final Function1<JvmFormalParameter, ParameterDeclaration> _function = (JvmFormalParameter it) -> {
      return this.getCompilationUnit().toParameterDeclaration(it);
    };
    return ListExtensions.<JvmFormalParameter, ParameterDeclaration>map(this.getDelegate().getParameters(), _function);
  }

  public List<TypeReference> getExceptions() {
    final Function1<JvmTypeReference, TypeReference> _function = (JvmTypeReference it) -> {
      return this.getCompilationUnit().toTypeReference(it);
    };
    return ListExtensions.<JvmTypeReference, TypeReference>map(this.getDelegate().getExceptions(), _function);
  }

  public Expression getBody() {
    Expression _xblockexpression = null;
    {
      final XExpression expression = this.getCompilationUnit().getJvmTypesBuilder().getExpression(this.getDelegate());
      _xblockexpression = this.getCompilationUnit().toExpression(expression);
    }
    return _xblockexpression;
  }

  public void setBody(final Expression body) {
    this.checkMutable();
    if ((body == null)) {
      this.getCompilationUnit().getJvmTypesBuilder().removeExistingBody(this.getDelegate());
    } else {
      this.getCompilationUnit().getJvmTypesBuilder().setBody(this.getDelegate(), ((ExpressionImpl) body).getDelegate());
    }
  }

  public void setExceptions(final TypeReference... exceptions) {
    this.checkMutable();
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(exceptions)), "exceptions");
    ConditionUtils.checkInferredTypeReferences("exception type", exceptions);
    this.getDelegate().getExceptions().clear();
    for (final TypeReference exceptionType : exceptions) {
      if ((exceptionType != null)) {
        this.getDelegate().getExceptions().add(this.getCompilationUnit().toJvmTypeReference(exceptionType));
      }
    }
  }

  public void setVarArgs(final boolean isVarArgs) {
    this.checkMutable();
    this.getDelegate().setVarArgs(isVarArgs);
  }

  public MutableTypeParameterDeclaration addTypeParameter(final String name, final TypeReference... upperBounds) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(upperBounds)), "upperBounds");
    ConditionUtils.checkInferredTypeReferences("parameter type", upperBounds);
    final JvmTypeParameter param = TypesFactory.eINSTANCE.createJvmTypeParameter();
    param.setName(name);
    this.getDelegate().getTypeParameters().add(param);
    for (final TypeReference upper : upperBounds) {
      {
        final JvmTypeReference typeRef = this.getCompilationUnit().toJvmTypeReference(upper);
        final JvmUpperBound jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
        jvmUpperBound.setTypeReference(typeRef);
        param.getConstraints().add(jvmUpperBound);
      }
    }
    TypeParameterDeclaration _typeParameterDeclaration = this.getCompilationUnit().toTypeParameterDeclaration(param);
    return ((MutableTypeParameterDeclaration) _typeParameterDeclaration);
  }

  public void setBody(final CompilationStrategy compilationStrategy) {
    this.checkMutable();
    Preconditions.checkArgument((compilationStrategy != null), "compilationStrategy cannot be null");
    this.getCompilationUnit().setCompilationStrategy(this.getDelegate(), compilationStrategy);
  }

  public void setBody(final StringConcatenationClient compilationTemplate) {
    this.checkMutable();
    Preconditions.checkArgument((compilationTemplate != null), "compilationTemplate cannot be null");
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), compilationTemplate);
  }

  public MutableParameterDeclaration addParameter(final String name, final TypeReference type) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    Preconditions.checkArgument((type != null), "type cannot be null");
    boolean _isInferred = type.isInferred();
    if (_isInferred) {
      throw new IllegalArgumentException("Cannot use inferred type as parameter type.");
    }
    final JvmFormalParameter param = TypesFactory.eINSTANCE.createJvmFormalParameter();
    param.setName(name);
    param.setParameterType(this.getCompilationUnit().toJvmTypeReference(type));
    this.getDelegate().getParameters().add(param);
    ParameterDeclaration _parameterDeclaration = this.getCompilationUnit().toParameterDeclaration(param);
    return ((MutableParameterDeclaration) _parameterDeclaration);
  }

  @Override
  public void remove() {
    this.getCompilationUnit().getJvmModelAssociator().removeLogicalChildAssociation(this.getDelegate());
    super.remove();
  }
}

/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.AnnotationLookup;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class MemberFromSuperImplementor {
  @Inject
  private IXtendJvmAssociations associations;

  @Inject
  private CodeBuilderFactory codeBuilderFactory;

  @Inject
  private AnnotationLookup annotationLookup;

  @Inject
  @Extension
  private TypesFactory typesFactory;

  public void appendOverrideFunction(final XtendTypeDeclaration overrider, final IResolvedOperation overriddenOperation, final ISourceAppender appendable) {
    final JvmDeclaredType inferredType = this.associations.getInferredType(overrider);
    final AbstractMethodBuilder methodBuilder = this.codeBuilderFactory.createMethodBuilder(inferredType);
    this.initializeExecutableBuilder(methodBuilder, inferredType, overriddenOperation);
    methodBuilder.setOverrideFlag(true);
    methodBuilder.setMethodName(overriddenOperation.getDeclaration().getSimpleName());
    methodBuilder.setReturnType(overriddenOperation.getResolvedReturnType());
    boolean _isSynchronized = overriddenOperation.getDeclaration().isSynchronized();
    if (_isSynchronized) {
      methodBuilder.setSynchronizedFlag(true);
    }
    boolean _isEmpty = overriddenOperation.getResolvedTypeParameters().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final ArrayList<JvmTypeParameter> typeParameters = CollectionLiterals.<JvmTypeParameter>newArrayList();
      final Procedure2<JvmTypeParameter, Integer> _function = (JvmTypeParameter typeParam, Integer idx) -> {
        final JvmTypeParameter newTypeParam = this.typesFactory.createJvmTypeParameter();
        newTypeParam.setName(typeParam.getName());
        final Consumer<LightweightTypeReference> _function_1 = (LightweightTypeReference it) -> {
          final JvmUpperBound upperBound = this.typesFactory.createJvmUpperBound();
          upperBound.setTypeReference(it.toJavaCompliantTypeReference());
          EList<JvmTypeConstraint> _constraints = newTypeParam.getConstraints();
          _constraints.add(upperBound);
        };
        overriddenOperation.getResolvedTypeParameterConstraints((idx).intValue()).forEach(_function_1);
        typeParameters.add(newTypeParam);
      };
      IterableExtensions.<JvmTypeParameter>forEach(overriddenOperation.getResolvedTypeParameters(), _function);
      methodBuilder.setTypeParameters(typeParameters);
    }
    boolean _isAbstract = overriddenOperation.getDeclaration().isAbstract();
    boolean _not_1 = (!_isAbstract);
    if (_not_1) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("super.");
      {
        List<JvmTypeParameter> _resolvedTypeParameters = overriddenOperation.getResolvedTypeParameters();
        boolean _hasElements = false;
        for(final JvmTypeParameter typeParam : _resolvedTypeParameters) {
          if (!_hasElements) {
            _hasElements = true;
            _builder.append("<");
          } else {
            _builder.appendImmediate(", ", "");
          }
          String _simpleName = typeParam.getSimpleName();
          _builder.append(_simpleName);
        }
        if (_hasElements) {
          _builder.append(">");
        }
      }
      String _simpleName_1 = overriddenOperation.getDeclaration().getSimpleName();
      _builder.append(_simpleName_1);
      _builder.append("(");
      final Function1<JvmFormalParameter, String> _function_1 = (JvmFormalParameter it) -> {
        return it.getSimpleName();
      };
      String _join = IterableExtensions.join(ListExtensions.<JvmFormalParameter, String>map(overriddenOperation.getDeclaration().getParameters(), _function_1), ", ");
      _builder.append(_join);
      _builder.append(")");
      final String body = _builder.toString();
      final Procedure1<? super ISourceAppender> superTypeRef = this.getImplementedInterface(inferredType, overriddenOperation.getDeclaration().getDeclaringType());
      final Procedure1<ISourceAppender> _function_2 = (ISourceAppender it) -> {
        if (superTypeRef!=null) {
          superTypeRef.apply(it);
        }
        it.append(body);
      };
      methodBuilder.setBodyGenerator(_function_2);
    }
    boolean _isValid = methodBuilder.isValid();
    if (_isValid) {
      methodBuilder.build(appendable);
    }
  }

  private Procedure1<? super ISourceAppender> getImplementedInterface(final JvmDeclaredType subType, final JvmDeclaredType superInterface) {
    if (((superInterface instanceof JvmGenericType) && ((JvmGenericType) superInterface).isInterface())) {
      final Function1<JvmTypeReference, Boolean> _function = (JvmTypeReference it) -> {
        JvmType _type = it.getType();
        return Boolean.valueOf(Objects.equal(_type, superInterface));
      };
      boolean _exists = IterableExtensions.<JvmTypeReference>exists(subType.getSuperTypes(), _function);
      if (_exists) {
        final Procedure1<ISourceAppender> _function_1 = (ISourceAppender it) -> {
          it.append(superInterface).append(".");
        };
        return _function_1;
      }
      final Function1<JvmTypeReference, Boolean> _function_2 = (JvmTypeReference it) -> {
        return Boolean.valueOf(this.isInterface(it.getType()));
      };
      final Function1<JvmTypeReference, JvmDeclaredType> _function_3 = (JvmTypeReference it) -> {
        JvmType _type = it.getType();
        return ((JvmDeclaredType) _type);
      };
      final Function1<JvmDeclaredType, Boolean> _function_4 = (JvmDeclaredType it) -> {
        Procedure1<? super ISourceAppender> _implementedInterface = this.getImplementedInterface(it, superInterface);
        return Boolean.valueOf((_implementedInterface != null));
      };
      final JvmDeclaredType interfaze = IterableExtensions.<JvmDeclaredType>findFirst(IterableExtensions.<JvmTypeReference, JvmDeclaredType>map(IterableExtensions.<JvmTypeReference>filter(subType.getSuperTypes(), _function_2), _function_3), _function_4);
      if ((interfaze != null)) {
        final Procedure1<ISourceAppender> _function_5 = (ISourceAppender it) -> {
          it.append(interfaze).append(".");
        };
        return _function_5;
      }
    }
    return null;
  }

  private boolean isInterface(final JvmType type) {
    return ((type instanceof JvmGenericType) && ((JvmGenericType) type).isInterface());
  }

  public void appendConstructorFromSuper(final XtendClass overrider, final IResolvedConstructor superConstructor, final ISourceAppender appendable) {
    final JvmGenericType inferredType = this.associations.getInferredType(overrider);
    final AbstractConstructorBuilder constructorBuilder = this.codeBuilderFactory.createConstructorBuilder(inferredType);
    this.initializeExecutableBuilder(constructorBuilder, inferredType, superConstructor);
    final Procedure1<ISourceAppender> _function = (ISourceAppender it) -> {
      boolean _isEmpty = superConstructor.getResolvedParameterTypes().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("super(");
        final Function1<JvmFormalParameter, String> _function_1 = (JvmFormalParameter it_1) -> {
          return it_1.getSimpleName();
        };
        String _join = IterableExtensions.join(ListExtensions.<JvmFormalParameter, String>map(superConstructor.getDeclaration().getParameters(), _function_1), ", ");
        _builder.append(_join);
        _builder.append(")");
        it.append(_builder);
      }
    };
    constructorBuilder.setBodyGenerator(_function);
    boolean _isValid = constructorBuilder.isValid();
    if (_isValid) {
      constructorBuilder.build(appendable);
    }
  }

  protected void initializeExecutableBuilder(final AbstractExecutableBuilder builder, final JvmDeclaredType overrider, final IResolvedExecutable overridden) {
    final JvmExecutable executable = overridden.getDeclaration();
    builder.setContext(overrider);
    builder.setVisibility(overridden.getDeclaration().getVisibility());
    final Procedure2<LightweightTypeReference, Integer> _function = (LightweightTypeReference it, Integer index) -> {
      final JvmFormalParameter declaredParameter = executable.getParameters().get((index).intValue());
      final AbstractParameterBuilder parameterBuilder = builder.newParameterBuilder();
      parameterBuilder.setName(declaredParameter.getSimpleName());
      parameterBuilder.setType(it);
      JvmAnnotationReference _findAnnotation = this.annotationLookup.findAnnotation(declaredParameter, Extension.class);
      boolean _tripleNotEquals = (_findAnnotation != null);
      parameterBuilder.setExtensionFlag(_tripleNotEquals);
    };
    IterableExtensions.<LightweightTypeReference>forEach(overridden.getResolvedParameterTypes(), _function);
    builder.setVarArgsFlag(executable.isVarArgs());
    builder.setExceptions(overridden.getResolvedExceptions());
  }
}

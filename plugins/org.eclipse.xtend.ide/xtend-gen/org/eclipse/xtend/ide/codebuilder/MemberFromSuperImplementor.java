/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.AbstractConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractExecutableBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractParameterBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
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
    JvmOperation _declaration = overriddenOperation.getDeclaration();
    String _simpleName = _declaration.getSimpleName();
    methodBuilder.setMethodName(_simpleName);
    LightweightTypeReference _resolvedReturnType = overriddenOperation.getResolvedReturnType();
    methodBuilder.setReturnType(_resolvedReturnType);
    List<JvmTypeParameter> _resolvedTypeParameters = overriddenOperation.getResolvedTypeParameters();
    boolean _isEmpty = _resolvedTypeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final ArrayList<JvmTypeParameter> typeParameters = CollectionLiterals.<JvmTypeParameter>newArrayList();
      List<JvmTypeParameter> _resolvedTypeParameters_1 = overriddenOperation.getResolvedTypeParameters();
      final Procedure2<JvmTypeParameter, Integer> _function = new Procedure2<JvmTypeParameter, Integer>() {
        @Override
        public void apply(final JvmTypeParameter typeParam, final Integer idx) {
          final JvmTypeParameter newTypeParam = MemberFromSuperImplementor.this.typesFactory.createJvmTypeParameter();
          String _name = typeParam.getName();
          newTypeParam.setName(_name);
          List<LightweightTypeReference> _resolvedTypeParameterConstraints = overriddenOperation.getResolvedTypeParameterConstraints((idx).intValue());
          for (final LightweightTypeReference it : _resolvedTypeParameterConstraints) {
            {
              final JvmUpperBound upperBound = MemberFromSuperImplementor.this.typesFactory.createJvmUpperBound();
              JvmTypeReference _javaCompliantTypeReference = it.toJavaCompliantTypeReference();
              upperBound.setTypeReference(_javaCompliantTypeReference);
              EList<JvmTypeConstraint> _constraints = newTypeParam.getConstraints();
              _constraints.add(upperBound);
            }
          }
          typeParameters.add(newTypeParam);
        }
      };
      IterableExtensions.<JvmTypeParameter>forEach(_resolvedTypeParameters_1, _function);
      methodBuilder.setTypeParameters(typeParameters);
    }
    JvmOperation _declaration_1 = overriddenOperation.getDeclaration();
    boolean _isAbstract = _declaration_1.isAbstract();
    boolean _not_1 = (!_isAbstract);
    if (_not_1) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("super.");
      {
        List<JvmTypeParameter> _resolvedTypeParameters_2 = overriddenOperation.getResolvedTypeParameters();
        boolean _hasElements = false;
        for(final JvmTypeParameter typeParam : _resolvedTypeParameters_2) {
          if (!_hasElements) {
            _hasElements = true;
            _builder.append("<", "");
          } else {
            _builder.appendImmediate(", ", "");
          }
          String _simpleName_1 = typeParam.getSimpleName();
          _builder.append(_simpleName_1, "");
        }
        if (_hasElements) {
          _builder.append(">", "");
        }
      }
      JvmOperation _declaration_2 = overriddenOperation.getDeclaration();
      String _simpleName_2 = _declaration_2.getSimpleName();
      _builder.append(_simpleName_2, "");
      _builder.append("(");
      JvmOperation _declaration_3 = overriddenOperation.getDeclaration();
      EList<JvmFormalParameter> _parameters = _declaration_3.getParameters();
      final Function1<JvmFormalParameter, String> _function_1 = new Function1<JvmFormalParameter, String>() {
        @Override
        public String apply(final JvmFormalParameter it) {
          return it.getSimpleName();
        }
      };
      List<String> _map = ListExtensions.<JvmFormalParameter, String>map(_parameters, _function_1);
      String _join = IterableExtensions.join(_map, ", ");
      _builder.append(_join, "");
      _builder.append(")");
      final String body = _builder.toString();
      JvmOperation _declaration_4 = overriddenOperation.getDeclaration();
      JvmDeclaredType _declaringType = _declaration_4.getDeclaringType();
      final Procedure1<? super ISourceAppender> superTypeRef = this.getImplementedInterface(inferredType, _declaringType);
      final Procedure1<ISourceAppender> _function_2 = new Procedure1<ISourceAppender>() {
        @Override
        public void apply(final ISourceAppender it) {
          if (superTypeRef!=null) {
            superTypeRef.apply(it);
          }
          it.append(body);
        }
      };
      methodBuilder.setBodyGenerator(_function_2);
    }
    boolean _isValid = methodBuilder.isValid();
    if (_isValid) {
      methodBuilder.build(appendable);
    }
  }
  
  private Procedure1<? super ISourceAppender> getImplementedInterface(final JvmDeclaredType subType, final JvmDeclaredType superInterface) {
    boolean _and = false;
    if (!(superInterface instanceof JvmGenericType)) {
      _and = false;
    } else {
      boolean _isInterface = ((JvmGenericType) superInterface).isInterface();
      _and = _isInterface;
    }
    if (_and) {
      EList<JvmTypeReference> _superTypes = subType.getSuperTypes();
      final Function1<JvmTypeReference, Boolean> _function = new Function1<JvmTypeReference, Boolean>() {
        @Override
        public Boolean apply(final JvmTypeReference it) {
          JvmType _type = it.getType();
          return Boolean.valueOf(Objects.equal(_type, superInterface));
        }
      };
      boolean _exists = IterableExtensions.<JvmTypeReference>exists(_superTypes, _function);
      if (_exists) {
        final Procedure1<ISourceAppender> _function_1 = new Procedure1<ISourceAppender>() {
          @Override
          public void apply(final ISourceAppender it) {
            ISourceAppender _append = it.append(superInterface);
            _append.append(".");
          }
        };
        return _function_1;
      }
      EList<JvmTypeReference> _superTypes_1 = subType.getSuperTypes();
      final Function1<JvmTypeReference, Boolean> _function_2 = new Function1<JvmTypeReference, Boolean>() {
        @Override
        public Boolean apply(final JvmTypeReference it) {
          JvmType _type = it.getType();
          return Boolean.valueOf(MemberFromSuperImplementor.this.isInterface(_type));
        }
      };
      Iterable<JvmTypeReference> _filter = IterableExtensions.<JvmTypeReference>filter(_superTypes_1, _function_2);
      final Function1<JvmTypeReference, JvmDeclaredType> _function_3 = new Function1<JvmTypeReference, JvmDeclaredType>() {
        @Override
        public JvmDeclaredType apply(final JvmTypeReference it) {
          JvmType _type = it.getType();
          return ((JvmDeclaredType) _type);
        }
      };
      Iterable<JvmDeclaredType> _map = IterableExtensions.<JvmTypeReference, JvmDeclaredType>map(_filter, _function_3);
      final Function1<JvmDeclaredType, Boolean> _function_4 = new Function1<JvmDeclaredType, Boolean>() {
        @Override
        public Boolean apply(final JvmDeclaredType it) {
          Procedure1<? super ISourceAppender> _implementedInterface = MemberFromSuperImplementor.this.getImplementedInterface(it, superInterface);
          return Boolean.valueOf((!Objects.equal(_implementedInterface, null)));
        }
      };
      final JvmDeclaredType interfaze = IterableExtensions.<JvmDeclaredType>findFirst(_map, _function_4);
      boolean _notEquals = (!Objects.equal(interfaze, null));
      if (_notEquals) {
        final Procedure1<ISourceAppender> _function_5 = new Procedure1<ISourceAppender>() {
          @Override
          public void apply(final ISourceAppender it) {
            ISourceAppender _append = it.append(interfaze);
            _append.append(".");
          }
        };
        return _function_5;
      }
    }
    return null;
  }
  
  private boolean isInterface(final JvmType type) {
    boolean _and = false;
    if (!(type instanceof JvmGenericType)) {
      _and = false;
    } else {
      boolean _isInterface = ((JvmGenericType) type).isInterface();
      _and = _isInterface;
    }
    return _and;
  }
  
  public void appendConstructorFromSuper(final XtendClass overrider, final IResolvedConstructor superConstructor, final ISourceAppender appendable) {
    final JvmGenericType inferredType = this.associations.getInferredType(overrider);
    final AbstractConstructorBuilder constructorBuilder = this.codeBuilderFactory.createConstructorBuilder(inferredType);
    this.initializeExecutableBuilder(constructorBuilder, inferredType, superConstructor);
    final Procedure1<ISourceAppender> _function = new Procedure1<ISourceAppender>() {
      @Override
      public void apply(final ISourceAppender it) {
        List<LightweightTypeReference> _resolvedParameterTypes = superConstructor.getResolvedParameterTypes();
        boolean _isEmpty = _resolvedParameterTypes.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("super(");
          JvmConstructor _declaration = superConstructor.getDeclaration();
          EList<JvmFormalParameter> _parameters = _declaration.getParameters();
          final Function1<JvmFormalParameter, String> _function = new Function1<JvmFormalParameter, String>() {
            @Override
            public String apply(final JvmFormalParameter it) {
              return it.getSimpleName();
            }
          };
          List<String> _map = ListExtensions.<JvmFormalParameter, String>map(_parameters, _function);
          String _join = IterableExtensions.join(_map, ", ");
          _builder.append(_join, "");
          _builder.append(")");
          it.append(_builder);
        }
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
    JvmExecutable _declaration = overridden.getDeclaration();
    JvmVisibility _visibility = _declaration.getVisibility();
    builder.setVisibility(_visibility);
    List<LightweightTypeReference> _resolvedParameterTypes = overridden.getResolvedParameterTypes();
    final Procedure2<LightweightTypeReference, Integer> _function = new Procedure2<LightweightTypeReference, Integer>() {
      @Override
      public void apply(final LightweightTypeReference it, final Integer index) {
        EList<JvmFormalParameter> _parameters = executable.getParameters();
        final JvmFormalParameter declaredParameter = _parameters.get((index).intValue());
        final AbstractParameterBuilder parameterBuilder = builder.newParameterBuilder();
        String _simpleName = declaredParameter.getSimpleName();
        parameterBuilder.setName(_simpleName);
        parameterBuilder.setType(it);
        JvmAnnotationReference _findAnnotation = MemberFromSuperImplementor.this.annotationLookup.findAnnotation(declaredParameter, Extension.class);
        boolean _notEquals = (!Objects.equal(_findAnnotation, null));
        parameterBuilder.setExtensionFlag(_notEquals);
      }
    };
    IterableExtensions.<LightweightTypeReference>forEach(_resolvedParameterTypes, _function);
    boolean _isVarArgs = executable.isVarArgs();
    builder.setVarArgsFlag(_isVarArgs);
    List<LightweightTypeReference> _resolvedExceptions = overridden.getResolvedExceptions();
    builder.setExceptions(_resolvedExceptions);
  }
}

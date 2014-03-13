package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
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
  
  public void appendOverrideFunction(final XtendClass overrider, final IResolvedOperation overriddenOperation, final ISourceAppender appendable) {
    final JvmGenericType inferredType = this.associations.getInferredType(overrider);
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
        public void apply(final JvmTypeParameter typeParam, final Integer idx) {
          final JvmTypeParameter newTypeParam = MemberFromSuperImplementor.this.typesFactory.createJvmTypeParameter();
          String _name = typeParam.getName();
          newTypeParam.setName(_name);
          List<LightweightTypeReference> _resolvedTypeParameterConstraints = overriddenOperation.getResolvedTypeParameterConstraints((idx).intValue());
          final Procedure1<LightweightTypeReference> _function = new Procedure1<LightweightTypeReference>() {
            public void apply(final LightweightTypeReference it) {
              final JvmUpperBound upperBound = MemberFromSuperImplementor.this.typesFactory.createJvmUpperBound();
              JvmTypeReference _javaCompliantTypeReference = it.toJavaCompliantTypeReference();
              upperBound.setTypeReference(_javaCompliantTypeReference);
              EList<JvmTypeConstraint> _constraints = newTypeParam.getConstraints();
              _constraints.add(upperBound);
            }
          };
          IterableExtensions.<LightweightTypeReference>forEach(_resolvedTypeParameterConstraints, _function);
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
            _builder.appendImmediate(",", "");
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
        public String apply(final JvmFormalParameter it) {
          return it.getSimpleName();
        }
      };
      List<String> _map = ListExtensions.<JvmFormalParameter, String>map(_parameters, _function_1);
      String _join = IterableExtensions.join(_map, ", ");
      _builder.append(_join, "");
      _builder.append(")");
      methodBuilder.setBody(_builder.toString());
    }
    boolean _isValid = methodBuilder.isValid();
    if (_isValid) {
      methodBuilder.build(appendable);
    }
  }
  
  public void appendConstructorFromSuper(final XtendClass overrider, final IResolvedConstructor superConstructor, final ISourceAppender appendable) {
    final JvmGenericType inferredType = this.associations.getInferredType(overrider);
    final AbstractConstructorBuilder constructorBuilder = this.codeBuilderFactory.createConstructorBuilder(inferredType);
    this.initializeExecutableBuilder(constructorBuilder, inferredType, superConstructor);
    String _xifexpression = null;
    List<LightweightTypeReference> _resolvedParameterTypes = superConstructor.getResolvedParameterTypes();
    boolean _isEmpty = _resolvedParameterTypes.isEmpty();
    if (_isEmpty) {
      _xifexpression = "";
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("super(");
      JvmConstructor _declaration = superConstructor.getDeclaration();
      EList<JvmFormalParameter> _parameters = _declaration.getParameters();
      final Function1<JvmFormalParameter, String> _function = new Function1<JvmFormalParameter, String>() {
        public String apply(final JvmFormalParameter it) {
          return it.getSimpleName();
        }
      };
      List<String> _map = ListExtensions.<JvmFormalParameter, String>map(_parameters, _function);
      String _join = IterableExtensions.join(_map, ", ");
      _builder.append(_join, "");
      _builder.append(")");
      _xifexpression = _builder.toString();
    }
    constructorBuilder.setBody(_xifexpression);
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

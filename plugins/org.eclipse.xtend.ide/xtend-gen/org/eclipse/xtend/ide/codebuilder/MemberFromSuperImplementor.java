package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
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
import org.eclipse.xtext.common.types.JvmLowerBound;
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
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;

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
  
  @Inject
  private CommonTypeComputationServices services;
  
  public void appendOverrideFunction(final XtendClass overrider, final JvmOperation overriddenOperation, final ISourceAppender appendable) {
    final JvmGenericType inferredType = this.associations.getInferredType(overrider);
    final AbstractMethodBuilder methodBuilder = this.codeBuilderFactory.createMethodBuilder(inferredType);
    final StandardTypeParameterSubstitutor substitutor = this.createSubstitutor(inferredType);
    this.initializeExecutableBuilder(methodBuilder, inferredType, overriddenOperation, substitutor);
    methodBuilder.setOverrideFlag(true);
    String _simpleName = overriddenOperation.getSimpleName();
    methodBuilder.setMethodName(_simpleName);
    JvmTypeReference _returnType = overriddenOperation.getReturnType();
    LightweightTypeReference _substitute = substitutor.substitute(_returnType);
    methodBuilder.setReturnType(_substitute);
    EList<JvmTypeParameter> _typeParameters = overriddenOperation.getTypeParameters();
    boolean _isEmpty = _typeParameters.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final ArrayList<JvmTypeParameter> typeParameters = CollectionLiterals.<JvmTypeParameter>newArrayList();
      EList<JvmTypeParameter> _typeParameters_1 = overriddenOperation.getTypeParameters();
      final Function1<JvmTypeParameter,JvmTypeParameter> _function = new Function1<JvmTypeParameter,JvmTypeParameter>() {
        public JvmTypeParameter apply(final JvmTypeParameter it) {
          JvmTypeParameter _xblockexpression = null;
          {
            final JvmTypeParameter typeParameter = MemberFromSuperImplementor.this.typesFactory.createJvmTypeParameter();
            String _name = it.getName();
            typeParameter.setName(_name);
            EList<JvmTypeConstraint> _constraints = it.getConstraints();
            for (final JvmTypeConstraint constraint : _constraints) {
              if ((constraint instanceof JvmUpperBound)) {
                final JvmUpperBound upperBound = MemberFromSuperImplementor.this.typesFactory.createJvmUpperBound();
                JvmTypeReference _typeReference = ((JvmUpperBound)constraint).getTypeReference();
                LightweightTypeReference _substitute = substitutor.substitute(_typeReference);
                JvmTypeReference _typeReference_1 = _substitute.toTypeReference();
                upperBound.setTypeReference(_typeReference_1);
                EList<JvmTypeConstraint> _constraints_1 = typeParameter.getConstraints();
                _constraints_1.add(upperBound);
              } else {
                if ((constraint instanceof JvmLowerBound)) {
                  final JvmLowerBound upperBound_1 = MemberFromSuperImplementor.this.typesFactory.createJvmLowerBound();
                  JvmTypeReference _typeReference_2 = ((JvmLowerBound)constraint).getTypeReference();
                  LightweightTypeReference _substitute_1 = substitutor.substitute(_typeReference_2);
                  JvmTypeReference _typeReference_3 = _substitute_1.toTypeReference();
                  upperBound_1.setTypeReference(_typeReference_3);
                  EList<JvmTypeConstraint> _constraints_2 = typeParameter.getConstraints();
                  _constraints_2.add(upperBound_1);
                }
              }
            }
            _xblockexpression = (typeParameter);
          }
          return _xblockexpression;
        }
      };
      List<JvmTypeParameter> _map = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(_typeParameters_1, _function);
      typeParameters.addAll(_map);
      methodBuilder.setTypeParameters(typeParameters);
    }
    boolean _isAbstract = overriddenOperation.isAbstract();
    boolean _not_1 = (!_isAbstract);
    if (_not_1) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("super.");
      {
        EList<JvmTypeParameter> _typeParameters_2 = overriddenOperation.getTypeParameters();
        boolean _hasElements = false;
        for(final JvmTypeParameter typeParam : _typeParameters_2) {
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
      String _simpleName_2 = overriddenOperation.getSimpleName();
      _builder.append(_simpleName_2, "");
      _builder.append("(");
      EList<JvmFormalParameter> _parameters = overriddenOperation.getParameters();
      final Function1<JvmFormalParameter,String> _function_1 = new Function1<JvmFormalParameter,String>() {
        public String apply(final JvmFormalParameter it) {
          String _simpleName = it.getSimpleName();
          return _simpleName;
        }
      };
      List<String> _map_1 = ListExtensions.<JvmFormalParameter, String>map(_parameters, _function_1);
      String _join = IterableExtensions.join(_map_1, ", ");
      _builder.append(_join, "");
      _builder.append(")");
      methodBuilder.setBody(_builder.toString());
    }
    boolean _isValid = methodBuilder.isValid();
    if (_isValid) {
      methodBuilder.build(appendable);
    }
  }
  
  public void appendConstructorFromSuper(final XtendClass overrider, final JvmConstructor superConstructor, final ISourceAppender appendable) {
    final JvmGenericType inferredType = this.associations.getInferredType(overrider);
    final AbstractConstructorBuilder constructorBuilder = this.codeBuilderFactory.createConstructorBuilder(inferredType);
    final StandardTypeParameterSubstitutor substitutor = this.createSubstitutor(inferredType);
    this.initializeExecutableBuilder(constructorBuilder, inferredType, superConstructor, substitutor);
    String _xifexpression = null;
    EList<JvmFormalParameter> _parameters = superConstructor.getParameters();
    boolean _isEmpty = _parameters.isEmpty();
    if (_isEmpty) {
      _xifexpression = "";
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("super(");
      EList<JvmFormalParameter> _parameters_1 = superConstructor.getParameters();
      final Function1<JvmFormalParameter,String> _function = new Function1<JvmFormalParameter,String>() {
        public String apply(final JvmFormalParameter it) {
          String _simpleName = it.getSimpleName();
          return _simpleName;
        }
      };
      List<String> _map = ListExtensions.<JvmFormalParameter, String>map(_parameters_1, _function);
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
  
  protected void initializeExecutableBuilder(final AbstractExecutableBuilder builder, final JvmDeclaredType overrider, final JvmExecutable overridden, final StandardTypeParameterSubstitutor substitutor) {
    builder.setContext(overrider);
    JvmVisibility _visibility = overridden.getVisibility();
    builder.setVisibility(_visibility);
    EList<JvmFormalParameter> _parameters = overridden.getParameters();
    final Procedure2<JvmFormalParameter,Integer> _function = new Procedure2<JvmFormalParameter,Integer>() {
      public void apply(final JvmFormalParameter it, final Integer index) {
        final AbstractParameterBuilder parameterBuilder = builder.newParameterBuilder();
        String _simpleName = it.getSimpleName();
        parameterBuilder.setName(_simpleName);
        EList<JvmFormalParameter> _parameters = overridden.getParameters();
        JvmFormalParameter _get = _parameters.get((index).intValue());
        JvmTypeReference _parameterType = _get.getParameterType();
        LightweightTypeReference _substitute = substitutor.substitute(_parameterType);
        parameterBuilder.setType(_substitute);
        JvmAnnotationReference _findAnnotation = MemberFromSuperImplementor.this.annotationLookup.findAnnotation(it, Extension.class);
        boolean _notEquals = (!Objects.equal(_findAnnotation, null));
        parameterBuilder.setExtensionFlag(_notEquals);
      }
    };
    IterableExtensions.<JvmFormalParameter>forEach(_parameters, _function);
    boolean _isVarArgs = overridden.isVarArgs();
    builder.setVarArgsFlag(_isVarArgs);
    EList<JvmTypeReference> _exceptions = overridden.getExceptions();
    final Function1<JvmTypeReference,LightweightTypeReference> _function_1 = new Function1<JvmTypeReference,LightweightTypeReference>() {
      public LightweightTypeReference apply(final JvmTypeReference it) {
        LightweightTypeReference _substitute = substitutor.substitute(it);
        return _substitute;
      }
    };
    List<LightweightTypeReference> _map = ListExtensions.<JvmTypeReference, LightweightTypeReference>map(_exceptions, _function_1);
    builder.setExceptions(_map);
  }
  
  protected StandardTypeParameterSubstitutor createSubstitutor(final JvmDeclaredType jvmOverrider) {
    StandardTypeParameterSubstitutor _xblockexpression = null;
    {
      StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, jvmOverrider);
      final StandardTypeReferenceOwner owner = _standardTypeReferenceOwner;
      ParameterizedTypeReference _parameterizedTypeReference = new ParameterizedTypeReference(owner, jvmOverrider);
      final ParameterizedTypeReference lightweightOverrider = _parameterizedTypeReference;
      if ((jvmOverrider instanceof JvmGenericType)) {
        EList<JvmTypeParameter> _typeParameters = ((JvmGenericType) ((JvmGenericType)jvmOverrider)).getTypeParameters();
        final Procedure1<JvmTypeParameter> _function = new Procedure1<JvmTypeParameter>() {
          public void apply(final JvmTypeParameter it) {
            ParameterizedTypeReference _parameterizedTypeReference = new ParameterizedTypeReference(owner, it);
            lightweightOverrider.addTypeArgument(_parameterizedTypeReference);
          }
        };
        IterableExtensions.<JvmTypeParameter>forEach(_typeParameters, _function);
      }
      DeclaratorTypeArgumentCollector _declaratorTypeArgumentCollector = new DeclaratorTypeArgumentCollector();
      final Map<JvmTypeParameter,LightweightMergedBoundTypeArgument> parameterMapping = _declaratorTypeArgumentCollector.getTypeParameterMapping(lightweightOverrider);
      StandardTypeParameterSubstitutor _standardTypeParameterSubstitutor = new StandardTypeParameterSubstitutor(parameterMapping, owner);
      _xblockexpression = (_standardTypeParameterSubstitutor);
    }
    return _xblockexpression;
  }
}

/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.macro.lang.jvmmodel;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.macro.ProcessingContext;
import org.eclipse.xtend.macro.RegistrationContext;
import org.eclipse.xtend.macro.lang.MacroAnnotationExtensions;
import org.eclipse.xtend.macro.lang.jvmmodel.FunctionAdapter;
import org.eclipse.xtend.macro.lang.macro.MacroAnnotation;
import org.eclipse.xtend.macro.lang.macro.Processor;
import org.eclipse.xtend.macro.lang.macro.Registrator;
import org.eclipse.xtend.macro.lang.macro.TargetType;
import org.eclipse.xtend.macro.lang.processing.MacroInterpreter;
import org.eclipse.xtend.macro.lang.processing.XAnnotationExtensions;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Translates the macro language ASTs to Java constructs.
 * 
 * A macro annotation is translated to
 *  1) a JvmAnnotationType, to be referenced from Xtend
 *  2) a "Registrator" class which is the context for the register-expression
 *  3) a "Processor" class which is the context for the process-expression
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class MacroJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private MacroAnnotationExtensions _macroAnnotationExtensions;
  
  @Inject
  private XAnnotationExtensions _xAnnotationExtensions;
  
  @Inject
  private MacroInterpreter interpreter;
  
  @Inject
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  protected void _infer(final XtendClass clazz, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(clazz);
    JvmGenericType _class = this._jvmTypesBuilder.toClass(clazz, _fullyQualifiedName);
    IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          DisableCodeGenerationAdapter.disableCodeGeneration(it);
          it.setVisibility(JvmVisibility.PUBLIC);
          EList<XtendMember> _members = clazz.getMembers();
          Iterable<XtendFunction> _filter = Iterables.<XtendFunction>filter(_members, XtendFunction.class);
          final Procedure1<XtendFunction> _function = new Procedure1<XtendFunction>() {
              public void apply(final XtendFunction function) {
                EList<JvmMember> _members = it.getMembers();
                String _name = function.getName();
                JvmTypeReference _returnType = function.getReturnType();
                final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                    public void apply(final JvmOperation it) {
                      boolean _isStatic = function.isStatic();
                      it.setStatic(_isStatic);
                      EList<JvmTypeReference> _exceptions = it.getExceptions();
                      EList<JvmTypeReference> _exceptions_1 = function.getExceptions();
                      final Function1<JvmTypeReference,JvmTypeReference> _function = new Function1<JvmTypeReference,JvmTypeReference>() {
                          public JvmTypeReference apply(final JvmTypeReference it) {
                            JvmTypeReference _cloneWithProxies = MacroJvmModelInferrer.this._jvmTypesBuilder.cloneWithProxies(it);
                            return _cloneWithProxies;
                          }
                        };
                      List<JvmTypeReference> _map = ListExtensions.<JvmTypeReference, JvmTypeReference>map(_exceptions_1, _function);
                      MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_exceptions, _map);
                      EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
                      EList<JvmTypeParameter> _typeParameters_1 = function.getTypeParameters();
                      final Function1<JvmTypeParameter,JvmTypeParameter> _function_1 = new Function1<JvmTypeParameter,JvmTypeParameter>() {
                          public JvmTypeParameter apply(final JvmTypeParameter it) {
                            JvmTypeParameter _cloneWithProxies = MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeParameter>cloneWithProxies(it);
                            return _cloneWithProxies;
                          }
                        };
                      List<JvmTypeParameter> _map_1 = ListExtensions.<JvmTypeParameter, JvmTypeParameter>map(_typeParameters_1, _function_1);
                      MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeParameter>operator_add(_typeParameters, _map_1);
                      EList<JvmFormalParameter> _parameters = it.getParameters();
                      EList<XtendParameter> _parameters_1 = function.getParameters();
                      final Function1<XtendParameter,JvmFormalParameter> _function_2 = new Function1<XtendParameter,JvmFormalParameter>() {
                          public JvmFormalParameter apply(final XtendParameter p) {
                            String _name = p.getName();
                            JvmTypeReference _parameterType = p.getParameterType();
                            JvmFormalParameter _parameter = MacroJvmModelInferrer.this._jvmTypesBuilder.toParameter(p, _name, _parameterType);
                            return _parameter;
                          }
                        };
                      List<JvmFormalParameter> _map_2 = ListExtensions.<XtendParameter, JvmFormalParameter>map(_parameters_1, _function_2);
                      MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _map_2);
                      XExpression _expression = function.getExpression();
                      MacroJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _expression);
                      EList<Adapter> _eAdapters = it.eAdapters();
                      FunctionAdapter _functionAdapter = new FunctionAdapter();
                      final Procedure1<FunctionAdapter> _function_3 = new Procedure1<FunctionAdapter>() {
                          public void apply(final FunctionAdapter it) {
                            final Function1<List<Object>,Object> _function = new Function1<List<Object>,Object>() {
                                public Object apply(final List<Object> arguments) {
                                  final HashMap<String,Object> map = CollectionLiterals.<String, Object>newHashMap();
                                  EList<XtendParameter> _parameters = function.getParameters();
                                  for (final XtendParameter p : _parameters) {
                                    String _name = p.getName();
                                    EList<XtendParameter> _parameters_1 = function.getParameters();
                                    int _indexOf = _parameters_1.indexOf(p);
                                    Object _get = arguments.get(_indexOf);
                                    map.put(_name, _get);
                                  }
                                  XExpression _expression = function.getExpression();
                                  return MacroJvmModelInferrer.this.evaluate(_expression, map);
                                }
                              };
                            it.setFunction(_function);
                          }
                        };
                      FunctionAdapter _doubleArrow = ObjectExtensions.<FunctionAdapter>operator_doubleArrow(_functionAdapter, _function_3);
                      MacroJvmModelInferrer.this._jvmTypesBuilder.<FunctionAdapter>operator_add(_eAdapters, _doubleArrow);
                    }
                  };
                JvmOperation _method = MacroJvmModelInferrer.this._jvmTypesBuilder.toMethod(function, _name, _returnType, _function);
                MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
              }
            };
          IterableExtensions.<XtendFunction>forEach(_filter, _function);
        }
      };
    _accept.initializeLater(_function);
  }
  
  protected void _infer(final MacroAnnotation annotation, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    String _registratorClassName = this._macroAnnotationExtensions.getRegistratorClassName(annotation);
    JvmGenericType _class = this._jvmTypesBuilder.toClass(annotation, _registratorClassName);
    IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          DisableCodeGenerationAdapter.disableCodeGeneration(it);
          it.setVisibility(JvmVisibility.PRIVATE);
          EList<JvmTypeReference> _superTypes = it.getSuperTypes();
          JvmTypeReference _newTypeRef = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(annotation, RegistrationContext.class);
          MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
          MacroJvmModelInferrer.this.addAnnotationValueAccessors(it, annotation);
          Registrator _registrator = MacroJvmModelInferrer.this._macroAnnotationExtensions.getRegistrator(annotation);
          final Procedure1<Registrator> _function = new Procedure1<Registrator>() {
              public void apply(final Registrator r) {
                boolean _equals = ObjectExtensions.operator_equals(r, null);
                if (_equals) {
                  return;
                }
                EList<JvmMember> _members = it.getMembers();
                JvmTypeReference _newTypeRef = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(annotation, Void.TYPE);
                final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                    public void apply(final JvmOperation it) {
                      it.setVisibility(JvmVisibility.PUBLIC);
                      JvmTypeReference _xifexpression = null;
                      boolean _isEach = r.isEach();
                      if (_isEach) {
                        JvmTypeReference _annotatedElementsType = MacroJvmModelInferrer.this.getAnnotatedElementsType(annotation);
                        _xifexpression = _annotatedElementsType;
                      } else {
                        JvmTypeReference _annotatedElementsType_1 = MacroJvmModelInferrer.this.getAnnotatedElementsType(annotation);
                        JvmTypeReference _newTypeRef = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(r, List.class, _annotatedElementsType_1);
                        _xifexpression = _newTypeRef;
                      }
                      final JvmTypeReference paramType = _xifexpression;
                      EList<JvmFormalParameter> _parameters = it.getParameters();
                      String _variableName = r.getVariableName();
                      String _elvis = ObjectExtensions.<String>operator_elvis(_variableName, "it");
                      JvmFormalParameter _parameter = MacroJvmModelInferrer.this._jvmTypesBuilder.toParameter(r, _elvis, paramType);
                      MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
                      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
                      JvmTypeReference _newTypeRef_1 = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(r, XtendFile.class);
                      JvmFormalParameter _parameter_1 = MacroJvmModelInferrer.this._jvmTypesBuilder.toParameter(r, "source", _newTypeRef_1);
                      MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
                      XExpression _expression = r.getExpression();
                      MacroJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _expression);
                    }
                  };
                JvmOperation _method = MacroJvmModelInferrer.this._jvmTypesBuilder.toMethod(r, "register", _newTypeRef, _function);
                MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
              }
            };
          ObjectExtensions.<Registrator>operator_doubleArrow(_registrator, _function);
        }
      };
    _accept.initializeLater(_function);
    String _processorClassName = this._macroAnnotationExtensions.getProcessorClassName(annotation);
    JvmGenericType _class_1 = this._jvmTypesBuilder.toClass(annotation, _processorClassName);
    IPostIndexingInitializing<JvmGenericType> _accept_1 = acceptor.<JvmGenericType>accept(_class_1);
    final Procedure1<JvmGenericType> _function_1 = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          DisableCodeGenerationAdapter.disableCodeGeneration(it);
          it.setVisibility(JvmVisibility.PRIVATE);
          EList<JvmTypeReference> _superTypes = it.getSuperTypes();
          JvmTypeReference _newTypeRef = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(annotation, ProcessingContext.class);
          MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
          MacroJvmModelInferrer.this.addAnnotationValueAccessors(it, annotation);
          Processor _processor = MacroJvmModelInferrer.this._macroAnnotationExtensions.getProcessor(annotation);
          final Procedure1<Processor> _function = new Procedure1<Processor>() {
              public void apply(final Processor p) {
                boolean _equals = ObjectExtensions.operator_equals(p, null);
                if (_equals) {
                  return;
                }
                EList<JvmMember> _members = it.getMembers();
                JvmTypeReference _newTypeRef = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(annotation, Void.TYPE);
                final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                    public void apply(final JvmOperation it) {
                      it.setVisibility(JvmVisibility.PUBLIC);
                      JvmTypeReference _xifexpression = null;
                      boolean _isEach = p.isEach();
                      if (_isEach) {
                        JvmTypeReference _annotatedElementsType = MacroJvmModelInferrer.this.getAnnotatedElementsType(annotation);
                        _xifexpression = _annotatedElementsType;
                      } else {
                        JvmTypeReference _annotatedElementsType_1 = MacroJvmModelInferrer.this.getAnnotatedElementsType(annotation);
                        JvmTypeReference _newTypeRef = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(p, List.class, _annotatedElementsType_1);
                        _xifexpression = _newTypeRef;
                      }
                      final JvmTypeReference paramType = _xifexpression;
                      EList<JvmFormalParameter> _parameters = it.getParameters();
                      String _variableName = p.getVariableName();
                      String _elvis = ObjectExtensions.<String>operator_elvis(_variableName, "it");
                      JvmFormalParameter _parameter = MacroJvmModelInferrer.this._jvmTypesBuilder.toParameter(p, _elvis, paramType);
                      MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
                      EList<JvmFormalParameter> _parameters_1 = it.getParameters();
                      JvmTypeReference _newTypeRef_1 = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(p, XtendFile.class);
                      JvmFormalParameter _parameter_1 = MacroJvmModelInferrer.this._jvmTypesBuilder.toParameter(p, "source", _newTypeRef_1);
                      MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters_1, _parameter_1);
                      XExpression _expression = p.getExpression();
                      MacroJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _expression);
                    }
                  };
                JvmOperation _method = MacroJvmModelInferrer.this._jvmTypesBuilder.toMethod(p, "process", _newTypeRef, _function);
                MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
              }
            };
          ObjectExtensions.<Processor>operator_doubleArrow(_processor, _function);
        }
      };
    _accept_1.initializeLater(_function_1);
    String _qualifiedName = this._macroAnnotationExtensions.getQualifiedName(annotation);
    JvmAnnotationType _annotationType = this._jvmTypesBuilder.toAnnotationType(annotation, _qualifiedName);
    IPostIndexingInitializing<JvmAnnotationType> _accept_2 = acceptor.<JvmAnnotationType>accept(_annotationType);
    final Procedure1<JvmAnnotationType> _function_2 = new Procedure1<JvmAnnotationType>() {
        public void apply(final JvmAnnotationType it) {
          DisableCodeGenerationAdapter.disableCodeGeneration(it);
          Iterable<XtendField> _fields = MacroJvmModelInferrer.this._macroAnnotationExtensions.getFields(annotation);
          final Procedure1<XtendField> _function = new Procedure1<XtendField>() {
              public void apply(final XtendField field) {
                EList<JvmMember> _members = it.getMembers();
                String _name = field.getName();
                JvmTypeReference _type = field.getType();
                final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                    public void apply(final JvmOperation it) {
                      XExpression _initialValue = field.getInitialValue();
                      boolean _notEquals = ObjectExtensions.operator_notEquals(_initialValue, null);
                      if (_notEquals) {
                        XExpression _initialValue_1 = field.getInitialValue();
                        JvmAnnotationValue _jvmAnnotationValue = MacroJvmModelInferrer.this._jvmTypesBuilder.toJvmAnnotationValue(_initialValue_1);
                        it.setDefaultValue(_jvmAnnotationValue);
                      }
                    }
                  };
                JvmOperation _method = MacroJvmModelInferrer.this._jvmTypesBuilder.toMethod(field, _name, _type, _function);
                MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
              }
            };
          IterableExtensions.<XtendField>forEach(_fields, _function);
        }
      };
    _accept_2.initializeLater(_function_2);
  }
  
  @Inject
  private TypeConformanceComputer typeConformanceComputer;
  
  public JvmTypeReference getAnnotatedElementsType(final MacroAnnotation annotation2) {
    final ArrayList<JvmTypeReference> result = CollectionLiterals.<JvmTypeReference>newArrayList();
    EList<TargetType> _targetType = annotation2.getTargetType();
    for (final TargetType targetType : _targetType) {
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(targetType,TargetType.CLASS)) {
          _matched=true;
          JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(annotation2, XtendClass.class);
          result.add(_newTypeRef);
        }
      }
      if (!_matched) {
        if (Objects.equal(targetType,TargetType.FIELD)) {
          _matched=true;
          JvmTypeReference _newTypeRef_1 = this._jvmTypesBuilder.newTypeRef(annotation2, XtendField.class);
          result.add(_newTypeRef_1);
        }
      }
      if (!_matched) {
        if (Objects.equal(targetType,TargetType.METHOD)) {
          _matched=true;
          JvmTypeReference _newTypeRef_2 = this._jvmTypesBuilder.newTypeRef(annotation2, XtendFunction.class);
          result.add(_newTypeRef_2);
        }
      }
      if (!_matched) {
        if (Objects.equal(targetType,TargetType.CONSTRUCTOR)) {
          _matched=true;
          JvmTypeReference _newTypeRef_3 = this._jvmTypesBuilder.newTypeRef(annotation2, XtendConstructor.class);
          result.add(_newTypeRef_3);
        }
      }
      if (!_matched) {
        if (Objects.equal(targetType,TargetType.PARAMETER)) {
          _matched=true;
          JvmTypeReference _newTypeRef_4 = this._jvmTypesBuilder.newTypeRef(annotation2, XtendParameter.class);
          result.add(_newTypeRef_4);
        }
      }
    }
    boolean _isEmpty = result.isEmpty();
    if (_isEmpty) {
      return this._jvmTypesBuilder.newTypeRef(annotation2, XtendAnnotationTarget.class);
    }
    return this.typeConformanceComputer.getCommonSuperType(result);
  }
  
  public void addAnnotationValueAccessors(final JvmGenericType it, final MacroAnnotation annotation) {
    Iterable<XtendField> _fields = this._macroAnnotationExtensions.getFields(annotation);
    for (final XtendField field : _fields) {
      {
        JvmTypeReference _xifexpression = null;
        boolean _isStatic = field.isStatic();
        if (_isStatic) {
          JvmTypeReference _type = field.getType();
          _xifexpression = _type;
        } else {
          JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(field, XExpression.class);
          _xifexpression = _newTypeRef;
        }
        final JvmTypeReference type = _xifexpression;
        EList<JvmMember> _members = it.getMembers();
        String _name = field.getName();
        final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
            public void apply(final JvmOperation it) {
              EList<JvmFormalParameter> _parameters = it.getParameters();
              JvmTypeReference _annotatedElementsType = MacroJvmModelInferrer.this.getAnnotatedElementsType(annotation);
              JvmFormalParameter _parameter = MacroJvmModelInferrer.this._jvmTypesBuilder.toParameter(field, "annotatedElement", _annotatedElementsType);
              MacroJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
              it.setVisibility(JvmVisibility.PRIVATE);
              EList<Adapter> _eAdapters = it.eAdapters();
              FunctionAdapter _functionAdapter = new FunctionAdapter();
              final Procedure1<FunctionAdapter> _function = new Procedure1<FunctionAdapter>() {
                  public void apply(final FunctionAdapter it) {
                    final Function1<List<Object>,Object> _function = new Function1<List<Object>,Object>() {
                        public Object apply(final List<Object> arguments) {
                          Object _head = IterableExtensions.<Object>head(arguments);
                          final XtendAnnotationTarget annotationTarget = ((XtendAnnotationTarget) _head);
                          final XExpression expression = MacroJvmModelInferrer.this.getAnnotationValueExpression(annotationTarget, field, annotation);
                          boolean _isStatic = field.isStatic();
                          if (_isStatic) {
                            return MacroJvmModelInferrer.this.evaluate(expression);
                          } else {
                            return expression;
                          }
                        }
                      };
                    it.setFunction(_function);
                  }
                };
              FunctionAdapter _doubleArrow = ObjectExtensions.<FunctionAdapter>operator_doubleArrow(_functionAdapter, _function);
              MacroJvmModelInferrer.this._jvmTypesBuilder.<FunctionAdapter>operator_add(_eAdapters, _doubleArrow);
            }
          };
        JvmOperation _method = this._jvmTypesBuilder.toMethod(field, _name, type, _function);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
      }
    }
  }
  
  public XExpression getAnnotationValueExpression(final XtendAnnotationTarget annotated, final XtendField field, final MacroAnnotation macroAnnotation) {
    EList<XAnnotation> _annotations = annotated.getAnnotations();
    final Function1<XAnnotation,Boolean> _function = new Function1<XAnnotation,Boolean>() {
        public Boolean apply(final XAnnotation it) {
          JvmAnnotationType _annotationType = it.getAnnotationType();
          MacroAnnotation _macroAnnotation = MacroJvmModelInferrer.this._xAnnotationExtensions.getMacroAnnotation(_annotationType);
          boolean _equals = ObjectExtensions.operator_equals(_macroAnnotation, macroAnnotation);
          return Boolean.valueOf(_equals);
        }
      };
    final XAnnotation a = IterableExtensions.<XAnnotation>findFirst(_annotations, _function);
    boolean _and = false;
    String _name = field.getName();
    boolean _equals = ObjectExtensions.operator_equals(_name, "value");
    if (!_equals) {
      _and = false;
    } else {
      XExpression _value = a.getValue();
      boolean _notEquals = ObjectExtensions.operator_notEquals(_value, null);
      _and = (_equals && _notEquals);
    }
    if (_and) {
      return a.getValue();
    }
    EList<XAnnotationElementValuePair> _elementValuePairs = a.getElementValuePairs();
    for (final XAnnotationElementValuePair valuePair : _elementValuePairs) {
      JvmOperation _element = valuePair.getElement();
      String _simpleName = _element.getSimpleName();
      String _name_1 = field.getName();
      boolean _equals_1 = ObjectExtensions.operator_equals(_simpleName, _name_1);
      if (_equals_1) {
        return valuePair.getValue();
      }
    }
    return field.getInitialValue();
  }
  
  public Object evaluate(final XExpression expression) {
    Object _evaluate = this.evaluate(expression, null);
    return _evaluate;
  }
  
  public Object evaluate(final XExpression expression, final Map<String,Object> arguments) {
    DefaultEvaluationContext _defaultEvaluationContext = new DefaultEvaluationContext();
    final DefaultEvaluationContext ctx = _defaultEvaluationContext;
    Set<Entry<String,Object>> _entrySet = arguments==null?(Set<Entry<String,Object>>)null:arguments.entrySet();
    final Procedure1<Entry<String,Object>> _function = new Procedure1<Entry<String,Object>>() {
        public void apply(final Entry<String,Object> it) {
          String _key = it.getKey();
          QualifiedName _create = QualifiedName.create(_key);
          Object _value = it.getValue();
          ctx.newValue(_create, _value);
        }
      };
    if (_entrySet!=null) IterableExtensions.<Entry<String,Object>>forEach(_entrySet, _function);
    final IEvaluationResult result = this.interpreter.evaluate(expression, ctx, CancelIndicator.NullImpl);
    return result.getResult();
  }
  
  public void infer(final EObject clazz, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (clazz instanceof XtendClass) {
      _infer((XtendClass)clazz, acceptor, isPreIndexingPhase);
      return;
    } else if (clazz instanceof MacroAnnotation) {
      _infer((MacroAnnotation)clazz, acceptor, isPreIndexingPhase);
      return;
    } else if (clazz != null) {
      _infer(clazz, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(clazz, acceptor, isPreIndexingPhase).toString());
    }
  }
}

package org.eclipse.xtend.macro.lang.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
                boolean _equals = Objects.equal(r, null);
                if (_equals) {
                  return;
                }
                EList<JvmMember> _members = it.getMembers();
                JvmTypeReference _newTypeRef = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(annotation, Void.TYPE);
                final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                    public void apply(final JvmOperation it) {
                      it.setVisibility(JvmVisibility.PUBLIC);
                      EList<JvmFormalParameter> _parameters = it.getParameters();
                      JvmTypeReference _annotatedElementsType = MacroJvmModelInferrer.this.getAnnotatedElementsType(annotation);
                      JvmTypeReference _newTypeRef = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(r, List.class, _annotatedElementsType);
                      JvmFormalParameter _parameter = MacroJvmModelInferrer.this._jvmTypesBuilder.toParameter(r, "elements", _newTypeRef);
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
                boolean _equals = Objects.equal(p, null);
                if (_equals) {
                  return;
                }
                EList<JvmMember> _members = it.getMembers();
                JvmTypeReference _newTypeRef = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(annotation, Void.TYPE);
                final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                    public void apply(final JvmOperation it) {
                      it.setVisibility(JvmVisibility.PUBLIC);
                      EList<JvmFormalParameter> _parameters = it.getParameters();
                      JvmTypeReference _annotatedElementsType = MacroJvmModelInferrer.this.getAnnotatedElementsType(annotation);
                      JvmTypeReference _newTypeRef = MacroJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(p, List.class, _annotatedElementsType);
                      JvmFormalParameter _parameter = MacroJvmModelInferrer.this._jvmTypesBuilder.toParameter(p, "elements", _newTypeRef);
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
                      boolean _notEquals = (!Objects.equal(_initialValue, null));
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
          boolean _equals = Objects.equal(_macroAnnotation, macroAnnotation);
          return Boolean.valueOf(_equals);
        }
      };
    final XAnnotation a = IterableExtensions.<XAnnotation>findFirst(_annotations, _function);
    boolean _and = false;
    String _name = field.getName();
    boolean _equals = Objects.equal(_name, "value");
    if (!_equals) {
      _and = false;
    } else {
      XExpression _value = a.getValue();
      boolean _notEquals = (!Objects.equal(_value, null));
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
      boolean _equals_1 = Objects.equal(_simpleName, _name_1);
      if (_equals_1) {
        return valuePair.getValue();
      }
    }
    return field.getInitialValue();
  }
  
  public Object evaluate(final XExpression expression) {
    final IEvaluationResult result = this.interpreter.evaluate(expression);
    return result.getResult();
  }
  
  public void infer(final EObject annotation, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (annotation instanceof MacroAnnotation) {
      _infer((MacroAnnotation)annotation, acceptor, isPreIndexingPhase);
      return;
    } else if (annotation != null) {
      _infer(annotation, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(annotation, acceptor, isPreIndexingPhase).toString());
    }
  }
}

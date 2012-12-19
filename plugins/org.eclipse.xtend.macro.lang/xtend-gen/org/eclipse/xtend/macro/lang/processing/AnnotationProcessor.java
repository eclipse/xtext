/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.macro.lang.processing;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.macro.lang.MacroAnnotationExtensions;
import org.eclipse.xtend.macro.lang.macro.MacroAnnotation;
import org.eclipse.xtend.macro.lang.macro.Processor;
import org.eclipse.xtend.macro.lang.macro.Registrator;
import org.eclipse.xtend.macro.lang.macro.TargetType;
import org.eclipse.xtend.macro.lang.processing.MacroEvaluationException;
import org.eclipse.xtend.macro.lang.processing.MacroInterpreter;
import org.eclipse.xtend.macro.lang.processing.ProcessingContextImpl;
import org.eclipse.xtend.macro.lang.processing.RegistrationContextImpl;
import org.eclipse.xtend.macro.lang.processing.XAnnotationExtensions;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * The annotation processor is registered with the compilation-particpant extenions point
 * and is called during model inference of Xtend files.
 * 
 * It checks whether the files contain macro annotations and calls their register and processing functions.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class AnnotationProcessor implements IJvmModelInferrer {
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    return _hashCode;
  }
  
  public boolean equals(final Object obj) {
    boolean _xblockexpression = false;
    {
      Class<? extends Object> _class = obj==null?(Class<? extends Object>)null:obj.getClass();
      Class<? extends Object> _class_1 = this.getClass();
      boolean _equals = ObjectExtensions.operator_equals(_class, _class_1);
      if (_equals) {
        return true;
      }
      boolean _equals_1 = super.equals(obj);
      _xblockexpression = (_equals_1);
    }
    return _xblockexpression;
  }
  
  private final static Logger LOG = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(AnnotationProcessor.class);
      return _logger;
    }
  }.apply();
  
  @Inject
  private IJvmModelAssociator associator;
  
  @Inject
  private MacroInterpreter interpreter;
  
  @Inject
  private Provider<ProcessingContextImpl> processingContextProvider;
  
  @Inject
  private Provider<RegistrationContextImpl> registratorContextProvider;
  
  @Inject
  private JvmTypesBuilder jvmTypesBuilder;
  
  @Inject
  private IXtendJvmAssociations associations;
  
  @Inject
  private XAnnotationExtensions _xAnnotationExtensions;
  
  @Inject
  private MacroAnnotationExtensions _macroAnnotationExtensions;
  
  /**
   * gets called from Xtend compiler, during "model inference", i.e. translation of Xtend AST to Java AST
   */
  public void infer(final EObject e, final IJvmDeclaredTypeAcceptor acceptor, final boolean preIndexingPhase) {
    boolean _matched = false;
    if (!_matched) {
      if (e instanceof XtendFile) {
        final XtendFile _xtendFile = (XtendFile)e;
        _matched=true;
        final Map<MacroAnnotation,List<XtendAnnotationTarget>> annotatedElements = CollectionLiterals.<MacroAnnotation, List<XtendAnnotationTarget>>newHashMap();
        final Procedure1<Pair<MacroAnnotation,XtendAnnotationTarget>> _function = new Procedure1<Pair<MacroAnnotation,XtendAnnotationTarget>>() {
            public void apply(final Pair<MacroAnnotation,XtendAnnotationTarget> it) {
              MacroAnnotation _key = it.getKey();
              boolean _containsKey = annotatedElements.containsKey(_key);
              boolean _not = (!_containsKey);
              if (_not) {
                MacroAnnotation _key_1 = it.getKey();
                ArrayList<XtendAnnotationTarget> _newArrayList = CollectionLiterals.<XtendAnnotationTarget>newArrayList();
                annotatedElements.put(_key_1, _newArrayList);
              }
              MacroAnnotation _key_2 = it.getKey();
              List<XtendAnnotationTarget> _get = annotatedElements.get(_key_2);
              XtendAnnotationTarget _value = it.getValue();
              _get.add(_value);
            }
          };
        this.searchAnnotatedElements(_xtendFile, new IAcceptor<Pair<MacroAnnotation,XtendAnnotationTarget>>() {
            public void accept(Pair<MacroAnnotation,XtendAnnotationTarget> t) {
              _function.apply(t);
            }
        });
        boolean _isEmpty = annotatedElements.isEmpty();
        if (_isEmpty) {
          return;
        }
        this.invokeRegistrators(_xtendFile, annotatedElements, acceptor, CancelIndicator.NullImpl);
        boolean _not = (!preIndexingPhase);
        if (_not) {
          this.invokeProcessors(_xtendFile, annotatedElements, CancelIndicator.NullImpl);
        }
      }
    }
    if (!_matched) {
      String _plus = ("Couldn\'t handle invocation for " + e);
      AnnotationProcessor.LOG.error(_plus);
    }
  }
  
  /**
   * recursively looks for macro annotations on XtendAnnotationTargets
   */
  private void searchAnnotatedElements(final EObject element, final IAcceptor<Pair<MacroAnnotation,XtendAnnotationTarget>> acceptor) {
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof XtendFile) {
        final XtendFile _xtendFile = (XtendFile)element;
        _matched=true;
        EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
        final Procedure1<XtendTypeDeclaration> _function = new Procedure1<XtendTypeDeclaration>() {
            public void apply(final XtendTypeDeclaration it) {
              AnnotationProcessor.this.searchAnnotatedElements(it, acceptor);
            }
          };
        IterableExtensions.<XtendTypeDeclaration>forEach(_xtendTypes, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendClass) {
        final XtendClass _xtendClass = (XtendClass)element;
        _matched=true;
        this.registerMacroAnnotations(_xtendClass, acceptor);
        EList<XtendMember> _members = _xtendClass.getMembers();
        final Procedure1<XtendMember> _function = new Procedure1<XtendMember>() {
            public void apply(final XtendMember it) {
              AnnotationProcessor.this.searchAnnotatedElements(it, acceptor);
            }
          };
        IterableExtensions.<XtendMember>forEach(_members, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendFunction) {
        final XtendFunction _xtendFunction = (XtendFunction)element;
        _matched=true;
        this.registerMacroAnnotations(_xtendFunction, acceptor);
        EList<XtendParameter> _parameters = _xtendFunction.getParameters();
        final Procedure1<XtendParameter> _function = new Procedure1<XtendParameter>() {
            public void apply(final XtendParameter it) {
              AnnotationProcessor.this.searchAnnotatedElements(it, acceptor);
            }
          };
        IterableExtensions.<XtendParameter>forEach(_parameters, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendConstructor) {
        final XtendConstructor _xtendConstructor = (XtendConstructor)element;
        _matched=true;
        this.registerMacroAnnotations(_xtendConstructor, acceptor);
        EList<XtendParameter> _parameters = _xtendConstructor.getParameters();
        final Procedure1<XtendParameter> _function = new Procedure1<XtendParameter>() {
            public void apply(final XtendParameter it) {
              AnnotationProcessor.this.searchAnnotatedElements(it, acceptor);
            }
          };
        IterableExtensions.<XtendParameter>forEach(_parameters, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendAnnotationTarget) {
        final XtendAnnotationTarget _xtendAnnotationTarget = (XtendAnnotationTarget)element;
        _matched=true;
        this.registerMacroAnnotations(_xtendAnnotationTarget, acceptor);
      }
    }
  }
  
  private void registerMacroAnnotations(final XtendAnnotationTarget candidate, final IAcceptor<Pair<MacroAnnotation,XtendAnnotationTarget>> acceptor) {
    EList<XAnnotation> _annotations = candidate.getAnnotations();
    final Function1<XAnnotation,Boolean> _function = new Function1<XAnnotation,Boolean>() {
        public Boolean apply(final XAnnotation it) {
          boolean _isProcessed = AnnotationProcessor.this._xAnnotationExtensions.isProcessed(it);
          return Boolean.valueOf(_isProcessed);
        }
      };
    Iterable<XAnnotation> _filter = IterableExtensions.<XAnnotation>filter(_annotations, _function);
    for (final XAnnotation annotation : _filter) {
      {
        final MacroAnnotation macroAnno = this._xAnnotationExtensions.getMacroAnnotation(annotation);
        boolean _notEquals = ObjectExtensions.operator_notEquals(macroAnno, null);
        if (_notEquals) {
          boolean _hasErrors = this._macroAnnotationExtensions.hasErrors(macroAnno);
          if (_hasErrors) {
            Resource _eResource = annotation.eResource();
            EList<Diagnostic> _errors = _eResource.getErrors();
            int _minus = (-1);
            EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, "macro_has_errors", "The referenced macro annotation has compile errors.", annotation, null, _minus, null);
            _errors.add(_eObjectDiagnosticImpl);
          } else {
            boolean _isValidTarget = this.isValidTarget(macroAnno, annotation);
            boolean _not = (!_isValidTarget);
            if (_not) {
              Resource _eResource_1 = annotation.eResource();
              EList<Diagnostic> _errors_1 = _eResource_1.getErrors();
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("The macro annotation ");
              String _name = macroAnno.getName();
              _builder.append(_name, "");
              _builder.append(" can only be used on ");
              EList<TargetType> _targetType = macroAnno.getTargetType();
              String _join = IterableExtensions.join(_targetType, ",");
              _builder.append(_join, "");
              int _minus_1 = (-1);
              EObjectDiagnosticImpl _eObjectDiagnosticImpl_1 = new EObjectDiagnosticImpl(Severity.ERROR, "invalid_annotation_target", _builder.toString(), annotation, null, _minus_1, null);
              _errors_1.add(_eObjectDiagnosticImpl_1);
            } else {
              Pair<MacroAnnotation,XtendAnnotationTarget> _mappedTo = Pair.<MacroAnnotation, XtendAnnotationTarget>of(macroAnno, candidate);
              acceptor.accept(_mappedTo);
            }
          }
        }
      }
    }
  }
  
  private boolean isValidTarget(final MacroAnnotation it, final XAnnotation annotation) {
    EList<TargetType> _targetType = it.getTargetType();
    boolean _isEmpty = _targetType.isEmpty();
    if (_isEmpty) {
      return true;
    }
    boolean _switchResult = false;
    XtendAnnotationTarget _annotatedTarget = this._xAnnotationExtensions.getAnnotatedTarget(annotation);
    final XtendAnnotationTarget target = _annotatedTarget;
    boolean _matched = false;
    if (!_matched) {
      if (target instanceof XtendClass) {
        final XtendClass _xtendClass = (XtendClass)target;
        _matched=true;
        EList<TargetType> _targetType_1 = it.getTargetType();
        boolean _contains = _targetType_1.contains(TargetType.CLASS);
        _switchResult = _contains;
      }
    }
    if (!_matched) {
      if (target instanceof XtendField) {
        final XtendField _xtendField = (XtendField)target;
        _matched=true;
        EList<TargetType> _targetType_1 = it.getTargetType();
        boolean _contains = _targetType_1.contains(TargetType.FIELD);
        _switchResult = _contains;
      }
    }
    if (!_matched) {
      if (target instanceof XtendFunction) {
        final XtendFunction _xtendFunction = (XtendFunction)target;
        _matched=true;
        EList<TargetType> _targetType_1 = it.getTargetType();
        boolean _contains = _targetType_1.contains(TargetType.METHOD);
        _switchResult = _contains;
      }
    }
    if (!_matched) {
      if (target instanceof XtendConstructor) {
        final XtendConstructor _xtendConstructor = (XtendConstructor)target;
        _matched=true;
        EList<TargetType> _targetType_1 = it.getTargetType();
        boolean _contains = _targetType_1.contains(TargetType.CONSTRUCTOR);
        _switchResult = _contains;
      }
    }
    if (!_matched) {
      if (target instanceof XtendParameter) {
        final XtendParameter _xtendParameter = (XtendParameter)target;
        _matched=true;
        EList<TargetType> _targetType_1 = it.getTargetType();
        boolean _contains = _targetType_1.contains(TargetType.PARAMETER);
        _switchResult = _contains;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  private void invokeRegistrators(final XtendFile xtendFile, final Map<MacroAnnotation,List<XtendAnnotationTarget>> annotatedElements, final IJvmDeclaredTypeAcceptor acceptor, final CancelIndicator cancelIndicator) {
    try {
      Set<MacroAnnotation> _keySet = annotatedElements.keySet();
      final Function1<MacroAnnotation,Boolean> _function = new Function1<MacroAnnotation,Boolean>() {
          public Boolean apply(final MacroAnnotation it) {
            Registrator _registrator = AnnotationProcessor.this._macroAnnotationExtensions.getRegistrator(it);
            boolean _notEquals = ObjectExtensions.operator_notEquals(_registrator, null);
            return Boolean.valueOf(_notEquals);
          }
        };
      Iterable<MacroAnnotation> _filter = IterableExtensions.<MacroAnnotation>filter(_keySet, _function);
      for (final MacroAnnotation macroAnnotation : _filter) {
        {
          final List<XtendAnnotationTarget> elements = this.getElements(macroAnnotation, annotatedElements);
          Registrator _registrator = this._macroAnnotationExtensions.getRegistrator(macroAnnotation);
          boolean _notEquals = ObjectExtensions.operator_notEquals(_registrator, null);
          if (_notEquals) {
            List<? extends Object> _xifexpression = null;
            Registrator _registrator_1 = this._macroAnnotationExtensions.getRegistrator(macroAnnotation);
            boolean _isEach = _registrator_1.isEach();
            if (_isEach) {
              _xifexpression = elements;
            } else {
              ArrayList<List<XtendAnnotationTarget>> _newArrayList = CollectionLiterals.<List<XtendAnnotationTarget>>newArrayList(elements);
              _xifexpression = _newArrayList;
            }
            final Iterable<?> each = _xifexpression;
            for (final Object element : each) {
              {
                DefaultEvaluationContext _defaultEvaluationContext = new DefaultEvaluationContext();
                final DefaultEvaluationContext ctx = _defaultEvaluationContext;
                final RegistrationContextImpl regstratorCtx = this.registratorContextProvider.get();
                regstratorCtx.setSource(xtendFile);
                regstratorCtx.setTypesBuilder(this.jvmTypesBuilder);
                regstratorCtx.setAcceptor(acceptor);
                regstratorCtx.setAssociator(this.associator);
                QualifiedName _create = QualifiedName.create("this");
                ctx.newValue(_create, regstratorCtx);
                Registrator _registrator_2 = this._macroAnnotationExtensions.getRegistrator(macroAnnotation);
                String _variableName = _registrator_2.getVariableName();
                final String varName = ObjectExtensions.<String>operator_elvis(_variableName, "it");
                QualifiedName _create_1 = QualifiedName.create(varName);
                ctx.newValue(_create_1, element);
                QualifiedName _create_2 = QualifiedName.create("source");
                ctx.newValue(_create_2, xtendFile);
                try {
                  Registrator _registrator_3 = this._macroAnnotationExtensions.getRegistrator(macroAnnotation);
                  XExpression _expression = _registrator_3==null?(XExpression)null:_registrator_3.getExpression();
                  final IEvaluationResult result = this.interpreter.evaluate(_expression, ctx, cancelIndicator);
                  Throwable _exception = result.getException();
                  boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_exception, null);
                  if (_notEquals_1) {
                    throw result.getException();
                  }
                } catch (final Throwable _t) {
                  if (_t instanceof Exception) {
                    final Exception e = (Exception)_t;
                    String _message = e.getMessage();
                    AnnotationProcessor.LOG.error(_message, e);
                  } else {
                    throw Exceptions.sneakyThrow(_t);
                  }
                }
              }
            }
          }
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void invokeProcessors(final XtendFile xtendFile, final Map<MacroAnnotation,List<XtendAnnotationTarget>> annotatedElements, final CancelIndicator cancelIndicator) {
    Set<MacroAnnotation> _keySet = annotatedElements.keySet();
    for (final MacroAnnotation macroAnnotation : _keySet) {
      {
        final List<XtendAnnotationTarget> elements = this.getElements(macroAnnotation, annotatedElements);
        Processor _processor = this._macroAnnotationExtensions.getProcessor(macroAnnotation);
        boolean _notEquals = ObjectExtensions.operator_notEquals(_processor, null);
        if (_notEquals) {
          List<? extends Object> _xifexpression = null;
          Processor _processor_1 = this._macroAnnotationExtensions.getProcessor(macroAnnotation);
          boolean _isEach = _processor_1.isEach();
          if (_isEach) {
            _xifexpression = elements;
          } else {
            ArrayList<List<XtendAnnotationTarget>> _newArrayList = CollectionLiterals.<List<XtendAnnotationTarget>>newArrayList(elements);
            _xifexpression = _newArrayList;
          }
          final Iterable<?> each = _xifexpression;
          for (final Object element : each) {
            {
              final ProcessingContextImpl processingCtx = this.processingContextProvider.get();
              processingCtx.setSource(xtendFile);
              processingCtx.setTypesBuilder(this.jvmTypesBuilder);
              processingCtx.setAssociations(this.associations);
              DefaultEvaluationContext _defaultEvaluationContext = new DefaultEvaluationContext();
              final DefaultEvaluationContext ctx = _defaultEvaluationContext;
              QualifiedName _create = QualifiedName.create("this");
              ctx.newValue(_create, processingCtx);
              Processor _processor_2 = this._macroAnnotationExtensions.getProcessor(macroAnnotation);
              String _variableName = _processor_2.getVariableName();
              final String varName = ObjectExtensions.<String>operator_elvis(_variableName, "it");
              QualifiedName _create_1 = QualifiedName.create(varName);
              ctx.newValue(_create_1, element);
              QualifiedName _create_2 = QualifiedName.create("source");
              ctx.newValue(_create_2, xtendFile);
              try {
                Processor _processor_3 = this._macroAnnotationExtensions.getProcessor(macroAnnotation);
                XExpression _expression = _processor_3.getExpression();
                final IEvaluationResult result = this.interpreter.evaluate(_expression, ctx, cancelIndicator);
                Throwable _exception = result.getException();
                boolean _notEquals_1 = ObjectExtensions.operator_notEquals(_exception, null);
                if (_notEquals_1) {
                  Resource _eResource = xtendFile.eResource();
                  Throwable _exception_1 = result.getException();
                  this.handleError(_eResource, elements, macroAnnotation, _exception_1);
                }
              } catch (final Throwable _t) {
                if (_t instanceof Exception) {
                  final Exception e = (Exception)_t;
                  String _message = e.getMessage();
                  AnnotationProcessor.LOG.error(_message, e);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void handleError(final Resource resource, final List<XtendAnnotationTarget> annotatedElements, final MacroAnnotation annotation, final Throwable exception) {
    final Procedure1<XtendAnnotationTarget> _function = new Procedure1<XtendAnnotationTarget>() {
        public void apply(final XtendAnnotationTarget it) {
          EList<XAnnotation> _annotations = it.getAnnotations();
          final Function1<XAnnotation,Boolean> _function = new Function1<XAnnotation,Boolean>() {
              public Boolean apply(final XAnnotation it) {
                JvmAnnotationType _annotationType = it.getAnnotationType();
                String _simpleName = _annotationType.getSimpleName();
                String _name = annotation.getName();
                boolean _equals = ObjectExtensions.operator_equals(_simpleName, _name);
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<XAnnotation> _filter = IterableExtensions.<XAnnotation>filter(_annotations, _function);
          final Procedure1<XAnnotation> _function_1 = new Procedure1<XAnnotation>() {
              public void apply(final XAnnotation it) {
                String _switchResult = null;
                boolean _matched = false;
                if (!_matched) {
                  if (exception instanceof MacroEvaluationException) {
                    final MacroEvaluationException _macroEvaluationException = (MacroEvaluationException)exception;
                    _matched=true;
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append("Problem during processing : [");
                    Throwable _cause = _macroEvaluationException.getCause();
                    Class<? extends Object> _class = _cause.getClass();
                    String _simpleName = _class.getSimpleName();
                    _builder.append(_simpleName, "");
                    _builder.append("] ");
                    String _message = _macroEvaluationException.getMessage();
                    _builder.append(_message, "");
                    _builder.newLineIfNotEmpty();
                    _builder.append("in ");
                    Resource _eResource = _macroEvaluationException.causer.eResource();
                    URI _uRI = _eResource.getURI();
                    String _lastSegment = _uRI.lastSegment();
                    _builder.append(_lastSegment, "");
                    _builder.append(" Line:");
                    ICompositeNode _node = NodeModelUtils.getNode(_macroEvaluationException.causer);
                    int _startLine = _node.getStartLine();
                    _builder.append(_startLine, "");
                    _builder.newLineIfNotEmpty();
                    _builder.newLine();
                    _builder.append("\t");
                    String _highlightedRange = AnnotationProcessor.this.getHighlightedRange(_macroEvaluationException.causer, 2, 2);
                    _builder.append(_highlightedRange, "	");
                    _builder.newLineIfNotEmpty();
                    _builder.newLine();
                    String _string = _builder.toString();
                    _switchResult = _string;
                  }
                }
                if (!_matched) {
                  Class<? extends Object> _class = exception.getClass();
                  String _simpleName = _class.getSimpleName();
                  String _plus = ("Problems during processing : [" + _simpleName);
                  String _plus_1 = (_plus + "] ");
                  String _message = exception.getMessage();
                  String _elvis = ObjectExtensions.<String>operator_elvis(_message, "");
                  String _plus_2 = (_plus_1 + _elvis);
                  _switchResult = _plus_2;
                }
                final String message = _switchResult;
                EList<Diagnostic> _errors = resource.getErrors();
                int _minus = (-1);
                EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, "macro_processing_problem", message, it, null, _minus, null);
                _errors.add(_eObjectDiagnosticImpl);
              }
            };
          IterableExtensions.<XAnnotation>forEach(_filter, _function_1);
        }
      };
    IterableExtensions.<XtendAnnotationTarget>forEach(annotatedElements, _function);
  }
  
  private String getHighlightedRange(final EObject obj, final int linesBefore, final int linesAfter) {
    final ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
    int _startLine = node.getStartLine();
    int _minus = (_startLine - 1);
    final int startLine = (_minus - linesBefore);
    int _startLine_1 = node.getStartLine();
    final int endLine = (_startLine_1 + linesAfter);
    Iterable<ILeafNode> _leafNodes = node.getLeafNodes();
    final Function1<ILeafNode,Boolean> _function = new Function1<ILeafNode,Boolean>() {
        public Boolean apply(final ILeafNode it) {
          boolean _isHidden = it.isHidden();
          boolean _not = (!_isHidden);
          return Boolean.valueOf(_not);
        }
      };
    final Iterable<ILeafNode> leafNodes = IterableExtensions.<ILeafNode>filter(_leafNodes, _function);
    ICompositeNode _rootNode = node.getRootNode();
    Iterable<ILeafNode> _leafNodes_1 = _rootNode.getLeafNodes();
    StringBuilder _stringBuilder = new StringBuilder();
    final Function2<StringBuilder,ILeafNode,StringBuilder> _function_1 = new Function2<StringBuilder,ILeafNode,StringBuilder>() {
        public StringBuilder apply(final StringBuilder result, final ILeafNode leafNode) {
          ILeafNode _head = IterableExtensions.<ILeafNode>head(leafNodes);
          boolean _equals = ObjectExtensions.operator_equals(leafNode, _head);
          if (_equals) {
            result.append("\u2588");
          }
          String _text = leafNode.getText();
          result.append(_text);
          return result;
        }
      };
    final StringBuilder document = IterableExtensions.<ILeafNode, StringBuilder>fold(_leafNodes_1, _stringBuilder, _function_1);
    StringBuilder _stringBuilder_1 = new StringBuilder();
    final StringBuilder result = _stringBuilder_1;
    String _string = document.toString();
    final String[] lines = _string.split("\n");
    IntegerRange _upTo = new IntegerRange(startLine, endLine);
    for (final Integer i : _upTo) {
      boolean _and = false;
      boolean _greaterEqualsThan = ((i).intValue() >= 0);
      if (!_greaterEqualsThan) {
        _and = false;
      } else {
        int _size = ((List<String>)Conversions.doWrapArray(lines)).size();
        boolean _lessThan = ((i).intValue() < _size);
        _and = (_greaterEqualsThan && _lessThan);
      }
      if (_and) {
        String _get = ((List<String>)Conversions.doWrapArray(lines)).get((i).intValue());
        StringBuilder _append = result.append(_get);
        _append.append("\n");
      }
    }
    return result.toString();
  }
  
  private List<XtendAnnotationTarget> getElements(final MacroAnnotation macroAnnotation, final Map<MacroAnnotation,List<XtendAnnotationTarget>> annotatedElements) {
    List<XtendAnnotationTarget> _get = annotatedElements.get(macroAnnotation);
    final Function1<XtendAnnotationTarget,Boolean> _function = new Function1<XtendAnnotationTarget,Boolean>() {
        public Boolean apply(final XtendAnnotationTarget e) {
          boolean _isTargetType = AnnotationProcessor.this.isTargetType(e, macroAnnotation);
          return Boolean.valueOf(_isTargetType);
        }
      };
    Iterable<XtendAnnotationTarget> _filter = IterableExtensions.<XtendAnnotationTarget>filter(_get, _function);
    List<XtendAnnotationTarget> _list = IterableExtensions.<XtendAnnotationTarget>toList(_filter);
    return _list;
  }
  
  private boolean isTargetType(final XtendAnnotationTarget target, final MacroAnnotation annotation) {
    final ArrayList<Class<?>> types = CollectionLiterals.<Class<?>>newArrayList();
    EList<TargetType> _targetType = annotation.getTargetType();
    for (final TargetType targetType : _targetType) {
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(targetType,TargetType.CLASS)) {
          _matched=true;
          types.add(XtendClass.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(targetType,TargetType.FIELD)) {
          _matched=true;
          types.add(XtendField.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(targetType,TargetType.METHOD)) {
          _matched=true;
          types.add(XtendFunction.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(targetType,TargetType.CONSTRUCTOR)) {
          _matched=true;
          types.add(XtendConstructor.class);
        }
      }
      if (!_matched) {
        if (Objects.equal(targetType,TargetType.PARAMETER)) {
          _matched=true;
          types.add(XtendParameter.class);
        }
      }
    }
    boolean _isEmpty = types.isEmpty();
    if (_isEmpty) {
      return true;
    }
    final Function1<Class<?>,Boolean> _function = new Function1<Class<?>,Boolean>() {
        public Boolean apply(final Class<?> it) {
          boolean _isInstance = it.isInstance(target);
          return Boolean.valueOf(_isInstance);
        }
      };
    return IterableExtensions.<Class<?>>exists(types, _function);
  }
}

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
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtend.macro.lang.processing.MacroInterpreter;
import org.eclipse.xtend.macro.lang.processing.ProcessingContextImpl;
import org.eclipse.xtend.macro.lang.processing.RegistrationContextImpl;
import org.eclipse.xtend.macro.lang.processing.XAnnotationExtensions;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(macroAnno, null));
        if (!_notEquals) {
          _and = false;
        } else {
          boolean _hasErrors = this._macroAnnotationExtensions.hasErrors(macroAnno);
          boolean _not = (!_hasErrors);
          _and = (_notEquals && _not);
        }
        if (_and) {
          Pair<MacroAnnotation,XtendAnnotationTarget> _mappedTo = Pair.<MacroAnnotation, XtendAnnotationTarget>of(macroAnno, candidate);
          acceptor.accept(_mappedTo);
        }
      }
    }
  }
  
  private void invokeRegistrators(final XtendFile xtendFile, final Map<MacroAnnotation,List<XtendAnnotationTarget>> annotatedElements, final IJvmDeclaredTypeAcceptor acceptor, final CancelIndicator cancelIndicator) {
    try {
      Set<MacroAnnotation> _keySet = annotatedElements.keySet();
      final Function1<MacroAnnotation,Boolean> _function = new Function1<MacroAnnotation,Boolean>() {
          public Boolean apply(final MacroAnnotation it) {
            Registrator _registrator = AnnotationProcessor.this._macroAnnotationExtensions.getRegistrator(it);
            boolean _notEquals = (!Objects.equal(_registrator, null));
            return Boolean.valueOf(_notEquals);
          }
        };
      Iterable<MacroAnnotation> _filter = IterableExtensions.<MacroAnnotation>filter(_keySet, _function);
      for (final MacroAnnotation macroAnnotation : _filter) {
        {
          final List<XtendAnnotationTarget> elements = this.getElements(macroAnnotation, annotatedElements);
          DefaultEvaluationContext _defaultEvaluationContext = new DefaultEvaluationContext();
          final DefaultEvaluationContext ctx = _defaultEvaluationContext;
          final RegistrationContextImpl regstratorCtx = this.registratorContextProvider.get();
          regstratorCtx.setSource(xtendFile);
          regstratorCtx.setTypesBuilder(this.jvmTypesBuilder);
          regstratorCtx.setAcceptor(acceptor);
          regstratorCtx.setAssociator(this.associator);
          regstratorCtx.setAnnotatedElements(elements);
          QualifiedName _create = QualifiedName.create("this");
          ctx.newValue(_create, regstratorCtx);
          QualifiedName _create_1 = QualifiedName.create("elements");
          ctx.newValue(_create_1, elements);
          QualifiedName _create_2 = QualifiedName.create("source");
          ctx.newValue(_create_2, xtendFile);
          try {
            Registrator _registrator = this._macroAnnotationExtensions.getRegistrator(macroAnnotation);
            XExpression _expression = _registrator==null?(XExpression)null:_registrator.getExpression();
            final IEvaluationResult result = this.interpreter.evaluate(_expression, ctx, cancelIndicator);
            Throwable _exception = result.getException();
            boolean _notEquals = (!Objects.equal(_exception, null));
            if (_notEquals) {
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
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void invokeProcessors(final XtendFile xtendFile, final Map<MacroAnnotation,List<XtendAnnotationTarget>> annotatedElements, final CancelIndicator cancelIndicator) {
    try {
      Set<MacroAnnotation> _keySet = annotatedElements.keySet();
      for (final MacroAnnotation macroAnnotation : _keySet) {
        {
          DefaultEvaluationContext _defaultEvaluationContext = new DefaultEvaluationContext();
          final DefaultEvaluationContext ctx = _defaultEvaluationContext;
          final List<XtendAnnotationTarget> elements = this.getElements(macroAnnotation, annotatedElements);
          final ProcessingContextImpl processingCtx = this.processingContextProvider.get();
          processingCtx.setElements(elements);
          processingCtx.setSource(xtendFile);
          processingCtx.setTypesBuilder(this.jvmTypesBuilder);
          QualifiedName _create = QualifiedName.create("this");
          ctx.newValue(_create, processingCtx);
          QualifiedName _create_1 = QualifiedName.create("elements");
          ctx.newValue(_create_1, elements);
          QualifiedName _create_2 = QualifiedName.create("source");
          ctx.newValue(_create_2, xtendFile);
          try {
            Processor _processor = this._macroAnnotationExtensions.getProcessor(macroAnnotation);
            XExpression _expression = _processor.getExpression();
            final IEvaluationResult result = this.interpreter.evaluate(_expression, ctx, cancelIndicator);
            Throwable _exception = result.getException();
            boolean _notEquals = (!Objects.equal(_exception, null));
            if (_notEquals) {
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
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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

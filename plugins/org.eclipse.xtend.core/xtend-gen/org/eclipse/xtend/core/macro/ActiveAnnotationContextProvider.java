/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.macro.XAnnotationExtensions;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class ActiveAnnotationContextProvider {
  private final static Logger logger = Logger.getLogger(ActiveAnnotationContextProvider.class);
  
  @Inject
  @Extension
  private XAnnotationExtensions _xAnnotationExtensions;
  
  @Inject
  @Extension
  private ProcessorInstanceForJvmTypeProvider _processorInstanceForJvmTypeProvider;
  
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  public ActiveAnnotationContexts computeContext(final XtendFile file) {
    final Stopwatches.StoppedTask task = Stopwatches.forTask("[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)");
    task.start();
    try {
      Resource _eResource = file.eResource();
      final ActiveAnnotationContexts result = ActiveAnnotationContexts.installNew(_eResource);
      final CompilationUnitImpl compilationUnit = this.compilationUnitProvider.get();
      compilationUnit.setXtendFile(file);
      result.compilationUnit = compilationUnit;
      final IAcceptor<Pair<JvmAnnotationType, XAnnotation>> _function = new IAcceptor<Pair<JvmAnnotationType, XAnnotation>>() {
        @Override
        public void accept(final Pair<JvmAnnotationType, XAnnotation> it) {
          Map<JvmAnnotationType, ActiveAnnotationContext> _contexts = result.getContexts();
          JvmAnnotationType _key = it.getKey();
          boolean _containsKey = _contexts.containsKey(_key);
          boolean _not = (!_containsKey);
          if (_not) {
            final ActiveAnnotationContext fa = new ActiveAnnotationContext();
            fa.setCompilationUnit(compilationUnit);
            JvmAnnotationType _key_1 = it.getKey();
            final JvmType processorType = ActiveAnnotationContextProvider.this._xAnnotationExtensions.getProcessorType(_key_1);
            try {
              final Object processorInstance = ActiveAnnotationContextProvider.this._processorInstanceForJvmTypeProvider.getProcessorInstance(processorType);
              boolean _equals = Objects.equal(processorInstance, null);
              if (_equals) {
                String _identifier = processorType.getIdentifier();
                String _plus = ("Couldn\'t instantiate the annotation processor of type \'" + _identifier);
                String _plus_1 = (_plus + "\'. This is usually the case when the processor resides in the same project as the annotated element.");
                throw new IllegalStateException(_plus_1);
              }
              fa.setProcessorInstance(processorInstance);
            } catch (final Throwable _t) {
              if (_t instanceof VirtualMachineError) {
                final VirtualMachineError e = (VirtualMachineError)_t;
                throw e;
              } else if (_t instanceof Throwable) {
                final Throwable e_1 = (Throwable)_t;
                ActiveAnnotationContextProvider.this.operationCanceledManager.propagateAsErrorIfCancelException(e_1);
                String _switchResult = null;
                boolean _matched = false;
                if (!_matched) {
                  if (e_1 instanceof ExceptionInInitializerError) {
                    _matched=true;
                    Throwable _exception = ((ExceptionInInitializerError)e_1).getException();
                    _switchResult = _exception.getMessage();
                  }
                }
                if (!_matched) {
                  _switchResult = e_1.getMessage();
                }
                final String msg = _switchResult;
                Resource _eResource = file.eResource();
                EList<Resource.Diagnostic> _errors = _eResource.getErrors();
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("Problem while loading annotation processor: ");
                _builder.append(msg, "");
                XAnnotation _value = it.getValue();
                EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, 
                  IssueCodes.PROCESSING_ERROR, _builder.toString(), _value, 
                  XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, (-1), null);
                _errors.add(_eObjectDiagnosticImpl);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            Map<JvmAnnotationType, ActiveAnnotationContext> _contexts_1 = result.getContexts();
            JvmAnnotationType _key_2 = it.getKey();
            _contexts_1.put(_key_2, fa);
          }
          Map<JvmAnnotationType, ActiveAnnotationContext> _contexts_2 = result.getContexts();
          JvmAnnotationType _key_3 = it.getKey();
          ActiveAnnotationContext _get = _contexts_2.get(_key_3);
          List<XtendAnnotationTarget> _annotatedSourceElements = _get.getAnnotatedSourceElements();
          XAnnotation _value_1 = it.getValue();
          XtendAnnotationTarget _annotatedTarget = ActiveAnnotationContextProvider.this._xAnnotationExtensions.getAnnotatedTarget(_value_1);
          _annotatedSourceElements.add(_annotatedTarget);
        }
      };
      this.searchAnnotatedElements(file, _function);
      return result;
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable e = (Throwable)_t;
        this.operationCanceledManager.propagateAsErrorIfCancelException(e);
        boolean _matched = false;
        if (!_matched) {
          if (e instanceof VirtualMachineError) {
            _matched=true;
            throw ((VirtualMachineError)e);
          }
        }
        if (!_matched) {
          if (e instanceof LinkageError) {
            _matched=true;
            throw ((LinkageError)e);
          }
        }
        ActiveAnnotationContextProvider.logger.warn("Error finding the elements to be processed by active annotations", e);
        Resource _eResource_1 = file.eResource();
        return ActiveAnnotationContexts.installNew(_eResource_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      task.stop();
    }
  }
  
  /**
   * recursively looks for macro annotations on XtendAnnotationTargets
   */
  private void searchAnnotatedElements(final EObject element, final IAcceptor<Pair<JvmAnnotationType, XAnnotation>> acceptor) {
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof XtendFile) {
        _matched=true;
        EList<XtendTypeDeclaration> _xtendTypes = ((XtendFile)element).getXtendTypes();
        final Procedure1<XtendTypeDeclaration> _function = new Procedure1<XtendTypeDeclaration>() {
          @Override
          public void apply(final XtendTypeDeclaration it) {
            ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
          }
        };
        IterableExtensions.<XtendTypeDeclaration>forEach(_xtendTypes, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendClass) {
        _matched=true;
        this.registerMacroAnnotations(((XtendAnnotationTarget)element), acceptor);
        EList<XtendMember> _members = ((XtendClass)element).getMembers();
        final Procedure1<XtendMember> _function = new Procedure1<XtendMember>() {
          @Override
          public void apply(final XtendMember it) {
            ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
          }
        };
        IterableExtensions.<XtendMember>forEach(_members, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendInterface) {
        _matched=true;
        this.registerMacroAnnotations(((XtendAnnotationTarget)element), acceptor);
        EList<XtendMember> _members = ((XtendInterface)element).getMembers();
        final Procedure1<XtendMember> _function = new Procedure1<XtendMember>() {
          @Override
          public void apply(final XtendMember it) {
            ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
          }
        };
        IterableExtensions.<XtendMember>forEach(_members, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendEnum) {
        _matched=true;
        this.registerMacroAnnotations(((XtendAnnotationTarget)element), acceptor);
        EList<XtendMember> _members = ((XtendEnum)element).getMembers();
        final Procedure1<XtendMember> _function = new Procedure1<XtendMember>() {
          @Override
          public void apply(final XtendMember it) {
            ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
          }
        };
        IterableExtensions.<XtendMember>forEach(_members, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendAnnotationType) {
        _matched=true;
        this.registerMacroAnnotations(((XtendAnnotationTarget)element), acceptor);
        EList<XtendMember> _members = ((XtendAnnotationType)element).getMembers();
        final Procedure1<XtendMember> _function = new Procedure1<XtendMember>() {
          @Override
          public void apply(final XtendMember it) {
            ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
          }
        };
        IterableExtensions.<XtendMember>forEach(_members, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendFunction) {
        _matched=true;
        this.registerMacroAnnotations(((XtendAnnotationTarget)element), acceptor);
        EList<XtendParameter> _parameters = ((XtendFunction)element).getParameters();
        final Procedure1<XtendParameter> _function = new Procedure1<XtendParameter>() {
          @Override
          public void apply(final XtendParameter it) {
            ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
          }
        };
        IterableExtensions.<XtendParameter>forEach(_parameters, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendConstructor) {
        _matched=true;
        this.registerMacroAnnotations(((XtendAnnotationTarget)element), acceptor);
        EList<XtendParameter> _parameters = ((XtendConstructor)element).getParameters();
        final Procedure1<XtendParameter> _function = new Procedure1<XtendParameter>() {
          @Override
          public void apply(final XtendParameter it) {
            ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
          }
        };
        IterableExtensions.<XtendParameter>forEach(_parameters, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendAnnotationTarget) {
        _matched=true;
        this.registerMacroAnnotations(((XtendAnnotationTarget)element), acceptor);
      }
    }
  }
  
  private void registerMacroAnnotations(final XtendAnnotationTarget candidate, final IAcceptor<Pair<JvmAnnotationType, XAnnotation>> acceptor) {
    EList<XAnnotation> _annotations = candidate.getAnnotations();
    final Function1<XAnnotation, Boolean> _function = new Function1<XAnnotation, Boolean>() {
      @Override
      public Boolean apply(final XAnnotation it) {
        return Boolean.valueOf(ActiveAnnotationContextProvider.this._xAnnotationExtensions.isProcessed(it));
      }
    };
    Iterable<XAnnotation> _filter = IterableExtensions.<XAnnotation>filter(_annotations, _function);
    for (final XAnnotation annotation : _filter) {
      {
        final JvmAnnotationType activeAnnotationDeclaration = this._xAnnotationExtensions.tryFindAnnotationType(annotation);
        boolean _notEquals = (!Objects.equal(activeAnnotationDeclaration, null));
        if (_notEquals) {
          boolean _isValid = this.isValid(annotation, activeAnnotationDeclaration);
          if (_isValid) {
            Pair<JvmAnnotationType, XAnnotation> _mappedTo = Pair.<JvmAnnotationType, XAnnotation>of(activeAnnotationDeclaration, annotation);
            acceptor.accept(_mappedTo);
          }
        }
      }
    }
  }
  
  private boolean isValid(final XAnnotation annotation, final JvmAnnotationType activeAnnotationDeclaration) {
    return (!Objects.equal(annotation, null));
  }
}

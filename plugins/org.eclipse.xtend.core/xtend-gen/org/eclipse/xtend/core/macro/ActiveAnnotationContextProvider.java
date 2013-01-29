/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.macro.XAnnotationExtensions;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class ActiveAnnotationContextProvider {
  @Inject
  private OnChangeEvictingCache cache;
  
  @Inject
  private XAnnotationExtensions _xAnnotationExtensions;
  
  @Inject
  private ProcessorInstanceForJvmTypeProvider _processorInstanceForJvmTypeProvider;
  
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;
  
  public List<? extends ActiveAnnotationContext> computeContext(final XtendFile file) {
    List<ActiveAnnotationContext> _xblockexpression = null;
    {
      final StoppedTask task = Stopwatches.forTask("[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)");
      task.start();
      List<ActiveAnnotationContext> _xtrycatchfinallyexpression = null;
      try {
        Resource _eResource = file.eResource();
        final Function0<List<ActiveAnnotationContext>> _function = new Function0<List<ActiveAnnotationContext>>() {
            public List<ActiveAnnotationContext> apply() {
              final Map<JvmAnnotationType,ActiveAnnotationContext> annotatedElements = CollectionLiterals.<JvmAnnotationType, ActiveAnnotationContext>newHashMap();
              final CompilationUnitImpl compilationUnit = ActiveAnnotationContextProvider.this.compilationUnitProvider.get();
              compilationUnit.setXtendFile(file);
              final Procedure1<Pair<JvmAnnotationType,XAnnotation>> _function = new Procedure1<Pair<JvmAnnotationType,XAnnotation>>() {
                  public void apply(final Pair<JvmAnnotationType,XAnnotation> it) {
                    JvmAnnotationType _key = it.getKey();
                    boolean _containsKey = annotatedElements.containsKey(_key);
                    boolean _not = (!_containsKey);
                    if (_not) {
                      ActiveAnnotationContext _activeAnnotationContext = new ActiveAnnotationContext();
                      final ActiveAnnotationContext fa = _activeAnnotationContext;
                      fa.setCompilationUnit(compilationUnit);
                      JvmAnnotationType _key_1 = it.getKey();
                      final JvmType processorType = ActiveAnnotationContextProvider.this._xAnnotationExtensions.getProcessorType(_key_1);
                      Object _processorInstance = ActiveAnnotationContextProvider.this._processorInstanceForJvmTypeProvider.getProcessorInstance(processorType);
                      fa.setProcessorInstance(_processorInstance);
                      JvmAnnotationType _key_2 = it.getKey();
                      annotatedElements.put(_key_2, fa);
                    }
                    JvmAnnotationType _key_3 = it.getKey();
                    ActiveAnnotationContext _get = annotatedElements.get(_key_3);
                    List<XtendAnnotationTarget> _annotatedSourceElements = _get.getAnnotatedSourceElements();
                    XAnnotation _value = it.getValue();
                    XtendAnnotationTarget _annotatedTarget = ActiveAnnotationContextProvider.this._xAnnotationExtensions.getAnnotatedTarget(_value);
                    _annotatedSourceElements.add(_annotatedTarget);
                  }
                };
              ActiveAnnotationContextProvider.this.searchAnnotatedElements(file, new IAcceptor<Pair<JvmAnnotationType,XAnnotation>>() {
                  public void accept(Pair<JvmAnnotationType,XAnnotation> t) {
                    _function.apply(t);
                  }
              });
              Collection<ActiveAnnotationContext> _values = annotatedElements.values();
              return IterableExtensions.<ActiveAnnotationContext>toList(_values);
            }
          };
        List<ActiveAnnotationContext> _get = this.cache.<List<ActiveAnnotationContext>>get("annotation context", _eResource, new Provider<List<ActiveAnnotationContext>>() {
            public List<ActiveAnnotationContext> get() {
              return _function.apply();
            }
        });
        _xtrycatchfinallyexpression = _get;
      } finally {
        task.stop();
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
  
  /**
   * recursively looks for macro annotations on XtendAnnotationTargets
   */
  private void searchAnnotatedElements(final EObject element, final IAcceptor<Pair<JvmAnnotationType,XAnnotation>> acceptor) {
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof XtendFile) {
        final XtendFile _xtendFile = (XtendFile)element;
        _matched=true;
        EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
        final Procedure1<XtendTypeDeclaration> _function = new Procedure1<XtendTypeDeclaration>() {
            public void apply(final XtendTypeDeclaration it) {
              ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
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
              ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
            }
          };
        IterableExtensions.<XtendMember>forEach(_members, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendInterface) {
        final XtendInterface _xtendInterface = (XtendInterface)element;
        _matched=true;
        this.registerMacroAnnotations(_xtendInterface, acceptor);
        EList<XtendMember> _members = _xtendInterface.getMembers();
        final Procedure1<XtendMember> _function = new Procedure1<XtendMember>() {
            public void apply(final XtendMember it) {
              ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
            }
          };
        IterableExtensions.<XtendMember>forEach(_members, _function);
      }
    }
    if (!_matched) {
      if (element instanceof XtendEnum) {
        final XtendEnum _xtendEnum = (XtendEnum)element;
        _matched=true;
        this.registerMacroAnnotations(_xtendEnum, acceptor);
        EList<XtendMember> _members = _xtendEnum.getMembers();
        final Procedure1<XtendMember> _function = new Procedure1<XtendMember>() {
            public void apply(final XtendMember it) {
              ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
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
              ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
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
              ActiveAnnotationContextProvider.this.searchAnnotatedElements(it, acceptor);
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
  
  private void registerMacroAnnotations(final XtendAnnotationTarget candidate, final IAcceptor<Pair<JvmAnnotationType,XAnnotation>> acceptor) {
    EList<XAnnotation> _annotations = candidate.getAnnotations();
    final Function1<XAnnotation,Boolean> _function = new Function1<XAnnotation,Boolean>() {
        public Boolean apply(final XAnnotation it) {
          boolean _isProcessed = ActiveAnnotationContextProvider.this._xAnnotationExtensions.isProcessed(it);
          return Boolean.valueOf(_isProcessed);
        }
      };
    Iterable<XAnnotation> _filter = IterableExtensions.<XAnnotation>filter(_annotations, _function);
    for (final XAnnotation annotation : _filter) {
      {
        final JvmAnnotationType activeAnnotationDeclaration = this._xAnnotationExtensions.tryFindAnnotationType(annotation);
        boolean _notEquals = ObjectExtensions.operator_notEquals(activeAnnotationDeclaration, null);
        if (_notEquals) {
          boolean _isValid = this.isValid(annotation, activeAnnotationDeclaration);
          if (_isValid) {
            Pair<JvmAnnotationType,XAnnotation> _mappedTo = Pair.<JvmAnnotationType, XAnnotation>of(activeAnnotationDeclaration, annotation);
            acceptor.accept(_mappedTo);
          }
        }
      }
    }
  }
  
  private boolean isValid(final XAnnotation annotation, final JvmAnnotationType activeAnnotationDeclaration) {
    return ObjectExtensions.operator_notEquals(annotation, null);
  }
}

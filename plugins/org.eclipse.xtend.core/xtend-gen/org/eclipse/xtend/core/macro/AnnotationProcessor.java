/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.inject.Inject;
import java.util.List;
import javax.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.TransformationContextImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendMemberDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtend.lib.macro.services.TimeoutException;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * It checks whether the files contain macro annotations and calls their register and processing functions.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class AnnotationProcessor {
  private final int timeout = 2000;
  
  @Inject
  private Provider<TransformationContextImpl> modifyContextProvider;
  
  /**
   * gets called from Xtend compiler, during "model inference", i.e. translation of Xtend AST to Java AST
   */
  public Object indexingPhase(final ActiveAnnotationContext ctx, final IAcceptor<JvmDeclaredType> acceptor, final CancelIndicator monitor) {
    Object _xblockexpression = null;
    {
      final StoppedTask task = Stopwatches.forTask("[macros] indexingPhase (AnnotationProcessor.indexingPhase)");
      task.start();
      Object _xtrycatchfinallyexpression = null;
      try {
        Object _switchResult = null;
        Object _processorInstance = ctx.getProcessorInstance();
        final Object processor = _processorInstance;
        boolean _matched = false;
        if (!_matched) {
          if (processor instanceof RegisterGlobalsParticipant) {
            final RegisterGlobalsParticipant _registerGlobalsParticipant = (RegisterGlobalsParticipant)processor;
            _matched=true;
            _switchResult = null;
          }
        }
        _xtrycatchfinallyexpression = _switchResult;
      } finally {
        task.stop();
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
  
  public Boolean inferencePhase(final ActiveAnnotationContext ctx, final CancelIndicator monitor) {
    Boolean _xblockexpression = null;
    {
      final StoppedTask task = Stopwatches.forTask("[macros] inferencePhase (AnnotationProcessor.inferencePhase)");
      task.start();
      Boolean _xtrycatchfinallyexpression = null;
      try {
        Boolean _switchResult = null;
        Object _processorInstance = ctx.getProcessorInstance();
        final Object processor = _processorInstance;
        boolean _matched = false;
        if (!_matched) {
          if (processor instanceof TransformationParticipant) {
            final TransformationParticipant _transformationParticipant = (TransformationParticipant)processor;
            _matched=true;
            Boolean _xblockexpression_1 = null;
            {
              final TransformationContextImpl modifyCtx = this.modifyContextProvider.get();
              CompilationUnitImpl _compilationUnit = ctx.getCompilationUnit();
              modifyCtx.setUnit(_compilationUnit);
              final Runnable _function = new Runnable() {
                  public void run() {
                    List<XtendAnnotationTarget> _annotatedSourceElements = ctx.getAnnotatedSourceElements();
                    final Function1<XtendAnnotationTarget,MutableNamedElement> _function = new Function1<XtendAnnotationTarget,MutableNamedElement>() {
                        public MutableNamedElement apply(final XtendAnnotationTarget it) {
                          CompilationUnitImpl _compilationUnit = ctx.getCompilationUnit();
                          final XtendMemberDeclarationImpl xtendMember = _compilationUnit.toXtendMemberDeclaration(((XtendMember) it));
                          return modifyCtx.getGeneratedElement(xtendMember);
                        }
                      };
                    final List<MutableNamedElement> map = ListExtensions.<XtendAnnotationTarget, MutableNamedElement>map(_annotatedSourceElements, _function);
                    _transformationParticipant.doTransform(map, modifyCtx);
                  }
                };
              Boolean _runWithTimeout = this.runWithTimeout(ctx, this.timeout, _function);
              _xblockexpression_1 = (_runWithTimeout);
            }
            _switchResult = _xblockexpression_1;
          }
        }
        _xtrycatchfinallyexpression = _switchResult;
      } finally {
        task.stop();
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
  
  /**
   * runs the given runnable in a new thread and sets the timeout property on the compilation unit to true
   * when the given amount of milliseconds have passed by.
   */
  private Boolean runWithTimeout(final ActiveAnnotationContext ctx, final int timeout, final Runnable runnable) {
    Boolean _xblockexpression = null;
    {
      final Runnable _function = new Runnable() {
          public void run() {
            try {
              runnable.run();
            } catch (final Throwable _t) {
              if (_t instanceof TimeoutException) {
                final TimeoutException e = (TimeoutException)_t;
                AnnotationProcessor.this.handelTimeout(ctx, e);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
        };
      Thread _thread = new Thread(_function);
      final Thread thread = _thread;
      thread.run();
      Boolean _xtrycatchfinallyexpression = null;
      try {
        Boolean _xblockexpression_1 = null;
        {
          thread.join(timeout);
          Boolean _xifexpression = null;
          boolean _isAlive = thread.isAlive();
          if (_isAlive) {
            CompilationUnitImpl _compilationUnit = ctx.getCompilationUnit();
            boolean _setTimeout = _compilationUnit.setTimeout(true);
            _xifexpression = _setTimeout;
          }
          _xblockexpression_1 = (_xifexpression);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof InterruptedException) {
          final InterruptedException e = (InterruptedException)_t;
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
  
  public boolean handelTimeout(final ActiveAnnotationContext context, final TimeoutException exception) {
    boolean _xblockexpression = false;
    {
      List<XtendAnnotationTarget> _annotatedSourceElements = context.getAnnotatedSourceElements();
      XtendAnnotationTarget _head = IterableExtensions.<XtendAnnotationTarget>head(_annotatedSourceElements);
      final Resource resource = _head.eResource();
      EList<Diagnostic> _errors = resource.getErrors();
      String _plus = ("Timeout (exceeded " + Integer.valueOf(this.timeout));
      String _plus_1 = (_plus + "ms) during annotation processing.");
      List<XtendAnnotationTarget> _annotatedSourceElements_1 = context.getAnnotatedSourceElements();
      XtendAnnotationTarget _head_1 = IterableExtensions.<XtendAnnotationTarget>head(_annotatedSourceElements_1);
      int _minus = (-1);
      EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(
        Severity.ERROR, 
        "time out", _plus_1, _head_1, 
        null, _minus, 
        null);
      boolean _add = _errors.add(_eObjectDiagnosticImpl);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
}

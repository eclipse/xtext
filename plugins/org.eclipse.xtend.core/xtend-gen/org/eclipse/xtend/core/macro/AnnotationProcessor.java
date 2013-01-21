/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.ModifyContextImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendMemberDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.lib.macro.ModifyProcessor;
import org.eclipse.xtend.lib.macro.PreModifyProcessor;
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.internal.StopWatches;
import org.eclipse.xtext.util.internal.StopWatches.StoppedTask;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * It checks whether the files contain macro annotations and calls their register and processing functions.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class AnnotationProcessor {
  private final static Logger logger = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(AnnotationProcessor.class);
      return _logger;
    }
  }.apply();
  
  @Inject
  private Provider<ModifyContextImpl> modifyContextProvider;
  
  /**
   * gets called from Xtend compiler, during "model inference", i.e. translation of Xtend AST to Java AST
   */
  public Object indexingPhase(final ActiveAnnotationContext ctx, final IAcceptor<JvmDeclaredType> acceptor, final CancelIndicator monitor) {
    Object _xblockexpression = null;
    {
      final StoppedTask task = StopWatches.forTask("[macros] indexingPhase");
      task.start();
      Object _xtrycatchfinallyexpression = null;
      try {
        Object _switchResult = null;
        Object _processorInstance = ctx.getProcessorInstance();
        final Object processor = _processorInstance;
        boolean _matched = false;
        if (!_matched) {
          if (processor instanceof PreModifyProcessor) {
            final PreModifyProcessor _preModifyProcessor = (PreModifyProcessor)processor;
            _matched=true;
            _switchResult = null;
          }
        }
        _xtrycatchfinallyexpression = _switchResult;
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable e = (Throwable)_t;
          this.handleException(e, ctx);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        task.stop();
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
  
  public void handleException(final Throwable e, final ActiveAnnotationContext ctx) {
    try {
      boolean _matched = false;
      if (!_matched) {
        if (e instanceof VirtualMachineError) {
          final VirtualMachineError _virtualMachineError = (VirtualMachineError)e;
          _matched=true;
          throw _virtualMachineError;
        }
      }
      Object _processorInstance = ctx.getProcessorInstance();
      String _plus = ("error while executing \'" + _processorInstance);
      String _plus_1 = (_plus + "\' on \'");
      List<XtendAnnotationTarget> _annotatedSourceElements = ctx.getAnnotatedSourceElements();
      String _plus_2 = (_plus_1 + _annotatedSourceElements);
      String _plus_3 = (_plus_2 + "\' : ");
      String _message = e.getMessage();
      String _plus_4 = (_plus_3 + _message);
      AnnotationProcessor.logger.error(_plus_4);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Object inferencePhase(final ActiveAnnotationContext ctx, final CancelIndicator monitor) {
    Object _xblockexpression = null;
    {
      final StoppedTask task = StopWatches.forTask("[macros] inferencePhase");
      task.start();
      Object _xtrycatchfinallyexpression = null;
      try {
        Object _switchResult = null;
        Object _processorInstance = ctx.getProcessorInstance();
        final Object processor = _processorInstance;
        boolean _matched = false;
        if (!_matched) {
          if (processor instanceof ModifyProcessor) {
            final ModifyProcessor _modifyProcessor = (ModifyProcessor)processor;
            _matched=true;
            final ModifyContextImpl modifyCtx = this.modifyContextProvider.get();
            CompilationUnitImpl _compilationUnit = ctx.getCompilationUnit();
            modifyCtx.setUnit(_compilationUnit);
            List<XtendAnnotationTarget> _annotatedSourceElements = ctx.getAnnotatedSourceElements();
            final Function1<XtendAnnotationTarget,MutableNamedElement> _function = new Function1<XtendAnnotationTarget,MutableNamedElement>() {
                public MutableNamedElement apply(final XtendAnnotationTarget it) {
                  CompilationUnitImpl _compilationUnit = ctx.getCompilationUnit();
                  final XtendMemberDeclarationImpl xtendMember = _compilationUnit.toXtendMemberDeclaration(((XtendMember) it));
                  return modifyCtx.getGeneratedElement(xtendMember);
                }
              };
            List<MutableNamedElement> _map = ListExtensions.<XtendAnnotationTarget, MutableNamedElement>map(_annotatedSourceElements, _function);
            _modifyProcessor.modify(_map, modifyCtx);
          }
        }
        _xtrycatchfinallyexpression = _switchResult;
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable e = (Throwable)_t;
          this.handleException(e, ctx);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        task.stop();
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
}

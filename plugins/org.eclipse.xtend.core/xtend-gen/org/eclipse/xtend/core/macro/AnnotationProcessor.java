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
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * It checks whether the files contain macro annotations and calls their register and processing functions.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class AnnotationProcessor {
  @Inject
  private ModifyContextImpl modifyContext;
  
  /**
   * gets called from Xtend compiler, during "model inference", i.e. translation of Xtend AST to Java AST
   */
  public Object indexingPhase(final ActiveAnnotationContext ctx, final IAcceptor<JvmDeclaredType> acceptor, final CancelIndicator monitor) {
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
    return _switchResult;
  }
  
  public Object inferencePhase(final ActiveAnnotationContext ctx, final CancelIndicator monitor) {
    Object _switchResult = null;
    Object _processorInstance = ctx.getProcessorInstance();
    final Object processor = _processorInstance;
    boolean _matched = false;
    if (!_matched) {
      if (processor instanceof ModifyProcessor) {
        final ModifyProcessor _modifyProcessor = (ModifyProcessor)processor;
        _matched=true;
        List<XtendAnnotationTarget> _annotatedSourceElements = ctx.getAnnotatedSourceElements();
        final Function1<XtendAnnotationTarget,MutableNamedElement> _function = new Function1<XtendAnnotationTarget,MutableNamedElement>() {
            public MutableNamedElement apply(final XtendAnnotationTarget it) {
              CompilationUnitImpl _compilationUnit = ctx.getCompilationUnit();
              final XtendMemberDeclarationImpl xtendMember = _compilationUnit.toXtendMemberDeclaration(((XtendMember) it));
              return AnnotationProcessor.this.modifyContext.getGeneratedElement(xtendMember);
            }
          };
        List<MutableNamedElement> _map = ListExtensions.<XtendAnnotationTarget, MutableNamedElement>map(_annotatedSourceElements, _function);
        _modifyProcessor.modify(_map, this.modifyContext);
      }
    }
    return _switchResult;
  }
}

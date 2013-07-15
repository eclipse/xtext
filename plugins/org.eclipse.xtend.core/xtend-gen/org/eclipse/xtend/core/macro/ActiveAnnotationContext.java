/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class ActiveAnnotationContext {
  private final static Logger LOG = new Function0<Logger>() {
    public Logger apply() {
      Logger _logger = Logger.getLogger(ActiveAnnotationContext.class);
      return _logger;
    }
  }.apply();
  
  private final List<XtendAnnotationTarget> _annotatedSourceElements = new Function0<List<XtendAnnotationTarget>>() {
    public List<XtendAnnotationTarget> apply() {
      ArrayList<XtendAnnotationTarget> _newArrayList = CollectionLiterals.<XtendAnnotationTarget>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public List<XtendAnnotationTarget> getAnnotatedSourceElements() {
    return this._annotatedSourceElements;
  }
  
  private Object _processorInstance;
  
  public Object getProcessorInstance() {
    return this._processorInstance;
  }
  
  public void setProcessorInstance(final Object processorInstance) {
    this._processorInstance = processorInstance;
  }
  
  private CompilationUnitImpl _compilationUnit;
  
  public CompilationUnitImpl getCompilationUnit() {
    return this._compilationUnit;
  }
  
  public void setCompilationUnit(final CompilationUnitImpl compilationUnit) {
    this._compilationUnit = compilationUnit;
  }
  
  public void handleProcessingError(final Resource resource, final Throwable t) {
    try {
      if ((t instanceof VirtualMachineError)) {
        throw t;
      }
      final EList<Diagnostic> errors = resource.getErrors();
      String _plus = ("Error during annotation processing :" + t);
      final String msg = (_plus + " (see error log for details)");
      final List<? extends EObject> sourceElements = this.getAnnotatedSourceElements();
      for (final EObject target : sourceElements) {
        boolean _matched = false;
        if (!_matched) {
          if (target instanceof XtendAnnotationTarget) {
            final XtendAnnotationTarget _xtendAnnotationTarget = (XtendAnnotationTarget)target;
            _matched=true;
            final EList<XAnnotation> annotations = _xtendAnnotationTarget.getAnnotations();
            EObject _xifexpression = null;
            boolean _isEmpty = annotations.isEmpty();
            if (_isEmpty) {
              _xifexpression = _xtendAnnotationTarget;
            } else {
              XAnnotation _head = IterableExtensions.<XAnnotation>head(annotations);
              _xifexpression = _head;
            }
            int _minus = (-1);
            EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.PROCESSING_ERROR, msg, _xifexpression, null, _minus, null);
            errors.add(_eObjectDiagnosticImpl);
          }
        }
        if (!_matched) {
          int _minus = (-1);
          EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.PROCESSING_ERROR, msg, target, null, _minus, null);
          errors.add(_eObjectDiagnosticImpl);
        }
      }
      URI _uRI = resource.getURI();
      String _plus_1 = ("Error processing " + _uRI);
      String _plus_2 = (_plus_1 + " with processor ");
      Object _processorInstance = this.getProcessorInstance();
      String _plus_3 = (_plus_2 + _processorInstance);
      ActiveAnnotationContext.LOG.error(_plus_3, t);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

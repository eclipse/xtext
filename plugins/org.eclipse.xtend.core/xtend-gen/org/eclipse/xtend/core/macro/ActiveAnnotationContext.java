/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.AnnotationProcessor;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge
 */
@Accessors
@SuppressWarnings("all")
public class ActiveAnnotationContext {
  private final List<XtendAnnotationTarget> annotatedSourceElements = CollectionLiterals.<XtendAnnotationTarget>newArrayList();
  
  private Object processorInstance;
  
  private CompilationUnitImpl compilationUnit;
  
  public void handleProcessingError(final Resource resource, final Throwable t) {
    try {
      if ((t instanceof VirtualMachineError)) {
        throw t;
      }
      ActiveAnnotationContexts.AnnotationCallback _lastPhase = this.compilationUnit.getLastPhase();
      boolean _equals = Objects.equal(_lastPhase, ActiveAnnotationContexts.AnnotationCallback.GENERATION);
      if (_equals) {
        Throwables.propagateIfPossible(t);
        String _messageWithoutStackTrace = this.getMessageWithoutStackTrace(t);
        throw new RuntimeException(_messageWithoutStackTrace, t);
      }
      final String msg = this.getMessageWithStackTrace(t);
      final EList<Resource.Diagnostic> errors = resource.getErrors();
      final List<? extends EObject> sourceElements = this.getAnnotatedSourceElements();
      for (final EObject target : sourceElements) {
        boolean _matched = false;
        if (!_matched) {
          if (target instanceof XtendAnnotationTarget) {
            _matched=true;
            final EList<XAnnotation> annotations = ((XtendAnnotationTarget)target).getAnnotations();
            EObject _xifexpression = null;
            boolean _isEmpty = annotations.isEmpty();
            if (_isEmpty) {
              _xifexpression = target;
            } else {
              _xifexpression = IterableExtensions.<XAnnotation>head(annotations);
            }
            EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.PROCESSING_ERROR, msg, _xifexpression, null, (-1), null);
            errors.add(_eObjectDiagnosticImpl);
          }
        }
        if (!_matched) {
          EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.PROCESSING_ERROR, msg, target, null, (-1), null);
          errors.add(_eObjectDiagnosticImpl);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getMessageWithoutStackTrace(final Throwable t) {
    String _xifexpression = null;
    boolean _and = false;
    if (!(t instanceof IncompatibleClassChangeError)) {
      _and = false;
    } else {
      String _message = t.getMessage();
      boolean _contains = _message.contains("org.eclipse.xtend.lib.macro");
      _and = _contains;
    }
    if (_and) {
      _xifexpression = "An active annotation used in this file was compiled against a different version of Xtend than the one that is currently installed.";
    } else {
      _xifexpression = "Error during annotation processing:";
    }
    return _xifexpression;
  }
  
  public String getMessageWithStackTrace(final Throwable t) {
    final Function1<Throwable, String> _function = new Function1<Throwable, String>() {
      public String apply(final Throwable it) {
        String _xblockexpression = null;
        {
          StringWriter _stringWriter = new StringWriter();
          final Procedure1<StringWriter> _function = new Procedure1<StringWriter>() {
            public void apply(final StringWriter it) {
              PrintWriter _printWriter = new PrintWriter(it);
              final Procedure1<PrintWriter> _function = new Procedure1<PrintWriter>() {
                public void apply(final PrintWriter it) {
                  String _messageWithoutStackTrace = ActiveAnnotationContext.this.getMessageWithoutStackTrace(t);
                  it.println(_messageWithoutStackTrace);
                  t.printStackTrace(it);
                  it.flush();
                }
              };
              ObjectExtensions.<PrintWriter>operator_doubleArrow(_printWriter, _function);
            }
          };
          final StringWriter writer = ObjectExtensions.<StringWriter>operator_doubleArrow(_stringWriter, _function);
          _xblockexpression = writer.toString();
        }
        return _xblockexpression;
      }
    };
    return this.getMessageWithReducedStackTrace(t, _function);
  }
  
  public String getMessageWithReducedStackTrace(final Throwable t, final Function1<? super Throwable, ? extends String> getMessage) {
    final StackTraceElement[] stackTrace = t.getStackTrace();
    final ArrayList<StackTraceElement> reducedStackTrace = CollectionLiterals.<StackTraceElement>newArrayList();
    for (final StackTraceElement it : stackTrace) {
      {
        String _className = it.getClassName();
        String _name = AnnotationProcessor.class.getName();
        boolean _contains = _className.contains(_name);
        if (_contains) {
          try {
            t.setStackTrace(((StackTraceElement[])Conversions.unwrapArray(reducedStackTrace, StackTraceElement.class)));
            return getMessage.apply(t);
          } finally {
            t.setStackTrace(stackTrace);
          }
        }
        reducedStackTrace.add(it);
      }
    }
    return getMessage.apply(t);
  }
  
  @Pure
  public List<XtendAnnotationTarget> getAnnotatedSourceElements() {
    return this.annotatedSourceElements;
  }
  
  @Pure
  public Object getProcessorInstance() {
    return this.processorInstance;
  }
  
  public void setProcessorInstance(final Object processorInstance) {
    this.processorInstance = processorInstance;
  }
  
  @Pure
  public CompilationUnitImpl getCompilationUnit() {
    return this.compilationUnit;
  }
  
  public void setCompilationUnit(final CompilationUnitImpl compilationUnit) {
    this.compilationUnit = compilationUnit;
  }
}

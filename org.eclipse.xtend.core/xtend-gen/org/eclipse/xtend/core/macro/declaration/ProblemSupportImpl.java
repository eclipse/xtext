/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.services.Problem;
import org.eclipse.xtend.lib.macro.services.ProblemSupport;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

@SuppressWarnings("all")
public class ProblemSupportImpl implements ProblemSupport {
  private CompilationUnitImpl compilationUnit;

  private final List<Procedure0> delayedTasks = CollectionLiterals.<Procedure0>newArrayList();

  public ProblemSupportImpl(final CompilationUnitImpl compilationUnit) {
    this.compilationUnit = compilationUnit;
  }

  private void checkCanceled() {
    this.compilationUnit.checkCanceled();
  }

  private void checkValidationAllowed() {
    ActiveAnnotationContexts.AnnotationCallback _lastPhase = this.compilationUnit.getLastPhase();
    boolean _greaterThan = (_lastPhase.compareTo(ActiveAnnotationContexts.AnnotationCallback.VALIDATION) > 0);
    if (_greaterThan) {
      throw new IllegalStateException("Adding problems is not allowed after the validation phase");
    }
  }

  @Override
  public void addError(final Element element, final String message) {
    this.checkCanceled();
    this.checkValidationAllowed();
    final Pair<Resource, EObject> resAndObj = this.getResourceAndEObject(element);
    EList<Resource.Diagnostic> _errors = resAndObj.getKey().getErrors();
    EObject _value = resAndObj.getValue();
    EStructuralFeature _significantFeature = this.getSignificantFeature(resAndObj.getValue());
    EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.ERROR, "user.issue", message, _value, _significantFeature, (-1), null);
    _errors.add(_eObjectDiagnosticImpl);
  }

  @Override
  public void addWarning(final Element element, final String message) {
    this.checkCanceled();
    this.checkValidationAllowed();
    final Pair<Resource, EObject> resAndObj = this.getResourceAndEObject(element);
    EList<Resource.Diagnostic> _warnings = resAndObj.getKey().getWarnings();
    EObject _value = resAndObj.getValue();
    EStructuralFeature _significantFeature = this.getSignificantFeature(resAndObj.getValue());
    EObjectDiagnosticImpl _eObjectDiagnosticImpl = new EObjectDiagnosticImpl(Severity.WARNING, "user.issue", message, _value, _significantFeature, (-1), null);
    _warnings.add(_eObjectDiagnosticImpl);
  }

  @Override
  public void validateLater(final Procedure0 validationCallback) {
    ActiveAnnotationContexts.AnnotationCallback _lastPhase = this.compilationUnit.getLastPhase();
    boolean _lessThan = (_lastPhase.compareTo(ActiveAnnotationContexts.AnnotationCallback.VALIDATION) < 0);
    if (_lessThan) {
      this.delayedTasks.add(validationCallback);
    } else {
      validationCallback.apply();
    }
  }

  public void validationPhaseStarted() {
    try {
      final Consumer<Procedure0> _function = (Procedure0 it) -> {
        it.apply();
      };
      this.delayedTasks.forEach(_function);
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable t = (Throwable)_t;
        this.compilationUnit.handleProcessingError(Collections.<XtendFile>singleton(this.compilationUnit.getXtendFile()), this.compilationUnit.getXtendFile().eResource(), t);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      this.delayedTasks.clear();
    }
  }

  @Override
  public List<? extends Problem> getProblems(final Element element) {
    this.checkCanceled();
    final Pair<Resource, EObject> resAndObj = this.getResourceAndEObject(element);
    final Resource resource = resAndObj.getKey();
    EList<Resource.Diagnostic> _errors = resource.getErrors();
    EList<Resource.Diagnostic> _warnings = resource.getWarnings();
    final Iterable<EObjectDiagnosticImpl> issues = Iterables.<EObjectDiagnosticImpl>filter((Iterables.<Resource.Diagnostic>concat(_errors, _warnings)), EObjectDiagnosticImpl.class);
    final Function1<EObjectDiagnosticImpl, Boolean> _function = (EObjectDiagnosticImpl diag) -> {
      EObject _problematicObject = diag.getProblematicObject();
      EObject _value = resAndObj.getValue();
      return Boolean.valueOf(Objects.equal(_problematicObject, _value));
    };
    final Function1<EObjectDiagnosticImpl, Problem> _function_1 = (EObjectDiagnosticImpl diag) -> {
      String _code = diag.getCode();
      String _message = diag.getMessage();
      Problem.Severity _translateSeverity = this.translateSeverity(diag.getSeverity());
      ProblemImpl _problemImpl = new ProblemImpl(_code, _message, _translateSeverity);
      return ((Problem) _problemImpl);
    };
    final Iterable<Problem> result = IterableExtensions.<EObjectDiagnosticImpl, Problem>map(IterableExtensions.<EObjectDiagnosticImpl>filter(issues, _function), _function_1);
    return IterableExtensions.<Problem>toList(result);
  }

  public EStructuralFeature getSignificantFeature(final EObject obj) {
    EStructuralFeature _switchResult = null;
    boolean _matched = false;
    if (obj instanceof XtendTypeDeclaration) {
      _matched=true;
      _switchResult = XtendPackage.eINSTANCE.getXtendTypeDeclaration_Name();
    }
    if (!_matched) {
      if (obj instanceof XtendField) {
        _matched=true;
        _switchResult = XtendPackage.eINSTANCE.getXtendField_Name();
      }
    }
    if (!_matched) {
      if (obj instanceof XtendFunction) {
        _matched=true;
        _switchResult = XtendPackage.eINSTANCE.getXtendFunction_Name();
      }
    }
    if (!_matched) {
      if (obj instanceof JvmFormalParameter) {
        _matched=true;
        _switchResult = TypesPackage.eINSTANCE.getJvmFormalParameter_Name();
      }
    }
    if (!_matched) {
      if (obj instanceof XAnnotation) {
        _matched=true;
        _switchResult = XAnnotationsPackage.eINSTANCE.getXAnnotation_AnnotationType();
      }
    }
    return _switchResult;
  }

  private Pair<Resource, EObject> getResourceAndEObject(final Element element) {
    this.checkCanceled();
    boolean _matched = false;
    if (element instanceof CompilationUnitImpl) {
      boolean _equals = Objects.equal(element, this.compilationUnit);
      if (_equals) {
        _matched=true;
        Resource _eResource = this.compilationUnit.getXtendFile().eResource();
        XtendFile _xtendFile = this.compilationUnit.getXtendFile();
        return Pair.<Resource, EObject>of(_eResource, _xtendFile);
      }
    }
    if (!_matched) {
      if (element instanceof AbstractElementImpl) {
        _matched=true;
        final Resource resource = ((AbstractElementImpl<? extends EObject>)element).getDelegate().eResource();
        Resource _eResource = this.compilationUnit.getXtendFile().eResource();
        boolean _equals = Objects.equal(resource, _eResource);
        if (_equals) {
          final EObject eobject = this.compilationUnit.getJvmModelAssociations().getPrimarySourceElement(((AbstractElementImpl<? extends EObject>)element).getDelegate());
          if ((eobject == null)) {
            EObject _delegate = ((AbstractElementImpl<? extends EObject>)element).getDelegate();
            return Pair.<Resource, EObject>of(resource, _delegate);
          }
          return Pair.<Resource, EObject>of(resource, eobject);
        }
      }
    }
    throw new IllegalArgumentException("You can only add issues on locally declared elements.");
  }

  private Problem.Severity translateSeverity(final Severity severity) {
    Problem.Severity _switchResult = null;
    if (severity != null) {
      switch (severity) {
        case ERROR:
          _switchResult = Problem.Severity.ERROR;
          break;
        case WARNING:
          _switchResult = Problem.Severity.WARNING;
          break;
        case INFO:
          _switchResult = Problem.Severity.INFO;
          break;
        case IGNORE:
          _switchResult = Problem.Severity.IGNORE;
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
}

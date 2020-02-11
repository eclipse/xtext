/**
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.BrokenTypeRefDetector;
import org.eclipse.xtext.xbase.compiler.IElementIssueProvider;
import org.eclipse.xtext.xbase.compiler.LoopParams;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.output.ErrorTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class ErrorSafeExtensions {
  @Inject
  @Extension
  private TypeReferenceSerializer _typeReferenceSerializer;
  
  @Inject
  private IElementIssueProvider.Factory issueProviderFactory;
  
  public Iterable<Issue> getErrors(final EObject element) {
    Iterable<Issue> _xblockexpression = null;
    {
      final IElementIssueProvider issueProvider = this.issueProviderFactory.get(element.eResource());
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        Severity _severity = it.getSeverity();
        return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
      };
      _xblockexpression = IterableExtensions.<Issue>filter(issueProvider.getIssues(element), _function);
    }
    return _xblockexpression;
  }
  
  public boolean hasErrors(final EObject element) {
    boolean _xblockexpression = false;
    {
      final IElementIssueProvider issueProvider = this.issueProviderFactory.get(element.eResource());
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        Severity _severity = it.getSeverity();
        return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
      };
      _xblockexpression = IterableExtensions.<Issue>exists(issueProvider.getIssues(element), _function);
    }
    return _xblockexpression;
  }
  
  public <T extends EObject> void forEachSafely(final ITreeAppendable appendable, final Iterable<T> elements, final Procedure1<? super LoopParams> loopInitializer, final Procedure2<? super T, ? super ITreeAppendable> body) {
    boolean _isEmpty = IterableExtensions.isEmpty(elements);
    if (_isEmpty) {
      return;
    }
    LoopParams _loopParams = new LoopParams();
    final LoopParams loopParams = ObjectExtensions.<LoopParams>operator_doubleArrow(_loopParams, loopInitializer);
    final Function1<T, Boolean> _function = (T it) -> {
      return Boolean.valueOf(this.hasErrors(it));
    };
    int _size = IterableExtensions.size(IterableExtensions.<T>filter(elements, _function));
    int _size_1 = IterableExtensions.size(elements);
    final boolean allElementsBroken = (_size == _size_1);
    ITreeAppendable _xifexpression = null;
    if (allElementsBroken) {
      _xifexpression = this.openErrorAppendable(appendable, null);
    } else {
      _xifexpression = appendable;
    }
    ITreeAppendable currentAppendable = _xifexpression;
    loopParams.appendPrefix(currentAppendable);
    boolean isFirst = true;
    boolean isFirstBroken = true;
    for (final T element : elements) {
      boolean _hasErrors = this.hasErrors(element);
      boolean _not = (!_hasErrors);
      if (_not) {
        currentAppendable = this.closeErrorAppendable(appendable, currentAppendable);
        if ((!isFirst)) {
          loopParams.appendSeparator(appendable);
        }
        isFirst = false;
        body.apply(element, appendable);
      } else {
        if ((!allElementsBroken)) {
          currentAppendable = this.openErrorAppendable(appendable, currentAppendable);
        }
        if (((!isFirst) || (!isFirstBroken))) {
          loopParams.appendSeparator(currentAppendable);
        }
        isFirstBroken = false;
        try {
          body.apply(element, currentAppendable);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    ITreeAppendable _xifexpression_1 = null;
    if (allElementsBroken) {
      _xifexpression_1 = currentAppendable;
    } else {
      _xifexpression_1 = this.closeErrorAppendable(appendable, currentAppendable);
    }
    currentAppendable = _xifexpression_1;
    loopParams.appendSuffix(currentAppendable);
    this.closeErrorAppendable(appendable, currentAppendable);
  }
  
  protected ITreeAppendable openErrorAppendable(final ITreeAppendable parent, final ITreeAppendable child) {
    ITreeAppendable _xifexpression = null;
    if ((!(child instanceof ErrorTreeAppendable))) {
      _xifexpression = parent.errorChild().append("/* ");
    } else {
      _xifexpression = child;
    }
    return _xifexpression;
  }
  
  protected ITreeAppendable closeErrorAppendable(final ITreeAppendable parent, final ITreeAppendable child) {
    ITreeAppendable _xblockexpression = null;
    {
      if (((child instanceof ErrorTreeAppendable) && (!Objects.equal(child, parent)))) {
        child.append(" */");
      }
      _xblockexpression = parent;
    }
    return _xblockexpression;
  }
  
  public void serializeSafely(final JvmTypeReference typeRef, final ITreeAppendable appendable) {
    this.serializeSafely(typeRef, null, appendable);
  }
  
  public void serializeSafely(final JvmTypeReference typeRef, final String surrogateType, final ITreeAppendable appendable) {
    if (((typeRef == null) || (typeRef.getType() == null))) {
      boolean _matched = false;
      if (typeRef instanceof JvmSpecializedTypeReference) {
        _matched=true;
        this.serializeSafely(((JvmSpecializedTypeReference)typeRef).getEquivalent(), surrogateType, appendable);
      }
      if (!_matched) {
        if (typeRef instanceof JvmUnknownTypeReference) {
          _matched=true;
          appendable.append(((JvmUnknownTypeReference)typeRef).getQualifiedName());
        }
      }
      if (!_matched) {
        {
          appendable.append("Object");
          final ITreeAppendable errorChild = this.openErrorAppendable(appendable, appendable);
          errorChild.append("type is \'null\'");
          this.closeErrorAppendable(appendable, errorChild);
        }
      }
    } else {
      BrokenTypeRefDetector _brokenTypeRefDetector = new BrokenTypeRefDetector();
      Boolean _accept = typeRef.<Boolean>accept(_brokenTypeRefDetector);
      if ((_accept).booleanValue()) {
        final ITreeAppendable errorChild = this.openErrorAppendable(appendable, appendable);
        try {
          this._typeReferenceSerializer.serialize(typeRef, typeRef.eContainer(), errorChild);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        this.closeErrorAppendable(appendable, errorChild);
        if ((surrogateType != null)) {
          appendable.append(surrogateType);
        }
      } else {
        this._typeReferenceSerializer.serialize(typeRef, typeRef.eContainer(), appendable);
      }
    }
  }
  
  public void serializeSafely(final JvmAnnotationReference annotationRef, final ITreeAppendable appendable, final Procedure1<? super ITreeAppendable> onSuccess) {
    if (((annotationRef == null) || (annotationRef.getAnnotation() == null))) {
      final ITreeAppendable errorChild = this.openErrorAppendable(appendable, appendable);
      errorChild.append("annotation is \'null\'");
      this.closeErrorAppendable(appendable, errorChild);
    } else {
      boolean _eIsProxy = annotationRef.getAnnotation().eIsProxy();
      if (_eIsProxy) {
        final ITreeAppendable errorChild_1 = this.openErrorAppendable(appendable, appendable);
        appendable.append("@");
        appendable.append(annotationRef.getAnnotation());
        this.closeErrorAppendable(appendable, errorChild_1);
      } else {
        appendable.append("@");
        appendable.append(annotationRef.getAnnotation());
        onSuccess.apply(appendable);
      }
    }
  }
}

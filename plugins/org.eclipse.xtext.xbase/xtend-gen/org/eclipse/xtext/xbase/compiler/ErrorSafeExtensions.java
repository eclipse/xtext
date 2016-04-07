/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
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
      Resource _eResource = element.eResource();
      final IElementIssueProvider issueProvider = this.issueProviderFactory.get(_eResource);
      Iterable<Issue> _issues = issueProvider.getIssues(element);
      final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
        @Override
        public Boolean apply(final Issue it) {
          Severity _severity = it.getSeverity();
          return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
        }
      };
      _xblockexpression = IterableExtensions.<Issue>filter(_issues, _function);
    }
    return _xblockexpression;
  }
  
  public boolean hasErrors(final EObject element) {
    boolean _xblockexpression = false;
    {
      Resource _eResource = element.eResource();
      final IElementIssueProvider issueProvider = this.issueProviderFactory.get(_eResource);
      Iterable<Issue> _issues = issueProvider.getIssues(element);
      final Function1<Issue, Boolean> _function = new Function1<Issue, Boolean>() {
        @Override
        public Boolean apply(final Issue it) {
          Severity _severity = it.getSeverity();
          return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
        }
      };
      _xblockexpression = IterableExtensions.<Issue>exists(_issues, _function);
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
    final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
      @Override
      public Boolean apply(final T it) {
        return Boolean.valueOf(ErrorSafeExtensions.this.hasErrors(it));
      }
    };
    Iterable<T> _filter = IterableExtensions.<T>filter(elements, _function);
    int _size = IterableExtensions.size(_filter);
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
        ITreeAppendable _closeErrorAppendable = this.closeErrorAppendable(appendable, currentAppendable);
        currentAppendable = _closeErrorAppendable;
        if ((!isFirst)) {
          loopParams.appendSeparator(appendable);
        }
        isFirst = false;
        body.apply(element, appendable);
      } else {
        if ((!allElementsBroken)) {
          ITreeAppendable _openErrorAppendable = this.openErrorAppendable(appendable, currentAppendable);
          currentAppendable = _openErrorAppendable;
        }
        if (((!isFirst) || (!isFirstBroken))) {
          loopParams.appendSeparator(currentAppendable);
        }
        isFirstBroken = false;
        try {
          body.apply(element, currentAppendable);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception ignoreMe = (Exception)_t;
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
      ErrorTreeAppendable _errorChild = parent.errorChild();
      _xifexpression = _errorChild.append("/* ");
    } else {
      _xifexpression = child;
    }
    return _xifexpression;
  }
  
  protected ITreeAppendable closeErrorAppendable(final ITreeAppendable parent, final ITreeAppendable child) {
    ITreeAppendable _xblockexpression = null;
    {
      boolean _and = false;
      if (!(child instanceof ErrorTreeAppendable)) {
        _and = false;
      } else {
        boolean _notEquals = (!Objects.equal(child, parent));
        _and = _notEquals;
      }
      if (_and) {
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
    boolean _or = false;
    boolean _equals = Objects.equal(typeRef, null);
    if (_equals) {
      _or = true;
    } else {
      JvmType _type = typeRef.getType();
      boolean _equals_1 = Objects.equal(_type, null);
      _or = _equals_1;
    }
    if (_or) {
      boolean _matched = false;
      if (typeRef instanceof JvmSpecializedTypeReference) {
        _matched=true;
        JvmTypeReference _equivalent = ((JvmSpecializedTypeReference)typeRef).getEquivalent();
        this.serializeSafely(_equivalent, surrogateType, appendable);
      }
      if (!_matched) {
        if (typeRef instanceof JvmUnknownTypeReference) {
          _matched=true;
          String _qualifiedName = ((JvmUnknownTypeReference)typeRef).getQualifiedName();
          appendable.append(_qualifiedName);
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
          EObject _eContainer = typeRef.eContainer();
          this._typeReferenceSerializer.serialize(typeRef, _eContainer, errorChild);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception ignoreMe = (Exception)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        this.closeErrorAppendable(appendable, errorChild);
        boolean _notEquals = (!Objects.equal(surrogateType, null));
        if (_notEquals) {
          appendable.append(surrogateType);
        }
      } else {
        EObject _eContainer_1 = typeRef.eContainer();
        this._typeReferenceSerializer.serialize(typeRef, _eContainer_1, appendable);
      }
    }
  }
  
  public void serializeSafely(final JvmAnnotationReference annotationRef, final ITreeAppendable appendable, final Procedure1<? super ITreeAppendable> onSuccess) {
    boolean _or = false;
    boolean _equals = Objects.equal(annotationRef, null);
    if (_equals) {
      _or = true;
    } else {
      JvmAnnotationType _annotation = annotationRef.getAnnotation();
      boolean _equals_1 = Objects.equal(_annotation, null);
      _or = _equals_1;
    }
    if (_or) {
      final ITreeAppendable errorChild = this.openErrorAppendable(appendable, appendable);
      errorChild.append("annotation is \'null\'");
      this.closeErrorAppendable(appendable, errorChild);
    } else {
      JvmAnnotationType _annotation_1 = annotationRef.getAnnotation();
      boolean _eIsProxy = _annotation_1.eIsProxy();
      if (_eIsProxy) {
        final ITreeAppendable errorChild_1 = this.openErrorAppendable(appendable, appendable);
        appendable.append("@");
        JvmAnnotationType _annotation_2 = annotationRef.getAnnotation();
        appendable.append(_annotation_2);
        this.closeErrorAppendable(appendable, errorChild_1);
      } else {
        appendable.append("@");
        JvmAnnotationType _annotation_3 = annotationRef.getAnnotation();
        appendable.append(_annotation_3);
        onSuccess.apply(appendable);
      }
    }
  }
}

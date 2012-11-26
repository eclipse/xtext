/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import com.google.inject.Provider;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.BrokenTypeRefDetector;
import org.eclipse.xtext.xbase.compiler.IElementIssueProvider;
import org.eclipse.xtext.xbase.compiler.LoopParams;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.output.ErrorTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
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
  private TypeReferenceSerializer _typeReferenceSerializer;
  
  @Inject
  private OnChangeEvictingCache cache;
  
  public Iterable<Issue> getErrors(final EObject element, final boolean includeContents) {
    Iterable<Issue> _xblockexpression = null;
    {
      String _name = IElementIssueProvider.class.getName();
      Resource _eResource = element.eResource();
      final Function0<IElementIssueProvider> _function = new Function0<IElementIssueProvider>() {
          public IElementIssueProvider apply() {
            return null;
          }
        };
      final IElementIssueProvider issueProvider = this.cache.<IElementIssueProvider>get(_name, _eResource, new Provider<IElementIssueProvider>() {
          public IElementIssueProvider get() {
            return _function.apply();
          }
      });
      Iterable<Issue> _xifexpression = null;
      boolean _equals = ObjectExtensions.operator_equals(issueProvider, null);
      if (_equals) {
        return Collections.<Issue>emptyList();
      } else {
        List<Issue> _issues = issueProvider.getIssues(element, includeContents);
        final Function1<Issue,Boolean> _function_1 = new Function1<Issue,Boolean>() {
            public Boolean apply(final Issue it) {
              Severity _severity = it.getSeverity();
              boolean _equals = ObjectExtensions.operator_equals(_severity, Severity.ERROR);
              return Boolean.valueOf(_equals);
            }
          };
        Iterable<Issue> _filter = IterableExtensions.<Issue>filter(_issues, _function_1);
        _xifexpression = _filter;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public boolean hasErrors(final EObject element, final boolean includeContents) {
    boolean _xblockexpression = false;
    {
      String _name = IElementIssueProvider.class.getName();
      Resource _eResource = element.eResource();
      final Function0<IElementIssueProvider> _function = new Function0<IElementIssueProvider>() {
          public IElementIssueProvider apply() {
            return null;
          }
        };
      final IElementIssueProvider issueProvider = this.cache.<IElementIssueProvider>get(_name, _eResource, new Provider<IElementIssueProvider>() {
          public IElementIssueProvider get() {
            return _function.apply();
          }
      });
      boolean _xifexpression = false;
      boolean _equals = ObjectExtensions.operator_equals(issueProvider, null);
      if (_equals) {
        return false;
      } else {
        List<Issue> _issues = issueProvider.getIssues(element, includeContents);
        final Function1<Issue,Boolean> _function_1 = new Function1<Issue,Boolean>() {
            public Boolean apply(final Issue it) {
              Severity _severity = it.getSeverity();
              boolean _equals = ObjectExtensions.operator_equals(_severity, Severity.ERROR);
              return Boolean.valueOf(_equals);
            }
          };
        boolean _exists = IterableExtensions.<Issue>exists(_issues, _function_1);
        _xifexpression = _exists;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public <T extends EObject> void forEachSafely(final ITreeAppendable appendable, final Iterable<T> elements, final Procedure1<? super LoopParams> loopInitializer, final Procedure2<? super T,? super ITreeAppendable> body) {
    boolean _isEmpty = IterableExtensions.isEmpty(elements);
    if (_isEmpty) {
      return;
    }
    LoopParams _loopParams = new LoopParams();
    final LoopParams loopParams = ObjectExtensions.<LoopParams>operator_doubleArrow(_loopParams, loopInitializer);
    final Function1<T,Boolean> _function = new Function1<T,Boolean>() {
        public Boolean apply(final T it) {
          boolean _hasErrors = ErrorSafeExtensions.this.hasErrors(it, true);
          return Boolean.valueOf(_hasErrors);
        }
      };
    Iterable<T> _filter = IterableExtensions.<T>filter(elements, _function);
    int _size = IterableExtensions.size(_filter);
    int _size_1 = IterableExtensions.size(elements);
    final boolean allElementsBroken = (_size == _size_1);
    ITreeAppendable _xifexpression = null;
    if (allElementsBroken) {
      T _head = IterableExtensions.<T>head(elements);
      ITreeAppendable _openErrorAppendable = this.openErrorAppendable(appendable, null, _head);
      _xifexpression = _openErrorAppendable;
    } else {
      _xifexpression = appendable;
    }
    ITreeAppendable currentAppendable = _xifexpression;
    loopParams.appendPrefix(currentAppendable);
    boolean isFirst = true;
    boolean isFirstBroken = true;
    for (final T element : elements) {
      boolean _hasErrors = this.hasErrors(element, true);
      boolean _not = (!_hasErrors);
      if (_not) {
        ITreeAppendable _closeErrorAppendable = this.closeErrorAppendable(appendable, currentAppendable);
        currentAppendable = _closeErrorAppendable;
        boolean _not_1 = (!isFirst);
        if (_not_1) {
          loopParams.appendSeparator(appendable);
        }
        isFirst = false;
        body.apply(element, appendable);
      } else {
        boolean _not_2 = (!allElementsBroken);
        if (_not_2) {
          ITreeAppendable _openErrorAppendable_1 = this.openErrorAppendable(appendable, currentAppendable, element);
          currentAppendable = _openErrorAppendable_1;
        }
        boolean _or = false;
        boolean _not_3 = (!isFirst);
        if (_not_3) {
          _or = true;
        } else {
          boolean _not_4 = (!isFirstBroken);
          _or = (_not_3 || _not_4);
        }
        if (_or) {
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
      ITreeAppendable _closeErrorAppendable_1 = this.closeErrorAppendable(appendable, currentAppendable);
      _xifexpression_1 = _closeErrorAppendable_1;
    }
    currentAppendable = _xifexpression_1;
    loopParams.appendSuffix(currentAppendable);
    this.closeErrorAppendable(appendable, currentAppendable);
  }
  
  protected ITreeAppendable openErrorAppendable(final ITreeAppendable parent, final ITreeAppendable child, final EObject context) {
    ITreeAppendable _xifexpression = null;
    boolean _not = (!(child instanceof ErrorTreeAppendable));
    if (_not) {
      ErrorTreeAppendable _errorChild = parent.errorChild(context);
      ITreeAppendable _append = _errorChild.append("/* ");
      _xifexpression = _append;
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
        boolean _notEquals = ObjectExtensions.operator_notEquals(child, parent);
        _and = ((child instanceof ErrorTreeAppendable) && _notEquals);
      }
      if (_and) {
        child.append(" */");
      }
      _xblockexpression = (parent);
    }
    return _xblockexpression;
  }
  
  public void serializeSafely(final JvmTypeReference typeRef, final ITreeAppendable appendable) {
    this.serializeSafely(typeRef, null, appendable);
  }
  
  public void serializeSafely(final JvmTypeReference typeRef, final String surrogateType, final ITreeAppendable appendable) {
    boolean _or = false;
    boolean _equals = ObjectExtensions.operator_equals(typeRef, null);
    if (_equals) {
      _or = true;
    } else {
      JvmType _type = typeRef.getType();
      boolean _equals_1 = ObjectExtensions.operator_equals(_type, null);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      EObject _eContainer = typeRef.eContainer();
      final ITreeAppendable errorChild = this.openErrorAppendable(appendable, appendable, _eContainer);
      errorChild.append("type is \'null\'");
      this.closeErrorAppendable(appendable, errorChild);
    } else {
      BrokenTypeRefDetector _brokenTypeRefDetector = new BrokenTypeRefDetector();
      Boolean _accept = typeRef.<Boolean>accept(_brokenTypeRefDetector);
      if ((_accept).booleanValue()) {
        EObject _eContainer_1 = typeRef.eContainer();
        final ITreeAppendable errorChild_1 = this.openErrorAppendable(appendable, appendable, _eContainer_1);
        try {
          EObject _eContainer_2 = typeRef.eContainer();
          this._typeReferenceSerializer.serialize(typeRef, _eContainer_2, errorChild_1);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception ignoreMe = (Exception)_t;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        this.closeErrorAppendable(appendable, errorChild_1);
        boolean _notEquals = ObjectExtensions.operator_notEquals(surrogateType, null);
        if (_notEquals) {
          appendable.append(surrogateType);
        }
      } else {
        EObject _eContainer_3 = typeRef.eContainer();
        this._typeReferenceSerializer.serialize(typeRef, _eContainer_3, appendable);
      }
    }
  }
}

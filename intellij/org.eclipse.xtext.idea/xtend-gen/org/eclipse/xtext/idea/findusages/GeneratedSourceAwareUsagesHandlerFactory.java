/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.findusages;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesHandlerFactory;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.project.IndexNotReadyException;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.idea.findusages.GeneratedSourceAwareFindUsagesHandler;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Anton Kosyakov - Refactoring and testing
 */
@SuppressWarnings("all")
public class GeneratedSourceAwareUsagesHandlerFactory extends FindUsagesHandlerFactory {
  private final static Logger LOG = Logger.getInstance("#com.intellij.find.findParameterUsages.FindUsagesManager");
  
  @Inject
  private ITraceForVirtualFileProvider traceProvider;
  
  public GeneratedSourceAwareUsagesHandlerFactory() {
    IdeaSharedInjectorProvider.injectMembers(this);
  }
  
  @Override
  public boolean canFindUsages(final PsiElement element) {
    Project _project = element.getProject();
    FindUsagesHandlerFactory[] delegates = Extensions.<FindUsagesHandlerFactory>getExtensions(FindUsagesHandlerFactory.EP_NAME, _project);
    for (final FindUsagesHandlerFactory delegate : delegates) {
      if ((delegate != this)) {
        try {
          boolean _canFindUsages = delegate.canFindUsages(element);
          if (_canFindUsages) {
            return true;
          }
        } catch (final Throwable _t) {
          if (_t instanceof IndexNotReadyException) {
            final IndexNotReadyException e = (IndexNotReadyException)_t;
            throw e;
          } else if (_t instanceof ProcessCanceledException) {
            final ProcessCanceledException e_1 = (ProcessCanceledException)_t;
            throw e_1;
          } else if (_t instanceof Exception) {
            final Exception e_2 = (Exception)_t;
            GeneratedSourceAwareUsagesHandlerFactory.LOG.error(e_2);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    return false;
  }
  
  @Override
  public FindUsagesHandler createFindUsagesHandler(final PsiElement element, final boolean forHighlightUsages) {
    if (forHighlightUsages) {
      return null;
    }
    final FindUsagesHandler primaryHandler = this.delegateFindUsagesHandler(element);
    boolean _isNullHandler = this.isNullHandler(primaryHandler);
    if (_isNullHandler) {
      return null;
    }
    final Iterable<FindUsagesHandler> secondaryHandlers = this.getSecondaryHandlers(element);
    boolean _isEmpty = IterableExtensions.isEmpty(secondaryHandlers);
    if (_isEmpty) {
      return primaryHandler;
    }
    return new GeneratedSourceAwareFindUsagesHandler(primaryHandler, secondaryHandlers);
  }
  
  protected Iterable<FindUsagesHandler> getSecondaryHandlers(final PsiElement element) {
    List<? extends PsiElement> _secondaryElements = this.getSecondaryElements(element);
    final Function1<PsiElement, FindUsagesHandler> _function = new Function1<PsiElement, FindUsagesHandler>() {
      @Override
      public FindUsagesHandler apply(final PsiElement it) {
        return GeneratedSourceAwareUsagesHandlerFactory.this.delegateFindUsagesHandler(it);
      }
    };
    List<FindUsagesHandler> _map = ListExtensions.map(_secondaryElements, _function);
    final Function1<FindUsagesHandler, Boolean> _function_1 = new Function1<FindUsagesHandler, Boolean>() {
      @Override
      public Boolean apply(final FindUsagesHandler it) {
        boolean _isNullHandler = GeneratedSourceAwareUsagesHandlerFactory.this.isNullHandler(it);
        return Boolean.valueOf((!_isNullHandler));
      }
    };
    return IterableExtensions.<FindUsagesHandler>filter(_map, _function_1);
  }
  
  protected List<? extends PsiElement> getSecondaryElements(final PsiElement element) {
    final List<? extends PsiElement> generatedElements = this.getGeneratedElements(element);
    boolean _isEmpty = generatedElements.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      return generatedElements;
    }
    return this.getOriginalElements(element);
  }
  
  protected List<? extends PsiElement> getOriginalElements(final PsiElement element) {
    if ((element instanceof PsiNameIdentifierOwner)) {
      PsiElement _nameIdentifier = ((PsiNameIdentifierOwner)element).getNameIdentifier();
      return this.getOriginalElements(_nameIdentifier);
    }
    List<? extends PsiElement> _originalElements = this.traceProvider.getOriginalElements(element);
    final Function1<PsiElement, PsiNamedElement> _function = new Function1<PsiElement, PsiNamedElement>() {
      @Override
      public PsiNamedElement apply(final PsiElement it) {
        return PsiTreeUtil.<PsiNamedElement>getParentOfType(it, PsiNamedElement.class, false);
      }
    };
    List<PsiNamedElement> _map = ListExtensions.map(_originalElements, _function);
    Iterable<PsiNamedElement> _filterNull = IterableExtensions.<PsiNamedElement>filterNull(_map);
    Set<PsiNamedElement> _set = IterableExtensions.<PsiNamedElement>toSet(_filterNull);
    final List<PsiNamedElement> result = IterableExtensions.<PsiNamedElement>toList(_set);
    return result;
  }
  
  protected List<? extends PsiElement> getGeneratedElements(final PsiElement element) {
    if ((element instanceof PsiNameIdentifierOwner)) {
      final PsiElement nameIdentifier = ((PsiNameIdentifierOwner)element).getNameIdentifier();
      if ((nameIdentifier == null)) {
        return Collections.<PsiElement>emptyList();
      }
      return this.getGeneratedElements(nameIdentifier);
    }
    final ArrayList<PsiNamedElement> result = CollectionLiterals.<PsiNamedElement>newArrayList();
    List<? extends PsiElement> _generatedElements = this.traceProvider.getGeneratedElements(element);
    for (final PsiElement generatedElement : _generatedElements) {
      {
        final PsiNamedElement parent = PsiTreeUtil.<PsiNamedElement>getParentOfType(generatedElement, PsiNamedElement.class, false);
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(parent, null));
        if (!_notEquals) {
          _and = false;
        } else {
          boolean _contains = result.contains(parent);
          boolean _not = (!_contains);
          _and = _not;
        }
        if (_and) {
          result.add(parent);
        }
      }
    }
    return result;
  }
  
  protected boolean isNullHandler(final FindUsagesHandler handler) {
    return ((handler == null) || (handler == FindUsagesHandler.NULL_HANDLER));
  }
  
  protected FindUsagesHandler delegateFindUsagesHandler(final PsiElement element) {
    Project _project = element.getProject();
    FindUsagesHandlerFactory[] delegates = Extensions.<FindUsagesHandlerFactory>getExtensions(FindUsagesHandlerFactory.EP_NAME, _project);
    for (final FindUsagesHandlerFactory delegate : delegates) {
      if ((delegate != this)) {
        try {
          boolean _canFindUsages = delegate.canFindUsages(element);
          if (_canFindUsages) {
            final FindUsagesHandler handler = delegate.createFindUsagesHandler(element, false);
            if ((handler != null)) {
              return handler;
            }
          }
        } catch (final Throwable _t) {
          if (_t instanceof IndexNotReadyException) {
            final IndexNotReadyException e = (IndexNotReadyException)_t;
            throw e;
          } else if (_t instanceof ProcessCanceledException) {
            final ProcessCanceledException e_1 = (ProcessCanceledException)_t;
            throw e_1;
          } else if (_t instanceof Exception) {
            final Exception e_2 = (Exception)_t;
            GeneratedSourceAwareUsagesHandlerFactory.LOG.error(e_2);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    return null;
  }
}

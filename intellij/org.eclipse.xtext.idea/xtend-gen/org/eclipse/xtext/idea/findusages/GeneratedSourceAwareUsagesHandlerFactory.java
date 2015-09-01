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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO decorate all find usage requests and use a custom Processor<UsageInfo> in the FindUsagesHandler to redirect navigation requests
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
    boolean _or = false;
    boolean _or_1 = false;
    FindUsagesHandlerFactory _delegateFindFactory = this.delegateFindFactory(element);
    boolean _tripleNotEquals = (_delegateFindFactory != null);
    if (_tripleNotEquals) {
      _or_1 = true;
    } else {
      List<? extends PsiElement> _generatedElements = this.getGeneratedElements(element);
      final Function1<PsiElement, Boolean> _function = new Function1<PsiElement, Boolean>() {
        @Override
        public Boolean apply(final PsiElement it) {
          FindUsagesHandlerFactory _delegateFindFactory = GeneratedSourceAwareUsagesHandlerFactory.this.delegateFindFactory(it);
          return Boolean.valueOf((_delegateFindFactory != null));
        }
      };
      boolean _exists = IterableExtensions.exists(_generatedElements, _function);
      _or_1 = _exists;
    }
    if (_or_1) {
      _or = true;
    } else {
      List<? extends PsiElement> _originalElements = this.getOriginalElements(element);
      final Function1<PsiElement, Boolean> _function_1 = new Function1<PsiElement, Boolean>() {
        @Override
        public Boolean apply(final PsiElement it) {
          FindUsagesHandlerFactory _delegateFindFactory = GeneratedSourceAwareUsagesHandlerFactory.this.delegateFindFactory(it);
          return Boolean.valueOf((_delegateFindFactory != null));
        }
      };
      boolean _exists_1 = IterableExtensions.exists(_originalElements, _function_1);
      _or = _exists_1;
    }
    return _or;
  }
  
  @Override
  public FindUsagesHandler createFindUsagesHandler(final PsiElement element, final boolean forHighlightUsages) {
    FindUsagesHandlerFactory _delegateFindFactory = this.delegateFindFactory(element);
    final FindUsagesHandler primaryHandler = _delegateFindFactory.createFindUsagesHandler(element, forHighlightUsages);
    final List<? extends PsiElement> generatedElements = this.getGeneratedElements(element);
    boolean _isEmpty = generatedElements.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final GeneratedSourceAwareFindUsagesHandler handler = new GeneratedSourceAwareFindUsagesHandler(primaryHandler);
      this.addSecondaryHandlers(handler, generatedElements, forHighlightUsages);
      return handler;
    }
    if (forHighlightUsages) {
      return primaryHandler;
    }
    final List<? extends PsiElement> originalElements = this.getOriginalElements(element);
    boolean _isEmpty_1 = originalElements.isEmpty();
    if (_isEmpty_1) {
      return primaryHandler;
    }
    final GeneratedSourceAwareFindUsagesHandler handler_1 = new GeneratedSourceAwareFindUsagesHandler(primaryHandler);
    this.addSecondaryHandlers(handler_1, originalElements, forHighlightUsages);
    return handler_1;
  }
  
  protected void addSecondaryHandlers(final GeneratedSourceAwareFindUsagesHandler result, final List<? extends PsiElement> elements, final boolean forHighlightUsages) {
    final Procedure1<PsiElement> _function = new Procedure1<PsiElement>() {
      @Override
      public void apply(final PsiElement it) {
        final FindUsagesHandlerFactory delegateFactory = GeneratedSourceAwareUsagesHandlerFactory.this.delegateFindFactory(it);
        if ((delegateFactory != null)) {
          final FindUsagesHandler delegateHandler = delegateFactory.createFindUsagesHandler(it, forHighlightUsages);
          if (((delegateHandler != null) && (delegateHandler != FindUsagesHandler.NULL_HANDLER))) {
            result.addSecondaryHandler(delegateHandler);
          }
        }
      }
    };
    IterableExtensions.forEach(elements, _function);
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
  
  protected FindUsagesHandlerFactory delegateFindFactory(final PsiElement element) {
    Project _project = element.getProject();
    FindUsagesHandlerFactory[] delegates = Extensions.<FindUsagesHandlerFactory>getExtensions(FindUsagesHandlerFactory.EP_NAME, _project);
    for (final FindUsagesHandlerFactory delegate : delegates) {
      if ((delegate != this)) {
        try {
          boolean _canFindUsages = delegate.canFindUsages(element);
          if (_canFindUsages) {
            return delegate;
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

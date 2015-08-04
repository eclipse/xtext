/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.findusages;

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
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.idea.findusages.GeneratedSourceAwareFindUsagesHandler;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
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
  
  protected List<? extends PsiElement> getOriginalElements(final PsiElement element) {
    if ((element instanceof PsiNameIdentifierOwner)) {
      PsiElement _nameIdentifier = ((PsiNameIdentifierOwner)element).getNameIdentifier();
      return this.getOriginalElements(_nameIdentifier);
    }
    List<? extends PsiElement> _originalElements = this.traceProvider.getOriginalElements(element);
    final Function1<PsiElement, PsiNamedElement> _function = new Function1<PsiElement, PsiNamedElement>() {
      @Override
      public PsiNamedElement apply(final PsiElement it) {
        return PsiTreeUtil.<PsiNamedElement>getParentOfType(it, PsiNamedElement.class);
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
      PsiElement _nameIdentifier = ((PsiNameIdentifierOwner)element).getNameIdentifier();
      return this.getGeneratedElements(_nameIdentifier);
    }
    List<? extends PsiElement> _generatedElements = this.traceProvider.getGeneratedElements(element);
    final Function1<PsiElement, PsiNamedElement> _function = new Function1<PsiElement, PsiNamedElement>() {
      @Override
      public PsiNamedElement apply(final PsiElement it) {
        return PsiTreeUtil.<PsiNamedElement>getParentOfType(it, PsiNamedElement.class);
      }
    };
    List<PsiNamedElement> _map = ListExtensions.map(_generatedElements, _function);
    Iterable<PsiNamedElement> _filterNull = IterableExtensions.<PsiNamedElement>filterNull(_map);
    Set<PsiNamedElement> _set = IterableExtensions.<PsiNamedElement>toSet(_filterNull);
    final List<PsiNamedElement> result = IterableExtensions.<PsiNamedElement>toList(_set);
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
  
  @Override
  public FindUsagesHandler createFindUsagesHandler(final PsiElement element, final boolean forHighlightUsages) {
    FindUsagesHandlerFactory _delegateFindFactory = this.delegateFindFactory(element);
    final FindUsagesHandler primaryDelegate = _delegateFindFactory.createFindUsagesHandler(element, forHighlightUsages);
    if (forHighlightUsages) {
      final List<? extends PsiElement> generatedElements = this.getGeneratedElements(element);
      FindUsagesHandler _xifexpression = null;
      boolean _isEmpty = generatedElements.isEmpty();
      if (_isEmpty) {
        _xifexpression = primaryDelegate;
      } else {
        GeneratedSourceAwareFindUsagesHandler _generatedSourceAwareFindUsagesHandler = new GeneratedSourceAwareFindUsagesHandler(primaryDelegate, true);
        final Procedure1<GeneratedSourceAwareFindUsagesHandler> _function = new Procedure1<GeneratedSourceAwareFindUsagesHandler>() {
          @Override
          public void apply(final GeneratedSourceAwareFindUsagesHandler it) {
            GeneratedSourceAwareUsagesHandlerFactory.this.addDelegates(it, generatedElements, forHighlightUsages);
          }
        };
        _xifexpression = ObjectExtensions.<GeneratedSourceAwareFindUsagesHandler>operator_doubleArrow(_generatedSourceAwareFindUsagesHandler, _function);
      }
      return _xifexpression;
    }
    final List<? extends PsiElement> originalElements = this.getOriginalElements(element);
    boolean _isEmpty_1 = originalElements.isEmpty();
    if (_isEmpty_1) {
      final List<? extends PsiElement> generatedElements_1 = this.getGeneratedElements(element);
      FindUsagesHandler _xifexpression_1 = null;
      boolean _isEmpty_2 = generatedElements_1.isEmpty();
      if (_isEmpty_2) {
        _xifexpression_1 = primaryDelegate;
      } else {
        GeneratedSourceAwareFindUsagesHandler _generatedSourceAwareFindUsagesHandler_1 = new GeneratedSourceAwareFindUsagesHandler(primaryDelegate, true);
        final Procedure1<GeneratedSourceAwareFindUsagesHandler> _function_1 = new Procedure1<GeneratedSourceAwareFindUsagesHandler>() {
          @Override
          public void apply(final GeneratedSourceAwareFindUsagesHandler it) {
            GeneratedSourceAwareUsagesHandlerFactory.this.addDelegates(it, generatedElements_1, forHighlightUsages);
          }
        };
        _xifexpression_1 = ObjectExtensions.<GeneratedSourceAwareFindUsagesHandler>operator_doubleArrow(_generatedSourceAwareFindUsagesHandler_1, _function_1);
      }
      return _xifexpression_1;
    } else {
      GeneratedSourceAwareFindUsagesHandler _generatedSourceAwareFindUsagesHandler_2 = new GeneratedSourceAwareFindUsagesHandler(primaryDelegate, true);
      final Procedure1<GeneratedSourceAwareFindUsagesHandler> _function_2 = new Procedure1<GeneratedSourceAwareFindUsagesHandler>() {
        @Override
        public void apply(final GeneratedSourceAwareFindUsagesHandler it) {
          GeneratedSourceAwareUsagesHandlerFactory.this.addDelegates(it, originalElements, forHighlightUsages);
        }
      };
      return ObjectExtensions.<GeneratedSourceAwareFindUsagesHandler>operator_doubleArrow(_generatedSourceAwareFindUsagesHandler_2, _function_2);
    }
  }
  
  public void addDelegates(final GeneratedSourceAwareFindUsagesHandler result, final List<? extends PsiElement> elements, final boolean forHighlightUsages) {
    final Procedure1<PsiElement> _function = new Procedure1<PsiElement>() {
      @Override
      public void apply(final PsiElement it) {
        final FindUsagesHandlerFactory delegateFactory = GeneratedSourceAwareUsagesHandlerFactory.this.delegateFindFactory(it);
        if ((delegateFactory != null)) {
          final FindUsagesHandler delegateHandler = delegateFactory.createFindUsagesHandler(it, forHighlightUsages);
          if (((delegateHandler != null) && (delegateHandler != FindUsagesHandler.NULL_HANDLER))) {
            result.addDelegate(delegateHandler);
          }
        }
      }
    };
    IterableExtensions.forEach(elements, _function);
  }
}

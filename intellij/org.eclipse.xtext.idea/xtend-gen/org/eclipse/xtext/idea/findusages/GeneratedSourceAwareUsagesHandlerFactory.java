/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.findusages;

import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesHandlerFactory;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.project.IndexNotReadyException;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import java.util.List;
import org.eclipse.xtext.idea.findusages.GeneratedSourceAwareFindUsagesHandler;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  
  @Override
  public boolean canFindUsages(final PsiElement element) {
    boolean _or = false;
    boolean _or_1 = false;
    FindUsagesHandlerFactory _delegateFindFactory = this.delegateFindFactory(element);
    boolean _tripleNotEquals = (_delegateFindFactory != null);
    if (_tripleNotEquals) {
      _or_1 = true;
    } else {
      List<PsiElement> _generatedElements = this.getGeneratedElements(element);
      final Function1<PsiElement, Boolean> _function = new Function1<PsiElement, Boolean>() {
        @Override
        public Boolean apply(final PsiElement it) {
          FindUsagesHandlerFactory _delegateFindFactory = GeneratedSourceAwareUsagesHandlerFactory.this.delegateFindFactory(it);
          return Boolean.valueOf((_delegateFindFactory != null));
        }
      };
      boolean _exists = IterableExtensions.<PsiElement>exists(_generatedElements, _function);
      _or_1 = _exists;
    }
    if (_or_1) {
      _or = true;
    } else {
      List<PsiElement> _originalElements = this.getOriginalElements(element);
      final Function1<PsiElement, Boolean> _function_1 = new Function1<PsiElement, Boolean>() {
        @Override
        public Boolean apply(final PsiElement it) {
          FindUsagesHandlerFactory _delegateFindFactory = GeneratedSourceAwareUsagesHandlerFactory.this.delegateFindFactory(it);
          return Boolean.valueOf((_delegateFindFactory != null));
        }
      };
      boolean _exists_1 = IterableExtensions.<PsiElement>exists(_originalElements, _function_1);
      _or = _exists_1;
    }
    return _or;
  }
  
  protected List<PsiElement> getOriginalElements(final PsiElement element) {
    if ((element instanceof PsiMethod)) {
      PsiClass _containingClass = ((PsiMethod)element).getContainingClass();
      String _name = ((PsiMethod)element).getName();
      String _plus = (_name + "gen");
      return (List<PsiElement>)Conversions.doWrapArray(_containingClass.findMethodsByName(_plus, false));
    }
    return CollectionLiterals.<PsiElement>emptyList();
  }
  
  protected List<PsiElement> getGeneratedElements(final PsiElement element) {
    if ((element instanceof PsiMethod)) {
      String _name = ((PsiMethod)element).getName();
      boolean _endsWith = _name.endsWith("gen");
      if (_endsWith) {
        PsiClass _containingClass = ((PsiMethod)element).getContainingClass();
        String _name_1 = ((PsiMethod)element).getName();
        String _name_2 = ((PsiMethod)element).getName();
        int _length = _name_2.length();
        int _minus = (_length - 3);
        String _substring = _name_1.substring(0, _minus);
        return (List<PsiElement>)Conversions.doWrapArray(_containingClass.findMethodsByName(_substring, false));
      }
    }
    return CollectionLiterals.<PsiElement>emptyList();
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
          } else if (_t instanceof Exception) {
            final Exception e_1 = (Exception)_t;
            GeneratedSourceAwareUsagesHandlerFactory.LOG.error(e_1);
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
      final List<PsiElement> generatedElements = this.getGeneratedElements(element);
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
    final List<PsiElement> originalElements = this.getOriginalElements(element);
    boolean _isEmpty_1 = originalElements.isEmpty();
    if (_isEmpty_1) {
      final List<PsiElement> generatedElements_1 = this.getGeneratedElements(element);
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
  
  public void addDelegates(final GeneratedSourceAwareFindUsagesHandler result, final List<PsiElement> elements, final boolean forHighlightUsages) {
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
    IterableExtensions.<PsiElement>forEach(elements, _function);
  }
}

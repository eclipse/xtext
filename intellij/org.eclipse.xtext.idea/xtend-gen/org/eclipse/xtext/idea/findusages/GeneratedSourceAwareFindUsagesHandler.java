/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.findusages;

import com.google.common.collect.Iterables;
import com.intellij.find.findUsages.AbstractFindUsagesDialog;
import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesOptions;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.usageView.UsageInfo;
import com.intellij.util.Processor;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class GeneratedSourceAwareFindUsagesHandler extends FindUsagesHandler {
  private final List<FindUsagesHandler> delegates = CollectionLiterals.<FindUsagesHandler>newArrayList();
  
  private final boolean includeAll;
  
  public GeneratedSourceAwareFindUsagesHandler(final FindUsagesHandler primaryDelegate, final boolean includeAll) {
    super(primaryDelegate.getPsiElement());
    this.includeAll = includeAll;
    this.addDelegate(primaryDelegate);
  }
  
  public void addDelegate(final FindUsagesHandler next) {
    this.delegates.add(next);
  }
  
  @Override
  public Collection<PsiReference> findReferencesToHighlight(final PsiElement target, final SearchScope searchScope) {
    FindUsagesHandler _primaryDelegate = this.getPrimaryDelegate();
    return _primaryDelegate.findReferencesToHighlight(target, searchScope);
  }
  
  protected FindUsagesHandler getPrimaryDelegate() {
    return IterableExtensions.<FindUsagesHandler>head(this.delegates);
  }
  
  @Override
  public AbstractFindUsagesDialog getFindUsagesDialog(final boolean isSingleFile, final boolean toShowInNewTab, final boolean mustOpenInNewTab) {
    FindUsagesHandler _primaryDelegate = this.getPrimaryDelegate();
    return _primaryDelegate.getFindUsagesDialog(isSingleFile, toShowInNewTab, mustOpenInNewTab);
  }
  
  @Override
  public FindUsagesOptions getFindUsagesOptions() {
    FindUsagesHandler _primaryDelegate = this.getPrimaryDelegate();
    return _primaryDelegate.getFindUsagesOptions();
  }
  
  @Override
  public FindUsagesOptions getFindUsagesOptions(final DataContext dataContext) {
    FindUsagesHandler _primaryDelegate = this.getPrimaryDelegate();
    return _primaryDelegate.getFindUsagesOptions(dataContext);
  }
  
  @Override
  public PsiElement[] getPrimaryElements() {
    final Function1<FindUsagesHandler, List<PsiElement>> _function = new Function1<FindUsagesHandler, List<PsiElement>>() {
      @Override
      public List<PsiElement> apply(final FindUsagesHandler it) {
        PsiElement[] _primaryElements = it.getPrimaryElements();
        return IterableExtensions.<PsiElement>toList(((Iterable<PsiElement>)Conversions.doWrapArray(_primaryElements)));
      }
    };
    List<List<PsiElement>> _map = ListExtensions.<FindUsagesHandler, List<PsiElement>>map(this.delegates, _function);
    return ((PsiElement[])Conversions.unwrapArray(Iterables.<PsiElement>concat(_map), PsiElement.class));
  }
  
  @Override
  public PsiElement[] getSecondaryElements() {
    final Function1<FindUsagesHandler, List<PsiElement>> _function = new Function1<FindUsagesHandler, List<PsiElement>>() {
      @Override
      public List<PsiElement> apply(final FindUsagesHandler it) {
        PsiElement[] _secondaryElements = it.getSecondaryElements();
        return IterableExtensions.<PsiElement>toList(((Iterable<PsiElement>)Conversions.doWrapArray(_secondaryElements)));
      }
    };
    List<List<PsiElement>> _map = ListExtensions.<FindUsagesHandler, List<PsiElement>>map(this.delegates, _function);
    return ((PsiElement[])Conversions.unwrapArray(Iterables.<PsiElement>concat(_map), PsiElement.class));
  }
  
  @Override
  public boolean processElementUsages(final PsiElement element, final Processor<UsageInfo> processor, final FindUsagesOptions options) {
    List<FindUsagesHandler> _relevantDelegates = this.getRelevantDelegates();
    final Function1<FindUsagesHandler, Boolean> _function = new Function1<FindUsagesHandler, Boolean>() {
      @Override
      public Boolean apply(final FindUsagesHandler it) {
        return Boolean.valueOf(GeneratedSourceAwareFindUsagesHandler.this.handles(it, element));
      }
    };
    FindUsagesHandler _findFirst = IterableExtensions.<FindUsagesHandler>findFirst(_relevantDelegates, _function);
    boolean _processElementUsages = false;
    if (_findFirst!=null) {
      _processElementUsages=_findFirst.processElementUsages(element, processor, options);
    }
    return _processElementUsages;
  }
  
  public List<FindUsagesHandler> getRelevantDelegates() {
    List<FindUsagesHandler> _xifexpression = null;
    if (this.includeAll) {
      _xifexpression = this.delegates;
    } else {
      _xifexpression = this.delegates.subList(0, 1);
    }
    return _xifexpression;
  }
  
  protected boolean handles(final FindUsagesHandler handler, final PsiElement element) {
    boolean _or = false;
    PsiElement[] _primaryElements = handler.getPrimaryElements();
    boolean _contains = ((List<PsiElement>)Conversions.doWrapArray(_primaryElements)).contains(element);
    if (_contains) {
      _or = true;
    } else {
      PsiElement[] _secondaryElements = handler.getSecondaryElements();
      boolean _contains_1 = ((List<PsiElement>)Conversions.doWrapArray(_secondaryElements)).contains(element);
      _or = _contains_1;
    }
    return _or;
  }
  
  @Override
  public boolean processUsagesInText(final PsiElement element, final Processor<UsageInfo> processor, final GlobalSearchScope searchScope) {
    List<FindUsagesHandler> _relevantDelegates = this.getRelevantDelegates();
    final Function1<FindUsagesHandler, Boolean> _function = new Function1<FindUsagesHandler, Boolean>() {
      @Override
      public Boolean apply(final FindUsagesHandler it) {
        return Boolean.valueOf(GeneratedSourceAwareFindUsagesHandler.this.handles(it, element));
      }
    };
    FindUsagesHandler _findFirst = IterableExtensions.<FindUsagesHandler>findFirst(_relevantDelegates, _function);
    boolean _processUsagesInText = false;
    if (_findFirst!=null) {
      _processUsagesInText=_findFirst.processUsagesInText(element, processor, searchScope);
    }
    return _processUsagesInText;
  }
}

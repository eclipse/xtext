/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.findusages;

import com.google.inject.Inject;
import com.intellij.lang.Language;
import com.intellij.openapi.application.QueryExecutorBase;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileSystemItem;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.SyntheticFileSystemItem;
import com.intellij.psi.meta.PsiMetaData;
import com.intellij.psi.meta.PsiMetaOwner;
import com.intellij.psi.search.SearchRequestCollector;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.search.searches.ReferencesSearch;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.Processor;
import java.util.List;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.idea.trace.ITraceForVirtualFileProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class GeneratedSourceAwareReferencesSearcher extends QueryExecutorBase<PsiReference, ReferencesSearch.SearchParameters> {
  @Inject
  @Extension
  private ITraceForVirtualFileProvider _iTraceForVirtualFileProvider;
  
  public GeneratedSourceAwareReferencesSearcher() {
    super(true);
    IdeaSharedInjectorProvider.injectMembers(this);
  }
  
  @Override
  public void processQuery(final ReferencesSearch.SearchParameters queryParameters, final Processor<PsiReference> consumer) {
    final PsiElement element = queryParameters.getElementToSearch();
    final boolean caseSensitive = this.isCaseSensitive(element);
    List<? extends PsiElement> _generatedElements = this._iTraceForVirtualFileProvider.getGeneratedElements(element);
    final Function1<PsiElement, String> _function = new Function1<PsiElement, String>() {
      @Override
      public String apply(final PsiElement it) {
        return GeneratedSourceAwareReferencesSearcher.this.getWord(it);
      }
    };
    List<String> _map = ListExtensions.map(_generatedElements, _function);
    final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
        return Boolean.valueOf((!_isNullOrEmpty));
      }
    };
    Iterable<String> _filter = IterableExtensions.<String>filter(_map, _function_1);
    for (final String word : _filter) {
      SearchRequestCollector _optimizer = queryParameters.getOptimizer();
      SearchScope _effectiveSearchScope = queryParameters.getEffectiveSearchScope();
      _optimizer.searchWord(word, _effectiveSearchScope, caseSensitive, element);
    }
  }
  
  protected boolean isCaseSensitive(final PsiElement element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (element instanceof SyntheticFileSystemItem) {
        _matched=true;
        Language _language = ((SyntheticFileSystemItem)element).getLanguage();
        _switchResult = _language.isCaseSensitive();
      }
    }
    if (!_matched) {
      if (element instanceof PsiFileSystemItem) {
        _matched=true;
        _switchResult = false;
      }
    }
    if (!_matched) {
      Language _language = element.getLanguage();
      _switchResult = _language.isCaseSensitive();
    }
    return _switchResult;
  }
  
  protected String getWord(final PsiElement element) {
    String _xblockexpression = null;
    {
      if ((element instanceof PsiFileSystemItem)) {
        if ((element instanceof SyntheticFileSystemItem)) {
          return this.getMetaDataName(element);
        }
        String _elvis = null;
        VirtualFile _virtualFile = ((PsiFileSystemItem)element).getVirtualFile();
        String _nameWithoutExtension = null;
        if (_virtualFile!=null) {
          _nameWithoutExtension=_virtualFile.getNameWithoutExtension();
        }
        if (_nameWithoutExtension != null) {
          _elvis = _nameWithoutExtension;
        } else {
          String _metaDataName = this.getMetaDataName(element);
          _elvis = _metaDataName;
        }
        return _elvis;
      }
      PsiNamedElement _parentOfType = null;
      if (element!=null) {
        _parentOfType=PsiTreeUtil.<PsiNamedElement>getParentOfType(element, PsiNamedElement.class, false);
      }
      final PsiNamedElement namedElement = _parentOfType;
      String _elvis_1 = null;
      String _metaDataName_1 = this.getMetaDataName(namedElement);
      if (_metaDataName_1 != null) {
        _elvis_1 = _metaDataName_1;
      } else {
        String _name = null;
        if (namedElement!=null) {
          _name=namedElement.getName();
        }
        _elvis_1 = _name;
      }
      _xblockexpression = _elvis_1;
    }
    return _xblockexpression;
  }
  
  protected String getMetaDataName(final PsiElement element) {
    String _xifexpression = null;
    if ((element instanceof PsiMetaOwner)) {
      PsiMetaData _metaData = ((PsiMetaOwner)element).getMetaData();
      String _name = null;
      if (_metaData!=null) {
        _name=_metaData.getName();
      }
      _xifexpression = _name;
    }
    return _xifexpression;
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.findusages;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.SearchRequestCollector;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.search.searches.ReferencesSearch;
import com.intellij.util.Processor;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.idea.findusages.IReferenceSearcher;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class JvmElementAwareReferenceSearcher implements IReferenceSearcher {
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  @Override
  public void processQuery(final ReferencesSearch.SearchParameters queryParameters, final Processor<PsiReference> consumer) {
    final PsiElement element = queryParameters.getElementToSearch();
    final Set<String> words = this.getWords(element);
    boolean _isEmpty = words.isEmpty();
    if (_isEmpty) {
      return;
    }
    Language _language = element.getLanguage();
    final boolean caseSensitive = _language.isCaseSensitive();
    for (final String word : words) {
      SearchRequestCollector _optimizer = queryParameters.getOptimizer();
      SearchScope _effectiveSearchScope = queryParameters.getEffectiveSearchScope();
      _optimizer.searchWord(word, _effectiveSearchScope, caseSensitive, element);
    }
  }
  
  protected Set<String> getWords(final PsiElement element) {
    if ((element instanceof PsiEObject)) {
      EObject _eObject = ((PsiEObject)element).getEObject();
      Set<EObject> _jvmElements = this._iJvmModelAssociations.getJvmElements(_eObject);
      final Function1<EObject, String> _function = new Function1<EObject, String>() {
        @Override
        public String apply(final EObject it) {
          return JvmElementAwareReferenceSearcher.this.getWord(it);
        }
      };
      Iterable<String> _map = IterableExtensions.<EObject, String>map(_jvmElements, _function);
      final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
        @Override
        public Boolean apply(final String it) {
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
          return Boolean.valueOf((!_isNullOrEmpty));
        }
      };
      Iterable<String> _filter = IterableExtensions.<String>filter(_map, _function_1);
      return IterableExtensions.<String>toSet(_filter);
    }
    return CollectionLiterals.<String>emptySet();
  }
  
  protected String getWord(final EObject jvmElement) {
    String _xifexpression = null;
    if ((jvmElement instanceof JvmIdentifiableElement)) {
      _xifexpression = ((JvmIdentifiableElement)jvmElement).getSimpleName();
    }
    return _xifexpression;
  }
}

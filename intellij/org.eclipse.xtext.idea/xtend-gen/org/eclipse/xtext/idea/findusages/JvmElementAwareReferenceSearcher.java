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
import com.google.inject.Singleton;
import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.SearchRequestCollector;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.search.searches.ReferencesSearch;
import com.intellij.util.Processor;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.idea.findusages.IReferenceSearcher;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.util.PropertyUtil;

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
    final Set<String> words = this.collectWords(element);
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
  
  protected Set<String> collectWords(final PsiElement element) {
    HashSet<String> _xblockexpression = null;
    {
      final HashSet<String> words = CollectionLiterals.<String>newHashSet();
      final Procedure1<String> _function = new Procedure1<String>() {
        @Override
        public void apply(final String word) {
          JvmElementAwareReferenceSearcher.this.accept(words, word);
        }
      };
      final Procedure1<String> acceptor = _function;
      if ((element instanceof PsiEObject)) {
        EObject _eObject = ((PsiEObject)element).getEObject();
        Set<EObject> _jvmElements = this._iJvmModelAssociations.getJvmElements(_eObject);
        for (final EObject jvmElement : _jvmElements) {
          this.collectWords(jvmElement, acceptor);
        }
      }
      _xblockexpression = words;
    }
    return _xblockexpression;
  }
  
  protected void accept(final Set<String> words, final String word) {
    boolean _notEquals = (!Objects.equal(word, null));
    if (_notEquals) {
      words.add(word);
    }
  }
  
  protected void collectWords(final EObject jvmElement, final Procedure1<? super String> acceptor) {
    if ((jvmElement instanceof JvmIdentifiableElement)) {
      String _simpleName = ((JvmIdentifiableElement)jvmElement).getSimpleName();
      acceptor.apply(_simpleName);
    }
    if ((jvmElement instanceof JvmFeature)) {
      String _propertyName = PropertyUtil.getPropertyName(((JvmFeature)jvmElement));
      acceptor.apply(_propertyName);
    }
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.findusages;

import com.intellij.openapi.application.QueryExecutorBase;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.searches.ReferencesSearch;
import com.intellij.util.Processor;
import org.eclipse.xtext.idea.findusages.IReferenceSearcher;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.XtextPsiElement;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextPsiElementReferenceSearcher extends QueryExecutorBase<PsiReference, ReferencesSearch.SearchParameters> {
  public XtextPsiElementReferenceSearcher() {
    super(true);
  }
  
  @Override
  public void processQuery(final ReferencesSearch.SearchParameters queryParameters, final Processor<PsiReference> consumer) {
    final PsiElement element = queryParameters.getElementToSearch();
    if ((element instanceof XtextPsiElement)) {
      IXtextLanguage _xtextLanguage = ((XtextPsiElement)element).getXtextLanguage();
      final IReferenceSearcher referenceSearcher = _xtextLanguage.<IReferenceSearcher>getInstance(IReferenceSearcher.class);
      referenceSearcher.processQuery(queryParameters, consumer);
    }
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.pom;

import com.google.common.base.Objects;
import com.intellij.lang.Language;
import com.intellij.openapi.util.TextRange;
import com.intellij.pom.PomDeclarationSearcher;
import com.intellij.pom.PomTarget;
import com.intellij.psi.PsiElement;
import com.intellij.util.Consumer;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.PsiEObjectIdentifier;
import org.eclipse.xtext.psi.PsiNamedEObject;

@SuppressWarnings("all")
public abstract class AbstractXtextPomDeclarationSearcher extends PomDeclarationSearcher {
  private final IXtextLanguage language;
  
  public AbstractXtextPomDeclarationSearcher(final IXtextLanguage language) {
    this.language = language;
    language.injectMembers(this);
  }
  
  @Override
  public void findDeclarationsAt(final PsiElement element, final int offsetInElement, final Consumer<PomTarget> consumer) {
    Language _language = element.getLanguage();
    boolean _notEquals = (!Objects.equal(_language, this.language));
    if (_notEquals) {
      return;
    }
    if ((element instanceof PsiNamedEObject)) {
      PsiEObjectIdentifier _nameIdentifier = ((PsiNamedEObject)element).getNameIdentifier();
      TextRange _textRange = null;
      if (_nameIdentifier!=null) {
        _textRange=_nameIdentifier.getTextRange();
      }
      final TextRange nameIdentifierRange = _textRange;
      boolean _notEquals_1 = (!Objects.equal(nameIdentifierRange, null));
      if (_notEquals_1) {
        TextRange _textRange_1 = ((PsiNamedEObject)element).getTextRange();
        int _startOffset = _textRange_1.getStartOffset();
        final int offsetInDocument = (_startOffset + offsetInElement);
        boolean _contains = nameIdentifierRange.contains(offsetInDocument);
        if (_contains) {
          consumer.consume(((PomTarget)element));
        }
      }
    }
  }
}

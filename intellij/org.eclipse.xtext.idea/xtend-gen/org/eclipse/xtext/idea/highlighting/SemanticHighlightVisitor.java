/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.highlighting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.daemon.impl.HighlightInfoType;
import com.intellij.codeInsight.daemon.impl.HighlightVisitor;
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder;
import com.intellij.lang.Language;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.idea.highlighting.TextAttributeProvider;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class SemanticHighlightVisitor implements HighlightVisitor {
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageId;
  
  @Inject
  private ISemanticHighlightingCalculator highlightCalculator;
  
  @Inject
  @Extension
  private TextAttributeProvider _textAttributeProvider;
  
  @Inject
  private Provider<SemanticHighlightVisitor> cloneProvider;
  
  private IHighlightedPositionAcceptor acceptor;
  
  @Override
  public boolean analyze(final PsiFile file, final boolean updateWholeFile, final HighlightInfoHolder holder, final Runnable action) {
    final IHighlightedPositionAcceptor _function = new IHighlightedPositionAcceptor() {
      @Override
      public void addPosition(final int offset, final int length, final String[] styles) {
        final Procedure1<String> _function = new Procedure1<String>() {
          @Override
          public void apply(final String it) {
            HighlightInfoType _highlightInfoType = SemanticHighlightVisitor.this.getHighlightInfoType(it);
            HighlightInfo.Builder _newHighlightInfo = HighlightInfo.newHighlightInfo(_highlightInfoType);
            HighlightInfo.Builder _range = _newHighlightInfo.range(offset, (offset + length));
            final HighlightInfo info = _range.create();
            holder.add(info);
          }
        };
        IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(styles)), _function);
      }
    };
    this.acceptor = _function;
    try {
      action.run();
    } finally {
      this.acceptor = null;
    }
    return true;
  }
  
  @Override
  public int order() {
    return 0;
  }
  
  @Override
  public boolean suitableForFile(final PsiFile file) {
    boolean _and = false;
    if (!(file instanceof BaseXtextFile)) {
      _and = false;
    } else {
      Language _language = file.getLanguage();
      String _iD = _language.getID();
      boolean _equals = Objects.equal(this.languageId, _iD);
      _and = _equals;
    }
    return _and;
  }
  
  @Override
  public void visit(final PsiElement element) {
    if ((element instanceof BaseXtextFile)) {
      XtextResource _resource = ((BaseXtextFile)element).getResource();
      this.highlightCalculator.provideHighlightingFor(_resource, this.acceptor);
    }
  }
  
  public HighlightInfoType getHighlightInfoType(final String xtextStyle) {
    TextAttributesKey _textAttributesKey = this._textAttributeProvider.getTextAttributesKey(xtextStyle);
    return new HighlightInfoType.HighlightInfoTypeImpl(HighlightSeverity.INFORMATION, _textAttributesKey);
  }
  
  @Override
  public HighlightVisitor clone() {
    SemanticHighlightVisitor _get = this.cloneProvider.get();
    final Procedure1<SemanticHighlightVisitor> _function = new Procedure1<SemanticHighlightVisitor>() {
      @Override
      public void apply(final SemanticHighlightVisitor it) {
        it.acceptor = SemanticHighlightVisitor.this.acceptor;
      }
    };
    return ObjectExtensions.<SemanticHighlightVisitor>operator_doubleArrow(_get, _function);
  }
}

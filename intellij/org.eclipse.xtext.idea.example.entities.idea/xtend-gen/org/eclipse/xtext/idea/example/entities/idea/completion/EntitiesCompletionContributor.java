/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.example.entities.idea.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.template.impl.LiveTemplateLookupElementImpl;
import com.intellij.codeInsight.template.impl.TemplateImpl;
import com.intellij.codeInsight.template.impl.TextExpression;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.eclipse.xtext.idea.example.entities.idea.completion.AbstractEntitiesCompletionContributor;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesElementTypeProvider;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EntitiesCompletionContributor extends AbstractEntitiesCompletionContributor {
  public EntitiesCompletionContributor() {
    super(EntitiesLanguage.INSTANCE);
    PsiElementPattern.Capture<PsiElement> _psiElement = PlatformPatterns.psiElement();
    PsiElementPattern.Capture<PsiElement> _psiElement_1 = PlatformPatterns.psiElement(EntitiesElementTypeProvider.Entity_NameValidIDParserRuleCall_1_0_ELEMENT_TYPE);
    PsiElementPattern.Capture<PsiElement> _withParent = _psiElement.withParent(_psiElement_1);
    final CompletionProvider<CompletionParameters> _function = new CompletionProvider<CompletionParameters>() {
      @Override
      protected void addCompletions(final CompletionParameters parameters, final ProcessingContext context, final CompletionResultSet result) {
        TemplateImpl _templateImpl = new TemplateImpl("entity name", "");
        final Procedure1<TemplateImpl> _function = new Procedure1<TemplateImpl>() {
          @Override
          public void apply(final TemplateImpl it) {
            TextExpression _textExpression = new TextExpression("Name");
            it.addVariable(_textExpression, true);
          }
        };
        final TemplateImpl template = ObjectExtensions.<TemplateImpl>operator_doubleArrow(_templateImpl, _function);
        LiveTemplateLookupElementImpl _liveTemplateLookupElementImpl = new LiveTemplateLookupElementImpl(template, false);
        EntitiesCompletionContributor.this._completionExtensions.operator_add(result, _liveTemplateLookupElementImpl);
      }
    };
    this.extend(
      CompletionType.BASIC, _withParent, _function);
  }
}

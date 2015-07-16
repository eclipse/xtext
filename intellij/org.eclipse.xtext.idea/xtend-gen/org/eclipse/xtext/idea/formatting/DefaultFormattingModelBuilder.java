/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.formatting;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.FormattingModelProvider;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.idea.formatting.DefaultXtextBlock;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultFormattingModelBuilder implements FormattingModelBuilder {
  @Inject
  private Injector injector;
  
  @Inject
  @Extension
  private IGrammarAccess _iGrammarAccess;
  
  @Inject
  @Extension
  private IElementTypeProvider elementTypeProvider;
  
  @Override
  public FormattingModel createModel(final PsiElement element, final CodeStyleSettings settings) {
    FormattingModel _xblockexpression = null;
    {
      ASTNode _node = element.getNode();
      final DefaultXtextBlock rootBlock = new DefaultXtextBlock(_node, null, null);
      this.injector.injectMembers(rootBlock);
      Language _language = element.getLanguage();
      SpacingBuilder _createSpacingBuilder = this.createSpacingBuilder(settings, _language);
      rootBlock.setSpacingBuilder(_createSpacingBuilder);
      PsiFile _containingFile = element.getContainingFile();
      _xblockexpression = FormattingModelProvider.createFormattingModelForPsiFile(_containingFile, rootBlock, settings);
    }
    return _xblockexpression;
  }
  
  public SpacingBuilder createSpacingBuilder(final CodeStyleSettings settings, final Language language) {
    SpacingBuilder _xblockexpression = null;
    {
      final SpacingBuilder spacingBuilder = new SpacingBuilder(settings, language);
      List<Pair<Keyword, Keyword>> _findKeywordPairs = this._iGrammarAccess.findKeywordPairs("{", "}");
      final Function1<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>> _function = new Function1<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>>() {
        @Override
        public org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType> apply(final Pair<Keyword, Keyword> it) {
          Keyword _first = it.getFirst();
          IGrammarAwareElementType _findElementType = DefaultFormattingModelBuilder.this.elementTypeProvider.findElementType(_first);
          Keyword _second = it.getSecond();
          IGrammarAwareElementType _findElementType_1 = DefaultFormattingModelBuilder.this.elementTypeProvider.findElementType(_second);
          return org.eclipse.xtext.xbase.lib.Pair.<IGrammarAwareElementType, IGrammarAwareElementType>of(_findElementType, _findElementType_1);
        }
      };
      List<org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>> _map = ListExtensions.<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>>map(_findKeywordPairs, _function);
      for (final org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType> pair : _map) {
        {
          IGrammarAwareElementType _key = pair.getKey();
          SpacingBuilder.RuleBuilder _before = spacingBuilder.before(_key);
          _before.spaces(1);
          IGrammarAwareElementType _key_1 = pair.getKey();
          IGrammarAwareElementType _value = pair.getValue();
          SpacingBuilder.RuleBuilder _withinPair = spacingBuilder.withinPair(_key_1, _value);
          _withinPair.lineBreakInCode();
        }
      }
      List<Keyword> _findKeywords = this._iGrammarAccess.findKeywords(((String[])Conversions.unwrapArray(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(",")), String.class)));
      final Function1<Keyword, IGrammarAwareElementType> _function_1 = new Function1<Keyword, IGrammarAwareElementType>() {
        @Override
        public IGrammarAwareElementType apply(final Keyword it) {
          return DefaultFormattingModelBuilder.this.elementTypeProvider.findElementType(it);
        }
      };
      List<IGrammarAwareElementType> _map_1 = ListExtensions.<Keyword, IGrammarAwareElementType>map(_findKeywords, _function_1);
      for (final IGrammarAwareElementType commaType : _map_1) {
        {
          SpacingBuilder.RuleBuilder _before = spacingBuilder.before(commaType);
          _before.spaces(0);
          SpacingBuilder.RuleBuilder _after = spacingBuilder.after(commaType);
          _after.spaces(1);
        }
      }
      List<Pair<Keyword, Keyword>> _findKeywordPairs_1 = this._iGrammarAccess.findKeywordPairs("(", ")");
      final Function1<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>> _function_2 = new Function1<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>>() {
        @Override
        public org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType> apply(final Pair<Keyword, Keyword> it) {
          Keyword _first = it.getFirst();
          IGrammarAwareElementType _findElementType = DefaultFormattingModelBuilder.this.elementTypeProvider.findElementType(_first);
          Keyword _second = it.getSecond();
          IGrammarAwareElementType _findElementType_1 = DefaultFormattingModelBuilder.this.elementTypeProvider.findElementType(_second);
          return org.eclipse.xtext.xbase.lib.Pair.<IGrammarAwareElementType, IGrammarAwareElementType>of(_findElementType, _findElementType_1);
        }
      };
      List<org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>> _map_2 = ListExtensions.<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>>map(_findKeywordPairs_1, _function_2);
      for (final org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType> pair_1 : _map_2) {
        {
          IGrammarAwareElementType _key = pair_1.getKey();
          IGrammarAwareElementType _value = pair_1.getValue();
          SpacingBuilder.RuleBuilder _withinPair = spacingBuilder.withinPair(_key, _value);
          _withinPair.none();
          IGrammarAwareElementType _key_1 = pair_1.getKey();
          SpacingBuilder.RuleBuilder _around = spacingBuilder.around(_key_1);
          _around.spaces(0);
          IGrammarAwareElementType _value_1 = pair_1.getValue();
          SpacingBuilder.RuleBuilder _before = spacingBuilder.before(_value_1);
          _before.spaces(0);
          IGrammarAwareElementType _value_2 = pair_1.getValue();
          SpacingBuilder.RuleBuilder _after = spacingBuilder.after(_value_2);
          _after.spaces(1);
        }
      }
      _xblockexpression = spacingBuilder;
    }
    return _xblockexpression;
  }
  
  @Override
  public TextRange getRangeAffectingIndent(final PsiFile file, final int offset, final ASTNode elementAtOffset) {
    return null;
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.completion;

import com.google.inject.Inject;
import com.intellij.codeInsight.template.EverywhereContextType;
import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lexer.Lexer;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.core.idea.editorActions.XtendTokenSetProvider;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.contentassist.IFollowElementAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElementComputer;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class XtendCodeContextType extends TemplateContextType {
  public static class Generic extends XtendCodeContextType {
    public Generic() {
      super("xtend.generic", "Xtend", EverywhereContextType.class);
    }
    
    @Override
    public boolean internalIsInContext(final PsiFile file, final int offset) {
      return true;
    }
  }
  
  public static class Statement extends XtendCodeContextType {
    public Statement() {
      super("xtend.statement", "Statement", XtendCodeContextType.Generic.class);
      TokenSet _defaultTokens = this.tokenSetProvider.getDefaultTokens();
      this.tokenSets.add(_defaultTokens);
      Keyword _valKeyword_0_0_1_0_0_1 = this.grammarAccess.getXVariableDeclarationAccess().getValKeyword_0_0_1_0_0_1();
      this.followElements.add(_valKeyword_0_0_1_0_0_1);
    }
  }
  
  public static class Expression extends XtendCodeContextType {
    public Expression() {
      super("xtend.expression", "Expression", XtendCodeContextType.Statement.class);
      TokenSet _defaultTokens = this.tokenSetProvider.getDefaultTokens();
      this.tokenSets.add(_defaultTokens);
      RuleCall _xFeatureCallParserRuleCall_4 = this.grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4();
      this.followElements.add(_xFeatureCallParserRuleCall_4);
    }
  }
  
  public static class Member extends XtendCodeContextType {
    public Member() {
      super("xtend.member", "Member", XtendCodeContextType.Generic.class);
      TokenSet _defaultTokens = this.tokenSetProvider.getDefaultTokens();
      this.tokenSets.add(_defaultTokens);
      this.registerFollowElementsfor(XtendPackage.Literals.XTEND_TYPE_DECLARATION__MEMBERS);
    }
  }
  
  public static class TemplateExpression extends XtendCodeContextType {
    public TemplateExpression() {
      super("xtend.template", "Template", XtendCodeContextType.Generic.class);
      TokenSet _richStringLiteralTokens = this.tokenSetProvider.getRichStringLiteralTokens();
      this.tokenSets.add(_richStringLiteralTokens);
    }
  }
  
  @Inject
  protected XtendGrammarAccess grammarAccess;
  
  @Inject
  protected IContentAssistParser contentAssistParser;
  
  @Inject
  protected FollowElementComputer followElementComputer;
  
  @Inject
  protected ParserDefinition parserDefinition;
  
  @Inject
  protected XtendTokenSetProvider tokenSetProvider;
  
  protected HashSet<TokenSet> tokenSets = CollectionLiterals.<TokenSet>newHashSet();
  
  protected HashSet<AbstractElement> followElements = CollectionLiterals.<AbstractElement>newHashSet();
  
  protected XtendCodeContextType(final String id, final String presentableName, final Class<? extends TemplateContextType> parent) {
    super(id, presentableName, parent);
    XtendLanguage.INSTANCE.injectMembers(this);
  }
  
  protected void registerFollowElementsfor(final EStructuralFeature eStructuralFeature) {
    final IFollowElementAcceptor _function = (AbstractElement it) -> {
      this.followElements.add(it);
    };
    this.followElementComputer.collectAbstractElements(this.grammarAccess.getGrammar(), eStructuralFeature, _function);
  }
  
  @Override
  public final boolean isInContext(final PsiFile file, final int offset) {
    Language _language = file.getLanguage();
    boolean _tripleNotEquals = (_language != XtendLanguage.INSTANCE);
    if (_tripleNotEquals) {
      return false;
    }
    return this.internalIsInContext(file, offset);
  }
  
  public boolean internalIsInContext(final PsiFile file, final int offset) {
    if ((this.tokenSets.isEmpty() && this.followElements.isEmpty())) {
      return true;
    }
    boolean _isEmpty = this.tokenSets.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Object tokenSet = this.getTokenSet(file, offset);
      boolean _contains = this.tokenSets.contains(tokenSet);
      boolean _not_1 = (!_contains);
      if (_not_1) {
        return false;
      }
      boolean _isEmpty_1 = this.followElements.isEmpty();
      if (_isEmpty_1) {
        return true;
      }
    }
    boolean _isEmpty_2 = this.followElements.isEmpty();
    if (_isEmpty_2) {
      return false;
    }
    final PsiElement element = file.findElementAt(offset);
    ASTNode _node = null;
    if (element!=null) {
      _node=element.getNode();
    }
    boolean _tripleEquals = (_node == null);
    if (_tripleEquals) {
      return false;
    }
    final Collection<FollowElement> elements = this.contentAssistParser.getFollowElements(file.getText().substring(0, element.getNode().getStartOffset()), false);
    final AtomicBoolean hasFollowElement = new AtomicBoolean(false);
    final IFollowElementAcceptor _function = (AbstractElement it) -> {
      if (((!hasFollowElement.get()) && this.followElements.contains(it))) {
        hasFollowElement.set(true);
      }
    };
    this.followElementComputer.computeFollowElements(elements, _function);
    return hasFollowElement.get();
  }
  
  protected Object getTokenSet(final PsiFile file, final int offset) {
    TokenSet _xblockexpression = null;
    {
      final Lexer lexer = this.parserDefinition.createLexer(file.getProject());
      lexer.start(file.getText());
      while (((lexer.getTokenType() != null) && (lexer.getTokenEnd() <= offset))) {
        lexer.advance();
      }
      final IElementType tokenType = lexer.getTokenType();
      if ((tokenType == null)) {
        return Boolean.valueOf(false);
      }
      _xblockexpression = this.tokenSetProvider.getTokenSet(tokenType);
    }
    return _xblockexpression;
  }
  
  @Override
  public String toString() {
    return this.getContextId();
  }
}

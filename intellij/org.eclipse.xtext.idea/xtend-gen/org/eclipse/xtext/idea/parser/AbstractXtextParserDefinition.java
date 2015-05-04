/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.parser;

import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.lang.LanguageUtil;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import javax.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.impl.PsiEObjectReference;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.xbase.lib.Pure;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public abstract class AbstractXtextParserDefinition implements ParserDefinition {
  @Inject
  private Provider<Lexer> lexerProvider;
  
  @Inject
  private TokenTypeProvider tokenTypeProvider;
  
  @Inject
  private Provider<PsiParser> psiParserProvider;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private IElementTypeProvider elementTypeProvider;
  
  @NotNull
  @Override
  public Lexer createLexer(final Project project) {
    return this.lexerProvider.get();
  }
  
  @Override
  public IFileElementType getFileNodeType() {
    return this.elementTypeProvider.getFileType();
  }
  
  @NotNull
  @Override
  public TokenSet getWhitespaceTokens() {
    return TokenSet.EMPTY;
  }
  
  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return TokenSet.EMPTY;
  }
  
  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return this.tokenTypeProvider.getStringLiteralTokens();
  }
  
  @NotNull
  @Override
  public PsiParser createParser(final Project project) {
    return this.psiParserProvider.get();
  }
  
  @Override
  public ParserDefinition.SpaceRequirements spaceExistanceTypeBetweenTokens(final ASTNode left, final ASTNode right) {
    Lexer _get = this.lexerProvider.get();
    return LanguageUtil.canStickTokensTogetherByLexer(left, right, _get);
  }
  
  @Override
  public PsiElement createElement(final ASTNode node) {
    PsiEObjectImpl<PsiElement, StubElement<PsiElement>> _xblockexpression = null;
    {
      IElementType _elementType = node.getElementType();
      boolean _isCrossReference = this.isCrossReference(_elementType);
      if (_isCrossReference) {
        return new PsiEObjectReference<PsiElement, StubElement<PsiElement>>(node);
      }
      _xblockexpression = new PsiEObjectImpl<PsiElement, StubElement<PsiElement>>(node);
    }
    return _xblockexpression;
  }
  
  protected boolean isCrossReference(final IElementType type) {
    boolean _xifexpression = false;
    if ((type instanceof IGrammarAwareElementType)) {
      EObject _grammarElement = ((IGrammarAwareElementType)type).getGrammarElement();
      _xifexpression = (_grammarElement instanceof CrossReference);
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  @Pure
  protected IElementTypeProvider getElementTypeProvider() {
    return this.elementTypeProvider;
  }
}

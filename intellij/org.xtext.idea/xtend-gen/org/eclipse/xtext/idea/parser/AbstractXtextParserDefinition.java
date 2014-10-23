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
  public Lexer createLexer(final Project project) {
    return this.lexerProvider.get();
  }
  
  public IFileElementType getFileNodeType() {
    return this.elementTypeProvider.getFileType();
  }
  
  @NotNull
  public TokenSet getWhitespaceTokens() {
    return TokenSet.EMPTY;
  }
  
  @NotNull
  public TokenSet getCommentTokens() {
    return TokenSet.EMPTY;
  }
  
  @NotNull
  public TokenSet getStringLiteralElements() {
    return this.tokenTypeProvider.getStringLiteralTokens();
  }
  
  @NotNull
  public PsiParser createParser(final Project project) {
    return this.psiParserProvider.get();
  }
  
  public ParserDefinition.SpaceRequirements spaceExistanceTypeBetweenTokens(final ASTNode left, final ASTNode right) {
    Lexer _get = this.lexerProvider.get();
    return LanguageUtil.canStickTokensTogetherByLexer(left, right, _get);
  }
  
  public PsiElement createElement(final ASTNode node) {
    PsiEObjectImpl<StubElement> _xifexpression = null;
    IElementType _elementType = node.getElementType();
    boolean _isCrossReference = this.isCrossReference(_elementType);
    if (_isCrossReference) {
      _xifexpression = new PsiEObjectReference<StubElement>(node);
    } else {
      _xifexpression = new PsiEObjectImpl<StubElement>(node);
    }
    return _xifexpression;
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

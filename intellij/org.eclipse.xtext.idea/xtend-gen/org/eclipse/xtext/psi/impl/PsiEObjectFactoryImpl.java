package org.eclipse.xtext.psi.impl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilderFactory;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.TokenType;
import com.intellij.psi.impl.source.DummyHolder;
import com.intellij.psi.impl.source.DummyHolderFactory;
import com.intellij.psi.impl.source.codeStyle.CodeEditUtil;
import com.intellij.psi.impl.source.tree.FileElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.RecursiveTreeElementVisitor;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import java.util.Map;
import java.util.regex.Pattern;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.TokenSourceProvider;
import org.eclipse.xtext.parser.antlr.TokenTool;
import org.eclipse.xtext.psi.PsiEObjectFactory;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@SuppressWarnings("all")
public class PsiEObjectFactoryImpl implements PsiEObjectFactory {
  @Inject
  @Extension
  private ParserDefinition parserDefinition;
  
  @Inject
  @Extension
  private ITokenDefProvider tokenDefProvider;
  
  @Inject
  @Extension
  private TokenSourceProvider tokenSourceProvider;
  
  @Override
  public ASTNode createLeafIdentifier(final String name, final ASTNode context) {
    LeafElement _xblockexpression = null;
    {
      IElementType _elementType = context.getElementType();
      this.assertToken(name, ((IGrammarAwareElementType) _elementType));
      IElementType _elementType_1 = context.getElementType();
      LeafElement _leaf = ASTFactory.leaf(_elementType_1, name);
      final Procedure1<LeafElement> _function = new Procedure1<LeafElement>() {
        @Override
        public void apply(final LeafElement it) {
          CodeEditUtil.setNodeGenerated(it, true);
        }
      };
      _xblockexpression = ObjectExtensions.<LeafElement>operator_doubleArrow(_leaf, _function);
    }
    return _xblockexpression;
  }
  
  @Override
  public ASTNode createCompositeIdentifier(final String name, final String currentName, @Extension final ASTNode context) {
    FileElement _xblockexpression = null;
    {
      final PsiBuilder builder = this.createNameBuilder(name, currentName, context);
      PsiElement _psi = context.getPsi();
      Project _project = _psi.getProject();
      PsiParser _createParser = this.parserDefinition.createParser(_project);
      IElementType _elementType = context.getElementType();
      ASTNode _parse = _createParser.parse(_elementType, builder);
      final Procedure1<TreeElement> _function = new Procedure1<TreeElement>() {
        @Override
        public void apply(final TreeElement it) {
          PsiEObjectFactoryImpl.this.assertNode(it);
          CodeEditUtil.setNodeGeneratedRecursively(it, true);
        }
      };
      final TreeElement contentElement = ObjectExtensions.<TreeElement>operator_doubleArrow(((TreeElement) _parse), _function);
      PsiElement _psi_1 = context.getPsi();
      PsiManager _manager = _psi_1.getManager();
      PsiElement _psi_2 = context.getPsi();
      PsiElement _context = _psi_2.getContext();
      DummyHolder _createHolder = DummyHolderFactory.createHolder(_manager, contentElement, _context);
      _xblockexpression = _createHolder.getTreeElement();
    }
    return _xblockexpression;
  }
  
  protected PsiBuilder createNameBuilder(final String name, final String currentName, final ASTNode context) {
    PsiBuilder _xblockexpression = null;
    {
      String _text = context.getText();
      String _quote = Pattern.quote(currentName);
      final String text = _text.replaceFirst(_quote, name);
      PsiBuilderFactory _instance = PsiBuilderFactory.getInstance();
      PsiElement _psi = context.getPsi();
      Project _project = _psi.getProject();
      Lexer _createLexer = this.parserDefinition.createLexer(_project);
      PsiBuilder _createBuilder = _instance.createBuilder(this.parserDefinition, _createLexer, text);
      final Procedure1<PsiBuilder> _function = new Procedure1<PsiBuilder>() {
        @Override
        public void apply(final PsiBuilder it) {
          Integer _userData = context.<Integer>getUserData(IASTNodeAwareNodeModelBuilder.LOOK_AHEAD_KEY);
          it.<Integer>putUserData(IASTNodeAwareNodeModelBuilder.LOOK_AHEAD_KEY, _userData);
        }
      };
      _xblockexpression = ObjectExtensions.<PsiBuilder>operator_doubleArrow(_createBuilder, _function);
    }
    return _xblockexpression;
  }
  
  protected void assertNode(final TreeElement treeElement) {
    final Function1<TreeElement, Boolean> _function = new Function1<TreeElement, Boolean>() {
      @Override
      public Boolean apply(final TreeElement element) {
        boolean _xblockexpression = false;
        {
          IElementType _elementType = element.getElementType();
          boolean _equals = Objects.equal(_elementType, TokenType.ERROR_ELEMENT);
          if (_equals) {
            final PsiErrorElement errorElement = ((PsiErrorElement) element);
            String _errorDescription = errorElement.getErrorDescription();
            throw new IncorrectOperationException(_errorDescription);
          }
          _xblockexpression = true;
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    treeElement.acceptTree(((RecursiveTreeElementVisitor) new RecursiveTreeElementVisitor() {
        public boolean visitNode(TreeElement element) {
          return _function.apply(element);
        }
    }));
  }
  
  protected void assertToken(final String name, final IGrammarAwareElementType elementType) {
    EObject _grammarElement = elementType.getGrammarElement();
    final RuleCall ruleCall = ((RuleCall) _grammarElement);
    AbstractRule _rule = ruleCall.getRule();
    final String ruleName = _rule.getName();
    final TokenSource tokenSource = this.tokenSourceProvider.createTokenSource(name);
    Token token = tokenSource.nextToken();
    String _text = token.getText();
    boolean _notEquals = (!Objects.equal(name, _text));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("The value \'");
      _builder.append(name, "");
      _builder.append("\' is an invalid ");
      _builder.append(ruleName, "");
      throw new IncorrectOperationException(_builder.toString());
    }
    Map<Integer, String> _tokenDefMap = this.tokenDefProvider.getTokenDefMap();
    int _type = token.getType();
    String _get = _tokenDefMap.get(Integer.valueOf(_type));
    final String lexerRuleName = TokenTool.getLexerRuleName(_get);
    boolean _notEquals_1 = (!Objects.equal(ruleName, lexerRuleName));
    if (_notEquals_1) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("The value \'");
      _builder_1.append(name, "");
      _builder_1.append("\' is an invalid ");
      _builder_1.append(ruleName, "");
      throw new IncorrectOperationException(_builder_1.toString());
    }
  }
}

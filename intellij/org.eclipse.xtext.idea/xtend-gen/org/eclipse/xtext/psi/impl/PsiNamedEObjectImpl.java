package org.eclipse.xtext.psi.impl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
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
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.impl.PsiManagerEx;
import com.intellij.psi.impl.source.DummyHolder;
import com.intellij.psi.impl.source.DummyHolderFactory;
import com.intellij.psi.impl.source.codeStyle.CodeEditUtil;
import com.intellij.psi.impl.source.tree.FileElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.RecursiveTreeElementVisitor;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import java.util.Map;
import java.util.regex.Pattern;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.TokenSourceProvider;
import org.eclipse.xtext.parser.antlr.TokenTool;
import org.eclipse.xtext.psi.PsiEObjectIdentifier;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.impl.PsiEObjectIdentifierImpl;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PsiNamedEObjectImpl<T extends PsiNamedEObjectStub<?>> extends PsiEObjectImpl<T> implements PsiNamedEObject {
  @Inject
  @Extension
  private ITokenDefProvider tokenDefProvider;
  
  @Inject
  @Extension
  private ParserDefinition parserDefinition;
  
  @Inject
  @Extension
  private TokenSourceProvider tokenSourceProvider;
  
  @Inject
  @Extension
  private ILocationInFileProvider locationInFileProvider;
  
  private final IGrammarAwareElementType nameType;
  
  public PsiNamedEObjectImpl(final T stub, final IStubElementType<?, ?> nodeType, final IGrammarAwareElementType nameType) {
    super(stub, nodeType);
    this.nameType = nameType;
  }
  
  public PsiNamedEObjectImpl(final ASTNode node, final IGrammarAwareElementType nameType) {
    super(node);
    this.nameType = nameType;
  }
  
  public PsiEObjectIdentifier getNameIdentifier() {
    PsiEObjectIdentifierImpl _xblockexpression = null;
    {
      final ASTNode nameNode = this.findNameNode();
      boolean _equals = Objects.equal(nameNode, null);
      if (_equals) {
        return null;
      }
      PsiElement _psi = nameNode.getPsi();
      _xblockexpression = new PsiEObjectIdentifierImpl(_psi);
    }
    return _xblockexpression;
  }
  
  public String getName() {
    String _xblockexpression = null;
    {
      final T stub = this.getStub();
      boolean _notEquals = (!Objects.equal(stub, null));
      if (_notEquals) {
        return stub.getName();
      }
      final ITextRegion significantTextRegion = this.getSignificantTextRegion();
      final int startIndex = significantTextRegion.getOffset();
      int _length = significantTextRegion.getLength();
      final int endIndex = (startIndex + _length);
      PsiFile _containingFile = this.getContainingFile();
      String _text = _containingFile.getText();
      _xblockexpression = _text.substring(startIndex, endIndex);
    }
    return _xblockexpression;
  }
  
  public int getTextOffset() {
    ITextRegion _significantTextRegion = this.getSignificantTextRegion();
    return _significantTextRegion.getOffset();
  }
  
  public PsiNamedEObject setName(final String name) throws IncorrectOperationException {
    PsiNamedEObjectImpl<T> _xblockexpression = null;
    {
      final ASTNode nameNode = this.findNameNode();
      EObject _grammarElement = this.nameType.getGrammarElement();
      boolean _isTerminalRuleCall = GrammarUtil.isTerminalRuleCall(_grammarElement);
      if (_isTerminalRuleCall) {
        final LeafElement newNameNode = this.createLeaf(name);
        ASTNode _treeParent = nameNode.getTreeParent();
        _treeParent.replaceChild(nameNode, newNameNode);
      } else {
        FileElement _parseName = this.parseName(name);
        final TreeElement newNameNode_1 = _parseName.getFirstChildNode();
        nameNode.replaceAllChildrenToChildrenOf(newNameNode_1);
      }
      _xblockexpression = this;
    }
    return _xblockexpression;
  }
  
  protected LeafElement createLeaf(final String name) {
    LeafElement _xblockexpression = null;
    {
      this.assertToken(name);
      LeafElement _leaf = ASTFactory.leaf(this.nameType, name);
      final Procedure1<LeafElement> _function = new Procedure1<LeafElement>() {
        public void apply(final LeafElement it) {
          CodeEditUtil.setNodeGenerated(it, true);
        }
      };
      _xblockexpression = ObjectExtensions.<LeafElement>operator_doubleArrow(_leaf, _function);
    }
    return _xblockexpression;
  }
  
  protected FileElement parseName(final String name) {
    FileElement _xblockexpression = null;
    {
      final PsiBuilder builder = this.createNameBuilder(name);
      Project _project = this.getProject();
      PsiParser _createParser = this.parserDefinition.createParser(_project);
      ASTNode _parse = _createParser.parse(this.nameType, builder);
      final Procedure1<TreeElement> _function = new Procedure1<TreeElement>() {
        public void apply(final TreeElement it) {
          PsiNamedEObjectImpl.this.assertNode(it);
          CodeEditUtil.setNodeGeneratedRecursively(it, true);
        }
      };
      final TreeElement contentElement = ObjectExtensions.<TreeElement>operator_doubleArrow(((TreeElement) _parse), _function);
      PsiManagerEx _manager = this.getManager();
      PsiElement _context = this.getContext();
      DummyHolder _createHolder = DummyHolderFactory.createHolder(_manager, contentElement, _context);
      _xblockexpression = _createHolder.getTreeElement();
    }
    return _xblockexpression;
  }
  
  protected PsiBuilder createNameBuilder(final String name) {
    PsiBuilder _xblockexpression = null;
    {
      final ASTNode nameNode = this.findNameNode();
      String _text = nameNode.getText();
      String _name = this.getName();
      String _quote = Pattern.quote(_name);
      final String text = _text.replaceFirst(_quote, name);
      PsiBuilderFactory _instance = PsiBuilderFactory.getInstance();
      Project _project = this.getProject();
      Lexer _createLexer = this.parserDefinition.createLexer(_project);
      PsiBuilder _createBuilder = _instance.createBuilder(this.parserDefinition, _createLexer, text);
      final Procedure1<PsiBuilder> _function = new Procedure1<PsiBuilder>() {
        public void apply(final PsiBuilder it) {
          Integer _userData = nameNode.<Integer>getUserData(IASTNodeAwareNodeModelBuilder.LOOK_AHEAD_KEY);
          it.<Integer>putUserData(IASTNodeAwareNodeModelBuilder.LOOK_AHEAD_KEY, _userData);
        }
      };
      _xblockexpression = ObjectExtensions.<PsiBuilder>operator_doubleArrow(_createBuilder, _function);
    }
    return _xblockexpression;
  }
  
  /**
   * @param treeElement
   */
  protected void assertNode(final TreeElement treeElement) {
    final Function1<TreeElement, Boolean> _function = new Function1<TreeElement, Boolean>() {
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
  
  /**
   * @param name
   */
  protected void assertToken(final String name) {
    EObject _grammarElement = this.nameType.getGrammarElement();
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
      String _string = _builder.toString();
      throw new IncorrectOperationException(_string);
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
      String _string_1 = _builder_1.toString();
      throw new IncorrectOperationException(_string_1);
    }
  }
  
  /**
   * @return
   */
  protected ASTNode findNameNode() {
    ASTNode _node = this.getNode();
    return _node.findChildByType(this.nameType);
  }
  
  /**
   * @return
   */
  protected ITextRegion getSignificantTextRegion() {
    EObject _eObject = this.getEObject();
    return this.locationInFileProvider.getSignificantTextRegion(_eObject);
  }
}

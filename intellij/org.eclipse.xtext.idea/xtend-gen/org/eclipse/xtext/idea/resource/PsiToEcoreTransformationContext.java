package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.idea.resource.ParserErrorContext;
import org.eclipse.xtext.idea.resource.ValueConverterErrorContext;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider;
import org.eclipse.xtext.parser.impl.DatatypeRuleToken;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.psi.PsiElementProvider;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class PsiToEcoreTransformationContext {
  public static class PsiToEcoreTransformationContextProvider {
    @Inject
    private Provider<IASTNodeAwareNodeModelBuilder> astNodeModelBuilderProvider;
    
    @Inject
    private Provider<PsiToEcoreTransformationContext> psiToEcoreTransformationContextProvider;
    
    public PsiToEcoreTransformationContext newTransformationContext(final BaseXtextFile xtextFile) {
      PsiToEcoreTransformationContext _xblockexpression = null;
      {
        final PsiToEcoreTransformationContext context = this.psiToEcoreTransformationContextProvider.get();
        IASTNodeAwareNodeModelBuilder _get = this.astNodeModelBuilderProvider.get();
        context.nodeModelBuilder = _get;
        context.newRootNode(xtextFile);
        _xblockexpression = context;
      }
      return _xblockexpression;
    }
  }
  
  @Inject
  private IAstFactory semanticModelBuilder;
  
  @Inject
  private IPsiModelAssociator psiModelAssociator;
  
  @Inject
  private ISyntaxErrorMessageProvider syntaxErrorProvider;
  
  @Inject
  private Provider<PsiToEcoreTransformationContext> psiToEcoreTransformationContextProvider;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private BaseXtextFile xtextFile;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private boolean hadErrors;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private EObject current;
  
  @Accessors
  private RuleCall actionRuleCall;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private DatatypeRuleToken datatypeRuleToken;
  
  private INode lastConsumedNode;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ICompositeNode currentNode;
  
  @Extension
  private IASTNodeAwareNodeModelBuilder nodeModelBuilder;
  
  public Map<ASTNode, INode> getNodesMapping() {
    return this.nodeModelBuilder.getNodesMapping();
  }
  
  public Map<INode, List<ASTNode>> getReverseNodesMapping() {
    return this.nodeModelBuilder.getReverseNodesMapping();
  }
  
  public PsiToEcoreTransformationContext branch() {
    PsiToEcoreTransformationContext _xblockexpression = null;
    {
      final PsiToEcoreTransformationContext childTransformationContext = this.psiToEcoreTransformationContextProvider.get();
      childTransformationContext.currentNode = this.currentNode;
      childTransformationContext.lastConsumedNode = this.lastConsumedNode;
      childTransformationContext.nodeModelBuilder = this.nodeModelBuilder;
      _xblockexpression = childTransformationContext;
    }
    return _xblockexpression;
  }
  
  public PsiToEcoreTransformationContext withDatatypeRule() {
    PsiToEcoreTransformationContext _xblockexpression = null;
    {
      AntlrDatatypeRuleToken _antlrDatatypeRuleToken = new AntlrDatatypeRuleToken();
      this.datatypeRuleToken = _antlrDatatypeRuleToken;
      _xblockexpression = this;
    }
    return _xblockexpression;
  }
  
  public PsiToEcoreTransformationContext sync(final PsiToEcoreTransformationContext childTransformationContext) {
    PsiToEcoreTransformationContext _xblockexpression = null;
    {
      this.currentNode = childTransformationContext.currentNode;
      this.lastConsumedNode = childTransformationContext.lastConsumedNode;
      if (childTransformationContext.hadErrors) {
        this.hadErrors = true;
      }
      _xblockexpression = this;
    }
    return _xblockexpression;
  }
  
  public PsiToEcoreTransformationContext merge(final PsiToEcoreTransformationContext childTransformationContext) {
    PsiToEcoreTransformationContext _xblockexpression = null;
    {
      boolean _equals = Objects.equal(this.current, null);
      if (_equals) {
        this.current = childTransformationContext.current;
      }
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(this.datatypeRuleToken, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _notEquals_1 = (!Objects.equal(childTransformationContext.datatypeRuleToken, null));
        _and = _notEquals_1;
      }
      if (_and) {
        this.datatypeRuleToken.merge(childTransformationContext.datatypeRuleToken);
      }
      _xblockexpression = this;
    }
    return _xblockexpression;
  }
  
  public PsiToEcoreTransformationContext compress() {
    PsiToEcoreTransformationContext _xblockexpression = null;
    {
      final ICompositeNode newCurrentNode = this.nodeModelBuilder.compressAndReturnParent(this.currentNode);
      boolean _equals = Objects.equal(this.currentNode, this.lastConsumedNode);
      if (_equals) {
        this.lastConsumedNode = newCurrentNode;
      }
      this.currentNode = newCurrentNode;
      _xblockexpression = this;
    }
    return _xblockexpression;
  }
  
  public void newLeafNode(final LeafElement it, final EObject grammarElement, final String ruleName) {
    ILeafNode _newLeafNode = this.nodeModelBuilder.newLeafNode(it, grammarElement, this.currentNode);
    this.lastConsumedNode = _newLeafNode;
    this.mergeDatatypeRuleToken(it);
    boolean _ensureModelElementCreated = this.ensureModelElementCreated(grammarElement);
    if (_ensureModelElementCreated) {
      final Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
      boolean _isBooleanAssignment = GrammarUtil.isBooleanAssignment(assignment);
      if (_isBooleanAssignment) {
        this.assign(Boolean.valueOf(true), grammarElement, ruleName);
      } else {
        String _text = it.getText();
        this.assign(_text, grammarElement, ruleName);
      }
    }
  }
  
  public void newLeafNode(final ASTNode it) {
    this.nodeModelBuilder.newLeafNode(it, this.currentNode);
  }
  
  public void newCompositeNode(final CompositeElement it) {
    ICompositeNode _newCompositeNode = this.nodeModelBuilder.newCompositeNode(it, this.currentNode);
    this.currentNode = _newCompositeNode;
  }
  
  public boolean ensureModelElementCreated(final EObject grammarElement) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(grammarElement, null);
      if (_equals) {
        return false;
      }
      if ((grammarElement instanceof Action)) {
        TypeRef _type = ((Action)grammarElement).getType();
        EClassifier _classifier = _type.getClassifier();
        EObject _create = this.semanticModelBuilder.create(_classifier);
        this.current = _create;
        this.associateWithSemanticElement(this.currentNode);
        return true;
      }
      boolean _isAssigned = GrammarUtil.isAssigned(grammarElement);
      boolean _not = (!_isAssigned);
      if (_not) {
        return false;
      }
      boolean _notEquals = (!Objects.equal(this.current, null));
      if (_notEquals) {
        return true;
      }
      ParserRule _containingParserRule = GrammarUtil.containingParserRule(grammarElement);
      TypeRef _type_1 = _containingParserRule.getType();
      final EClassifier classifier = _type_1.getClassifier();
      EObject _create_1 = this.semanticModelBuilder.create(classifier);
      this.current = _create_1;
      ICompositeNode _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        boolean _isTerminalRuleCall = GrammarUtil.isTerminalRuleCall(grammarElement);
        if (_isTerminalRuleCall) {
          _matched=true;
        }
        if (!_matched) {
          if ((grammarElement instanceof Keyword)) {
            _matched=true;
          }
        }
        if (!_matched) {
          if (grammarElement instanceof CrossReference) {
            AbstractElement _terminal = ((CrossReference)grammarElement).getTerminal();
            boolean _isTerminalRuleCall_1 = GrammarUtil.isTerminalRuleCall(_terminal);
            if (_isTerminalRuleCall_1) {
              _matched=true;
            }
          }
        }
        if (!_matched) {
          if (grammarElement instanceof CrossReference) {
            AbstractElement _terminal = ((CrossReference)grammarElement).getTerminal();
            if ((_terminal instanceof Keyword)) {
              _matched=true;
            }
          }
        }
        if (_matched) {
          _switchResult = this.currentNode;
        }
      }
      if (!_matched) {
        _switchResult = this.currentNode.getParent();
      }
      this.associateWithSemanticElement(_switchResult);
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  protected void mergeDatatypeRuleToken(final LeafElement it) {
    boolean _notEquals = (!Objects.equal(this.datatypeRuleToken, null));
    if (_notEquals) {
      AntlrDatatypeRuleToken _antlrDatatypeRuleToken = new AntlrDatatypeRuleToken();
      final Procedure1<AntlrDatatypeRuleToken> _function = new Procedure1<AntlrDatatypeRuleToken>() {
        @Override
        public void apply(final AntlrDatatypeRuleToken token) {
          String _text = it.getText();
          token.setText(_text);
          int _startOffset = it.getStartOffset();
          token.setStartOffset(_startOffset);
        }
      };
      AntlrDatatypeRuleToken _doubleArrow = ObjectExtensions.<AntlrDatatypeRuleToken>operator_doubleArrow(_antlrDatatypeRuleToken, _function);
      this.datatypeRuleToken.merge(_doubleArrow);
    }
  }
  
  public ICompositeNode assign(final EObject value, final Action action) {
    ICompositeNode _xifexpression = null;
    String _feature = action.getFeature();
    boolean _notEquals = (!Objects.equal(_feature, null));
    if (_notEquals) {
      String _operator = action.getOperator();
      String _feature_1 = action.getFeature();
      _xifexpression = this.assign(this.current, _operator, _feature_1, value, null, this.currentNode);
    }
    return _xifexpression;
  }
  
  public void assign(final Object value, final EObject grammarElement, final String ruleName) {
    this.assign(this.current, value, grammarElement, ruleName);
  }
  
  protected void assign(final EObject parent, final Object value, final EObject grammarElement, final String ruleName) {
    boolean _isAssigned = GrammarUtil.isAssigned(grammarElement);
    if (_isAssigned) {
      INode _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (grammarElement instanceof RuleCall) {
          boolean _or = false;
          AbstractRule _rule = ((RuleCall)grammarElement).getRule();
          if ((_rule instanceof EnumRule)) {
            _or = true;
          } else {
            AbstractRule _rule_1 = ((RuleCall)grammarElement).getRule();
            _or = (_rule_1 instanceof ParserRule);
          }
          if (_or) {
            _matched=true;
            _switchResult = this.currentNode;
          }
        }
      }
      if (!_matched) {
        _switchResult = this.lastConsumedNode;
      }
      final INode node = _switchResult;
      Assignment _containingAssignment = GrammarUtil.containingAssignment(grammarElement);
      this.assign(parent, _containingAssignment, value, ruleName, node);
    }
  }
  
  protected boolean associateWithSemanticElement(final ICompositeNode node) {
    boolean _xblockexpression = false;
    {
      this.nodeModelBuilder.associateWithSemanticElement(node, this.current);
      Map<INode, List<ASTNode>> _reverseNodesMapping = this.getReverseNodesMapping();
      List<ASTNode> _get = _reverseNodesMapping.get(node);
      ASTNode _last = null;
      if (_get!=null) {
        _last=IterableExtensions.<ASTNode>last(_get);
      }
      final ASTNode astNode = _last;
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(astNode, null));
      if (_notEquals) {
        final PsiElementProvider _function = new PsiElementProvider() {
          @Override
          public PsiElement get() {
            return astNode.getPsi();
          }
        };
        _xifexpression = this.psiModelAssociator.associate(this.current, _function);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected ICompositeNode assign(final EObject parent, final Assignment assignment, final Object value, final String ruleName, final INode node) {
    String _operator = assignment.getOperator();
    String _feature = assignment.getFeature();
    return this.assign(parent, _operator, _feature, value, ruleName, node);
  }
  
  protected ICompositeNode assign(final EObject parent, final String operator, final String feature, final Object value, final String ruleName, final INode node) {
    ICompositeNode _xtrycatchfinallyexpression = null;
    try {
      boolean _equals = Objects.equal(operator, "+=");
      if (_equals) {
        this.semanticModelBuilder.add(parent, feature, value, ruleName, node);
      } else {
        this.semanticModelBuilder.set(parent, feature, value, ruleName, node);
      }
    } catch (final Throwable _t) {
      if (_t instanceof ValueConverterException) {
        final ValueConverterException vce = (ValueConverterException)_t;
        _xtrycatchfinallyexpression = this.handleValueConverterException(vce);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public void appendSyntaxError(final PsiErrorElement errorElement) {
    this.hadErrors = true;
    final ISyntaxErrorMessageProvider.IParserErrorContext errorContext = this.createErrorContext(errorElement);
    final SyntaxErrorMessage error = this.syntaxErrorProvider.getSyntaxErrorMessage(errorContext);
    INode _lastLeafNode = this.getLastLeafNode();
    this.appendError(_lastLeafNode, error);
  }
  
  protected INode getLastLeafNode() {
    INode _xblockexpression = null;
    {
      BidiTreeIterable<INode> _asTreeIterable = this.currentNode.getAsTreeIterable();
      BidiTreeIterator<INode> iter = _asTreeIterable.iterator();
      while (iter.hasPrevious()) {
        {
          INode previous = iter.previous();
          if ((previous instanceof ILeafNode)) {
            return previous;
          }
        }
      }
      INode _xifexpression = null;
      if ((this.currentNode instanceof RootNode)) {
        _xifexpression = ((RootNode)this.currentNode).getFirstChild();
      } else {
        _xifexpression = this.currentNode;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected ISyntaxErrorMessageProvider.IParserErrorContext createErrorContext(final PsiErrorElement errorElement) {
    return new ParserErrorContext(this, errorElement);
  }
  
  protected ISyntaxErrorMessageProvider.IValueConverterErrorContext createValueConverterErrorContext(final ValueConverterException vce) {
    return new ValueConverterErrorContext(this, vce);
  }
  
  protected ICompositeNode handleValueConverterException(final ValueConverterException vce) {
    ICompositeNode _xblockexpression = null;
    {
      this.hadErrors = true;
      Throwable _cause = vce.getCause();
      final Exception cause = ((Exception) _cause);
      ICompositeNode _xifexpression = null;
      boolean _notEquals = (!Objects.equal(vce, cause));
      if (_notEquals) {
        ICompositeNode _xblockexpression_1 = null;
        {
          final ISyntaxErrorMessageProvider.IValueConverterErrorContext errorContext = this.createValueConverterErrorContext(vce);
          final SyntaxErrorMessage error = this.syntaxErrorProvider.getSyntaxErrorMessage(errorContext);
          INode _elvis = null;
          INode _node = vce.getNode();
          if (_node != null) {
            _elvis = _node;
          } else {
            INode _lastChild = this.currentNode.getLastChild();
            _elvis = _lastChild;
          }
          final INode node = _elvis;
          _xblockexpression_1 = this.appendError(node, error);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        throw new RuntimeException(vce);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected ICompositeNode appendError(final INode node, final SyntaxErrorMessage error) {
    ICompositeNode _xifexpression = null;
    SyntaxErrorMessage _syntaxErrorMessage = node.getSyntaxErrorMessage();
    boolean _equals = Objects.equal(_syntaxErrorMessage, null);
    if (_equals) {
      ICompositeNode _xblockexpression = null;
      {
        final INode newNode = this.nodeModelBuilder.setSyntaxError(node, error);
        ICompositeNode _xifexpression_1 = null;
        boolean _equals_1 = Objects.equal(node, this.currentNode);
        if (_equals_1) {
          _xifexpression_1 = this.currentNode = ((ICompositeNode) newNode);
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected ICompositeNode newRootNode(final BaseXtextFile xtextFile) {
    ICompositeNode _xblockexpression = null;
    {
      this.hadErrors = false;
      this.xtextFile = xtextFile;
      String _text = xtextFile.getText();
      ICompositeNode _newRootNode = this.nodeModelBuilder.newRootNode(_text);
      _xblockexpression = this.currentNode = _newRootNode;
    }
    return _xblockexpression;
  }
  
  @Pure
  public BaseXtextFile getXtextFile() {
    return this.xtextFile;
  }
  
  @Pure
  public boolean isHadErrors() {
    return this.hadErrors;
  }
  
  @Pure
  public EObject getCurrent() {
    return this.current;
  }
  
  @Pure
  public RuleCall getActionRuleCall() {
    return this.actionRuleCall;
  }
  
  public void setActionRuleCall(final RuleCall actionRuleCall) {
    this.actionRuleCall = actionRuleCall;
  }
  
  @Pure
  public DatatypeRuleToken getDatatypeRuleToken() {
    return this.datatypeRuleToken;
  }
  
  @Pure
  public ICompositeNode getCurrentNode() {
    return this.currentNode;
  }
}

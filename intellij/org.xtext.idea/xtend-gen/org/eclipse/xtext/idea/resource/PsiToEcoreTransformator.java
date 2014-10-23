package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.lang.FileASTNode;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;
import java.io.Reader;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformationContext;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parser.impl.DatatypeRuleToken;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class PsiToEcoreTransformator implements IParser {
  @Accessors(AccessorType.PUBLIC_SETTER)
  private BaseXtextFile xtextFile;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private PsiToEcoreAdapter adapter;
  
  @Inject
  @Extension
  private PsiToEcoreTransformationContext.PsiToEcoreTransformationContextProvider _psiToEcoreTransformationContextProvider;
  
  public IParseResult parse(final Reader reader) {
    ParseResult _xblockexpression = null;
    {
      final PsiToEcoreTransformationContext transformationContext = this.transform();
      PsiToEcoreAdapter _psiToEcoreAdapter = new PsiToEcoreAdapter(transformationContext);
      this.adapter = _psiToEcoreAdapter;
      final EObject rootAstElement = transformationContext.getCurrent();
      final ICompositeNode rootNode = transformationContext.getCurrentNode();
      final boolean hadErrors = transformationContext.isHadErrors();
      _xblockexpression = new ParseResult(rootAstElement, rootNode, hadErrors);
    }
    return _xblockexpression;
  }
  
  protected PsiToEcoreTransformationContext transform() {
    PsiToEcoreTransformationContext _xblockexpression = null;
    {
      final PsiToEcoreTransformationContext transformationContext = this._psiToEcoreTransformationContextProvider.newTransformationContext(this.xtextFile);
      FileASTNode _node = this.xtextFile.getNode();
      ASTNode[] _children = _node.getChildren(null);
      for (final ASTNode child : _children) {
        this.transform(child, transformationContext);
      }
      _xblockexpression = transformationContext;
    }
    return _xblockexpression;
  }
  
  protected void _transform(final ASTNode it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    throw new IllegalStateException(("Unexpected ast node: " + it));
  }
  
  protected void _transform(final LeafElement it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    final IElementType elementType = it.getElementType();
    if ((elementType instanceof IGrammarAwareElementType)) {
      EObject _grammarElement = ((IGrammarAwareElementType)elementType).getGrammarElement();
      this.transform(it, _grammarElement, transformationContext);
    } else {
      transformationContext.newLeafNode(it);
    }
  }
  
  protected void _transform(final CompositeElement it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    if ((it instanceof PsiErrorElement)) {
      this.transformChildren(it, transformationContext);
      transformationContext.appendSyntaxError(((PsiErrorElement)it));
    } else {
      final IElementType elementType = it.getElementType();
      if ((elementType instanceof IGrammarAwareElementType)) {
        EObject _grammarElement = ((IGrammarAwareElementType)elementType).getGrammarElement();
        this.transform(it, _grammarElement, transformationContext);
      }
    }
  }
  
  protected void _transform(final ASTNode it, final EObject grammarElement, @Extension final PsiToEcoreTransformationContext transformationContext) {
    throw new IllegalStateException(((("Unexpected grammar element: " + grammarElement) + ", for node: ") + it));
  }
  
  protected void _transform(final LeafElement it, final Keyword keyword, @Extension final PsiToEcoreTransformationContext transformationContext) {
    String _value = keyword.getValue();
    transformationContext.newLeafNode(it, keyword, _value);
  }
  
  protected void _transform(final LeafElement it, final RuleCall ruleCall, @Extension final PsiToEcoreTransformationContext transformationContext) {
    AbstractRule _rule = ruleCall.getRule();
    final AbstractRule rule = _rule;
    boolean _matched = false;
    if (!_matched) {
      if (rule instanceof TerminalRule) {
        _matched=true;
        String _name = ((TerminalRule)rule).getName();
        transformationContext.newLeafNode(it, ruleCall, _name);
      }
    }
    if (!_matched) {
      throw new IllegalStateException(("Unexpected rule: " + rule));
    }
  }
  
  protected void _transform(final CompositeElement it, final ParserRule rule, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.newCompositeNode(it);
    this.transformChildren(it, transformationContext);
    transformationContext.compress();
  }
  
  protected void _transform(final CompositeElement it, final RuleCall ruleCall, @Extension final PsiToEcoreTransformationContext transformationContext) {
    AbstractRule _rule = ruleCall.getRule();
    final AbstractRule rule = _rule;
    boolean _matched = false;
    if (!_matched) {
      if (rule instanceof ParserRule) {
        boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(((ParserRule)rule));
        if (_isDatatypeRule) {
          _matched=true;
          transformationContext.newCompositeNode(it);
          PsiToEcoreTransformationContext _branch = transformationContext.branch();
          final PsiToEcoreTransformationContext childTransformationContext = _branch.withDatatypeRule();
          PsiToEcoreTransformationContext _transformChildren = this.transformChildren(it, childTransformationContext);
          transformationContext.sync(_transformChildren);
          boolean _ensureModelElementCreated = transformationContext.ensureModelElementCreated(ruleCall);
          if (_ensureModelElementCreated) {
            final DatatypeRuleToken datatypeRuleToken = childTransformationContext.getDatatypeRuleToken();
            String _name = ((ParserRule)rule).getName();
            transformationContext.assign(datatypeRuleToken, ruleCall, _name);
          }
          transformationContext.merge(childTransformationContext);
          transformationContext.compress();
        }
      }
    }
    if (!_matched) {
      if (rule instanceof EnumRule) {
        _matched=true;
      }
      if (!_matched) {
        if (rule instanceof ParserRule) {
          _matched=true;
        }
      }
      if (_matched) {
        transformationContext.newCompositeNode(it);
        final PsiToEcoreTransformationContext childTransformationContext = transformationContext.branch();
        PsiToEcoreTransformationContext _transformChildren = this.transformChildren(it, childTransformationContext);
        transformationContext.sync(_transformChildren);
        boolean _ensureModelElementCreated = transformationContext.ensureModelElementCreated(ruleCall);
        if (_ensureModelElementCreated) {
          final EObject child = childTransformationContext.getCurrent();
          boolean _notEquals = (!Objects.equal(child, null));
          if (_notEquals) {
            String _name = rule.getName();
            transformationContext.assign(child, ruleCall, _name);
          }
        }
        transformationContext.merge(childTransformationContext);
        transformationContext.compress();
      }
    }
    if (!_matched) {
      throw new IllegalStateException(("Unexpected rule: " + rule));
    }
  }
  
  protected void _transform(final LeafElement it, final CrossReference crossReference, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.ensureModelElementCreated(crossReference);
    transformationContext.newLeafNode(it);
  }
  
  protected void _transform(final CompositeElement it, final CrossReference crossReference, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.newCompositeNode(it);
    transformationContext.ensureModelElementCreated(crossReference);
    this.transformChildren(it, transformationContext);
    transformationContext.compress();
  }
  
  protected PsiToEcoreTransformationContext transformChildren(final CompositeElement it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    PsiToEcoreTransformationContext _xblockexpression = null;
    {
      ASTNode[] _children = it.getChildren(null);
      for (final ASTNode child : _children) {
        this.transform(child, transformationContext);
      }
      _xblockexpression = transformationContext;
    }
    return _xblockexpression;
  }
  
  public IParseResult parse(final ParserRule rule, final Reader reader) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public IParseResult parse(final RuleCall ruleCall, final Reader reader, final int initialLookAhead) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public IParseResult reparse(final IParseResult previousParseResult, final ReplaceRegion replaceRegion) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  protected void transform(final ASTNode it, final PsiToEcoreTransformationContext transformationContext) {
    if (it instanceof CompositeElement) {
      _transform((CompositeElement)it, transformationContext);
      return;
    } else if (it instanceof LeafElement) {
      _transform((LeafElement)it, transformationContext);
      return;
    } else if (it != null) {
      _transform(it, transformationContext);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, transformationContext).toString());
    }
  }
  
  protected void transform(final ASTNode it, final EObject crossReference, final PsiToEcoreTransformationContext transformationContext) {
    if (it instanceof CompositeElement
         && crossReference instanceof CrossReference) {
      _transform((CompositeElement)it, (CrossReference)crossReference, transformationContext);
      return;
    } else if (it instanceof CompositeElement
         && crossReference instanceof ParserRule) {
      _transform((CompositeElement)it, (ParserRule)crossReference, transformationContext);
      return;
    } else if (it instanceof CompositeElement
         && crossReference instanceof RuleCall) {
      _transform((CompositeElement)it, (RuleCall)crossReference, transformationContext);
      return;
    } else if (it instanceof LeafElement
         && crossReference instanceof CrossReference) {
      _transform((LeafElement)it, (CrossReference)crossReference, transformationContext);
      return;
    } else if (it instanceof LeafElement
         && crossReference instanceof Keyword) {
      _transform((LeafElement)it, (Keyword)crossReference, transformationContext);
      return;
    } else if (it instanceof LeafElement
         && crossReference instanceof RuleCall) {
      _transform((LeafElement)it, (RuleCall)crossReference, transformationContext);
      return;
    } else if (it != null
         && crossReference != null) {
      _transform(it, crossReference, transformationContext);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, crossReference, transformationContext).toString());
    }
  }
  
  public void setXtextFile(final BaseXtextFile xtextFile) {
    this.xtextFile = xtextFile;
  }
  
  @Pure
  public PsiToEcoreAdapter getAdapter() {
    return this.adapter;
  }
}

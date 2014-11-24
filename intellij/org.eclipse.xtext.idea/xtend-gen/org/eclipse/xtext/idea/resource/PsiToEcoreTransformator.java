package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.io.Reader;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method node is undefined for the type PsiToEcoreTransformator"
      + "\ngetChildren cannot be resolved"
      + "\ntransform cannot be resolved");
  }
  
  protected void _transform(final /* ASTNode */Object it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    String _plus = ("Unexpected ast node: " + it);
    throw new IllegalStateException(_plus);
  }
  
  protected void _transform(final /* LeafElement */Object it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field elementType is undefined for the type PsiToEcoreTransformator"
      + "\ngrammarElement cannot be resolved");
  }
  
  protected void _transform(final /* CompositeElement */Object it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiErrorElement cannot be resolved to a type."
      + "\nThe method or field elementType is undefined for the type PsiToEcoreTransformator"
      + "\ngrammarElement cannot be resolved");
  }
  
  protected void _transform(final /* ASTNode */Object it, final EObject grammarElement, @Extension final PsiToEcoreTransformationContext transformationContext) {
    String _plus = ((("Unexpected grammar element: " + grammarElement) + ", for node: ") + it);
    throw new IllegalStateException(_plus);
  }
  
  protected void _transform(final /* LeafElement */Object it, final Keyword keyword, @Extension final PsiToEcoreTransformationContext transformationContext) {
    String _value = keyword.getValue();
    transformationContext.newLeafNode(this, keyword, _value);
  }
  
  protected void _transform(final /* LeafElement */Object it, final RuleCall ruleCall, @Extension final PsiToEcoreTransformationContext transformationContext) {
    AbstractRule _rule = ruleCall.getRule();
    final AbstractRule rule = _rule;
    boolean _matched = false;
    if (!_matched) {
      if (rule instanceof TerminalRule) {
        _matched=true;
        String _name = ((TerminalRule)rule).getName();
        transformationContext.newLeafNode(this, ruleCall, _name);
      }
    }
    if (!_matched) {
      throw new IllegalStateException(("Unexpected rule: " + rule));
    }
  }
  
  protected void _transform(final /* CompositeElement */Object it, final ParserRule rule, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.newCompositeNode(this);
    this.transformChildren(this, transformationContext);
    transformationContext.compress();
  }
  
  protected void _transform(final /* CompositeElement */Object it, final Action action, @Extension final PsiToEcoreTransformationContext transformationContext) {
    final EObject value = transformationContext.getCurrent();
    transformationContext.forceCreateModelElement(action);
    transformationContext.assign(value, action);
    transformationContext.newCompositeNodeAsParentOfCurrentNode(this, action);
  }
  
  protected void _transform(final /* CompositeElement */Object it, final RuleCall ruleCall, @Extension final PsiToEcoreTransformationContext transformationContext) {
    AbstractRule _rule = ruleCall.getRule();
    final AbstractRule rule = _rule;
    boolean _matched = false;
    if (!_matched) {
      if (rule instanceof ParserRule) {
        boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(((ParserRule)rule));
        if (_isDatatypeRule) {
          _matched=true;
          transformationContext.newCompositeNode(this);
          PsiToEcoreTransformationContext _branch = transformationContext.branch();
          final PsiToEcoreTransformationContext childTransformationContext = _branch.withDatatypeRule();
          PsiToEcoreTransformationContext _transformChildren = this.transformChildren(this, childTransformationContext);
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
        transformationContext.newCompositeNode(this);
        final PsiToEcoreTransformationContext childTransformationContext = transformationContext.branch();
        PsiToEcoreTransformationContext _transformChildren = this.transformChildren(this, childTransformationContext);
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
  
  protected void _transform(final /* LeafElement */Object it, final CrossReference crossReference, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.ensureModelElementCreated(crossReference);
    transformationContext.newLeafNode(this);
  }
  
  protected void _transform(final /* CompositeElement */Object it, final CrossReference crossReference, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.newCompositeNode(this);
    transformationContext.ensureModelElementCreated(crossReference);
    this.transformChildren(this, transformationContext);
    transformationContext.compress();
  }
  
  protected PsiToEcoreTransformationContext transformChildren(final /* CompositeElement */Object it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getChildren is undefined for the type PsiToEcoreTransformator"
      + "\ntransform cannot be resolved");
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
    if (it != null) {
      _transform(it, transformationContext);
      return; else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(it, transformationContext).toString());
      }
    }
    
    protected void transform(final CompositeElement it, final EObject action, final PsiToEcoreTransformationContext transformationContext) {
      if (it != null
           && action instanceof Action) {
        _transform(it, (Action)action, transformationContext);
        return;
      } else if (it != null
           && action instanceof CrossReference) {
        _transform(it, (CrossReference)action, transformationContext);
        return;
      } else if (it != null
           && action instanceof Keyword) {
        _transform(it, (Keyword)action, transformationContext);
        return;
      } else if (it != null
           && action instanceof ParserRule) {
        _transform(it, (ParserRule)action, transformationContext);
        return;
      } else if (it != null
           && action instanceof RuleCall) {
        _transform(it, (RuleCall)action, transformationContext);
        return;
      } else if (it != null
           && action != null) {
        _transform(it, action, transformationContext);
        return;
      } else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(it, action, transformationContext).toString());
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
  
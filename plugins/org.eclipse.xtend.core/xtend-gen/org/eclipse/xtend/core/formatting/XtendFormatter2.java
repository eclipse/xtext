package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.formatting.FormatterCfg;
import org.eclipse.xtend.core.formatting.FormatterState;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.services.XtendGrammarAccess.ClassElements;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XBlockExpressionElements;

/**
 * @author Moitz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFormatter2 {
  @Inject
  private XtendGrammarAccess _xtendGrammarAccess;
  
  @Inject
  private IWhitespaceInformationProvider whitespaeInfo;
  
  public void format(final ICompositeNode root, final int offset, final int length, final Procedure3<? super Integer,? super Integer,? super String> textEditAcceptor) {
    EObject _semanticElement = root.getSemanticElement();
    Resource _eResource = _semanticElement.eResource();
    final URI uri = _eResource.getURI();
    ILineSeparatorInformation _lineSeparatorInformation = this.whitespaeInfo.getLineSeparatorInformation(uri);
    final String lineSeparator = _lineSeparatorInformation.getLineSeparator();
    IIndentationInformation _indentationInformation = this.whitespaeInfo.getIndentationInformation(uri);
    final String indentation = _indentationInformation.getIndentString();
    FormatterState _formatterState = new FormatterState();
    FormatterCfg _formatterCfg = new FormatterCfg(lineSeparator, indentation);
    this.format(root, _formatterState, _formatterCfg, textEditAcceptor);
  }
  
  public void format(final INode node, final FormatterState state, final FormatterCfg cfg, final Procedure3<? super Integer,? super Integer,? super String> textEditAcceptor) {
    boolean _matched = false;
    if (!_matched) {
      if (node instanceof ILeafNode) {
        final ILeafNode _iLeafNode = (ILeafNode)node;
        boolean _isHidden = _iLeafNode.isHidden();
        if (_isHidden) {
          _matched=true;
          List<ILeafNode> _lastHiddens = state.getLastHiddens();
          _lastHiddens.add(_iLeafNode);
        }
      }
    }
    if (!_matched) {
      if (node instanceof ILeafNode) {
        final ILeafNode _iLeafNode = (ILeafNode)node;
        boolean _isHidden = _iLeafNode.isHidden();
        boolean _not = (!_isHidden);
        if (_not) {
          _matched=true;
          EObject _grammarElement = _iLeafNode.getGrammarElement();
          final EObject _switchValue = _grammarElement;
          boolean _matched_1 = false;
          if (!_matched_1) {
            ClassElements _classAccess = this._xtendGrammarAccess.getClassAccess();
            Keyword _rightCurlyBracketKeyword_10 = _classAccess.getRightCurlyBracketKeyword_10();
            if (Objects.equal(_switchValue,_rightCurlyBracketKeyword_10)) {
              _matched_1=true;
              state.setWrap(1);
              int _indentation = state.getIndentation();
              int _minus = (_indentation - 1);
              state.setIndentation(_minus);
            }
          }
          if (!_matched_1) {
            XBlockExpressionElements _xBlockExpressionAccess = this._xtendGrammarAccess.getXBlockExpressionAccess();
            Keyword _rightCurlyBracketKeyword_3 = _xBlockExpressionAccess.getRightCurlyBracketKeyword_3();
            if (Objects.equal(_switchValue,_rightCurlyBracketKeyword_3)) {
              _matched_1=true;
              state.setWrap(1);
              int _indentation_1 = state.getIndentation();
              int _minus_1 = (_indentation_1 - 1);
              state.setIndentation(_minus_1);
            }
          }
          if (!_matched_1) {
            XBlockExpressionElements _xBlockExpressionAccess_1 = this._xtendGrammarAccess.getXBlockExpressionAccess();
            Keyword _semicolonKeyword_2_1 = _xBlockExpressionAccess_1.getSemicolonKeyword_2_1();
            if (Objects.equal(_switchValue,_semicolonKeyword_2_1)) {
              _matched_1=true;
              state.setWrap(1);
              state.setSpace("");
            }
          }
          if (!_matched_1) {
            String _text = _iLeafNode.getText();
            boolean _equals = Objects.equal(_text, ".");
            if (_equals) {
              _matched_1=true;
              state.setWrap(2);
              state.setSpace("");
            }
          }
          List<ILeafNode> _lastHiddens = state.getLastHiddens();
          final Function1<ILeafNode,String> _function = new Function1<ILeafNode,String>() {
              public String apply(final ILeafNode it) {
                String _text = it.getText();
                return _text;
              }
            };
          List<String> _map = ListExtensions.<ILeafNode, String>map(_lastHiddens, _function);
          final String oldText = IterableExtensions.join(_map);
          int _xifexpression = (int) 0;
          List<ILeafNode> _lastHiddens_1 = state.getLastHiddens();
          boolean _isEmpty = _lastHiddens_1.isEmpty();
          if (_isEmpty) {
            int _offset = _iLeafNode.getOffset();
            _xifexpression = _offset;
          } else {
            List<ILeafNode> _lastHiddens_2 = state.getLastHiddens();
            ILeafNode _head = IterableExtensions.<ILeafNode>head(_lastHiddens_2);
            int _offset_1 = _head.getOffset();
            _xifexpression = _offset_1;
          }
          final int oldOffset = _xifexpression;
          int _xifexpression_1 = (int) 0;
          List<ILeafNode> _lastHiddens_3 = state.getLastHiddens();
          boolean _isEmpty_1 = _lastHiddens_3.isEmpty();
          if (_isEmpty_1) {
            _xifexpression_1 = 0;
          } else {
            int _length = oldText.length();
            _xifexpression_1 = _length;
          }
          final int oldLength = _xifexpression_1;
          String _xifexpression_2 = null;
          int _wrap = state.getWrap();
          boolean _greaterThan = (_wrap > 0);
          if (_greaterThan) {
            int _wrap_1 = state.getWrap();
            String _wrap_2 = cfg.getWrap(_wrap_1);
            int _indentation_2 = state.getIndentation();
            String _indentation_3 = cfg.getIndentation(_indentation_2);
            String _plus = (_wrap_2 + _indentation_3);
            _xifexpression_2 = _plus;
          } else {
            String _space = state.getSpace();
            _xifexpression_2 = _space;
          }
          final String newText = _xifexpression_2;
          textEditAcceptor.apply(Integer.valueOf(oldOffset), Integer.valueOf(oldLength), newText);
          List<ILeafNode> _lastHiddens_4 = state.getLastHiddens();
          _lastHiddens_4.clear();
          state.setWrap(0);
          state.setSpace(" ");
          EObject _grammarElement_1 = _iLeafNode.getGrammarElement();
          final EObject _switchValue_1 = _grammarElement_1;
          boolean _matched_2 = false;
          if (!_matched_2) {
            ClassElements _classAccess_1 = this._xtendGrammarAccess.getClassAccess();
            Keyword _leftCurlyBracketKeyword_8 = _classAccess_1.getLeftCurlyBracketKeyword_8();
            if (Objects.equal(_switchValue_1,_leftCurlyBracketKeyword_8)) {
              _matched_2=true;
              state.setWrap(1);
              int _indentation_4 = state.getIndentation();
              int _plus_1 = (_indentation_4 + 1);
              state.setIndentation(_plus_1);
            }
          }
          if (!_matched_2) {
            XBlockExpressionElements _xBlockExpressionAccess_2 = this._xtendGrammarAccess.getXBlockExpressionAccess();
            Keyword _leftCurlyBracketKeyword_1 = _xBlockExpressionAccess_2.getLeftCurlyBracketKeyword_1();
            if (Objects.equal(_switchValue_1,_leftCurlyBracketKeyword_1)) {
              _matched_2=true;
              state.setWrap(1);
              int _indentation_5 = state.getIndentation();
              int _plus_2 = (_indentation_5 + 1);
              state.setIndentation(_plus_2);
            }
          }
          if (!_matched_2) {
            String _text_1 = _iLeafNode.getText();
            boolean _equals_1 = Objects.equal(_text_1, ".");
            if (_equals_1) {
              _matched_2=true;
              state.setWrap(1);
              state.setSpace("");
            }
          }
        }
      }
    }
    if (!_matched) {
      if (node instanceof ICompositeNode) {
        final ICompositeNode _iCompositeNode = (ICompositeNode)node;
        _matched=true;
        EObject _grammarElement = _iCompositeNode.getGrammarElement();
        final EObject ge = _grammarElement;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (ge instanceof RuleCall) {
            final RuleCall _ruleCall = (RuleCall)ge;
            _matched_1=true;
            AbstractRule _rule = _ruleCall.getRule();
            final AbstractRule rule = _rule;
            boolean _matched_2 = false;
            if (!_matched_2) {
              ParserRule _importRule = this._xtendGrammarAccess.getImportRule();
              if (Objects.equal(rule,_importRule)) {
                _matched_2=true;
                state.setWrap(2);
              }
            }
            if (!_matched_2) {
              ParserRule _memberRule = this._xtendGrammarAccess.getMemberRule();
              if (Objects.equal(rule,_memberRule)) {
                _matched_2=true;
                state.setWrap(2);
              }
            }
            if (!_matched_2) {
              ParserRule _classRule = this._xtendGrammarAccess.getClassRule();
              if (Objects.equal(rule,_classRule)) {
                _matched_2=true;
                state.setWrap(2);
              }
            }
          }
        }
        BidiIterable<INode> _children = _iCompositeNode.getChildren();
        for (final INode child : _children) {
          this.format(child, state, cfg, textEditAcceptor);
        }
        EObject _grammarElement_1 = _iCompositeNode.getGrammarElement();
        final EObject ge_1 = _grammarElement_1;
        boolean _matched_2 = false;
        if (!_matched_2) {
          XBlockExpressionElements _xBlockExpressionAccess = this._xtendGrammarAccess.getXBlockExpressionAccess();
          RuleCall _expressionsXExpressionInsideBlockParserRuleCall_2_0_0 = _xBlockExpressionAccess.getExpressionsXExpressionInsideBlockParserRuleCall_2_0_0();
          if (Objects.equal(ge_1,_expressionsXExpressionInsideBlockParserRuleCall_2_0_0)) {
            _matched_2=true;
            state.setWrap(1);
          }
        }
        if (!_matched_2) {
          if (ge_1 instanceof RuleCall) {
            final RuleCall _ruleCall = (RuleCall)ge_1;
            _matched_2=true;
            AbstractRule _rule = _ruleCall.getRule();
            final AbstractRule rule = _rule;
            boolean _matched_3 = false;
            if (!_matched_3) {
              ParserRule _importRule = this._xtendGrammarAccess.getImportRule();
              if (Objects.equal(rule,_importRule)) {
                _matched_3=true;
                state.setWrap(2);
              }
            }
            if (!_matched_3) {
              ParserRule _memberRule = this._xtendGrammarAccess.getMemberRule();
              if (Objects.equal(rule,_memberRule)) {
                _matched_3=true;
                state.setWrap(2);
              }
            }
            if (!_matched_3) {
              ParserRule _classRule = this._xtendGrammarAccess.getClassRule();
              if (Objects.equal(rule,_classRule)) {
                _matched_3=true;
                state.setWrap(2);
              }
            }
          }
        }
      }
    }
  }
}

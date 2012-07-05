package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.formatting.FormatterCfg;
import org.eclipse.xtend.core.formatting.FormatterState;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.services.XtendGrammarAccess.ClassElements;
import org.eclipse.xtend.core.services.XtendGrammarAccess.MemberElements;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendImport;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
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
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess.XAnnotationElements;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XBlockExpressionElements;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess.XIfExpressionElements;

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
              state.setSpace("");
            }
          }
          if (!_matched_1) {
            String _text = _iLeafNode.getText();
            boolean _equals = Objects.equal(_text, ".");
            if (_equals) {
              _matched_1=true;
              ILeafNode _last = state.getLast();
              String _text_1 = _last==null?(String)null:_last.getText();
              boolean _notEquals = (!Objects.equal(_text_1, "="));
              if (_notEquals) {
                state.setSpace("");
              }
            }
          }
          if (!_matched_1) {
            String _text_2 = _iLeafNode.getText();
            boolean _equals_1 = Objects.equal(_text_2, ",");
            if (_equals_1) {
              _matched_1=true;
              ILeafNode _last_1 = state.getLast();
              String _text_3 = _last_1==null?(String)null:_last_1.getText();
              boolean _notEquals_1 = (!Objects.equal(_text_3, "="));
              if (_notEquals_1) {
                state.setSpace("");
              }
            }
          }
          if (!_matched_1) {
            String _text_4 = _iLeafNode.getText();
            boolean _equals_2 = Objects.equal(_text_4, "(");
            if (_equals_2) {
              _matched_1=true;
              ILeafNode _last_2 = state.getLast();
              String _text_5 = _last_2==null?(String)null:_last_2.getText();
              boolean _notEquals_2 = (!Objects.equal(_text_5, "="));
              if (_notEquals_2) {
                state.setSpace("");
              }
            }
          }
          if (!_matched_1) {
            String _text_6 = _iLeafNode.getText();
            boolean _equals_3 = Objects.equal(_text_6, ")");
            if (_equals_3) {
              _matched_1=true;
              ILeafNode _last_3 = state.getLast();
              String _text_7 = _last_3==null?(String)null:_last_3.getText();
              boolean _notEquals_3 = (!Objects.equal(_text_7, "="));
              if (_notEquals_3) {
                state.setSpace("");
              }
            }
          }
          if (!_matched_1) {
            String _text_8 = _iLeafNode.getText();
            boolean _equals_4 = Objects.equal(_text_8, "<");
            if (_equals_4) {
              _matched_1=true;
              ILeafNode _last_4 = state.getLast();
              String _text_9 = _last_4==null?(String)null:_last_4.getText();
              boolean _notEquals_4 = (!Objects.equal(_text_9, "="));
              if (_notEquals_4) {
                state.setSpace("");
              }
            }
          }
          if (!_matched_1) {
            String _text_10 = _iLeafNode.getText();
            boolean _equals_5 = Objects.equal(_text_10, ">");
            if (_equals_5) {
              _matched_1=true;
              ILeafNode _last_5 = state.getLast();
              String _text_11 = _last_5==null?(String)null:_last_5.getText();
              boolean _notEquals_5 = (!Objects.equal(_text_11, "="));
              if (_notEquals_5) {
                state.setSpace("");
              }
            }
          }
          if (!_matched_1) {
            String _text_12 = _iLeafNode.getText();
            boolean _equals_6 = Objects.equal(_text_12, "[");
            if (_equals_6) {
              _matched_1=true;
              ILeafNode _last_6 = state.getLast();
              String _text_13 = _last_6==null?(String)null:_last_6.getText();
              boolean _notEquals_6 = (!Objects.equal(_text_13, "="));
              if (_notEquals_6) {
                state.setSpace("");
              }
            }
          }
          if (!_matched_1) {
            String _text_14 = _iLeafNode.getText();
            boolean _equals_7 = Objects.equal(_text_14, "::");
            if (_equals_7) {
              _matched_1=true;
              state.setSpace("");
            }
          }
          if (!_matched_1) {
            String _text_15 = _iLeafNode.getText();
            boolean _equals_8 = Objects.equal(_text_15, "..");
            if (_equals_8) {
              _matched_1=true;
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
          boolean _and = false;
          int _wrap = state.getWrap();
          boolean _greaterThan = (_wrap > 0);
          if (!_greaterThan) {
            _and = false;
          } else {
            String _space = state.getSpace();
            int _length_1 = _space.length();
            boolean _notEquals_7 = (_length_1 != 0);
            _and = (_greaterThan && _notEquals_7);
          }
          if (_and) {
            int _wrap_1 = state.getWrap();
            String _wrap_2 = cfg.getWrap(_wrap_1);
            int _indentation_2 = state.getIndentation();
            String _indentation_3 = cfg.getIndentation(_indentation_2);
            String _plus = (_wrap_2 + _indentation_3);
            _xifexpression_2 = _plus;
          } else {
            String _space_1 = state.getSpace();
            _xifexpression_2 = _space_1;
          }
          final String newText = _xifexpression_2;
          boolean _notEquals_8 = (!Objects.equal(oldText, newText));
          if (_notEquals_8) {
            textEditAcceptor.apply(Integer.valueOf(oldOffset), Integer.valueOf(oldLength), newText);
          }
          List<ILeafNode> _lastHiddens_4 = state.getLastHiddens();
          _lastHiddens_4.clear();
          state.setWrap(0);
          state.setSpace(" ");
          state.setLast(_iLeafNode);
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
            String _text_16 = _iLeafNode.getText();
            boolean _equals_9 = Objects.equal(_text_16, ".");
            if (_equals_9) {
              _matched_2=true;
              state.setSpace("");
            }
          }
          if (!_matched_2) {
            String _text_17 = _iLeafNode.getText();
            boolean _equals_10 = Objects.equal(_text_17, "(");
            if (_equals_10) {
              _matched_2=true;
              state.setSpace("");
            }
          }
          if (!_matched_2) {
            String _text_18 = _iLeafNode.getText();
            boolean _equals_11 = Objects.equal(_text_18, "<");
            if (_equals_11) {
              _matched_2=true;
              state.setSpace("");
            }
          }
          if (!_matched_2) {
            String _text_19 = _iLeafNode.getText();
            boolean _equals_12 = Objects.equal(_text_19, ">");
            if (_equals_12) {
              _matched_2=true;
              state.setSpace("");
            }
          }
          if (!_matched_2) {
            String _text_20 = _iLeafNode.getText();
            boolean _equals_13 = Objects.equal(_text_20, "@");
            if (_equals_13) {
              _matched_2=true;
              state.setSpace("");
            }
          }
          if (!_matched_2) {
            String _text_21 = _iLeafNode.getText();
            boolean _equals_14 = Objects.equal(_text_21, "::");
            if (_equals_14) {
              _matched_2=true;
              state.setSpace("");
            }
          }
          if (!_matched_2) {
            String _text_22 = _iLeafNode.getText();
            boolean _equals_15 = Objects.equal(_text_22, "..");
            if (_equals_15) {
              _matched_2=true;
              state.setSpace("");
            }
          }
          if (!_matched_2) {
            String _text_23 = _iLeafNode.getText();
            boolean _equals_16 = Objects.equal(_text_23, "!");
            if (_equals_16) {
              _matched_2=true;
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
        MemberElements _memberAccess = this._xtendGrammarAccess.getMemberAccess();
        Action _xtendFunctionAnnotationInfoAction_2_1_0 = _memberAccess.getXtendFunctionAnnotationInfoAction_2_1_0();
        MemberElements _memberAccess_1 = this._xtendGrammarAccess.getMemberAccess();
        Action _xtendConstructorAnnotationInfoAction_2_2_0 = _memberAccess_1.getXtendConstructorAnnotationInfoAction_2_2_0();
        final HashSet<Action> memberAction = CollectionLiterals.<Action>newHashSet(_xtendFunctionAnnotationInfoAction_2_1_0, _xtendConstructorAnnotationInfoAction_2_2_0);
        EObject _grammarElement = _iCompositeNode.getGrammarElement();
        final EObject ge = _grammarElement;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (ge instanceof RuleCall) {
            final RuleCall _ruleCall = (RuleCall)ge;
            XIfExpressionElements _xIfExpressionAccess = this._xtendGrammarAccess.getXIfExpressionAccess();
            RuleCall _thenXExpressionParserRuleCall_5_0 = _xIfExpressionAccess.getThenXExpressionParserRuleCall_5_0();
            if (Objects.equal(ge,_thenXExpressionParserRuleCall_5_0)) {
              _matched_1=true;
              EObject _semanticElement = _iCompositeNode.getSemanticElement();
              XExpression _then = ((XIfExpression) _semanticElement).getThen();
              boolean _not = (!(_then instanceof XBlockExpression));
              if (_not) {
                state.setWrap(1);
                int _indentation = state.getIndentation();
                int _plus = (_indentation + 1);
                state.setIndentation(_plus);
              }
            }
          }
        }
        if (!_matched_1) {
          if (ge instanceof RuleCall) {
            final RuleCall _ruleCall = (RuleCall)ge;
            XIfExpressionElements _xIfExpressionAccess = this._xtendGrammarAccess.getXIfExpressionAccess();
            RuleCall _elseXExpressionParserRuleCall_6_1_0 = _xIfExpressionAccess.getElseXExpressionParserRuleCall_6_1_0();
            if (Objects.equal(ge,_elseXExpressionParserRuleCall_6_1_0)) {
              _matched_1=true;
              EObject _semanticElement = _iCompositeNode.getSemanticElement();
              XExpression _else = ((XIfExpression) _semanticElement).getElse();
              boolean _not = (!(_else instanceof XBlockExpression));
              if (_not) {
                state.setWrap(1);
                int _indentation = state.getIndentation();
                int _plus = (_indentation + 1);
                state.setIndentation(_plus);
              }
            }
          }
        }
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
                int _xifexpression = (int) 0;
                EObject _semanticElement = _iCompositeNode.getSemanticElement();
                EObject _eContainer = _semanticElement.eContainer();
                EList<XtendImport> _imports = ((XtendFile) _eContainer).getImports();
                XtendImport _head = IterableExtensions.<XtendImport>head(_imports);
                EObject _semanticElement_1 = _iCompositeNode.getSemanticElement();
                boolean _equals = Objects.equal(_head, _semanticElement_1);
                if (_equals) {
                  _xifexpression = 2;
                } else {
                  _xifexpression = 1;
                }
                state.setWrap(_xifexpression);
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
        if (!_matched_1) {
          if (ge instanceof Action) {
            final Action _action = (Action)ge;
            MemberElements _memberAccess_2 = this._xtendGrammarAccess.getMemberAccess();
            Action _xtendFieldAnnotationInfoAction_2_0_0 = _memberAccess_2.getXtendFieldAnnotationInfoAction_2_0_0();
            if (Objects.equal(ge,_xtendFieldAnnotationInfoAction_2_0_0)) {
              _matched_1=true;
              state.setWrap(1);
            }
          }
        }
        if (!_matched_1) {
          if (ge instanceof Action) {
            final Action _action = (Action)ge;
            boolean _contains = memberAction.contains(_action);
            if (_contains) {
              _matched_1=true;
              int _xifexpression = (int) 0;
              ILeafNode _last = state.getLast();
              EObject _grammarElement_1 = _last==null?(EObject)null:_last.getGrammarElement();
              ClassElements _classAccess = this._xtendGrammarAccess.getClassAccess();
              Keyword _leftCurlyBracketKeyword_8 = _classAccess.getLeftCurlyBracketKeyword_8();
              boolean _equals = Objects.equal(_grammarElement_1, _leftCurlyBracketKeyword_8);
              if (_equals) {
                _xifexpression = 1;
              } else {
                _xifexpression = 2;
              }
              state.setWrap(_xifexpression);
            }
          }
        }
        if (!_matched_1) {
          if (ge instanceof Action) {
            final Action _action = (Action)ge;
            XAnnotationElements _xAnnotationAccess = this._xtendGrammarAccess.getXAnnotationAccess();
            Action _xAnnotationAction_0 = _xAnnotationAccess.getXAnnotationAction_0();
            if (Objects.equal(ge,_xAnnotationAction_0)) {
              _matched_1=true;
              int _wrap = state.getWrap();
              boolean _lessThan = (_wrap < 1);
              if (_lessThan) {
                state.setWrap(1);
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
            XIfExpressionElements _xIfExpressionAccess = this._xtendGrammarAccess.getXIfExpressionAccess();
            RuleCall _thenXExpressionParserRuleCall_5_0 = _xIfExpressionAccess.getThenXExpressionParserRuleCall_5_0();
            if (Objects.equal(ge_1,_thenXExpressionParserRuleCall_5_0)) {
              _matched_2=true;
              EObject _semanticElement = _iCompositeNode.getSemanticElement();
              XExpression _then = ((XIfExpression) _semanticElement).getThen();
              boolean _not = (!(_then instanceof XBlockExpression));
              if (_not) {
                state.setWrap(1);
                int _indentation = state.getIndentation();
                int _minus = (_indentation - 1);
                state.setIndentation(_minus);
              }
            }
          }
        }
        if (!_matched_2) {
          if (ge_1 instanceof RuleCall) {
            final RuleCall _ruleCall = (RuleCall)ge_1;
            XIfExpressionElements _xIfExpressionAccess = this._xtendGrammarAccess.getXIfExpressionAccess();
            RuleCall _elseXExpressionParserRuleCall_6_1_0 = _xIfExpressionAccess.getElseXExpressionParserRuleCall_6_1_0();
            if (Objects.equal(ge_1,_elseXExpressionParserRuleCall_6_1_0)) {
              _matched_2=true;
              EObject _semanticElement = _iCompositeNode.getSemanticElement();
              XExpression _else = ((XIfExpression) _semanticElement).getElse();
              boolean _not = (!(_else instanceof XBlockExpression));
              if (_not) {
                state.setWrap(1);
                int _indentation = state.getIndentation();
                int _minus = (_indentation - 1);
                state.setIndentation(_minus);
              }
            }
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
                state.setWrap(1);
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
        if (!_matched_2) {
          if (ge_1 instanceof Action) {
            final Action _action = (Action)ge_1;
            XAnnotationElements _xAnnotationAccess = this._xtendGrammarAccess.getXAnnotationAccess();
            Action _xAnnotationAction_0 = _xAnnotationAccess.getXAnnotationAction_0();
            if (Objects.equal(ge_1,_xAnnotationAction_0)) {
              _matched_2=true;
              EObject _semanticElement = _iCompositeNode.getSemanticElement();
              EObject _eContainer = _semanticElement.eContainer();
              if ((_eContainer instanceof XtendClass)) {
                state.setWrap(1);
              }
            }
          }
        }
      }
    }
  }
}

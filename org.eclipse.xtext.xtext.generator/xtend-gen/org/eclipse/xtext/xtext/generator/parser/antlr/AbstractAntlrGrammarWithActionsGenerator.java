/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.common.collect.Iterables;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Condition;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public abstract class AbstractAntlrGrammarWithActionsGenerator extends AbstractAntlrGrammarGenerator {
  @Override
  protected String compileInit(final AbstractRule it, final AntlrOptions options) {
    String _switchResult = null;
    boolean _matched = false;
    if (it instanceof ParserRule) {
      _matched=true;
      _switchResult = this.compileEntryInit(((ParserRule)it), options).toString();
    }
    if (!_matched) {
      _switchResult = super.compileInit(it, options);
    }
    return _switchResult;
  }

  protected CharSequence compileEntryInit(final ParserRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((it.isDefinesHiddenTokens() || this._grammarAccessExtensions.definesUnorderedGroups(it, options))) {
        _builder.append("@init {");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _compileInitHiddenTokens = this.compileInitHiddenTokens(it, options);
        _builder.append(_compileInitHiddenTokens, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _compileInitUnorderedGroups = this.compileInitUnorderedGroups(it, options);
        _builder.append(_compileInitUnorderedGroups, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
      }
    }
    return _builder;
  }

  protected CharSequence _compileInitHiddenTokens(final AbstractRule it, final AntlrOptions options) {
    return "";
  }

  protected CharSequence _compileInitHiddenTokens(final ParserRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isDefinesHiddenTokens = it.isDefinesHiddenTokens();
      if (_isDefinesHiddenTokens) {
        _builder.append("HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens(");
        {
          EList<AbstractRule> _hiddenTokens = it.getHiddenTokens();
          boolean _hasElements = false;
          for(final AbstractRule hidden : _hiddenTokens) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            _builder.append("\"");
            String _ruleName = this._grammarAccessExtensions.ruleName(hidden);
            _builder.append(_ruleName);
            _builder.append("\"");
          }
        }
        _builder.append(");");
      }
    }
    return _builder;
  }

  protected CharSequence _compileInitUnorderedGroups(final AbstractRule it, final AntlrOptions options) {
    return "";
  }

  protected CharSequence _compileInitUnorderedGroups(final ParserRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _definesUnorderedGroups = this._grammarAccessExtensions.definesUnorderedGroups(it, options);
      if (_definesUnorderedGroups) {
        _builder.newLineIfNotEmpty();
        _builder.append("UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(");
        _builder.newLine();
        {
          Iterable<UnorderedGroup> _filter = Iterables.<UnorderedGroup>filter(EcoreUtil2.eAllContentsAsList(it), UnorderedGroup.class);
          boolean _hasElements = false;
          for(final UnorderedGroup group : _filter) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            _builder.append("grammarAccess.");
            UnorderedGroup _originalElement = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(group);
            String _gaRuleElementAccessor = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement));
            _builder.append(_gaRuleElementAccessor);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append(");");
      }
    }
    return _builder;
  }

  @Override
  protected String compileFinally(final AbstractRule it, final AntlrOptions options) {
    String _switchResult = null;
    boolean _matched = false;
    if (it instanceof ParserRule) {
      _matched=true;
      _switchResult = this.compileEntryFinally(((ParserRule)it), options).toString();
    }
    if (!_matched) {
      _switchResult = super.compileFinally(it, options);
    }
    return _switchResult;
  }

  protected CharSequence compileEntryFinally(final ParserRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((it.isDefinesHiddenTokens() || this._grammarAccessExtensions.definesUnorderedGroups(it, options))) {
        _builder.append("finally {");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _compileRestoreHiddenTokens = this.compileRestoreHiddenTokens(it, options);
        _builder.append(_compileRestoreHiddenTokens, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _compileRestoreUnorderedGroups = this.compileRestoreUnorderedGroups(it, options);
        _builder.append(_compileRestoreUnorderedGroups, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
      }
    }
    return _builder;
  }

  protected CharSequence _compileRestoreHiddenTokens(final AbstractRule it, final AntlrOptions options) {
    return "";
  }

  protected CharSequence _compileRestoreHiddenTokens(final ParserRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isDefinesHiddenTokens = it.isDefinesHiddenTokens();
      if (_isDefinesHiddenTokens) {
        _builder.append("myHiddenTokenState.restore();");
      }
    }
    return _builder;
  }

  protected CharSequence _compileRestoreUnorderedGroups(final AbstractRule it, final AntlrOptions options) {
    return "";
  }

  protected CharSequence _compileRestoreUnorderedGroups(final ParserRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _definesUnorderedGroups = this._grammarAccessExtensions.definesUnorderedGroups(it, options);
      if (_definesUnorderedGroups) {
        _builder.append("myUnorderedGroupState.restore();");
      }
    }
    return _builder;
  }

  @Override
  protected String _dataTypeEbnf2(final Group it, final boolean supportActions) {
    String _xifexpression = null;
    Condition _guardCondition = it.getGuardCondition();
    boolean _tripleEquals = (_guardCondition == null);
    if (_tripleEquals) {
      _xifexpression = super._dataTypeEbnf2(it, supportActions);
    } else {
      String _guardConditionToAntlr = AntlrGrammarGenUtil.guardConditionToAntlr(it);
      String _plus = (_guardConditionToAntlr + "(");
      String __dataTypeEbnf2 = super._dataTypeEbnf2(it, supportActions);
      String _plus_1 = (_plus + __dataTypeEbnf2);
      _xifexpression = (_plus_1 + ")");
    }
    return _xifexpression;
  }

  @Override
  protected String _dataTypeEbnf2(final UnorderedGroup it, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      String _xblockexpression = null;
      {
        final Function1<AbstractElement, Boolean> _function = (AbstractElement it_1) -> {
          boolean _isOptionalCardinality = GrammarUtil.isOptionalCardinality(it_1);
          return Boolean.valueOf((!_isOptionalCardinality));
        };
        final int mandatoryContent = IterableExtensions.size(IterableExtensions.<AbstractElement>filter(it.getElements(), _function));
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{ ");
        _builder.newLine();
        _builder.append("\t  ");
        _builder.append("getUnorderedGroupHelper().enter(grammarAccess.");
        UnorderedGroup _originalElement = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
        String _gaRuleElementAccessor = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement));
        _builder.append(_gaRuleElementAccessor, "\t  ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("(");
        _builder.newLine();
        {
          Iterable<Pair<Integer, AbstractElement>> _indexed = IterableExtensions.<AbstractElement>indexed(it.getElements());
          boolean _hasElements = false;
          for(final Pair<Integer, AbstractElement> element : _indexed) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("|", "");
            }
            _builder.append("(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("{getUnorderedGroupHelper().canSelect(grammarAccess.");
            UnorderedGroup _originalElement_1 = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
            String _gaRuleElementAccessor_1 = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement_1));
            _builder.append(_gaRuleElementAccessor_1, "\t");
            _builder.append(", ");
            Integer _key = element.getKey();
            _builder.append(_key, "\t");
            _builder.append(")}?=>(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("getUnorderedGroupHelper().select(grammarAccess.");
            UnorderedGroup _originalElement_2 = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
            String _gaRuleElementAccessor_2 = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement_2));
            _builder.append(_gaRuleElementAccessor_2, "\t\t\t");
            _builder.append(", ");
            Integer _key_1 = element.getKey();
            _builder.append(_key_1, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("({true}?=>(");
            String _dataTypeEbnf2 = this.dataTypeEbnf2(element.getValue(), supportActions);
            _builder.append(_dataTypeEbnf2, "\t\t\t\t\t");
            _builder.append("))");
            {
              boolean _isMultipleCardinality = GrammarUtil.isMultipleCardinality(element.getValue());
              if (_isMultipleCardinality) {
                _builder.append("+");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{ ");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("getUnorderedGroupHelper().returnFromSelection(grammarAccess.");
            UnorderedGroup _originalElement_3 = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
            String _gaRuleElementAccessor_3 = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement_3));
            _builder.append(_gaRuleElementAccessor_3, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(")");
            _builder.newLine();
            _builder.append(")");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append(")");
        {
          if ((mandatoryContent != 0)) {
            _builder.append("+");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{getUnorderedGroupHelper().canLeave(grammarAccess.");
            UnorderedGroup _originalElement_4 = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
            String _gaRuleElementAccessor_4 = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement_4));
            _builder.append(_gaRuleElementAccessor_4, "\t\t");
            _builder.append(")}?");
          } else {
            _builder.append("*");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{ ");
        _builder.newLine();
        _builder.append("\t  ");
        _builder.append("getUnorderedGroupHelper().leave(grammarAccess.");
        UnorderedGroup _originalElement_5 = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
        String _gaRuleElementAccessor_5 = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement_5));
        _builder.append(_gaRuleElementAccessor_5, "\t  ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _xblockexpression = _builder.toString();
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super._dataTypeEbnf2(it, supportActions);
    }
    return _xifexpression;
  }

  @Override
  protected String _ebnf2(final Group it, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    Condition _guardCondition = it.getGuardCondition();
    boolean _tripleEquals = (_guardCondition == null);
    if (_tripleEquals) {
      _xifexpression = super._ebnf2(it, options, supportActions);
    } else {
      String _guardConditionToAntlr = AntlrGrammarGenUtil.guardConditionToAntlr(it);
      String _plus = (_guardConditionToAntlr + "(");
      String __ebnf2 = super._ebnf2(it, options, supportActions);
      String _plus_1 = (_plus + __ebnf2);
      _xifexpression = (_plus_1 + ")");
    }
    return _xifexpression;
  }

  @Override
  protected String _ebnf2(final UnorderedGroup it, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      String _xblockexpression = null;
      {
        final Function1<AbstractElement, Boolean> _function = (AbstractElement it_1) -> {
          boolean _isOptionalCardinality = GrammarUtil.isOptionalCardinality(it_1);
          return Boolean.valueOf((!_isOptionalCardinality));
        };
        final int mandatoryContent = IterableExtensions.size(IterableExtensions.<AbstractElement>filter(it.getElements(), _function));
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{ ");
        _builder.newLine();
        _builder.append("\t  ");
        _builder.append("getUnorderedGroupHelper().enter(grammarAccess.");
        UnorderedGroup _originalElement = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
        String _gaRuleElementAccessor = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement));
        _builder.append(_gaRuleElementAccessor, "\t  ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("(");
        _builder.newLine();
        {
          Iterable<Pair<Integer, AbstractElement>> _indexed = IterableExtensions.<AbstractElement>indexed(it.getElements());
          boolean _hasElements = false;
          for(final Pair<Integer, AbstractElement> element : _indexed) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate("|", "");
            }
            _builder.append("(");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("{getUnorderedGroupHelper().canSelect(grammarAccess.");
            UnorderedGroup _originalElement_1 = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
            String _gaRuleElementAccessor_1 = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement_1));
            _builder.append(_gaRuleElementAccessor_1, "\t");
            _builder.append(", ");
            Integer _key = element.getKey();
            _builder.append(_key, "\t");
            _builder.append(")}?=>(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("getUnorderedGroupHelper().select(grammarAccess.");
            UnorderedGroup _originalElement_2 = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
            String _gaRuleElementAccessor_2 = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement_2));
            _builder.append(_gaRuleElementAccessor_2, "\t\t\t");
            _builder.append(", ");
            Integer _key_1 = element.getKey();
            _builder.append(_key_1, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            _builder.append("({true}?=>(");
            String _ebnf2 = this.ebnf2(element.getValue(), options, supportActions);
            _builder.append(_ebnf2, "\t\t\t\t\t");
            _builder.append("))");
            {
              boolean _isMultipleCardinality = GrammarUtil.isMultipleCardinality(element.getValue());
              if (_isMultipleCardinality) {
                _builder.append("+");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{ ");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("getUnorderedGroupHelper().returnFromSelection(grammarAccess.");
            UnorderedGroup _originalElement_3 = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
            String _gaRuleElementAccessor_3 = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement_3));
            _builder.append(_gaRuleElementAccessor_3, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(")");
            _builder.newLine();
            _builder.append(")");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append(")");
        {
          if ((mandatoryContent != 0)) {
            _builder.append("+");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("{getUnorderedGroupHelper().canLeave(grammarAccess.");
            UnorderedGroup _originalElement_4 = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
            String _gaRuleElementAccessor_4 = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement_4));
            _builder.append(_gaRuleElementAccessor_4, "\t\t");
            _builder.append(")}?");
          } else {
            _builder.append("*");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{ ");
        _builder.newLine();
        _builder.append("\t  ");
        _builder.append("getUnorderedGroupHelper().leave(grammarAccess.");
        UnorderedGroup _originalElement_5 = AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it);
        String _gaRuleElementAccessor_5 = this._grammarAccessExtensions.gaRuleElementAccessor(((AbstractElement) _originalElement_5));
        _builder.append(_gaRuleElementAccessor_5, "\t  ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _xblockexpression = _builder.toString();
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super._ebnf2(it, options, supportActions);
    }
    return _xifexpression;
  }

  @Override
  protected String _ebnf2(final RuleCall it, final AntlrOptions options, final boolean supportActions) {
    String __ebnf2 = super._ebnf2(it, options, supportActions);
    String _argumentList = AntlrGrammarGenUtil.getArgumentList(it, this.isPassCurrentIntoFragment(), (!supportActions));
    return (__ebnf2 + _argumentList);
  }

  @Override
  protected String _ebnf2(final Assignment it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t");
    String __ebnf2 = super._ebnf2(it, options, supportActions);
    _builder.append(__ebnf2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }

  @Override
  protected String _dataTypeEbnf2(final RuleCall it, final boolean supportActions) {
    String __dataTypeEbnf2 = super._dataTypeEbnf2(it, supportActions);
    String _argumentList = AntlrGrammarGenUtil.getArgumentList(it, this.isPassCurrentIntoFragment(), (!supportActions));
    return (__dataTypeEbnf2 + _argumentList);
  }

  @Override
  protected String crossrefEbnf(final AbstractRule it, final RuleCall call, final CrossReference ref, final boolean supportActions) {
    String _crossrefEbnf = super.crossrefEbnf(it, call, ref, supportActions);
    String _argumentList = AntlrGrammarGenUtil.getArgumentList(call, this.isPassCurrentIntoFragment(), (!supportActions));
    return (_crossrefEbnf + _argumentList);
  }

  @Override
  protected String _assignmentEbnf(final RuleCall it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    String __assignmentEbnf = super._assignmentEbnf(it, assignment, options, supportActions);
    String _argumentList = AntlrGrammarGenUtil.getArgumentList(it, this.isPassCurrentIntoFragment(), (!supportActions));
    return (__assignmentEbnf + _argumentList);
  }

  @Override
  protected String _assignmentEbnf(final Alternatives it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t");
    String __assignmentEbnf = super._assignmentEbnf(it, assignment, options, supportActions);
    _builder.append(__assignmentEbnf, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }

  protected boolean isPassCurrentIntoFragment() {
    return false;
  }

  protected String getCurrentType() {
    return "EObject";
  }

  @Override
  protected boolean _mustBeParenthesized(final AbstractElement it) {
    return true;
  }

  @Override
  protected boolean _mustBeParenthesized(final Group it) {
    return true;
  }

  @Override
  protected boolean _mustBeParenthesized(final Assignment it) {
    return true;
  }

  @Override
  protected boolean _mustBeParenthesized(final Alternatives it) {
    return true;
  }

  protected boolean _mustBeParenthesized(final Keyword it) {
    return ((this._grammarAccessExtensions.predicated(it) || it.isFirstSetPredicated()) || (it.getCardinality() != null));
  }

  protected boolean _mustBeParenthesized(final RuleCall it) {
    return ((this._grammarAccessExtensions.predicated(it) || it.isFirstSetPredicated()) || (it.getCardinality() != null));
  }

  protected CharSequence compileInitHiddenTokens(final AbstractRule it, final AntlrOptions options) {
    if (it instanceof ParserRule) {
      return _compileInitHiddenTokens((ParserRule)it, options);
    } else if (it != null) {
      return _compileInitHiddenTokens(it, options);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, options).toString());
    }
  }

  protected CharSequence compileInitUnorderedGroups(final AbstractRule it, final AntlrOptions options) {
    if (it instanceof ParserRule) {
      return _compileInitUnorderedGroups((ParserRule)it, options);
    } else if (it != null) {
      return _compileInitUnorderedGroups(it, options);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, options).toString());
    }
  }

  protected CharSequence compileRestoreHiddenTokens(final AbstractRule it, final AntlrOptions options) {
    if (it instanceof ParserRule) {
      return _compileRestoreHiddenTokens((ParserRule)it, options);
    } else if (it != null) {
      return _compileRestoreHiddenTokens(it, options);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, options).toString());
    }
  }

  protected CharSequence compileRestoreUnorderedGroups(final AbstractRule it, final AntlrOptions options) {
    if (it instanceof ParserRule) {
      return _compileRestoreUnorderedGroups((ParserRule)it, options);
    } else if (it != null) {
      return _compileRestoreUnorderedGroups(it, options);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, options).toString());
    }
  }

  @Override
  protected String ebnf2(final AbstractElement it, final AntlrOptions options, final boolean supportActions) {
    if (it instanceof Alternatives) {
      return _ebnf2((Alternatives)it, options, supportActions);
    } else if (it instanceof Group) {
      return _ebnf2((Group)it, options, supportActions);
    } else if (it instanceof UnorderedGroup) {
      return _ebnf2((UnorderedGroup)it, options, supportActions);
    } else if (it instanceof Action) {
      return _ebnf2((Action)it, options, supportActions);
    } else if (it instanceof Assignment) {
      return _ebnf2((Assignment)it, options, supportActions);
    } else if (it instanceof EnumLiteralDeclaration) {
      return _ebnf2((EnumLiteralDeclaration)it, options, supportActions);
    } else if (it instanceof Keyword) {
      return _ebnf2((Keyword)it, options, supportActions);
    } else if (it instanceof RuleCall) {
      return _ebnf2((RuleCall)it, options, supportActions);
    } else if (it != null) {
      return _ebnf2(it, options, supportActions);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, options, supportActions).toString());
    }
  }

  @Override
  protected String assignmentEbnf(final AbstractElement it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    if (it instanceof Alternatives) {
      return _assignmentEbnf((Alternatives)it, assignment, options, supportActions);
    } else if (it instanceof Group) {
      return _assignmentEbnf((Group)it, assignment, options, supportActions);
    } else if (it instanceof Action) {
      return _assignmentEbnf((Action)it, assignment, options, supportActions);
    } else if (it instanceof Assignment) {
      return _assignmentEbnf((Assignment)it, assignment, options, supportActions);
    } else if (it instanceof CrossReference) {
      return _assignmentEbnf((CrossReference)it, assignment, options, supportActions);
    } else if (it instanceof RuleCall) {
      return _assignmentEbnf((RuleCall)it, assignment, options, supportActions);
    } else if (it != null) {
      return _assignmentEbnf(it, assignment, options, supportActions);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, assignment, options, supportActions).toString());
    }
  }

  @Override
  public boolean mustBeParenthesized(final AbstractElement it) {
    if (it instanceof Alternatives) {
      return _mustBeParenthesized((Alternatives)it);
    } else if (it instanceof Group) {
      return _mustBeParenthesized((Group)it);
    } else if (it instanceof Assignment) {
      return _mustBeParenthesized((Assignment)it);
    } else if (it instanceof Keyword) {
      return _mustBeParenthesized((Keyword)it);
    } else if (it instanceof RuleCall) {
      return _mustBeParenthesized((RuleCall)it);
    } else if (it != null) {
      return _mustBeParenthesized(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}

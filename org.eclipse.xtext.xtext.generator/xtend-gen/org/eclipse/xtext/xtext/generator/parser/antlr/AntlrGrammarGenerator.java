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
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Singleton
@SuppressWarnings("all")
public class AntlrGrammarGenerator extends AbstractAntlrGrammarWithActionsGenerator {
  @Inject
  @Extension
  private GrammarNaming naming;

  @Override
  protected GrammarNaming getGrammarNaming() {
    return this.naming;
  }

  @Override
  protected String compileParserImports(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.*;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.parser.*;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.parser.impl.*;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.util.EcoreUtil;");
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    {
      boolean _isEmpty = GrammarUtil.allEnumRules(it).isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("import org.eclipse.emf.common.util.Enumerator;");
        _builder.newLine();
      }
    }
    _builder.append("import ");
    String _name = this.getGrammarNaming().getInternalParserSuperClass(it).getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.xtext.parser.antlr.XtextTokenStream;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;");
    _builder.newLine();
    {
      if (((!IterableExtensions.isEmpty(Iterables.<UnorderedGroup>filter((Iterables.<EObject>concat(ListExtensions.<ParserRule, List<EObject>>map(GrammarUtil.allParserRules(it), ((Function1<ParserRule, List<EObject>>) (ParserRule it_1) -> {
        return EcoreUtil2.eAllContentsAsList(it_1);
      })))), UnorderedGroup.class))) && options.isBacktrack())) {
        _builder.append("import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;");
        _builder.newLine();
      }
    }
    _builder.append("import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;");
    _builder.newLine();
    _builder.append("import ");
    String _name_1 = this._grammarAccessExtensions.getGrammarAccess(it).getName();
    _builder.append(_name_1);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder.toString();
  }

  @Override
  protected String compileParserMembers(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("@");
    {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      if (_isCombinedGrammar) {
        _builder.append("parser::");
      }
    }
    _builder.append("members {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _isBacktrack = options.isBacktrack();
      if (_isBacktrack) {
        _builder.append("/*");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("This grammar contains a lot of empty actions to work around a bug in ANTLR.");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.");
        _builder.newLine();
        _builder.append("*/");
        _builder.newLine();
        _builder.newLine();
      }
    }
    _builder.append(" \t");
    _builder.append("private ");
    String _simpleName = this._grammarAccessExtensions.getGrammarAccess(it).getSimpleName();
    _builder.append(_simpleName, " \t");
    _builder.append(" grammarAccess;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public ");
    String _simpleName_1 = this.naming.getInternalParserClass(it).getSimpleName();
    _builder.append(_simpleName_1, "    ");
    _builder.append("(TokenStream input, ");
    String _simpleName_2 = this._grammarAccessExtensions.getGrammarAccess(it).getSimpleName();
    _builder.append(_simpleName_2, "    ");
    _builder.append(" grammarAccess) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("this(input);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("this.grammarAccess = grammarAccess;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("registerRules(grammarAccess.getGrammar());");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected String getFirstRuleName() {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return \"");
    String _name = AntlrGrammarGenUtil.<ParserRule>getOriginalElement(IterableExtensions.<ParserRule>head(GrammarUtil.allParserRules(it))).getName();
    _builder.append(_name, "    \t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("   \t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("   \t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("   \t");
    _builder.append("protected ");
    String _simpleName_3 = this._grammarAccessExtensions.getGrammarAccess(it).getSimpleName();
    _builder.append(_simpleName_3, "   \t");
    _builder.append(" getGrammarAccess() {");
    _builder.newLineIfNotEmpty();
    _builder.append("   \t\t");
    _builder.append("return grammarAccess;");
    _builder.newLine();
    _builder.append("   \t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  @Override
  protected String compileRuleCatch(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("@rulecatch {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("catch (RecognitionException re) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("recover(input,re);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("appendSkippedTokens();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  @Override
  protected boolean shouldBeSkipped(final TerminalRule it, final Grammar grammar) {
    return false;
  }

  @Override
  protected CharSequence _compileRule(final ParserRule it, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isValidEntryRule = AntlrGrammarGenUtil.isValidEntryRule(it);
      if (_isValidEntryRule) {
        String _compileEntryRule = this.compileEntryRule(it, grammar, options);
        _builder.append(_compileEntryRule);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    String _compileEBNF = this.compileEBNF(it, options);
    _builder.append(_compileEBNF);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected String compileEntryRule(final ParserRule it, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Entry rule ");
    String _entryRuleName = this._grammarAccessExtensions.entryRuleName(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(it));
    _builder.append(_entryRuleName);
    _builder.newLineIfNotEmpty();
    String _entryRuleName_1 = this._grammarAccessExtensions.entryRuleName(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(it));
    _builder.append(_entryRuleName_1);
    _builder.append(" returns ");
    String _compileEntryReturns = this.compileEntryReturns(it, options);
    _builder.append(_compileEntryReturns);
    CharSequence _compileEntryInit = this.compileEntryInit(it, options);
    _builder.append(_compileEntryInit);
    _builder.append(":");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{ ");
    CharSequence _newCompositeNode = this.newCompositeNode(it);
    _builder.append(_newCompositeNode, "\t");
    _builder.append(" }");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("iv_");
    String _ruleName = this._grammarAccessExtensions.ruleName(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(it));
    _builder.append(_ruleName, "\t");
    _builder.append("=");
    String _ruleName_1 = this._grammarAccessExtensions.ruleName(it);
    _builder.append(_ruleName_1, "\t");
    String _defaultArgumentList = AntlrGrammarGenUtil.getDefaultArgumentList(it);
    _builder.append(_defaultArgumentList, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{ $current=$iv_");
    String _ruleName_2 = this._grammarAccessExtensions.ruleName(it);
    _builder.append(_ruleName_2, "\t");
    _builder.append(".current");
    {
      boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(it));
      if (_isDatatypeRule) {
        _builder.append(".getText()");
      }
    }
    _builder.append("; }");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("EOF;");
    _builder.newLine();
    CharSequence _compileEntryFinally = this.compileEntryFinally(it, options);
    _builder.append(_compileEntryFinally);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  protected String compileEntryReturns(final ParserRule it, final AntlrOptions options) {
    boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(it));
    if (_isDatatypeRule) {
      return "[String current=null]";
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[");
      String _currentType = this.getCurrentType();
      _builder.append(_currentType);
      _builder.append(" current=null]");
      return _builder.toString();
    }
  }

  @Override
  protected String compileInit(final AbstractRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((it instanceof ParserRule)) {
        boolean _isPassCurrentIntoFragment = this.isPassCurrentIntoFragment();
        boolean _not = (!_isPassCurrentIntoFragment);
        String _parameterList = AntlrGrammarGenUtil.getParameterList(((ParserRule)it), Boolean.valueOf(_not), this.getCurrentType());
        _builder.append(_parameterList);
      }
    }
    _builder.append(" returns ");
    CharSequence _compileReturns = this.compileReturns(it, options);
    _builder.append(_compileReturns);
    _builder.newLineIfNotEmpty();
    _builder.append("@init {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("enterRule();");
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
    _builder.newLine();
    _builder.append("@after {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("leaveRule();");
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }

  protected CharSequence compileReturns(final AbstractRule it, final AntlrOptions options) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (it instanceof EnumRule) {
      _matched=true;
      _switchResult = "[Enumerator current=null]";
    }
    if (!_matched) {
      if (it instanceof ParserRule) {
        boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(((ParserRule)it)));
        if (_isDatatypeRule) {
          _matched=true;
          _switchResult = "[AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]";
        }
      }
    }
    if (!_matched) {
      if (it instanceof ParserRule) {
        boolean _isEObjectFragmentRule = GrammarUtil.isEObjectFragmentRule(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(((ParserRule)it)));
        if (_isEObjectFragmentRule) {
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("[");
          String _currentType = this.getCurrentType();
          _builder.append(_currentType);
          _builder.append(" current=in_current]");
          _switchResult = _builder;
        }
      }
    }
    if (!_matched) {
      if (it instanceof ParserRule) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("[");
        String _currentType = this.getCurrentType();
        _builder.append(_currentType);
        _builder.append(" current=null]");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      throw new IllegalStateException(("Unexpected rule: " + it));
    }
    return _switchResult;
  }

  @Override
  protected String _dataTypeEbnf2(final Keyword it, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("kw=");
      String __dataTypeEbnf2 = super._dataTypeEbnf2(it, supportActions);
      _builder.append(__dataTypeEbnf2);
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$current.merge(kw);");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _newLeafNode = this.newLeafNode(it, "kw");
      _builder.append(_newLeafNode, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder.toString();
    } else {
      _xifexpression = super._dataTypeEbnf2(it, supportActions);
    }
    return _xifexpression;
  }

  @Override
  protected String _dataTypeEbnf2(final RuleCall it, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      String _switchResult = null;
      AbstractRule _rule = it.getRule();
      boolean _matched = false;
      if (_rule instanceof EnumRule) {
        boolean _isAssigned = GrammarUtil.isAssigned(it);
        if (_isAssigned) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (_rule instanceof ParserRule) {
          boolean _isAssigned = GrammarUtil.isAssigned(it);
          if (_isAssigned) {
            _matched=true;
          }
        }
      }
      if (_matched) {
        _switchResult = super._dataTypeEbnf2(it, supportActions);
      }
      if (!_matched) {
        if (_rule instanceof EnumRule) {
          _matched=true;
        }
        if (!_matched) {
          if (_rule instanceof ParserRule) {
            _matched=true;
          }
        }
        if (_matched) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          CharSequence _newCompositeNode = this.newCompositeNode(it);
          _builder.append(_newCompositeNode, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          String _localVar = this._grammarAccessExtensions.localVar(it);
          _builder.append(_localVar);
          _builder.append("=");
          String __dataTypeEbnf2 = super._dataTypeEbnf2(it, supportActions);
          _builder.append(__dataTypeEbnf2);
          String _argumentList = AntlrGrammarGenUtil.getArgumentList(it, this.isPassCurrentIntoFragment(), (!supportActions));
          _builder.append(_argumentList);
          _builder.newLineIfNotEmpty();
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("$current.merge(");
          String _localVar_1 = this._grammarAccessExtensions.localVar(it);
          _builder.append(_localVar_1, "\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("afterParserOrEnumRuleCall();");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _switchResult = _builder.toString();
        }
      }
      if (!_matched) {
        if (_rule instanceof TerminalRule) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          String _localVar_2 = this._grammarAccessExtensions.localVar(it);
          _builder_1.append(_localVar_2);
          _builder_1.append("=");
          String __dataTypeEbnf2_1 = super._dataTypeEbnf2(it, supportActions);
          _builder_1.append(__dataTypeEbnf2_1);
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("$current.merge(");
          String _localVar_3 = this._grammarAccessExtensions.localVar(it);
          _builder_1.append(_localVar_3, "\t");
          _builder_1.append(");");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          CharSequence _newLeafNode = this.newLeafNode(it, this._grammarAccessExtensions.localVar(it));
          _builder_1.append(_newLeafNode, "\t");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          _switchResult = _builder_1.toString();
        }
      }
      if (!_matched) {
        _switchResult = super._dataTypeEbnf2(it, supportActions);
      }
      _xifexpression = _switchResult;
    } else {
      _xifexpression = super._dataTypeEbnf2(it, supportActions);
    }
    return _xifexpression;
  }

  @Override
  protected String _ebnf2(final Action it, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isBacktrack = options.isBacktrack();
        if (_isBacktrack) {
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* */");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$current = forceCreateModelElement");
      {
        String _feature = it.getFeature();
        boolean _tripleNotEquals = (_feature != null);
        if (_tripleNotEquals) {
          _builder.append("And");
          String _firstUpper = StringExtensions.toFirstUpper(this._grammarAccessExtensions.setOrAdd(it));
          _builder.append(_firstUpper, "\t");
        }
      }
      _builder.append("(");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("grammarAccess.");
      String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<Action>getOriginalElement(it));
      _builder.append(_grammarElementAccess, "\t\t");
      _builder.append(",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("$current);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder.toString();
    } else {
      _xifexpression = super._ebnf2(it, options, supportActions);
    }
    return _xifexpression;
  }

  @Override
  protected String _ebnf2(final Keyword it, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    if ((!supportActions)) {
      _xifexpression = super._ebnf2(it, options, supportActions);
    } else {
      String _xifexpression_1 = null;
      boolean _isAssigned = GrammarUtil.isAssigned(it);
      if (_isAssigned) {
        StringConcatenation _builder = new StringConcatenation();
        String __ebnf2 = super._ebnf2(it, options, supportActions);
        _builder.append(__ebnf2);
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _newLeafNode = this.newLeafNode(it, this._grammarAccessExtensions.localVar(GrammarUtil.containingAssignment(it), it));
        _builder.append(_newLeafNode, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _xifexpression_1 = _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _localVar = this._grammarAccessExtensions.localVar(it);
        _builder_1.append(_localVar);
        _builder_1.append("=");
        String __ebnf2_1 = super._ebnf2(it, options, supportActions);
        _builder_1.append(__ebnf2_1);
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("\t");
        CharSequence _newLeafNode_1 = this.newLeafNode(it, this._grammarAccessExtensions.localVar(it));
        _builder_1.append(_newLeafNode_1, "\t");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("}");
        _builder_1.newLine();
        _xifexpression_1 = _builder_1.toString();
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  @Override
  protected String _ebnf2(final EnumLiteralDeclaration it, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    if ((!supportActions)) {
      _xifexpression = super._ebnf2(it, options, supportActions);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      String _localVar = this._grammarAccessExtensions.localVar(it);
      _builder.append(_localVar);
      _builder.append("=");
      String __ebnf2 = super._ebnf2(it, options, supportActions);
      _builder.append(__ebnf2);
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$current = grammarAccess.");
      String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<EnumLiteralDeclaration>getOriginalElement(it));
      _builder.append(_grammarElementAccess, "\t");
      _builder.append(".getEnumLiteral().getInstance();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _newLeafNode = this.newLeafNode(it, this._grammarAccessExtensions.localVar(it));
      _builder.append(_newLeafNode, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder.toString();
    }
    return _xifexpression;
  }

  @Override
  protected String _ebnf2(final RuleCall it, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    if ((!supportActions)) {
      _xifexpression = super._ebnf2(it, options, supportActions);
    } else {
      String _switchResult = null;
      AbstractRule _rule = it.getRule();
      final AbstractRule rule = _rule;
      boolean _matched = false;
      if (rule instanceof EnumRule) {
        boolean _isAssigned = GrammarUtil.isAssigned(it);
        if (_isAssigned) {
          _matched=true;
        }
      }
      if (!_matched) {
        if (rule instanceof ParserRule) {
          boolean _isAssigned = GrammarUtil.isAssigned(it);
          if (_isAssigned) {
            _matched=true;
          }
        }
      }
      if (_matched) {
        _switchResult = super._ebnf2(it, options, supportActions);
      }
      if (!_matched) {
        if (rule instanceof EnumRule) {
          _matched=true;
        }
        if (!_matched) {
          if (rule instanceof ParserRule) {
            boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(((ParserRule)rule)));
            if (_isDatatypeRule) {
              _matched=true;
            }
          }
        }
        if (_matched) {
          StringConcatenation _builder = new StringConcatenation();
          {
            boolean _isBacktrack = options.isBacktrack();
            if (_isBacktrack) {
              _builder.append("{");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("/* */");
              _builder.newLine();
              _builder.append("}");
              _builder.newLine();
            }
          }
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          CharSequence _newCompositeNode = this.newCompositeNode(it);
          _builder.append(_newCompositeNode, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          String __ebnf2 = super._ebnf2(it, options, supportActions);
          _builder.append(__ebnf2);
          _builder.newLineIfNotEmpty();
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("afterParserOrEnumRuleCall();");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _switchResult = _builder.toString();
        }
      }
      if (!_matched) {
        if (rule instanceof ParserRule) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          {
            boolean _isBacktrack_1 = options.isBacktrack();
            if (_isBacktrack_1) {
              _builder_1.append("{");
              _builder_1.newLine();
              _builder_1.append("\t");
              _builder_1.append("/* */");
              _builder_1.newLine();
              _builder_1.append("}");
              _builder_1.newLine();
            }
          }
          _builder_1.append("{");
          _builder_1.newLine();
          {
            boolean _isEObjectFragmentRuleCall = GrammarUtil.isEObjectFragmentRuleCall(it);
            if (_isEObjectFragmentRuleCall) {
              _builder_1.append("\t");
              _builder_1.append("if ($current==null) {");
              _builder_1.newLine();
              _builder_1.append("\t");
              _builder_1.append("\t");
              _builder_1.append("$current = ");
              CharSequence _createModelElement = this.createModelElement(it);
              _builder_1.append(_createModelElement, "\t\t");
              _builder_1.append(";");
              _builder_1.newLineIfNotEmpty();
              _builder_1.append("\t");
              _builder_1.append("}");
              _builder_1.newLine();
            }
          }
          _builder_1.append("\t");
          CharSequence _newCompositeNode_1 = this.newCompositeNode(it);
          _builder_1.append(_newCompositeNode_1, "\t");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          String _localVar = this._grammarAccessExtensions.localVar(it);
          _builder_1.append(_localVar);
          _builder_1.append("=");
          String __ebnf2_1 = super._ebnf2(it, options, supportActions);
          _builder_1.append(__ebnf2_1);
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("$current = $");
          String _localVar_1 = this._grammarAccessExtensions.localVar(it);
          _builder_1.append(_localVar_1, "\t");
          _builder_1.append(".current;");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          _builder_1.append("afterParserOrEnumRuleCall();");
          _builder_1.newLine();
          _builder_1.append("}");
          _builder_1.newLine();
          _switchResult = _builder_1.toString();
        }
      }
      if (!_matched) {
        if (rule instanceof TerminalRule) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          String _localVar = this._grammarAccessExtensions.localVar(it);
          _builder_1.append(_localVar);
          _builder_1.append("=");
          String __ebnf2_1 = super._ebnf2(it, options, supportActions);
          _builder_1.append(__ebnf2_1);
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          CharSequence _newLeafNode = this.newLeafNode(it, this._grammarAccessExtensions.localVar(it));
          _builder_1.append(_newLeafNode, "\t");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          _switchResult = _builder_1.toString();
        }
      }
      if (!_matched) {
        _switchResult = super._ebnf2(it, options, supportActions);
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }

  @Override
  protected String crossrefEbnf(final AbstractRule it, final RuleCall call, final CrossReference ref, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      String _switchResult = null;
      boolean _matched = false;
      if (it instanceof EnumRule) {
        _matched=true;
      }
      if (!_matched) {
        if (it instanceof ParserRule) {
          _matched=true;
        }
      }
      if (_matched) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _newCompositeNode = this.newCompositeNode(ref);
        _builder.append(_newCompositeNode, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        String _ruleName = this._grammarAccessExtensions.ruleName(it);
        _builder.append(_ruleName);
        String _argumentList = AntlrGrammarGenUtil.getArgumentList(call, this.isPassCurrentIntoFragment(), (!supportActions));
        _builder.append(_argumentList);
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("afterParserOrEnumRuleCall();");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _switchResult = _builder.toString();
      }
      if (!_matched) {
        if (it instanceof TerminalRule) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          String _localVar = this._grammarAccessExtensions.localVar(GrammarUtil.containingAssignment(ref));
          _builder_1.append(_localVar);
          _builder_1.append("=");
          String _ruleName_1 = this._grammarAccessExtensions.ruleName(it);
          _builder_1.append(_ruleName_1);
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          CharSequence _newLeafNode = this.newLeafNode(ref, this._grammarAccessExtensions.localVar(GrammarUtil.containingAssignment(ref)));
          _builder_1.append(_newLeafNode, "\t");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          _switchResult = _builder_1.toString();
        }
      }
      if (!_matched) {
        throw new IllegalStateException(("crossrefEbnf is not supported for " + it));
      }
      _xifexpression = _switchResult;
    } else {
      _xifexpression = super.crossrefEbnf(it, call, ref, supportActions);
    }
    return _xifexpression;
  }

  @Override
  protected String _crossrefEbnf(final Keyword it, final CrossReference ref, final boolean supportActions) {
    String _xifexpression = null;
    if ((!supportActions)) {
      _xifexpression = super._crossrefEbnf(it, ref, supportActions);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      String _localVar = this._grammarAccessExtensions.localVar(GrammarUtil.containingAssignment(ref));
      _builder.append(_localVar);
      _builder.append("=");
      String __crossrefEbnf = super._crossrefEbnf(it, ref, supportActions);
      _builder.append(__crossrefEbnf);
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _newLeafNode = this.newLeafNode(ref, this._grammarAccessExtensions.localVar(GrammarUtil.containingAssignment(ref)));
      _builder.append(_newLeafNode, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder.toString();
    }
    return _xifexpression;
  }

  @Override
  protected String _assignmentEbnf(final CrossReference it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isBacktrack = options.isBacktrack();
        if (_isBacktrack) {
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("/* */");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if ($current==null) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$current = ");
      CharSequence _createModelElement = this.createModelElement(assignment);
      _builder.append(_createModelElement, "\t\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      String __assignmentEbnf = super._assignmentEbnf(it, assignment, options, supportActions);
      _builder.append(__assignmentEbnf);
      _xifexpression = _builder.toString();
    } else {
      _xifexpression = super._assignmentEbnf(it, assignment, options, supportActions);
    }
    return _xifexpression;
  }

  @Override
  protected String _assignmentEbnf(final AbstractElement it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      StringConcatenation _builder = new StringConcatenation();
      String _localVar = this._grammarAccessExtensions.localVar(assignment, it);
      _builder.append(_localVar);
      _builder.append("=");
      String __assignmentEbnf = super._assignmentEbnf(it, assignment, options, supportActions);
      _builder.append(__assignmentEbnf);
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if ($current==null) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$current = ");
      CharSequence _createModelElement = this.createModelElement(assignment);
      _builder.append(_createModelElement, "\t\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      String _setOrAdd = this._grammarAccessExtensions.setOrAdd(assignment);
      _builder.append(_setOrAdd, "\t");
      _builder.append("WithLastConsumed($current, \"");
      String _feature = assignment.getFeature();
      _builder.append(_feature, "\t");
      _builder.append("\", ");
      String _localVar_1 = this._grammarAccessExtensions.localVar(assignment, it);
      _builder.append(_localVar_1, "\t");
      {
        boolean _isBooleanAssignment = GrammarUtil.isBooleanAssignment(assignment);
        if (_isBooleanAssignment) {
          _builder.append(" != null");
        }
      }
      _builder.append(", ");
      CharSequence _stringLiteral = this._grammarAccessExtensions.toStringLiteral(assignment.getTerminal());
      _builder.append(_stringLiteral, "\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder.toString();
    } else {
      _xifexpression = super._assignmentEbnf(it, assignment, options, supportActions);
    }
    return _xifexpression;
  }

  @Override
  protected String _assignmentEbnf(final RuleCall it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      String _switchResult = null;
      AbstractRule _rule = it.getRule();
      boolean _matched = false;
      if (_rule instanceof EnumRule) {
        _matched=true;
      }
      if (!_matched) {
        if (_rule instanceof ParserRule) {
          _matched=true;
        }
      }
      if (_matched) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _newCompositeNode = this.newCompositeNode(it);
        _builder.append(_newCompositeNode, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        String _localVar = this._grammarAccessExtensions.localVar(assignment, it);
        _builder.append(_localVar);
        _builder.append("=");
        String __assignmentEbnf = super._assignmentEbnf(it, assignment, options, supportActions);
        _builder.append(__assignmentEbnf);
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("if ($current==null) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("$current = ");
        CharSequence _createModelElementForParent = this.createModelElementForParent(assignment);
        _builder.append(_createModelElementForParent, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        String _setOrAdd = this._grammarAccessExtensions.setOrAdd(assignment);
        _builder.append(_setOrAdd, "\t");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("$current,");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\"");
        String _feature = assignment.getFeature();
        _builder.append(_feature, "\t\t");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _localVar_1 = this._grammarAccessExtensions.localVar(assignment, it);
        _builder.append(_localVar_1, "\t\t");
        {
          boolean _isBooleanAssignment = GrammarUtil.isBooleanAssignment(assignment);
          if (_isBooleanAssignment) {
            _builder.append(" != null");
          }
        }
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        CharSequence _stringLiteral = this._grammarAccessExtensions.toStringLiteral(it);
        _builder.append(_stringLiteral, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("afterParserOrEnumRuleCall();");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _switchResult = _builder.toString();
      }
      if (!_matched) {
        if (_rule instanceof TerminalRule) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          String _localVar_2 = this._grammarAccessExtensions.localVar(assignment, it);
          _builder_1.append(_localVar_2);
          _builder_1.append("=");
          String __assignmentEbnf_1 = super._assignmentEbnf(it, assignment, options, supportActions);
          _builder_1.append(__assignmentEbnf_1);
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          CharSequence _newLeafNode = this.newLeafNode(it, this._grammarAccessExtensions.localVar(assignment, it));
          _builder_1.append(_newLeafNode, "\t");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          _builder_1.append("if ($current==null) {");
          _builder_1.newLine();
          _builder_1.append("\t\t");
          _builder_1.append("$current = ");
          CharSequence _createModelElement = this.createModelElement(assignment);
          _builder_1.append(_createModelElement, "\t\t");
          _builder_1.append(";");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t");
          _builder_1.append("}");
          _builder_1.newLine();
          _builder_1.append("\t");
          String _setOrAdd_1 = this._grammarAccessExtensions.setOrAdd(assignment);
          _builder_1.append(_setOrAdd_1, "\t");
          _builder_1.append("WithLastConsumed(");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t\t");
          _builder_1.append("$current,");
          _builder_1.newLine();
          _builder_1.append("\t\t");
          _builder_1.append("\"");
          String _feature_1 = assignment.getFeature();
          _builder_1.append(_feature_1, "\t\t");
          _builder_1.append("\",");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t\t");
          String _localVar_3 = this._grammarAccessExtensions.localVar(assignment, it);
          _builder_1.append(_localVar_3, "\t\t");
          {
            boolean _isBooleanAssignment_1 = GrammarUtil.isBooleanAssignment(assignment);
            if (_isBooleanAssignment_1) {
              _builder_1.append(" != null");
            }
          }
          _builder_1.append(",");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t\t");
          CharSequence _stringLiteral_1 = this._grammarAccessExtensions.toStringLiteral(it);
          _builder_1.append(_stringLiteral_1, "\t\t");
          _builder_1.append(");");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          _switchResult = _builder_1.toString();
        }
      }
      if (!_matched) {
        throw new IllegalStateException(("assignmentEbnf is not supported for " + it));
      }
      _xifexpression = _switchResult;
    } else {
      _xifexpression = super._assignmentEbnf(it, assignment, options, supportActions);
    }
    return _xifexpression;
  }

  @Override
  protected boolean isPassCurrentIntoFragment() {
    return true;
  }

  protected CharSequence createModelElement(final EObject grammarElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("createModelElement(grammarAccess.");
    String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(GrammarUtil.containingParserRule(grammarElement)));
    _builder.append(_grammarElementAccess);
    _builder.append(")");
    return _builder;
  }

  protected CharSequence createModelElementForParent(final EObject grammarElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("createModelElementForParent(grammarAccess.");
    String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(GrammarUtil.containingParserRule(grammarElement)));
    _builder.append(_grammarElementAccess);
    _builder.append(")");
    return _builder;
  }

  protected CharSequence newCompositeNode(final EObject it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newCompositeNode(grammarAccess.");
    String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<EObject>getOriginalElement(it));
    _builder.append(_grammarElementAccess);
    _builder.append(");");
    return _builder;
  }

  protected CharSequence newLeafNode(final EObject it, final String token) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("newLeafNode(");
    _builder.append(token);
    _builder.append(", grammarAccess.");
    String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<EObject>getOriginalElement(it));
    _builder.append(_grammarElementAccess);
    _builder.append(");");
    return _builder;
  }

  @Override
  protected CharSequence compileRule(final Object it, final Grammar grammar, final AntlrOptions options) {
    if (it instanceof EnumRule) {
      return _compileRule((EnumRule)it, grammar, options);
    } else if (it instanceof ParserRule) {
      return _compileRule((ParserRule)it, grammar, options);
    } else if (it instanceof TerminalRule) {
      return _compileRule((TerminalRule)it, grammar, options);
    } else if (it instanceof String) {
      return _compileRule((String)it, grammar, options);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, grammar, options).toString());
    }
  }
}

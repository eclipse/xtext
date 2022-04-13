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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class AntlrContentAssistGrammarGenerator extends AbstractAntlrGrammarWithActionsGenerator {
  @Inject
  @Extension
  private ContentAssistGrammarNaming naming;

  @Override
  protected GrammarNaming getGrammarNaming() {
    return this.naming;
  }

  @Override
  protected boolean isParserBackTracking(final Grammar it, final AntlrOptions options) {
    return (super.isParserBackTracking(it, options) || (!GrammarUtil.getAllPredicatedElements(it).isEmpty()));
  }

  @Override
  protected String compileParserMembers(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@");
    {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      if (_isCombinedGrammar) {
        _builder.append("parser::");
      }
    }
    _builder.append("members {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private ");
    String _simpleName = this._grammarAccessExtensions.getGrammarAccess(it).getSimpleName();
    _builder.append(_simpleName, "\t");
    _builder.append(" grammarAccess;");
    _builder.newLineIfNotEmpty();
    {
      boolean _isCombinedGrammar_1 = this.isCombinedGrammar();
      boolean _not = (!_isCombinedGrammar_1);
      if (_not) {
        _builder.append("\t");
        _builder.append("private final Map<String, String> tokenNameToValue = new HashMap<String, String>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        {
          final Function1<String, Integer> _function = (String it_1) -> {
            return Integer.valueOf(it_1.length());
          };
          List<String> _sortBy = IterableExtensions.<String, Integer>sortBy(IterableExtensions.<String>sort(GrammarUtil.getAllKeywords(it)), _function);
          for(final String kw : _sortBy) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("tokenNameToValue.put(\"");
            String _ruleName = this.keywordHelper.getRuleName(kw);
            _builder.append(_ruleName, "\t\t");
            _builder.append("\", \"\'");
            String _replace = AntlrGrammarGenUtil.toStringInAntlrAction(kw).replace("$", "\\u0024");
            _builder.append(_replace, "\t\t");
            _builder.append("\'\");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setGrammarAccess(");
    String _simpleName_1 = this._grammarAccessExtensions.getGrammarAccess(it).getSimpleName();
    _builder.append(_simpleName_1, "\t");
    _builder.append(" grammarAccess) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this.grammarAccess = grammarAccess;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Grammar getGrammar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return grammarAccess.getGrammar();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String getValueForTokenName(String tokenName) {");
    _builder.newLine();
    {
      boolean _isCombinedGrammar_2 = this.isCombinedGrammar();
      if (_isCombinedGrammar_2) {
        _builder.append("\t\t");
        _builder.append("return tokenName;");
        _builder.newLine();
      } else {
        _builder.append("\t\t");
        _builder.append("String result = tokenNameToValue.get(tokenName);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("if (result == null)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("result = tokenName;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return result;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  @Override
  protected String compileParserImports(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      boolean _not = (!_isCombinedGrammar);
      if (_not) {
        _builder.append("import java.util.Map;");
        _builder.newLine();
        _builder.append("import java.util.HashMap;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("import java.io.InputStream;");
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
    _builder.append("import org.eclipse.xtext.parser.antlr.XtextTokenStream;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;");
    _builder.newLine();
    _builder.append("import ");
    String _name = this.getGrammarNaming().getInternalParserSuperClass(it).getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;");
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
  protected CharSequence compileRules(final Grammar g, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<ParserRule> _allParserRules = GrammarUtil.allParserRules(g);
      List<EnumRule> _allEnumRules = GrammarUtil.allEnumRules(g);
      Iterable<AbstractRule> _plus = Iterables.<AbstractRule>concat(_allParserRules, _allEnumRules);
      Collection<? extends AbstractElement> _allAlternatives = GrammarUtil.getAllAlternatives(g);
      Iterable<EObject> _plus_1 = Iterables.<EObject>concat(_plus, _allAlternatives);
      Collection<? extends AbstractElement> _allGroups = GrammarUtil.getAllGroups(g);
      Iterable<EObject> _plus_2 = Iterables.<EObject>concat(_plus_1, _allGroups);
      Collection<? extends AbstractElement> _allUnorderedGroups = GrammarUtil.getAllUnorderedGroups(g);
      Iterable<EObject> _plus_3 = Iterables.<EObject>concat(_plus_2, _allUnorderedGroups);
      Collection<? extends AbstractElement> _allAssignments = GrammarUtil.getAllAssignments(g);
      final Function1<EObject, Boolean> _function = (EObject it) -> {
        return Boolean.valueOf(this._grammarAccessExtensions.isCalled(GrammarUtil.containingRule(it), g));
      };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(Iterables.<EObject>concat(_plus_3, _allAssignments), _function);
      for(final EObject rule : _filter) {
        _builder.newLine();
        CharSequence _compileRule = this.compileRule(rule, g, options);
        _builder.append(_compileRule);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      if (_isCombinedGrammar) {
        CharSequence _compileTerminalRules = this.compileTerminalRules(g, options);
        _builder.append(_compileTerminalRules);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  @Override
  protected CharSequence _compileRule(final ParserRule it, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isValidEntryRule = AntlrGrammarGenUtil.isValidEntryRule(it);
      if (_isValidEntryRule) {
        _builder.append("// Entry rule ");
        String _entryRuleName = this._grammarAccessExtensions.entryRuleName(it);
        _builder.append(_entryRuleName);
        _builder.newLineIfNotEmpty();
        String _entryRuleName_1 = this._grammarAccessExtensions.entryRuleName(it);
        _builder.append(_entryRuleName_1);
        _builder.newLineIfNotEmpty();
        {
          boolean _isDefinesHiddenTokens = it.isDefinesHiddenTokens();
          if (_isDefinesHiddenTokens) {
            _builder.append("@init { ");
            _builder.newLine();
            _builder.append("\t");
            CharSequence _compileInitHiddenTokens = this.compileInitHiddenTokens(it, options);
            _builder.append(_compileInitHiddenTokens, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.append(":");
        _builder.newLine();
        _builder.append("{ before(grammarAccess.");
        String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(it));
        _builder.append(_grammarElementAccess);
        _builder.append("); }");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        String _ruleName = this._grammarAccessExtensions.ruleName(it);
        _builder.append(_ruleName, "\t ");
        _builder.newLineIfNotEmpty();
        _builder.append("{ after(grammarAccess.");
        String _grammarElementAccess_1 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<ParserRule>getOriginalElement(it));
        _builder.append(_grammarElementAccess_1);
        _builder.append("); } ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t ");
        _builder.append("EOF ");
        _builder.newLine();
        _builder.append(";");
        _builder.newLine();
        {
          boolean _isDefinesHiddenTokens_1 = it.isDefinesHiddenTokens();
          if (_isDefinesHiddenTokens_1) {
            _builder.append("finally {");
            _builder.newLine();
            _builder.append("\t");
            CharSequence _compileRestoreHiddenTokens = this.compileRestoreHiddenTokens(it, options);
            _builder.append(_compileRestoreHiddenTokens, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("// Rule ");
    String _name = AntlrGrammarGenUtil.<ParserRule>getOriginalElement(it).getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    String _ruleName_1 = this._grammarAccessExtensions.ruleName(it);
    _builder.append(_ruleName_1);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@init {");
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _compileInitHiddenTokens_1 = this.compileInitHiddenTokens(it, options);
    _builder.append(_compileInitHiddenTokens_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("int stackSize = keepStackSize();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(":");
    _builder.newLine();
    _builder.append("\t");
    String _ebnf = this.ebnf(it.getAlternatives(), options, false);
    _builder.append(_ebnf, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(";");
    _builder.newLine();
    _builder.append("finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("restoreStackSize(stackSize);");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _compileRestoreHiddenTokens_1 = this.compileRestoreHiddenTokens(it, options);
    _builder.append(_compileRestoreHiddenTokens_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  @Override
  protected CharSequence _compileRule(final EnumRule it, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Rule ");
    String _name = AntlrGrammarGenUtil.<EnumRule>getOriginalElement(it).getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    String _ruleName = this._grammarAccessExtensions.ruleName(it);
    _builder.append(_ruleName);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@init {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int stackSize = keepStackSize();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("\t");
    String _ebnf = this.ebnf(it.getAlternatives(), options, false);
    _builder.append(_ebnf, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(";");
    _builder.newLine();
    _builder.append("finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("restoreStackSize(stackSize);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence _compileRule(final Alternatives it, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName);
    _builder.append("__");
    String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<Alternatives>getOriginalElement(it));
    _builder.append(_gaElementIdentifier);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@init {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int stackSize = keepStackSize();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("\t");
    {
      EList<AbstractElement> _elements = it.getElements();
      boolean _hasElements = false;
      for(final AbstractElement element : _elements) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n|", "\t");
        }
        String _ebnf = this.ebnf(element, options, false);
        _builder.append(_ebnf, "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append(";");
    _builder.newLine();
    _builder.append("finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("restoreStackSize(stackSize);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence _compileRule(final Assignment it, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName);
    _builder.append("__");
    String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<Assignment>getOriginalElement(it));
    _builder.append(_gaElementIdentifier);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@init {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int stackSize = keepStackSize();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("\t");
    String _assignmentEbnf = this.assignmentEbnf(it.getTerminal(), it, options, false);
    _builder.append(_assignmentEbnf, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(";");
    _builder.newLine();
    _builder.append("finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("restoreStackSize(stackSize);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence _compileRule(final UnorderedGroup it, final Grammar grammar, final AntlrOptions options) {
    CharSequence _xblockexpression = null;
    {
      final Function1<AbstractElement, Boolean> _function = (AbstractElement it_1) -> {
        boolean _isOptionalCardinality = GrammarUtil.isOptionalCardinality(it_1);
        return Boolean.valueOf((!_isOptionalCardinality));
      };
      final boolean hasMandatoryContent = IterableExtensions.<AbstractElement>exists(it.getElements(), _function);
      StringConcatenation _builder = new StringConcatenation();
      String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
      _builder.append(_contentAssistRuleName);
      _builder.append("__");
      String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
      _builder.append(_gaElementIdentifier);
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("@init {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("int stackSize = keepStackSize();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("getUnorderedGroupHelper().enter(grammarAccess.");
      String _gaRuleElementAccessor = this._grammarAccessExtensions.gaRuleElementAccessor(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
      _builder.append(_gaRuleElementAccessor, "\t\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append(":");
      _builder.newLine();
      _builder.append("\t");
      String _contentAssistRuleName_1 = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
      _builder.append(_contentAssistRuleName_1, "\t");
      _builder.append("__");
      String _gaElementIdentifier_1 = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
      _builder.append(_gaElementIdentifier_1, "\t");
      _builder.append("__0");
      _builder.newLineIfNotEmpty();
      {
        if (hasMandatoryContent) {
          _builder.append("\t");
          _builder.append("{getUnorderedGroupHelper().canLeave(grammarAccess.");
          String _gaRuleElementAccessor_1 = this._grammarAccessExtensions.gaRuleElementAccessor(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
          _builder.append(_gaRuleElementAccessor_1, "\t");
          _builder.append(")}?");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("\t");
          _builder.append("?");
          _builder.newLine();
        }
      }
      _builder.append(";");
      _builder.newLine();
      _builder.append("finally {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("getUnorderedGroupHelper().leave(grammarAccess.");
      String _gaRuleElementAccessor_2 = this._grammarAccessExtensions.gaRuleElementAccessor(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
      _builder.append(_gaRuleElementAccessor_2, "\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("restoreStackSize(stackSize);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      CharSequence _ruleImpl = this.ruleImpl(it, grammar, options);
      _builder.append(_ruleImpl);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      CharSequence _ruleImpl_1 = this.ruleImpl(it, grammar, options, 0);
      _builder.append(_ruleImpl_1);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }

  protected CharSequence _compileRule(final Group it, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _ruleImpl = this.ruleImpl(it, grammar, options, 0);
    _builder.append(_ruleImpl);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence ruleImpl(final UnorderedGroup it, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName);
    _builder.append("__");
    String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
    _builder.append(_gaElementIdentifier);
    _builder.append("__Impl");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@init {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int stackSize = keepStackSize();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("boolean selected = false;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append(":");
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
          _builder.appendImmediate("|", "\t\t");
        }
        _builder.append("\t\t");
        _builder.append("( ");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("{getUnorderedGroupHelper().canSelect(grammarAccess.");
        String _gaRuleElementAccessor = this._grammarAccessExtensions.gaRuleElementAccessor(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
        _builder.append(_gaRuleElementAccessor, "\t\t\t");
        _builder.append(", ");
        Integer _key = element.getKey();
        _builder.append(_key, "\t\t\t");
        _builder.append(")}?=>(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("getUnorderedGroupHelper().select(grammarAccess.");
        String _gaRuleElementAccessor_1 = this._grammarAccessExtensions.gaRuleElementAccessor(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
        _builder.append(_gaRuleElementAccessor_1, "\t\t\t\t\t");
        _builder.append(", ");
        Integer _key_1 = element.getKey();
        _builder.append(_key_1, "\t\t\t\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append("selected = true;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append("(");
        _builder.newLine();
        {
          boolean _isMultipleCardinality = GrammarUtil.isMultipleCardinality(element.getValue());
          if (_isMultipleCardinality) {
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("(");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("{ before(grammarAccess.");
            String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(element.getValue()));
            _builder.append(_grammarElementAccess, "\t\t\t\t\t\t");
            _builder.append("); }");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("(");
            String _ebnf2 = this.ebnf2(element.getValue(), options, false);
            _builder.append(_ebnf2, "\t\t\t\t\t\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("{ after(grammarAccess.");
            String _grammarElementAccess_1 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(element.getValue()));
            _builder.append(_grammarElementAccess_1, "\t\t\t\t\t\t");
            _builder.append("); }");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append(")");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("(");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("{ before(grammarAccess.");
            String _grammarElementAccess_2 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(element.getValue()));
            _builder.append(_grammarElementAccess_2, "\t\t\t\t\t\t");
            _builder.append("); }");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("((");
            String _ebnf2_1 = this.ebnf2(element.getValue(), options, false);
            _builder.append(_ebnf2_1, "\t\t\t\t\t\t");
            _builder.append(")=>");
            String _ebnf2_2 = this.ebnf2(element.getValue(), options, false);
            _builder.append(_ebnf2_2, "\t\t\t\t\t\t");
            _builder.append(")*");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("{ after(grammarAccess.");
            String _grammarElementAccess_3 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(element.getValue()));
            _builder.append(_grammarElementAccess_3, "\t\t\t\t\t\t");
            _builder.append("); }");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append(")");
            _builder.newLine();
          } else {
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("{ before(grammarAccess.");
            String _grammarElementAccess_4 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(element.getValue()));
            _builder.append(_grammarElementAccess_4, "\t\t\t\t\t");
            _builder.append("); }");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("(");
            String _ebnf2_3 = this.ebnf2(element.getValue(), options, false);
            _builder.append(_ebnf2_3, "\t\t\t\t\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t\t");
            _builder.append("{ after(grammarAccess.");
            String _grammarElementAccess_5 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(element.getValue()));
            _builder.append(_grammarElementAccess_5, "\t\t\t\t\t");
            _builder.append("); }");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(")");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append(")");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    _builder.append("finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (selected)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getUnorderedGroupHelper().returnFromSelection(grammarAccess.");
    String _gaRuleElementAccessor_2 = this._grammarAccessExtensions.gaRuleElementAccessor(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
    _builder.append(_gaRuleElementAccessor_2, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("restoreStackSize(stackSize);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence ruleImpl(final UnorderedGroup it, final Grammar grammar, final AntlrOptions options, final int index) {
    StringConcatenation _builder = new StringConcatenation();
    String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName);
    _builder.append("__");
    String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
    _builder.append(_gaElementIdentifier);
    _builder.append("__");
    _builder.append(index);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@init {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int stackSize = keepStackSize();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("\t");
    String _contentAssistRuleName_1 = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName_1, "\t");
    _builder.append("__");
    String _gaElementIdentifier_1 = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
    _builder.append(_gaElementIdentifier_1, "\t");
    _builder.append("__Impl");
    _builder.newLineIfNotEmpty();
    {
      int _size = it.getElements().size();
      boolean _greaterThan = (_size > (index + 1));
      if (_greaterThan) {
        _builder.append("\t");
        String _contentAssistRuleName_2 = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
        _builder.append(_contentAssistRuleName_2, "\t");
        _builder.append("__");
        String _gaElementIdentifier_2 = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
        _builder.append(_gaElementIdentifier_2, "\t");
        _builder.append("__");
        _builder.append((index + 1), "\t");
        _builder.append("?");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(";");
    _builder.newLine();
    _builder.append("finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("restoreStackSize(stackSize);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      int _size_1 = it.getElements().size();
      boolean _greaterThan_1 = (_size_1 > (index + 1));
      if (_greaterThan_1) {
        CharSequence _ruleImpl = this.ruleImpl(it, grammar, options, (index + 1));
        _builder.append(_ruleImpl);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  protected CharSequence ruleImpl(final Group it, final Grammar grammar, final AntlrOptions options, final int index) {
    StringConcatenation _builder = new StringConcatenation();
    String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName);
    _builder.append("__");
    String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<Group>getOriginalElement(it));
    _builder.append(_gaElementIdentifier);
    _builder.append("__");
    _builder.append(index);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@init {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int stackSize = keepStackSize();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    _builder.append("\t");
    String _contentAssistRuleName_1 = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName_1, "\t");
    _builder.append("__");
    String _gaElementIdentifier_1 = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<Group>getOriginalElement(it));
    _builder.append(_gaElementIdentifier_1, "\t");
    _builder.append("__");
    _builder.append(index, "\t");
    _builder.append("__Impl");
    _builder.newLineIfNotEmpty();
    {
      int _size = it.getElements().size();
      boolean _greaterThan = (_size > (index + 1));
      if (_greaterThan) {
        _builder.append("\t");
        String _contentAssistRuleName_2 = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
        _builder.append(_contentAssistRuleName_2, "\t");
        _builder.append("__");
        String _gaElementIdentifier_2 = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<Group>getOriginalElement(it));
        _builder.append(_gaElementIdentifier_2, "\t");
        _builder.append("__");
        _builder.append((index + 1), "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(";");
    _builder.newLine();
    _builder.append("finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("restoreStackSize(stackSize);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _contentAssistRuleName_3 = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName_3);
    _builder.append("__");
    String _gaElementIdentifier_3 = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<Group>getOriginalElement(it));
    _builder.append(_gaElementIdentifier_3);
    _builder.append("__");
    _builder.append(index);
    _builder.append("__Impl");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@init {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("int stackSize = keepStackSize();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append(":");
    _builder.newLine();
    String _ebnf = this.ebnf(it.getElements().get(index), options, false);
    _builder.append(_ebnf);
    _builder.newLineIfNotEmpty();
    _builder.append(";");
    _builder.newLine();
    _builder.append("finally {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("restoreStackSize(stackSize);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      int _size_1 = it.getElements().size();
      boolean _greaterThan_1 = (_size_1 > (index + 1));
      if (_greaterThan_1) {
        CharSequence _ruleImpl = this.ruleImpl(it, grammar, options, (index + 1));
        _builder.append(_ruleImpl);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  @Override
  protected String ebnf(final AbstractElement it, final AntlrOptions options, final boolean supportsActions) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((!GrammarUtil.isOptionalCardinality(it)) && GrammarUtil.isMultipleCardinality(it))) {
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("{ before(grammarAccess.");
        String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(it));
        _builder.append(_grammarElementAccess, "\t\t");
        CharSequence _paramConfig = this.paramConfig(it);
        _builder.append(_paramConfig, "\t\t");
        _builder.append("); }");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("(");
        String _ebnf2 = this.ebnf2(it, options, supportsActions);
        _builder.append(_ebnf2, "\t\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("{ after(grammarAccess.");
        String _grammarElementAccess_1 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(it));
        _builder.append(_grammarElementAccess_1, "\t\t");
        CharSequence _paramConfig_1 = this.paramConfig(it);
        _builder.append(_paramConfig_1, "\t\t");
        _builder.append("); }");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("{ before(grammarAccess.");
        String _grammarElementAccess_2 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(it));
        _builder.append(_grammarElementAccess_2, "\t\t");
        CharSequence _paramConfig_2 = this.paramConfig(it);
        _builder.append(_paramConfig_2, "\t\t");
        _builder.append("); }");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("(");
        String _ebnf2_1 = this.ebnf2(it, options, supportsActions);
        _builder.append(_ebnf2_1, "\t\t");
        _builder.append(")*");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("{ after(grammarAccess.");
        String _grammarElementAccess_3 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(it));
        _builder.append(_grammarElementAccess_3, "\t\t");
        CharSequence _paramConfig_3 = this.paramConfig(it);
        _builder.append(_paramConfig_3, "\t\t");
        _builder.append("); }");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append(")");
        _builder.newLine();
      } else {
        _builder.append("(");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{ before(grammarAccess.");
        String _grammarElementAccess_4 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(it));
        _builder.append(_grammarElementAccess_4, "\t");
        CharSequence _paramConfig_4 = this.paramConfig(it);
        _builder.append(_paramConfig_4, "\t");
        _builder.append("); }");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          boolean _mustBeParenthesized = this.mustBeParenthesized(it);
          if (_mustBeParenthesized) {
            _builder.append("(");
            String _ebnf2_2 = this.ebnf2(it, options, supportsActions);
            _builder.append(_ebnf2_2, "\t");
            _builder.append(")");
          } else {
            String _ebnf2_3 = this.ebnf2(it, options, supportsActions);
            _builder.append(_ebnf2_3, "\t");
          }
        }
        String _cardinality = it.getCardinality();
        _builder.append(_cardinality, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("{ after(grammarAccess.");
        String _grammarElementAccess_5 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(it));
        _builder.append(_grammarElementAccess_5, "\t");
        CharSequence _paramConfig_5 = this.paramConfig(it);
        _builder.append(_paramConfig_5, "\t");
        _builder.append("); }");
        _builder.newLineIfNotEmpty();
        _builder.append(")");
        _builder.newLine();
      }
    }
    return _builder.toString();
  }

  protected CharSequence paramConfig(final AbstractElement it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((((GrammarUtil.containingRule(it).getAlternatives() == it) && ParserRule.class.isInstance(GrammarUtil.containingRule(it))) && (!((ParserRule) AntlrGrammarGenUtil.<AbstractRule>getOriginalElement(GrammarUtil.containingRule(it))).getParameters().isEmpty()))) {
        _builder.append(", ");
        AbstractRule _containingRule = GrammarUtil.containingRule(it);
        int _parameterConfig = AntlrGrammarGenUtil.getParameterConfig(((ParserRule) _containingRule));
        _builder.append(_parameterConfig);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  @Override
  protected String _assignmentEbnf(final AbstractElement it, final Assignment assignment, final AntlrOptions options, final boolean supportsActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{ before(grammarAccess.");
    String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(it));
    _builder.append(_grammarElementAccess, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _ebnf = this.ebnf(it, options, supportsActions);
    _builder.append(_ebnf, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{ after(grammarAccess.");
    String _grammarElementAccess_1 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<AbstractElement>getOriginalElement(it));
    _builder.append(_grammarElementAccess_1, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }

  @Override
  protected String _assignmentEbnf(final CrossReference it, final Assignment assignment, final AntlrOptions options, final boolean supportsActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{ before(grammarAccess.");
    String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<CrossReference>getOriginalElement(it));
    _builder.append(_grammarElementAccess, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _crossrefEbnf = this.crossrefEbnf(it.getTerminal(), it, supportsActions);
    _builder.append(_crossrefEbnf, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{ after(grammarAccess.");
    String _grammarElementAccess_1 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<CrossReference>getOriginalElement(it));
    _builder.append(_grammarElementAccess_1, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }

  @Override
  protected String _assignmentEbnf(final Alternatives it, final Assignment assignment, final AntlrOptions options, final boolean supportsActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{ before(grammarAccess.");
    String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<Alternatives>getOriginalElement(it));
    _builder.append(_grammarElementAccess, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(");
    String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName, "\t");
    _builder.append("__");
    String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<Alternatives>getOriginalElement(it));
    _builder.append(_gaElementIdentifier, "\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{ after(grammarAccess.");
    String _grammarElementAccess_1 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<Alternatives>getOriginalElement(it));
    _builder.append(_grammarElementAccess_1, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }

  @Override
  protected String _assignmentEbnf(final RuleCall it, final Assignment assignment, final AntlrOptions options, final boolean supportsActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{ before(grammarAccess.");
    String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<RuleCall>getOriginalElement(it));
    _builder.append(_grammarElementAccess, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _ruleName = this._grammarAccessExtensions.ruleName(it.getRule());
    _builder.append(_ruleName, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{ after(grammarAccess.");
    String _grammarElementAccess_1 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<RuleCall>getOriginalElement(it));
    _builder.append(_grammarElementAccess_1, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }

  @Override
  protected String _crossrefEbnf(final RuleCall it, final CrossReference ref, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{ before(grammarAccess.");
    String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<RuleCall>getOriginalElement(it));
    _builder.append(_grammarElementAccess, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _crossrefEbnf = this.crossrefEbnf(it.getRule(), it, ref, supportActions);
    _builder.append(_crossrefEbnf, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{ after(grammarAccess.");
    String _grammarElementAccess_1 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<RuleCall>getOriginalElement(it));
    _builder.append(_grammarElementAccess_1, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }

  @Override
  protected String _crossrefEbnf(final Keyword it, final CrossReference ref, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{ before(grammarAccess.");
    String _grammarElementAccess = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<Keyword>getOriginalElement(it));
    _builder.append(_grammarElementAccess, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String __crossrefEbnf = super._crossrefEbnf(it, ref, supportActions);
    _builder.append(__crossrefEbnf, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{ after(grammarAccess.");
    String _grammarElementAccess_1 = this._grammarAccessExtensions.grammarElementAccess(AntlrGrammarGenUtil.<Keyword>getOriginalElement(it));
    _builder.append(_grammarElementAccess_1, "\t");
    _builder.append("); }");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }

  protected String _crossrefEbnf(final TerminalRule it, final RuleCall call, final CrossReference ref, final boolean supportActions) {
    return this._grammarAccessExtensions.ruleName(it);
  }

  protected String _crossrefEbnf(final EnumRule it, final RuleCall call, final CrossReference ref, final boolean supportActions) {
    return this._grammarAccessExtensions.ruleName(it);
  }

  protected String _crossrefEbnf(final AbstractRule it, final RuleCall call, final CrossReference ref, final boolean supportActions) {
    boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(AntlrGrammarGenUtil.<AbstractRule>getOriginalElement(it));
    if (_isDatatypeRule) {
      return this._grammarAccessExtensions.ruleName(it);
    }
    String _name = it.getName();
    String _plus = (_name + " is not a datatype rule");
    throw new IllegalArgumentException(_plus);
  }

  @Override
  protected String _ebnf2(final Alternatives it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName);
    _builder.append("__");
    String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<Alternatives>getOriginalElement(it));
    _builder.append(_gaElementIdentifier);
    return _builder.toString();
  }

  @Override
  protected String _ebnf2(final Assignment it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName);
    _builder.append("__");
    String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<Assignment>getOriginalElement(it));
    _builder.append(_gaElementIdentifier);
    return _builder.toString();
  }

  @Override
  protected String _ebnf2(final Group it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName);
    _builder.append("__");
    String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<Group>getOriginalElement(it));
    _builder.append(_gaElementIdentifier);
    _builder.append("__0");
    return _builder.toString();
  }

  @Override
  protected String _ebnf2(final UnorderedGroup it, final AntlrOptions options, final boolean supportActions) {
    StringConcatenation _builder = new StringConcatenation();
    String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(GrammarUtil.containingRule(it));
    _builder.append(_contentAssistRuleName);
    _builder.append("__");
    String _gaElementIdentifier = this._grammarAccessExtensions.gaElementIdentifier(AntlrGrammarGenUtil.<UnorderedGroup>getOriginalElement(it));
    _builder.append(_gaElementIdentifier);
    return _builder.toString();
  }

  @Override
  protected String _ebnf2(final RuleCall it, final AntlrOptions options, final boolean supportActions) {
    return this._grammarAccessExtensions.ruleName(it.getRule());
  }

  @Override
  protected boolean shouldBeSkipped(final TerminalRule it, final Grammar grammar) {
    return false;
  }

  @Override
  protected CharSequence compileRule(final Object it, final Grammar grammar, final AntlrOptions options) {
    if (it instanceof Alternatives) {
      return _compileRule((Alternatives)it, grammar, options);
    } else if (it instanceof Group) {
      return _compileRule((Group)it, grammar, options);
    } else if (it instanceof UnorderedGroup) {
      return _compileRule((UnorderedGroup)it, grammar, options);
    } else if (it instanceof Assignment) {
      return _compileRule((Assignment)it, grammar, options);
    } else if (it instanceof EnumRule) {
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

  @Override
  protected String assignmentEbnf(final AbstractElement it, final Assignment assignment, final AntlrOptions options, final boolean supportsActions) {
    if (it instanceof Alternatives) {
      return _assignmentEbnf((Alternatives)it, assignment, options, supportsActions);
    } else if (it instanceof Group) {
      return _assignmentEbnf((Group)it, assignment, options, supportsActions);
    } else if (it instanceof Action) {
      return _assignmentEbnf((Action)it, assignment, options, supportsActions);
    } else if (it instanceof Assignment) {
      return _assignmentEbnf((Assignment)it, assignment, options, supportsActions);
    } else if (it instanceof CrossReference) {
      return _assignmentEbnf((CrossReference)it, assignment, options, supportsActions);
    } else if (it instanceof RuleCall) {
      return _assignmentEbnf((RuleCall)it, assignment, options, supportsActions);
    } else if (it != null) {
      return _assignmentEbnf(it, assignment, options, supportsActions);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, assignment, options, supportsActions).toString());
    }
  }

  @Override
  protected String crossrefEbnf(final AbstractElement it, final CrossReference ref, final boolean supportActions) {
    if (it instanceof Alternatives) {
      return _crossrefEbnf((Alternatives)it, ref, supportActions);
    } else if (it instanceof Keyword) {
      return _crossrefEbnf((Keyword)it, ref, supportActions);
    } else if (it instanceof RuleCall) {
      return _crossrefEbnf((RuleCall)it, ref, supportActions);
    } else if (it != null) {
      return _crossrefEbnf(it, ref, supportActions);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, ref, supportActions).toString());
    }
  }

  protected String crossrefEbnf(final AbstractRule it, final RuleCall call, final CrossReference ref, final boolean supportActions) {
    if (it instanceof EnumRule) {
      return _crossrefEbnf((EnumRule)it, call, ref, supportActions);
    } else if (it instanceof TerminalRule) {
      return _crossrefEbnf((TerminalRule)it, call, ref, supportActions);
    } else if (it != null) {
      return _crossrefEbnf(it, call, ref, supportActions);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, call, ref, supportActions).toString());
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
}

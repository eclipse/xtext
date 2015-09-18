/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.idea.parser.antlr;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
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
import org.eclipse.xtext.xtext.generator.idea.IdeaPluginClassNames;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGrammarWithActionsGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;

@SuppressWarnings("all")
public class PsiAntlrGrammarGenerator extends AbstractAntlrGrammarWithActionsGenerator {
  @Inject
  @Extension
  private IdeaPluginClassNames _ideaPluginClassNames;
  
  @Override
  protected TypeReference getGrammarClass(final Grammar it) {
    return this._grammarNaming.getGrammarClass(it, "Psi");
  }
  
  @Override
  protected String compileOptions(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("options {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("superClass=AbstractPsiAntlrParser;");
    _builder.newLine();
    {
      boolean _or = false;
      boolean _or_1 = false;
      boolean _isBacktrack = options.isBacktrack();
      if (_isBacktrack) {
        _or_1 = true;
      } else {
        boolean _isMemoize = options.isMemoize();
        _or_1 = _isMemoize;
      }
      if (_or_1) {
        _or = true;
      } else {
        int _k = options.getK();
        boolean _greaterEqualsThan = (_k >= 0);
        _or = _greaterEqualsThan;
      }
      if (_or) {
        {
          boolean _isBacktrack_1 = options.isBacktrack();
          if (_isBacktrack_1) {
            _builder.append("\t");
            _builder.append("backtrack=true;");
            _builder.newLine();
          }
        }
        {
          boolean _isMemoize_1 = options.isMemoize();
          if (_isMemoize_1) {
            _builder.append("\t");
            _builder.append("memoize=true;");
            _builder.newLine();
          }
        }
        {
          int _k_1 = options.getK();
          boolean _greaterEqualsThan_1 = (_k_1 >= 0);
          if (_greaterEqualsThan_1) {
            _builder.append("\t");
            _builder.append("memoize=");
            int _k_2 = options.getK();
            _builder.append(_k_2, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  protected String compileParserImports(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;");
    _builder.newLine();
    _builder.append("import ");
    Grammar _grammar = GrammarUtil.getGrammar(it);
    TypeReference _elementTypeProvider = this._ideaPluginClassNames.getElementTypeProvider(_grammar);
    _builder.append(_elementTypeProvider, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.xtext.idea.parser.TokenTypeProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.parser.antlr.XtextTokenStream;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;");
    _builder.newLine();
    {
      boolean _and = false;
      List<ParserRule> _allParserRules = GrammarUtil.allParserRules(it);
      final Function1<ParserRule, List<EObject>> _function = new Function1<ParserRule, List<EObject>>() {
        @Override
        public List<EObject> apply(final ParserRule it) {
          return EcoreUtil2.eAllContentsAsList(it);
        }
      };
      List<List<EObject>> _map = ListExtensions.<ParserRule, List<EObject>>map(_allParserRules, _function);
      Iterable<EObject> _flatten = Iterables.<EObject>concat(_map);
      Iterable<UnorderedGroup> _filter = Iterables.<UnorderedGroup>filter(_flatten, UnorderedGroup.class);
      boolean _isEmpty = IterableExtensions.isEmpty(_filter);
      boolean _not = (!_isEmpty);
      if (!_not) {
        _and = false;
      } else {
        boolean _isBacktrack = options.isBacktrack();
        _and = _isBacktrack;
      }
      if (_and) {
        _builder.append("import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;");
        _builder.newLine();
      }
    }
    _builder.append("import ");
    TypeReference _grammarAccess = this._grammarAccessExtensions.getGrammarAccess(it);
    String _name = _grammarAccess.getName();
    _builder.append(_name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.lang.PsiBuilder;");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Override
  protected String compileParserMembers(final Grammar it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("@parser::members {");
    _builder.newLine();
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
    _builder.append("\t");
    _builder.append("protected ");
    TypeReference _grammarAccess = this._grammarAccessExtensions.getGrammarAccess(it);
    String _simpleName = _grammarAccess.getSimpleName();
    _builder.append(_simpleName, "\t");
    _builder.append(" grammarAccess;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ");
    Grammar _grammar = GrammarUtil.getGrammar(it);
    TypeReference _elementTypeProvider = this._ideaPluginClassNames.getElementTypeProvider(_grammar);
    String _simpleName_1 = _elementTypeProvider.getSimpleName();
    _builder.append(_simpleName_1, "\t");
    _builder.append(" elementTypeProvider;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    Grammar _grammar_1 = GrammarUtil.getGrammar(it);
    TypeReference _psiInternalParser = this._ideaPluginClassNames.getPsiInternalParser(_grammar_1);
    String _simpleName_2 = _psiInternalParser.getSimpleName();
    _builder.append(_simpleName_2, "\t");
    _builder.append("(PsiBuilder builder, TokenStream input, ");
    Grammar _grammar_2 = GrammarUtil.getGrammar(it);
    TypeReference _elementTypeProvider_1 = this._ideaPluginClassNames.getElementTypeProvider(_grammar_2);
    String _simpleName_3 = _elementTypeProvider_1.getSimpleName();
    _builder.append(_simpleName_3, "\t");
    _builder.append(" elementTypeProvider, ");
    TypeReference _grammarAccess_1 = this._grammarAccessExtensions.getGrammarAccess(it);
    String _simpleName_4 = _grammarAccess_1.getSimpleName();
    _builder.append(_simpleName_4, "\t");
    _builder.append(" grammarAccess) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this(input);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setPsiBuilder(builder);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("this.grammarAccess = grammarAccess;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.elementTypeProvider = elementTypeProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected String getFirstRuleName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"");
    List<ParserRule> _allParserRules = GrammarUtil.allParserRules(it);
    ParserRule _head = IterableExtensions.<ParserRule>head(_allParserRules);
    EObject _originalElement = AntlrGrammarGenUtil.getOriginalElement(_head);
    String _name = ((AbstractRule) _originalElement).getName();
    _builder.append(_name, "\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
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
  protected String compileRule(final ParserRule it, final Grammar grammar, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isValidEntryRule = AntlrGrammarGenUtil.isValidEntryRule(it);
      if (_isValidEntryRule) {
        _builder.append("//Entry rule ");
        String _entryRuleName = this._grammarAccessExtensions.entryRuleName(it);
        _builder.append(_entryRuleName, "");
        _builder.newLineIfNotEmpty();
        String _entryRuleName_1 = this._grammarAccessExtensions.entryRuleName(it);
        _builder.append(_entryRuleName_1, "");
        CharSequence _compileEntryInit = this.compileEntryInit(it, options);
        _builder.append(_compileEntryInit, "");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("{ ");
        CharSequence _markComposite = this.markComposite(it);
        _builder.append(_markComposite, "\t");
        _builder.append(" }");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _ruleName = this._grammarAccessExtensions.ruleName(it);
        _builder.append(_ruleName, "\t");
        String _defaultArgumentList = AntlrGrammarGenUtil.getDefaultArgumentList(it);
        _builder.append(_defaultArgumentList, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("EOF;");
        _builder.newLine();
        CharSequence _compileEntryFinally = this.compileEntryFinally(it, options);
        _builder.append(_compileEntryFinally, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    String _compileEBNF = this.compileEBNF(it, options);
    _builder.append(_compileEBNF, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  @Override
  protected String compileInit(final AbstractRule it, final AntlrOptions options) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((it instanceof ParserRule)) {
        boolean _isPassCurrentIntoFragment = this.isPassCurrentIntoFragment();
        boolean _not = (!_isPassCurrentIntoFragment);
        String _parameterList = AntlrGrammarGenUtil.getParameterList(((ParserRule)it), Boolean.valueOf(_not));
        _builder.append(_parameterList, "");
      }
    }
    _builder.newLineIfNotEmpty();
    String _compileInit = super.compileInit(it, options);
    _builder.append(_compileInit, "");
    return _builder.toString();
  }
  
  @Override
  protected String _dataTypeEbnf2(final Keyword it, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _markLeaf = this.markLeaf(it);
      _builder.append(_markLeaf, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.append("kw=");
      String __dataTypeEbnf2 = super._dataTypeEbnf2(it, supportActions);
      _builder.append(__dataTypeEbnf2, "");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _doneLeaf = this.doneLeaf(it, "kw");
      _builder.append(_doneLeaf, "\t");
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
      if (!_matched) {
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
          CharSequence _markComposite = this.markComposite(it);
          _builder.append(_markComposite, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          String __dataTypeEbnf2 = super._dataTypeEbnf2(it, supportActions);
          _builder.append(__dataTypeEbnf2, "");
          _builder.newLineIfNotEmpty();
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          CharSequence _doneComposite = this.doneComposite(it);
          _builder.append(_doneComposite, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          _switchResult = _builder.toString();
        }
      }
      if (!_matched) {
        if (_rule instanceof TerminalRule) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          CharSequence _markLeaf = this.markLeaf(it);
          _builder_1.append(_markLeaf, "\t");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          String _localVar = this._grammarAccessExtensions.localVar(it);
          _builder_1.append(_localVar, "");
          _builder_1.append("=");
          String __dataTypeEbnf2_1 = super._dataTypeEbnf2(it, supportActions);
          _builder_1.append(__dataTypeEbnf2_1, "");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          String _localVar_1 = this._grammarAccessExtensions.localVar(it);
          CharSequence _doneLeaf = this.doneLeaf(it, _localVar_1);
          _builder_1.append(_doneLeaf, "\t");
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
    if ((!supportActions)) {
      return super._ebnf2(it, options, supportActions);
    } else {
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
      CharSequence _precedeComposite = this.precedeComposite(it);
      _builder.append(_precedeComposite, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CharSequence _doneComposite = this.doneComposite(it);
      _builder.append(_doneComposite, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xifexpression = _builder.toString();
    }
    return _xifexpression;
  }
  
  @Override
  protected String _ebnf2(final Keyword it, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    if ((!supportActions)) {
      return super._ebnf2(it, options, supportActions);
    } else {
      String _xifexpression_1 = null;
      boolean _isAssigned = GrammarUtil.isAssigned(it);
      if (_isAssigned) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _markLeaf = this.markLeaf(it);
        _builder.append(_markLeaf, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        Assignment _containingAssignment = GrammarUtil.containingAssignment(it);
        String _localVar = this._grammarAccessExtensions.localVar(_containingAssignment, it);
        _builder.append(_localVar, "");
        _builder.append("=");
        String __ebnf2 = super._ebnf2(it, options, supportActions);
        _builder.append(__ebnf2, "");
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        Assignment _containingAssignment_1 = GrammarUtil.containingAssignment(it);
        String _localVar_1 = this._grammarAccessExtensions.localVar(_containingAssignment_1, it);
        CharSequence _doneLeaf = this.doneLeaf(it, _localVar_1);
        _builder.append(_doneLeaf, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _xifexpression_1 = _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("\t");
        CharSequence _markLeaf_1 = this.markLeaf(it);
        _builder_1.append(_markLeaf_1, "\t");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("}");
        _builder_1.newLine();
        String _localVar_2 = this._grammarAccessExtensions.localVar(it);
        _builder_1.append(_localVar_2, "");
        _builder_1.append("=");
        String __ebnf2_1 = super._ebnf2(it, options, supportActions);
        _builder_1.append(__ebnf2_1, "");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("\t");
        String _localVar_3 = this._grammarAccessExtensions.localVar(it);
        CharSequence _doneLeaf_1 = this.doneLeaf(it, _localVar_3);
        _builder_1.append(_doneLeaf_1, "\t");
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
      return super._ebnf2(it, options, supportActions);
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _markLeaf = this.markLeaf(it);
      _builder.append(_markLeaf, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      String _localVar = this._grammarAccessExtensions.localVar(it);
      _builder.append(_localVar, "");
      _builder.append("=");
      String __ebnf2 = super._ebnf2(it, options, supportActions);
      _builder.append(__ebnf2, "");
      _builder.newLineIfNotEmpty();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      String _localVar_1 = this._grammarAccessExtensions.localVar(it);
      CharSequence _doneLeaf = this.doneLeaf(it, _localVar_1);
      _builder.append(_doneLeaf, "\t");
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
    if (supportActions) {
      String _switchResult = null;
      AbstractRule _rule = it.getRule();
      boolean _matched = false;
      if (!_matched) {
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
          _switchResult = super._ebnf2(it, options, supportActions);
        }
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
          CharSequence _markComposite = this.markComposite(it);
          _builder.append(_markComposite, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          String __ebnf2 = super._ebnf2(it, options, supportActions);
          _builder.append(__ebnf2, "");
          _builder.newLineIfNotEmpty();
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          CharSequence _doneComposite = this.doneComposite(it);
          _builder.append(_doneComposite, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          _switchResult = _builder.toString();
        }
      }
      if (!_matched) {
        if (_rule instanceof TerminalRule) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          CharSequence _markLeaf = this.markLeaf(it);
          _builder_1.append(_markLeaf, "\t");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          String _localVar = this._grammarAccessExtensions.localVar(it);
          _builder_1.append(_localVar, "");
          _builder_1.append("=");
          String __ebnf2_1 = super._ebnf2(it, options, supportActions);
          _builder_1.append(__ebnf2_1, "");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          String _localVar_1 = this._grammarAccessExtensions.localVar(it);
          CharSequence _doneLeaf = this.doneLeaf(it, _localVar_1);
          _builder_1.append(_doneLeaf, "\t");
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
    } else {
      _xifexpression = super._ebnf2(it, options, supportActions);
    }
    return _xifexpression;
  }
  
  @Override
  protected String crossrefEbnf(final AbstractRule it, final RuleCall call, final CrossReference ref, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
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
          CharSequence _markComposite = this.markComposite(ref);
          _builder.append(_markComposite, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          String _crossrefEbnf = super.crossrefEbnf(it, call, ref, supportActions);
          _builder.append(_crossrefEbnf, "");
          _builder.newLineIfNotEmpty();
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          CharSequence _doneComposite = this.doneComposite(ref);
          _builder.append(_doneComposite, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          _switchResult = _builder.toString();
        }
      }
      if (!_matched) {
        if (it instanceof TerminalRule) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          CharSequence _markLeaf = this.markLeaf(ref);
          _builder_1.append(_markLeaf, "\t");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          Assignment _containingAssignment = GrammarUtil.containingAssignment(ref);
          String _localVar = this._grammarAccessExtensions.localVar(_containingAssignment);
          _builder_1.append(_localVar, "");
          _builder_1.append("=");
          String _crossrefEbnf_1 = super.crossrefEbnf(it, call, ref, supportActions);
          _builder_1.append(_crossrefEbnf_1, "");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          Assignment _containingAssignment_1 = GrammarUtil.containingAssignment(ref);
          String _localVar_1 = this._grammarAccessExtensions.localVar(_containingAssignment_1);
          CharSequence _doneLeaf = this.doneLeaf(ref, _localVar_1);
          _builder_1.append(_doneLeaf, "\t");
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
  protected String _assignmentEbnf(final RuleCall it, final Assignment assignment, final AntlrOptions options, final boolean supportActions) {
    String _xifexpression = null;
    if (supportActions) {
      String _switchResult = null;
      AbstractRule _rule = it.getRule();
      boolean _matched = false;
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
          CharSequence _markComposite = this.markComposite(it);
          _builder.append(_markComposite, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          String _localVar = this._grammarAccessExtensions.localVar(assignment, it);
          _builder.append(_localVar, "");
          _builder.append("=");
          String __assignmentEbnf = super._assignmentEbnf(it, assignment, options, supportActions);
          _builder.append(__assignmentEbnf, "");
          _builder.newLineIfNotEmpty();
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          CharSequence _doneComposite = this.doneComposite(it);
          _builder.append(_doneComposite, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
          _switchResult = _builder.toString();
        }
      }
      if (!_matched) {
        if (_rule instanceof TerminalRule) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          CharSequence _markLeaf = this.markLeaf(it);
          _builder_1.append(_markLeaf, "\t");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("}");
          _builder_1.newLine();
          String _localVar_1 = this._grammarAccessExtensions.localVar(assignment, it);
          _builder_1.append(_localVar_1, "");
          _builder_1.append("=");
          String __assignmentEbnf_1 = super._assignmentEbnf(it, assignment, options, supportActions);
          _builder_1.append(__assignmentEbnf_1, "");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("{");
          _builder_1.newLine();
          _builder_1.append("\t");
          String _localVar_2 = this._grammarAccessExtensions.localVar(assignment, it);
          CharSequence _doneLeaf = this.doneLeaf(it, _localVar_2);
          _builder_1.append(_doneLeaf, "\t");
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
  
  protected CharSequence markLeaf(final EObject it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("markLeaf(elementTypeProvider.get");
    EObject _originalElement = AntlrGrammarGenUtil.getOriginalElement(it);
    String _grammarElementIdentifier = this._grammarAccessExtensions.grammarElementIdentifier(_originalElement);
    _builder.append(_grammarElementIdentifier, "");
    _builder.append("ElementType());");
    return _builder;
  }
  
  protected CharSequence doneLeaf(final EObject it, final String token) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("doneLeaf(");
    _builder.append(token, "");
    _builder.append(");");
    return _builder;
  }
  
  protected CharSequence markComposite(final EObject it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("markComposite(elementTypeProvider.get");
    EObject _originalElement = AntlrGrammarGenUtil.getOriginalElement(it);
    String _grammarElementIdentifier = this._grammarAccessExtensions.grammarElementIdentifier(_originalElement);
    _builder.append(_grammarElementIdentifier, "");
    _builder.append("ElementType());");
    return _builder;
  }
  
  protected CharSequence doneComposite(final EObject it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("doneComposite();");
    return _builder;
  }
  
  protected CharSequence precedeComposite(final EObject it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("precedeComposite(elementTypeProvider.get");
    EObject _originalElement = AntlrGrammarGenUtil.getOriginalElement(it);
    String _grammarElementIdentifier = this._grammarAccessExtensions.grammarElementIdentifier(_originalElement);
    _builder.append(_grammarElementIdentifier, "");
    _builder.append("ElementType());");
    return _builder;
  }
}

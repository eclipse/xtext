/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.parser;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class JFlexGeneratorFragmentTemplate {
  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions = new GrammarAccessExtensions();

  public String toJavaPackage(final String name) {
    String _xblockexpression = null;
    {
      final String result = name.substring(0, name.lastIndexOf("."));
      _xblockexpression = result;
    }
    return _xblockexpression;
  }

  public String generateFlexer(final Grammar it, final String parserName, final String macros, final String rules, final CodeConfig c) {
    StringConcatenation _builder = new StringConcatenation();
    String _fileHeader = c.getFileHeader();
    _builder.append(_fileHeader);
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _javaPackage = this.toJavaPackage(parserName);
    _builder.append(_javaPackage);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import static ");
    _builder.append(parserName);
    _builder.append(".*;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.antlr.runtime.Token;");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.CommonToken;");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.TokenSource;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings({\"all\"})");
    _builder.newLine();
    _builder.append("%%");
    _builder.newLine();
    _builder.newLine();
    _builder.append("%{");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public InternalXtendFlexer() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this((java.io.Reader)null);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public int getTokenLength() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return yylength();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public String getTokenText() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return yytext();");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("%}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("%unicode");
    _builder.newLine();
    _builder.append("%implements org.eclipse.xtend.core.parser.InternalFlexer");
    _builder.newLine();
    _builder.append("%class InternalXtendFlexer");
    _builder.newLine();
    _builder.append("%function advance");
    _builder.newLine();
    _builder.append("%int");
    _builder.newLine();
    _builder.append("%eofval{");
    _builder.newLine();
    _builder.append("return Token.EOF;");
    _builder.newLine();
    _builder.append("%eofval}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append(macros);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("%%");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _kens = this.tokens(it);
    _builder.append(_kens);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    {
      if ((rules != null)) {
        _builder.append(rules);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.newLine();
    {
      final Function1<TerminalRule, Boolean> _function = (TerminalRule r) -> {
        boolean _isFragment = r.isFragment();
        return Boolean.valueOf((!_isFragment));
      };
      Iterable<TerminalRule> _filter = IterableExtensions.<TerminalRule>filter(GrammarUtil.allTerminalRules(it), _function);
      for(final TerminalRule rule : _filter) {
        _builder.append("<YYINITIAL> {");
        String _name = rule.getName();
        _builder.append(_name);
        _builder.append("} { return RULE_");
        String _name_1 = rule.getName();
        _builder.append(_name_1);
        _builder.append("; }");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    return _builder.toString();
  }

  public String tokens(final Grammar it) {
    ArrayList<String> allKeywords = CollectionLiterals.<String>newArrayList();
    List<ParserRule> _allParserRules = GrammarUtil.allParserRules(it);
    for (final ParserRule r : _allParserRules) {
      this.collectTokens(r, allKeywords);
    }
    List<EnumRule> _allEnumRules = GrammarUtil.allEnumRules(it);
    for (final EnumRule r_1 : _allEnumRules) {
      this.collectTokens(r_1, allKeywords);
    }
    StringConcatenation _builder = new StringConcatenation();
    {
      List<String> _sort = IterableExtensions.<String>sort(allKeywords);
      for(final String k : _sort) {
        CharSequence _state = this.state(k);
        _builder.append(_state);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }

  public CharSequence state(final String it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<YYINITIAL> \"");
    String _antlrString = AntlrGrammarGenUtil.toAntlrString(it);
    _builder.append(_antlrString);
    _builder.append("\" { return KW_");
    String _javaIdentifier = this._grammarAccessExtensions.toJavaIdentifier(it, true);
    _builder.append(_javaIdentifier);
    _builder.append("; }");
    return _builder;
  }

  protected void _collectTokens(final AbstractRule it, final List<String> known) {
    this.collectTokens(it.getAlternatives(), known);
  }

  protected void _collectTokens(final Keyword it, final List<String> known) {
    boolean _and = false;
    boolean _contains = known.contains(it.getValue());
    boolean _not = (!_contains);
    if (!_not) {
      _and = false;
    } else {
      boolean _add = known.add(it.getValue());
      _and = _add;
    }
  }

  protected void _collectTokens(final EObject it, final List<String> known) {
    EList<EObject> _eContents = it.eContents();
    for (final EObject e : _eContents) {
      this.collectTokens(e, known);
    }
  }

  public void collectTokens(final EObject it, final List<String> known) {
    if (it instanceof Keyword) {
      _collectTokens((Keyword)it, known);
      return;
    } else if (it instanceof AbstractRule) {
      _collectTokens((AbstractRule)it, known);
      return;
    } else if (it != null) {
      _collectTokens(it, known);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, known).toString());
    }
  }
}

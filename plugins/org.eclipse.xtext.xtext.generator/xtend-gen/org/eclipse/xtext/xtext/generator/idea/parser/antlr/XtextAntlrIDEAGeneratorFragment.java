/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.idea.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.ISubProjectConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiAntlrGrammarGenerator;
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiGrammarNaming;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammar;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrToolFacade;

@SuppressWarnings("all")
public class XtextAntlrIDEAGeneratorFragment extends AbstractAntlrGeneratorFragment2 {
  @Inject
  private PsiAntlrGrammarGenerator generator;
  
  @Inject
  @Extension
  private PsiGrammarNaming _psiGrammarNaming;
  
  @Override
  protected void doGenerate() {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    ISubProjectConfig _ideaPlugin = _projectConfig.getIdeaPlugin();
    final IXtextGeneratorFileSystemAccess fsa = _ideaPlugin.getSrcGen();
    Grammar _grammar = this.getGrammar();
    AntlrOptions _options = this.getOptions();
    this.generator.generate(_grammar, _options, fsa);
    CodeConfig _codeConfig = this.getCodeConfig();
    final String encoding = _codeConfig.getEncoding();
    Grammar _grammar_1 = this.getGrammar();
    AntlrGrammar _parserGrammar = this._psiGrammarNaming.getParserGrammar(_grammar_1);
    final String grammarFileName = _parserGrammar.getGrammarFileName();
    StringConcatenation _builder = new StringConcatenation();
    String _path = fsa.getPath();
    _builder.append(_path, "");
    _builder.append("/");
    _builder.append(grammarFileName, "");
    final String absoluteGrammarFileName = _builder.toString();
    this.addAntlrParam("-fo");
    int _lastIndexOf = absoluteGrammarFileName.lastIndexOf("/");
    String _substring = absoluteGrammarFileName.substring(0, _lastIndexOf);
    this.addAntlrParam(_substring);
    AntlrToolFacade _antlrTool = this.getAntlrTool();
    String[] _antlrParams = this.getAntlrParams();
    _antlrTool.runWithEncodingAndParams(absoluteGrammarFileName, encoding, _antlrParams);
    Grammar _grammar_2 = this.getGrammar();
    Grammar _grammar_3 = this.getGrammar();
    TypeReference _internalParserClass = this._psiGrammarNaming.getInternalParserClass(_grammar_3);
    this.simplifyUnorderedGroupPredicatesIfRequired(_grammar_2, fsa, _internalParserClass);
    Grammar _grammar_4 = this.getGrammar();
    TypeReference _lexerClass = this._psiGrammarNaming.getLexerClass(_grammar_4);
    Grammar _grammar_5 = this.getGrammar();
    TypeReference _internalParserClass_1 = this._psiGrammarNaming.getInternalParserClass(_grammar_5);
    this.splitParserAndLexerIfEnabled(fsa, _lexerClass, _internalParserClass_1);
    Grammar _grammar_6 = this.getGrammar();
    AntlrGrammar _lexerGrammar = this._psiGrammarNaming.getLexerGrammar(_grammar_6);
    String _tokensFileName = _lexerGrammar.getTokensFileName();
    this.normalizeTokens(fsa, _tokensFileName);
    Grammar _grammar_7 = this.getGrammar();
    TypeReference _internalParserClass_2 = this._psiGrammarNaming.getInternalParserClass(_grammar_7);
    Grammar _grammar_8 = this.getGrammar();
    TypeReference _lexerClass_1 = this._psiGrammarNaming.getLexerClass(_grammar_8);
    this.suppressWarnings(fsa, _internalParserClass_2, _lexerClass_1);
    Grammar _grammar_9 = this.getGrammar();
    TypeReference _internalParserClass_3 = this._psiGrammarNaming.getInternalParserClass(_grammar_9);
    Grammar _grammar_10 = this.getGrammar();
    TypeReference _lexerClass_2 = this._psiGrammarNaming.getLexerClass(_grammar_10);
    this.normalizeLineDelimiters(fsa, _internalParserClass_3, _lexerClass_2);
  }
}

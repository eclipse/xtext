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
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiAntlrGrammarGenerator;
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiGrammarNaming;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.project.ISubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
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
    boolean _isEnabled = _ideaPlugin.isEnabled();
    boolean _not = (!_isEnabled);
    if (_not) {
      return;
    }
    IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
    ISubProjectConfig _ideaPlugin_1 = _projectConfig_1.getIdeaPlugin();
    final IXtextGeneratorFileSystemAccess fsa = _ideaPlugin_1.getSrcGen();
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
    _builder.append(_path);
    _builder.append("/");
    _builder.append(grammarFileName);
    final String absoluteGrammarFileName = _builder.toString();
    this.addAntlrParam("-fo");
    this.addAntlrParam(absoluteGrammarFileName.substring(0, absoluteGrammarFileName.lastIndexOf("/")));
    AntlrToolFacade _antlrTool = this.getAntlrTool();
    String[] _antlrParams = this.getAntlrParams();
    _antlrTool.runWithEncodingAndParams(absoluteGrammarFileName, encoding, _antlrParams);
    this.simplifyUnorderedGroupPredicatesIfRequired(this.getGrammar(), fsa, this._psiGrammarNaming.getInternalParserClass(this.getGrammar()));
    this.splitParserAndLexerIfEnabled(fsa, this._psiGrammarNaming.getInternalParserClass(this.getGrammar()), this._psiGrammarNaming.getLexerClass(this.getGrammar()));
    this.normalizeTokens(fsa, this._psiGrammarNaming.getLexerGrammar(this.getGrammar()).getTokensFileName());
    this.suppressWarnings(fsa, this._psiGrammarNaming.getInternalParserClass(this.getGrammar()), this._psiGrammarNaming.getLexerClass(this.getGrammar()));
    this.normalizeLineDelimiters(fsa, this._psiGrammarNaming.getInternalParserClass(this.getGrammar()), this._psiGrammarNaming.getLexerClass(this.getGrammar()));
  }
}

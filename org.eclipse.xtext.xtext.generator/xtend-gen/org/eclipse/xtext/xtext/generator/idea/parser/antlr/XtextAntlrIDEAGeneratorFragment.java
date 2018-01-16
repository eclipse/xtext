/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.idea.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiAntlrGrammarGenerator;
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiGrammarNaming;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment2;

@SuppressWarnings("all")
public class XtextAntlrIDEAGeneratorFragment extends AbstractAntlrGeneratorFragment2 {
  @Inject
  private PsiAntlrGrammarGenerator generator;
  
  @Inject
  @Extension
  private PsiGrammarNaming _psiGrammarNaming;
  
  @Override
  protected void doGenerate() {
    boolean _isEnabled = this.getProjectConfig().getIdeaPlugin().isEnabled();
    boolean _not = (!_isEnabled);
    if (_not) {
      return;
    }
    final IXtextGeneratorFileSystemAccess fsa = this.getProjectConfig().getIdeaPlugin().getSrcGen();
    this.generator.generate(this.getGrammar(), this.getOptions(), fsa);
    final String encoding = this.getCodeConfig().getEncoding();
    final String grammarFileName = this._psiGrammarNaming.getParserGrammar(this.getGrammar()).getGrammarFileName();
    StringConcatenation _builder = new StringConcatenation();
    String _path = fsa.getPath();
    _builder.append(_path);
    _builder.append("/");
    _builder.append(grammarFileName);
    final String absoluteGrammarFileName = _builder.toString();
    this.addAntlrParam("-fo");
    this.addAntlrParam(absoluteGrammarFileName.substring(0, absoluteGrammarFileName.lastIndexOf("/")));
    this.getAntlrTool().runWithEncodingAndParams(absoluteGrammarFileName, encoding, this.getAntlrParams());
    this.simplifyUnorderedGroupPredicatesIfRequired(this.getGrammar(), fsa, this._psiGrammarNaming.getInternalParserClass(this.getGrammar()));
    this.splitParserAndLexerIfEnabled(fsa, this._psiGrammarNaming.getInternalParserClass(this.getGrammar()), this._psiGrammarNaming.getLexerClass(this.getGrammar()));
    this.normalizeTokens(fsa, this._psiGrammarNaming.getLexerGrammar(this.getGrammar()).getTokensFileName());
    this.suppressWarnings(fsa, this._psiGrammarNaming.getInternalParserClass(this.getGrammar()), this._psiGrammarNaming.getLexerClass(this.getGrammar()));
    this.normalizeLineDelimiters(fsa, this._psiGrammarNaming.getInternalParserClass(this.getGrammar()), this._psiGrammarNaming.getLexerClass(this.getGrammar()));
  }
}

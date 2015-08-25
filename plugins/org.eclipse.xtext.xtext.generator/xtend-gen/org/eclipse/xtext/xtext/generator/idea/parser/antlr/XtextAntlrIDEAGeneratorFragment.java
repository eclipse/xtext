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
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiAntlrGrammarGenerator;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrToolFacade;

@SuppressWarnings("all")
public class XtextAntlrIDEAGeneratorFragment extends AbstractAntlrGeneratorFragment2 {
  @Inject
  @Extension
  private PsiAntlrGrammarGenerator _psiAntlrGrammarGenerator;
  
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  private IXtextProjectConfig projectConfig;
  
  @Override
  protected void doGenerate() {
    final IXtextGeneratorFileSystemAccess fsa = this.projectConfig.getIdeaPluginSrcGen();
    Grammar _grammar = this.getGrammar();
    AntlrOptions _options = this.getOptions();
    this._psiAntlrGrammarGenerator.generate(_grammar, _options, fsa);
    final String encoding = this.codeConfig.getEncoding();
    StringConcatenation _builder = new StringConcatenation();
    Grammar _grammar_1 = this.getGrammar();
    TypeReference _grammarClass = this._psiAntlrGrammarGenerator.getGrammarClass(_grammar_1);
    String _path = _grammarClass.getPath();
    _builder.append(_path, "");
    _builder.append(".g");
    final String grammarFileName = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _path_1 = fsa.getPath();
    _builder_1.append(_path_1, "");
    _builder_1.append("/");
    _builder_1.append(grammarFileName, "");
    final String absoluteGrammarFileName = _builder_1.toString();
    this.addAntlrParam("-fo");
    int _lastIndexOf = absoluteGrammarFileName.lastIndexOf("/");
    String _substring = absoluteGrammarFileName.substring(0, _lastIndexOf);
    this.addAntlrParam(_substring);
    AntlrToolFacade _antlrTool = this.getAntlrTool();
    String[] _antlrParams = this.getAntlrParams();
    _antlrTool.runWithEncodingAndParams(absoluteGrammarFileName, encoding, _antlrParams);
    Grammar _grammar_2 = this.getGrammar();
    this.simplifyUnorderedGroupPredicatesIfRequired(_grammar_2, fsa, grammarFileName);
    this.splitParserAndLexerIfEnabled(fsa, grammarFileName);
    this.suppressWarnings(fsa, grammarFileName);
    this.normalizeLineDelimiters(fsa, grammarFileName);
    this.normalizeTokens(fsa, grammarFileName);
  }
}

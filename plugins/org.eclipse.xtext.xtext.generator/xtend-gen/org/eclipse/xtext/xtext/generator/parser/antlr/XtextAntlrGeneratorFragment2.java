/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Names;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;
import org.eclipse.xtext.conversion.impl.IgnoreCaseIDValueConverter;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ITokenToStringConverter;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.AbstractIndentationTokenSource;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.parser.antlr.LexerProvider;
import org.eclipse.xtext.parser.antlr.UnorderedGroupHelper;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.IgnoreCaseKeywordSerializer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.project.IBundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrContentAssistGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrDebugGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammar;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrToolFacade;
import org.eclipse.xtext.xtext.generator.parser.antlr.CombinedGrammarMarker;
import org.eclipse.xtext.xtext.generator.parser.antlr.ContentAssistGrammarNaming;
import org.eclipse.xtext.xtext.generator.parser.antlr.GrammarNaming;
import org.eclipse.xtext.xtext.generator.parser.antlr.KeywordHelper;
import org.eclipse.xtext.xtext.generator.util.SyntheticTerminalDetector;

@SuppressWarnings("all")
public class XtextAntlrGeneratorFragment2 extends AbstractAntlrGeneratorFragment2 {
  @Accessors
  private boolean debugGrammar;
  
  @Accessors
  private Boolean combinedGrammar = null;
  
  @Accessors
  private boolean removeBacktrackingGuards;
  
  private int lookaheadThreshold;
  
  @Accessors
  private boolean partialParsing;
  
  @Inject
  private AntlrGrammarGenerator productionGenerator;
  
  @Inject
  private AntlrContentAssistGrammarGenerator contentAssistGenerator;
  
  @Inject
  private AntlrDebugGrammarGenerator debugGenerator;
  
  @Inject
  private FileAccessFactory fileFactory;
  
  @Inject
  private GrammarNaming productionNaming;
  
  @Inject
  private ContentAssistGrammarNaming contentAssistNaming;
  
  @Inject
  @Extension
  private GrammarAccessExtensions grammarUtil;
  
  @Inject
  @Extension
  private SyntheticTerminalDetector _syntheticTerminalDetector;
  
  @Override
  protected void doGenerate() {
    Grammar _grammar = this.getGrammar();
    AntlrOptions _options = this.getOptions();
    boolean _isIgnoreCase = _options.isIgnoreCase();
    new KeywordHelper(_grammar, _isIgnoreCase, this.grammarUtil);
    boolean _isCombinedGrammar = this.isCombinedGrammar();
    CombinedGrammarMarker _combinedGrammarMarker = new CombinedGrammarMarker(_isCombinedGrammar);
    Grammar _grammar_1 = this.getGrammar();
    _combinedGrammarMarker.attachToEmfObject(_grammar_1);
    if (this.debugGrammar) {
      this.generateDebugGrammar();
    }
    this.generateProductionGrammar();
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _genericIde = _projectConfig.getGenericIde();
    IXtextGeneratorFileSystemAccess _srcGen = _genericIde.getSrcGen();
    boolean _notEquals = (!Objects.equal(_srcGen, null));
    if (_notEquals) {
      this.generateContentAssistGrammar();
    }
    JavaFileAccess _generateProductionParser = this.generateProductionParser();
    IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig_1.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen_1 = _runtime.getSrcGen();
    _generateProductionParser.writeTo(_srcGen_1);
    JavaFileAccess _generateAntlrTokenFileProvider = this.generateAntlrTokenFileProvider();
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    IRuntimeProjectConfig _runtime_1 = _projectConfig_2.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen_2 = _runtime_1.getSrcGen();
    _generateAntlrTokenFileProvider.writeTo(_srcGen_2);
    JavaFileAccess _generateContentAssistParser = this.generateContentAssistParser();
    IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
    IBundleProjectConfig _genericIde_1 = _projectConfig_3.getGenericIde();
    IXtextGeneratorFileSystemAccess _srcGen_3 = _genericIde_1.getSrcGen();
    _generateContentAssistParser.writeTo(_srcGen_3);
    boolean _and = false;
    boolean _isCombinedGrammar_1 = this.isCombinedGrammar();
    boolean _not = (!_isCombinedGrammar_1);
    if (!_not) {
      _and = false;
    } else {
      Grammar _grammar_2 = this.getGrammar();
      List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(_grammar_2);
      final Function1<TerminalRule, Boolean> _function = new Function1<TerminalRule, Boolean>() {
        @Override
        public Boolean apply(final TerminalRule it) {
          return Boolean.valueOf(XtextAntlrGeneratorFragment2.this._syntheticTerminalDetector.isSyntheticTerminalRule(it));
        }
      };
      boolean _exists = IterableExtensions.<TerminalRule>exists(_allTerminalRules, _function);
      _and = _exists;
    }
    if (_and) {
      JavaFileAccess _generateProductionTokenSource = this.generateProductionTokenSource();
      IXtextProjectConfig _projectConfig_4 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_2 = _projectConfig_4.getRuntime();
      IXtextGeneratorFileSystemAccess _srcGen_4 = _runtime_2.getSrcGen();
      _generateProductionTokenSource.writeTo(_srcGen_4);
      JavaFileAccess _generateContentAssistTokenSource = this.generateContentAssistTokenSource();
      IXtextProjectConfig _projectConfig_5 = this.getProjectConfig();
      IBundleProjectConfig _genericIde_2 = _projectConfig_5.getGenericIde();
      IXtextGeneratorFileSystemAccess _srcGen_5 = _genericIde_2.getSrcGen();
      _generateContentAssistTokenSource.writeTo(_srcGen_5);
    }
    this.addRuntimeBindingsAndImports();
    this.addUiBindingsAndImports();
  }
  
  public void setLookaheadThreshold(final String lookaheadThreshold) {
    int _parseInt = Integer.parseInt(lookaheadThreshold);
    this.lookaheadThreshold = _parseInt;
  }
  
  protected void generateProductionGrammar() {
    @Extension
    final GrammarNaming naming = this.productionNaming;
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    final IXtextGeneratorFileSystemAccess fsa = _runtime.getSrcGen();
    Grammar _grammar = this.getGrammar();
    AntlrOptions _options = this.getOptions();
    this.productionGenerator.generate(_grammar, _options, fsa);
    Grammar _grammar_1 = this.getGrammar();
    AntlrGrammar _parserGrammar = naming.getParserGrammar(_grammar_1);
    Grammar _grammar_2 = this.getGrammar();
    AntlrGrammar _lexerGrammar = naming.getLexerGrammar(_grammar_2);
    this.runAntlr(_parserGrammar, _lexerGrammar, fsa);
    Grammar _grammar_3 = this.getGrammar();
    Grammar _grammar_4 = this.getGrammar();
    TypeReference _internalParserClass = naming.getInternalParserClass(_grammar_4);
    this.simplifyUnorderedGroupPredicatesIfRequired(_grammar_3, fsa, _internalParserClass);
    Grammar _grammar_5 = this.getGrammar();
    TypeReference _internalParserClass_1 = naming.getInternalParserClass(_grammar_5);
    Grammar _grammar_6 = this.getGrammar();
    TypeReference _lexerClass = naming.getLexerClass(_grammar_6);
    this.splitParserAndLexerIfEnabled(fsa, _internalParserClass_1, _lexerClass);
    Grammar _grammar_7 = this.getGrammar();
    AntlrGrammar _lexerGrammar_1 = naming.getLexerGrammar(_grammar_7);
    String _tokensFileName = _lexerGrammar_1.getTokensFileName();
    this.normalizeTokens(fsa, _tokensFileName);
    Grammar _grammar_8 = this.getGrammar();
    TypeReference _internalParserClass_2 = naming.getInternalParserClass(_grammar_8);
    Grammar _grammar_9 = this.getGrammar();
    TypeReference _lexerClass_1 = naming.getLexerClass(_grammar_9);
    this.suppressWarnings(fsa, _internalParserClass_2, _lexerClass_1);
    Grammar _grammar_10 = this.getGrammar();
    TypeReference _internalParserClass_3 = naming.getInternalParserClass(_grammar_10);
    Grammar _grammar_11 = this.getGrammar();
    TypeReference _lexerClass_2 = naming.getLexerClass(_grammar_11);
    this.normalizeLineDelimiters(fsa, _internalParserClass_3, _lexerClass_2);
  }
  
  protected void generateContentAssistGrammar() {
    @Extension
    final ContentAssistGrammarNaming naming = this.contentAssistNaming;
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _genericIde = _projectConfig.getGenericIde();
    final IXtextGeneratorFileSystemAccess fsa = _genericIde.getSrcGen();
    Grammar _grammar = this.getGrammar();
    AntlrOptions _options = this.getOptions();
    this.contentAssistGenerator.generate(_grammar, _options, fsa);
    Grammar _grammar_1 = this.getGrammar();
    AntlrGrammar _parserGrammar = naming.getParserGrammar(_grammar_1);
    Grammar _grammar_2 = this.getGrammar();
    AntlrGrammar _lexerGrammar = naming.getLexerGrammar(_grammar_2);
    this.runAntlr(_parserGrammar, _lexerGrammar, fsa);
    Grammar _grammar_3 = this.getGrammar();
    Grammar _grammar_4 = this.getGrammar();
    TypeReference _internalParserClass = naming.getInternalParserClass(_grammar_4);
    this.simplifyUnorderedGroupPredicatesIfRequired(_grammar_3, fsa, _internalParserClass);
    Grammar _grammar_5 = this.getGrammar();
    TypeReference _internalParserClass_1 = naming.getInternalParserClass(_grammar_5);
    Grammar _grammar_6 = this.getGrammar();
    TypeReference _lexerClass = naming.getLexerClass(_grammar_6);
    this.splitParserAndLexerIfEnabled(fsa, _internalParserClass_1, _lexerClass);
    Grammar _grammar_7 = this.getGrammar();
    AntlrGrammar _lexerGrammar_1 = naming.getLexerGrammar(_grammar_7);
    String _tokensFileName = _lexerGrammar_1.getTokensFileName();
    this.normalizeTokens(fsa, _tokensFileName);
    Grammar _grammar_8 = this.getGrammar();
    TypeReference _internalParserClass_2 = naming.getInternalParserClass(_grammar_8);
    Grammar _grammar_9 = this.getGrammar();
    TypeReference _lexerClass_1 = naming.getLexerClass(_grammar_9);
    this.suppressWarnings(fsa, _internalParserClass_2, _lexerClass_1);
    Grammar _grammar_10 = this.getGrammar();
    TypeReference _lexerClass_2 = naming.getLexerClass(_grammar_10);
    Grammar _grammar_11 = this.getGrammar();
    TypeReference _internalParserClass_3 = naming.getInternalParserClass(_grammar_11);
    this.normalizeLineDelimiters(fsa, _lexerClass_2, _internalParserClass_3);
    if (this.removeBacktrackingGuards) {
      Grammar _grammar_12 = this.getGrammar();
      TypeReference _internalParserClass_4 = naming.getInternalParserClass(_grammar_12);
      this.removeBackTrackingGuards(fsa, _internalParserClass_4, this.lookaheadThreshold);
    }
  }
  
  protected void runAntlr(final AntlrGrammar parserGrammar, final AntlrGrammar lexerGrammar, final IXtextGeneratorFileSystemAccess fsa) {
    CodeConfig _codeConfig = this.getCodeConfig();
    final String encoding = _codeConfig.getEncoding();
    StringConcatenation _builder = new StringConcatenation();
    String _path = fsa.getPath();
    _builder.append(_path, "");
    _builder.append("/");
    String _grammarFileName = lexerGrammar.getGrammarFileName();
    _builder.append(_grammarFileName, "");
    final String lexerGrammarFile = _builder.toString();
    String[] _antlrParams = this.getAntlrParams();
    final ArrayList<String> lexerAntlrParams = CollectionLiterals.<String>newArrayList(_antlrParams);
    lexerAntlrParams.add("-fo");
    int _lastIndexOf = lexerGrammarFile.lastIndexOf("/");
    final String lexerOutputDir = lexerGrammarFile.substring(0, _lastIndexOf);
    lexerAntlrParams.add(lexerOutputDir);
    boolean _isCombinedGrammar = this.isCombinedGrammar();
    boolean _not = (!_isCombinedGrammar);
    if (_not) {
      AntlrToolFacade _antlrTool = this.getAntlrTool();
      _antlrTool.runWithEncodingAndParams(lexerGrammarFile, encoding, ((String[])Conversions.unwrapArray(lexerAntlrParams, String.class)));
      Grammar _grammar = this.getGrammar();
      KeywordHelper _helper = KeywordHelper.getHelper(_grammar);
      this.cleanupLexerTokensFile(lexerGrammar, _helper, fsa);
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    String _path_1 = fsa.getPath();
    _builder_1.append(_path_1, "");
    _builder_1.append("/");
    String _grammarFileName_1 = parserGrammar.getGrammarFileName();
    _builder_1.append(_grammarFileName_1, "");
    final String parserGrammarFile = _builder_1.toString();
    String[] _antlrParams_1 = this.getAntlrParams();
    final ArrayList<String> parserAntlrParams = CollectionLiterals.<String>newArrayList(_antlrParams_1);
    parserAntlrParams.add("-fo");
    int _lastIndexOf_1 = parserGrammarFile.lastIndexOf("/");
    String _substring = parserGrammarFile.substring(0, _lastIndexOf_1);
    parserAntlrParams.add(_substring);
    boolean _isCombinedGrammar_1 = this.isCombinedGrammar();
    boolean _not_1 = (!_isCombinedGrammar_1);
    if (_not_1) {
      parserAntlrParams.add("-lib");
      parserAntlrParams.add(lexerOutputDir);
    }
    AntlrToolFacade _antlrTool_1 = this.getAntlrTool();
    _antlrTool_1.runWithEncodingAndParams(parserGrammarFile, encoding, ((String[])Conversions.unwrapArray(parserAntlrParams, String.class)));
    boolean _isCombinedGrammar_2 = this.isCombinedGrammar();
    boolean _not_2 = (!_isCombinedGrammar_2);
    if (_not_2) {
      Grammar _grammar_1 = this.getGrammar();
      KeywordHelper _helper_1 = KeywordHelper.getHelper(_grammar_1);
      this.cleanupParserTokensFile(lexerGrammar, parserGrammar, _helper_1, fsa);
    }
  }
  
  public boolean isCombinedGrammar() {
    boolean _or = false;
    boolean _and = false;
    boolean _and_1 = false;
    boolean _equals = Objects.equal(this.combinedGrammar, null);
    if (!_equals) {
      _and_1 = false;
    } else {
      AntlrOptions _options = this.getOptions();
      boolean _isBacktrackLexer = _options.isBacktrackLexer();
      boolean _not = (!_isBacktrackLexer);
      _and_1 = _not;
    }
    if (!_and_1) {
      _and = false;
    } else {
      AntlrOptions _options_1 = this.getOptions();
      boolean _isIgnoreCase = _options_1.isIgnoreCase();
      boolean _not_1 = (!_isIgnoreCase);
      _and = _not_1;
    }
    if (_and) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(this.combinedGrammar, Boolean.TRUE);
      _or = _equals_1;
    }
    return _or;
  }
  
  protected void generateDebugGrammar() {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    final IXtextGeneratorFileSystemAccess fsa = _runtime.getSrcGen();
    Grammar _grammar = this.getGrammar();
    AntlrOptions _options = this.getOptions();
    this.debugGenerator.generate(_grammar, _options, fsa);
  }
  
  public JavaFileAccess generateProductionParser() {
    GeneratedJavaFileAccess _xblockexpression = null;
    {
      @Extension
      final GrammarNaming naming = this.productionNaming;
      Grammar _grammar = this.getGrammar();
      TypeReference _parserClass = naming.getParserClass(_grammar);
      final GeneratedJavaFileAccess file = this.fileFactory.createGeneratedJavaFile(_parserClass);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _parserClass = naming.getParserClass(_grammar);
          String _simpleName = _parserClass.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" extends ");
          _builder.append(AbstractAntlrParser.class, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@");
          _builder.append(Inject.class, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("private ");
          Grammar _grammar_1 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _grammarAccess = XtextAntlrGeneratorFragment2.this.grammarUtil.getGrammarAccess(_grammar_1);
          _builder.append(_grammarAccess, "\t");
          _builder.append(" grammarAccess;");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected void setInitialHiddenTokens(");
          _builder.append(XtextTokenStream.class, "\t");
          _builder.append(" tokenStream) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("tokenStream.setInitialHiddenTokens(");
          {
            Grammar _grammar_2 = XtextAntlrGeneratorFragment2.this.getGrammar();
            List<String> _initialHiddenTokens = XtextAntlrGeneratorFragment2.this.grammarUtil.initialHiddenTokens(_grammar_2);
            boolean _hasElements = false;
            for(final String hidden : _initialHiddenTokens) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(", ", "\t\t");
              }
              _builder.append("\"");
              _builder.append(hidden, "\t\t");
              _builder.append("\"");
            }
          }
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.newLine();
          {
            Grammar _grammar_3 = XtextAntlrGeneratorFragment2.this.getGrammar();
            List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(_grammar_3);
            final Function1<TerminalRule, Boolean> _function = new Function1<TerminalRule, Boolean>() {
              @Override
              public Boolean apply(final TerminalRule it) {
                return Boolean.valueOf(XtextAntlrGeneratorFragment2.this._syntheticTerminalDetector.isSyntheticTerminalRule(it));
              }
            };
            boolean _exists = IterableExtensions.<TerminalRule>exists(_allTerminalRules, _function);
            if (_exists) {
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("protected ");
              _builder.append(TokenSource.class, "\t");
              _builder.append(" createLexer(");
              _builder.append(CharStream.class, "\t");
              _builder.append(" stream) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("return new ");
              Grammar _grammar_4 = XtextAntlrGeneratorFragment2.this.getGrammar();
              TypeReference _tokenSourceClass = naming.getTokenSourceClass(_grammar_4);
              _builder.append(_tokenSourceClass, "\t\t");
              _builder.append("(super.createLexer(stream));");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("/**");
              _builder.newLine();
              _builder.append("\t");
              _builder.append(" ");
              _builder.append("* Indentation aware languages do not support partial parsing since the lexer is inherently stateful.");
              _builder.newLine();
              _builder.append("\t");
              _builder.append(" ");
              _builder.append("* Override and return {@code true} if your terminal splitting is stateless.");
              _builder.newLine();
              _builder.append("\t");
              _builder.append(" ");
              _builder.append("*/");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("protected boolean isReparseSupported() {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("return false;");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected ");
          Grammar _grammar_5 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserClass = naming.getInternalParserClass(_grammar_5);
          _builder.append(_internalParserClass, "\t");
          _builder.append(" createParser(");
          _builder.append(XtextTokenStream.class, "\t");
          _builder.append(" stream) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("return new ");
          Grammar _grammar_6 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserClass_1 = naming.getInternalParserClass(_grammar_6);
          _builder.append(_internalParserClass_1, "\t\t");
          _builder.append("(stream, getGrammarAccess());");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected String getDefaultRuleName() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("return \"");
          Grammar _grammar_7 = XtextAntlrGeneratorFragment2.this.getGrammar();
          List<ParserRule> _allParserRules = GrammarUtil.allParserRules(_grammar_7);
          ParserRule _head = IterableExtensions.<ParserRule>head(_allParserRules);
          ParserRule _originalElement = AntlrGrammarGenUtil.<ParserRule>getOriginalElement(_head);
          String _name = _originalElement.getName();
          _builder.append(_name, "\t\t");
          _builder.append("\";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public ");
          Grammar _grammar_8 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _grammarAccess_1 = XtextAntlrGeneratorFragment2.this.grammarUtil.getGrammarAccess(_grammar_8);
          _builder.append(_grammarAccess_1, "\t");
          _builder.append(" getGrammarAccess() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("return this.grammarAccess;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void setGrammarAccess(");
          Grammar _grammar_9 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _grammarAccess_2 = XtextAntlrGeneratorFragment2.this.grammarUtil.getGrammarAccess(_grammar_9);
          _builder.append(_grammarAccess_2, "\t");
          _builder.append(" grammarAccess) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("this.grammarAccess = grammarAccess;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      file.setContent(_client);
      _xblockexpression = file;
    }
    return _xblockexpression;
  }
  
  public JavaFileAccess generateAntlrTokenFileProvider() {
    GeneratedJavaFileAccess _xblockexpression = null;
    {
      @Extension
      final GrammarNaming naming = this.productionNaming;
      Grammar _grammar = this.getGrammar();
      TypeReference _antlrTokenFileProviderClass = naming.getAntlrTokenFileProviderClass(_grammar);
      final GeneratedJavaFileAccess file = this.fileFactory.createGeneratedJavaFile(_antlrTokenFileProviderClass);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _antlrTokenFileProviderClass = naming.getAntlrTokenFileProviderClass(_grammar);
          String _simpleName = _antlrTokenFileProviderClass.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" implements ");
          _builder.append(IAntlrTokenFileProvider.class, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public ");
          _builder.append(InputStream.class, "\t");
          _builder.append(" getAntlrTokenFile() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append(ClassLoader.class, "\t\t");
          _builder.append(" classLoader = getClass().getClassLoader();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("return classLoader.getResourceAsStream(\"");
          Grammar _grammar_1 = XtextAntlrGeneratorFragment2.this.getGrammar();
          AntlrGrammar _parserGrammar = naming.getParserGrammar(_grammar_1);
          String _tokensFileName = _parserGrammar.getTokensFileName();
          _builder.append(_tokensFileName, "\t\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      file.setContent(_client);
      _xblockexpression = file;
    }
    return _xblockexpression;
  }
  
  public JavaFileAccess generateProductionTokenSource() {
    GeneratedJavaFileAccess _xblockexpression = null;
    {
      @Extension
      final GrammarNaming naming = this.productionNaming;
      Grammar _grammar = this.getGrammar();
      TypeReference _tokenSourceClass = naming.getTokenSourceClass(_grammar);
      final GeneratedJavaFileAccess file = this.fileFactory.createGeneratedJavaFile(_tokenSourceClass);
      Grammar _grammar_1 = this.getGrammar();
      List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(_grammar_1);
      final Function1<TerminalRule, Boolean> _function = new Function1<TerminalRule, Boolean>() {
        @Override
        public Boolean apply(final TerminalRule it) {
          String _name = it.getName();
          String _upperCase = _name.toUpperCase();
          return Boolean.valueOf(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("BEGIN", "INDENT", "OPEN")).contains(_upperCase));
        }
      };
      final Iterable<TerminalRule> open = IterableExtensions.<TerminalRule>filter(_allTerminalRules, _function);
      Grammar _grammar_2 = this.getGrammar();
      List<TerminalRule> _allTerminalRules_1 = GrammarUtil.allTerminalRules(_grammar_2);
      final Function1<TerminalRule, Boolean> _function_1 = new Function1<TerminalRule, Boolean>() {
        @Override
        public Boolean apply(final TerminalRule it) {
          String _name = it.getName();
          String _upperCase = _name.toUpperCase();
          return Boolean.valueOf(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("END", "DEDENT", "CLOSE")).contains(_upperCase));
        }
      };
      final Iterable<TerminalRule> close = IterableExtensions.<TerminalRule>filter(_allTerminalRules_1, _function_1);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _tokenSourceClass = naming.getTokenSourceClass(_grammar);
          String _simpleName = _tokenSourceClass.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" extends ");
          _builder.append(AbstractIndentationTokenSource.class, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public ");
          Grammar _grammar_1 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _tokenSourceClass_1 = naming.getTokenSourceClass(_grammar_1);
          String _simpleName_1 = _tokenSourceClass_1.getSimpleName();
          _builder.append(_simpleName_1, "\t");
          _builder.append("(");
          _builder.append(TokenSource.class, "\t");
          _builder.append(" delegate) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("super(delegate);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected boolean shouldSplitTokenImpl(");
          _builder.append(Token.class, "\t");
          _builder.append(" token) {");
          _builder.newLineIfNotEmpty();
          {
            Grammar _grammar_2 = XtextAntlrGeneratorFragment2.this.getGrammar();
            List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(_grammar_2);
            final Function1<TerminalRule, Boolean> _function = new Function1<TerminalRule, Boolean>() {
              @Override
              public Boolean apply(final TerminalRule it) {
                String _name = it.getName();
                String _upperCase = _name.toUpperCase();
                return Boolean.valueOf(Objects.equal(_upperCase, "WS"));
              }
            };
            boolean _exists = IterableExtensions.<TerminalRule>exists(_allTerminalRules, _function);
            if (_exists) {
              _builder.append("\t\t");
              _builder.append("// TODO Review assumption");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("return token.getType() == ");
              Grammar _grammar_3 = XtextAntlrGeneratorFragment2.this.getGrammar();
              TypeReference _internalParserClass = naming.getInternalParserClass(_grammar_3);
              _builder.append(_internalParserClass, "\t\t");
              _builder.append(".RULE_WS;");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              _builder.append("// TODO Implement me");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("throw new UnsupportedOperationException(\"Implement me\");");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected int getBeginTokenType() {");
          _builder.newLine();
          {
            int _size = IterableExtensions.size(open);
            boolean _equals = (_size == 1);
            if (_equals) {
              _builder.append("\t\t");
              _builder.append("// TODO Review assumption");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("return ");
              Grammar _grammar_4 = XtextAntlrGeneratorFragment2.this.getGrammar();
              TypeReference _internalParserClass_1 = naming.getInternalParserClass(_grammar_4);
              _builder.append(_internalParserClass_1, "\t\t");
              _builder.append(".");
              TerminalRule _head = IterableExtensions.<TerminalRule>head(open);
              String _ruleName = XtextAntlrGeneratorFragment2.this.grammarUtil.ruleName(_head);
              _builder.append(_ruleName, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              _builder.append("// TODO Implement me");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("throw new UnsupportedOperationException(\"Implement me\");");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected int getEndTokenType() {");
          _builder.newLine();
          {
            int _size_1 = IterableExtensions.size(close);
            boolean _equals_1 = (_size_1 == 1);
            if (_equals_1) {
              _builder.append("\t\t");
              _builder.append("// TODO Review assumption");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("return ");
              Grammar _grammar_5 = XtextAntlrGeneratorFragment2.this.getGrammar();
              TypeReference _internalParserClass_2 = naming.getInternalParserClass(_grammar_5);
              _builder.append(_internalParserClass_2, "\t\t");
              _builder.append(".");
              TerminalRule _head_1 = IterableExtensions.<TerminalRule>head(close);
              String _ruleName_1 = XtextAntlrGeneratorFragment2.this.grammarUtil.ruleName(_head_1);
              _builder.append(_ruleName_1, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              _builder.append("// TODO Implement me");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("throw new UnsupportedOperationException(\"Implement me\");");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      file.setContent(_client);
      _xblockexpression = file;
    }
    return _xblockexpression;
  }
  
  public JavaFileAccess generateContentAssistParser() {
    GeneratedJavaFileAccess _xblockexpression = null;
    {
      @Extension
      final ContentAssistGrammarNaming naming = this.contentAssistNaming;
      Grammar _grammar = this.getGrammar();
      TypeReference _parserClass = naming.getParserClass(_grammar);
      final GeneratedJavaFileAccess file = this.fileFactory.createGeneratedJavaFile(_parserClass);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _parserClass = naming.getParserClass(_grammar);
          String _simpleName = _parserClass.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" extends ");
          Grammar _grammar_1 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _parserSuperClass = naming.getParserSuperClass(_grammar_1, XtextAntlrGeneratorFragment2.this.partialParsing);
          _builder.append(_parserSuperClass, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@");
          _builder.append(Inject.class, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("private ");
          Grammar _grammar_2 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _grammarAccess = XtextAntlrGeneratorFragment2.this.grammarUtil.getGrammarAccess(_grammar_2);
          _builder.append(_grammarAccess, "\t");
          _builder.append(" grammarAccess;");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("private ");
          _builder.append(Map.class, "\t");
          _builder.append("<");
          _builder.append(AbstractElement.class, "\t");
          _builder.append(", String> nameMappings;");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected ");
          Grammar _grammar_3 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserClass = naming.getInternalParserClass(_grammar_3);
          _builder.append(_internalParserClass, "\t");
          _builder.append(" createParser() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          Grammar _grammar_4 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserClass_1 = naming.getInternalParserClass(_grammar_4);
          _builder.append(_internalParserClass_1, "\t\t");
          _builder.append(" result = new ");
          Grammar _grammar_5 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserClass_2 = naming.getInternalParserClass(_grammar_5);
          _builder.append(_internalParserClass_2, "\t\t");
          _builder.append("(null);");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("result.setGrammarAccess(grammarAccess);");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("return result;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          {
            Grammar _grammar_6 = XtextAntlrGeneratorFragment2.this.getGrammar();
            List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(_grammar_6);
            final Function1<TerminalRule, Boolean> _function = new Function1<TerminalRule, Boolean>() {
              @Override
              public Boolean apply(final TerminalRule it) {
                return Boolean.valueOf(XtextAntlrGeneratorFragment2.this._syntheticTerminalDetector.isSyntheticTerminalRule(it));
              }
            };
            boolean _exists = IterableExtensions.<TerminalRule>exists(_allTerminalRules, _function);
            if (_exists) {
              _builder.append("\t");
              _builder.append("@Override");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("protected ");
              _builder.append(TokenSource.class, "\t");
              _builder.append(" createLexer(CharStream stream) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("return new ");
              Grammar _grammar_7 = XtextAntlrGeneratorFragment2.this.getGrammar();
              TypeReference _tokenSourceClass = naming.getTokenSourceClass(_grammar_7);
              _builder.append(_tokenSourceClass, "\t\t");
              _builder.append("(super.createLexer(stream));");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected String getRuleName(");
          _builder.append(AbstractElement.class, "\t");
          _builder.append(" element) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("if (nameMappings == null) {");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("nameMappings = new ");
          _builder.append(HashMap.class, "\t\t\t");
          _builder.append("<");
          _builder.append(AbstractElement.class, "\t\t\t");
          _builder.append(", String>() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t");
          _builder.append("private static final long serialVersionUID = 1L;");
          _builder.newLine();
          _builder.append("\t\t\t\t");
          _builder.append("{");
          _builder.newLine();
          {
            Grammar _grammar_8 = XtextAntlrGeneratorFragment2.this.getGrammar();
            Collection<? extends AbstractElement> _allAlternatives = GrammarUtil.getAllAlternatives(_grammar_8);
            Grammar _grammar_9 = XtextAntlrGeneratorFragment2.this.getGrammar();
            Collection<? extends AbstractElement> _allGroups = GrammarUtil.getAllGroups(_grammar_9);
            Iterable<AbstractElement> _plus = Iterables.<AbstractElement>concat(_allAlternatives, _allGroups);
            Grammar _grammar_10 = XtextAntlrGeneratorFragment2.this.getGrammar();
            Collection<? extends AbstractElement> _allAssignments = GrammarUtil.getAllAssignments(_grammar_10);
            Iterable<AbstractElement> _plus_1 = Iterables.<AbstractElement>concat(_plus, _allAssignments);
            Grammar _grammar_11 = XtextAntlrGeneratorFragment2.this.getGrammar();
            Collection<? extends AbstractElement> _allUnorderedGroups = GrammarUtil.getAllUnorderedGroups(_grammar_11);
            Iterable<AbstractElement> _plus_2 = Iterables.<AbstractElement>concat(_plus_1, _allUnorderedGroups);
            Iterable<AbstractElement> _filter = Iterables.<AbstractElement>filter(_plus_2, AbstractElement.class);
            for(final AbstractElement element : _filter) {
              _builder.append("\t\t\t\t\t");
              _builder.append("put(grammarAccess.");
              String _grammarElementAccess = XtextAntlrGeneratorFragment2.this.grammarUtil.grammarElementAccess(element);
              _builder.append(_grammarElementAccess, "\t\t\t\t\t");
              _builder.append(", \"");
              AbstractRule _containingRule = GrammarUtil.containingRule(element);
              String _contentAssistRuleName = AntlrGrammarGenUtil.getContentAssistRuleName(_containingRule);
              _builder.append(_contentAssistRuleName, "\t\t\t\t\t");
              _builder.append("__");
              String _gaElementIdentifier = XtextAntlrGeneratorFragment2.this.grammarUtil.gaElementIdentifier(element);
              _builder.append(_gaElementIdentifier, "\t\t\t\t\t");
              {
                if ((element instanceof Group)) {
                  _builder.append("__0");
                }
              }
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("};");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("return nameMappings.get(element);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected ");
          _builder.append(Collection.class, "\t");
          _builder.append("<");
          TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement");
          _builder.append(_typeRef, "\t");
          _builder.append("> getFollowElements(");
          Grammar _grammar_12 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserSuperClass = naming.getInternalParserSuperClass(_grammar_12);
          _builder.append(_internalParserSuperClass, "\t");
          _builder.append(" parser) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("try {");
          _builder.newLine();
          _builder.append("\t\t\t");
          Grammar _grammar_13 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserClass_3 = naming.getInternalParserClass(_grammar_13);
          _builder.append(_internalParserClass_3, "\t\t\t");
          _builder.append(" typedParser = (");
          Grammar _grammar_14 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserClass_4 = naming.getInternalParserClass(_grammar_14);
          _builder.append(_internalParserClass_4, "\t\t\t");
          _builder.append(") parser;");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("typedParser.");
          Grammar _grammar_15 = XtextAntlrGeneratorFragment2.this.getGrammar();
          List<ParserRule> _allParserRules = GrammarUtil.allParserRules(_grammar_15);
          ParserRule _head = IterableExtensions.<ParserRule>head(_allParserRules);
          ParserRule _originalElement = AntlrGrammarGenUtil.<ParserRule>getOriginalElement(_head);
          String _entryRuleName = XtextAntlrGeneratorFragment2.this.grammarUtil.entryRuleName(_originalElement);
          _builder.append(_entryRuleName, "\t\t\t");
          _builder.append("();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("return typedParser.getFollowElements();");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("} catch(");
          _builder.append(RecognitionException.class, "\t\t");
          _builder.append(" ex) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t");
          _builder.append("throw new RuntimeException(ex);");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected String[] getInitialHiddenTokens() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("return new String[] { ");
          {
            Grammar _grammar_16 = XtextAntlrGeneratorFragment2.this.getGrammar();
            List<String> _initialHiddenTokens = XtextAntlrGeneratorFragment2.this.grammarUtil.initialHiddenTokens(_grammar_16);
            boolean _hasElements = false;
            for(final String hidden : _initialHiddenTokens) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(", ", "\t\t");
              }
              _builder.append("\"");
              _builder.append(hidden, "\t\t");
              _builder.append("\"");
            }
          }
          _builder.append(" };");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public ");
          Grammar _grammar_17 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _grammarAccess_1 = XtextAntlrGeneratorFragment2.this.grammarUtil.getGrammarAccess(_grammar_17);
          _builder.append(_grammarAccess_1, "\t");
          _builder.append(" getGrammarAccess() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("return this.grammarAccess;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void setGrammarAccess(");
          Grammar _grammar_18 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _grammarAccess_2 = XtextAntlrGeneratorFragment2.this.grammarUtil.getGrammarAccess(_grammar_18);
          _builder.append(_grammarAccess_2, "\t");
          _builder.append(" grammarAccess) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("this.grammarAccess = grammarAccess;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      file.setContent(_client);
      _xblockexpression = file;
    }
    return _xblockexpression;
  }
  
  public JavaFileAccess generateContentAssistTokenSource() {
    GeneratedJavaFileAccess _xblockexpression = null;
    {
      @Extension
      final ContentAssistGrammarNaming naming = this.contentAssistNaming;
      Grammar _grammar = this.getGrammar();
      TypeReference _tokenSourceClass = naming.getTokenSourceClass(_grammar);
      final GeneratedJavaFileAccess file = this.fileFactory.createGeneratedJavaFile(_tokenSourceClass);
      Grammar _grammar_1 = this.getGrammar();
      List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(_grammar_1);
      final Function1<TerminalRule, Boolean> _function = new Function1<TerminalRule, Boolean>() {
        @Override
        public Boolean apply(final TerminalRule it) {
          String _name = it.getName();
          String _upperCase = _name.toUpperCase();
          return Boolean.valueOf(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("BEGIN", "INDENT", "OPEN")).contains(_upperCase));
        }
      };
      final Iterable<TerminalRule> open = IterableExtensions.<TerminalRule>filter(_allTerminalRules, _function);
      Grammar _grammar_2 = this.getGrammar();
      List<TerminalRule> _allTerminalRules_1 = GrammarUtil.allTerminalRules(_grammar_2);
      final Function1<TerminalRule, Boolean> _function_1 = new Function1<TerminalRule, Boolean>() {
        @Override
        public Boolean apply(final TerminalRule it) {
          String _name = it.getName();
          String _upperCase = _name.toUpperCase();
          return Boolean.valueOf(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("END", "DEDENT", "CLOSE")).contains(_upperCase));
        }
      };
      final Iterable<TerminalRule> close = IterableExtensions.<TerminalRule>filter(_allTerminalRules_1, _function_1);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _tokenSourceClass = naming.getTokenSourceClass(_grammar);
          String _simpleName = _tokenSourceClass.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" extends ");
          _builder.append(AbstractIndentationTokenSource.class, "");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public ");
          Grammar _grammar_1 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _tokenSourceClass_1 = naming.getTokenSourceClass(_grammar_1);
          String _simpleName_1 = _tokenSourceClass_1.getSimpleName();
          _builder.append(_simpleName_1, "\t");
          _builder.append("(");
          _builder.append(TokenSource.class, "\t");
          _builder.append(" delegate) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("super(delegate);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected boolean shouldSplitTokenImpl(Token token) {");
          _builder.newLine();
          {
            Grammar _grammar_2 = XtextAntlrGeneratorFragment2.this.getGrammar();
            List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(_grammar_2);
            final Function1<TerminalRule, TerminalRule> _function = new Function1<TerminalRule, TerminalRule>() {
              @Override
              public TerminalRule apply(final TerminalRule it) {
                return AntlrGrammarGenUtil.<TerminalRule>getOriginalElement(it);
              }
            };
            List<TerminalRule> _map = ListExtensions.<TerminalRule, TerminalRule>map(_allTerminalRules, _function);
            final Function1<TerminalRule, Boolean> _function_1 = new Function1<TerminalRule, Boolean>() {
              @Override
              public Boolean apply(final TerminalRule it) {
                String _name = it.getName();
                String _upperCase = _name.toUpperCase();
                return Boolean.valueOf(Objects.equal(_upperCase, "WS"));
              }
            };
            boolean _exists = IterableExtensions.<TerminalRule>exists(_map, _function_1);
            if (_exists) {
              _builder.append("\t\t");
              _builder.append("// TODO Review assumption");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("return token.getType() == ");
              Grammar _grammar_3 = XtextAntlrGeneratorFragment2.this.getGrammar();
              TypeReference _internalParserClass = naming.getInternalParserClass(_grammar_3);
              _builder.append(_internalParserClass, "\t\t");
              _builder.append(".RULE_WS;");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              _builder.append("// TODO Implement me");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("throw new UnsupportedOperationException(\"Implement me\");");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected int getBeginTokenType() {");
          _builder.newLine();
          {
            int _size = IterableExtensions.size(open);
            boolean _equals = (_size == 1);
            if (_equals) {
              _builder.append("\t\t");
              _builder.append("// TODO Review assumption");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("return ");
              Grammar _grammar_4 = XtextAntlrGeneratorFragment2.this.getGrammar();
              TypeReference _internalParserClass_1 = naming.getInternalParserClass(_grammar_4);
              _builder.append(_internalParserClass_1, "\t\t");
              _builder.append(".");
              TerminalRule _head = IterableExtensions.<TerminalRule>head(open);
              String _ruleName = XtextAntlrGeneratorFragment2.this.grammarUtil.ruleName(_head);
              _builder.append(_ruleName, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              _builder.append("// TODO Implement me");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("throw new UnsupportedOperationException(\"Implement me\");");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected int getEndTokenType() {");
          _builder.newLine();
          {
            int _size_1 = IterableExtensions.size(close);
            boolean _equals_1 = (_size_1 == 1);
            if (_equals_1) {
              _builder.append("\t\t");
              _builder.append("// TODO Review assumption");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("return ");
              Grammar _grammar_5 = XtextAntlrGeneratorFragment2.this.getGrammar();
              TypeReference _internalParserClass_2 = naming.getInternalParserClass(_grammar_5);
              _builder.append(_internalParserClass_2, "\t\t");
              _builder.append(".");
              TerminalRule _head_1 = IterableExtensions.<TerminalRule>head(close);
              String _ruleName_1 = XtextAntlrGeneratorFragment2.this.grammarUtil.ruleName(_head_1);
              _builder.append(_ruleName_1, "\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("\t\t");
              _builder.append("// TODO Implement me");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("throw new UnsupportedOperationException(\"Implement me\");");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected boolean shouldEmitPendingEndTokens() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("return false;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
        }
      };
      file.setContent(_client);
      _xblockexpression = file;
    }
    return _xblockexpression;
  }
  
  @Override
  public void checkConfiguration(final Issues issues) {
    super.checkConfiguration(issues);
    boolean _and = false;
    AntlrOptions _options = this.getOptions();
    boolean _isBacktrackLexer = _options.isBacktrackLexer();
    if (!_isBacktrackLexer) {
      _and = false;
    } else {
      boolean _isCombinedGrammar = this.isCombinedGrammar();
      _and = _isCombinedGrammar;
    }
    if (_and) {
      issues.addError("A combined grammar cannot have a backtracking lexer");
    }
    boolean _and_1 = false;
    AntlrOptions _options_1 = this.getOptions();
    boolean _isIgnoreCase = _options_1.isIgnoreCase();
    if (!_isIgnoreCase) {
      _and_1 = false;
    } else {
      boolean _isCombinedGrammar_1 = this.isCombinedGrammar();
      _and_1 = _isCombinedGrammar_1;
    }
    if (_and_1) {
      issues.addError("A combined grammar cannot have an ignorecase lexer");
    }
    boolean _and_2 = false;
    AntlrOptions _options_2 = this.getOptions();
    boolean _isBacktrackLexer_1 = _options_2.isBacktrackLexer();
    if (!_isBacktrackLexer_1) {
      _and_2 = false;
    } else {
      AntlrOptions _options_3 = this.getOptions();
      boolean _isIgnoreCase_1 = _options_3.isIgnoreCase();
      _and_2 = _isIgnoreCase_1;
    }
    if (_and_2) {
      issues.addError("Backtracking lexer and ignorecase cannot be combined for now.");
    }
  }
  
  public void addRuntimeBindingsAndImports() {
    @Extension
    final GrammarNaming naming = this.productionNaming;
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    ManifestAccess _manifest = _runtime.getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
      ManifestAccess _manifest_1 = _runtime_1.getManifest();
      final Procedure1<ManifestAccess> _function = new Procedure1<ManifestAccess>() {
        @Override
        public void apply(final ManifestAccess it) {
          Set<String> _exportedPackages = it.getExportedPackages();
          Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _lexerClass = naming.getLexerClass(_grammar);
          String _packageName = _lexerClass.getPackageName();
          Grammar _grammar_1 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _parserClass = naming.getParserClass(_grammar_1);
          String _packageName_1 = _parserClass.getPackageName();
          Grammar _grammar_2 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserClass = naming.getInternalParserClass(_grammar_2);
          String _packageName_2 = _internalParserClass.getPackageName();
          Iterables.<String>addAll(_exportedPackages, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_packageName, _packageName_1, _packageName_2)));
          Set<String> _requiredBundles = it.getRequiredBundles();
          _requiredBundles.add("org.antlr.runtime");
        }
      };
      ObjectExtensions.<ManifestAccess>operator_doubleArrow(_manifest_1, _function);
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef(IParser.class);
    Grammar _grammar = this.getGrammar();
    TypeReference _parserClass = naming.getParserClass(_grammar);
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeRef, _parserClass);
    TypeReference _typeRef_1 = TypeReference.typeRef(ITokenToStringConverter.class);
    TypeReference _typeRef_2 = TypeReference.typeRef(AntlrTokenToStringConverter.class);
    GuiceModuleAccess.BindingFactory _addTypeToType_1 = _addTypeToType.addTypeToType(_typeRef_1, _typeRef_2);
    TypeReference _typeRef_3 = TypeReference.typeRef(IAntlrTokenFileProvider.class);
    Grammar _grammar_1 = this.getGrammar();
    TypeReference _antlrTokenFileProviderClass = naming.getAntlrTokenFileProviderClass(_grammar_1);
    GuiceModuleAccess.BindingFactory _addTypeToType_2 = _addTypeToType_1.addTypeToType(_typeRef_3, _antlrTokenFileProviderClass);
    Grammar _grammar_2 = this.getGrammar();
    TypeReference _lexerSuperClass = naming.getLexerSuperClass(_grammar_2);
    Grammar _grammar_3 = this.getGrammar();
    TypeReference _lexerClass = naming.getLexerClass(_grammar_3);
    GuiceModuleAccess.BindingFactory _addTypeToType_3 = _addTypeToType_2.addTypeToType(_lexerSuperClass, _lexerClass);
    TypeReference _typeRef_4 = TypeReference.typeRef(ITokenDefProvider.class);
    TypeReference _typeRef_5 = TypeReference.typeRef(AntlrTokenDefProvider.class);
    GuiceModuleAccess.BindingFactory _addTypeToType_4 = _addTypeToType_3.addTypeToType(_typeRef_4, _typeRef_5);
    Grammar _grammar_4 = this.getGrammar();
    TypeReference _lexerClass_1 = naming.getLexerClass(_grammar_4);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(LexerProvider.class, "");
        _builder.append(".create(");
        Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
        TypeReference _lexerClass = naming.getLexerClass(_grammar);
        _builder.append(_lexerClass, "");
        _builder.append(".class)");
      }
    };
    GuiceModuleAccess.BindingFactory _addTypeToProviderInstance = _addTypeToType_4.addTypeToProviderInstance(_lexerClass_1, _client);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(Lexer.class, "");
        _builder.append(".class)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".annotatedWith(");
        _builder.append(Names.class, "\t");
        _builder.append(".named(");
        _builder.append(LexerBindings.class, "\t");
        _builder.append(".RUNTIME))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".to(");
        Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
        TypeReference _lexerClass = naming.getLexerClass(_grammar);
        _builder.append(_lexerClass, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    };
    final GuiceModuleAccess.BindingFactory rtBindings = _addTypeToProviderInstance.addConfiguredBinding("RuntimeLexer", _client_1);
    Grammar _grammar_5 = this.getGrammar();
    boolean _containsUnorderedGroup = this.containsUnorderedGroup(_grammar_5);
    if (_containsUnorderedGroup) {
      TypeReference _typeRef_6 = TypeReference.typeRef(IUnorderedGroupHelper.class);
      TypeReference _typeRef_7 = TypeReference.typeRef(UnorderedGroupHelper.class);
      rtBindings.addTypeToType(_typeRef_6, _typeRef_7);
    }
    AntlrOptions _options = this.getOptions();
    boolean _isIgnoreCase = _options.isIgnoreCase();
    if (_isIgnoreCase) {
      TypeReference _typeRef_8 = TypeReference.typeRef(ITokenSerializer.IKeywordSerializer.class);
      TypeReference _typeRef_9 = TypeReference.typeRef(IgnoreCaseKeywordSerializer.class);
      GuiceModuleAccess.BindingFactory _addTypeToType_5 = rtBindings.addTypeToType(_typeRef_8, _typeRef_9);
      TypeReference _typeRef_10 = TypeReference.typeRef(AbstractIDValueConverter.class);
      TypeReference _typeRef_11 = TypeReference.typeRef(IgnoreCaseIDValueConverter.class);
      _addTypeToType_5.addTypeToType(_typeRef_10, _typeRef_11);
    }
    IXtextGeneratorLanguage _language = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language.getRuntimeGenModule();
    rtBindings.contributeTo(_runtimeGenModule);
  }
  
  public void addUiBindingsAndImports() {
    @Extension
    final ContentAssistGrammarNaming naming = this.contentAssistNaming;
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IBundleProjectConfig _genericIde = _projectConfig.getGenericIde();
    ManifestAccess _manifest = _genericIde.getManifest();
    boolean _tripleNotEquals = (_manifest != null);
    if (_tripleNotEquals) {
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      IBundleProjectConfig _genericIde_1 = _projectConfig_1.getGenericIde();
      ManifestAccess _manifest_1 = _genericIde_1.getManifest();
      final Procedure1<ManifestAccess> _function = new Procedure1<ManifestAccess>() {
        @Override
        public void apply(final ManifestAccess it) {
          Set<String> _exportedPackages = it.getExportedPackages();
          Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _lexerClass = naming.getLexerClass(_grammar);
          String _packageName = _lexerClass.getPackageName();
          Grammar _grammar_1 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _parserClass = naming.getParserClass(_grammar_1);
          String _packageName_1 = _parserClass.getPackageName();
          Grammar _grammar_2 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserClass = naming.getInternalParserClass(_grammar_2);
          String _packageName_2 = _internalParserClass.getPackageName();
          Iterables.<String>addAll(_exportedPackages, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_packageName, _packageName_1, _packageName_2)));
        }
      };
      ObjectExtensions.<ManifestAccess>operator_doubleArrow(_manifest_1, _function);
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper");
    TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper");
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeRef, _typeRef_1);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(Lexer.class, "");
        _builder.append(".class)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".annotatedWith(");
        _builder.append(Names.class, "\t");
        _builder.append(".named(org.eclipse.xtext.ide.LexerIdeBindings.HIGHLIGHTING))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".to(");
        Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
        TypeReference _lexerClass = XtextAntlrGeneratorFragment2.this.productionNaming.getLexerClass(_grammar);
        _builder.append(_lexerClass, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    };
    GuiceModuleAccess.BindingFactory _addConfiguredBinding = _addTypeToType.addConfiguredBinding("HighlightingLexer", _client);
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
        TypeReference _lexerSuperClass = naming.getLexerSuperClass(_grammar);
        _builder.append(_lexerSuperClass, "");
        _builder.append(".class)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".annotatedWith(");
        _builder.append(Names.class, "\t");
        _builder.append(".named(org.eclipse.xtext.ide.LexerIdeBindings.CONTENT_ASSIST))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".to(");
        Grammar _grammar_1 = XtextAntlrGeneratorFragment2.this.getGrammar();
        TypeReference _lexerClass = naming.getLexerClass(_grammar_1);
        _builder.append(_lexerClass, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    };
    GuiceModuleAccess.BindingFactory _addConfiguredBinding_1 = _addConfiguredBinding.addConfiguredBinding("ContentAssistLexer", _client_1);
    StringConcatenationClient _client_2 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        _builder.append(ITokenDefProvider.class, "");
        _builder.append(".class)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".annotatedWith(");
        _builder.append(Names.class, "\t");
        _builder.append(".named(org.eclipse.xtext.ide.LexerIdeBindings.HIGHLIGHTING))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".to(");
        _builder.append(AntlrTokenDefProvider.class, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    };
    GuiceModuleAccess.BindingFactory _addConfiguredBinding_2 = _addConfiguredBinding_1.addConfiguredBinding("HighlightingTokenDefProvider", _client_2);
    TypeReference _typeReference = new TypeReference("org.eclipse.xtext.ui.editor.contentassist", "ContentAssistContext.Factory");
    TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.antlr.DelegatingContentAssistContextFactory");
    GuiceModuleAccess.BindingFactory _addTypeToType_1 = _addConfiguredBinding_2.addTypeToType(_typeReference, _typeRef_2);
    TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser");
    Grammar _grammar = this.getGrammar();
    TypeReference _parserClass = naming.getParserClass(_grammar);
    GuiceModuleAccess.BindingFactory _addTypeToType_2 = _addTypeToType_1.addTypeToType(_typeRef_3, _parserClass);
    StringConcatenationClient _client_3 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
        TypeReference _lexerClass = naming.getLexerClass(_grammar);
        _builder.append(_lexerClass, "");
        _builder.append(".class)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".toProvider(");
        _builder.append(LexerProvider.class, "\t");
        _builder.append(".create(");
        Grammar _grammar_1 = XtextAntlrGeneratorFragment2.this.getGrammar();
        TypeReference _lexerClass_1 = naming.getLexerClass(_grammar_1);
        _builder.append(_lexerClass_1, "\t");
        _builder.append(".class));");
        _builder.newLineIfNotEmpty();
      }
    };
    final GuiceModuleAccess.BindingFactory uiBindings = _addTypeToType_2.addConfiguredBinding("ContentAssistLexerProvider", _client_3);
    if (this.partialParsing) {
      TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory");
      TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.xtext.ide.editor.contentassist.antlr.PartialContentAssistContextFactory");
      uiBindings.addTypeToType(_typeRef_4, _typeRef_5);
    }
    IXtextGeneratorLanguage _language = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language.getEclipsePluginGenModule();
    uiBindings.contributeTo(_eclipsePluginGenModule);
  }
  
  @Pure
  public boolean isDebugGrammar() {
    return this.debugGrammar;
  }
  
  public void setDebugGrammar(final boolean debugGrammar) {
    this.debugGrammar = debugGrammar;
  }
  
  @Pure
  public Boolean getCombinedGrammar() {
    return this.combinedGrammar;
  }
  
  public void setCombinedGrammar(final Boolean combinedGrammar) {
    this.combinedGrammar = combinedGrammar;
  }
  
  @Pure
  public boolean isRemoveBacktrackingGuards() {
    return this.removeBacktrackingGuards;
  }
  
  public void setRemoveBacktrackingGuards(final boolean removeBacktrackingGuards) {
    this.removeBacktrackingGuards = removeBacktrackingGuards;
  }
  
  @Pure
  public boolean isPartialParsing() {
    return this.partialParsing;
  }
  
  public void setPartialParsing(final boolean partialParsing) {
    this.partialParsing = partialParsing;
  }
}

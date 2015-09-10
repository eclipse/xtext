/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.generator.LineSeparatorHarmonizer;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrToolFacade;
import org.eclipse.xtext.xtext.generator.parser.antlr.postProcessing.SuppressWarningsProcessor;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrCodeQualityHelper;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrLexerSplitter;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrParserSplitter;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.BacktrackingGuardForUnorderedGroupsRemover;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.PartialClassExtractor;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.SyntacticPredicateFixup;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.UnorderedGroupsSplitter;

@SuppressWarnings("all")
public abstract class AbstractAntlrGeneratorFragment2 extends AbstractGeneratorFragment2 {
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private AntlrToolFacade antlrTool;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private AntlrCodeQualityHelper codeQualityHelper;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private LineSeparatorHarmonizer newLineNormalizer;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private CodeConfig codeConfig;
  
  @Accessors
  private AntlrOptions options = new AntlrOptions();
  
  private final ArrayList<String> antlrParams = CollectionLiterals.<String>newArrayList();
  
  public void addAntlrParam(final String param) {
    this.antlrParams.add(param);
  }
  
  public String[] getAntlrParams() {
    ArrayList<String> params = Lists.<String>newArrayList(this.antlrParams);
    boolean _contains = params.contains("-Xconversiontimeout");
    boolean _not = (!_contains);
    if (_not) {
      params.add(0, "-Xconversiontimeout");
      params.add(1, "100000");
    }
    return ((String[])Conversions.unwrapArray(params, String.class));
  }
  
  @Override
  public void checkConfiguration(final Issues issues) {
    super.checkConfiguration(issues);
    boolean _isWorkable = this.antlrTool.isWorkable();
    boolean _not = (!_isWorkable);
    if (_not) {
      issues.addError("\n\n*ATTENTION*\nIt is highly recommended to use ANTLR\'s parser generator (get it from \'http://xtext.itemis.com/\'). \nAs an alternative to ANTLR you could also use the alternative implementation shipped with Xtext.\nTo do so use the generator fragment \'org.eclipse.xtext.generator.parser.packrat.PackratParserFragment\' in your mwe2 file instead.");
    }
  }
  
  @Override
  public void generate() {
    this.checkGrammar();
    this.doGenerate();
  }
  
  protected abstract void doGenerate();
  
  protected void checkGrammar() {
    Grammar _grammar = this.getGrammar();
    boolean _hasProductionRules = this.hasProductionRules(_grammar);
    boolean _not = (!_hasProductionRules);
    if (_not) {
      throw new IllegalArgumentException("You may not generate an ANTLR parser for a grammar without production rules.");
    }
  }
  
  protected boolean hasProductionRules(final Grammar grammar) {
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule firstRule = _rules.get(0);
    boolean _and = false;
    if (!(firstRule instanceof ParserRule)) {
      _and = false;
    } else {
      boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(((ParserRule) firstRule));
      boolean _not = (!_isDatatypeRule);
      _and = _not;
    }
    return _and;
  }
  
  protected void splitLexerClassFile(final IXtextGeneratorFileSystemAccess fsa, final String filename) {
    CharSequence _readTextFile = fsa.readTextFile(filename);
    final String content = _readTextFile.toString();
    AntlrLexerSplitter splitter = new AntlrLexerSplitter(content);
    String _transform = splitter.transform();
    fsa.generateFile(filename, _transform);
  }
  
  protected void splitParserClassFile(final IXtextGeneratorFileSystemAccess fsa, final String filename) {
    CharSequence _readTextFile = fsa.readTextFile(filename);
    final String content = _readTextFile.toString();
    AntlrOptions _options = this.getOptions();
    int _fieldsPerClass = _options.getFieldsPerClass();
    final AntlrParserSplitter splitter = new AntlrParserSplitter(content, _fieldsPerClass);
    String _transform = splitter.transform();
    AntlrOptions _options_1 = this.getOptions();
    int _methodsPerClass = _options_1.getMethodsPerClass();
    final PartialClassExtractor extractor = new PartialClassExtractor(_transform, _methodsPerClass);
    String _transform_1 = extractor.transform();
    fsa.generateFile(filename, _transform_1);
  }
  
  protected void simplifyUnorderedGroupPredicatesIfRequired(final Grammar grammar, final IXtextGeneratorFileSystemAccess fsa, final String parserFileName) {
    boolean _or = false;
    boolean _containsUnorderedGroup = this.containsUnorderedGroup(grammar);
    if (_containsUnorderedGroup) {
      _or = true;
    } else {
      boolean _hasParameterizedRules = this.hasParameterizedRules(grammar);
      _or = _hasParameterizedRules;
    }
    if (_or) {
      String _parserFileNameSuffix = this.getParserFileNameSuffix();
      final String javaFile = parserFileName.replaceAll("\\.g$", _parserFileNameSuffix);
      this.simplifyUnorderedGroupPredicates(fsa, javaFile);
    }
  }
  
  protected boolean hasParameterizedRules(final Grammar grammar) {
    List<ParserRule> _allParserRules = GrammarUtil.allParserRules(grammar);
    for (final ParserRule rule : _allParserRules) {
      EList<Parameter> _parameters = rule.getParameters();
      boolean _isEmpty = _parameters.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        return true;
      }
    }
    return false;
  }
  
  protected String getParserFileNameSuffix() {
    return "Parser.java";
  }
  
  protected void simplifyUnorderedGroupPredicates(final IXtextGeneratorFileSystemAccess fsa, final String fileName) {
    CharSequence _readTextFile = fsa.readTextFile(fileName);
    final String content = _readTextFile.toString();
    UnorderedGroupsSplitter splitter = new UnorderedGroupsSplitter(content);
    String transformed = splitter.transform();
    SyntacticPredicateFixup fixup = new SyntacticPredicateFixup(transformed);
    String _transform = fixup.transform();
    transformed = _transform;
    BacktrackingGuardForUnorderedGroupsRemover remover = new BacktrackingGuardForUnorderedGroupsRemover(transformed);
    String newContent = remover.transform();
    fsa.generateFile(fileName, newContent);
  }
  
  private void suppressWarningsImpl(final IXtextGeneratorFileSystemAccess fsa, final String javaFile) {
    CharSequence _readTextFile = fsa.readTextFile(javaFile);
    final String content = _readTextFile.toString();
    SuppressWarningsProcessor _suppressWarningsProcessor = new SuppressWarningsProcessor();
    final String newContent = _suppressWarningsProcessor.process(content);
    fsa.generateFile(javaFile, newContent);
  }
  
  protected void suppressWarnings(final IXtextGeneratorFileSystemAccess fsa, final String grammarFileName) {
    this.suppressWarnings(fsa, grammarFileName, grammarFileName);
  }
  
  protected void suppressWarnings(final IXtextGeneratorFileSystemAccess fsa, final String lexerGrammarFileName, final String parserGrammarFileName) {
    String _lexerFileNameSuffix = this.getLexerFileNameSuffix();
    String _replaceAll = lexerGrammarFileName.replaceAll("\\.g$", _lexerFileNameSuffix);
    this.suppressWarningsImpl(fsa, _replaceAll);
    String _parserFileNameSuffix = this.getParserFileNameSuffix();
    String _replaceAll_1 = parserGrammarFileName.replaceAll("\\.g$", _parserFileNameSuffix);
    this.suppressWarningsImpl(fsa, _replaceAll_1);
  }
  
  private void normalizeLineDelimitersImpl(final IXtextGeneratorFileSystemAccess fsa, final String textFile) {
    CharSequence _readTextFile = fsa.readTextFile(textFile);
    String content = _readTextFile.toString();
    URI _uRI = fsa.getURI(textFile);
    CharSequence _postProcess = this.newLineNormalizer.postProcess(_uRI, content);
    String _string = _postProcess.toString();
    content = _string;
    String _replaceAll = content.replaceAll("\"\\+(\\r)?\\n\\s+\"", "");
    content = _replaceAll;
    fsa.generateFile(textFile, content);
  }
  
  protected void normalizeLineDelimiters(final IXtextGeneratorFileSystemAccess fsa, final String grammarFileName) {
    this.normalizeLineDelimiters(fsa, grammarFileName, grammarFileName);
  }
  
  protected void normalizeTokens(final IXtextGeneratorFileSystemAccess fsa, final String grammarFileName) {
    final String tokenFile = this.toTokenFileName(grammarFileName);
    CharSequence _readTextFile = fsa.readTextFile(tokenFile);
    String content = _readTextFile.toString();
    URI _uRI = fsa.getURI(tokenFile);
    CharSequence _postProcess = this.newLineNormalizer.postProcess(_uRI, content);
    String _string = _postProcess.toString();
    content = _string;
    String _lineDelimiter = this.codeConfig.getLineDelimiter();
    final List<String> splitted = Strings.split(content, _lineDelimiter);
    Collections.<String>sort(splitted);
    String _lineDelimiter_1 = this.codeConfig.getLineDelimiter();
    String _concat = Strings.concat(_lineDelimiter_1, splitted);
    String _lineDelimiter_2 = this.codeConfig.getLineDelimiter();
    String _plus = (_concat + _lineDelimiter_2);
    content = _plus;
    fsa.generateFile(tokenFile, content);
  }
  
  private String toTokenFileName(final String grammarFileName) {
    return grammarFileName.replaceAll("\\.g$", ".tokens");
  }
  
  protected void normalizeLineDelimiters(final IXtextGeneratorFileSystemAccess fsa, final String lexerGrammarFileName, final String parserGrammarFileName) {
    String _lexerFileNameSuffix = this.getLexerFileNameSuffix();
    String _replaceAll = lexerGrammarFileName.replaceAll("\\.g$", _lexerFileNameSuffix);
    this.normalizeLineDelimitersImpl(fsa, _replaceAll);
    String _parserFileNameSuffix = this.getParserFileNameSuffix();
    String _replaceAll_1 = parserGrammarFileName.replaceAll("\\.g$", _parserFileNameSuffix);
    this.normalizeLineDelimitersImpl(fsa, _replaceAll_1);
  }
  
  protected String getLexerFileNameSuffix() {
    return "Lexer.java";
  }
  
  protected void splitParserAndLexerIfEnabled(final IXtextGeneratorFileSystemAccess fsa, final String lexerGrammarFileName, final String parserGrammarFileName) {
    String _lexerFileNameSuffix = this.getLexerFileNameSuffix();
    final String lexerJavaFile = lexerGrammarFileName.replaceAll("\\.g$", _lexerFileNameSuffix);
    String _parserFileNameSuffix = this.getParserFileNameSuffix();
    final String parserJavaFile = parserGrammarFileName.replaceAll("\\.g$", _parserFileNameSuffix);
    if ((this.codeQualityHelper != null)) {
      this.codeQualityHelper.stripUnnecessaryComments(fsa, lexerJavaFile, parserJavaFile);
      this.codeQualityHelper.removeDuplicateBitsets(fsa, parserJavaFile);
    }
    AntlrOptions _options = this.getOptions();
    boolean _isClassSplitting = _options.isClassSplitting();
    if (_isClassSplitting) {
      this.splitLexerClassFile(fsa, lexerJavaFile);
      this.splitParserClassFile(fsa, parserJavaFile);
    }
  }
  
  protected void splitParserAndLexerIfEnabled(final IXtextGeneratorFileSystemAccess fsa, final String grammarFileName) {
    this.splitParserAndLexerIfEnabled(fsa, grammarFileName, grammarFileName);
  }
  
  protected boolean containsUnorderedGroup(final Grammar grammar) {
    List<ParserRule> _allParserRules = GrammarUtil.allParserRules(grammar);
    for (final ParserRule rule : _allParserRules) {
      TreeIterator<EObject> _eAllContents = rule.eAllContents();
      UnmodifiableIterator<UnorderedGroup> _filter = Iterators.<UnorderedGroup>filter(_eAllContents, UnorderedGroup.class);
      boolean _hasNext = _filter.hasNext();
      if (_hasNext) {
        return true;
      }
    }
    return false;
  }
  
  @Pure
  protected AntlrToolFacade getAntlrTool() {
    return this.antlrTool;
  }
  
  @Pure
  protected AntlrCodeQualityHelper getCodeQualityHelper() {
    return this.codeQualityHelper;
  }
  
  @Pure
  protected LineSeparatorHarmonizer getNewLineNormalizer() {
    return this.newLineNormalizer;
  }
  
  @Pure
  protected CodeConfig getCodeConfig() {
    return this.codeConfig;
  }
  
  @Pure
  public AntlrOptions getOptions() {
    return this.options;
  }
  
  public void setOptions(final AntlrOptions options) {
    this.options = options;
  }
}

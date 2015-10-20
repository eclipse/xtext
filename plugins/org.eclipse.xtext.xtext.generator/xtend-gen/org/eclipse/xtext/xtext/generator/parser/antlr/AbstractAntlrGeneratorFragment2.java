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
import java.io.CharArrayWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammar;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrToolFacade;
import org.eclipse.xtext.xtext.generator.parser.antlr.KeywordHelper;
import org.eclipse.xtext.xtext.generator.parser.antlr.MutableTokenDefProvider;
import org.eclipse.xtext.xtext.generator.parser.antlr.postProcessing.SuppressWarningsProcessor;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrCodeQualityHelper;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrLexerSplitter;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.AntlrParserSplitter;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.BacktrackingGuardForUnorderedGroupsRemover;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.BacktrackingGuardRemover;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.PartialClassExtractor;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.SyntacticPredicateFixup;
import org.eclipse.xtext.xtext.generator.parser.antlr.splitting.UnorderedGroupsSplitter;

@SuppressWarnings("all")
public abstract class AbstractAntlrGeneratorFragment2 extends AbstractXtextGeneratorFragment {
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
  
  protected void splitLexerClassFile(final IXtextGeneratorFileSystemAccess fsa, final TypeReference lexer) {
    String _javaPath = lexer.getJavaPath();
    CharSequence _readTextFile = fsa.readTextFile(_javaPath);
    final String content = _readTextFile.toString();
    AntlrLexerSplitter splitter = new AntlrLexerSplitter(content);
    String _javaPath_1 = lexer.getJavaPath();
    String _transform = splitter.transform();
    fsa.generateFile(_javaPath_1, _transform);
  }
  
  protected void splitParserClassFile(final IXtextGeneratorFileSystemAccess fsa, final TypeReference parser) {
    String _javaPath = parser.getJavaPath();
    CharSequence _readTextFile = fsa.readTextFile(_javaPath);
    final String content = _readTextFile.toString();
    AntlrOptions _options = this.getOptions();
    int _fieldsPerClass = _options.getFieldsPerClass();
    final AntlrParserSplitter splitter = new AntlrParserSplitter(content, _fieldsPerClass);
    String _transform = splitter.transform();
    AntlrOptions _options_1 = this.getOptions();
    int _methodsPerClass = _options_1.getMethodsPerClass();
    final PartialClassExtractor extractor = new PartialClassExtractor(_transform, _methodsPerClass);
    String _javaPath_1 = parser.getJavaPath();
    String _transform_1 = extractor.transform();
    fsa.generateFile(_javaPath_1, _transform_1);
  }
  
  protected void simplifyUnorderedGroupPredicatesIfRequired(final Grammar grammar, final IXtextGeneratorFileSystemAccess fsa, final TypeReference parser) {
    boolean _or = false;
    boolean _containsUnorderedGroup = this.containsUnorderedGroup(grammar);
    if (_containsUnorderedGroup) {
      _or = true;
    } else {
      boolean _hasParameterizedRules = this.hasParameterizedRules(grammar);
      _or = _hasParameterizedRules;
    }
    if (_or) {
      this.simplifyUnorderedGroupPredicates(fsa, parser);
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
  
  protected void simplifyUnorderedGroupPredicates(final IXtextGeneratorFileSystemAccess fsa, final TypeReference parser) {
    String _javaPath = parser.getJavaPath();
    CharSequence _readTextFile = fsa.readTextFile(_javaPath);
    final String content = _readTextFile.toString();
    UnorderedGroupsSplitter splitter = new UnorderedGroupsSplitter(content);
    String transformed = splitter.transform();
    SyntacticPredicateFixup fixup = new SyntacticPredicateFixup(transformed);
    String _transform = fixup.transform();
    transformed = _transform;
    BacktrackingGuardForUnorderedGroupsRemover remover = new BacktrackingGuardForUnorderedGroupsRemover(transformed);
    String newContent = remover.transform();
    String _javaPath_1 = parser.getJavaPath();
    fsa.generateFile(_javaPath_1, newContent);
  }
  
  protected void suppressWarnings(final IXtextGeneratorFileSystemAccess fsa, final TypeReference type) {
    String _javaPath = type.getJavaPath();
    CharSequence _readTextFile = fsa.readTextFile(_javaPath);
    final String content = _readTextFile.toString();
    SuppressWarningsProcessor _suppressWarningsProcessor = new SuppressWarningsProcessor();
    final String newContent = _suppressWarningsProcessor.process(content);
    String _javaPath_1 = type.getJavaPath();
    fsa.generateFile(_javaPath_1, newContent);
  }
  
  protected void suppressWarnings(final IXtextGeneratorFileSystemAccess fsa, final TypeReference... types) {
    final Procedure1<TypeReference> _function = new Procedure1<TypeReference>() {
      @Override
      public void apply(final TypeReference it) {
        AbstractAntlrGeneratorFragment2.this.suppressWarnings(fsa, it);
      }
    };
    IterableExtensions.<TypeReference>forEach(((Iterable<TypeReference>)Conversions.doWrapArray(types)), _function);
  }
  
  protected void normalizeLineDelimiters(final IXtextGeneratorFileSystemAccess fsa, final TypeReference type) {
    String _javaPath = type.getJavaPath();
    CharSequence _readTextFile = fsa.readTextFile(_javaPath);
    String content = _readTextFile.toString();
    String _javaPath_1 = type.getJavaPath();
    URI _uRI = fsa.getURI(_javaPath_1);
    CharSequence _postProcess = this.newLineNormalizer.postProcess(_uRI, content);
    String _string = _postProcess.toString();
    content = _string;
    String _replaceAll = content.replaceAll("\"\\+(\\r)?\\n\\s+\"", "");
    content = _replaceAll;
    String _javaPath_2 = type.getJavaPath();
    fsa.generateFile(_javaPath_2, content);
  }
  
  protected void normalizeLineDelimiters(final IXtextGeneratorFileSystemAccess fsa, final TypeReference... types) {
    final Procedure1<TypeReference> _function = new Procedure1<TypeReference>() {
      @Override
      public void apply(final TypeReference it) {
        AbstractAntlrGeneratorFragment2.this.normalizeLineDelimiters(fsa, it);
      }
    };
    IterableExtensions.<TypeReference>forEach(((Iterable<TypeReference>)Conversions.doWrapArray(types)), _function);
  }
  
  protected void normalizeTokens(final IXtextGeneratorFileSystemAccess fsa, final String tokenFile) {
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
  
  protected void splitParserAndLexerIfEnabled(final IXtextGeneratorFileSystemAccess fsa, final TypeReference parser, final TypeReference lexer) {
    this.improveCodeQuality(fsa, lexer, parser);
    AntlrOptions _options = this.getOptions();
    boolean _isClassSplitting = _options.isClassSplitting();
    if (_isClassSplitting) {
      this.splitLexerClassFile(fsa, lexer);
      this.splitParserClassFile(fsa, parser);
    }
  }
  
  protected void improveCodeQuality(final IXtextGeneratorFileSystemAccess fsa, final TypeReference lexer, final TypeReference parser) {
    String _javaPath = lexer.getJavaPath();
    CharSequence _readTextFile = fsa.readTextFile(_javaPath);
    String lexerContent = _readTextFile.toString();
    String _stripUnnecessaryComments = this.codeQualityHelper.stripUnnecessaryComments(lexerContent, this.options);
    lexerContent = _stripUnnecessaryComments;
    String _javaPath_1 = lexer.getJavaPath();
    fsa.generateFile(_javaPath_1, lexerContent);
    String _javaPath_2 = parser.getJavaPath();
    CharSequence _readTextFile_1 = fsa.readTextFile(_javaPath_2);
    String parserContent = _readTextFile_1.toString();
    String _stripUnnecessaryComments_1 = this.codeQualityHelper.stripUnnecessaryComments(parserContent, this.options);
    parserContent = _stripUnnecessaryComments_1;
    String _removeDuplicateBitsets = this.codeQualityHelper.removeDuplicateBitsets(parserContent, this.options);
    parserContent = _removeDuplicateBitsets;
    String _removeDuplicateDFAs = this.codeQualityHelper.removeDuplicateDFAs(parserContent, this.options);
    parserContent = _removeDuplicateDFAs;
    String _javaPath_3 = parser.getJavaPath();
    fsa.generateFile(_javaPath_3, parserContent);
  }
  
  protected void cleanupLexerTokensFile(final AntlrGrammar lexerGrammar, final KeywordHelper helper, final IXtextGeneratorFileSystemAccess fsa) {
    try {
      boolean _isBacktrackLexer = this.options.isBacktrackLexer();
      if (_isBacktrackLexer) {
        final MutableTokenDefProvider provider = this.createLexerTokensProvider(lexerGrammar, helper, fsa);
        Map<Integer, String> _tokenDefMap = provider.getTokenDefMap();
        Set<Map.Entry<Integer, String>> _entrySet = _tokenDefMap.entrySet();
        final Iterator<Map.Entry<Integer, String>> entries = _entrySet.iterator();
        while (entries.hasNext()) {
          {
            Map.Entry<Integer, String> _next = entries.next();
            final String value = _next.getValue();
            boolean _and = false;
            boolean _and_1 = false;
            boolean _isKeywordRule = helper.isKeywordRule(value);
            boolean _not = (!_isKeywordRule);
            if (!_not) {
              _and_1 = false;
            } else {
              boolean _startsWith = value.startsWith("RULE_");
              boolean _not_1 = (!_startsWith);
              _and_1 = _not_1;
            }
            if (!_and_1) {
              _and = false;
            } else {
              boolean _startsWith_1 = value.startsWith("SUPER_");
              boolean _not_2 = (!_startsWith_1);
              _and = _not_2;
            }
            if (_and) {
              entries.remove();
            }
          }
        }
        final CharArrayWriter writer = new CharArrayWriter();
        PrintWriter _printWriter = new PrintWriter(writer);
        provider.writeTokenFile(_printWriter);
        String _tokensFileName = lexerGrammar.getTokensFileName();
        char[] _charArray = writer.toCharArray();
        String _string = new String(_charArray);
        fsa.generateFile(_tokensFileName, _string);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected MutableTokenDefProvider createLexerTokensProvider(final AntlrGrammar lexerGrammar, final KeywordHelper helper, final IXtextGeneratorFileSystemAccess fsa) {
    String _encoding = this.codeConfig.getEncoding();
    Charset _forName = Charset.forName(_encoding);
    final MutableTokenDefProvider provider = new MutableTokenDefProvider(helper, _forName);
    final IAntlrTokenFileProvider _function = new IAntlrTokenFileProvider() {
      @Override
      public InputStream getAntlrTokenFile() {
        String _tokensFileName = lexerGrammar.getTokensFileName();
        return fsa.readBinaryFile(_tokensFileName);
      }
    };
    provider.setAntlrTokenFileProvider(_function);
    return provider;
  }
  
  protected void cleanupParserTokensFile(final AntlrGrammar lexerGrammar, final AntlrGrammar parserGrammar, final KeywordHelper helper, final IXtextGeneratorFileSystemAccess fsa) {
    try {
      final MutableTokenDefProvider provider = this.createLexerTokensProvider(lexerGrammar, helper, fsa);
      Map<Integer, String> _tokenDefMap = provider.getTokenDefMap();
      Set<Map.Entry<Integer, String>> _entrySet = _tokenDefMap.entrySet();
      for (final Map.Entry<Integer, String> entry : _entrySet) {
        {
          final String value = entry.getValue();
          boolean _isKeywordRule = helper.isKeywordRule(value);
          if (_isKeywordRule) {
            String _keywordValue = helper.getKeywordValue(value);
            final String keywordAsAntlrString = AntlrGrammarGenUtil.toAntlrString(_keywordValue);
            entry.setValue((("\'" + keywordAsAntlrString) + "\'"));
          } else {
            boolean _startsWith = value.startsWith("\'");
            if (_startsWith) {
              String _antlrString = AntlrGrammarGenUtil.toAntlrString(value);
              String _plus = ("\'" + _antlrString);
              String _plus_1 = (_plus + "\'");
              entry.setValue(_plus_1);
            }
          }
        }
      }
      final CharArrayWriter writer = new CharArrayWriter();
      PrintWriter _printWriter = new PrintWriter(writer);
      provider.writeTokenFile(_printWriter);
      String _tokensFileName = parserGrammar.getTokensFileName();
      char[] _charArray = writer.toCharArray();
      String _string = new String(_charArray);
      fsa.generateFile(_tokensFileName, _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void removeBackTrackingGuards(final IXtextGeneratorFileSystemAccess fsa, final TypeReference parser, final int lookaheadThreshold) {
    String _javaPath = parser.getJavaPath();
    CharSequence _readTextFile = fsa.readTextFile(_javaPath);
    final String content = _readTextFile.toString();
    final BacktrackingGuardRemover remover = new BacktrackingGuardRemover(content, lookaheadThreshold);
    final String newContent = remover.transform();
    String _javaPath_1 = parser.getJavaPath();
    fsa.generateFile(_javaPath_1, newContent);
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

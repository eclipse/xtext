/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.generator.LineSeparatorHarmonizer;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
    boolean _hasProductionRules = this.hasProductionRules(this.getGrammar());
    boolean _not = (!_hasProductionRules);
    if (_not) {
      throw new IllegalArgumentException("You may not generate an ANTLR parser for a grammar without production rules.");
    }
  }
  
  protected boolean hasProductionRules(final Grammar grammar) {
    AbstractRule firstRule = grammar.getRules().get(0);
    return ((firstRule instanceof ParserRule) && (!GrammarUtil.isDatatypeRule(((ParserRule) firstRule))));
  }
  
  protected void splitLexerClassFile(final IXtextGeneratorFileSystemAccess fsa, final TypeReference lexer) {
    final String content = fsa.readTextFile(lexer.getJavaPath()).toString();
    AntlrLexerSplitter splitter = new AntlrLexerSplitter(content);
    splitter.setCasesPerSpecialStateSwitch(this.options.getCasesPerSpecialStateSwitch());
    fsa.generateFile(lexer.getJavaPath(), splitter.transform());
  }
  
  protected void splitParserClassFile(final IXtextGeneratorFileSystemAccess fsa, final TypeReference parser) {
    final String content = fsa.readTextFile(parser.getJavaPath()).toString();
    int _fieldsPerClass = this.getOptions().getFieldsPerClass();
    final AntlrParserSplitter splitter = new AntlrParserSplitter(content, _fieldsPerClass);
    String _transform = splitter.transform();
    int _methodsPerClass = this.getOptions().getMethodsPerClass();
    final PartialClassExtractor extractor = new PartialClassExtractor(_transform, _methodsPerClass);
    fsa.generateFile(parser.getJavaPath(), extractor.transform());
  }
  
  protected void simplifyUnorderedGroupPredicatesIfRequired(final Grammar grammar, final IXtextGeneratorFileSystemAccess fsa, final TypeReference parser) {
    if ((this.containsUnorderedGroup(grammar) || this.hasParameterizedRules(grammar))) {
      this.simplifyUnorderedGroupPredicates(fsa, parser);
    }
  }
  
  protected boolean hasParameterizedRules(final Grammar grammar) {
    List<ParserRule> _allParserRules = GrammarUtil.allParserRules(grammar);
    for (final ParserRule rule : _allParserRules) {
      boolean _isEmpty = rule.getParameters().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        return true;
      }
    }
    return false;
  }
  
  protected void simplifyUnorderedGroupPredicates(final IXtextGeneratorFileSystemAccess fsa, final TypeReference parser) {
    final String content = fsa.readTextFile(parser.getJavaPath()).toString();
    UnorderedGroupsSplitter splitter = new UnorderedGroupsSplitter(content);
    String transformed = splitter.transform();
    SyntacticPredicateFixup fixup = new SyntacticPredicateFixup(transformed);
    transformed = fixup.transform();
    BacktrackingGuardForUnorderedGroupsRemover remover = new BacktrackingGuardForUnorderedGroupsRemover(transformed);
    String newContent = remover.transform();
    fsa.generateFile(parser.getJavaPath(), newContent);
  }
  
  protected void suppressWarnings(final IXtextGeneratorFileSystemAccess fsa, final TypeReference type) {
    final String content = fsa.readTextFile(type.getJavaPath()).toString();
    final String newContent = new SuppressWarningsProcessor().process(content);
    fsa.generateFile(type.getJavaPath(), newContent);
  }
  
  protected void suppressWarnings(final IXtextGeneratorFileSystemAccess fsa, final TypeReference... types) {
    final Consumer<TypeReference> _function = (TypeReference it) -> {
      this.suppressWarnings(fsa, it);
    };
    ((List<TypeReference>)Conversions.doWrapArray(types)).forEach(_function);
  }
  
  protected void normalizeLineDelimiters(final IXtextGeneratorFileSystemAccess fsa, final TypeReference type) {
    String content = fsa.readTextFile(type.getJavaPath()).toString();
    content = this.newLineNormalizer.postProcess(fsa.getURI(type.getJavaPath()), content).toString();
    content = content.replaceAll("\"\\+(\\r)?\\n\\s+\"", "");
    fsa.generateFile(type.getJavaPath(), content);
  }
  
  protected void normalizeLineDelimiters(final IXtextGeneratorFileSystemAccess fsa, final TypeReference... types) {
    final Consumer<TypeReference> _function = (TypeReference it) -> {
      this.normalizeLineDelimiters(fsa, it);
    };
    ((List<TypeReference>)Conversions.doWrapArray(types)).forEach(_function);
  }
  
  protected void normalizeTokens(final IXtextGeneratorFileSystemAccess fsa, final String tokenFile) {
    String content = fsa.readTextFile(tokenFile).toString();
    content = this.newLineNormalizer.postProcess(fsa.getURI(tokenFile), content).toString();
    final List<String> splitted = Strings.split(content, this.codeConfig.getLineDelimiter());
    Collections.<String>sort(splitted);
    String _concat = Strings.concat(this.codeConfig.getLineDelimiter(), splitted);
    String _lineDelimiter = this.codeConfig.getLineDelimiter();
    String _plus = (_concat + _lineDelimiter);
    content = _plus;
    fsa.generateFile(tokenFile, content);
  }
  
  protected void splitParserAndLexerIfEnabled(final IXtextGeneratorFileSystemAccess fsa, final TypeReference parser, final TypeReference lexer) {
    this.improveCodeQuality(fsa, lexer, parser);
    boolean _isClassSplitting = this.getOptions().isClassSplitting();
    if (_isClassSplitting) {
      this.splitLexerClassFile(fsa, lexer);
      this.splitParserClassFile(fsa, parser);
    }
  }
  
  protected void improveCodeQuality(final IXtextGeneratorFileSystemAccess fsa, final TypeReference lexer, final TypeReference parser) {
    this.improveLexerCodeQuality(fsa, lexer);
    this.improveParserCodeQuality(fsa, parser);
  }
  
  protected void improveParserCodeQuality(final IXtextGeneratorFileSystemAccess fsa, final TypeReference parser) {
    String parserContent = fsa.readTextFile(parser.getJavaPath()).toString();
    parserContent = this.codeQualityHelper.stripUnnecessaryComments(parserContent, this.options);
    parserContent = this.codeQualityHelper.removeDuplicateBitsets(parserContent, this.options);
    parserContent = this.codeQualityHelper.removeDuplicateDFAs(parserContent, this.options);
    fsa.generateFile(parser.getJavaPath(), parserContent);
  }
  
  protected void improveLexerCodeQuality(final IXtextGeneratorFileSystemAccess fsa, final TypeReference lexer) {
    String lexerContent = fsa.readTextFile(lexer.getJavaPath()).toString();
    lexerContent = this.codeQualityHelper.stripUnnecessaryComments(lexerContent, this.options);
    fsa.generateFile(lexer.getJavaPath(), lexerContent);
  }
  
  protected void cleanupLexerTokensFile(final AntlrGrammar lexerGrammar, final KeywordHelper helper, final IXtextGeneratorFileSystemAccess fsa) {
    try {
      boolean _isBacktrackLexer = this.options.isBacktrackLexer();
      if (_isBacktrackLexer) {
        final MutableTokenDefProvider provider = this.createLexerTokensProvider(lexerGrammar, helper, fsa);
        final Iterator<Map.Entry<Integer, String>> entries = provider.getTokenDefMap().entrySet().iterator();
        while (entries.hasNext()) {
          {
            final String value = entries.next().getValue();
            if ((((!helper.isKeywordRule(value)) && (!value.startsWith("RULE_"))) && (!value.startsWith("SUPER_")))) {
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
    Charset _forName = Charset.forName(this.codeConfig.getEncoding());
    final MutableTokenDefProvider provider = new MutableTokenDefProvider(helper, _forName);
    final IAntlrTokenFileProvider _function = () -> {
      return fsa.readBinaryFile(lexerGrammar.getTokensFileName());
    };
    provider.setAntlrTokenFileProvider(_function);
    return provider;
  }
  
  protected void cleanupParserTokensFile(final AntlrGrammar lexerGrammar, final AntlrGrammar parserGrammar, final KeywordHelper helper, final IXtextGeneratorFileSystemAccess fsa) {
    try {
      final MutableTokenDefProvider provider = this.createLexerTokensProvider(lexerGrammar, helper, fsa);
      Set<Map.Entry<Integer, String>> _entrySet = provider.getTokenDefMap().entrySet();
      for (final Map.Entry<Integer, String> entry : _entrySet) {
        {
          final String value = entry.getValue();
          boolean _isKeywordRule = helper.isKeywordRule(value);
          if (_isKeywordRule) {
            final String keywordAsAntlrString = AntlrGrammarGenUtil.toAntlrString(helper.getKeywordValue(value));
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
    final String content = fsa.readTextFile(parser.getJavaPath()).toString();
    final BacktrackingGuardRemover remover = new BacktrackingGuardRemover(content, lookaheadThreshold);
    final String newContent = remover.transform();
    fsa.generateFile(parser.getJavaPath(), newContent);
  }
  
  protected boolean containsUnorderedGroup(final Grammar grammar) {
    List<ParserRule> _allParserRules = GrammarUtil.allParserRules(grammar);
    for (final ParserRule rule : _allParserRules) {
      boolean _hasNext = Iterators.<UnorderedGroup>filter(rule.eAllContents(), UnorderedGroup.class).hasNext();
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

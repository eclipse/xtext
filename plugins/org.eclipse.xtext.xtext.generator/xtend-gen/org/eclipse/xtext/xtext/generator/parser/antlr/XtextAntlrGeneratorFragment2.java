/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Names;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ITokenToStringConverter;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.ILanguageConfig;
import org.eclipse.xtext.xtext.generator.IRuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.Issues;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.ManifestAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrToolFacade;
import org.eclipse.xtext.xtext.generator.parser.antlr.GrammarNaming;

@SuppressWarnings("all")
public class XtextAntlrGeneratorFragment2 extends AbstractAntlrGeneratorFragment2 {
  @Inject
  private AntlrGrammarGenerator generator;
  
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  private FileAccessFactory fileFactory;
  
  @Inject
  @Extension
  private GrammarNaming _grammarNaming;
  
  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;
  
  @Override
  protected void doGenerate() {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    IRuntimeProjectConfig _runtime = _projectConfig.getRuntime();
    final IXtextGeneratorFileSystemAccess fsa = _runtime.getSrcGen();
    Grammar _grammar = this.getGrammar();
    AntlrOptions _options = this.getOptions();
    this.generator.generate(_grammar, _options, fsa);
    final String encoding = this.codeConfig.getEncoding();
    StringConcatenation _builder = new StringConcatenation();
    Grammar _grammar_1 = this.getGrammar();
    TypeReference _grammarClass = this._grammarNaming.getGrammarClass(_grammar_1);
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
    JavaFileAccess _generateXtextParser = this.generateXtextParser();
    IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
    IRuntimeProjectConfig _runtime_1 = _projectConfig_1.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen = _runtime_1.getSrcGen();
    _generateXtextParser.writeTo(_srcGen);
    JavaFileAccess _generateAntlrTokenFileProvider = this.generateAntlrTokenFileProvider();
    IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
    IRuntimeProjectConfig _runtime_2 = _projectConfig_2.getRuntime();
    IXtextGeneratorFileSystemAccess _srcGen_1 = _runtime_2.getSrcGen();
    _generateAntlrTokenFileProvider.writeTo(_srcGen_1);
    this.addBindingsAndImports();
  }
  
  public JavaFileAccess generateXtextParser() {
    GeneratedJavaFileAccess _xblockexpression = null;
    {
      Grammar _grammar = this.getGrammar();
      TypeReference _parserClass = this._grammarNaming.getParserClass(_grammar);
      final GeneratedJavaFileAccess file = this.fileFactory.createGeneratedJavaFile(_parserClass);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _parserClass = XtextAntlrGeneratorFragment2.this._grammarNaming.getParserClass(_grammar);
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
          TypeReference _grammarAccess = XtextAntlrGeneratorFragment2.this._grammarAccessExtensions.getGrammarAccess(_grammar_1);
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
            List<String> _initialHiddenTokens = XtextAntlrGeneratorFragment2.this._grammarAccessExtensions.initialHiddenTokens(_grammar_2);
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
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("protected ");
          Grammar _grammar_3 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserClass = XtextAntlrGeneratorFragment2.this._grammarNaming.getInternalParserClass(_grammar_3);
          _builder.append(_internalParserClass, "\t");
          _builder.append(" createParser(");
          _builder.append(XtextTokenStream.class, "\t");
          _builder.append(" stream) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("return new ");
          Grammar _grammar_4 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _internalParserClass_1 = XtextAntlrGeneratorFragment2.this._grammarNaming.getInternalParserClass(_grammar_4);
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
          Grammar _grammar_5 = XtextAntlrGeneratorFragment2.this.getGrammar();
          List<ParserRule> _allParserRules = GrammarUtil.allParserRules(_grammar_5);
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
          Grammar _grammar_6 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _grammarAccess_1 = XtextAntlrGeneratorFragment2.this._grammarAccessExtensions.getGrammarAccess(_grammar_6);
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
          Grammar _grammar_7 = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _grammarAccess_2 = XtextAntlrGeneratorFragment2.this._grammarAccessExtensions.getGrammarAccess(_grammar_7);
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
      Grammar _grammar = this.getGrammar();
      TypeReference _antlrTokenFileProviderClass = this._grammarNaming.getAntlrTokenFileProviderClass(_grammar);
      final GeneratedJavaFileAccess file = this.fileFactory.createGeneratedJavaFile(_antlrTokenFileProviderClass);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("public class ");
          Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
          TypeReference _antlrTokenFileProviderClass = XtextAntlrGeneratorFragment2.this._grammarNaming.getAntlrTokenFileProviderClass(_grammar);
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
          String _tokenFileName = XtextAntlrGeneratorFragment2.this._grammarNaming.getTokenFileName(_grammar_1);
          _builder.append(_tokenFileName, "\t\t");
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
  
  @Override
  public void checkConfiguration(final Issues issues) {
    super.checkConfiguration(issues);
    AntlrOptions _options = this.getOptions();
    boolean _isBacktrackLexer = _options.isBacktrackLexer();
    if (_isBacktrackLexer) {
      issues.addError("This fragment does not support the option \'backtracking\' for the lexer. Use \'org.eclipse.xtext.xtext.generator.parser.antlr.ex.rt.AntlrGeneratorFragment2\' instead");
    }
    AntlrOptions _options_1 = this.getOptions();
    boolean _isIgnoreCase = _options_1.isIgnoreCase();
    if (_isIgnoreCase) {
      issues.addError("This fragment does not support the option \'ignorecase\'. Use \'org.eclipse.xtext.xtext.generator.parser.antlr.ex.rt.AntlrGeneratorFragment2\' instead");
    }
  }
  
  public void addBindingsAndImports() {
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
          String _parserPackage = XtextAntlrGeneratorFragment2.this._grammarNaming.getParserPackage(_grammar);
          Grammar _grammar_1 = XtextAntlrGeneratorFragment2.this.getGrammar();
          String _internalParserPackage = XtextAntlrGeneratorFragment2.this._grammarNaming.getInternalParserPackage(_grammar_1);
          Iterables.<String>addAll(_exportedPackages, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_parserPackage, _internalParserPackage)));
          Set<String> _requiredBundles = it.getRequiredBundles();
          _requiredBundles.add("org.antlr.runtime");
        }
      };
      ObjectExtensions.<ManifestAccess>operator_doubleArrow(_manifest_1, _function);
    }
    GuiceModuleAccess.BindingFactory _bindingFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef(IParser.class);
    Grammar _grammar = this.getGrammar();
    TypeReference _parserClass = this._grammarNaming.getParserClass(_grammar);
    GuiceModuleAccess.BindingFactory _addTypeToType = _bindingFactory.addTypeToType(_typeRef, _parserClass);
    TypeReference _typeRef_1 = TypeReference.typeRef(ITokenToStringConverter.class);
    TypeReference _typeRef_2 = TypeReference.typeRef(AntlrTokenToStringConverter.class);
    GuiceModuleAccess.BindingFactory _addTypeToType_1 = _addTypeToType.addTypeToType(_typeRef_1, _typeRef_2);
    TypeReference _typeRef_3 = TypeReference.typeRef(IAntlrTokenFileProvider.class);
    Grammar _grammar_1 = this.getGrammar();
    TypeReference _antlrTokenFileProviderClass = this._grammarNaming.getAntlrTokenFileProviderClass(_grammar_1);
    GuiceModuleAccess.BindingFactory _addTypeToType_2 = _addTypeToType_1.addTypeToType(_typeRef_3, _antlrTokenFileProviderClass);
    TypeReference _typeRef_4 = TypeReference.typeRef(Lexer.class);
    Grammar _grammar_2 = this.getGrammar();
    TypeReference _lexerClass = this._grammarNaming.getLexerClass(_grammar_2);
    GuiceModuleAccess.BindingFactory _addTypeToType_3 = _addTypeToType_2.addTypeToType(_typeRef_4, _lexerClass);
    TypeReference _typeRef_5 = TypeReference.typeRef(ITokenDefProvider.class);
    TypeReference _typeRef_6 = TypeReference.typeRef(AntlrTokenDefProvider.class);
    GuiceModuleAccess.BindingFactory _addTypeToType_4 = _addTypeToType_3.addTypeToType(_typeRef_5, _typeRef_6);
    Grammar _grammar_3 = this.getGrammar();
    TypeReference _lexerClass_1 = this._grammarNaming.getLexerClass(_grammar_3);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(LexerProvider.class, "");
        _builder.append(".create(");
        Grammar _grammar = XtextAntlrGeneratorFragment2.this.getGrammar();
        TypeReference _lexerClass = XtextAntlrGeneratorFragment2.this._grammarNaming.getLexerClass(_grammar);
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
        TypeReference _lexerClass = XtextAntlrGeneratorFragment2.this._grammarNaming.getLexerClass(_grammar);
        _builder.append(_lexerClass, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    };
    final GuiceModuleAccess.BindingFactory rtBindings = _addTypeToProviderInstance.addConfiguredBinding("RuntimeLexer", _client_1);
    Grammar _grammar_4 = this.getGrammar();
    boolean _containsUnorderedGroup = this.containsUnorderedGroup(_grammar_4);
    if (_containsUnorderedGroup) {
      TypeReference _typeRef_7 = TypeReference.typeRef(IUnorderedGroupHelper.class);
      TypeReference _typeRef_8 = TypeReference.typeRef(UnorderedGroupHelper.class);
      rtBindings.addTypeToType(_typeRef_7, _typeRef_8);
    }
    ILanguageConfig _language = this.getLanguage();
    GuiceModuleAccess _runtimeGenModule = _language.getRuntimeGenModule();
    rtBindings.contributeTo(_runtimeGenModule);
    GuiceModuleAccess.BindingFactory _bindingFactory_1 = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef_9 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper");
    TypeReference _typeRef_10 = TypeReference.typeRef("org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper");
    GuiceModuleAccess.BindingFactory _addTypeToType_5 = _bindingFactory_1.addTypeToType(_typeRef_9, _typeRef_10);
    StringConcatenationClient _client_2 = new StringConcatenationClient() {
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
        TypeReference _lexerClass = XtextAntlrGeneratorFragment2.this._grammarNaming.getLexerClass(_grammar);
        _builder.append(_lexerClass, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    };
    GuiceModuleAccess.BindingFactory _addConfiguredBinding = _addTypeToType_5.addConfiguredBinding("HighlightingLexer", _client_2);
    StringConcatenationClient _client_3 = new StringConcatenationClient() {
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
    GuiceModuleAccess.BindingFactory _addConfiguredBinding_1 = _addConfiguredBinding.addConfiguredBinding("HighlightingTokenDefProvider", _client_3);
    ILanguageConfig _language_1 = this.getLanguage();
    GuiceModuleAccess _eclipsePluginGenModule = _language_1.getEclipsePluginGenModule();
    _addConfiguredBinding_1.contributeTo(_eclipsePluginGenModule);
  }
}

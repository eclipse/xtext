/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.idea;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.service.LanguageSpecific;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.idea.IdeaPluginClassNames;
import org.eclipse.xtext.xtext.generator.idea.IdeaPluginExtension;
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory;
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;
import org.eclipse.xtext.xtext.generator.model.project.ISubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.parser.antlr.ContentAssistGrammarNaming;
import org.eclipse.xtext.xtext.generator.xbase.XbaseUsageDetector;

@SuppressWarnings("all")
public class IdeaPluginGenerator extends AbstractXtextGeneratorFragment {
  @Inject
  @Extension
  private XtextGeneratorNaming _xtextGeneratorNaming;
  
  @Inject
  @Extension
  private XbaseUsageDetector _xbaseUsageDetector;
  
  @Inject
  private ContentAssistGrammarNaming caNaming;
  
  @Inject
  @Extension
  private IdeaPluginExtension _ideaPluginExtension;
  
  @Inject
  @Extension
  private IdeaPluginClassNames _ideaPluginClassNames;
  
  @Inject
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions;
  
  @Inject
  private FileAccessFactory fileAccessFactory;
  
  private Set<String> libraries = CollectionLiterals.<String>newHashSet();
  
  @Accessors
  private boolean deployable = true;
  
  public boolean addLibrary(final String library) {
    return this.libraries.add(library);
  }
  
  @Override
  public void generate() {
    IXtextProjectConfig _projectConfig = this.getProjectConfig();
    ISubProjectConfig _ideaPlugin = _projectConfig.getIdeaPlugin();
    boolean _isEnabled = _ideaPlugin.isEnabled();
    boolean _not = (!_isEnabled);
    if (_not) {
      return;
    }
    IXtextGeneratorLanguage _language = this.getLanguage();
    List<String> _fileExtensions = _language.getFileExtensions();
    final String fileExtension = IterableExtensions.<String>head(_fileExtensions);
    IXtextGeneratorLanguage _language_1 = this.getLanguage();
    final Grammar grammar = _language_1.getGrammar();
    final GuiceModuleAccess.BindingFactory bindFactory = new GuiceModuleAccess.BindingFactory();
    TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider");
    TypeReference _antlrTokenFileProvider = this._ideaPluginClassNames.getAntlrTokenFileProvider(grammar);
    bindFactory.addTypeToType(_typeRef, _antlrTokenFileProvider);
    TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.parser.antlr.Lexer");
    TypeReference _psiInternalLexer = this._ideaPluginClassNames.getPsiInternalLexer(grammar);
    bindFactory.addTypeToType(_typeRef_1, _psiInternalLexer);
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
        _builder.append(".named(");
        _builder.append(LexerBindings.class, "\t");
        _builder.append(".RUNTIME))");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(".to(");
        TypeReference _psiInternalLexer = IdeaPluginGenerator.this._ideaPluginClassNames.getPsiInternalLexer(grammar);
        _builder.append(_psiInternalLexer, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
      }
    };
    bindFactory.addConfiguredBinding("RuntimeLexer", _client);
    TypeReference _typeRef_2 = TypeReference.typeRef("com.intellij.lang.PsiParser");
    TypeReference _psiParser = this._ideaPluginClassNames.getPsiParser(grammar);
    bindFactory.addTypeToType(_typeRef_2, _psiParser);
    TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.xtext.idea.parser.TokenTypeProvider");
    TypeReference _tokenTypeProvider = this._ideaPluginClassNames.getTokenTypeProvider(grammar);
    bindFactory.addTypeToType(_typeRef_3, _tokenTypeProvider);
    TypeReference _typeRef_4 = TypeReference.typeRef("com.intellij.lang.ParserDefinition");
    TypeReference _parserDefinition = this._ideaPluginClassNames.getParserDefinition(grammar);
    bindFactory.addTypeToType(_typeRef_4, _parserDefinition);
    TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.xtext.idea.lang.IElementTypeProvider");
    TypeReference _elementTypeProvider = this._ideaPluginClassNames.getElementTypeProvider(grammar);
    bindFactory.addTypeToTypeSingleton(_typeRef_5, _elementTypeProvider);
    TypeReference _typeRef_6 = TypeReference.typeRef("org.eclipse.xtext.idea.facet.AbstractFacetConfiguration");
    TypeReference _facetConfiguration = this._ideaPluginClassNames.getFacetConfiguration(grammar);
    bindFactory.addTypeToType(_typeRef_6, _facetConfiguration);
    TypeReference _typeRef_7 = TypeReference.typeRef("com.intellij.facet.FacetTypeId");
    StringConcatenationClient _client_1 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        TypeReference _facetType = IdeaPluginGenerator.this._ideaPluginClassNames.getFacetType(grammar);
        _builder.append(_facetType, "");
        _builder.append(".TYPEID");
      }
    };
    bindFactory.addTypeToInstance(_typeRef_7, _client_1);
    TypeReference _typeRef_8 = TypeReference.typeRef("org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser");
    TypeReference _parserClass = this.caNaming.getParserClass(grammar);
    bindFactory.addTypeToType(_typeRef_8, _parserClass);
    StringConcatenationClient _client_2 = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("binder.bind(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer");
        _builder.append(_typeRef, "");
        _builder.append(".class).annotatedWith(");
        _builder.append(Names.class, "");
        _builder.append(".named(");
        TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.ide.LexerIdeBindings");
        _builder.append(_typeRef_1, "");
        _builder.append(".CONTENT_ASSIST)).to(");
        TypeReference _lexerClass = IdeaPluginGenerator.this.caNaming.getLexerClass(grammar);
        _builder.append(_lexerClass, "");
        _builder.append(".class);");
      }
    };
    bindFactory.addConfiguredBinding("ContentAssistLexer", _client_2);
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(grammar);
    if (_inheritsXbase) {
      TypeReference _typeRef_9 = TypeReference.typeRef("org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider");
      TypeReference _typeRef_10 = TypeReference.typeRef("org.eclipse.xtext.idea.common.types.StubBasedTypeScopeProvider");
      bindFactory.addTypeToType(_typeRef_9, _typeRef_10);
      TypeReference _typeReference = new TypeReference("org.eclipse.xtext.xbase.typesystem.internal", "IFeatureScopeTracker.Provider");
      TypeReference _typeRef_11 = TypeReference.typeRef("org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider");
      bindFactory.addTypeToType(_typeReference, _typeRef_11);
      StringConcatenationClient _client_3 = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("binder.bind(");
          TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.psi.IPsiModelAssociations");
          _builder.append(_typeRef, "");
          _builder.append(".class)");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(".annotatedWith(");
          _builder.append(LanguageSpecific.class, "\t");
          _builder.append(".class)");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(".to(");
          TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.idea.common.types.DerivedMemberAwarePsiModelAssociations");
          _builder.append(_typeRef_1, "\t");
          _builder.append(".class);");
          _builder.newLineIfNotEmpty();
        }
      };
      bindFactory.addConfiguredBinding("LanguageSpecificPsiModelAssociations", _client_3);
      TypeReference _typeRef_12 = TypeReference.typeRef("org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration");
      TypeReference _typeRef_13 = TypeReference.typeRef("org.eclipse.xtext.xbase.idea.highlighting.XbaseHighlightingConfiguration");
      bindFactory.addTypeToType(_typeRef_12, _typeRef_13);
      TypeReference _typeRef_14 = TypeReference.typeRef("org.eclipse.xtext.idea.formatting.BlockFactory");
      TypeReference _typeRef_15 = TypeReference.typeRef("org.eclipse.xtext.xbase.idea.formatting.XbaseBlockFactory");
      bindFactory.addTypeToType(_typeRef_14, _typeRef_15);
      TypeReference _typeRef_16 = TypeReference.typeRef("org.eclipse.xtext.idea.formatting.ChildAttributesProvider");
      TypeReference _typeRef_17 = TypeReference.typeRef("org.eclipse.xtext.xbase.idea.formatting.XbaseChildAttributesProvider");
      bindFactory.addTypeToType(_typeRef_16, _typeRef_17);
      TypeReference _typeRef_18 = TypeReference.typeRef("org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider");
      TypeReference _typeRef_19 = TypeReference.typeRef("org.eclipse.xtext.xbase.idea.bracketmatching.XbaseBracePairProvider");
      bindFactory.addTypeToType(_typeRef_18, _typeRef_19);
      TypeReference _typeRef_20 = TypeReference.typeRef("org.eclipse.xtext.idea.findusages.IReferenceSearcher");
      TypeReference _typeRef_21 = TypeReference.typeRef("org.eclipse.xtext.xbase.idea.findusages.JvmElementAwareReferenceSearcher");
      bindFactory.addTypeToType(_typeRef_20, _typeRef_21);
      TypeReference _typeRef_22 = TypeReference.typeRef("org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider");
      TypeReference _typeRef_23 = TypeReference.typeRef("org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigProvider");
      bindFactory.addTypeToType(_typeRef_22, _typeRef_23);
      TypeReference _typeRef_24 = TypeReference.typeRef("org.eclipse.xtext.idea.findusages.WordsScannerProvider");
      TypeReference _typeReference_1 = new TypeReference("org.eclipse.xtext.xbase.idea.findusages", "XbaseWordsScanner.XbaseWordsScannerProvider");
      bindFactory.addTypeToType(_typeRef_24, _typeReference_1);
    }
    IXtextGeneratorLanguage _language_2 = this.getLanguage();
    GuiceModuleAccess _ideaGenModule = _language_2.getIdeaGenModule();
    bindFactory.contributeTo(_ideaGenModule);
    XtendFileAccess _compileStandaloneSetup = this.compileStandaloneSetup(grammar);
    XtendFileAccess _compileIdeaSetup = this.compileIdeaSetup(grammar);
    JavaFileAccess _compileCompletionContributor = this.compileCompletionContributor(grammar);
    XtendFileAccess _compileFileType = this.compileFileType(grammar);
    JavaFileAccess _compileFacetConfiguration = this.compileFacetConfiguration(grammar);
    JavaFileAccess _compileColorSettingsPage = this.compileColorSettingsPage(grammar);
    final Procedure1<JavaFileAccess> _function = new Procedure1<JavaFileAccess>() {
      @Override
      public void apply(final JavaFileAccess it) {
        IXtextProjectConfig _projectConfig = IdeaPluginGenerator.this.getProjectConfig();
        ISubProjectConfig _ideaPlugin = _projectConfig.getIdeaPlugin();
        IXtextGeneratorFileSystemAccess _src = _ideaPlugin.getSrc();
        it.writeTo(_src);
      }
    };
    IterableExtensions.forEach(Collections.<JavaFileAccess>unmodifiableList(CollectionLiterals.<JavaFileAccess>newArrayList(_compileStandaloneSetup, _compileIdeaSetup, _compileCompletionContributor, _compileFileType, _compileFacetConfiguration, _compileColorSettingsPage)), _function);
    TextFileAccess _compileServicesISetup = this.compileServicesISetup(grammar);
    JavaFileAccess _compileAbstractCompletionContributor = this.compileAbstractCompletionContributor(grammar);
    JavaFileAccess _compileLanguage = this.compileLanguage(grammar);
    JavaFileAccess _compileAbstractFileType = this.compileAbstractFileType(grammar, fileExtension);
    JavaFileAccess _compileFileTypeFactory = this.compileFileTypeFactory(grammar);
    JavaFileAccess _compileFileImpl = this.compileFileImpl(grammar);
    JavaFileAccess _compileTokenTypeProvider = this.compileTokenTypeProvider(grammar);
    JavaFileAccess _compileElementTypeProvider = this.compileElementTypeProvider(grammar);
    JavaFileAccess _compileParserDefinition = this.compileParserDefinition(grammar);
    JavaFileAccess _compileSyntaxHighlighterFactory = this.compileSyntaxHighlighterFactory(grammar);
    JavaFileAccess _compileSemanticHighlightVisitor = this.compileSemanticHighlightVisitor(grammar);
    JavaFileAccess _compileExtensionFactory = this.compileExtensionFactory(grammar);
    JavaFileAccess _compileCodeBlockModificationListener = this.compileCodeBlockModificationListener(grammar);
    JavaFileAccess _compilePsiParser = this.compilePsiParser(grammar);
    JavaFileAccess _compileAntlrTokenFileProvider = this.compileAntlrTokenFileProvider(grammar);
    JavaFileAccess _compilePomDeclarationSearcher = this.compilePomDeclarationSearcher(grammar);
    JavaFileAccess _compileFacetType = this.compileFacetType(grammar);
    JavaFileAccess _compileBaseColorSettingsPage = this.compileBaseColorSettingsPage(grammar);
    final Procedure1<TextFileAccess> _function_1 = new Procedure1<TextFileAccess>() {
      @Override
      public void apply(final TextFileAccess it) {
        IXtextProjectConfig _projectConfig = IdeaPluginGenerator.this.getProjectConfig();
        ISubProjectConfig _ideaPlugin = _projectConfig.getIdeaPlugin();
        IXtextGeneratorFileSystemAccess _srcGen = _ideaPlugin.getSrcGen();
        it.writeTo(_srcGen);
      }
    };
    IterableExtensions.forEach(Collections.<TextFileAccess>unmodifiableList(CollectionLiterals.<TextFileAccess>newArrayList(_compileServicesISetup, _compileAbstractCompletionContributor, _compileLanguage, _compileAbstractFileType, _compileFileTypeFactory, _compileFileImpl, _compileTokenTypeProvider, _compileElementTypeProvider, _compileParserDefinition, _compileSyntaxHighlighterFactory, _compileSemanticHighlightVisitor, _compileExtensionFactory, _compileCodeBlockModificationListener, _compilePsiParser, _compileAntlrTokenFileProvider, _compilePomDeclarationSearcher, _compileFacetType, _compileBaseColorSettingsPage)), _function_1);
    if (this.deployable) {
      final TextFileAccess pluginXml = this.compilePluginXml(grammar);
      IXtextProjectConfig _projectConfig_1 = this.getProjectConfig();
      ISubProjectConfig _ideaPlugin_1 = _projectConfig_1.getIdeaPlugin();
      IXtextGeneratorFileSystemAccess _metaInf = _ideaPlugin_1.getMetaInf();
      String _path = pluginXml.getPath();
      boolean _isFile = _metaInf.isFile(_path);
      boolean _not_1 = (!_isFile);
      if (_not_1) {
        IXtextProjectConfig _projectConfig_2 = this.getProjectConfig();
        ISubProjectConfig _ideaPlugin_2 = _projectConfig_2.getIdeaPlugin();
        IXtextGeneratorFileSystemAccess _metaInf_1 = _ideaPlugin_2.getMetaInf();
        pluginXml.writeTo(_metaInf_1);
      }
      TextFileAccess _compilePluginGenXml = this.compilePluginGenXml(grammar);
      IXtextProjectConfig _projectConfig_3 = this.getProjectConfig();
      ISubProjectConfig _ideaPlugin_3 = _projectConfig_3.getIdeaPlugin();
      IXtextGeneratorFileSystemAccess _metaInf_2 = _ideaPlugin_3.getMetaInf();
      _compilePluginGenXml.writeTo(_metaInf_2);
    }
  }
  
  public String iml() {
    return ".iml";
  }
  
  public JavaFileAccess compileExtensionFactory(final Grammar grammar) {
    TypeReference _extensionFactory = this._ideaPluginClassNames.getExtensionFactory(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _extensionFactory = IdeaPluginGenerator.this._ideaPluginClassNames.getExtensionFactory(grammar);
        String _simpleName = _extensionFactory.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" implements ");
        TypeReference _typeRef = TypeReference.typeRef("com.intellij.openapi.extensions.ExtensionFactory");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public Object createInstance(");
        _builder.append(String.class, "\t");
        _builder.append(" factoryArgument, ");
        _builder.append(String.class, "\t");
        _builder.append(" implementationClass) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append(Class.class, "\t\t");
        _builder.append("<?> clazz;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("clazz = ");
        _builder.append(Class.class, "\t\t\t");
        _builder.append(".forName(implementationClass);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("} catch (");
        _builder.append(ClassNotFoundException.class, "\t\t");
        _builder.append(" e) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("throw new ");
        _builder.append(IllegalArgumentException.class, "\t\t\t");
        _builder.append("(\"Couldn\'t load \"+implementationClass, e);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return ");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage, "\t\t");
        _builder.append(".INSTANCE.<Object> getInstance(clazz);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_extensionFactory, _client);
  }
  
  public JavaFileAccess compileCodeBlockModificationListener(final Grammar grammar) {
    TypeReference _codeBlockModificationListener = this._ideaPluginClassNames.getCodeBlockModificationListener(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _codeBlockModificationListener = IdeaPluginGenerator.this._ideaPluginClassNames.getCodeBlockModificationListener(grammar);
        String _simpleName = _codeBlockModificationListener.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _codeBlockModificationListener_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getCodeBlockModificationListener(grammar);
        String _simpleName_1 = _codeBlockModificationListener_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        TypeReference _typeRef_1 = TypeReference.typeRef("com.intellij.psi.util.PsiModificationTracker");
        _builder.append(_typeRef_1, "\t");
        _builder.append(" psiModificationTracker) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage, "\t\t");
        _builder.append(".INSTANCE, psiModificationTracker);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        {
          boolean _inheritsXbase = IdeaPluginGenerator.this._xbaseUsageDetector.inheritsXbase(grammar);
          if (_inheritsXbase) {
            _builder.append("\t");
            _builder.append("protected boolean hasJavaStructuralChanges(");
            TypeReference _typeRef_2 = TypeReference.typeRef("com.intellij.psi.impl.PsiTreeChangeEventImpl");
            _builder.append(_typeRef_2, "\t");
            _builder.append(" event) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return true;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_codeBlockModificationListener, _client);
  }
  
  public JavaFileAccess compilePomDeclarationSearcher(final Grammar it) {
    TypeReference _pomDeclarationSearcher = this._ideaPluginClassNames.getPomDeclarationSearcher(it);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _pomDeclarationSearcher = IdeaPluginGenerator.this._ideaPluginClassNames.getPomDeclarationSearcher(it);
        String _simpleName = _pomDeclarationSearcher.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _pomDeclarationSearcher_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getPomDeclarationSearcher(it);
        String _simpleName_1 = _pomDeclarationSearcher_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(");
        Grammar _grammar = IdeaPluginGenerator.this.getGrammar();
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(_grammar);
        _builder.append(_ideaLanguage, "\t\t");
        _builder.append(".INSTANCE);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_pomDeclarationSearcher, _client);
  }
  
  public JavaFileAccess compilePsiParser(final Grammar grammar) {
    TypeReference _psiParser = this._ideaPluginClassNames.getPsiParser(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _psiParser = IdeaPluginGenerator.this._ideaPluginClassNames.getPsiParser(grammar);
        String _simpleName = _psiParser.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.parser.AbstractXtextPsiParser");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          List<String> _initialHiddenTokens = IdeaPluginGenerator.this._grammarAccessExtensions.initialHiddenTokens(grammar);
          boolean _isEmpty = _initialHiddenTokens.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("\t");
            _builder.append("private static final ");
            _builder.append(Set.class, "\t");
            _builder.append("<");
            _builder.append(String.class, "\t");
            _builder.append("> INITIAL_HIDDEN_TOKENS = new ");
            _builder.append(HashSet.class, "\t");
            _builder.append("<");
            _builder.append(String.class, "\t");
            _builder.append(">(");
            _builder.append(Arrays.class, "\t");
            _builder.append(".asList(");
            {
              List<String> _initialHiddenTokens_1 = IdeaPluginGenerator.this._grammarAccessExtensions.initialHiddenTokens(grammar);
              boolean _hasElements = false;
              for(final String hidden : _initialHiddenTokens_1) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "\t");
                }
                _builder.append("\"");
                _builder.append(hidden, "\t");
                _builder.append("\"");
              }
            }
            _builder.append("));");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("private static final ");
            _builder.append(Set.class, "\t");
            _builder.append("<");
            _builder.append(String.class, "\t");
            _builder.append("> INITIAL_HIDDEN_TOKENS = ");
            _builder.append(Collections.class, "\t");
            _builder.append(".emptySet();");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private ");
        TypeReference _grammarAccess = IdeaPluginGenerator.this._grammarAccessExtensions.getGrammarAccess(grammar);
        _builder.append(_grammarAccess, "\t");
        _builder.append(" grammarAccess;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Inject.class, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("private ");
        TypeReference _elementTypeProvider = IdeaPluginGenerator.this._ideaPluginClassNames.getElementTypeProvider(grammar);
        _builder.append(_elementTypeProvider, "\t");
        _builder.append(" elementTypeProvider;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Override.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("protected ");
        TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser");
        _builder.append(_typeRef_1, "\t");
        _builder.append(" createParser(");
        TypeReference _typeRef_2 = TypeReference.typeRef("com.intellij.lang.PsiBuilder");
        _builder.append(_typeRef_2, "\t");
        _builder.append(" builder, ");
        TypeReference _typeRef_3 = TypeReference.typeRef("org.antlr.runtime.TokenStream");
        _builder.append(_typeRef_3, "\t");
        _builder.append(" tokenStream) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return new ");
        TypeReference _psiInternalParser = IdeaPluginGenerator.this._ideaPluginClassNames.getPsiInternalParser(grammar);
        _builder.append(_psiInternalParser, "\t\t");
        _builder.append("(builder, tokenStream, elementTypeProvider, grammarAccess);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Override.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("protected ");
        _builder.append(Set.class, "\t");
        _builder.append("<");
        _builder.append(String.class, "\t");
        _builder.append("> getInitialHiddenTokens() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return INITIAL_HIDDEN_TOKENS;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_psiParser, _client);
  }
  
  public JavaFileAccess compileAntlrTokenFileProvider(final Grammar grammar) {
    TypeReference _antlrTokenFileProvider = this._ideaPluginClassNames.getAntlrTokenFileProvider(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _antlrTokenFileProvider = IdeaPluginGenerator.this._ideaPluginClassNames.getAntlrTokenFileProvider(grammar);
        String _simpleName = _antlrTokenFileProvider.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" implements ");
        _builder.append(IAntlrTokenFileProvider.class, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("@");
        _builder.append(Override.class, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(InputStream.class, "\t");
        _builder.append(" getAntlrTokenFile() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append(ClassLoader.class, "\t\t");
        _builder.append(" classLoader = getClass().getClassLoader();");
        _builder.newLineIfNotEmpty();
        _builder.append("    \t");
        _builder.append("return classLoader.getResourceAsStream(\"");
        String _tokens = IdeaPluginGenerator.this._ideaPluginClassNames.getTokens(grammar);
        _builder.append(_tokens, "    \t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_antlrTokenFileProvider, _client);
  }
  
  public TextFileAccess compilePluginXml(final Grammar grammar) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("<idea-plugin version=\"2\" xmlns:xi=\"http://www.w3.org/2001/XInclude\">");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<id>");
        String _ideaBasePackage = IdeaPluginGenerator.this._xtextGeneratorNaming.getIdeaBasePackage(grammar);
        _builder.append(_ideaBasePackage, "\t");
        _builder.append("</id>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("<name>");
        String _simpleName = IdeaPluginGenerator.this._ideaPluginExtension.getSimpleName(grammar);
        _builder.append(_simpleName, "\t");
        _builder.append(" Support</name>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("<description>");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("This plugin enables smart editing of ");
        String _simpleName_1 = IdeaPluginGenerator.this._ideaPluginExtension.getSimpleName(grammar);
        _builder.append(_simpleName_1, "      ");
        _builder.append(" files.");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</description>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<version>1.0.0</version>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<vendor>My Company</vendor>");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<idea-version since-build=\"131\"/>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<depends>org.eclipse.xtext.idea</depends>");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<xi:include href=\"plugin_gen.xml\" xpointer=\"xpointer(/idea-plugin/*)\"/>");
        _builder.newLine();
        _builder.append("</idea-plugin>");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createTextFile("plugin.xml", _client);
  }
  
  public TextFileAccess compilePluginGenXml(final Grammar grammar) {
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("<idea-plugin version=\"2\">");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<extensions defaultExtensionNs=\"org.eclipse.xtext.idea\">");
        _builder.newLine();
        {
          EList<AbstractMetamodelDeclaration> _metamodelDeclarations = grammar.getMetamodelDeclarations();
          Iterable<GeneratedMetamodel> _filter = Iterables.<GeneratedMetamodel>filter(_metamodelDeclarations, GeneratedMetamodel.class);
          for(final GeneratedMetamodel generatedMetamodel : _filter) {
            _builder.append("\t\t");
            _builder.append("<package");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("uri=\"");
            EPackage _ePackage = generatedMetamodel.getEPackage();
            String _nsURI = _ePackage.getNsURI();
            _builder.append(_nsURI, "\t\t\t");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("class=\"");
            String _namespace = GrammarUtil.getNamespace(grammar);
            _builder.append(_namespace, "\t\t\t");
            _builder.append(".");
            String _name = generatedMetamodel.getName();
            _builder.append(_name, "\t\t\t");
            _builder.append(".");
            String _name_1 = generatedMetamodel.getName();
            String _firstUpper = StringExtensions.toFirstUpper(_name_1);
            _builder.append(_firstUpper, "\t\t\t");
            _builder.append("Package\"");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("/>");
            _builder.newLine();
          }
        }
        _builder.append("\t\t");
        _builder.append("<resourceFactory ");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("type=\"");
        IXtextGeneratorLanguage _language = IdeaPluginGenerator.this.getLanguage();
        List<String> _fileExtensions = _language.getFileExtensions();
        String _head = IterableExtensions.<String>head(_fileExtensions);
        _builder.append(_head, "\t\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("class=\"org.eclipse.xtext.resource.IResourceFactory\"");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("factoryClass=\"");
        TypeReference _extensionFactory = IdeaPluginGenerator.this._ideaPluginClassNames.getExtensionFactory(grammar);
        _builder.append(_extensionFactory, "\t\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("/>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<resourceServiceProvider");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("uriExtension=\"");
        IXtextGeneratorLanguage _language_1 = IdeaPluginGenerator.this.getLanguage();
        List<String> _fileExtensions_1 = _language_1.getFileExtensions();
        String _head_1 = IterableExtensions.<String>head(_fileExtensions_1);
        _builder.append(_head_1, "\t\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("class=\"org.eclipse.xtext.idea.resource.IResourceIdeaServiceProvider\"");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("factoryClass=\"");
        TypeReference _extensionFactory_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getExtensionFactory(grammar);
        _builder.append(_extensionFactory_1, "\t\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("/>");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<lang.setup");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("language=\"");
        String _languageID = IdeaPluginGenerator.this._ideaPluginExtension.getLanguageID(grammar);
        _builder.append(_languageID, "\t\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("implementationClass=\"");
        TypeReference _ideaSetup = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaSetup(grammar);
        _builder.append(_ideaSetup, "\t\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("/>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</extensions>");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<extensions defaultExtensionNs=\"com.intellij\">");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<psi.treeChangePreprocessor implementation=\"");
        TypeReference _codeBlockModificationListener = IdeaPluginGenerator.this._ideaPluginClassNames.getCodeBlockModificationListener(grammar);
        _builder.append(_codeBlockModificationListener, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<fileTypeFactory implementation=\"");
        TypeReference _fileTypeFactory = IdeaPluginGenerator.this._ideaPluginClassNames.getFileTypeFactory(grammar);
        _builder.append(_fileTypeFactory, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("<stubElementTypeHolder class=\"");
        TypeReference _elementTypeProvider = IdeaPluginGenerator.this._ideaPluginClassNames.getElementTypeProvider(grammar);
        _builder.append(_elementTypeProvider, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.lang.BaseXtextASTFactory");
        CharSequence _compileExtension = IdeaPluginGenerator.this.compileExtension(grammar, "lang.ast.factory", _typeRef);
        _builder.append(_compileExtension, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _parserDefinition = IdeaPluginGenerator.this._ideaPluginClassNames.getParserDefinition(grammar);
        CharSequence _compileExtension_1 = IdeaPluginGenerator.this.compileExtension(grammar, "lang.parserDefinition", _parserDefinition);
        _builder.append(_compileExtension_1, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.idea.findusages.BaseXtextFindUsageProvider");
        CharSequence _compileExtension_2 = IdeaPluginGenerator.this.compileExtension(grammar, "lang.findUsagesProvider", _typeRef_1);
        _builder.append(_compileExtension_2, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.idea.refactoring.BaseXtextRefactoringSupportProvider");
        CharSequence _compileExtension_3 = IdeaPluginGenerator.this.compileExtension(grammar, "lang.refactoringSupport", _typeRef_2);
        _builder.append(_compileExtension_3, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _typeRef_3 = TypeReference.typeRef("com.intellij.lang.refactoring.NamesValidator");
        CharSequence _compileExtension_4 = IdeaPluginGenerator.this.compileExtension(grammar, "lang.namesValidator", _typeRef_3);
        _builder.append(_compileExtension_4, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("<lang.syntaxHighlighterFactory key=\"");
        String _languageID_1 = IdeaPluginGenerator.this._ideaPluginExtension.getLanguageID(grammar);
        _builder.append(_languageID_1, "\t\t");
        _builder.append("\" implementationClass=\"");
        TypeReference _syntaxHighlighterFactory = IdeaPluginGenerator.this._ideaPluginClassNames.getSyntaxHighlighterFactory(grammar);
        _builder.append(_syntaxHighlighterFactory, "\t\t");
        _builder.append("\" />");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _typeRef_4 = TypeReference.typeRef("com.intellij.lang.PairedBraceMatcher");
        CharSequence _compileExtension_5 = IdeaPluginGenerator.this.compileExtension(grammar, "lang.braceMatcher", _typeRef_4);
        _builder.append(_compileExtension_5, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.xtext.idea.annotation.IssueAnnotator");
        CharSequence _compileExtension_6 = IdeaPluginGenerator.this.compileExtension(grammar, "annotator", _typeRef_5);
        _builder.append(_compileExtension_6, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("<completion.contributor language=\"");
        String _languageID_2 = IdeaPluginGenerator.this._ideaPluginExtension.getLanguageID(grammar);
        _builder.append(_languageID_2, "\t\t");
        _builder.append("\" implementationClass=\"");
        TypeReference _completionContributor = IdeaPluginGenerator.this._ideaPluginClassNames.getCompletionContributor(grammar);
        _builder.append(_completionContributor, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("<pom.declarationSearcher implementation=\"");
        TypeReference _pomDeclarationSearcher = IdeaPluginGenerator.this._ideaPluginClassNames.getPomDeclarationSearcher(grammar);
        _builder.append(_pomDeclarationSearcher, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t");
        TypeReference _typeRef_6 = TypeReference.typeRef("com.intellij.lang.PsiStructureViewFactory");
        CharSequence _compileExtension_7 = IdeaPluginGenerator.this.compileExtension(grammar, "lang.psiStructureViewFactory", _typeRef_6);
        _builder.append(_compileExtension_7, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("<facetType implementation=\"");
        TypeReference _facetType = IdeaPluginGenerator.this._ideaPluginClassNames.getFacetType(grammar);
        _builder.append(_facetType, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("      \t");
        TypeReference _typeRef_7 = TypeReference.typeRef("org.eclipse.xtext.idea.documentation.IdeaDocumentationProvider");
        CharSequence _compileExtension_8 = IdeaPluginGenerator.this.compileExtension(grammar, "lang.documentationProvider", _typeRef_7);
        _builder.append(_compileExtension_8, "      \t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("<colorSettingsPage implementation=\"");
        TypeReference _colorSettingsPage = IdeaPluginGenerator.this._ideaPluginClassNames.colorSettingsPage(grammar);
        _builder.append(_colorSettingsPage, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("<highlightVisitor implementation=\"");
        TypeReference _semanticHighlightVisitor = IdeaPluginGenerator.this._ideaPluginClassNames.getSemanticHighlightVisitor(grammar);
        _builder.append(_semanticHighlightVisitor, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t");
        TypeReference _typeRef_8 = TypeReference.typeRef("com.intellij.formatting.FormattingModelBuilder");
        CharSequence _compileExtension_9 = IdeaPluginGenerator.this.compileExtension(grammar, "lang.formatter", _typeRef_8);
        _builder.append(_compileExtension_9, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _typeRef_9 = TypeReference.typeRef("com.intellij.lang.CodeDocumentationAwareCommenter");
        CharSequence _compileExtension_10 = IdeaPluginGenerator.this.compileExtension(grammar, "lang.commenter", _typeRef_9);
        _builder.append(_compileExtension_10, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</extensions>");
        _builder.newLine();
        _builder.append("</idea-plugin>");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createTextFile("plugin_gen.xml", _client);
  }
  
  public CharSequence compileExtension(final Grammar grammar, final String extensionPointId, final TypeReference implementationClass) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<");
    _builder.append(extensionPointId, "");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("language=\"");
    String _languageID = this._ideaPluginExtension.getLanguageID(grammar);
    _builder.append(_languageID, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("factoryClass=\"");
    TypeReference _extensionFactory = this._ideaPluginClassNames.getExtensionFactory(grammar);
    _builder.append(_extensionFactory, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("implementationClass=\"");
    _builder.append(implementationClass, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("/>");
    _builder.newLine();
    return _builder;
  }
  
  public JavaFileAccess compileFileImpl(final Grammar grammar) {
    TypeReference _fileImpl = this._ideaPluginClassNames.getFileImpl(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public final class ");
        TypeReference _fileImpl = IdeaPluginGenerator.this._ideaPluginClassNames.getFileImpl(grammar);
        String _simpleName = _fileImpl.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.psi.impl.BaseXtextFile");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _fileImpl_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getFileImpl(grammar);
        String _simpleName_1 = _fileImpl_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        TypeReference _typeRef_1 = TypeReference.typeRef("com.intellij.psi.FileViewProvider");
        _builder.append(_typeRef_1, "\t");
        _builder.append(" viewProvider) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(viewProvider, ");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage, "\t\t");
        _builder.append(".INSTANCE);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _typeRef_2 = TypeReference.typeRef("com.intellij.openapi.fileTypes.FileType");
        _builder.append(_typeRef_2, "\t");
        _builder.append(" getFileType() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        TypeReference _fileType = IdeaPluginGenerator.this._ideaPluginClassNames.getFileType(grammar);
        _builder.append(_fileType, "\t\t");
        _builder.append(".INSTANCE;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_fileImpl, _client);
  }
  
  public JavaFileAccess compileFileTypeFactory(final Grammar grammar) {
    TypeReference _fileTypeFactory = this._ideaPluginClassNames.getFileTypeFactory(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _fileTypeFactory = IdeaPluginGenerator.this._ideaPluginClassNames.getFileTypeFactory(grammar);
        String _simpleName = _fileTypeFactory.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("com.intellij.openapi.fileTypes.FileTypeFactory");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void createFileTypes(@");
        TypeReference _typeRef_1 = TypeReference.typeRef("org.jetbrains.annotations.NotNull");
        _builder.append(_typeRef_1, "\t");
        _builder.append(" ");
        TypeReference _typeRef_2 = TypeReference.typeRef("com.intellij.openapi.fileTypes.FileTypeConsumer");
        _builder.append(_typeRef_2, "\t");
        _builder.append(" consumer) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("consumer.consume(");
        TypeReference _fileType = IdeaPluginGenerator.this._ideaPluginClassNames.getFileType(grammar);
        _builder.append(_fileType, "\t\t");
        _builder.append(".INSTANCE, ");
        TypeReference _abstractFileType = IdeaPluginGenerator.this._ideaPluginClassNames.getAbstractFileType(grammar);
        _builder.append(_abstractFileType, "\t\t");
        _builder.append(".DEFAULT_EXTENSION);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_fileTypeFactory, _client);
  }
  
  public JavaFileAccess compileAbstractFileType(final Grammar grammar, final String fileExtension) {
    TypeReference _abstractFileType = this._ideaPluginClassNames.getAbstractFileType(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _abstractFileType = IdeaPluginGenerator.this._ideaPluginClassNames.getAbstractFileType(grammar);
        String _simpleName = _abstractFileType.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("com.intellij.openapi.fileTypes.LanguageFileType");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@");
        TypeReference _typeRef_1 = TypeReference.typeRef("org.jetbrains.annotations.NonNls");
        _builder.append(_typeRef_1, "\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public static final String DEFAULT_EXTENSION = \"");
        _builder.append(fileExtension, "\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected ");
        TypeReference _abstractFileType_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getAbstractFileType(grammar);
        String _simpleName_1 = _abstractFileType_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(final ");
        TypeReference _typeRef_2 = TypeReference.typeRef("com.intellij.lang.Language");
        _builder.append(_typeRef_2, "\t");
        _builder.append(" language) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(language);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public String getDefaultExtension() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return DEFAULT_EXTENSION;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public String getDescription() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return \"");
        String _simpleName_2 = IdeaPluginGenerator.this._ideaPluginExtension.getSimpleName(grammar);
        _builder.append(_simpleName_2, "\t\t");
        _builder.append(" files\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _typeRef_3 = TypeReference.typeRef("javax.swing.Icon");
        _builder.append(_typeRef_3, "\t");
        _builder.append(" getIcon() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.xtext.idea.Icons");
        _builder.append(_typeRef_4, "\t\t");
        _builder.append(".DSL_FILE_TYPE;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public String getName() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return \"");
        String _simpleName_3 = IdeaPluginGenerator.this._ideaPluginExtension.getSimpleName(grammar);
        _builder.append(_simpleName_3, "\t\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_abstractFileType, _client);
  }
  
  public XtendFileAccess compileFileType(final Grammar grammar) {
    TypeReference _fileType = this._ideaPluginClassNames.getFileType(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("class ");
        TypeReference _fileType = IdeaPluginGenerator.this._ideaPluginClassNames.getFileType(grammar);
        String _simpleName = _fileType.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _abstractFileType = IdeaPluginGenerator.this._ideaPluginClassNames.getAbstractFileType(grammar);
        _builder.append(_abstractFileType, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public static final ");
        TypeReference _fileType_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getFileType(grammar);
        String _simpleName_1 = _fileType_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append(" INSTANCE = new ");
        TypeReference _fileType_2 = IdeaPluginGenerator.this._ideaPluginClassNames.getFileType(grammar);
        String _simpleName_2 = _fileType_2.getSimpleName();
        _builder.append(_simpleName_2, "\t");
        _builder.append("()");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("new() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("super(");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage, "\t\t");
        _builder.append(".INSTANCE)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createXtendFile(_fileType, _client);
  }
  
  public JavaFileAccess compileLanguage(final Grammar grammar) {
    TypeReference _ideaLanguage = this._ideaPluginClassNames.getIdeaLanguage(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public final class ");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        String _simpleName = _ideaLanguage.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.lang.AbstractXtextLanguage");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static final ");
        TypeReference _ideaLanguage_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        String _simpleName_1 = _ideaLanguage_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append(" INSTANCE = new ");
        TypeReference _ideaLanguage_2 = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        String _simpleName_2 = _ideaLanguage_2.getSimpleName();
        _builder.append(_simpleName_2, "\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private ");
        TypeReference _ideaLanguage_3 = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        String _simpleName_3 = _ideaLanguage_3.getSimpleName();
        _builder.append(_simpleName_3, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(\"");
        String _languageId = GrammarUtil.getLanguageId(grammar);
        _builder.append(_languageId, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_ideaLanguage, _client);
  }
  
  public XtendFileAccess compileStandaloneSetup(final Grammar grammar) {
    TypeReference _ideaStandaloneSetup = this._xtextGeneratorNaming.getIdeaStandaloneSetup(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("class ");
        TypeReference _ideaStandaloneSetup = IdeaPluginGenerator.this._xtextGeneratorNaming.getIdeaStandaloneSetup(grammar);
        String _simpleName = _ideaStandaloneSetup.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _runtimeGenSetup = IdeaPluginGenerator.this._xtextGeneratorNaming.getRuntimeGenSetup(grammar);
        _builder.append(_runtimeGenSetup, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("override createInjector() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("val runtimeModule = new ");
        TypeReference _runtimeModule = IdeaPluginGenerator.this._xtextGeneratorNaming.getRuntimeModule(grammar);
        _builder.append(_runtimeModule, "\t\t");
        _builder.append("()");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("val ideaModule = new ");
        TypeReference _ideaModule = IdeaPluginGenerator.this._xtextGeneratorNaming.getIdeaModule(grammar);
        _builder.append(_ideaModule, "\t\t");
        _builder.append("()");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("val mergedModule = ");
        _builder.append(Modules2.class, "\t\t");
        _builder.append(".mixin(runtimeModule, ideaModule)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return ");
        _builder.append(Guice.class, "\t\t");
        _builder.append(".createInjector(mergedModule)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createXtendFile(_ideaStandaloneSetup, _client);
  }
  
  public XtendFileAccess compileIdeaSetup(final Grammar grammar) {
    TypeReference _ideaSetup = this._ideaPluginClassNames.getIdeaSetup(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("class ");
        TypeReference _ideaSetup = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaSetup(grammar);
        String _simpleName = _ideaSetup.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" implements ");
        _builder.append(ISetup.class, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("override createInjectorAndDoEMFRegistration() {");
        _builder.newLine();
        _builder.append("\t\t");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries");
        _builder.append(_typeRef, "\t\t");
        _builder.append(".ensureInitialized");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("new ");
        TypeReference _ideaStandaloneSetup = IdeaPluginGenerator.this._xtextGeneratorNaming.getIdeaStandaloneSetup(grammar);
        _builder.append(_ideaStandaloneSetup, "\t\t");
        _builder.append("().createInjector");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createXtendFile(_ideaSetup, _client);
  }
  
  public JavaFileAccess compileElementTypeProvider(final Grammar grammar) {
    TypeReference _elementTypeProvider = this._ideaPluginClassNames.getElementTypeProvider(grammar);
    final JavaFileAccess file = this.fileAccessFactory.createJavaFile(_elementTypeProvider);
    TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.lang.IElementTypeProvider");
    file.importType(_typeRef);
    TypeReference _typeRef_1 = TypeReference.typeRef("org.eclipse.xtext.psi.stubs.XtextFileElementType");
    file.importType(_typeRef_1);
    TypeReference _typeRef_2 = TypeReference.typeRef("org.eclipse.xtext.psi.stubs.XtextFileStub");
    file.importType(_typeRef_2);
    TypeReference _typeRef_3 = TypeReference.typeRef("org.eclipse.xtext.psi.tree.IGrammarAwareElementType");
    file.importType(_typeRef_3);
    TypeReference _typeRef_4 = TypeReference.typeRef("com.intellij.psi.tree.IFileElementType");
    file.importType(_typeRef_4);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _elementTypeProvider = IdeaPluginGenerator.this._ideaPluginClassNames.getElementTypeProvider(grammar);
        String _simpleName = _elementTypeProvider.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" implements IElementTypeProvider {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<");
        TypeReference _fileImpl = IdeaPluginGenerator.this._ideaPluginClassNames.getFileImpl(grammar);
        _builder.append(_fileImpl, "\t");
        _builder.append(">>(");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage, "\t");
        _builder.append(".INSTANCE);");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static final ");
        _builder.append(Map.class, "\t");
        _builder.append("<");
        _builder.append(EObject.class, "\t");
        _builder.append(", IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new ");
        _builder.append(HashMap.class, "\t");
        _builder.append("<");
        _builder.append(EObject.class, "\t");
        _builder.append(", IGrammarAwareElementType>();");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return grammarAwareElementType;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static final ");
        TypeReference _grammarAccess = IdeaPluginGenerator.this._grammarAccessExtensions.getGrammarAccess(grammar);
        _builder.append(_grammarAccess, "\t");
        _builder.append(" GRAMMAR_ACCESS = ");
        TypeReference _ideaLanguage_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage_1, "\t");
        _builder.append(".INSTANCE.getInstance(");
        TypeReference _grammarAccess_1 = IdeaPluginGenerator.this._grammarAccessExtensions.getGrammarAccess(grammar);
        _builder.append(_grammarAccess_1, "\t");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        {
          Iterable<AbstractRule> _allNonTerminalRules = IdeaPluginGenerator.this._ideaPluginExtension.getAllNonTerminalRules(grammar);
          for(final AbstractRule rule : _allNonTerminalRules) {
            _builder.newLine();
            _builder.append("\t");
            _builder.append("private static class ");
            String _grammarElementIdentifier = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(rule);
            _builder.append(_grammarElementIdentifier, "\t");
            _builder.append("Factory {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("public static IGrammarAwareElementType create");
            String _grammarElementIdentifier_1 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(rule);
            _builder.append(_grammarElementIdentifier_1, "\t\t");
            _builder.append("ElementType() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("return new IGrammarAwareElementType(\"");
            String _grammarElementIdentifier_2 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(rule);
            _builder.append(_grammarElementIdentifier_2, "\t\t\t");
            _builder.append("_ELEMENT_TYPE\", ");
            TypeReference _ideaLanguage_2 = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
            _builder.append(_ideaLanguage_2, "\t\t\t");
            _builder.append(".INSTANCE, GRAMMAR_ACCESS.");
            String _gaRuleAccessor = IdeaPluginGenerator.this._grammarAccessExtensions.gaRuleAccessor(rule);
            _builder.append(_gaRuleAccessor, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            {
              TreeIterator<EObject> _eAllContents = rule.eAllContents();
              Iterator<AbstractElement> _filter = Iterators.<AbstractElement>filter(_eAllContents, AbstractElement.class);
              Iterable<AbstractElement> _iterable = IteratorExtensions.<AbstractElement>toIterable(_filter);
              for(final AbstractElement element : _iterable) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("public static IGrammarAwareElementType create");
                String _grammarElementIdentifier_3 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(element);
                _builder.append(_grammarElementIdentifier_3, "\t\t");
                _builder.append("ElementType() {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return new IGrammarAwareElementType(\"");
                String _grammarElementIdentifier_4 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(element);
                _builder.append(_grammarElementIdentifier_4, "\t\t\t");
                _builder.append("_ELEMENT_TYPE\", ");
                TypeReference _ideaLanguage_3 = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
                _builder.append(_ideaLanguage_3, "\t\t\t");
                _builder.append(".INSTANCE, GRAMMAR_ACCESS.");
                String _gaElementsAccessor = IdeaPluginGenerator.this._grammarAccessExtensions.gaElementsAccessor(rule);
                _builder.append(_gaElementsAccessor, "\t\t\t");
                _builder.append(".");
                String _gaElementAccessor = IdeaPluginGenerator.this._grammarAccessExtensions.gaElementAccessor(element);
                _builder.append(_gaElementAccessor, "\t\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public static final IGrammarAwareElementType ");
            String _grammarElementIdentifier_5 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(rule);
            _builder.append(_grammarElementIdentifier_5, "\t");
            _builder.append("_ELEMENT_TYPE = associate(");
            String _grammarElementIdentifier_6 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(rule);
            _builder.append(_grammarElementIdentifier_6, "\t");
            _builder.append("Factory.create");
            String _grammarElementIdentifier_7 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(rule);
            _builder.append(_grammarElementIdentifier_7, "\t");
            _builder.append("ElementType());");
            _builder.newLineIfNotEmpty();
            {
              TreeIterator<EObject> _eAllContents_1 = rule.eAllContents();
              Iterator<AbstractElement> _filter_1 = Iterators.<AbstractElement>filter(_eAllContents_1, AbstractElement.class);
              Iterable<AbstractElement> _iterable_1 = IteratorExtensions.<AbstractElement>toIterable(_filter_1);
              for(final AbstractElement element_1 : _iterable_1) {
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public static final IGrammarAwareElementType ");
                String _grammarElementIdentifier_8 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(element_1);
                _builder.append(_grammarElementIdentifier_8, "\t");
                _builder.append("_ELEMENT_TYPE = associate(");
                String _grammarElementIdentifier_9 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(rule);
                _builder.append(_grammarElementIdentifier_9, "\t");
                _builder.append("Factory.create");
                String _grammarElementIdentifier_10 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(element_1);
                _builder.append(_grammarElementIdentifier_10, "\t");
                _builder.append("ElementType());");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public IFileElementType getFileType() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return FILE_TYPE;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public IGrammarAwareElementType findElementType(");
        _builder.append(EObject.class, "\t");
        _builder.append(" grammarElement) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return GRAMMAR_ELEMENT_TYPE.get(grammarElement);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        {
          Iterable<AbstractRule> _allNonTerminalRules_1 = IdeaPluginGenerator.this._ideaPluginExtension.getAllNonTerminalRules(grammar);
          for(final AbstractRule rule_1 : _allNonTerminalRules_1) {
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public IGrammarAwareElementType get");
            String _grammarElementIdentifier_11 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(rule_1);
            _builder.append(_grammarElementIdentifier_11, "\t");
            _builder.append("ElementType() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return ");
            String _grammarElementIdentifier_12 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(rule_1);
            _builder.append(_grammarElementIdentifier_12, "\t\t");
            _builder.append("_ELEMENT_TYPE;");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            {
              TreeIterator<EObject> _eAllContents_2 = rule_1.eAllContents();
              Iterator<AbstractElement> _filter_2 = Iterators.<AbstractElement>filter(_eAllContents_2, AbstractElement.class);
              Iterable<AbstractElement> _iterable_2 = IteratorExtensions.<AbstractElement>toIterable(_filter_2);
              for(final AbstractElement element_2 : _iterable_2) {
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public IGrammarAwareElementType get");
                String _grammarElementIdentifier_13 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(element_2);
                _builder.append(_grammarElementIdentifier_13, "\t");
                _builder.append("ElementType() {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return ");
                String _grammarElementIdentifier_14 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(element_2);
                _builder.append(_grammarElementIdentifier_14, "\t\t");
                _builder.append("_ELEMENT_TYPE;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    return file;
  }
  
  public JavaFileAccess compileTokenTypeProvider(final Grammar grammar) {
    final TypeReference tokenSet = TypeReference.typeRef("com.intellij.psi.tree.TokenSet");
    final TypeReference iElementType = TypeReference.typeRef("com.intellij.psi.tree.IElementType");
    final String indexedElementType = "IndexedElementType";
    TypeReference _tokenTypeProvider = this._ideaPluginClassNames.getTokenTypeProvider(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("@");
        _builder.append(Singleton.class, "");
        _builder.newLineIfNotEmpty();
        _builder.append("public class ");
        TypeReference _tokenTypeProvider = IdeaPluginGenerator.this._ideaPluginClassNames.getTokenTypeProvider(grammar);
        String _simpleName = _tokenTypeProvider.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" implements ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.parser.TokenTypeProvider");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static final String[] TOKEN_NAMES = new ");
        TypeReference _psiInternalParser = IdeaPluginGenerator.this._ideaPluginClassNames.getPsiInternalParser(grammar);
        _builder.append(_psiInternalParser, "\t");
        _builder.append("(null).getTokenNames();");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static final ");
        _builder.append(iElementType, "\t");
        _builder.append("[] tokenTypes = new ");
        _builder.append(iElementType, "\t");
        _builder.append("[TOKEN_NAMES.length];");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("static {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("for (int i = 0; i < TOKEN_NAMES.length; i++) {");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("tokenTypes[i] = new ");
        _builder.append(indexedElementType, "\t\t\t");
        _builder.append("(TOKEN_NAMES[i], i, ");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage, "\t\t\t");
        _builder.append(".INSTANCE);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        {
          List<TerminalRule> _allTerminalRules = GrammarUtil.allTerminalRules(grammar);
          final Function1<TerminalRule, Boolean> _function = new Function1<TerminalRule, Boolean>() {
            @Override
            public Boolean apply(final TerminalRule it) {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "WS"));
            }
          };
          boolean _exists = IterableExtensions.<TerminalRule>exists(_allTerminalRules, _function);
          if (_exists) {
            _builder.append("\t");
            _builder.append("private static final ");
            _builder.append(tokenSet, "\t");
            _builder.append(" WHITESPACE_TOKENS = ");
            _builder.append(tokenSet, "\t");
            _builder.append(".create(tokenTypes[");
            TypeReference _psiInternalParser_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getPsiInternalParser(grammar);
            _builder.append(_psiInternalParser_1, "\t");
            _builder.append(".RULE_WS]);");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("private static final ");
            _builder.append(tokenSet, "\t");
            _builder.append(" WHITESPACE_TOKENS = ");
            _builder.append(tokenSet, "\t");
            _builder.append(".EMPTY;");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _and = false;
          List<TerminalRule> _allTerminalRules_1 = GrammarUtil.allTerminalRules(grammar);
          final Function1<TerminalRule, Boolean> _function_1 = new Function1<TerminalRule, Boolean>() {
            @Override
            public Boolean apply(final TerminalRule it) {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "SL_COMMENT"));
            }
          };
          boolean _exists_1 = IterableExtensions.<TerminalRule>exists(_allTerminalRules_1, _function_1);
          if (!_exists_1) {
            _and = false;
          } else {
            List<TerminalRule> _allTerminalRules_2 = GrammarUtil.allTerminalRules(grammar);
            final Function1<TerminalRule, Boolean> _function_2 = new Function1<TerminalRule, Boolean>() {
              @Override
              public Boolean apply(final TerminalRule it) {
                String _name = it.getName();
                return Boolean.valueOf(Objects.equal(_name, "ML_COMMENT"));
              }
            };
            boolean _exists_2 = IterableExtensions.<TerminalRule>exists(_allTerminalRules_2, _function_2);
            _and = _exists_2;
          }
          if (_and) {
            _builder.append("\t");
            _builder.append("private static final ");
            _builder.append(tokenSet, "\t");
            _builder.append(" COMMENT_TOKENS = ");
            _builder.append(tokenSet, "\t");
            _builder.append(".create(tokenTypes[");
            TypeReference _psiInternalParser_2 = IdeaPluginGenerator.this._ideaPluginClassNames.getPsiInternalParser(grammar);
            _builder.append(_psiInternalParser_2, "\t");
            _builder.append(".RULE_SL_COMMENT], tokenTypes[");
            TypeReference _psiInternalParser_3 = IdeaPluginGenerator.this._ideaPluginClassNames.getPsiInternalParser(grammar);
            _builder.append(_psiInternalParser_3, "\t");
            _builder.append(".RULE_ML_COMMENT]);");
            _builder.newLineIfNotEmpty();
          } else {
            List<TerminalRule> _allTerminalRules_3 = GrammarUtil.allTerminalRules(grammar);
            final Function1<TerminalRule, Boolean> _function_3 = new Function1<TerminalRule, Boolean>() {
              @Override
              public Boolean apply(final TerminalRule it) {
                String _name = it.getName();
                return Boolean.valueOf(Objects.equal(_name, "SL_COMMENT"));
              }
            };
            boolean _exists_3 = IterableExtensions.<TerminalRule>exists(_allTerminalRules_3, _function_3);
            if (_exists_3) {
              _builder.append("\t");
              _builder.append("private static final ");
              _builder.append(tokenSet, "\t");
              _builder.append(" COMMENT_TOKENS = ");
              _builder.append(tokenSet, "\t");
              _builder.append(".create(tokenTypes[");
              TypeReference _psiInternalParser_4 = IdeaPluginGenerator.this._ideaPluginClassNames.getPsiInternalParser(grammar);
              _builder.append(_psiInternalParser_4, "\t");
              _builder.append(".RULE_SL_COMMENT]);");
              _builder.newLineIfNotEmpty();
            } else {
              List<TerminalRule> _allTerminalRules_4 = GrammarUtil.allTerminalRules(grammar);
              final Function1<TerminalRule, Boolean> _function_4 = new Function1<TerminalRule, Boolean>() {
                @Override
                public Boolean apply(final TerminalRule it) {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "ML_COMMENT"));
                }
              };
              boolean _exists_4 = IterableExtensions.<TerminalRule>exists(_allTerminalRules_4, _function_4);
              if (_exists_4) {
                _builder.append("\t");
                _builder.append("private static final ");
                _builder.append(tokenSet, "\t");
                _builder.append(" COMMENT_TOKENS = ");
                _builder.append(tokenSet, "\t");
                _builder.append(".create(tokenTypes[");
                TypeReference _psiInternalParser_5 = IdeaPluginGenerator.this._ideaPluginClassNames.getPsiInternalParser(grammar);
                _builder.append(_psiInternalParser_5, "\t");
                _builder.append(".RULE_ML_COMMENT]);");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("\t");
                _builder.append("private static final ");
                _builder.append(tokenSet, "\t");
                _builder.append(" COMMENT_TOKENS = ");
                _builder.append(tokenSet, "\t");
                _builder.append(".EMPTY;");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          List<TerminalRule> _allTerminalRules_5 = GrammarUtil.allTerminalRules(grammar);
          final Function1<TerminalRule, Boolean> _function_5 = new Function1<TerminalRule, Boolean>() {
            @Override
            public Boolean apply(final TerminalRule it) {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "STRING"));
            }
          };
          boolean _exists_5 = IterableExtensions.<TerminalRule>exists(_allTerminalRules_5, _function_5);
          if (_exists_5) {
            _builder.append("\t");
            _builder.append("private static final ");
            _builder.append(tokenSet, "\t");
            _builder.append(" STRING_TOKENS = ");
            _builder.append(tokenSet, "\t");
            _builder.append(".create(tokenTypes[");
            TypeReference _psiInternalParser_6 = IdeaPluginGenerator.this._ideaPluginClassNames.getPsiInternalParser(grammar);
            _builder.append(_psiInternalParser_6, "\t");
            _builder.append(".RULE_STRING]);");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("private static final ");
            _builder.append(tokenSet, "\t");
            _builder.append(" STRING_TOKENS = ");
            _builder.append(tokenSet, "\t");
            _builder.append(".EMPTY;");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("public int getAntlrType(");
        _builder.append(iElementType, "    ");
        _builder.append(" iElementType) {");
        _builder.newLineIfNotEmpty();
        _builder.append("        ");
        _builder.append("return (iElementType instanceof ");
        _builder.append(indexedElementType, "        ");
        _builder.append(") ? ((");
        _builder.append(indexedElementType, "        ");
        _builder.append(") iElementType).getLocalIndex() : ");
        _builder.append(Token.class, "        ");
        _builder.append(".INVALID_TOKEN_TYPE;");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("    ");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("public ");
        _builder.append(iElementType, "    ");
        _builder.append(" getIElementType(int antlrType) {");
        _builder.newLineIfNotEmpty();
        _builder.append("    \t");
        _builder.append("return tokenTypes[antlrType];");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(tokenSet, "\t");
        _builder.append(" getWhitespaceTokens() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return WHITESPACE_TOKENS;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(tokenSet, "\t");
        _builder.append(" getCommentTokens() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return COMMENT_TOKENS;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(tokenSet, "\t");
        _builder.append(" getStringLiteralTokens() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return STRING_TOKENS;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_tokenTypeProvider, _client);
  }
  
  public JavaFileAccess compileSyntaxHighlighterFactory(final Grammar grammar) {
    final TypeReference syntaxHighlighter = TypeReference.typeRef("com.intellij.openapi.fileTypes.SyntaxHighlighter");
    final TypeReference lazySyntaxHighlighter = TypeReference.typeRef("com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory");
    TypeReference _syntaxHighlighterFactory = this._ideaPluginClassNames.getSyntaxHighlighterFactory(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _syntaxHighlighterFactory = IdeaPluginGenerator.this._ideaPluginClassNames.getSyntaxHighlighterFactory(grammar);
        String _simpleName = _syntaxHighlighterFactory.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        _builder.append(lazySyntaxHighlighter, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("@");
        TypeReference _typeRef = TypeReference.typeRef("org.jetbrains.annotations.NotNull");
        _builder.append(_typeRef, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("protected ");
        _builder.append(syntaxHighlighter, "    ");
        _builder.append(" createHighlighter() {");
        _builder.newLineIfNotEmpty();
        _builder.append("        ");
        _builder.append("return ");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage, "        ");
        _builder.append(".INSTANCE.getInstance(");
        _builder.append(syntaxHighlighter, "        ");
        _builder.append(".class);");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_syntaxHighlighterFactory, _client);
  }
  
  public JavaFileAccess compileSemanticHighlightVisitor(final Grammar grammar) {
    TypeReference _semanticHighlightVisitor = this._ideaPluginClassNames.getSemanticHighlightVisitor(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _semanticHighlightVisitor = IdeaPluginGenerator.this._ideaPluginClassNames.getSemanticHighlightVisitor(grammar);
        String _simpleName = _semanticHighlightVisitor.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _semanticHighlightVisitor_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getSemanticHighlightVisitor(grammar);
        String _simpleName_1 = _semanticHighlightVisitor_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage, "\t\t");
        _builder.append(".INSTANCE.injectMembers(this);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_semanticHighlightVisitor, _client);
  }
  
  public JavaFileAccess compileParserDefinition(final Grammar grammar) {
    List<AbstractRule> _allRules = GrammarUtil.allRules(grammar);
    final Function1<AbstractRule, Boolean> _function = new Function1<AbstractRule, Boolean>() {
      @Override
      public Boolean apply(final AbstractRule it) {
        return Boolean.valueOf(GrammarUtil.isEObjectRule(it));
      }
    };
    Iterable<AbstractRule> _filter = IterableExtensions.<AbstractRule>filter(_allRules, _function);
    final List<AbstractRule> EObjectRules = IterableExtensions.<AbstractRule>toList(_filter);
    final Function1<AbstractRule, Boolean> _function_1 = new Function1<AbstractRule, Boolean>() {
      @Override
      public Boolean apply(final AbstractRule it) {
        return Boolean.valueOf(IdeaPluginGenerator.this.isNamed(it));
      }
    };
    Iterable<AbstractRule> _filter_1 = IterableExtensions.<AbstractRule>filter(EObjectRules, _function_1);
    final List<AbstractRule> namedEObjectRules = IterableExtensions.<AbstractRule>toList(_filter_1);
    TypeReference _parserDefinition = this._ideaPluginClassNames.getParserDefinition(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _parserDefinition = IdeaPluginGenerator.this._ideaPluginClassNames.getParserDefinition(grammar);
        String _simpleName = _parserDefinition.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _superParserDefinition = IdeaPluginGenerator.this._ideaPluginClassNames.getSuperParserDefinition(grammar);
        _builder.append(_superParserDefinition, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        {
          boolean _isEmpty = EObjectRules.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@");
            _builder.append(Inject.class, "\t");
            _builder.append(" ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("private ");
            TypeReference _elementTypeProvider = IdeaPluginGenerator.this._ideaPluginClassNames.getElementTypeProvider(grammar);
            _builder.append(_elementTypeProvider, "\t");
            _builder.append(" elementTypeProvider;");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _typeRef = TypeReference.typeRef("com.intellij.psi.PsiFile");
        _builder.append(_typeRef, "\t");
        _builder.append(" createFile(");
        TypeReference _typeRef_1 = TypeReference.typeRef("com.intellij.psi.FileViewProvider");
        _builder.append(_typeRef_1, "\t");
        _builder.append(" viewProvider) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return new ");
        TypeReference _fileImpl = IdeaPluginGenerator.this._ideaPluginClassNames.getFileImpl(grammar);
        _builder.append(_fileImpl, "\t\t");
        _builder.append("(viewProvider);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        {
          boolean _isEmpty_1 = EObjectRules.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          if (_not_1) {
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@Override");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@SuppressWarnings(\"rawtypes\")");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public ");
            TypeReference _typeRef_2 = TypeReference.typeRef("com.intellij.psi.PsiElement");
            _builder.append(_typeRef_2, "\t");
            _builder.append(" createElement(");
            TypeReference _typeRef_3 = TypeReference.typeRef("com.intellij.lang.ASTNode");
            _builder.append(_typeRef_3, "\t");
            _builder.append(" node) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("Boolean hasSemanticElement = node.getUserData(");
            TypeReference _typeRef_4 = TypeReference.typeRef("org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder");
            _builder.append(_typeRef_4, "\t\t");
            _builder.append(".HAS_SEMANTIC_ELEMENT_KEY);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("if (hasSemanticElement != null && hasSemanticElement) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t\t");
            TypeReference _typeRef_5 = TypeReference.typeRef("com.intellij.psi.tree.IElementType");
            _builder.append(_typeRef_5, "\t\t\t");
            _builder.append(" elementType = node.getElementType();");
            _builder.newLineIfNotEmpty();
            {
              for(final AbstractRule rule : EObjectRules) {
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("if (elementType == elementTypeProvider.get");
                String _grammarElementIdentifier = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(rule);
                _builder.append(_grammarElementIdentifier, "\t\t\t");
                _builder.append("ElementType()) {");
                _builder.newLineIfNotEmpty();
                {
                  boolean _contains = namedEObjectRules.contains(rule);
                  if (_contains) {
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("return new ");
                    TypeReference _typeRef_6 = TypeReference.typeRef("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl");
                    _builder.append(_typeRef_6, "\t\t\t\t");
                    _builder.append("(node) {};");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("return new ");
                    _builder.append("org.eclipse.xtext.psi.impl.PsiEObjectImpl", "\t\t\t\t");
                    _builder.append("(node) {};");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("}");
                _builder.newLine();
                {
                  List<AbstractElement> _eAllOfType = EcoreUtil2.<AbstractElement>eAllOfType(rule, AbstractElement.class);
                  for(final AbstractElement element : _eAllOfType) {
                    {
                      if ((element instanceof Action)) {
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("if (elementType == elementTypeProvider.get");
                        String _grammarElementIdentifier_1 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(element);
                        _builder.append(_grammarElementIdentifier_1, "\t\t\t");
                        _builder.append("ElementType()) {");
                        _builder.newLineIfNotEmpty();
                        {
                          boolean _contains_1 = namedEObjectRules.contains(rule);
                          if (_contains_1) {
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("return new ");
                            TypeReference _typeRef_7 = TypeReference.typeRef("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl");
                            _builder.append(_typeRef_7, "\t\t\t\t");
                            _builder.append("(node) {};");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("\t");
                            _builder.append("return new ");
                            _builder.append("org.eclipse.xtext.psi.impl.PsiEObjectImpl", "\t\t\t\t");
                            _builder.append("(node) {};");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                        _builder.append("\t");
                        _builder.append("\t\t");
                        _builder.append("}");
                        _builder.newLine();
                      }
                    }
                    {
                      if ((element instanceof RuleCall)) {
                        {
                          boolean _isEObjectRuleCall = GrammarUtil.isEObjectRuleCall(element);
                          if (_isEObjectRuleCall) {
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("if (elementType == elementTypeProvider.get");
                            String _grammarElementIdentifier_2 = IdeaPluginGenerator.this._grammarAccessExtensions.grammarElementIdentifier(element);
                            _builder.append(_grammarElementIdentifier_2, "\t\t\t");
                            _builder.append("ElementType()) {");
                            _builder.newLineIfNotEmpty();
                            {
                              AbstractRule _rule = ((RuleCall)element).getRule();
                              boolean _contains_2 = namedEObjectRules.contains(_rule);
                              if (_contains_2) {
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("return new ");
                                TypeReference _typeRef_8 = TypeReference.typeRef("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl");
                                _builder.append(_typeRef_8, "\t\t\t\t");
                                _builder.append("(node) {};");
                                _builder.newLineIfNotEmpty();
                              } else {
                                _builder.append("\t");
                                _builder.append("\t\t");
                                _builder.append("\t");
                                _builder.append("return new ");
                                _builder.append("org.eclipse.xtext.psi.impl.PsiEObjectImpl", "\t\t\t\t");
                                _builder.append("(node) {};");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                            _builder.append("\t");
                            _builder.append("\t\t");
                            _builder.append("}");
                            _builder.newLine();
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("throw new ");
            TypeReference _typeRef_9 = TypeReference.typeRef("java.lang.IllegalStateException");
            _builder.append(_typeRef_9, "\t\t\t");
            _builder.append("(\"Unexpected element type: \" + elementType);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return super.createElement(node);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_parserDefinition, _client);
  }
  
  protected boolean isNamed(final AbstractRule rule) {
    boolean _xblockexpression = false;
    {
      TypeRef _type = rule.getType();
      EClassifier _classifier = null;
      if (_type!=null) {
        _classifier=_type.getClassifier();
      }
      final EClassifier classifier = _classifier;
      EStructuralFeature _xifexpression = null;
      if ((classifier instanceof EClass)) {
        _xifexpression = ((EClass)classifier).getEStructuralFeature("name");
      }
      final EStructuralFeature feature = _xifexpression;
      boolean _and = false;
      boolean _and_1 = false;
      if (!(feature instanceof EAttribute)) {
        _and_1 = false;
      } else {
        boolean _isMany = feature.isMany();
        boolean _not = (!_isMany);
        _and_1 = _not;
      }
      if (!_and_1) {
        _and = false;
      } else {
        EClassifier _eType = feature.getEType();
        Class<?> _instanceClass = _eType.getInstanceClass();
        boolean _isAssignableFrom = String.class.isAssignableFrom(_instanceClass);
        _and = _isAssignableFrom;
      }
      _xblockexpression = _and;
    }
    return _xblockexpression;
  }
  
  public JavaFileAccess compileAbstractCompletionContributor(final Grammar grammar) {
    TypeReference _abstractCompletionContributor = this._ideaPluginClassNames.getAbstractCompletionContributor(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _abstractCompletionContributor = IdeaPluginGenerator.this._ideaPluginClassNames.getAbstractCompletionContributor(grammar);
        String _simpleName = _abstractCompletionContributor.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _completionContributorSuperClass = IdeaPluginGenerator.this._ideaPluginClassNames.getCompletionContributorSuperClass(grammar);
        _builder.append(_completionContributorSuperClass, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _abstractCompletionContributor_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getAbstractCompletionContributor(grammar);
        String _simpleName_1 = _abstractCompletionContributor_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.lang.AbstractXtextLanguage");
        _builder.append(_typeRef, "\t");
        _builder.append(" lang) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(lang);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_abstractCompletionContributor, _client);
  }
  
  public JavaFileAccess compileCompletionContributor(final Grammar grammar) {
    TypeReference _completionContributor = this._ideaPluginClassNames.getCompletionContributor(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("class ");
        TypeReference _completionContributor = IdeaPluginGenerator.this._ideaPluginClassNames.getCompletionContributor(grammar);
        String _simpleName = _completionContributor.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _abstractCompletionContributor = IdeaPluginGenerator.this._ideaPluginClassNames.getAbstractCompletionContributor(grammar);
        _builder.append(_abstractCompletionContributor, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("new() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("this(");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage, "\t\t");
        _builder.append(".INSTANCE)");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("new(");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.lang.AbstractXtextLanguage");
        _builder.append(_typeRef, "\t");
        _builder.append(" lang) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(lang)");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("//custom rules here");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createXtendFile(_completionContributor, _client);
  }
  
  public TextFileAccess compileServicesISetup(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("META-INF/services/");
    String _name = ISetup.class.getName();
    _builder.append(_name, "");
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        TypeReference _runtimeSetup = IdeaPluginGenerator.this._xtextGeneratorNaming.getRuntimeSetup(grammar);
        _builder.append(_runtimeSetup, "");
        _builder.newLineIfNotEmpty();
      }
    };
    return this.fileAccessFactory.createTextFile(_builder.toString(), _client);
  }
  
  public JavaFileAccess compileFacetConfiguration(final Grammar grammar) {
    TypeReference _facetConfiguration = this._ideaPluginClassNames.getFacetConfiguration(grammar);
    final XtendFileAccess file = this.fileAccessFactory.createXtendFile(_facetConfiguration);
    TypeReference _typeRef = TypeReference.typeRef("com.intellij.openapi.components.PersistentStateComponent");
    file.importType(_typeRef);
    TypeReference _typeRef_1 = TypeReference.typeRef("com.intellij.openapi.components.State");
    file.importType(_typeRef_1);
    TypeReference _typeRef_2 = TypeReference.typeRef("com.intellij.openapi.components.Storage");
    file.importType(_typeRef_2);
    TypeReference _typeRef_3 = TypeReference.typeRef("com.intellij.openapi.components.StoragePathMacros");
    file.importType(_typeRef_3);
    TypeReference _typeRef_4 = TypeReference.typeRef("com.intellij.openapi.components.StorageScheme");
    file.importType(_typeRef_4);
    boolean _inheritsXbase = this._xbaseUsageDetector.inheritsXbase(grammar);
    if (_inheritsXbase) {
      TypeReference _typeRef_5 = TypeReference.typeRef("org.eclipse.xtext.xbase.idea.facet.XbaseFacetConfiguration");
      file.importType(_typeRef_5);
      TypeReference _typeRef_6 = TypeReference.typeRef("org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState");
      file.importType(_typeRef_6);
    } else {
      TypeReference _typeRef_7 = TypeReference.typeRef("org.eclipse.xtext.idea.facet.AbstractFacetConfiguration");
      file.importType(_typeRef_7);
      TypeReference _typeRef_8 = TypeReference.typeRef("org.eclipse.xtext.idea.facet.GeneratorConfigurationState");
      file.importType(_typeRef_8);
    }
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("@State(name = \"");
        String _name = grammar.getName();
        _builder.append(_name, "");
        _builder.append("Generator\", storages = #[");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("@Storage(id = \"default\", file = StoragePathMacros.PROJECT_FILE),");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("@Storage(id = \"dir\", file = StoragePathMacros.PROJECT_CONFIG_DIR");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("+ \"/");
        String _simpleName = IdeaPluginGenerator.this._ideaPluginExtension.getSimpleName(grammar);
        _builder.append(_simpleName, "\t\t\t\t");
        _builder.append("GeneratorConfig.xml\", scheme = StorageScheme.DIRECTORY_BASED)])");
        _builder.newLineIfNotEmpty();
        _builder.append("class ");
        TypeReference _facetConfiguration = IdeaPluginGenerator.this._ideaPluginClassNames.getFacetConfiguration(grammar);
        String _simpleName_1 = _facetConfiguration.getSimpleName();
        _builder.append(_simpleName_1, "");
        _builder.append(" extends ");
        {
          boolean _inheritsXbase = IdeaPluginGenerator.this._xbaseUsageDetector.inheritsXbase(grammar);
          if (_inheritsXbase) {
            _builder.append("XbaseFacetConfiguration implements PersistentStateComponent<XbaseGeneratorConfigurationState>");
          } else {
            _builder.append("AbstractFacetConfiguration implements PersistentStateComponent<GeneratorConfigurationState>");
          }
        }
        _builder.append("{");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    file.setContent(_client);
    return file;
  }
  
  public JavaFileAccess compileFacetType(final Grammar grammar) {
    TypeReference _facetConfiguration = this._ideaPluginClassNames.getFacetConfiguration(grammar);
    TypeReference _typeRef = TypeReference.typeRef("com.intellij.facet.Facet", _facetConfiguration);
    final TypeReference faceTypeId = TypeReference.typeRef("com.intellij.facet.FacetTypeId", _typeRef);
    TypeReference _facetType = this._ideaPluginClassNames.getFacetType(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _facetType = IdeaPluginGenerator.this._ideaPluginClassNames.getFacetType(grammar);
        String _simpleName = _facetType.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _facetConfiguration = IdeaPluginGenerator.this._ideaPluginClassNames.getFacetConfiguration(grammar);
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.facet.AbstractFacetType", _facetConfiguration);
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static final ");
        _builder.append(faceTypeId, "\t");
        _builder.append(" TYPEID = new ");
        _builder.append(faceTypeId, "\t");
        _builder.append("(\"");
        String _name = grammar.getName();
        _builder.append(_name, "\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _facetType_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getFacetType(grammar);
        String _simpleName_1 = _facetType_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("super(TYPEID, \"");
        String _name_1 = grammar.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append("\", \"");
        String _simpleName_2 = IdeaPluginGenerator.this._ideaPluginExtension.getSimpleName(grammar);
        _builder.append(_simpleName_2, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage, "\t\t");
        _builder.append(".INSTANCE.injectMembers(this);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_facetType, _client);
  }
  
  public JavaFileAccess compileBaseColorSettingsPage(final Grammar grammar) {
    TypeReference _baseColorSettingsPage = this._ideaPluginClassNames.baseColorSettingsPage(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("public class ");
        TypeReference _baseColorSettingsPage = IdeaPluginGenerator.this._ideaPluginClassNames.baseColorSettingsPage(grammar);
        String _simpleName = _baseColorSettingsPage.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _typeRef = TypeReference.typeRef("org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage");
        _builder.append(_typeRef, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        TypeReference _baseColorSettingsPage_1 = IdeaPluginGenerator.this._ideaPluginClassNames.baseColorSettingsPage(grammar);
        String _simpleName_1 = _baseColorSettingsPage_1.getSimpleName();
        _builder.append(_simpleName_1, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        TypeReference _ideaLanguage = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage, "\t\t");
        _builder.append(".INSTANCE.injectMembers(this);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public String getDisplayName() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return ");
        TypeReference _ideaLanguage_1 = IdeaPluginGenerator.this._ideaPluginClassNames.getIdeaLanguage(grammar);
        _builder.append(_ideaLanguage_1, "\t\t");
        _builder.append(".INSTANCE.getDisplayName();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createJavaFile(_baseColorSettingsPage, _client);
  }
  
  public JavaFileAccess compileColorSettingsPage(final Grammar grammar) {
    TypeReference _colorSettingsPage = this._ideaPluginClassNames.colorSettingsPage(grammar);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append("class ");
        TypeReference _colorSettingsPage = IdeaPluginGenerator.this._ideaPluginClassNames.colorSettingsPage(grammar);
        String _simpleName = _colorSettingsPage.getSimpleName();
        _builder.append(_simpleName, "");
        _builder.append(" extends ");
        TypeReference _baseColorSettingsPage = IdeaPluginGenerator.this._ideaPluginClassNames.baseColorSettingsPage(grammar);
        _builder.append(_baseColorSettingsPage, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    };
    return this.fileAccessFactory.createXtendFile(_colorSettingsPage, _client);
  }
  
  @Pure
  public boolean isDeployable() {
    return this.deployable;
  }
  
  public void setDeployable(final boolean deployable) {
    this.deployable = deployable;
  }
}

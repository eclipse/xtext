/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
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
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.NewlineNormalizer;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
import org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment;
import org.eclipse.xtext.idea.generator.IdeaPluginClassNames;
import org.eclipse.xtext.idea.generator.IdeaPluginExtension;
import org.eclipse.xtext.idea.generator.parser.antlr.GrammarAccessExtensions;
import org.eclipse.xtext.idea.generator.parser.antlr.XtextIDEAGeneratorExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Deprecated
@SuppressWarnings("all")
public class IdeaPluginGenerator extends Xtend2GeneratorFragment {
  private static String META_INF_PLUGIN = "META_INF_PLUGIN";
  
  private static String META_INF_PLUGIN_GEN = "META_INF_PLUGIN_GEN";
  
  private static String PLUGIN = "PLUGIN";
  
  private String encoding;
  
  private String fileExtension;
  
  private Set<String> libraries = CollectionLiterals.<String>newHashSet();
  
  @Accessors
  private String ideaProjectName;
  
  @Accessors
  private String runtimeProjectName;
  
  @Accessors
  private String ideaProjectPath;
  
  @Accessors
  private String runtimeProjectPath;
  
  @Accessors
  private boolean deployable = true;
  
  @Inject
  @Extension
  private GrammarAccess _grammarAccess;
  
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
  @Extension
  private XtextIDEAGeneratorExtensions _xtextIDEAGeneratorExtensions;
  
  @Accessors
  private boolean srcGenOnly = false;
  
  @Override
  public void generate(final LanguageConfig config, final XpandExecutionContext ctx) {
    Grammar _grammar = config.getGrammar();
    List<String> _fileExtensions = config.getFileExtensions(_grammar);
    String _head = IterableExtensions.<String>head(_fileExtensions);
    this.fileExtension = _head;
    Grammar _grammar_1 = config.getGrammar();
    Module _createModule = this.createModule(_grammar_1);
    Injector _createInjector = Guice.createInjector(_createModule);
    _createInjector.injectMembers(this);
    Grammar _grammar_2 = config.getGrammar();
    Xtend2ExecutionContext _xtend2ExecutionContext = new Xtend2ExecutionContext(ctx);
    this.generate(_grammar_2, _xtend2ExecutionContext);
  }
  
  @Override
  public void generate(final Grammar grammar, final Xtend2ExecutionContext ctx) {
    Naming _naming = this.getNaming();
    String _lineDelimiter = _naming.getLineDelimiter();
    this._xtextIDEAGeneratorExtensions.installOutlets(ctx, this.ideaProjectPath, this.encoding, _lineDelimiter);
    Outlet _srcGenOutlet = this._xtextIDEAGeneratorExtensions.getSrcGenOutlet(ctx);
    String outlet_src_gen = _srcGenOutlet.getName();
    String _xifexpression = null;
    if (this.srcGenOnly) {
      _xifexpression = outlet_src_gen;
    } else {
      Outlet _srcOutlet = this._xtextIDEAGeneratorExtensions.getSrcOutlet(ctx);
      _xifexpression = _srcOutlet.getName();
    }
    String outlet_src = _xifexpression;
    final BindFactory bindFactory = new BindFactory();
    String _antlrTokenFileProvider = this._ideaPluginClassNames.getAntlrTokenFileProvider(grammar);
    bindFactory.addTypeToType("org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider", _antlrTokenFileProvider);
    String _psiInternalLexerName = this._ideaPluginClassNames.getPsiInternalLexerName(grammar);
    bindFactory.addTypeToType("org.eclipse.xtext.parser.antlr.Lexer", _psiInternalLexerName);
    String _psiInternalLexerName_1 = this._ideaPluginClassNames.getPsiInternalLexerName(grammar);
    String _plus = (((("binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class)" + 
      ".annotatedWith(com.google.inject.name.Names.named(") + 
      "org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME") + 
      ")).to(") + _psiInternalLexerName_1);
    String _plus_1 = (_plus + ".class)");
    bindFactory.addConfiguredBinding("RuntimeLexer", _plus_1);
    String _psiParserName = this._ideaPluginClassNames.getPsiParserName(grammar);
    bindFactory.addTypeToType("com.intellij.lang.PsiParser", _psiParserName);
    String _tokenTypeProviderName = this._ideaPluginClassNames.getTokenTypeProviderName(grammar);
    bindFactory.addTypeToType("org.eclipse.xtext.idea.parser.TokenTypeProvider", _tokenTypeProviderName);
    String _parserDefinitionName = this._ideaPluginClassNames.getParserDefinitionName(grammar);
    bindFactory.addTypeToType("com.intellij.lang.ParserDefinition", _parserDefinitionName);
    String _elementTypeProviderName = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
    bindFactory.addTypeToTypeSingleton("org.eclipse.xtext.idea.lang.IElementTypeProvider", _elementTypeProviderName);
    String _facetConfiguration = this._ideaPluginClassNames.getFacetConfiguration(grammar);
    bindFactory.addTypeToType("org.eclipse.xtext.idea.facet.AbstractFacetConfiguration", _facetConfiguration);
    String _facetTypeName = this._ideaPluginClassNames.getFacetTypeName(grammar);
    String _plus_2 = (_facetTypeName + ".TYPEID");
    bindFactory.addTypeToInstance("com.intellij.facet.FacetTypeId", _plus_2);
    boolean _doesUseXbase = XbaseGeneratorFragment.doesUseXbase(grammar);
    if (_doesUseXbase) {
      bindFactory.addTypeToType("org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider", "org.eclipse.xtext.idea.common.types.StubBasedTypeScopeProvider");
      bindFactory.addTypeToType("org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker.Provider", "org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider");
      bindFactory.addConfiguredBinding("LanguageSpecificPsiModelAssociations", 
        (("binder.bind(org.eclipse.xtext.psi.IPsiModelAssociations.class)." + 
          "annotatedWith(org.eclipse.xtext.service.LanguageSpecific.class).") + 
          "to(org.eclipse.xtext.idea.common.types.DerivedMemberAwarePsiModelAssociations.class)"));
      bindFactory.addTypeToType("org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration", "org.eclipse.xtext.xbase.idea.highlighting.XbaseHighlightingConfiguration");
      bindFactory.addTypeToType("org.eclipse.xtext.idea.formatting.BlockFactory", "org.eclipse.xtext.xbase.idea.formatting.XbaseBlockFactory");
      bindFactory.addTypeToType("org.eclipse.xtext.idea.formatting.ChildAttributesProvider", "org.eclipse.xtext.xbase.idea.formatting.XbaseChildAttributesProvider");
      bindFactory.addTypeToType("org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider", "org.eclipse.xtext.xbase.idea.bracketmatching.XbaseBracePairProvider");
      bindFactory.addTypeToType("org.eclipse.xtext.idea.findusages.IReferenceSearcher", "org.eclipse.xtext.xbase.idea.findusages.JvmElementAwareReferenceSearcher");
      bindFactory.addTypeToType("org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider", "org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigProvider");
      bindFactory.addTypeToType("org.eclipse.xtext.idea.findusages.WordsScannerProvider", "org.eclipse.xtext.xbase.idea.findusages.XbaseWordsScanner.XbaseWordsScannerProvider");
    }
    final Set<Binding> bindings = bindFactory.getBindings();
    String _standaloneSetupIdea = this._ideaPluginClassNames.getStandaloneSetupIdea(grammar);
    String _javaPath = this._ideaPluginClassNames.toJavaPath(_standaloneSetupIdea);
    CharSequence _compileStandaloneSetup = this.compileStandaloneSetup(grammar);
    ctx.writeFile(outlet_src, _javaPath, _compileStandaloneSetup);
    String _ideaSetup = this._ideaPluginClassNames.getIdeaSetup(grammar);
    String _xtendPath = this._ideaPluginClassNames.toXtendPath(_ideaSetup);
    CharSequence _compileIdeaSetup = this.compileIdeaSetup(grammar);
    ctx.writeFile(outlet_src, _xtendPath, _compileIdeaSetup);
    String _ideaModuleName = this._ideaPluginClassNames.getIdeaModuleName(grammar);
    String _javaPath_1 = this._ideaPluginClassNames.toJavaPath(_ideaModuleName);
    CharSequence _compileIdeaModule = this.compileIdeaModule(grammar);
    ctx.writeFile(outlet_src, _javaPath_1, _compileIdeaModule);
    String _completionContributor = this._ideaPluginClassNames.getCompletionContributor(grammar);
    String _xtendPath_1 = this._ideaPluginClassNames.toXtendPath(_completionContributor);
    CharSequence _compileCompletionContributor = this.compileCompletionContributor(grammar);
    ctx.writeFile(outlet_src, _xtendPath_1, _compileCompletionContributor);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("META-INF/services/");
    String _name = ISetup.class.getName();
    _builder.append(_name, "");
    CharSequence _compileServicesISetup = this.compileServicesISetup(grammar);
    ctx.writeFile(outlet_src_gen, _builder.toString(), _compileServicesISetup);
    String _abstractCompletionContributor = this._ideaPluginClassNames.getAbstractCompletionContributor(grammar);
    String _javaPath_2 = this._ideaPluginClassNames.toJavaPath(_abstractCompletionContributor);
    CharSequence _compileAbstractCompletionContributor = this.compileAbstractCompletionContributor(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_2, _compileAbstractCompletionContributor);
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    String _javaPath_3 = this._ideaPluginClassNames.toJavaPath(_languageName);
    CharSequence _compileLanguage = this.compileLanguage(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_3, _compileLanguage);
    String _fileTypeName = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _xtendPath_2 = this._ideaPluginClassNames.toXtendPath(_fileTypeName);
    CharSequence _compileFileType = this.compileFileType(grammar);
    ctx.writeFile(outlet_src, _xtendPath_2, _compileFileType);
    String _abstractFileTypeName = this._ideaPluginClassNames.getAbstractFileTypeName(grammar);
    String _javaPath_4 = this._ideaPluginClassNames.toJavaPath(_abstractFileTypeName);
    CharSequence _compileAbstractFileType = this.compileAbstractFileType(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_4, _compileAbstractFileType);
    String _fileTypeFactoryName = this._ideaPluginClassNames.getFileTypeFactoryName(grammar);
    String _javaPath_5 = this._ideaPluginClassNames.toJavaPath(_fileTypeFactoryName);
    CharSequence _compileFileTypeFactory = this.compileFileTypeFactory(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_5, _compileFileTypeFactory);
    String _fileImplName = this._ideaPluginClassNames.getFileImplName(grammar);
    String _javaPath_6 = this._ideaPluginClassNames.toJavaPath(_fileImplName);
    CharSequence _compileFileImpl = this.compileFileImpl(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_6, _compileFileImpl);
    String _tokenTypeProviderName_1 = this._ideaPluginClassNames.getTokenTypeProviderName(grammar);
    String _javaPath_7 = this._ideaPluginClassNames.toJavaPath(_tokenTypeProviderName_1);
    CharSequence _compileTokenTypeProvider = this.compileTokenTypeProvider(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_7, _compileTokenTypeProvider);
    String _elementTypeProviderName_1 = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
    String _javaPath_8 = this._ideaPluginClassNames.toJavaPath(_elementTypeProviderName_1);
    CharSequence _compileElementTypeProvider = this.compileElementTypeProvider(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_8, _compileElementTypeProvider);
    String _parserDefinitionName_1 = this._ideaPluginClassNames.getParserDefinitionName(grammar);
    String _javaPath_9 = this._ideaPluginClassNames.toJavaPath(_parserDefinitionName_1);
    CharSequence _compileParserDefinition = this.compileParserDefinition(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_9, _compileParserDefinition);
    String _syntaxHighlighterFactoryName = this._ideaPluginClassNames.getSyntaxHighlighterFactoryName(grammar);
    String _javaPath_10 = this._ideaPluginClassNames.toJavaPath(_syntaxHighlighterFactoryName);
    CharSequence _compileSyntaxHighlighterFactory = this.compileSyntaxHighlighterFactory(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_10, _compileSyntaxHighlighterFactory);
    String _semanticHighlightVisitorName = this._ideaPluginClassNames.getSemanticHighlightVisitorName(grammar);
    String _javaPath_11 = this._ideaPluginClassNames.toJavaPath(_semanticHighlightVisitorName);
    CharSequence _compileSemanticHighlightVisitor = this.compileSemanticHighlightVisitor(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_11, _compileSemanticHighlightVisitor);
    String _abstractIdeaModuleName = this._ideaPluginClassNames.getAbstractIdeaModuleName(grammar);
    String _javaPath_12 = this._ideaPluginClassNames.toJavaPath(_abstractIdeaModuleName);
    CharSequence _compileGuiceModuleIdeaGenerated = this.compileGuiceModuleIdeaGenerated(grammar, bindings);
    ctx.writeFile(outlet_src_gen, _javaPath_12, _compileGuiceModuleIdeaGenerated);
    String _extensionFactoryName = this._ideaPluginClassNames.getExtensionFactoryName(grammar);
    String _javaPath_13 = this._ideaPluginClassNames.toJavaPath(_extensionFactoryName);
    CharSequence _compileExtensionFactory = this.compileExtensionFactory(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_13, _compileExtensionFactory);
    String _codeBlockModificationListenerName = this._ideaPluginClassNames.getCodeBlockModificationListenerName(grammar);
    String _javaPath_14 = this._ideaPluginClassNames.toJavaPath(_codeBlockModificationListenerName);
    CharSequence _compileCodeBlockModificationListener = this.compileCodeBlockModificationListener(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_14, _compileCodeBlockModificationListener);
    String _psiParserName_1 = this._ideaPluginClassNames.getPsiParserName(grammar);
    String _javaPath_15 = this._ideaPluginClassNames.toJavaPath(_psiParserName_1);
    CharSequence _compilePsiParser = this.compilePsiParser(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_15, _compilePsiParser);
    String _antlrTokenFileProvider_1 = this._ideaPluginClassNames.getAntlrTokenFileProvider(grammar);
    String _javaPath_16 = this._ideaPluginClassNames.toJavaPath(_antlrTokenFileProvider_1);
    CharSequence _compileAntlrTokenFileProvider = this.compileAntlrTokenFileProvider(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_16, _compileAntlrTokenFileProvider);
    String _pomDeclarationSearcherName = this._ideaPluginClassNames.getPomDeclarationSearcherName(grammar);
    String _javaPath_17 = this._ideaPluginClassNames.toJavaPath(_pomDeclarationSearcherName);
    CharSequence _compilePomDeclarationSearcher = this.compilePomDeclarationSearcher(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_17, _compilePomDeclarationSearcher);
    String _facetTypeName_1 = this._ideaPluginClassNames.getFacetTypeName(grammar);
    String _javaPath_18 = this._ideaPluginClassNames.toJavaPath(_facetTypeName_1);
    CharSequence _compileFacetType = this.compileFacetType(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_18, _compileFacetType);
    String _facetConfiguration_1 = this._ideaPluginClassNames.getFacetConfiguration(grammar);
    String _javaPath_19 = this._ideaPluginClassNames.toJavaPath(_facetConfiguration_1);
    CharSequence _compileFacetConfiguration = this.compileFacetConfiguration(grammar);
    ctx.writeFile(outlet_src, _javaPath_19, _compileFacetConfiguration);
    String _baseColorSettingsPage = this._ideaPluginClassNames.baseColorSettingsPage(grammar);
    String _javaPath_20 = this._ideaPluginClassNames.toJavaPath(_baseColorSettingsPage);
    CharSequence _compileBaseColorSettingsPage = this.compileBaseColorSettingsPage(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_20, _compileBaseColorSettingsPage);
    String _colorSettingsPage = this._ideaPluginClassNames.colorSettingsPage(grammar);
    String _xtendPath_3 = this._ideaPluginClassNames.toXtendPath(_colorSettingsPage);
    CharSequence _compileColorSettingsPage = this.compileColorSettingsPage(grammar);
    ctx.writeFile(outlet_src, _xtendPath_3, _compileColorSettingsPage);
    OutputImpl output = new OutputImpl();
    this.addOutlet(output, IdeaPluginGenerator.PLUGIN, false, this.ideaProjectPath);
    this.addOutlet(output, IdeaPluginGenerator.META_INF_PLUGIN, false, (this.ideaProjectPath + "/META-INF"));
    this.addOutlet(output, IdeaPluginGenerator.META_INF_PLUGIN_GEN, true, (this.ideaProjectPath + "/META-INF"));
    if (this.deployable) {
      CharSequence _compilePluginXml = this.compilePluginXml(grammar);
      this.writeFile(output, IdeaPluginGenerator.META_INF_PLUGIN, "plugin.xml", _compilePluginXml);
      CharSequence _compilePluginGenXml = this.compilePluginGenXml(grammar);
      this.writeFile(output, IdeaPluginGenerator.META_INF_PLUGIN_GEN, "plugin_gen.xml", _compilePluginGenXml);
    }
  }
  
  public CharSequence compileGuiceModuleIdeaGenerated(final Grammar grammar, final Set<Binding> bindings) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _abstractIdeaModuleName = this._ideaPluginClassNames.getAbstractIdeaModuleName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_abstractIdeaModuleName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _abstractIdeaModuleName_1 = this._ideaPluginClassNames.getAbstractIdeaModuleName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_abstractIdeaModuleName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends org.eclipse.xtext.idea.DefaultIdeaModule {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final Binding it : bindings) {
        {
          boolean _and = false;
          BindValue _value = it.getValue();
          boolean _isProvider = _value.isProvider();
          boolean _not = (!_isProvider);
          if (!_not) {
            _and = false;
          } else {
            BindValue _value_1 = it.getValue();
            String[] _statements = _value_1.getStatements();
            boolean _isEmpty = ((List<String>)Conversions.doWrapArray(_statements)).isEmpty();
            _and = _isEmpty;
          }
          if (_and) {
            _builder.append("\t");
            _builder.append("// contributed by ");
            String _contributedBy = it.getContributedBy();
            _builder.append(_contributedBy, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            {
              BindKey _key = it.getKey();
              boolean _isSingleton = _key.isSingleton();
              if (_isSingleton) {
                _builder.append("@org.eclipse.xtext.service.SingletonBinding");
                {
                  BindKey _key_1 = it.getKey();
                  boolean _isEagerSingleton = _key_1.isEagerSingleton();
                  if (_isEagerSingleton) {
                    _builder.append("(eager=true)");
                  }
                }
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("public ");
            {
              BindValue _value_2 = it.getValue();
              String _expression = _value_2.getExpression();
              boolean _equals = Objects.equal(_expression, null);
              if (_equals) {
                _builder.append("Class<? extends ");
                BindKey _key_2 = it.getKey();
                String _type = _key_2.getType();
                _builder.append(_type, "\t");
                _builder.append(">");
              } else {
                BindKey _key_3 = it.getKey();
                String _type_1 = _key_3.getType();
                _builder.append(_type_1, "\t");
              }
            }
            _builder.append(" ");
            String _bindMethodName = this.bindMethodName(it);
            _builder.append(_bindMethodName, "\t");
            _builder.append("() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return ");
            {
              BindValue _value_3 = it.getValue();
              String _expression_1 = _value_3.getExpression();
              boolean _notEquals = (!Objects.equal(_expression_1, null));
              if (_notEquals) {
                BindValue _value_4 = it.getValue();
                String _expression_2 = _value_4.getExpression();
                _builder.append(_expression_2, "\t\t");
              } else {
                BindValue _value_5 = it.getValue();
                String _typeName = _value_5.getTypeName();
                _builder.append(_typeName, "\t\t");
                _builder.append(".class");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          } else {
            BindValue _value_6 = it.getValue();
            String[] _statements_1 = _value_6.getStatements();
            boolean _isEmpty_1 = ((List<String>)Conversions.doWrapArray(_statements_1)).isEmpty();
            if (_isEmpty_1) {
              _builder.append("\t");
              _builder.append("// contributed by ");
              String _contributedBy_1 = it.getContributedBy();
              _builder.append(_contributedBy_1, "\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              {
                BindKey _key_4 = it.getKey();
                boolean _isSingleton_1 = _key_4.isSingleton();
                if (_isSingleton_1) {
                  _builder.append("@org.eclipse.xtext.service.SingletonBinding");
                  {
                    BindKey _key_5 = it.getKey();
                    boolean _isEagerSingleton_1 = _key_5.isEagerSingleton();
                    if (_isEagerSingleton_1) {
                      _builder.append("(eager=true)");
                    }
                  }
                }
              }
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("public ");
              {
                BindValue _value_7 = it.getValue();
                String _expression_3 = _value_7.getExpression();
                boolean _equals_1 = Objects.equal(_expression_3, null);
                if (_equals_1) {
                  _builder.append("Class<? extends com.google.inject.Provider<");
                  BindKey _key_6 = it.getKey();
                  String _type_2 = _key_6.getType();
                  _builder.append(_type_2, "\t");
                  _builder.append(">>");
                } else {
                  _builder.append("com.google.inject.Provider<");
                  BindKey _key_7 = it.getKey();
                  String _type_3 = _key_7.getType();
                  _builder.append(_type_3, "\t");
                  _builder.append(">");
                }
              }
              _builder.append(" ");
              String _bindMethodName_1 = this.bindMethodName(it);
              _builder.append(_bindMethodName_1, "\t");
              _builder.append("() {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("return ");
              {
                BindValue _value_8 = it.getValue();
                String _expression_4 = _value_8.getExpression();
                boolean _notEquals_1 = (!Objects.equal(_expression_4, null));
                if (_notEquals_1) {
                  BindValue _value_9 = it.getValue();
                  String _expression_5 = _value_9.getExpression();
                  _builder.append(_expression_5, "\t\t");
                } else {
                  BindValue _value_10 = it.getValue();
                  String _typeName_1 = _value_10.getTypeName();
                  _builder.append(_typeName_1, "\t\t");
                  _builder.append(".class");
                }
              }
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            } else {
              _builder.append("\t");
              _builder.append("// contributed by ");
              String _contributedBy_2 = it.getContributedBy();
              _builder.append(_contributedBy_2, "\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("public void ");
              String _bindMethodName_2 = this.bindMethodName(it);
              _builder.append(_bindMethodName_2, "\t");
              _builder.append("(com.google.inject.Binder binder) {");
              _builder.newLineIfNotEmpty();
              {
                BindValue _value_11 = it.getValue();
                String[] _statements_2 = _value_11.getStatements();
                for(final String statement : _statements_2) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append(statement, "\t\t");
                  {
                    boolean _endsWith = statement.endsWith(";");
                    boolean _not_1 = (!_endsWith);
                    if (_not_1) {
                      _builder.append(";");
                    }
                  }
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public String bindMethodName(final Binding it) {
    String _xifexpression = null;
    boolean _and = false;
    BindValue _value = it.getValue();
    boolean _isProvider = _value.isProvider();
    boolean _not = (!_isProvider);
    if (!_not) {
      _and = false;
    } else {
      BindValue _value_1 = it.getValue();
      String[] _statements = _value_1.getStatements();
      boolean _isEmpty = ((List<String>)Conversions.doWrapArray(_statements)).isEmpty();
      _and = _isEmpty;
    }
    if (_and) {
      _xifexpression = "bind";
    } else {
      String _xifexpression_1 = null;
      BindValue _value_2 = it.getValue();
      String[] _statements_1 = _value_2.getStatements();
      boolean _isEmpty_1 = ((List<String>)Conversions.doWrapArray(_statements_1)).isEmpty();
      if (_isEmpty_1) {
        _xifexpression_1 = "provide";
      } else {
        _xifexpression_1 = "configure";
      }
      _xifexpression = _xifexpression_1;
    }
    final String prefix = _xifexpression;
    String _xifexpression_2 = null;
    boolean _and_1 = false;
    BindValue _value_3 = it.getValue();
    String _expression = _value_3.getExpression();
    boolean _notEquals = (!Objects.equal(_expression, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      BindValue _value_4 = it.getValue();
      boolean _isProvider_1 = _value_4.isProvider();
      boolean _not_1 = (!_isProvider_1);
      _and_1 = _not_1;
    }
    if (_and_1) {
      _xifexpression_2 = "ToInstance";
    } else {
      _xifexpression_2 = "";
    }
    final String suffix = _xifexpression_2;
    BindKey _key = it.getKey();
    String _type = _key.getType();
    String _simpleMethodName = this.simpleMethodName(_type);
    String _plus = (prefix + _simpleMethodName);
    return (_plus + suffix);
  }
  
  private String simpleMethodName(final String qn) {
    String _replaceAll = qn.replaceAll("<", "\\.");
    String _replaceAll_1 = _replaceAll.replaceAll(">", "\\.");
    String[] _split = _replaceAll_1.split("\\.");
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String e) {
        return Boolean.valueOf(e.matches("[A-Z].*"));
      }
    };
    Iterable<String> _filter = IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(_split)), _function);
    return IterableExtensions.join(_filter, "$");
  }
  
  public CharSequence compileExtensionFactory(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _extensionFactoryName = this._ideaPluginClassNames.getExtensionFactoryName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_extensionFactoryName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.openapi.extensions.ExtensionFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _extensionFactoryName_1 = this._ideaPluginClassNames.getExtensionFactoryName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_extensionFactoryName_1);
    _builder.append(_simpleName, "");
    _builder.append(" implements ExtensionFactory {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Object createInstance(final String factoryArgument, final String implementationClass) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Class<?> clazz;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("clazz = Class.forName(implementationClass);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (ClassNotFoundException e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new IllegalArgumentException(\"Couldn\'t load \"+implementationClass, e);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_1, "\t\t");
    _builder.append(".INSTANCE.<Object> getInstance(clazz);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileCodeBlockModificationListener(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _codeBlockModificationListenerName = this._ideaPluginClassNames.getCodeBlockModificationListenerName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_codeBlockModificationListenerName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _doesUseXbase = XbaseGeneratorFragment.doesUseXbase(grammar);
      if (_doesUseXbase) {
        _builder.append("import com.intellij.psi.impl.PsiTreeChangeEventImpl;");
        _builder.newLine();
      }
    }
    _builder.append("import com.intellij.psi.util.PsiModificationTracker;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _codeBlockModificationListenerName_1 = this._ideaPluginClassNames.getCodeBlockModificationListenerName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_codeBlockModificationListenerName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends BaseXtextCodeBlockModificationListener {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _codeBlockModificationListenerName_2 = this._ideaPluginClassNames.getCodeBlockModificationListenerName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_codeBlockModificationListenerName_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append("(PsiModificationTracker psiModificationTracker) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_2, "\t\t");
    _builder.append(".INSTANCE, psiModificationTracker);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    {
      boolean _doesUseXbase_1 = XbaseGeneratorFragment.doesUseXbase(grammar);
      if (_doesUseXbase_1) {
        _builder.newLine();
        _builder.append("\t");
        _builder.append("protected boolean hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {");
        _builder.newLine();
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
    return _builder;
  }
  
  public CharSequence compilePomDeclarationSearcher(final Grammar it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _pomDeclarationSearcherName = this._ideaPluginClassNames.getPomDeclarationSearcherName(it);
    String _packageName = this._ideaPluginClassNames.toPackageName(_pomDeclarationSearcherName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(it);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _pomDeclarationSearcherName_1 = this._ideaPluginClassNames.getPomDeclarationSearcherName(it);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_pomDeclarationSearcherName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractXtextPomDeclarationSearcher {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _pomDeclarationSearcherName_2 = this._ideaPluginClassNames.getPomDeclarationSearcherName(it);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_pomDeclarationSearcherName_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(it);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_2, "\t\t");
    _builder.append(".INSTANCE);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compilePsiParser(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _psiParserName = this._ideaPluginClassNames.getPsiParserName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_psiParserName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      List<String> _initialHiddenTokens = this._grammarAccessExtensions.initialHiddenTokens(grammar);
      boolean _isEmpty = _initialHiddenTokens.isEmpty();
      if (_isEmpty) {
        _builder.append("import static java.util.Collections.emptySet;");
        _builder.newLine();
        _builder.newLine();
      } else {
        _builder.append("import java.util.Arrays;");
        _builder.newLine();
        _builder.append("import java.util.HashSet;");
        _builder.newLine();
      }
    }
    _builder.append("import java.util.Set;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.antlr.runtime.TokenStream;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;");
    _builder.newLine();
    _builder.append("import ");
    String _elementTypeProviderName = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
    _builder.append(_elementTypeProviderName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _psiInternalParserName = this._ideaPluginClassNames.getPsiInternalParserName(grammar);
    _builder.append(_psiInternalParserName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _gaFQName = this._grammarAccess.gaFQName(grammar);
    _builder.append(_gaFQName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.google.inject.Inject;");
    _builder.newLine();
    _builder.append("import com.intellij.lang.PsiBuilder;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _psiParserName_1 = this._ideaPluginClassNames.getPsiParserName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_psiParserName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractXtextPsiParser {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      List<String> _initialHiddenTokens_1 = this._grammarAccessExtensions.initialHiddenTokens(grammar);
      boolean _isEmpty_1 = _initialHiddenTokens_1.isEmpty();
      boolean _not = (!_isEmpty_1);
      if (_not) {
        _builder.append("\t");
        _builder.append("private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList(");
        {
          List<String> _initialHiddenTokens_2 = this._grammarAccessExtensions.initialHiddenTokens(grammar);
          boolean _hasElements = false;
          for(final String hidden : _initialHiddenTokens_2) {
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
        _builder.append("private static final Set<String> INITIAL_HIDDEN_TOKENS = emptySet();");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ");
    String _gaSimpleName = this._grammarAccess.gaSimpleName(grammar);
    _builder.append(_gaSimpleName, "\t");
    _builder.append(" grammarAccess;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ");
    String _elementTypeProviderName_1 = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_elementTypeProviderName_1);
    _builder.append(_simpleName_1, "\t");
    _builder.append(" elementTypeProvider;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected AbstractPsiAntlrParser createParser(PsiBuilder builder, TokenStream tokenStream) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new ");
    String _psiInternalParserName_1 = this._ideaPluginClassNames.getPsiInternalParserName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_psiInternalParserName_1);
    _builder.append(_simpleName_2, "\t\t");
    _builder.append("(builder, tokenStream, elementTypeProvider, grammarAccess);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Set<String> getInitialHiddenTokens() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return INITIAL_HIDDEN_TOKENS;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileAntlrTokenFileProvider(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _antlrTokenFileProvider = this._ideaPluginClassNames.getAntlrTokenFileProvider(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_antlrTokenFileProvider);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.io.InputStream;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _antlrTokenFileProvider_1 = this._ideaPluginClassNames.getAntlrTokenFileProvider(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_antlrTokenFileProvider_1);
    _builder.append(_simpleName, "");
    _builder.append(" implements IAntlrTokenFileProvider {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public InputStream getAntlrTokenFile() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ClassLoader classLoader = getClass().getClassLoader();");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("return classLoader.getResourceAsStream(\"");
    String _tokens = this._ideaPluginClassNames.getTokens(grammar);
    _builder.append(_tokens, "    \t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public String iml() {
    return (this.ideaProjectPath + ".iml");
  }
  
  public void addOutlet(final Output output, final String outletName, final boolean overwrite, final String path) {
    String _encoding = this.getEncoding();
    final Outlet outlet = new Outlet(false, _encoding, outletName, overwrite, path);
    Naming _naming = this.getNaming();
    String _lineDelimiter = _naming.getLineDelimiter();
    NewlineNormalizer _newlineNormalizer = new NewlineNormalizer(_lineDelimiter);
    outlet.addPostprocessor(_newlineNormalizer);
    output.addOutlet(outlet);
  }
  
  public void writeFile(final Output output, final String outletName, final String filename, final CharSequence contents) {
    output.openFile(filename, outletName);
    String _string = contents.toString();
    output.write(_string);
    output.closeFile();
  }
  
  public String getEncoding() {
    boolean _notEquals = (!Objects.equal(this.encoding, null));
    if (_notEquals) {
      return this.encoding;
    }
    return System.getProperty("file.encoding");
  }
  
  public boolean addLibrary(final String library) {
    return this.libraries.add(library);
  }
  
  public void setEncoding(final String encoding) {
    this.encoding = encoding;
  }
  
  public CharSequence compilePluginXml(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<idea-plugin version=\"2\" xmlns:xi=\"http://www.w3.org/2001/XInclude\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<id>");
    _builder.append(this.ideaProjectName, "\t");
    _builder.append("</id>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<name>");
    String _simpleName = this._ideaPluginExtension.getSimpleName(grammar);
    _builder.append(_simpleName, "\t");
    _builder.append(" Support</name>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<description>");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("This plugin enables smart editing of ");
    String _simpleName_1 = this._ideaPluginExtension.getSimpleName(grammar);
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
    return _builder;
  }
  
  public CharSequence compilePluginGenXml(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
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
        _builder.append("<package uri=\"");
        EPackage _ePackage = generatedMetamodel.getEPackage();
        String _nsURI = _ePackage.getNsURI();
        _builder.append(_nsURI, "\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t\t ");
        _builder.append("class=\"");
        String _namespace = GrammarUtil.getNamespace(grammar);
        _builder.append(_namespace, "\t\t\t\t ");
        _builder.append(".");
        String _name = generatedMetamodel.getName();
        _builder.append(_name, "\t\t\t\t ");
        _builder.append(".");
        String _name_1 = generatedMetamodel.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_1);
        _builder.append(_firstUpper, "\t\t\t\t ");
        _builder.append("Package\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("<resourceFactory type=\"");
    _builder.append(this.fileExtension, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("class=\"org.eclipse.xtext.resource.IResourceFactory\"");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t ");
    _builder.append("factoryClass=\"");
    String _extensionFactoryName = this._ideaPluginClassNames.getExtensionFactoryName(grammar);
    _builder.append(_extensionFactoryName, "\t\t\t\t\t\t ");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<resourceServiceProvider uriExtension=\"");
    _builder.append(this.fileExtension, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t\t ");
    _builder.append("class=\"org.eclipse.xtext.idea.resource.IResourceIdeaServiceProvider\"");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t\t ");
    _builder.append("factoryClass=\"");
    String _extensionFactoryName_1 = this._ideaPluginClassNames.getExtensionFactoryName(grammar);
    _builder.append(_extensionFactoryName_1, "\t\t\t\t\t\t\t\t ");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<lang.setup language=\"");
    String _languageID = this._ideaPluginExtension.getLanguageID(grammar);
    _builder.append(_languageID, "\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("implementationClass=\"");
    String _ideaSetup = this._ideaPluginClassNames.getIdeaSetup(grammar);
    _builder.append(_ideaSetup, "\t\t\t\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</extensions>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<extensions defaultExtensionNs=\"com.intellij\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<psi.treeChangePreprocessor implementation=\"");
    String _codeBlockModificationListenerName = this._ideaPluginClassNames.getCodeBlockModificationListenerName(grammar);
    _builder.append(_codeBlockModificationListenerName, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<fileTypeFactory implementation=\"");
    String _fileTypeFactoryName = this._ideaPluginClassNames.getFileTypeFactoryName(grammar);
    _builder.append(_fileTypeFactoryName, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<stubElementTypeHolder class=\"");
    String _elementTypeProviderName = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
    _builder.append(_elementTypeProviderName, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _compileExtension = this.compileExtension(grammar, "lang.ast.factory", "org.eclipse.xtext.idea.lang.BaseXtextASTFactory");
    _builder.append(_compileExtension, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _parserDefinitionName = this._ideaPluginClassNames.getParserDefinitionName(grammar);
    CharSequence _compileExtension_1 = this.compileExtension(grammar, "lang.parserDefinition", _parserDefinitionName);
    _builder.append(_compileExtension_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _compileExtension_2 = this.compileExtension(grammar, "lang.findUsagesProvider", "org.eclipse.xtext.idea.findusages.BaseXtextFindUsageProvider");
    _builder.append(_compileExtension_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _compileExtension_3 = this.compileExtension(grammar, "lang.refactoringSupport", "org.eclipse.xtext.idea.refactoring.BaseXtextRefactoringSupportProvider");
    _builder.append(_compileExtension_3, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _compileExtension_4 = this.compileExtension(grammar, "lang.namesValidator", "com.intellij.lang.refactoring.NamesValidator");
    _builder.append(_compileExtension_4, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("      \t");
    _builder.append("<lang.syntaxHighlighterFactory key=\"");
    String _languageID_1 = this._ideaPluginExtension.getLanguageID(grammar);
    _builder.append(_languageID_1, "      \t");
    _builder.append("\" implementationClass=\"");
    String _syntaxHighlighterFactoryName = this._ideaPluginClassNames.getSyntaxHighlighterFactoryName(grammar);
    _builder.append(_syntaxHighlighterFactoryName, "      \t");
    _builder.append("\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _compileExtension_5 = this.compileExtension(grammar, "lang.braceMatcher", "com.intellij.lang.PairedBraceMatcher");
    _builder.append(_compileExtension_5, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("      \t");
    CharSequence _compileExtension_6 = this.compileExtension(grammar, "annotator", "org.eclipse.xtext.idea.annotation.IssueAnnotator");
    _builder.append(_compileExtension_6, "      \t");
    _builder.newLineIfNotEmpty();
    _builder.append("      \t");
    _builder.append("<completion.contributor language=\"");
    String _languageID_2 = this._ideaPluginExtension.getLanguageID(grammar);
    _builder.append(_languageID_2, "      \t");
    _builder.append("\" implementationClass=\"");
    String _completionContributor = this._ideaPluginClassNames.getCompletionContributor(grammar);
    _builder.append(_completionContributor, "      \t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("      \t");
    _builder.append("<pom.declarationSearcher implementation=\"");
    String _pomDeclarationSearcherName = this._ideaPluginClassNames.getPomDeclarationSearcherName(grammar);
    _builder.append(_pomDeclarationSearcherName, "      \t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("      \t");
    CharSequence _compileExtension_7 = this.compileExtension(grammar, "lang.psiStructureViewFactory", "com.intellij.lang.PsiStructureViewFactory");
    _builder.append(_compileExtension_7, "      \t");
    _builder.newLineIfNotEmpty();
    _builder.append("      \t");
    CharSequence _compileExtension_8 = this.compileExtension(grammar, "lang.documentationProvider", "org.eclipse.xtext.idea.documentation.IdeaDocumentationProvider");
    _builder.append(_compileExtension_8, "      \t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<facetType implementation=\"");
    String _facetTypeName = this._ideaPluginClassNames.getFacetTypeName(grammar);
    _builder.append(_facetTypeName, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<colorSettingsPage implementation=\"");
    String _colorSettingsPage = this._ideaPluginClassNames.colorSettingsPage(grammar);
    _builder.append(_colorSettingsPage, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<highlightVisitor implementation=\"");
    String _semanticHighlightVisitorName = this._ideaPluginClassNames.getSemanticHighlightVisitorName(grammar);
    _builder.append(_semanticHighlightVisitorName, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _compileExtension_9 = this.compileExtension(grammar, "lang.formatter", "com.intellij.formatting.FormattingModelBuilder");
    _builder.append(_compileExtension_9, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _compileExtension_10 = this.compileExtension(grammar, "lang.commenter", "com.intellij.lang.CodeDocumentationAwareCommenter");
    _builder.append(_compileExtension_10, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</extensions>");
    _builder.newLine();
    _builder.append("</idea-plugin>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileExtension(final Grammar grammar, final String extensionPointId, final String implementationClass) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<");
    _builder.append(extensionPointId, "");
    _builder.append(" language=\"");
    String _languageID = this._ideaPluginExtension.getLanguageID(grammar);
    _builder.append(_languageID, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("factoryClass=\"");
    String _extensionFactoryName = this._ideaPluginClassNames.getExtensionFactoryName(grammar);
    _builder.append(_extensionFactoryName, "\t\t\t\t\t\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("implementationClass=\"");
    _builder.append(implementationClass, "\t\t\t\t\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileFileImpl(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _psiImplPackageName = this._ideaPluginClassNames.getPsiImplPackageName(grammar);
    _builder.append(_psiImplPackageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.psi.impl.BaseXtextFile;");
    _builder.newLine();
    _builder.append("import ");
    String _fileTypeName = this._ideaPluginClassNames.getFileTypeName(grammar);
    _builder.append(_fileTypeName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.openapi.fileTypes.FileType;");
    _builder.newLine();
    _builder.append("import com.intellij.psi.FileViewProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public final class ");
    String _fileImplName = this._ideaPluginClassNames.getFileImplName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_fileImplName);
    _builder.append(_simpleName, "");
    _builder.append(" extends BaseXtextFile {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _fileImplName_1 = this._ideaPluginClassNames.getFileImplName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_fileImplName_1);
    _builder.append(_simpleName_1, "\t");
    _builder.append("(FileViewProvider viewProvider) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(viewProvider, ");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_2, "\t\t");
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
    _builder.append("public FileType getFileType() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ");
    String _fileTypeName_1 = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(_fileTypeName_1);
    _builder.append(_simpleName_3, "\t\t");
    _builder.append(".INSTANCE;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileFileTypeFactory(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _fileTypeFactoryName = this._ideaPluginClassNames.getFileTypeFactoryName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_fileTypeFactoryName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.openapi.fileTypes.FileTypeConsumer;");
    _builder.newLine();
    _builder.append("import com.intellij.openapi.fileTypes.FileTypeFactory;");
    _builder.newLine();
    _builder.append("import org.jetbrains.annotations.NotNull;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _fileTypeFactoryName_1 = this._ideaPluginClassNames.getFileTypeFactoryName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_fileTypeFactoryName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends FileTypeFactory {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void createFileTypes(@NotNull FileTypeConsumer consumer) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("consumer.consume(");
    String _fileTypeName = this._ideaPluginClassNames.getFileTypeName(grammar);
    _builder.append(_fileTypeName, "\t\t");
    _builder.append(".INSTANCE, ");
    String _abstractFileTypeName = this._ideaPluginClassNames.getAbstractFileTypeName(grammar);
    _builder.append(_abstractFileTypeName, "\t\t");
    _builder.append(".DEFAULT_EXTENSION);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileAbstractFileType(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _abstractFileTypeName = this._ideaPluginClassNames.getAbstractFileTypeName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_abstractFileTypeName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.swing.Icon;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.Icons;");
    _builder.newLine();
    _builder.append("import org.jetbrains.annotations.NonNls;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.intellij.lang.Language;");
    _builder.newLine();
    _builder.append("import com.intellij.openapi.fileTypes.LanguageFileType;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _abstractFileTypeName_1 = this._ideaPluginClassNames.getAbstractFileTypeName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_abstractFileTypeName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends LanguageFileType {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@NonNls ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final String DEFAULT_EXTENSION = \"");
    _builder.append(this.fileExtension, "\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected ");
    String _abstractFileTypeName_2 = this._ideaPluginClassNames.getAbstractFileTypeName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_abstractFileTypeName_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append("(final Language language) {");
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
    String _simpleName_2 = this._ideaPluginExtension.getSimpleName(grammar);
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
    _builder.append("public Icon getIcon() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return Icons.DSL_FILE_TYPE;");
    _builder.newLine();
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
    String _simpleName_3 = this._ideaPluginExtension.getSimpleName(grammar);
    _builder.append(_simpleName_3, "\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileFileType(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _fileTypeName = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_fileTypeName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class ");
    String _fileTypeName_1 = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_fileTypeName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends ");
    String _abstractFileTypeName = this._ideaPluginClassNames.getAbstractFileTypeName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_abstractFileTypeName);
    _builder.append(_simpleName_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final ");
    String _fileTypeName_2 = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_fileTypeName_2);
    _builder.append(_simpleName_2, "\t");
    _builder.append(" INSTANCE = new ");
    String _fileTypeName_3 = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(_fileTypeName_3);
    _builder.append(_simpleName_3, "\t");
    _builder.append("()");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_4 = this._ideaPluginClassNames.toSimpleName(_languageName);
    _builder.append(_simpleName_4, "\t\t");
    _builder.append(".INSTANCE)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileLanguage(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_languageName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public final class ");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractXtextLanguage {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final ");
    String _languageName_2 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_languageName_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append(" INSTANCE = new ");
    String _languageName_3 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_languageName_3);
    _builder.append(_simpleName_2, "\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ");
    String _languageName_4 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(_languageName_4);
    _builder.append(_simpleName_3, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(\"");
    String _languageID = this._ideaPluginExtension.getLanguageID(grammar);
    _builder.append(_languageID, "\t\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileStandaloneSetup(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _standaloneSetupIdea = this._ideaPluginClassNames.getStandaloneSetupIdea(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_standaloneSetupIdea);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.util.Modules2;");
    _builder.newLine();
    _builder.append("import ");
    Naming _naming = this.getNaming();
    String _setupImpl = _naming.setupImpl(grammar);
    _builder.append(_setupImpl, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.google.inject.Guice;");
    _builder.newLine();
    _builder.append("import com.google.inject.Injector;");
    _builder.newLine();
    _builder.append("import com.google.inject.Module;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _standaloneSetupIdea_1 = this._ideaPluginClassNames.getStandaloneSetupIdea(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_standaloneSetupIdea_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends ");
    Naming _naming_1 = this.getNaming();
    Naming _naming_2 = this.getNaming();
    String _setupImpl_1 = _naming_2.setupImpl(grammar);
    String _simpleName_1 = _naming_1.toSimpleName(_setupImpl_1);
    _builder.append(_simpleName_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public Injector createInjector() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Module runtimeModule = new ");
    Naming _naming_3 = this.getNaming();
    String _guiceModuleRt = _naming_3.guiceModuleRt(grammar);
    _builder.append(_guiceModuleRt, "        ");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("Module ideaModule = new ");
    String _ideaModuleName = this._ideaPluginClassNames.getIdeaModuleName(grammar);
    _builder.append(_ideaModuleName, "        ");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return Guice.createInjector(mergedModule);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileIdeaSetup(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _ideaSetup = this._ideaPluginClassNames.getIdeaSetup(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_ideaSetup);
    _builder.append(_packageName, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.ISetup");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _ideaSetup_1 = this._ideaPluginClassNames.getIdeaSetup(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_ideaSetup_1);
    _builder.append(_simpleName, "");
    _builder.append(" implements ISetup {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override createInjectorAndDoEMFRegistration() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("EcoreGlobalRegistries.ensureInitialized");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new ");
    String _standaloneSetupIdea = this._ideaPluginClassNames.getStandaloneSetupIdea(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_standaloneSetupIdea);
    _builder.append(_simpleName_1, "\t\t");
    _builder.append("().createInjector");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileIdeaModule(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _ideaModuleName = this._ideaPluginClassNames.getIdeaModuleName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_ideaModuleName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _ideaModuleName_1 = this._ideaPluginClassNames.getIdeaModuleName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_ideaModuleName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends ");
    String _abstractIdeaModuleName = this._ideaPluginClassNames.getAbstractIdeaModuleName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_abstractIdeaModuleName);
    _builder.append(_simpleName_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileElementTypeProvider(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _elementTypeProviderName = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_elementTypeProviderName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.lang.IElementTypeProvider;");
    _builder.newLine();
    _builder.append("import ");
    String _fileImplName = this._ideaPluginClassNames.getFileImplName(grammar);
    _builder.append(_fileImplName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _grammarAccessName = this._ideaPluginClassNames.getGrammarAccessName(grammar);
    _builder.append(_grammarAccessName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.xtext.psi.stubs.XtextFileElementType;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.psi.stubs.XtextFileStub;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.intellij.psi.tree.IFileElementType;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _elementTypeProviderName_1 = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_elementTypeProviderName_1);
    _builder.append(_simpleName, "");
    _builder.append(" implements IElementTypeProvider {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<");
    String _fileImplName_1 = this._ideaPluginClassNames.getFileImplName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_fileImplName_1);
    _builder.append(_simpleName_1, "\t");
    _builder.append(">>(");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_languageName);
    _builder.append(_simpleName_2, "\t");
    _builder.append(".INSTANCE);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();");
    _builder.newLine();
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
    String _grammarAccessName_1 = this._ideaPluginClassNames.getGrammarAccessName(grammar);
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(_grammarAccessName_1);
    _builder.append(_simpleName_3, "\t");
    _builder.append(" GRAMMAR_ACCESS = ");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_4 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_4, "\t");
    _builder.append(".INSTANCE.getInstance(");
    String _grammarAccessName_2 = this._ideaPluginClassNames.getGrammarAccessName(grammar);
    String _simpleName_5 = this._ideaPluginClassNames.toSimpleName(_grammarAccessName_2);
    _builder.append(_simpleName_5, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    {
      Iterable<AbstractRule> _allNonTerminalRules = this._ideaPluginExtension.getAllNonTerminalRules(grammar);
      for(final AbstractRule rule : _allNonTerminalRules) {
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private static class ");
        String _grammarElementIdentifier = this._grammarAccessExtensions.grammarElementIdentifier(rule);
        _builder.append(_grammarElementIdentifier, "\t");
        _builder.append("Factory {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("public static IGrammarAwareElementType create");
        String _grammarElementIdentifier_1 = this._grammarAccessExtensions.grammarElementIdentifier(rule);
        _builder.append(_grammarElementIdentifier_1, "\t\t");
        _builder.append("ElementType() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return new IGrammarAwareElementType(\"");
        String _grammarElementIdentifier_2 = this._grammarAccessExtensions.grammarElementIdentifier(rule);
        _builder.append(_grammarElementIdentifier_2, "\t\t\t");
        _builder.append("_ELEMENT_TYPE\", ");
        String _languageName_2 = this._ideaPluginClassNames.getLanguageName(grammar);
        String _simpleName_6 = this._ideaPluginClassNames.toSimpleName(_languageName_2);
        _builder.append(_simpleName_6, "\t\t\t");
        _builder.append(".INSTANCE, GRAMMAR_ACCESS.");
        String _gaRuleAccessor = this._grammarAccess.gaRuleAccessor(rule);
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
            String _grammarElementIdentifier_3 = this._grammarAccessExtensions.grammarElementIdentifier(element);
            _builder.append(_grammarElementIdentifier_3, "\t\t");
            _builder.append("ElementType() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return new IGrammarAwareElementType(\"");
            String _grammarElementIdentifier_4 = this._grammarAccessExtensions.grammarElementIdentifier(element);
            _builder.append(_grammarElementIdentifier_4, "\t\t\t");
            _builder.append("_ELEMENT_TYPE\", ");
            String _languageName_3 = this._ideaPluginClassNames.getLanguageName(grammar);
            String _simpleName_7 = this._ideaPluginClassNames.toSimpleName(_languageName_3);
            _builder.append(_simpleName_7, "\t\t\t");
            _builder.append(".INSTANCE, GRAMMAR_ACCESS.");
            String _gaElementsAccessor = this._grammarAccess.gaElementsAccessor(rule);
            _builder.append(_gaElementsAccessor, "\t\t\t");
            _builder.append(".");
            String _gaElementAccessor = this._grammarAccess.gaElementAccessor(element);
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
        String _grammarElementIdentifier_5 = this._grammarAccessExtensions.grammarElementIdentifier(rule);
        _builder.append(_grammarElementIdentifier_5, "\t");
        _builder.append("_ELEMENT_TYPE = associate(");
        String _grammarElementIdentifier_6 = this._grammarAccessExtensions.grammarElementIdentifier(rule);
        _builder.append(_grammarElementIdentifier_6, "\t");
        _builder.append("Factory.create");
        String _grammarElementIdentifier_7 = this._grammarAccessExtensions.grammarElementIdentifier(rule);
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
            String _grammarElementIdentifier_8 = this._grammarAccessExtensions.grammarElementIdentifier(element_1);
            _builder.append(_grammarElementIdentifier_8, "\t");
            _builder.append("_ELEMENT_TYPE = associate(");
            String _grammarElementIdentifier_9 = this._grammarAccessExtensions.grammarElementIdentifier(rule);
            _builder.append(_grammarElementIdentifier_9, "\t");
            _builder.append("Factory.create");
            String _grammarElementIdentifier_10 = this._grammarAccessExtensions.grammarElementIdentifier(element_1);
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
    _builder.append("public IGrammarAwareElementType findElementType(EObject grammarElement) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return GRAMMAR_ELEMENT_TYPE.get(grammarElement);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    {
      Iterable<AbstractRule> _allNonTerminalRules_1 = this._ideaPluginExtension.getAllNonTerminalRules(grammar);
      for(final AbstractRule rule_1 : _allNonTerminalRules_1) {
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public IGrammarAwareElementType get");
        String _grammarElementIdentifier_11 = this._grammarAccessExtensions.grammarElementIdentifier(rule_1);
        _builder.append(_grammarElementIdentifier_11, "\t");
        _builder.append("ElementType() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        String _grammarElementIdentifier_12 = this._grammarAccessExtensions.grammarElementIdentifier(rule_1);
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
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public IGrammarAwareElementType get");
            String _grammarElementIdentifier_13 = this._grammarAccessExtensions.grammarElementIdentifier(element_2);
            _builder.append(_grammarElementIdentifier_13, "\t");
            _builder.append("ElementType() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return ");
            String _grammarElementIdentifier_14 = this._grammarAccessExtensions.grammarElementIdentifier(element_2);
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
    return _builder;
  }
  
  public CharSequence compileTokenTypeProvider(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _tokenTypeProviderName = this._ideaPluginClassNames.getTokenTypeProviderName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_tokenTypeProviderName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import static ");
    String _psiInternalParserName = this._ideaPluginClassNames.getPsiInternalParserName(grammar);
    _builder.append(_psiInternalParserName, "");
    _builder.append(".*;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.parser.TokenTypeProvider;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _psiInternalParserName_1 = this._ideaPluginClassNames.getPsiInternalParserName(grammar);
    _builder.append(_psiInternalParserName_1, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.google.inject.Singleton;");
    _builder.newLine();
    _builder.append("import com.intellij.psi.tree.IElementType;");
    _builder.newLine();
    _builder.append("import com.intellij.psi.tree.TokenSet;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Singleton public class ");
    String _tokenTypeProviderName_1 = this._ideaPluginClassNames.getTokenTypeProviderName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_tokenTypeProviderName_1);
    _builder.append(_simpleName, "");
    _builder.append(" implements TokenTypeProvider {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final String[] TOKEN_NAMES = new ");
    String _psiInternalParserName_2 = this._ideaPluginClassNames.getPsiInternalParserName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_psiInternalParserName_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append("(null).getTokenNames();");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final IElementType[] tokenTypes = new IElementType[TOKEN_NAMES.length];");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (int i = 0; i < TOKEN_NAMES.length; i++) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("tokenTypes[i] = new IndexedElementType(TOKEN_NAMES[i], i, ");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_2, "\t\t\t");
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
        _builder.append("private static final TokenSet WHITESPACE_TOKENS = TokenSet.create(tokenTypes[RULE_WS]);");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("private static final TokenSet WHITESPACE_TOKENS = TokenSet.EMPTY;");
        _builder.newLine();
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
        _builder.append("private static final TokenSet COMMENT_TOKENS = TokenSet.create(tokenTypes[RULE_SL_COMMENT], tokenTypes[RULE_ML_COMMENT]);");
        _builder.newLine();
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
          _builder.append("private static final TokenSet COMMENT_TOKENS = TokenSet.create(tokenTypes[RULE_SL_COMMENT]);");
          _builder.newLine();
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
            _builder.append("private static final TokenSet COMMENT_TOKENS = TokenSet.create(tokenTypes[RULE_ML_COMMENT]);");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("private static final TokenSet COMMENT_TOKENS = TokenSet.EMPTY;");
            _builder.newLine();
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
        _builder.append("private static final TokenSet STRING_TOKENS = TokenSet.create(tokenTypes[RULE_STRING]);");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("private static final TokenSet STRING_TOKENS = TokenSet.EMPTY;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public int getAntlrType(IElementType iElementType) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return (iElementType instanceof IndexedElementType) ? ((IndexedElementType) iElementType).getLocalIndex()");
    _builder.newLine();
    _builder.append("        \t\t\t\t");
    _builder.append(": org.antlr.runtime.Token.INVALID_TOKEN_TYPE;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public IElementType getIElementType(int antlrType) {");
    _builder.newLine();
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
    _builder.append("public TokenSet getWhitespaceTokens() {");
    _builder.newLine();
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
    _builder.append("public TokenSet getCommentTokens() {");
    _builder.newLine();
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
    _builder.append("public TokenSet getStringLiteralTokens() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return STRING_TOKENS;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileSyntaxHighlighterFactory(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _syntaxHighlighterFactoryName = this._ideaPluginClassNames.getSyntaxHighlighterFactoryName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_syntaxHighlighterFactoryName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.jetbrains.annotations.NotNull;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;");
    _builder.newLine();
    _builder.append("import com.intellij.openapi.fileTypes.SyntaxHighlighter;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _syntaxHighlighterFactoryName_1 = this._ideaPluginClassNames.getSyntaxHighlighterFactoryName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_syntaxHighlighterFactoryName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends SingleLazyInstanceSyntaxHighlighterFactory {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@NotNull");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected SyntaxHighlighter createHighlighter() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return ");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_1, "        ");
    _builder.append(".INSTANCE.getInstance(SyntaxHighlighter.class);");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileSemanticHighlightVisitor(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _semanticHighlightVisitorName = this._ideaPluginClassNames.getSemanticHighlightVisitorName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_semanticHighlightVisitorName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _semanticHighlightVisitorName_1 = this._ideaPluginClassNames.getSemanticHighlightVisitorName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_semanticHighlightVisitorName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends SemanticHighlightVisitor {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public ");
    String _semanticHighlightVisitorName_2 = this._ideaPluginClassNames.getSemanticHighlightVisitorName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_semanticHighlightVisitorName_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_2, "\t\t");
    _builder.append(".INSTANCE.injectMembers(this);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileParserDefinition(final Grammar grammar) {
    CharSequence _xblockexpression = null;
    {
      List<AbstractRule> _allRules = GrammarUtil.allRules(grammar);
      final Function1<AbstractRule, Boolean> _function = new Function1<AbstractRule, Boolean>() {
        @Override
        public Boolean apply(final AbstractRule it) {
          return Boolean.valueOf(GrammarUtil.isEObjectRule(it));
        }
      };
      final Iterable<AbstractRule> EObjectRules = IterableExtensions.<AbstractRule>filter(_allRules, _function);
      final Function1<AbstractRule, Boolean> _function_1 = new Function1<AbstractRule, Boolean>() {
        @Override
        public Boolean apply(final AbstractRule it) {
          boolean _or = false;
          boolean _isNamed = IdeaPluginGenerator.this.isNamed(it);
          if (_isNamed) {
            _or = true;
          } else {
            Iterable<AbstractElement> _eObjectElements = IdeaPluginGenerator.this.getEObjectElements(it);
            final Function1<AbstractElement, Boolean> _function = new Function1<AbstractElement, Boolean>() {
              @Override
              public Boolean apply(final AbstractElement it) {
                return Boolean.valueOf(IdeaPluginGenerator.this.isNamed(it));
              }
            };
            boolean _exists = IterableExtensions.<AbstractElement>exists(_eObjectElements, _function);
            _or = _exists;
          }
          return Boolean.valueOf(_or);
        }
      };
      final boolean hasNamed = IterableExtensions.<AbstractRule>exists(EObjectRules, _function_1);
      final Function1<AbstractRule, Boolean> _function_2 = new Function1<AbstractRule, Boolean>() {
        @Override
        public Boolean apply(final AbstractRule it) {
          boolean _or = false;
          boolean _isNamed = IdeaPluginGenerator.this.isNamed(it);
          boolean _not = (!_isNamed);
          if (_not) {
            _or = true;
          } else {
            Iterable<AbstractElement> _eObjectElements = IdeaPluginGenerator.this.getEObjectElements(it);
            final Function1<AbstractElement, Boolean> _function = new Function1<AbstractElement, Boolean>() {
              @Override
              public Boolean apply(final AbstractElement it) {
                boolean _isNamed = IdeaPluginGenerator.this.isNamed(it);
                return Boolean.valueOf((!_isNamed));
              }
            };
            boolean _exists = IterableExtensions.<AbstractElement>exists(_eObjectElements, _function);
            _or = _exists;
          }
          return Boolean.valueOf(_or);
        }
      };
      final boolean hasNotNamed = IterableExtensions.<AbstractRule>exists(EObjectRules, _function_2);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _parserDefinitionName = this._ideaPluginClassNames.getParserDefinitionName(grammar);
      String _packageName = this._ideaPluginClassNames.toPackageName(_parserDefinitionName);
      _builder.append(_packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import ");
      String _fileImplName = this._ideaPluginClassNames.getFileImplName(grammar);
      _builder.append(_fileImplName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      String _superParserDefinitionName = this._ideaPluginClassNames.getSuperParserDefinitionName(grammar);
      _builder.append(_superParserDefinitionName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      {
        boolean _isEmpty = IterableExtensions.isEmpty(EObjectRules);
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;");
          _builder.newLine();
          _builder.append("import ");
          String _elementTypeProviderName = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
          _builder.append(_elementTypeProviderName, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          {
            if (hasNotNamed) {
              _builder.append("import org.eclipse.xtext.psi.impl.PsiEObjectImpl;");
              _builder.newLine();
            }
          }
          {
            if (hasNamed) {
              _builder.append("import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("import ");
      String _name = Inject.class.getName();
      _builder.append(_name, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import com.intellij.lang.ASTNode;");
      _builder.newLine();
      _builder.append("import com.intellij.psi.FileViewProvider;");
      _builder.newLine();
      _builder.append("import com.intellij.psi.PsiElement;");
      _builder.newLine();
      _builder.append("import com.intellij.psi.PsiFile;");
      _builder.newLine();
      _builder.append("import com.intellij.psi.tree.IElementType;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      String _parserDefinitionName_1 = this._ideaPluginClassNames.getParserDefinitionName(grammar);
      String _simpleName = this._ideaPluginClassNames.toSimpleName(_parserDefinitionName_1);
      _builder.append(_simpleName, "");
      _builder.append(" extends ");
      String _superParserDefinitionName_1 = this._ideaPluginClassNames.getSuperParserDefinitionName(grammar);
      String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_superParserDefinitionName_1);
      _builder.append(_simpleName_1, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      {
        boolean _isEmpty_1 = IterableExtensions.isEmpty(EObjectRules);
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Inject ");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("private ");
          String _elementTypeProviderName_1 = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
          String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_elementTypeProviderName_1);
          _builder.append(_simpleName_2, "\t");
          _builder.append(" elementTypeProvider;");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public PsiFile createFile(FileViewProvider viewProvider) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return new ");
      String _fileImplName_1 = this._ideaPluginClassNames.getFileImplName(grammar);
      String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(_fileImplName_1);
      _builder.append(_simpleName_3, "\t\t");
      _builder.append("(viewProvider);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      {
        boolean _isEmpty_2 = IterableExtensions.isEmpty(EObjectRules);
        boolean _not_2 = (!_isEmpty_2);
        if (_not_2) {
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@Override");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("@SuppressWarnings(\"rawtypes\")");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public PsiElement createElement(ASTNode node) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("Boolean hasSemanticElement = node.getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY);");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("if (hasSemanticElement != null && hasSemanticElement) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("IElementType elementType = node.getElementType();");
          _builder.newLine();
          {
            for(final AbstractRule rule : EObjectRules) {
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("if (elementType == elementTypeProvider.get");
              String _grammarElementIdentifier = this._grammarAccessExtensions.grammarElementIdentifier(rule);
              _builder.append(_grammarElementIdentifier, "\t\t\t");
              _builder.append("ElementType()) {");
              _builder.newLineIfNotEmpty();
              {
                boolean _isNamed = this.isNamed(rule);
                if (_isNamed) {
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("return new PsiNamedEObjectImpl(node) {};");
                  _builder.newLine();
                } else {
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append("\t");
                  _builder.append("return new PsiEObjectImpl(node) {};");
                  _builder.newLine();
                }
              }
              _builder.append("\t");
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
              {
                Iterable<AbstractElement> _eObjectElements = this.getEObjectElements(rule);
                for(final AbstractElement element : _eObjectElements) {
                  _builder.append("\t");
                  _builder.append("\t\t");
                  _builder.append("if (elementType == elementTypeProvider.get");
                  String _grammarElementIdentifier_1 = this._grammarAccessExtensions.grammarElementIdentifier(element);
                  _builder.append(_grammarElementIdentifier_1, "\t\t\t");
                  _builder.append("ElementType()) {");
                  _builder.newLineIfNotEmpty();
                  {
                    boolean _isNamed_1 = this.isNamed(element);
                    if (_isNamed_1) {
                      _builder.append("\t");
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("return new PsiNamedEObjectImpl(node) {};");
                      _builder.newLine();
                    } else {
                      _builder.append("\t");
                      _builder.append("\t\t");
                      _builder.append("\t");
                      _builder.append("return new PsiEObjectImpl(node) {};");
                      _builder.newLine();
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
          _builder.append("\t");
          _builder.append("\t\t");
          _builder.append("throw new IllegalStateException(\"Unexpected element type: \" + elementType);");
          _builder.newLine();
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
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected Iterable<AbstractElement> getEObjectElements(final AbstractRule rule) {
    List<AbstractElement> _eAllOfType = EcoreUtil2.<AbstractElement>eAllOfType(rule, AbstractElement.class);
    final Function1<AbstractElement, Boolean> _function = new Function1<AbstractElement, Boolean>() {
      @Override
      public Boolean apply(final AbstractElement element) {
        boolean _switchResult = false;
        boolean _matched = false;
        if (element instanceof Action) {
          _matched=true;
        }
        if (!_matched) {
          if (element instanceof RuleCall) {
            boolean _isEObjectRuleCall = GrammarUtil.isEObjectRuleCall(element);
            if (_isEObjectRuleCall) {
              _matched=true;
            }
          }
        }
        if (_matched) {
          _switchResult = true;
        }
        if (!_matched) {
          _switchResult = false;
        }
        return Boolean.valueOf(_switchResult);
      }
    };
    return IterableExtensions.<AbstractElement>filter(_eAllOfType, _function);
  }
  
  protected boolean isNamed(final EObject element) {
    boolean _xblockexpression = false;
    {
      TypeRef _switchResult = null;
      boolean _matched = false;
      if (element instanceof AbstractRule) {
        _matched=true;
        _switchResult = ((AbstractRule)element).getType();
      }
      if (!_matched) {
        if (element instanceof RuleCall) {
          _matched=true;
          AbstractRule _rule = ((RuleCall)element).getRule();
          TypeRef _type = null;
          if (_rule!=null) {
            _type=_rule.getType();
          }
          _switchResult = _type;
        }
      }
      if (!_matched) {
        if (element instanceof Action) {
          _matched=true;
          _switchResult = ((Action)element).getType();
        }
      }
      final TypeRef type = _switchResult;
      EClassifier _classifier = null;
      if (type!=null) {
        _classifier=type.getClassifier();
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
  
  public CharSequence compileAbstractCompletionContributor(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _completionContributor = this._ideaPluginClassNames.getCompletionContributor(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_completionContributor);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;");
    _builder.newLine();
    _builder.append("import ");
    String _completionContributorSuperClass = this._ideaPluginClassNames.getCompletionContributorSuperClass(grammar);
    _builder.append(_completionContributorSuperClass, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _abstractCompletionContributor = this._ideaPluginClassNames.getAbstractCompletionContributor(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_abstractCompletionContributor);
    _builder.append(_simpleName, "");
    _builder.append(" extends ");
    String _completionContributorSuperClass_1 = this._ideaPluginClassNames.getCompletionContributorSuperClass(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_completionContributorSuperClass_1);
    _builder.append(_simpleName_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public ");
    String _abstractCompletionContributor_1 = this._ideaPluginClassNames.getAbstractCompletionContributor(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_abstractCompletionContributor_1);
    _builder.append(_simpleName_2, "\t");
    _builder.append("(AbstractXtextLanguage lang) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(lang);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileCompletionContributor(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _completionContributor = this._ideaPluginClassNames.getCompletionContributor(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_completionContributor);
    _builder.append(_packageName, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class ");
    String _completionContributor_1 = this._ideaPluginClassNames.getCompletionContributor(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_completionContributor_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends ");
    String _abstractCompletionContributor = this._ideaPluginClassNames.getAbstractCompletionContributor(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_abstractCompletionContributor);
    _builder.append(_simpleName_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this(");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_2, "\t\t");
    _builder.append(".INSTANCE)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(AbstractXtextLanguage lang) {");
    _builder.newLine();
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
    return _builder;
  }
  
  public CharSequence compileServicesISetup(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    String _standaloneSetup = this._ideaPluginClassNames.getStandaloneSetup(grammar);
    _builder.append(_standaloneSetup, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileFacetConfiguration(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _facetConfiguration = this._ideaPluginClassNames.getFacetConfiguration(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_facetConfiguration);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.openapi.components.PersistentStateComponent;");
    _builder.newLine();
    _builder.append("import com.intellij.openapi.components.State;");
    _builder.newLine();
    _builder.append("import com.intellij.openapi.components.Storage;");
    _builder.newLine();
    _builder.append("import com.intellij.openapi.components.StoragePathMacros;");
    _builder.newLine();
    _builder.append("import com.intellij.openapi.components.StorageScheme;");
    _builder.newLine();
    {
      boolean _doesUseXbase = XbaseGeneratorFragment.doesUseXbase(grammar);
      if (_doesUseXbase) {
        _builder.append("import org.eclipse.xtext.xbase.idea.facet.XbaseFacetConfiguration;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState;");
        _builder.newLine();
      } else {
        _builder.append("import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;");
        _builder.newLine();
        _builder.append("import org.eclipse.xtext.idea.facet.GeneratorConfigurationState;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("@State(name = \"");
    String _name = grammar.getName();
    _builder.append(_name, "");
    _builder.append("Generator\", storages = {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("@Storage(id = \"default\", file = StoragePathMacros.PROJECT_FILE),");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@Storage(id = \"dir\", file = StoragePathMacros.PROJECT_CONFIG_DIR");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("+ \"/");
    String _name_1 = grammar.getName();
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_name_1);
    _builder.append(_simpleName, "\t\t\t\t");
    _builder.append("GeneratorConfig.xml\", scheme = StorageScheme.DIRECTORY_BASED)})");
    _builder.newLineIfNotEmpty();
    _builder.append("public class ");
    String _facetConfiguration_1 = this._ideaPluginClassNames.getFacetConfiguration(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_facetConfiguration_1);
    _builder.append(_simpleName_1, "");
    _builder.append(" extends ");
    {
      boolean _doesUseXbase_1 = XbaseGeneratorFragment.doesUseXbase(grammar);
      if (_doesUseXbase_1) {
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
    return _builder;
  }
  
  public CharSequence compileFacetType(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _facetTypeName = this._ideaPluginClassNames.getFacetTypeName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_facetTypeName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.facet.Facet;");
    _builder.newLine();
    _builder.append("import com.intellij.facet.FacetTypeId;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.facet.AbstractFacetType;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _facetTypeName_1 = this._ideaPluginClassNames.getFacetTypeName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_facetTypeName_1);
    _builder.append(_simpleName, "");
    _builder.append("  extends AbstractFacetType<");
    String _facetConfiguration = this._ideaPluginClassNames.getFacetConfiguration(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_facetConfiguration);
    _builder.append(_simpleName_1, "");
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final FacetTypeId<Facet<");
    String _facetConfiguration_1 = this._ideaPluginClassNames.getFacetConfiguration(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_facetConfiguration_1);
    _builder.append(_simpleName_2, "\t");
    _builder.append(">> TYPEID = new FacetTypeId<Facet<");
    String _facetConfiguration_2 = this._ideaPluginClassNames.getFacetConfiguration(grammar);
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(_facetConfiguration_2);
    _builder.append(_simpleName_3, "\t");
    _builder.append(">>(\"");
    String _name = grammar.getName();
    _builder.append(_name, "\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _facetTypeName_2 = this._ideaPluginClassNames.getFacetTypeName(grammar);
    String _simpleName_4 = this._ideaPluginClassNames.toSimpleName(_facetTypeName_2);
    _builder.append(_simpleName_4, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(TYPEID, \"");
    String _name_1 = grammar.getName();
    _builder.append(_name_1, "\t\t");
    _builder.append("\", \"");
    String _name_2 = grammar.getName();
    String _simpleName_5 = this._ideaPluginClassNames.toSimpleName(_name_2);
    _builder.append(_simpleName_5, "\t\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "\t\t");
    _builder.append(".INSTANCE.injectMembers(this);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileBaseColorSettingsPage(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _baseColorSettingsPage = this._ideaPluginClassNames.baseColorSettingsPage(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_baseColorSettingsPage);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _baseColorSettingsPage_1 = this._ideaPluginClassNames.baseColorSettingsPage(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_baseColorSettingsPage_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractColorSettingsPage {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _baseColorSettingsPage_2 = this._ideaPluginClassNames.baseColorSettingsPage(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_baseColorSettingsPage_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_2, "\t\t");
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
    String _languageName_2 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(_languageName_2);
    _builder.append(_simpleName_3, "\t\t");
    _builder.append(".INSTANCE.getDisplayName();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileColorSettingsPage(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _colorSettingsPage = this._ideaPluginClassNames.colorSettingsPage(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_colorSettingsPage);
    _builder.append(_packageName, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class ");
    String _colorSettingsPage_1 = this._ideaPluginClassNames.colorSettingsPage(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_colorSettingsPage_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends ");
    String _baseColorSettingsPage = this._ideaPluginClassNames.baseColorSettingsPage(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_baseColorSettingsPage);
    _builder.append(_simpleName_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  @Pure
  public String getIdeaProjectName() {
    return this.ideaProjectName;
  }
  
  public void setIdeaProjectName(final String ideaProjectName) {
    this.ideaProjectName = ideaProjectName;
  }
  
  @Pure
  public String getRuntimeProjectName() {
    return this.runtimeProjectName;
  }
  
  public void setRuntimeProjectName(final String runtimeProjectName) {
    this.runtimeProjectName = runtimeProjectName;
  }
  
  @Pure
  public String getIdeaProjectPath() {
    return this.ideaProjectPath;
  }
  
  public void setIdeaProjectPath(final String ideaProjectPath) {
    this.ideaProjectPath = ideaProjectPath;
  }
  
  @Pure
  public String getRuntimeProjectPath() {
    return this.runtimeProjectPath;
  }
  
  public void setRuntimeProjectPath(final String runtimeProjectPath) {
    this.runtimeProjectPath = runtimeProjectPath;
  }
  
  @Pure
  public boolean isDeployable() {
    return this.deployable;
  }
  
  public void setDeployable(final boolean deployable) {
    this.deployable = deployable;
  }
  
  @Pure
  public boolean isSrcGenOnly() {
    return this.srcGenOnly;
  }
  
  public void setSrcGenOnly(final boolean srcGenOnly) {
    this.srcGenOnly = srcGenOnly;
  }
}

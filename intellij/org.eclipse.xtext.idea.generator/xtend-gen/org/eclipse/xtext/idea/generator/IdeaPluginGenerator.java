package org.eclipse.xtext.idea.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess;
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

@SuppressWarnings("all")
public class IdeaPluginGenerator extends Xtend2GeneratorFragment {
  private static String META_INF_PLUGIN = "META_INF_PLUGIN";
  
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
  
  @Accessors
  private boolean typesIntegrationRequired = false;
  
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
  
  public void generate(final Grammar grammar, final Xtend2ExecutionContext ctx) {
    this._xtextIDEAGeneratorExtensions.installOutlets(ctx, this.ideaProjectPath, this.encoding);
    Outlet _srcOutlet = this._xtextIDEAGeneratorExtensions.getSrcOutlet(ctx);
    String outlet_src = _srcOutlet.getName();
    Outlet _srcGenOutlet = this._xtextIDEAGeneratorExtensions.getSrcGenOutlet(ctx);
    String outlet_src_gen = _srcGenOutlet.getName();
    final BindFactory bindFactory = new BindFactory();
    String _syntaxHighlighterName = this._ideaPluginClassNames.getSyntaxHighlighterName(grammar);
    bindFactory.addTypeToType("com.intellij.openapi.fileTypes.SyntaxHighlighter", _syntaxHighlighterName);
    String _lexerName = this._ideaPluginClassNames.getLexerName(grammar);
    bindFactory.addTypeToType("com.intellij.lexer.Lexer", _lexerName);
    String _psiParserName = this._ideaPluginClassNames.getPsiParserName(grammar);
    bindFactory.addTypeToType("com.intellij.lang.PsiParser", _psiParserName);
    String _tokenTypeProviderName = this._ideaPluginClassNames.getTokenTypeProviderName(grammar);
    bindFactory.addTypeToType("org.eclipse.xtext.idea.parser.TokenTypeProvider", _tokenTypeProviderName);
    String _parserDefinitionName = this._ideaPluginClassNames.getParserDefinitionName(grammar);
    bindFactory.addTypeToType("com.intellij.lang.ParserDefinition", _parserDefinitionName);
    String _elementTypeProviderName = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
    bindFactory.addTypeToTypeSingleton("org.eclipse.xtext.idea.lang.IElementTypeProvider", _elementTypeProviderName);
    if (this.typesIntegrationRequired) {
      bindFactory.addTypeToType("org.eclipse.xtext.common.types.access.IJvmTypeProvider.Factory", "org.eclipse.xtext.idea.types.access.StubTypeProviderFactory");
      bindFactory.addTypeToType("org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider", "org.eclipse.xtext.idea.types.StubBasedTypeScopeProvider");
      bindFactory.addTypeToType("org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator", "org.eclipse.xtext.idea.jvmmodel.PsiJvmModelAssociator");
      bindFactory.addTypeToTypeSingleton("org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex", "org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex");
      bindFactory.addTypeToType("org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker.Provider", "org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider");
    }
    final Set<Binding> bindings = bindFactory.getBindings();
    String _standaloneSetupIdea = this._ideaPluginClassNames.getStandaloneSetupIdea(grammar);
    String _javaPath = this._ideaPluginClassNames.toJavaPath(_standaloneSetupIdea);
    CharSequence _compileStandaloneSetup = this.compileStandaloneSetup(grammar);
    ctx.writeFile(outlet_src, _javaPath, _compileStandaloneSetup);
    String _ideaModuleName = this._ideaPluginClassNames.getIdeaModuleName(grammar);
    String _javaPath_1 = this._ideaPluginClassNames.toJavaPath(_ideaModuleName);
    CharSequence _compileIdeaModule = this.compileIdeaModule(grammar);
    ctx.writeFile(outlet_src, _javaPath_1, _compileIdeaModule);
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    String _javaPath_2 = this._ideaPluginClassNames.toJavaPath(_languageName);
    CharSequence _compileLanguage = this.compileLanguage(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_2, _compileLanguage);
    String _fileTypeName = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _javaPath_3 = this._ideaPluginClassNames.toJavaPath(_fileTypeName);
    CharSequence _compileFileType = this.compileFileType(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_3, _compileFileType);
    String _fileTypeFactoryName = this._ideaPluginClassNames.getFileTypeFactoryName(grammar);
    String _javaPath_4 = this._ideaPluginClassNames.toJavaPath(_fileTypeFactoryName);
    CharSequence _compileFileTypeFactory = this.compileFileTypeFactory(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_4, _compileFileTypeFactory);
    String _fileImplName = this._ideaPluginClassNames.getFileImplName(grammar);
    String _javaPath_5 = this._ideaPluginClassNames.toJavaPath(_fileImplName);
    CharSequence _compileFileImpl = this.compileFileImpl(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_5, _compileFileImpl);
    String _lexerName_1 = this._ideaPluginClassNames.getLexerName(grammar);
    String _javaPath_6 = this._ideaPluginClassNames.toJavaPath(_lexerName_1);
    CharSequence _compileLexer = this.compileLexer(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_6, _compileLexer);
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
    String _syntaxHighlighterName_1 = this._ideaPluginClassNames.getSyntaxHighlighterName(grammar);
    String _javaPath_10 = this._ideaPluginClassNames.toJavaPath(_syntaxHighlighterName_1);
    CharSequence _compileSyntaxHighlighter = this.compileSyntaxHighlighter(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_10, _compileSyntaxHighlighter);
    String _syntaxHighlighterFactoryName = this._ideaPluginClassNames.getSyntaxHighlighterFactoryName(grammar);
    String _javaPath_11 = this._ideaPluginClassNames.toJavaPath(_syntaxHighlighterFactoryName);
    CharSequence _compileSyntaxHighlighterFactory = this.compileSyntaxHighlighterFactory(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_11, _compileSyntaxHighlighterFactory);
    String _abstractIdeaModuleName = this._ideaPluginClassNames.getAbstractIdeaModuleName(grammar);
    String _javaPath_12 = this._ideaPluginClassNames.toJavaPath(_abstractIdeaModuleName);
    CharSequence _compileGuiceModuleIdeaGenerated = this.compileGuiceModuleIdeaGenerated(grammar, bindings);
    ctx.writeFile(outlet_src_gen, _javaPath_12, _compileGuiceModuleIdeaGenerated);
    String _extensionFactoryName = this._ideaPluginClassNames.getExtensionFactoryName(grammar);
    String _javaPath_13 = this._ideaPluginClassNames.toJavaPath(_extensionFactoryName);
    CharSequence _compileExtensionFactory = this.compileExtensionFactory(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_13, _compileExtensionFactory);
    String _buildProcessParametersProviderName = this._ideaPluginClassNames.buildProcessParametersProviderName(grammar);
    String _javaPath_14 = this._ideaPluginClassNames.toJavaPath(_buildProcessParametersProviderName);
    CharSequence _compileBuildProcessParametersProvider = this.compileBuildProcessParametersProvider(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_14, _compileBuildProcessParametersProvider);
    String _codeBlockModificationListenerName = this._ideaPluginClassNames.getCodeBlockModificationListenerName(grammar);
    String _javaPath_15 = this._ideaPluginClassNames.toJavaPath(_codeBlockModificationListenerName);
    CharSequence _compileCodeBlockModificationListener = this.compileCodeBlockModificationListener(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_15, _compileCodeBlockModificationListener);
    String _elementDescriptionProviderName = this._ideaPluginClassNames.getElementDescriptionProviderName(grammar);
    String _javaPath_16 = this._ideaPluginClassNames.toJavaPath(_elementDescriptionProviderName);
    CharSequence _compileElementDescriptionProvider = this.compileElementDescriptionProvider(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_16, _compileElementDescriptionProvider);
    String _psiParserName_1 = this._ideaPluginClassNames.getPsiParserName(grammar);
    String _javaPath_17 = this._ideaPluginClassNames.toJavaPath(_psiParserName_1);
    CharSequence _compilePsiParser = this.compilePsiParser(grammar);
    ctx.writeFile(outlet_src_gen, _javaPath_17, _compilePsiParser);
    if (this.typesIntegrationRequired) {
      String _jvmTypesElementFinderName = this._ideaPluginClassNames.getJvmTypesElementFinderName(grammar);
      String _javaPath_18 = this._ideaPluginClassNames.toJavaPath(_jvmTypesElementFinderName);
      CharSequence _compileJvmTypesElementFinder = this.compileJvmTypesElementFinder(grammar);
      ctx.writeFile(outlet_src_gen, _javaPath_18, _compileJvmTypesElementFinder);
      String _jvmTypesShortNamesCacheName = this._ideaPluginClassNames.getJvmTypesShortNamesCacheName(grammar);
      String _javaPath_19 = this._ideaPluginClassNames.toJavaPath(_jvmTypesShortNamesCacheName);
      CharSequence _compileJvmTypesShortNamesCache = this.compileJvmTypesShortNamesCache(grammar);
      ctx.writeFile(outlet_src_gen, _javaPath_19, _compileJvmTypesShortNamesCache);
      String _jvmElementsReferencesSearch = this._ideaPluginClassNames.getJvmElementsReferencesSearch(grammar);
      String _javaPath_20 = this._ideaPluginClassNames.toJavaPath(_jvmElementsReferencesSearch);
      CharSequence _compileJvmElementsReferencesSearch = this.compileJvmElementsReferencesSearch(grammar);
      ctx.writeFile(outlet_src_gen, _javaPath_20, _compileJvmElementsReferencesSearch);
    }
    OutputImpl output = new OutputImpl();
    this.addOutlet(output, IdeaPluginGenerator.PLUGIN, this.ideaProjectPath);
    this.addOutlet(output, IdeaPluginGenerator.META_INF_PLUGIN, (this.ideaProjectPath + "/META-INF"));
    if (this.deployable) {
      StringConcatenation _builder = new StringConcatenation();
      String _name = grammar.getName();
      String _simpleName = this._ideaPluginClassNames.toSimpleName(_name);
      _builder.append(_simpleName, "");
      _builder.append(" Launch Intellij.launch");
      CharSequence _compileLaunchIntellij = this.compileLaunchIntellij(grammar);
      this.writeFile(output, IdeaPluginGenerator.PLUGIN, _builder.toString(), _compileLaunchIntellij);
      CharSequence _compilePluginXml = this.compilePluginXml(grammar);
      this.writeFile(output, IdeaPluginGenerator.META_INF_PLUGIN, "plugin.xml", _compilePluginXml);
    }
    CharSequence _compileProjectXml = this.compileProjectXml(grammar);
    this.writeFile(output, IdeaPluginGenerator.PLUGIN, ".project", _compileProjectXml);
    CharSequence _compileClasspathXml = this.compileClasspathXml(grammar);
    this.writeFile(output, IdeaPluginGenerator.PLUGIN, ".classpath", _compileClasspathXml);
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
  
  public CharSequence compileBuildProcessParametersProvider(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _buildProcessParametersProviderName = this._ideaPluginClassNames.buildProcessParametersProviderName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_buildProcessParametersProviderName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    String _name = Arrays.class.getName();
    _builder.append(_name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _name_1 = List.class.getName();
    _builder.append(_name_1, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.compiler.server.BuildProcessParametersProvider;");
    _builder.newLine();
    _builder.append("import com.intellij.ide.plugins.PluginManager;");
    _builder.newLine();
    _builder.append("import com.intellij.openapi.extensions.PluginId;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _buildProcessParametersProviderName_1 = this._ideaPluginClassNames.buildProcessParametersProviderName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_buildProcessParametersProviderName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends BuildProcessParametersProvider {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<String> getClassPath() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String path = PluginManager.getPlugin(PluginId.getId(\"");
    String _languageID = this._ideaPluginExtension.getLanguageID(grammar);
    _builder.append(_languageID, "\t\t");
    _builder.append("\")).getPath().getPath();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return Arrays.asList(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("path + \"/bin\", ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("path + \"/../");
    _builder.append(this.runtimeProjectPath, "\t\t\t");
    _builder.append("/bin\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append(");");
    _builder.newLine();
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
      if (this.typesIntegrationRequired) {
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
      if (this.typesIntegrationRequired) {
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
  
  public CharSequence compileElementDescriptionProvider(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _elementDescriptionProviderName = this._ideaPluginClassNames.getElementDescriptionProviderName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_elementDescriptionProviderName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _elementDescriptionProviderName_1 = this._ideaPluginClassNames.getElementDescriptionProviderName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_elementDescriptionProviderName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends BaseXtextElementDescriptionProvider {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _elementDescriptionProviderName_2 = this._ideaPluginClassNames.getElementDescriptionProviderName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_elementDescriptionProviderName_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
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
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.antlr.runtime.ANTLRReaderStream;");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.TokenSource;");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.TokenStream;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.parser.AbstractXtextPsiParser;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xbase.lib.Exceptions;");
    _builder.newLine();
    _builder.append("import ");
    String _elementTypeProviderName = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
    _builder.append(_elementTypeProviderName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _psiInternalLexerName = this._ideaPluginClassNames.getPsiInternalLexerName(grammar);
    _builder.append(_psiInternalLexerName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _psiInternalParserName = this._ideaPluginClassNames.getPsiInternalParserName(grammar);
    _builder.append(_psiInternalParserName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.google.inject.Inject;");
    _builder.newLine();
    _builder.append("import com.intellij.lang.PsiBuilder;");
    _builder.newLine();
    _builder.append("import com.intellij.util.text.CharSequenceReader;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _psiParserName_1 = this._ideaPluginClassNames.getPsiParserName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_psiParserName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractXtextPsiParser {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
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
    _builder.append("(builder, tokenStream, getTokenTypeProvider(), elementTypeProvider);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected TokenSource createTokenSource(PsiBuilder builder) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("CharSequence originalText = builder.getOriginalText();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("CharSequenceReader reader = new CharSequenceReader(originalText);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return new ");
    String _psiInternalLexerName_1 = this._ideaPluginClassNames.getPsiInternalLexerName(grammar);
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(_psiInternalLexerName_1);
    _builder.append(_simpleName_3, "\t\t\t");
    _builder.append("(new ANTLRReaderStream(reader));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("} catch (IOException e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw Exceptions.sneakyThrow(e);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileJvmTypesShortNamesCache(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _jvmTypesShortNamesCacheName = this._ideaPluginClassNames.getJvmTypesShortNamesCacheName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_jvmTypesShortNamesCacheName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.openapi.project.Project;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.types.JvmTypesShortNamesCache;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class ");
    String _jvmTypesShortNamesCacheName_1 = this._ideaPluginClassNames.getJvmTypesShortNamesCacheName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_jvmTypesShortNamesCacheName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends JvmTypesShortNamesCache {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _jvmTypesShortNamesCacheName_2 = this._ideaPluginClassNames.getJvmTypesShortNamesCacheName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_jvmTypesShortNamesCacheName_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append("(Project project) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_2, "\t\t");
    _builder.append(".INSTANCE, project);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileJvmElementsReferencesSearch(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _jvmElementsReferencesSearch = this._ideaPluginClassNames.getJvmElementsReferencesSearch(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_jvmElementsReferencesSearch);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.types.psi.search.JvmElementsReferencesSearch;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _jvmElementsReferencesSearch_1 = this._ideaPluginClassNames.getJvmElementsReferencesSearch(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_jvmElementsReferencesSearch_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends JvmElementsReferencesSearch {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _jvmElementsReferencesSearch_2 = this._ideaPluginClassNames.getJvmElementsReferencesSearch(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_jvmElementsReferencesSearch_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
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
  
  public CharSequence compileJvmTypesElementFinder(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _jvmTypesElementFinderName = this._ideaPluginClassNames.getJvmTypesElementFinderName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_jvmTypesElementFinderName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.openapi.project.Project;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.types.psi.JvmTypesElementFinder;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _jvmTypesElementFinderName_1 = this._ideaPluginClassNames.getJvmTypesElementFinderName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_jvmTypesElementFinderName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends JvmTypesElementFinder {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _jvmTypesElementFinderName_2 = this._ideaPluginClassNames.getJvmTypesElementFinderName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_jvmTypesElementFinderName_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append("(Project project) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_2, "\t\t");
    _builder.append(".INSTANCE, project);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public String iml() {
    return (this.ideaProjectPath + ".iml");
  }
  
  public void addOutlet(final Output output, final String outletName, final String path) {
    String _encoding = this.getEncoding();
    Outlet _outlet = new Outlet(false, _encoding, outletName, false, path);
    output.addOutlet(_outlet);
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
  
  public String setFileExtensions(final String fileExtensions) {
    String[] _split = fileExtensions.split("\\s*,\\s*");
    String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_split)));
    return this.fileExtension = _head;
  }
  
  public void setEncoding(final String encoding) {
    this.encoding = encoding;
  }
  
  public CharSequence compileClasspathXml(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<classpath>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"src\" path=\"src\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"src\" path=\"src-gen\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<classpathentry combineaccessrules=\"false\" exported=\"true\" kind=\"src\" path=\"/org.eclipse.xtext.idea\"/>");
    _builder.newLine();
    {
      if (this.typesIntegrationRequired) {
        _builder.append("\t");
        _builder.append("<classpathentry combineaccessrules=\"false\" exported=\"true\" kind=\"src\" path=\"/org.eclipse.xtext.xbase.idea\"/>");
        _builder.newLine();
      }
    }
    {
      boolean _notEquals = (!Objects.equal(this.runtimeProjectName, this.ideaProjectName));
      if (_notEquals) {
        _builder.append("\t");
        _builder.append("<classpathentry combineaccessrules=\"false\" exported=\"true\" kind=\"src\" path=\"/");
        _builder.append(this.runtimeProjectName, "\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"output\" path=\"bin\"/>");
    _builder.newLine();
    _builder.append("</classpath>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileProjectXml(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<projectDescription>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<name>");
    _builder.append(this.ideaProjectName, "\t");
    _builder.append("</name>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<comment></comment>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<projects>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</projects>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<buildSpec>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<buildCommand>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<name>org.eclipse.jdt.core.javabuilder</name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<arguments>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</arguments>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</buildCommand>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</buildSpec>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<natures>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<nature>org.eclipse.jdt.core.javanature</nature>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</natures>");
    _builder.newLine();
    _builder.append("</projectDescription>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compilePluginXml(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<idea-plugin version=\"2\">");
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
    _builder.append("<depends optional=\"true\">org.eclipse.xtext.idea</depends>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<extensions defaultExtensionNs=\"com.intellij\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<buildProcess.parametersProvider implementation=\"");
    String _buildProcessParametersProviderName = this._ideaPluginClassNames.buildProcessParametersProviderName(grammar);
    _builder.append(_buildProcessParametersProviderName, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    {
      if (this.typesIntegrationRequired) {
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<java.elementFinder implementation=\"");
        String _jvmTypesElementFinderName = this._ideaPluginClassNames.getJvmTypesElementFinderName(grammar);
        _builder.append(_jvmTypesElementFinderName, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("<java.shortNamesCache implementation=\"");
        String _jvmTypesShortNamesCacheName = this._ideaPluginClassNames.getJvmTypesShortNamesCacheName(grammar);
        _builder.append(_jvmTypesShortNamesCacheName, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<stubIndex implementation=\"org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex\"/>");
    _builder.newLine();
    {
      if (this.typesIntegrationRequired) {
        _builder.append("\t\t");
        _builder.append("<stubIndex implementation=\"org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex\"/>");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<psi.treeChangePreprocessor implementation=\"");
    String _codeBlockModificationListenerName = this._ideaPluginClassNames.getCodeBlockModificationListenerName(grammar);
    _builder.append(_codeBlockModificationListenerName, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    {
      if (this.typesIntegrationRequired) {
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<referencesSearch implementation=\"");
        String _jvmElementsReferencesSearch = this._ideaPluginClassNames.getJvmElementsReferencesSearch(grammar);
        _builder.append(_jvmElementsReferencesSearch, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        CharSequence _compileExtension = this.compileExtension(grammar, "targetElementEvaluator", "org.eclipse.xtext.idea.jvmmodel.codeInsight.PsiJvmTargetElementEvaluator");
        _builder.append(_compileExtension, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
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
    CharSequence _compileExtension_1 = this.compileExtension(grammar, "lang.ast.factory", "org.eclipse.xtext.idea.lang.BaseXtextASTFactory");
    _builder.append(_compileExtension_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _parserDefinitionName = this._ideaPluginClassNames.getParserDefinitionName(grammar);
    CharSequence _compileExtension_2 = this.compileExtension(grammar, "lang.parserDefinition", _parserDefinitionName);
    _builder.append(_compileExtension_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _compileExtension_3 = this.compileExtension(grammar, "lang.findUsagesProvider", "org.eclipse.xtext.idea.findusages.BaseXtextFindUsageProvider");
    _builder.append(_compileExtension_3, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    CharSequence _compileExtension_4 = this.compileExtension(grammar, "lang.refactoringSupport", "org.eclipse.xtext.idea.refactoring.BaseXtextRefactoringSupportProvider");
    _builder.append(_compileExtension_4, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("      \t");
    _builder.append("<lang.syntaxHighlighterFactory key=\"");
    String _languageID = this._ideaPluginExtension.getLanguageID(grammar);
    _builder.append(_languageID, "      \t");
    _builder.append("\" implementationClass=\"");
    String _syntaxHighlighterFactoryName = this._ideaPluginClassNames.getSyntaxHighlighterFactoryName(grammar);
    _builder.append(_syntaxHighlighterFactoryName, "      \t");
    _builder.append("\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("      \t");
    CharSequence _compileExtension_5 = this.compileExtension(grammar, "annotator", "org.eclipse.xtext.idea.annotation.IssueAnnotator");
    _builder.append(_compileExtension_5, "      \t");
    _builder.newLineIfNotEmpty();
    _builder.append("      \t");
    _builder.append("<elementDescriptionProvider implementation=\"");
    String _elementDescriptionProviderName = this._ideaPluginClassNames.getElementDescriptionProviderName(grammar);
    _builder.append(_elementDescriptionProviderName, "      \t");
    _builder.append("\" order=\"first\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</extensions>");
    _builder.newLine();
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
  
  public CharSequence compileLaunchIntellij(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<launchConfiguration type=\"org.eclipse.jdt.launching.localJavaApplication\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<stringAttribute key=\"bad_container_name\" value=\"/");
    _builder.append(this.ideaProjectName, "\t");
    _builder.append("/");
    String _name = grammar.getName();
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_name);
    String _lowerCase = _simpleName.toLowerCase();
    _builder.append(_lowerCase, "\t");
    _builder.append("_launch_intellij.launch\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_PATHS\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<listEntry value=\"/");
    _builder.append(this.ideaProjectName, "\t\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</listAttribute>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_TYPES\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<listEntry value=\"4\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</listAttribute>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<booleanAttribute key=\"org.eclipse.jdt.launching.ATTR_USE_START_ON_FIRST_THREAD\" value=\"false\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.JRE_CONTAINER\" value=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.launching.macosx.MacOSXType/Java SE 6 [1.6.0_65-b14-462]\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.MAIN_TYPE\" value=\"com.intellij.idea.Main\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.PROJECT_ATTR\" value=\"");
    _builder.append(this.ideaProjectName, "\t");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<stringAttribute key=\"org.eclipse.jdt.launching.VM_ARGUMENTS\" value=\"-Xmx2g -XX:MaxPermSize=320m -Didea.plugins.path=${INTELLIJ_IDEA_PLUGINS} -Didea.home.path=${INTELLIJ_IDEA} -Didea.ProcessCanceledException=disabled -Dcompiler.process.debug.port=-1\"/>");
    _builder.newLine();
    _builder.append("</launchConfiguration>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compilePsiElement(final Grammar grammar, final AbstractRule rule) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _psiPackageName = this._ideaPluginClassNames.getPsiPackageName(grammar);
    _builder.append(_psiPackageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasMultipleAssigment = this._ideaPluginExtension.hasMultipleAssigment(rule);
      if (_hasMultipleAssigment) {
        _builder.newLine();
        _builder.append("import java.util.List;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("import com.intellij.psi.");
    String _psiElementSuperClassName = this._ideaPluginExtension.getPsiElementSuperClassName(rule);
    _builder.append(_psiElementSuperClassName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _psiElementClassName = this._ideaPluginExtension.getPsiElementClassName(rule);
    _builder.append(_psiElementClassName, "");
    _builder.append(" extends ");
    String _psiElementSuperClassName_1 = this._ideaPluginExtension.getPsiElementSuperClassName(rule);
    _builder.append(_psiElementSuperClassName_1, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      List<Assignment> _assignmentsWithoutName = this._ideaPluginExtension.getAssignmentsWithoutName(rule);
      for(final Assignment assignment : _assignmentsWithoutName) {
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        String _typeName = this._ideaPluginExtension.getTypeName(assignment);
        _builder.append(_typeName, "\t");
        _builder.append(" ");
        String _getter = this._ideaPluginExtension.getGetter(assignment);
        _builder.append(_getter, "\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("void ");
        String _setter = this._ideaPluginExtension.getSetter(assignment);
        _builder.append(_setter, "\t");
        _builder.append("(");
        String _typeName_1 = this._ideaPluginExtension.getTypeName(assignment);
        _builder.append(_typeName_1, "\t");
        _builder.append(" ");
        String _feature = assignment.getFeature();
        _builder.append(_feature, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
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
    _builder.append("public void createFileTypes(@NotNull FileTypeConsumer consumer) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("consumer.consume(");
    String _fileTypeName = this._ideaPluginClassNames.getFileTypeName(grammar);
    _builder.append(_fileTypeName, "\t\t");
    _builder.append(".INSTANCE, ");
    String _fileTypeName_1 = this._ideaPluginClassNames.getFileTypeName(grammar);
    _builder.append(_fileTypeName_1, "\t\t");
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
  
  public CharSequence compileFileType(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _fileTypeName = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_fileTypeName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.swing.Icon;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.intellij.openapi.fileTypes.LanguageFileType;");
    _builder.newLine();
    _builder.append("import org.jetbrains.annotations.NonNls;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public final class ");
    String _fileTypeName_1 = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_fileTypeName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends LanguageFileType {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final ");
    String _fileTypeName_2 = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_fileTypeName_2);
    _builder.append(_simpleName_1, "\t");
    _builder.append(" INSTANCE = new ");
    String _fileTypeName_3 = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_fileTypeName_3);
    _builder.append(_simpleName_2, "\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
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
    _builder.append("private ");
    String _fileTypeName_4 = this._ideaPluginClassNames.getFileTypeName(grammar);
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(_fileTypeName_4);
    _builder.append(_simpleName_3, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_4 = this._ideaPluginClassNames.toSimpleName(_languageName);
    _builder.append(_simpleName_4, "\t\t");
    _builder.append(".INSTANCE);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
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
    _builder.append("public String getDescription() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"");
    String _simpleName_5 = this._ideaPluginExtension.getSimpleName(grammar);
    _builder.append(_simpleName_5, "\t\t");
    _builder.append(" files\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Icon getIcon() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"");
    String _simpleName_6 = this._ideaPluginExtension.getSimpleName(grammar);
    _builder.append(_simpleName_6, "\t\t");
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
    _builder.append("import com.google.inject.Injector;");
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
    _builder.append("private Injector injector;");
    _builder.newLine();
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
    _builder.append("\t\t");
    _builder.append("this.injector = new ");
    String _standaloneSetupIdea = this._ideaPluginClassNames.getStandaloneSetupIdea(grammar);
    _builder.append(_standaloneSetupIdea, "\t\t");
    _builder.append("().createInjectorAndDoEMFRegistration();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected Injector getInjector() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return injector;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
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
    _builder.append("import org.eclipse.xtext.psi.PsiNamedEObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.psi.stubs.PsiNamedEObjectType;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.psi.stubs.XtextFileElementType;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.psi.stubs.XtextFileStub;");
    _builder.newLine();
    _builder.append("import ");
    String _fileImplName = this._ideaPluginClassNames.getFileImplName(grammar);
    _builder.append(_fileImplName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.psi.stubs.IStubElementType;");
    _builder.newLine();
    _builder.append("import com.intellij.psi.tree.IElementType;");
    _builder.newLine();
    _builder.append("import com.intellij.psi.tree.IFileElementType;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;");
    _builder.newLine();
    _builder.append("import ");
    String _grammarAccessName = this._ideaPluginClassNames.getGrammarAccessName(grammar);
    _builder.append(_grammarAccessName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
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
    _builder.append("public static final IElementType NAME_TYPE = new IElementType(\"NAME\", ");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_3, "\t");
    _builder.append(".INSTANCE);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final IElementType EOBJECT_TYPE = new IElementType(\"EOBJECT_TYPE\", ");
    String _languageName_2 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_4 = this._ideaPluginClassNames.toSimpleName(_languageName_2);
    _builder.append(_simpleName_4, "\t");
    _builder.append(".INSTANCE);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final IStubElementType<PsiNamedEObjectStub, PsiNamedEObject> NAMED_EOBJECT_TYPE = new PsiNamedEObjectType(\"NAMED_EOBJECT\", ");
    String _languageName_3 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_5 = this._ideaPluginClassNames.toSimpleName(_languageName_3);
    _builder.append(_simpleName_5, "\t");
    _builder.append(".INSTANCE);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final IElementType CROSS_REFERENCE_TYPE = new IElementType(\"CROSS_REFERENCE\", ");
    String _languageName_4 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_6 = this._ideaPluginClassNames.toSimpleName(_languageName_4);
    _builder.append(_simpleName_6, "\t");
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
    String _simpleName_7 = this._ideaPluginClassNames.toSimpleName(_grammarAccessName_1);
    _builder.append(_simpleName_7, "\t");
    _builder.append(" GRAMMAR_ACCESS = ");
    String _languageName_5 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_8 = this._ideaPluginClassNames.toSimpleName(_languageName_5);
    _builder.append(_simpleName_8, "\t");
    _builder.append(".INSTANCE.getInstance(");
    String _grammarAccessName_2 = this._ideaPluginClassNames.getGrammarAccessName(grammar);
    String _simpleName_9 = this._ideaPluginClassNames.toSimpleName(_grammarAccessName_2);
    _builder.append(_simpleName_9, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    {
      List<AbstractRule> _allRules = this._ideaPluginExtension.getAllRules(grammar);
      for(final AbstractRule rule : _allRules) {
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
        String _languageName_6 = this._ideaPluginClassNames.getLanguageName(grammar);
        String _simpleName_10 = this._ideaPluginClassNames.toSimpleName(_languageName_6);
        _builder.append(_simpleName_10, "\t\t\t");
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
            String _languageName_7 = this._ideaPluginClassNames.getLanguageName(grammar);
            String _simpleName_11 = this._ideaPluginClassNames.toSimpleName(_languageName_7);
            _builder.append(_simpleName_11, "\t\t\t");
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
    _builder.append("public IElementType getObjectType() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return EOBJECT_TYPE;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IElementType getCrossReferenceType() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return CROSS_REFERENCE_TYPE;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IElementType getNameType() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return NAME_TYPE;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IStubElementType<PsiNamedEObjectStub, PsiNamedEObject> getNamedObjectType() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return NAMED_EOBJECT_TYPE;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    {
      List<AbstractRule> _allRules_1 = this._ideaPluginExtension.getAllRules(grammar);
      for(final AbstractRule rule_1 : _allRules_1) {
        _builder.append("\t");
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
            _builder.append("\t");
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
    _builder.append("\t");
    _builder.append("public IGrammarAwareElementType findElementType(EObject grammarElement) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return GRAMMAR_ELEMENT_TYPE.get(grammarElement);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
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
    _builder.append("private static final IElementType[] tokenTypes = new IElementType[tokenNames.length];");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (int i = 0; i < tokenNames.length; i++) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("tokenTypes[i] = new IndexedElementType(tokenNames[i], i, ");
    String _languageName_1 = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_languageName_1);
    _builder.append(_simpleName_1, "\t\t\t");
    _builder.append(".INSTANCE);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final TokenSet WHITESPACE_TOKENS = TokenSet.create(tokenTypes[RULE_WS]);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final TokenSet COMMENT_TOKENS = TokenSet.create(tokenTypes[RULE_SL_COMMENT], tokenTypes[RULE_ML_COMMENT]);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final TokenSet STRING_TOKENS = TokenSet.create(tokenTypes[RULE_STRING]);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public int getAntlrType(IElementType iElementType) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return ((IndexedElementType)iElementType).getLocalIndex();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
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
  
  public CharSequence compileLexer(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _lexerName = this._ideaPluginClassNames.getLexerName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_lexerName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.antlr.runtime.ANTLRStringStream;");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.Lexer;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.parser.AbstractAntlrDelegatingIdeaLexer;");
    _builder.newLine();
    _builder.append("import ");
    String _antlrLexerName = this._ideaPluginClassNames.getAntlrLexerName(grammar);
    _builder.append(_antlrLexerName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _lexerName_1 = this._ideaPluginClassNames.getLexerName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_lexerName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractAntlrDelegatingIdeaLexer {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Lexer createAntlrLexer(String text) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new ");
    String _antlrLexerName_1 = this._ideaPluginClassNames.getAntlrLexerName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_antlrLexerName_1);
    _builder.append(_simpleName_1, "\t\t");
    _builder.append("(new ANTLRStringStream(text));");
    _builder.newLineIfNotEmpty();
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
    _builder.newLine();
    _builder.append("public class ");
    String _syntaxHighlighterFactoryName_1 = this._ideaPluginClassNames.getSyntaxHighlighterFactoryName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_syntaxHighlighterFactoryName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends SingleLazyInstanceSyntaxHighlighterFactory {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@NotNull");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("protected SyntaxHighlighter createHighlighter() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_languageName);
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
  
  public CharSequence compileSyntaxHighlighter(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _syntaxHighlighterName = this._ideaPluginClassNames.getSyntaxHighlighterName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_syntaxHighlighterName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.parser.TokenTypeProvider;");
    _builder.newLine();
    _builder.append("import org.jetbrains.annotations.NotNull;");
    _builder.newLine();
    _builder.append("import ");
    String _antlrLexerName = this._ideaPluginClassNames.getAntlrLexerName(grammar);
    _builder.append(_antlrLexerName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.google.inject.Inject;");
    _builder.newLine();
    _builder.append("import com.google.inject.Provider;");
    _builder.newLine();
    _builder.append("import com.intellij.lexer.Lexer;");
    _builder.newLine();
    _builder.append("import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;");
    _builder.newLine();
    _builder.append("import com.intellij.openapi.editor.colors.TextAttributesKey;");
    _builder.newLine();
    _builder.append("import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;");
    _builder.newLine();
    _builder.append("import com.intellij.psi.tree.IElementType;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _syntaxHighlighterName_1 = this._ideaPluginClassNames.getSyntaxHighlighterName(grammar);
    String _simpleName = this._ideaPluginClassNames.toSimpleName(_syntaxHighlighterName_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends SyntaxHighlighterBase {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject TokenTypeProvider tokenTypeProvider;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject Provider<Lexer> lexerProvider; ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@NotNull");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public Lexer getHighlightingLexer() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return lexerProvider.get();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("@NotNull");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (tokenTypeProvider.getStringLiteralTokens().contains(tokenType)) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return pack(DefaultLanguageHighlighterColors.STRING);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (tokenTypeProvider.getIElementType(");
    String _antlrLexerName_1 = this._ideaPluginClassNames.getAntlrLexerName(grammar);
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(_antlrLexerName_1);
    _builder.append(_simpleName_1, "\t\t");
    _builder.append(".RULE_SL_COMMENT) == tokenType) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("return pack(DefaultLanguageHighlighterColors.LINE_COMMENT);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (tokenTypeProvider.getIElementType(");
    String _antlrLexerName_2 = this._ideaPluginClassNames.getAntlrLexerName(grammar);
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(_antlrLexerName_2);
    _builder.append(_simpleName_2, "\t\t");
    _builder.append(".RULE_ML_COMMENT) == tokenType) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("return pack(DefaultLanguageHighlighterColors.BLOCK_COMMENT);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("String myDebugName = tokenType.toString();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (myDebugName.matches(\"^\'.*\\\\w.*\'$\")) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return pack(DefaultLanguageHighlighterColors.KEYWORD);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return new TextAttributesKey[0];");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileParserDefinition(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _parserDefinitionName = this._ideaPluginClassNames.getParserDefinitionName(grammar);
    String _packageName = this._ideaPluginClassNames.toPackageName(_parserDefinitionName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      TreeIterator<EObject> _eAllContents = grammar.eAllContents();
      Iterator<CrossReference> _filter = Iterators.<CrossReference>filter(_eAllContents, CrossReference.class);
      final Function1<CrossReference, Boolean> _function = new Function1<CrossReference, Boolean>() {
        public Boolean apply(final CrossReference it) {
          return Boolean.valueOf(GrammarUtil.isAssigned(it));
        }
      };
      Iterator<CrossReference> _filter_1 = IteratorExtensions.<CrossReference>filter(_filter, _function);
      boolean _isEmpty = IteratorExtensions.isEmpty(_filter_1);
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("import org.eclipse.xtext.psi.impl.PsiEObjectReference;");
        _builder.newLine();
      }
    }
    _builder.append("import ");
    String _elementTypeProviderName = this._ideaPluginClassNames.getElementTypeProviderName(grammar);
    _builder.append(_elementTypeProviderName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
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
      TreeIterator<EObject> _eAllContents_1 = grammar.eAllContents();
      Iterator<RuleCall> _filter_2 = Iterators.<RuleCall>filter(_eAllContents_1, RuleCall.class);
      final Function1<RuleCall, Boolean> _function_1 = new Function1<RuleCall, Boolean>() {
        public Boolean apply(final RuleCall it) {
          boolean _and = false;
          boolean _isAssigned = GrammarUtil.isAssigned(it);
          if (!_isAssigned) {
            _and = false;
          } else {
            Assignment _containingAssignment = GrammarUtil.containingAssignment(it);
            String _feature = _containingAssignment.getFeature();
            boolean _equals = Objects.equal(_feature, "name");
            _and = _equals;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterator<RuleCall> _filter_3 = IteratorExtensions.<RuleCall>filter(_filter_2, _function_1);
      final Function1<RuleCall, Boolean> _function_2 = new Function1<RuleCall, Boolean>() {
        public Boolean apply(final RuleCall nameRuleCall) {
          TreeIterator<EObject> _eAllContents = grammar.eAllContents();
          Iterator<RuleCall> _filter = Iterators.<RuleCall>filter(_eAllContents, RuleCall.class);
          final Function1<RuleCall, Boolean> _function = new Function1<RuleCall, Boolean>() {
            public Boolean apply(final RuleCall it) {
              AbstractRule _rule = it.getRule();
              TreeIterator<EObject> _eAllContents = _rule.eAllContents();
              final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
                public Boolean apply(final EObject it) {
                  return Boolean.valueOf(Objects.equal(it, nameRuleCall));
                }
              };
              return Boolean.valueOf(IteratorExtensions.<EObject>exists(_eAllContents, _function));
            }
          };
          Iterator<RuleCall> _filter_1 = IteratorExtensions.<RuleCall>filter(_filter, _function);
          boolean _isEmpty = IteratorExtensions.isEmpty(_filter_1);
          return Boolean.valueOf((!_isEmpty));
        }
      };
      boolean _exists = IteratorExtensions.<RuleCall>exists(_filter_3, _function_2);
      if (_exists) {
        _builder.append("import org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl;");
        _builder.newLine();
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
    _builder.append("\t\t");
    _builder.append("IElementType elementType = node.getElementType();");
    _builder.newLine();
    {
      TreeIterator<EObject> _eAllContents_2 = grammar.eAllContents();
      Iterator<RuleCall> _filter_4 = Iterators.<RuleCall>filter(_eAllContents_2, RuleCall.class);
      final Function1<RuleCall, Boolean> _function_3 = new Function1<RuleCall, Boolean>() {
        public Boolean apply(final RuleCall it) {
          boolean _and = false;
          boolean _isAssigned = GrammarUtil.isAssigned(it);
          if (!_isAssigned) {
            _and = false;
          } else {
            Assignment _containingAssignment = GrammarUtil.containingAssignment(it);
            String _feature = _containingAssignment.getFeature();
            boolean _equals = Objects.equal(_feature, "name");
            _and = _equals;
          }
          return Boolean.valueOf(_and);
        }
      };
      Iterator<RuleCall> _filter_5 = IteratorExtensions.<RuleCall>filter(_filter_4, _function_3);
      Iterable<RuleCall> _iterable = IteratorExtensions.<RuleCall>toIterable(_filter_5);
      for(final RuleCall nameRuleCall : _iterable) {
        {
          TreeIterator<EObject> _eAllContents_3 = grammar.eAllContents();
          Iterator<RuleCall> _filter_6 = Iterators.<RuleCall>filter(_eAllContents_3, RuleCall.class);
          final Function1<RuleCall, Boolean> _function_4 = new Function1<RuleCall, Boolean>() {
            public Boolean apply(final RuleCall it) {
              AbstractRule _rule = it.getRule();
              TreeIterator<EObject> _eAllContents = _rule.eAllContents();
              final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
                public Boolean apply(final EObject it) {
                  return Boolean.valueOf(Objects.equal(it, nameRuleCall));
                }
              };
              return Boolean.valueOf(IteratorExtensions.<EObject>exists(_eAllContents, _function));
            }
          };
          Iterator<RuleCall> _filter_7 = IteratorExtensions.<RuleCall>filter(_filter_6, _function_4);
          Iterable<RuleCall> _iterable_1 = IteratorExtensions.<RuleCall>toIterable(_filter_7);
          for(final RuleCall ruleCall : _iterable_1) {
            _builder.append("\t\t");
            _builder.append("if (elementType == elementTypeProvider.get");
            String _grammarElementIdentifier = this._grammarAccessExtensions.grammarElementIdentifier(ruleCall);
            _builder.append(_grammarElementIdentifier, "\t\t");
            _builder.append("ElementType()) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            _builder.append("return new PsiNamedEObjectImpl(node, elementTypeProvider.get");
            String _grammarElementIdentifier_1 = this._grammarAccessExtensions.grammarElementIdentifier(nameRuleCall);
            _builder.append(_grammarElementIdentifier_1, "\t\t\t");
            _builder.append("ElementType());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    {
      TreeIterator<EObject> _eAllContents_4 = grammar.eAllContents();
      Iterator<CrossReference> _filter_8 = Iterators.<CrossReference>filter(_eAllContents_4, CrossReference.class);
      final Function1<CrossReference, Boolean> _function_5 = new Function1<CrossReference, Boolean>() {
        public Boolean apply(final CrossReference it) {
          return Boolean.valueOf(GrammarUtil.isAssigned(it));
        }
      };
      Iterator<CrossReference> _filter_9 = IteratorExtensions.<CrossReference>filter(_filter_8, _function_5);
      Iterable<CrossReference> _iterable_2 = IteratorExtensions.<CrossReference>toIterable(_filter_9);
      for(final CrossReference crossReference : _iterable_2) {
        _builder.append("\t\t");
        _builder.append("if (elementType == elementTypeProvider.get");
        String _grammarElementIdentifier_2 = this._grammarAccessExtensions.grammarElementIdentifier(crossReference);
        _builder.append(_grammarElementIdentifier_2, "\t\t");
        _builder.append("ElementType()) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("return new PsiEObjectReference(node);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("return super.createElement(node);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
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
  public boolean isTypesIntegrationRequired() {
    return this.typesIntegrationRequired;
  }
  
  public void setTypesIntegrationRequired(final boolean typesIntegrationRequired) {
    this.typesIntegrationRequired = typesIntegrationRequired;
  }
}

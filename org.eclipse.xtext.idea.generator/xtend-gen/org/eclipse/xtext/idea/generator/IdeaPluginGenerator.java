/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
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
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
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
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.LanguageConfig;
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
    this.fileExtension = IterableExtensions.<String>head(config.getFileExtensions(config.getGrammar()));
    Guice.createInjector(this.createModule(config.getGrammar())).injectMembers(this);
    Grammar _grammar = config.getGrammar();
    Xtend2ExecutionContext _xtend2ExecutionContext = new Xtend2ExecutionContext(ctx);
    this.generate(_grammar, _xtend2ExecutionContext);
  }
  
  @Override
  public void generate(final Grammar grammar, final Xtend2ExecutionContext ctx) {
    this._xtextIDEAGeneratorExtensions.installOutlets(ctx, this.ideaProjectPath, this.encoding, this.getNaming().getLineDelimiter());
    String outlet_src_gen = this._xtextIDEAGeneratorExtensions.getSrcGenOutlet(ctx).getName();
    String _xifexpression = null;
    if (this.srcGenOnly) {
      _xifexpression = outlet_src_gen;
    } else {
      _xifexpression = this._xtextIDEAGeneratorExtensions.getSrcOutlet(ctx).getName();
    }
    String outlet_src = _xifexpression;
    final BindFactory bindFactory = new BindFactory();
    bindFactory.addTypeToType("org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider", this._ideaPluginClassNames.getAntlrTokenFileProvider(grammar));
    bindFactory.addTypeToType("org.eclipse.xtext.parser.antlr.Lexer", this._ideaPluginClassNames.getPsiInternalLexerName(grammar));
    String _psiInternalLexerName = this._ideaPluginClassNames.getPsiInternalLexerName(grammar);
    String _plus = (((("binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class)" + 
      ".annotatedWith(com.google.inject.name.Names.named(") + 
      "org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME") + 
      ")).to(") + _psiInternalLexerName);
    String _plus_1 = (_plus + ".class)");
    bindFactory.addConfiguredBinding("RuntimeLexer", _plus_1);
    bindFactory.addTypeToType("com.intellij.lang.PsiParser", this._ideaPluginClassNames.getPsiParserName(grammar));
    bindFactory.addTypeToType("org.eclipse.xtext.idea.parser.TokenTypeProvider", this._ideaPluginClassNames.getTokenTypeProviderName(grammar));
    bindFactory.addTypeToType("com.intellij.lang.ParserDefinition", this._ideaPluginClassNames.getParserDefinitionName(grammar));
    bindFactory.addTypeToTypeSingleton("org.eclipse.xtext.idea.lang.IElementTypeProvider", this._ideaPluginClassNames.getElementTypeProviderName(grammar));
    bindFactory.addTypeToType("org.eclipse.xtext.idea.facet.AbstractFacetConfiguration", this._ideaPluginClassNames.getFacetConfiguration(grammar));
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
    ctx.writeFile(outlet_src, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getStandaloneSetupIdea(grammar)), this.compileStandaloneSetup(grammar));
    ctx.writeFile(outlet_src, this._ideaPluginClassNames.toXtendPath(this._ideaPluginClassNames.getIdeaSetup(grammar)), this.compileIdeaSetup(grammar));
    ctx.writeFile(outlet_src, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getIdeaModuleName(grammar)), this.compileIdeaModule(grammar));
    ctx.writeFile(outlet_src, this._ideaPluginClassNames.toXtendPath(this._ideaPluginClassNames.getCompletionContributor(grammar)), this.compileCompletionContributor(grammar));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("META-INF/services/");
    String _name = ISetup.class.getName();
    _builder.append(_name);
    ctx.writeFile(outlet_src_gen, _builder.toString(), this.compileServicesISetup(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getAbstractCompletionContributor(grammar)), this.compileAbstractCompletionContributor(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getLanguageName(grammar)), this.compileLanguage(grammar));
    ctx.writeFile(outlet_src, this._ideaPluginClassNames.toXtendPath(this._ideaPluginClassNames.getFileTypeName(grammar)), this.compileFileType(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getAbstractFileTypeName(grammar)), this.compileAbstractFileType(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getFileTypeFactoryName(grammar)), this.compileFileTypeFactory(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getFileImplName(grammar)), this.compileFileImpl(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getTokenTypeProviderName(grammar)), this.compileTokenTypeProvider(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getElementTypeProviderName(grammar)), this.compileElementTypeProvider(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getParserDefinitionName(grammar)), this.compileParserDefinition(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getSyntaxHighlighterFactoryName(grammar)), this.compileSyntaxHighlighterFactory(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getSemanticHighlightVisitorName(grammar)), this.compileSemanticHighlightVisitor(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getAbstractIdeaModuleName(grammar)), this.compileGuiceModuleIdeaGenerated(grammar, bindings));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getExtensionFactoryName(grammar)), this.compileExtensionFactory(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getCodeBlockModificationListenerName(grammar)), this.compileCodeBlockModificationListener(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getPsiParserName(grammar)), this.compilePsiParser(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getAntlrTokenFileProvider(grammar)), this.compileAntlrTokenFileProvider(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getPomDeclarationSearcherName(grammar)), this.compilePomDeclarationSearcher(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getFacetTypeName(grammar)), this.compileFacetType(grammar));
    ctx.writeFile(outlet_src, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.getFacetConfiguration(grammar)), this.compileFacetConfiguration(grammar));
    ctx.writeFile(outlet_src_gen, this._ideaPluginClassNames.toJavaPath(this._ideaPluginClassNames.baseColorSettingsPage(grammar)), this.compileBaseColorSettingsPage(grammar));
    ctx.writeFile(outlet_src, this._ideaPluginClassNames.toXtendPath(this._ideaPluginClassNames.colorSettingsPage(grammar)), this.compileColorSettingsPage(grammar));
    OutputImpl output = new OutputImpl();
    this.addOutlet(output, IdeaPluginGenerator.PLUGIN, false, this.ideaProjectPath);
    this.addOutlet(output, IdeaPluginGenerator.META_INF_PLUGIN, false, (this.ideaProjectPath + "/META-INF"));
    this.addOutlet(output, IdeaPluginGenerator.META_INF_PLUGIN_GEN, true, (this.ideaProjectPath + "/META-INF"));
    if (this.deployable) {
      this.writeFile(output, IdeaPluginGenerator.META_INF_PLUGIN, "plugin.xml", this.compilePluginXml(grammar));
      this.writeFile(output, IdeaPluginGenerator.META_INF_PLUGIN_GEN, "plugin_gen.xml", this.compilePluginGenXml(grammar));
    }
  }
  
  public CharSequence compileGuiceModuleIdeaGenerated(final Grammar grammar, final Set<Binding> bindings) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getAbstractIdeaModuleName(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getAbstractIdeaModuleName(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends org.eclipse.xtext.idea.DefaultIdeaModule {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final Binding it : bindings) {
        {
          if (((!it.getValue().isProvider()) && ((List<String>)Conversions.doWrapArray(it.getValue().getStatements())).isEmpty())) {
            _builder.append("\t");
            _builder.append("// contributed by ");
            String _contributedBy = it.getContributedBy();
            _builder.append(_contributedBy, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            {
              boolean _isSingleton = it.getKey().isSingleton();
              if (_isSingleton) {
                _builder.append("@org.eclipse.xtext.service.SingletonBinding");
                {
                  boolean _isEagerSingleton = it.getKey().isEagerSingleton();
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
              String _expression = it.getValue().getExpression();
              boolean _tripleEquals = (_expression == null);
              if (_tripleEquals) {
                _builder.append("Class<? extends ");
                String _type = it.getKey().getType();
                _builder.append(_type, "\t");
                _builder.append(">");
              } else {
                String _type_1 = it.getKey().getType();
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
              String _expression_1 = it.getValue().getExpression();
              boolean _tripleNotEquals = (_expression_1 != null);
              if (_tripleNotEquals) {
                String _expression_2 = it.getValue().getExpression();
                _builder.append(_expression_2, "\t\t");
              } else {
                String _typeName = it.getValue().getTypeName();
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
            boolean _isEmpty = ((List<String>)Conversions.doWrapArray(it.getValue().getStatements())).isEmpty();
            if (_isEmpty) {
              _builder.append("\t");
              _builder.append("// contributed by ");
              String _contributedBy_1 = it.getContributedBy();
              _builder.append(_contributedBy_1, "\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              {
                boolean _isSingleton_1 = it.getKey().isSingleton();
                if (_isSingleton_1) {
                  _builder.append("@org.eclipse.xtext.service.SingletonBinding");
                  {
                    boolean _isEagerSingleton_1 = it.getKey().isEagerSingleton();
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
                String _expression_3 = it.getValue().getExpression();
                boolean _tripleEquals_1 = (_expression_3 == null);
                if (_tripleEquals_1) {
                  _builder.append("Class<? extends com.google.inject.Provider<");
                  String _type_2 = it.getKey().getType();
                  _builder.append(_type_2, "\t");
                  _builder.append(">>");
                } else {
                  _builder.append("com.google.inject.Provider<");
                  String _type_3 = it.getKey().getType();
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
                String _expression_4 = it.getValue().getExpression();
                boolean _tripleNotEquals_1 = (_expression_4 != null);
                if (_tripleNotEquals_1) {
                  String _expression_5 = it.getValue().getExpression();
                  _builder.append(_expression_5, "\t\t");
                } else {
                  String _typeName_1 = it.getValue().getTypeName();
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
                String[] _statements = it.getValue().getStatements();
                for(final String statement : _statements) {
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append(statement, "\t\t");
                  {
                    boolean _endsWith = statement.endsWith(";");
                    boolean _not = (!_endsWith);
                    if (_not) {
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
    if (((!it.getValue().isProvider()) && ((List<String>)Conversions.doWrapArray(it.getValue().getStatements())).isEmpty())) {
      _xifexpression = "bind";
    } else {
      String _xifexpression_1 = null;
      boolean _isEmpty = ((List<String>)Conversions.doWrapArray(it.getValue().getStatements())).isEmpty();
      if (_isEmpty) {
        _xifexpression_1 = "provide";
      } else {
        _xifexpression_1 = "configure";
      }
      _xifexpression = _xifexpression_1;
    }
    final String prefix = _xifexpression;
    String _xifexpression_2 = null;
    if (((it.getValue().getExpression() != null) && (!it.getValue().isProvider()))) {
      _xifexpression_2 = "ToInstance";
    } else {
      _xifexpression_2 = "";
    }
    final String suffix = _xifexpression_2;
    String _simpleMethodName = this.simpleMethodName(it.getKey().getType());
    String _plus = (prefix + _simpleMethodName);
    return (_plus + suffix);
  }
  
  private String simpleMethodName(final String qn) {
    final Function1<String, Boolean> _function = (String e) -> {
      return Boolean.valueOf(e.matches("[A-Z].*"));
    };
    return IterableExtensions.join(IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(qn.replaceAll("<", "\\.").replaceAll(">", "\\.").split("\\."))), _function), "$");
  }
  
  public CharSequence compileExtensionFactory(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getExtensionFactoryName(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.openapi.extensions.ExtensionFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getExtensionFactoryName(grammar));
    _builder.append(_simpleName);
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
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getCodeBlockModificationListenerName(grammar));
    _builder.append(_packageName);
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
    _builder.append(_languageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getCodeBlockModificationListenerName(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends BaseXtextCodeBlockModificationListener {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getCodeBlockModificationListenerName(grammar));
    _builder.append(_simpleName_1, "\t");
    _builder.append("(PsiModificationTracker psiModificationTracker) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(");
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getPomDeclarationSearcherName(it));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(it);
    _builder.append(_languageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getPomDeclarationSearcherName(it));
    _builder.append(_simpleName);
    _builder.append(" extends AbstractXtextPomDeclarationSearcher {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getPomDeclarationSearcherName(it));
    _builder.append(_simpleName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(");
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(it));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getPsiParserName(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _isEmpty = this._grammarAccessExtensions.initialHiddenTokens(grammar).isEmpty();
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
    _builder.append(_elementTypeProviderName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _psiInternalParserName = this._ideaPluginClassNames.getPsiInternalParserName(grammar);
    _builder.append(_psiInternalParserName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _gaFQName = this._grammarAccess.gaFQName(grammar);
    _builder.append(_gaFQName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.google.inject.Inject;");
    _builder.newLine();
    _builder.append("import com.intellij.lang.PsiBuilder;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getPsiParserName(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends AbstractXtextPsiParser {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      boolean _isEmpty_1 = this._grammarAccessExtensions.initialHiddenTokens(grammar).isEmpty();
      boolean _not = (!_isEmpty_1);
      if (_not) {
        _builder.append("\t");
        _builder.append("private static final Set<String> INITIAL_HIDDEN_TOKENS = new HashSet<String>(Arrays.asList(");
        {
          List<String> _initialHiddenTokens = this._grammarAccessExtensions.initialHiddenTokens(grammar);
          boolean _hasElements = false;
          for(final String hidden : _initialHiddenTokens) {
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
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getElementTypeProviderName(grammar));
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
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getPsiInternalParserName(grammar));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getAntlrTokenFileProvider(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.io.InputStream;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getAntlrTokenFileProvider(grammar));
    _builder.append(_simpleName);
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
    String _lineDelimiter = this.getNaming().getLineDelimiter();
    NewlineNormalizer _newlineNormalizer = new NewlineNormalizer(_lineDelimiter);
    outlet.addPostprocessor(_newlineNormalizer);
    output.addOutlet(outlet);
  }
  
  public void writeFile(final Output output, final String outletName, final String filename, final CharSequence contents) {
    output.openFile(filename, outletName);
    output.write(contents.toString());
    output.closeFile();
  }
  
  public String getEncoding() {
    if ((this.encoding != null)) {
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
    _builder.append("<idea-version since-build=\"145\"/>");
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
      Iterable<GeneratedMetamodel> _filter = Iterables.<GeneratedMetamodel>filter(grammar.getMetamodelDeclarations(), GeneratedMetamodel.class);
      for(final GeneratedMetamodel generatedMetamodel : _filter) {
        _builder.append("\t\t");
        _builder.append("<package uri=\"");
        String _nsURI = generatedMetamodel.getEPackage().getNsURI();
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
        String _firstUpper = StringExtensions.toFirstUpper(generatedMetamodel.getName());
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
    CharSequence _compileExtension_1 = this.compileExtension(grammar, "lang.parserDefinition", this._ideaPluginClassNames.getParserDefinitionName(grammar));
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
    _builder.append(extensionPointId);
    _builder.append(" language=\"");
    String _languageID = this._ideaPluginExtension.getLanguageID(grammar);
    _builder.append(_languageID);
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
    _builder.append(_psiImplPackageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.psi.impl.BaseXtextFile;");
    _builder.newLine();
    _builder.append("import ");
    String _fileTypeName = this._ideaPluginClassNames.getFileTypeName(grammar);
    _builder.append(_fileTypeName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.intellij.openapi.fileTypes.FileType;");
    _builder.newLine();
    _builder.append("import com.intellij.psi.FileViewProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public final class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFileImplName(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends BaseXtextFile {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFileImplName(grammar));
    _builder.append(_simpleName_1, "\t");
    _builder.append("(FileViewProvider viewProvider) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(viewProvider, ");
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFileTypeName(grammar));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getFileTypeFactoryName(grammar));
    _builder.append(_packageName);
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
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFileTypeFactoryName(grammar));
    _builder.append(_simpleName);
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getAbstractFileTypeName(grammar));
    _builder.append(_packageName);
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
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getAbstractFileTypeName(grammar));
    _builder.append(_simpleName);
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
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getAbstractFileTypeName(grammar));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getFileTypeName(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFileTypeName(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getAbstractFileTypeName(grammar));
    _builder.append(_simpleName_1);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final ");
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFileTypeName(grammar));
    _builder.append(_simpleName_2, "\t");
    _builder.append(" INSTANCE = new ");
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFileTypeName(grammar));
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
    String _simpleName_4 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getLanguageName(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public final class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends AbstractXtextLanguage {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
    _builder.append(_simpleName_1, "\t");
    _builder.append(" INSTANCE = new ");
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
    _builder.append(_simpleName_2, "\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ");
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getStandaloneSetupIdea(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.util.Modules2;");
    _builder.newLine();
    _builder.append("import ");
    String _setupImpl = this.getNaming().setupImpl(grammar);
    _builder.append(_setupImpl);
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
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getStandaloneSetupIdea(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends ");
    String _simpleName_1 = this.getNaming().toSimpleName(this.getNaming().setupImpl(grammar));
    _builder.append(_simpleName_1);
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
    String _guiceModuleRt = this.getNaming().guiceModuleRt(grammar);
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getIdeaSetup(grammar));
    _builder.append(_packageName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.ISetup");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getIdeaSetup(grammar));
    _builder.append(_simpleName);
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
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getStandaloneSetupIdea(grammar));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getIdeaModuleName(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getIdeaModuleName(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getAbstractIdeaModuleName(grammar));
    _builder.append(_simpleName_1);
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getElementTypeProviderName(grammar));
    _builder.append(_packageName);
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
    _builder.append(_fileImplName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _grammarAccessName = this._ideaPluginClassNames.getGrammarAccessName(grammar);
    _builder.append(_grammarAccessName);
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
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getElementTypeProviderName(grammar));
    _builder.append(_simpleName);
    _builder.append(" implements IElementTypeProvider {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFileImplName(grammar));
    _builder.append(_simpleName_1, "\t");
    _builder.append(">>(");
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getGrammarAccessName(grammar));
    _builder.append(_simpleName_3, "\t");
    _builder.append(" GRAMMAR_ACCESS = ");
    String _simpleName_4 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
    _builder.append(_simpleName_4, "\t");
    _builder.append(".INSTANCE.getInstance(");
    String _simpleName_5 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getGrammarAccessName(grammar));
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
        String _simpleName_6 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
          Iterable<AbstractElement> _iterable = IteratorExtensions.<AbstractElement>toIterable(Iterators.<AbstractElement>filter(rule.eAllContents(), AbstractElement.class));
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
            String _simpleName_7 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
          Iterable<AbstractElement> _iterable_1 = IteratorExtensions.<AbstractElement>toIterable(Iterators.<AbstractElement>filter(rule.eAllContents(), AbstractElement.class));
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
          Iterable<AbstractElement> _iterable_2 = IteratorExtensions.<AbstractElement>toIterable(Iterators.<AbstractElement>filter(rule_1.eAllContents(), AbstractElement.class));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getTokenTypeProviderName(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import static ");
    String _psiInternalParserName = this._ideaPluginClassNames.getPsiInternalParserName(grammar);
    _builder.append(_psiInternalParserName);
    _builder.append(".*;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.parser.TokenTypeProvider;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _psiInternalParserName_1 = this._ideaPluginClassNames.getPsiInternalParserName(grammar);
    _builder.append(_psiInternalParserName_1);
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
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getTokenTypeProviderName(grammar));
    _builder.append(_simpleName);
    _builder.append(" implements TokenTypeProvider {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final String[] TOKEN_NAMES = new ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getPsiInternalParserName(grammar));
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
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
      final Function1<TerminalRule, Boolean> _function = (TerminalRule it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "WS"));
      };
      boolean _exists = IterableExtensions.<TerminalRule>exists(GrammarUtil.allTerminalRules(grammar), _function);
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
      if ((IterableExtensions.<TerminalRule>exists(GrammarUtil.allTerminalRules(grammar), ((Function1<TerminalRule, Boolean>) (TerminalRule it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "SL_COMMENT"));
      })) && IterableExtensions.<TerminalRule>exists(GrammarUtil.allTerminalRules(grammar), ((Function1<TerminalRule, Boolean>) (TerminalRule it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "ML_COMMENT"));
      })))) {
        _builder.append("\t");
        _builder.append("private static final TokenSet COMMENT_TOKENS = TokenSet.create(tokenTypes[RULE_SL_COMMENT], tokenTypes[RULE_ML_COMMENT]);");
        _builder.newLine();
      } else {
        final Function1<TerminalRule, Boolean> _function_1 = (TerminalRule it) -> {
          String _name = it.getName();
          return Boolean.valueOf(Objects.equal(_name, "SL_COMMENT"));
        };
        boolean _exists_1 = IterableExtensions.<TerminalRule>exists(GrammarUtil.allTerminalRules(grammar), _function_1);
        if (_exists_1) {
          _builder.append("\t");
          _builder.append("private static final TokenSet COMMENT_TOKENS = TokenSet.create(tokenTypes[RULE_SL_COMMENT]);");
          _builder.newLine();
        } else {
          final Function1<TerminalRule, Boolean> _function_2 = (TerminalRule it) -> {
            String _name = it.getName();
            return Boolean.valueOf(Objects.equal(_name, "ML_COMMENT"));
          };
          boolean _exists_2 = IterableExtensions.<TerminalRule>exists(GrammarUtil.allTerminalRules(grammar), _function_2);
          if (_exists_2) {
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
      final Function1<TerminalRule, Boolean> _function_3 = (TerminalRule it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "STRING"));
      };
      boolean _exists_3 = IterableExtensions.<TerminalRule>exists(GrammarUtil.allTerminalRules(grammar), _function_3);
      if (_exists_3) {
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getSyntaxHighlighterFactoryName(grammar));
    _builder.append(_packageName);
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
    _builder.append(_languageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getSyntaxHighlighterFactoryName(grammar));
    _builder.append(_simpleName);
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
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getSemanticHighlightVisitorName(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getSemanticHighlightVisitorName(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends SemanticHighlightVisitor {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getSemanticHighlightVisitorName(grammar));
    _builder.append(_simpleName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
      final Function1<AbstractRule, Boolean> _function = (AbstractRule it) -> {
        return Boolean.valueOf(GrammarUtil.isEObjectRule(it));
      };
      final Iterable<AbstractRule> EObjectRules = IterableExtensions.<AbstractRule>filter(GrammarUtil.allRules(grammar), _function);
      final Function1<AbstractRule, Boolean> _function_1 = (AbstractRule it) -> {
        return Boolean.valueOf((this.isNamed(it) || IterableExtensions.<AbstractElement>exists(this.getEObjectElements(it), ((Function1<AbstractElement, Boolean>) (AbstractElement it_1) -> {
          return Boolean.valueOf(this.isNamed(it_1));
        }))));
      };
      final boolean hasNamed = IterableExtensions.<AbstractRule>exists(EObjectRules, _function_1);
      final Function1<AbstractRule, Boolean> _function_2 = (AbstractRule it) -> {
        return Boolean.valueOf(((!this.isNamed(it)) || IterableExtensions.<AbstractElement>exists(this.getEObjectElements(it), ((Function1<AbstractElement, Boolean>) (AbstractElement it_1) -> {
          boolean _isNamed = this.isNamed(it_1);
          return Boolean.valueOf((!_isNamed));
        }))));
      };
      final boolean hasNotNamed = IterableExtensions.<AbstractRule>exists(EObjectRules, _function_2);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getParserDefinitionName(grammar));
      _builder.append(_packageName);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import ");
      String _fileImplName = this._ideaPluginClassNames.getFileImplName(grammar);
      _builder.append(_fileImplName);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      String _superParserDefinitionName = this._ideaPluginClassNames.getSuperParserDefinitionName(grammar);
      _builder.append(_superParserDefinitionName);
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
          _builder.append(_elementTypeProviderName);
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
      _builder.append(_name);
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
      String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getParserDefinitionName(grammar));
      _builder.append(_simpleName);
      _builder.append(" extends ");
      String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getSuperParserDefinitionName(grammar));
      _builder.append(_simpleName_1);
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
          String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getElementTypeProviderName(grammar));
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
      String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFileImplName(grammar));
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
          _builder.append("if (hasSemanticElement !== null && hasSemanticElement) {");
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
    final Function1<AbstractElement, Boolean> _function = (AbstractElement element) -> {
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
    };
    return IterableExtensions.<AbstractElement>filter(EcoreUtil2.<AbstractElement>eAllOfType(rule, AbstractElement.class), _function);
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
      _xblockexpression = (((feature instanceof EAttribute) && (!feature.isMany())) && String.class.isAssignableFrom(feature.getEType().getInstanceClass()));
    }
    return _xblockexpression;
  }
  
  public CharSequence compileAbstractCompletionContributor(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getCompletionContributor(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;");
    _builder.newLine();
    _builder.append("import ");
    String _completionContributorSuperClass = this._ideaPluginClassNames.getCompletionContributorSuperClass(grammar);
    _builder.append(_completionContributorSuperClass);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getAbstractCompletionContributor(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getCompletionContributorSuperClass(grammar));
    _builder.append(_simpleName_1);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public ");
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getAbstractCompletionContributor(grammar));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getCompletionContributor(grammar));
    _builder.append(_packageName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;");
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getCompletionContributor(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getAbstractCompletionContributor(grammar));
    _builder.append(_simpleName_1);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this(");
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
    _builder.append(_standaloneSetup);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileFacetConfiguration(final Grammar grammar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getFacetConfiguration(grammar));
    _builder.append(_packageName);
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
    _builder.append(_name);
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
    String _simpleName = this._ideaPluginClassNames.toSimpleName(grammar.getName());
    _builder.append(_simpleName, "\t\t\t\t");
    _builder.append("GeneratorConfig.xml\", scheme = StorageScheme.DIRECTORY_BASED)})");
    _builder.newLineIfNotEmpty();
    _builder.append("public class ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFacetConfiguration(grammar));
    _builder.append(_simpleName_1);
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.getFacetTypeName(grammar));
    _builder.append(_packageName);
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
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFacetTypeName(grammar));
    _builder.append(_simpleName);
    _builder.append("  extends AbstractFacetType<");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFacetConfiguration(grammar));
    _builder.append(_simpleName_1);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final FacetTypeId<Facet<");
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFacetConfiguration(grammar));
    _builder.append(_simpleName_2, "\t");
    _builder.append(">> TYPEID = new FacetTypeId<Facet<");
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFacetConfiguration(grammar));
    _builder.append(_simpleName_3, "\t");
    _builder.append(">>(\"");
    String _name = grammar.getName();
    _builder.append(_name, "\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _simpleName_4 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getFacetTypeName(grammar));
    _builder.append(_simpleName_4, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(TYPEID, \"");
    String _name_1 = grammar.getName();
    _builder.append(_name_1, "\t\t");
    _builder.append("\", \"");
    String _simpleName_5 = this._ideaPluginClassNames.toSimpleName(grammar.getName());
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.baseColorSettingsPage(grammar));
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    String _languageName = this._ideaPluginClassNames.getLanguageName(grammar);
    _builder.append(_languageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.baseColorSettingsPage(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends AbstractColorSettingsPage {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.baseColorSettingsPage(grammar));
    _builder.append(_simpleName_1, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _simpleName_2 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
    String _simpleName_3 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.getLanguageName(grammar));
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
    String _packageName = this._ideaPluginClassNames.toPackageName(this._ideaPluginClassNames.colorSettingsPage(grammar));
    _builder.append(_packageName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class ");
    String _simpleName = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.colorSettingsPage(grammar));
    _builder.append(_simpleName);
    _builder.append(" extends ");
    String _simpleName_1 = this._ideaPluginClassNames.toSimpleName(this._ideaPluginClassNames.baseColorSettingsPage(grammar));
    _builder.append(_simpleName_1);
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

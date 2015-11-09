/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2;
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.exporting.QualifiedNamesFragment2;
import org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2;
import org.eclipse.xtext.xtext.generator.generator.GeneratorFragment2;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessFragment2;
import org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator;
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.XtextAntlrIDEAGeneratorFragment;
import org.eclipse.xtext.xtext.generator.junit.Junit4Fragment2;
import org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.resourceFactory.ResourceFactoryFragment2;
import org.eclipse.xtext.xtext.generator.scoping.ImportNamespacesScopingFragment2;
import org.eclipse.xtext.xtext.generator.serializer.SerializerFragment2;
import org.eclipse.xtext.xtext.generator.types.TypesGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.ui.compare.CompareFragment2;
import org.eclipse.xtext.xtext.generator.ui.contentAssist.ContentAssistFragment2;
import org.eclipse.xtext.xtext.generator.ui.labeling.LabelProviderFragment2;
import org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2;
import org.eclipse.xtext.xtext.generator.ui.outline.QuickOutlineFragment2;
import org.eclipse.xtext.xtext.generator.ui.quickfix.QuickfixProviderFragment2;
import org.eclipse.xtext.xtext.generator.ui.refactoring.RefactorElementNameFragment2;
import org.eclipse.xtext.xtext.generator.ui.templates.CodetemplatesGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.util.BooleanGeneratorOption;
import org.eclipse.xtext.xtext.generator.util.GeneratorOption;
import org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2;
import org.eclipse.xtext.xtext.generator.web.WebIntegrationFragment;
import org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.xbase.XtypeGeneratorFragment2;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend
 */
@Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
@Log
@SuppressWarnings("all")
public class StandardLanguage extends XtextGeneratorLanguage {
  private GrammarAccessFragment2 grammarAccess = new GrammarAccessFragment2();
  
  private SerializerFragment2 serializer = new SerializerFragment2();
  
  private ResourceFactoryFragment2 resourceFactoryFragment = new ResourceFactoryFragment2();
  
  private EMFGeneratorFragment2 emfGenerator = new EMFGeneratorFragment2();
  
  private XtextAntlrGeneratorFragment2 parserGenerator = new XtextAntlrGeneratorFragment2();
  
  private ValidatorFragment2 validator = new ValidatorFragment2();
  
  private Formatter2Fragment2 formatter = new Formatter2Fragment2();
  
  private GeneratorFragment2 generator = new GeneratorFragment2();
  
  private BuilderIntegrationFragment2 builder = new BuilderIntegrationFragment2();
  
  private ImportNamespacesScopingFragment2 scopeProvider = new ImportNamespacesScopingFragment2();
  
  private QualifiedNamesFragment2 qualifiedNamesProvider = new QualifiedNamesFragment2();
  
  private Junit4Fragment2 junitSupport = new Junit4Fragment2();
  
  private QuickfixProviderFragment2 quickFixProvider = new QuickfixProviderFragment2();
  
  private LabelProviderFragment2 labelProvider = new LabelProviderFragment2();
  
  private OutlineTreeProviderFragment2 outline = new OutlineTreeProviderFragment2();
  
  private QuickOutlineFragment2 quickOutline = new QuickOutlineFragment2();
  
  private CompareFragment2 compareEditor = new CompareFragment2();
  
  private ContentAssistFragment2 contentAssist = new ContentAssistFragment2();
  
  private RefactorElementNameFragment2 renameRefactoring = new RefactorElementNameFragment2();
  
  private CodetemplatesGeneratorFragment2 codeTemplates = new CodetemplatesGeneratorFragment2();
  
  private XtextAntlrIDEAGeneratorFragment ideaParser = new XtextAntlrIDEAGeneratorFragment();
  
  private TypesGeneratorFragment2 commonTypesSupport = new TypesGeneratorFragment2();
  
  private XtypeGeneratorFragment2 xtypeSupport = new XtypeGeneratorFragment2();
  
  private XbaseGeneratorFragment2 xbaseSupport = new XbaseGeneratorFragment2();
  
  private IdeaPluginGenerator ideaPlugin = new IdeaPluginGenerator();
  
  private WebIntegrationFragment webSupport = new WebIntegrationFragment();
  
  public StandardLanguage() {
    try {
      Class<? extends StandardLanguage> _class = this.getClass();
      ClassLoader _classLoader = _class.getClassLoader();
      _classLoader.loadClass("org.eclipse.xtext.xbase.XbaseRuntimeModule");
      this.addReferencedResource("platform:/resource/org.eclipse.xtext.xbase/model/Xbase.genmodel");
    } catch (final Throwable _t) {
      if (_t instanceof ClassNotFoundException) {
        final ClassNotFoundException e = (ClassNotFoundException)_t;
        StandardLanguage.LOG.info("Skipping registration of Xbase genmodel. Xbase is not on the classpath.");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Override
  public void initialize(final Injector injector) {
    BooleanGeneratorOption _generateStub = this.formatter.getGenerateStub();
    boolean _isSet = _generateStub.isSet();
    boolean _not = (!_isSet);
    if (_not) {
      this.formatter.setGenerateStub(false);
    }
    BooleanGeneratorOption _onlyEnabledIfGrammarIsUsed = this.commonTypesSupport.getOnlyEnabledIfGrammarIsUsed();
    boolean _isSet_1 = _onlyEnabledIfGrammarIsUsed.isSet();
    boolean _not_1 = (!_isSet_1);
    if (_not_1) {
      this.commonTypesSupport.setOnlyEnabledIfGrammarIsUsed(true);
    }
    GeneratorOption<WebIntegrationFragment.Framework> _framework = this.webSupport.getFramework();
    boolean _isSet_2 = _framework.isSet();
    boolean _not_2 = (!_isSet_2);
    if (_not_2) {
      this.webSupport.setFramework("Ace");
    }
    BooleanGeneratorOption _generateServlet = this.webSupport.getGenerateServlet();
    boolean _isSet_3 = _generateServlet.isSet();
    boolean _not_3 = (!_isSet_3);
    if (_not_3) {
      this.webSupport.setGenerateServlet(true);
    }
    BooleanGeneratorOption _generateJettyLauncher = this.webSupport.getGenerateJettyLauncher();
    boolean _isSet_4 = _generateJettyLauncher.isSet();
    boolean _not_4 = (!_isSet_4);
    if (_not_4) {
      this.webSupport.setGenerateJettyLauncher(true);
    }
    BooleanGeneratorOption _generateHtmlExample = this.webSupport.getGenerateHtmlExample();
    boolean _isSet_5 = _generateHtmlExample.isSet();
    boolean _not_5 = (!_isSet_5);
    if (_not_5) {
      this.webSupport.setGenerateHtmlExample(true);
    }
    super.initialize(injector);
  }
  
  @Override
  protected List<? extends IXtextGeneratorFragment> getImplicitFragments() {
    ArrayList<IXtextGeneratorFragment> _xblockexpression = null;
    {
      final ArrayList<IXtextGeneratorFragment> fragments = CollectionLiterals.<IXtextGeneratorFragment>newArrayList();
      List<? extends IXtextGeneratorFragment> _implicitFragments = super.getImplicitFragments();
      Iterables.<IXtextGeneratorFragment>addAll(fragments, _implicitFragments);
      this.operator_add(fragments, this.grammarAccess);
      this.operator_add(fragments, this.emfGenerator);
      this.operator_add(fragments, this.serializer);
      this.operator_add(fragments, this.resourceFactoryFragment);
      this.operator_add(fragments, this.parserGenerator);
      this.operator_add(fragments, this.validator);
      this.operator_add(fragments, this.scopeProvider);
      this.operator_add(fragments, this.qualifiedNamesProvider);
      this.operator_add(fragments, this.builder);
      this.operator_add(fragments, this.generator);
      this.operator_add(fragments, this.formatter);
      this.operator_add(fragments, this.labelProvider);
      this.operator_add(fragments, this.quickOutline);
      this.operator_add(fragments, this.outline);
      this.operator_add(fragments, this.quickFixProvider);
      this.operator_add(fragments, this.contentAssist);
      this.operator_add(fragments, this.junitSupport);
      this.operator_add(fragments, this.renameRefactoring);
      this.operator_add(fragments, this.commonTypesSupport);
      this.operator_add(fragments, this.xbaseSupport);
      this.operator_add(fragments, this.xtypeSupport);
      this.operator_add(fragments, this.codeTemplates);
      this.operator_add(fragments, this.compareEditor);
      this.operator_add(fragments, this.ideaParser);
      this.operator_add(fragments, this.ideaPlugin);
      this.operator_add(fragments, this.webSupport);
      _xblockexpression = fragments;
    }
    return _xblockexpression;
  }
  
  private boolean operator_add(final List<IXtextGeneratorFragment> list, final IXtextGeneratorFragment fragment) {
    boolean _xifexpression = false;
    if ((fragment != null)) {
      _xifexpression = list.add(fragment);
    }
    return _xifexpression;
  }
  
  @Pure
  protected GrammarAccessFragment2 getGrammarAccess() {
    return this.grammarAccess;
  }
  
  public void setGrammarAccess(final GrammarAccessFragment2 grammarAccess) {
    this.grammarAccess = grammarAccess;
  }
  
  @Pure
  protected SerializerFragment2 getSerializer() {
    return this.serializer;
  }
  
  public void setSerializer(final SerializerFragment2 serializer) {
    this.serializer = serializer;
  }
  
  @Pure
  protected ResourceFactoryFragment2 getResourceFactoryFragment() {
    return this.resourceFactoryFragment;
  }
  
  public void setResourceFactoryFragment(final ResourceFactoryFragment2 resourceFactoryFragment) {
    this.resourceFactoryFragment = resourceFactoryFragment;
  }
  
  @Pure
  protected EMFGeneratorFragment2 getEmfGenerator() {
    return this.emfGenerator;
  }
  
  public void setEmfGenerator(final EMFGeneratorFragment2 emfGenerator) {
    this.emfGenerator = emfGenerator;
  }
  
  @Pure
  protected XtextAntlrGeneratorFragment2 getParserGenerator() {
    return this.parserGenerator;
  }
  
  public void setParserGenerator(final XtextAntlrGeneratorFragment2 parserGenerator) {
    this.parserGenerator = parserGenerator;
  }
  
  @Pure
  protected ValidatorFragment2 getValidator() {
    return this.validator;
  }
  
  public void setValidator(final ValidatorFragment2 validator) {
    this.validator = validator;
  }
  
  @Pure
  protected Formatter2Fragment2 getFormatter() {
    return this.formatter;
  }
  
  public void setFormatter(final Formatter2Fragment2 formatter) {
    this.formatter = formatter;
  }
  
  @Pure
  protected GeneratorFragment2 getGenerator() {
    return this.generator;
  }
  
  public void setGenerator(final GeneratorFragment2 generator) {
    this.generator = generator;
  }
  
  @Pure
  protected BuilderIntegrationFragment2 getBuilder() {
    return this.builder;
  }
  
  public void setBuilder(final BuilderIntegrationFragment2 builder) {
    this.builder = builder;
  }
  
  @Pure
  protected ImportNamespacesScopingFragment2 getScopeProvider() {
    return this.scopeProvider;
  }
  
  public void setScopeProvider(final ImportNamespacesScopingFragment2 scopeProvider) {
    this.scopeProvider = scopeProvider;
  }
  
  @Pure
  protected QualifiedNamesFragment2 getQualifiedNamesProvider() {
    return this.qualifiedNamesProvider;
  }
  
  public void setQualifiedNamesProvider(final QualifiedNamesFragment2 qualifiedNamesProvider) {
    this.qualifiedNamesProvider = qualifiedNamesProvider;
  }
  
  @Pure
  protected Junit4Fragment2 getJunitSupport() {
    return this.junitSupport;
  }
  
  public void setJunitSupport(final Junit4Fragment2 junitSupport) {
    this.junitSupport = junitSupport;
  }
  
  @Pure
  protected QuickfixProviderFragment2 getQuickFixProvider() {
    return this.quickFixProvider;
  }
  
  public void setQuickFixProvider(final QuickfixProviderFragment2 quickFixProvider) {
    this.quickFixProvider = quickFixProvider;
  }
  
  @Pure
  protected LabelProviderFragment2 getLabelProvider() {
    return this.labelProvider;
  }
  
  public void setLabelProvider(final LabelProviderFragment2 labelProvider) {
    this.labelProvider = labelProvider;
  }
  
  @Pure
  protected OutlineTreeProviderFragment2 getOutline() {
    return this.outline;
  }
  
  public void setOutline(final OutlineTreeProviderFragment2 outline) {
    this.outline = outline;
  }
  
  @Pure
  protected QuickOutlineFragment2 getQuickOutline() {
    return this.quickOutline;
  }
  
  public void setQuickOutline(final QuickOutlineFragment2 quickOutline) {
    this.quickOutline = quickOutline;
  }
  
  @Pure
  protected CompareFragment2 getCompareEditor() {
    return this.compareEditor;
  }
  
  public void setCompareEditor(final CompareFragment2 compareEditor) {
    this.compareEditor = compareEditor;
  }
  
  @Pure
  protected ContentAssistFragment2 getContentAssist() {
    return this.contentAssist;
  }
  
  public void setContentAssist(final ContentAssistFragment2 contentAssist) {
    this.contentAssist = contentAssist;
  }
  
  @Pure
  protected RefactorElementNameFragment2 getRenameRefactoring() {
    return this.renameRefactoring;
  }
  
  public void setRenameRefactoring(final RefactorElementNameFragment2 renameRefactoring) {
    this.renameRefactoring = renameRefactoring;
  }
  
  @Pure
  protected CodetemplatesGeneratorFragment2 getCodeTemplates() {
    return this.codeTemplates;
  }
  
  public void setCodeTemplates(final CodetemplatesGeneratorFragment2 codeTemplates) {
    this.codeTemplates = codeTemplates;
  }
  
  @Pure
  protected XtextAntlrIDEAGeneratorFragment getIdeaParser() {
    return this.ideaParser;
  }
  
  public void setIdeaParser(final XtextAntlrIDEAGeneratorFragment ideaParser) {
    this.ideaParser = ideaParser;
  }
  
  @Pure
  protected TypesGeneratorFragment2 getCommonTypesSupport() {
    return this.commonTypesSupport;
  }
  
  public void setCommonTypesSupport(final TypesGeneratorFragment2 commonTypesSupport) {
    this.commonTypesSupport = commonTypesSupport;
  }
  
  @Pure
  protected XtypeGeneratorFragment2 getXtypeSupport() {
    return this.xtypeSupport;
  }
  
  public void setXtypeSupport(final XtypeGeneratorFragment2 xtypeSupport) {
    this.xtypeSupport = xtypeSupport;
  }
  
  @Pure
  protected XbaseGeneratorFragment2 getXbaseSupport() {
    return this.xbaseSupport;
  }
  
  public void setXbaseSupport(final XbaseGeneratorFragment2 xbaseSupport) {
    this.xbaseSupport = xbaseSupport;
  }
  
  @Pure
  protected IdeaPluginGenerator getIdeaPlugin() {
    return this.ideaPlugin;
  }
  
  public void setIdeaPlugin(final IdeaPluginGenerator ideaPlugin) {
    this.ideaPlugin = ideaPlugin;
  }
  
  @Pure
  protected WebIntegrationFragment getWebSupport() {
    return this.webSupport;
  }
  
  public void setWebSupport(final WebIntegrationFragment webSupport) {
    this.webSupport = webSupport;
  }
  
  private final static Logger LOG = Logger.getLogger(StandardLanguage.class);
}

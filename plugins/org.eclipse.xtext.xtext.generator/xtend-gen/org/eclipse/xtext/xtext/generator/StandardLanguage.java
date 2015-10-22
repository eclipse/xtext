/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextLanguageStandaloneSetup;
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
import org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2;
import org.eclipse.xtext.xtext.generator.web.WebIntegrationFragment;
import org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.xbase.XtypeGeneratorFragment2;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend
 */
@Accessors(AccessorType.PUBLIC_SETTER)
@Log
@SuppressWarnings("all")
public class StandardLanguage extends XtextGeneratorLanguage {
  private GrammarAccessFragment2 grammarAccess = new GrammarAccessFragment2();
  
  private SerializerFragment2 serializer = new SerializerFragment2();
  
  private ResourceFactoryFragment2 resourceFactoryFragment = new ResourceFactoryFragment2();
  
  private EMFGeneratorFragment2 emfGenerator = new EMFGeneratorFragment2();
  
  private XtextAntlrGeneratorFragment2 parserGenerator = new XtextAntlrGeneratorFragment2();
  
  private ValidatorFragment2 validator = ObjectExtensions.<ValidatorFragment2>operator_doubleArrow(new ValidatorFragment2(), new Procedure1<ValidatorFragment2>() {
    @Override
    public void apply(final ValidatorFragment2 it) {
      it.addComposedCheck("org.eclipse.xtext.validation.NamesAreUniqueValidator");
    }
  });
  
  private Formatter2Fragment2 formatter = ObjectExtensions.<Formatter2Fragment2>operator_doubleArrow(new Formatter2Fragment2(), new Procedure1<Formatter2Fragment2>() {
    @Override
    public void apply(final Formatter2Fragment2 it) {
      it.setGenerateStub(false);
    }
  });
  
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
  
  private TypesGeneratorFragment2 commonTypesSupport = ObjectExtensions.<TypesGeneratorFragment2>operator_doubleArrow(new TypesGeneratorFragment2(), new Procedure1<TypesGeneratorFragment2>() {
    @Override
    public void apply(final TypesGeneratorFragment2 it) {
      it.setOnlyEnabledIfGrammarIsUsed(true);
    }
  });
  
  private XtypeGeneratorFragment2 xtypeSupport = new XtypeGeneratorFragment2();
  
  private XbaseGeneratorFragment2 xbaseSupport = new XbaseGeneratorFragment2();
  
  private IdeaPluginGenerator ideaPlugin = new IdeaPluginGenerator();
  
  private WebIntegrationFragment webSupport = ObjectExtensions.<WebIntegrationFragment>operator_doubleArrow(new WebIntegrationFragment(), new Procedure1<WebIntegrationFragment>() {
    @Override
    public void apply(final WebIntegrationFragment it) {
      it.setFramework("Ace");
      it.setGenerateServlet(true);
      it.setGenerateJettyLauncher(true);
      it.setGenerateHtmlExample(true);
    }
  });
  
  public StandardLanguage() {
    try {
      Class<? extends StandardLanguage> _class = this.getClass();
      ClassLoader _classLoader = _class.getClassLoader();
      _classLoader.loadClass("org.eclipse.xtext.xbase.XbaseRuntimeModule");
      XtextLanguageStandaloneSetup _xtextLanguageStandaloneSetup = new XtextLanguageStandaloneSetup();
      final Procedure1<XtextLanguageStandaloneSetup> _function = new Procedure1<XtextLanguageStandaloneSetup>() {
        @Override
        public void apply(final XtextLanguageStandaloneSetup it) {
          it.addLoadedResource("platform:/resource/org.eclipse.xtext.xbase/model/Xbase.genmodel");
        }
      };
      XtextLanguageStandaloneSetup _doubleArrow = ObjectExtensions.<XtextLanguageStandaloneSetup>operator_doubleArrow(_xtextLanguageStandaloneSetup, _function);
      this.setStandaloneSetup(_doubleArrow);
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
  protected List<? extends IXtextGeneratorFragment> getImplicitFragments() {
    ArrayList<IXtextGeneratorFragment> _xblockexpression = null;
    {
      final ArrayList<IXtextGeneratorFragment> fragments = CollectionLiterals.<IXtextGeneratorFragment>newArrayList();
      List<? extends IXtextGeneratorFragment> _implicitFragments = super.getImplicitFragments();
      Iterables.<IXtextGeneratorFragment>addAll(fragments, _implicitFragments);
      fragments.add(this.grammarAccess);
      fragments.add(this.emfGenerator);
      fragments.add(this.serializer);
      fragments.add(this.resourceFactoryFragment);
      fragments.add(this.parserGenerator);
      fragments.add(this.validator);
      fragments.add(this.scopeProvider);
      fragments.add(this.qualifiedNamesProvider);
      fragments.add(this.builder);
      fragments.add(this.generator);
      fragments.add(this.formatter);
      fragments.add(this.labelProvider);
      fragments.add(this.quickOutline);
      fragments.add(this.outline);
      fragments.add(this.quickFixProvider);
      fragments.add(this.contentAssist);
      fragments.add(this.junitSupport);
      fragments.add(this.renameRefactoring);
      fragments.add(this.commonTypesSupport);
      fragments.add(this.xbaseSupport);
      fragments.add(this.xtypeSupport);
      fragments.add(this.codeTemplates);
      fragments.add(this.compareEditor);
      fragments.add(this.ideaParser);
      fragments.add(this.ideaPlugin);
      fragments.add(this.webSupport);
      _xblockexpression = fragments;
    }
    return _xblockexpression;
  }
  
  public void setGrammarAccess(final GrammarAccessFragment2 grammarAccess) {
    this.grammarAccess = grammarAccess;
  }
  
  public void setSerializer(final SerializerFragment2 serializer) {
    this.serializer = serializer;
  }
  
  public void setResourceFactoryFragment(final ResourceFactoryFragment2 resourceFactoryFragment) {
    this.resourceFactoryFragment = resourceFactoryFragment;
  }
  
  public void setEmfGenerator(final EMFGeneratorFragment2 emfGenerator) {
    this.emfGenerator = emfGenerator;
  }
  
  public void setParserGenerator(final XtextAntlrGeneratorFragment2 parserGenerator) {
    this.parserGenerator = parserGenerator;
  }
  
  public void setValidator(final ValidatorFragment2 validator) {
    this.validator = validator;
  }
  
  public void setFormatter(final Formatter2Fragment2 formatter) {
    this.formatter = formatter;
  }
  
  public void setGenerator(final GeneratorFragment2 generator) {
    this.generator = generator;
  }
  
  public void setBuilder(final BuilderIntegrationFragment2 builder) {
    this.builder = builder;
  }
  
  public void setScopeProvider(final ImportNamespacesScopingFragment2 scopeProvider) {
    this.scopeProvider = scopeProvider;
  }
  
  public void setQualifiedNamesProvider(final QualifiedNamesFragment2 qualifiedNamesProvider) {
    this.qualifiedNamesProvider = qualifiedNamesProvider;
  }
  
  public void setJunitSupport(final Junit4Fragment2 junitSupport) {
    this.junitSupport = junitSupport;
  }
  
  public void setQuickFixProvider(final QuickfixProviderFragment2 quickFixProvider) {
    this.quickFixProvider = quickFixProvider;
  }
  
  public void setLabelProvider(final LabelProviderFragment2 labelProvider) {
    this.labelProvider = labelProvider;
  }
  
  public void setOutline(final OutlineTreeProviderFragment2 outline) {
    this.outline = outline;
  }
  
  public void setQuickOutline(final QuickOutlineFragment2 quickOutline) {
    this.quickOutline = quickOutline;
  }
  
  public void setCompareEditor(final CompareFragment2 compareEditor) {
    this.compareEditor = compareEditor;
  }
  
  public void setContentAssist(final ContentAssistFragment2 contentAssist) {
    this.contentAssist = contentAssist;
  }
  
  public void setRenameRefactoring(final RefactorElementNameFragment2 renameRefactoring) {
    this.renameRefactoring = renameRefactoring;
  }
  
  public void setCodeTemplates(final CodetemplatesGeneratorFragment2 codeTemplates) {
    this.codeTemplates = codeTemplates;
  }
  
  public void setIdeaParser(final XtextAntlrIDEAGeneratorFragment ideaParser) {
    this.ideaParser = ideaParser;
  }
  
  public void setCommonTypesSupport(final TypesGeneratorFragment2 commonTypesSupport) {
    this.commonTypesSupport = commonTypesSupport;
  }
  
  public void setXtypeSupport(final XtypeGeneratorFragment2 xtypeSupport) {
    this.xtypeSupport = xtypeSupport;
  }
  
  public void setXbaseSupport(final XbaseGeneratorFragment2 xbaseSupport) {
    this.xbaseSupport = xbaseSupport;
  }
  
  public void setIdeaPlugin(final IdeaPluginGenerator ideaPlugin) {
    this.ideaPlugin = ideaPlugin;
  }
  
  public void setWebSupport(final WebIntegrationFragment webSupport) {
    this.webSupport = webSupport;
  }
  
  private final static Logger LOG = Logger.getLogger(StandardLanguage.class);
}

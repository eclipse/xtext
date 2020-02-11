/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.adapter;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.binder.AnnotatedBindingBuilder;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.LanguageConfig;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.adapter.NamingAdapter;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.project.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.XtextProjectConfig;

/**
 * @since 2.9
 */
@Deprecated
@SuppressWarnings("all")
public class Generator2AdapterSetup {
  private final LanguageConfig languageConfig;
  
  private final XpandExecutionContext xpandContext;
  
  private final Naming naming;
  
  private Injector injector;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private com.google.inject.Module additionalGeneratorBindings = ((com.google.inject.Module) (Binder it) -> {
  });
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private com.google.inject.Module additionalLanguageBindings = ((com.google.inject.Module) (Binder it) -> {
  });
  
  public Generator2AdapterSetup(final LanguageConfig languageConfig, final XpandExecutionContext xpandContext, final Naming naming) {
    this.languageConfig = languageConfig;
    this.xpandContext = xpandContext;
    this.naming = naming;
  }
  
  public Injector getInjector() {
    Injector _xblockexpression = null;
    {
      if ((this.injector == null)) {
        this.injector = this.createInjector();
      }
      _xblockexpression = this.injector;
    }
    return _xblockexpression;
  }
  
  private Injector createInjector() {
    final Procedure1<DefaultGeneratorModule> _function = (DefaultGeneratorModule it) -> {
      it.setProject(this.createProjectConfig());
      it.setCode(this.createCodeConfig());
    };
    final DefaultGeneratorModule generatorModule = ObjectExtensions.<DefaultGeneratorModule>operator_doubleArrow(new DefaultGeneratorModule() {
      @Override
      public void configure(final Binder binder) {
        super.configure(binder);
        binder.install(Generator2AdapterSetup.this.additionalGeneratorBindings);
      }
    }, _function);
    final Injector generatorInjector = Guice.createInjector(generatorModule);
    generatorModule.getProject().initialize(generatorInjector);
    generatorModule.getCode().initialize(generatorInjector);
    final IXtextGeneratorLanguage language = this.createLanguage(generatorInjector);
    final com.google.inject.Module _function_1 = (Binder it) -> {
      it.<IXtextGeneratorLanguage>bind(IXtextGeneratorLanguage.class).toInstance(language);
      it.<Grammar>bind(Grammar.class).toInstance(language.getGrammar());
      AnnotatedBindingBuilder<XtextGeneratorNaming> _bind = it.<XtextGeneratorNaming>bind(XtextGeneratorNaming.class);
      NamingAdapter _namingAdapter = new NamingAdapter(this.naming);
      _bind.toInstance(_namingAdapter);
      it.install(this.additionalLanguageBindings);
    };
    final com.google.inject.Module languageModule = _function_1;
    return generatorInjector.createChildInjector(languageModule);
  }
  
  private XtextProjectConfig createProjectConfig() {
    StandardProjectConfig _standardProjectConfig = new StandardProjectConfig();
    final Procedure1<StandardProjectConfig> _function = (StandardProjectConfig it) -> {
      it.setCreateEclipseMetaData(true);
      it.setBaseName(this.naming.getProjectNameRt());
      final String runtimeRoot = this.xpandContext.getOutput().getOutlet(Generator.PLUGIN_RT).getPath();
      final int projectNameIndex = runtimeRoot.lastIndexOf(it.getBaseName());
      if ((projectNameIndex >= 0)) {
        it.setRootPath(runtimeRoot.substring(0, projectNameIndex));
      } else {
        it.setRootPath(runtimeRoot);
      }
      RuntimeProjectConfig _runtime = it.getRuntime();
      _runtime.setName(it.getBaseName());
      RuntimeProjectConfig _runtime_1 = it.getRuntime();
      _runtime_1.setRoot(runtimeRoot);
      RuntimeProjectConfig _runtime_2 = it.getRuntime();
      _runtime_2.setSrc(this.xpandContext.getOutput().getOutlet(Generator.SRC).getPath());
      RuntimeProjectConfig _runtime_3 = it.getRuntime();
      _runtime_3.setSrcGen(this.xpandContext.getOutput().getOutlet(Generator.SRC_GEN).getPath());
      RuntimeProjectConfig _runtime_4 = it.getRuntime();
      _runtime_4.setEcoreModel(this.xpandContext.getOutput().getOutlet(Generator.MODEL).getPath());
      BundleProjectConfig _eclipsePlugin = it.getEclipsePlugin();
      _eclipsePlugin.setEnabled(true);
      BundleProjectConfig _eclipsePlugin_1 = it.getEclipsePlugin();
      _eclipsePlugin_1.setName(this.naming.getProjectNameUi());
      BundleProjectConfig _eclipsePlugin_2 = it.getEclipsePlugin();
      _eclipsePlugin_2.setRoot(this.xpandContext.getOutput().getOutlet(Generator.PLUGIN_UI).getPath());
      BundleProjectConfig _eclipsePlugin_3 = it.getEclipsePlugin();
      _eclipsePlugin_3.setSrc(this.xpandContext.getOutput().getOutlet(Generator.SRC_UI).getPath());
      BundleProjectConfig _eclipsePlugin_4 = it.getEclipsePlugin();
      _eclipsePlugin_4.setSrcGen(this.xpandContext.getOutput().getOutlet(Generator.SRC_GEN_UI).getPath());
      BundleProjectConfig _genericIde = it.getGenericIde();
      _genericIde.setEnabled(true);
      BundleProjectConfig _genericIde_1 = it.getGenericIde();
      _genericIde_1.setName(this.naming.getProjectNameIde());
      BundleProjectConfig _genericIde_2 = it.getGenericIde();
      _genericIde_2.setRoot(this.xpandContext.getOutput().getOutlet(Generator.PLUGIN_IDE).getPath());
      BundleProjectConfig _genericIde_3 = it.getGenericIde();
      _genericIde_3.setSrc(this.xpandContext.getOutput().getOutlet(Generator.SRC_IDE).getPath());
      BundleProjectConfig _genericIde_4 = it.getGenericIde();
      _genericIde_4.setSrcGen(this.xpandContext.getOutput().getOutlet(Generator.SRC_GEN_IDE).getPath());
    };
    return ObjectExtensions.<StandardProjectConfig>operator_doubleArrow(_standardProjectConfig, _function);
  }
  
  private CodeConfig createCodeConfig() {
    CodeConfig _codeConfig = new CodeConfig();
    final Procedure1<CodeConfig> _function = (CodeConfig it) -> {
      it.setLineDelimiter(this.naming.getLineDelimiter());
      it.setFileHeader(this.naming.fileHeader());
    };
    return ObjectExtensions.<CodeConfig>operator_doubleArrow(_codeConfig, _function);
  }
  
  private IXtextGeneratorLanguage createLanguage(final Injector generatorInjector) {
    XtextGeneratorLanguage _xtextGeneratorLanguage = new XtextGeneratorLanguage();
    final Procedure1<XtextGeneratorLanguage> _function = (XtextGeneratorLanguage it) -> {
      it.setGrammarUri(this.languageConfig.getGrammar().eResource().getURI().toString());
      it.setResourceSet(this.languageConfig.getGrammar().eResource().getResourceSet());
      it.setFileExtensions(IterableExtensions.join(this.languageConfig.getFileExtensions(this.languageConfig.getGrammar()), ","));
      generatorInjector.injectMembers(it);
      it.initialize(this.languageConfig.getGrammar());
    };
    return ObjectExtensions.<XtextGeneratorLanguage>operator_doubleArrow(_xtextGeneratorLanguage, _function);
  }
  
  public void setAdditionalGeneratorBindings(final com.google.inject.Module additionalGeneratorBindings) {
    this.additionalGeneratorBindings = additionalGeneratorBindings;
  }
  
  public void setAdditionalLanguageBindings(final com.google.inject.Module additionalLanguageBindings) {
    this.additionalLanguageBindings = additionalLanguageBindings;
  }
}

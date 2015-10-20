/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.adapter;

import com.google.common.base.Objects;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
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
import org.eclipse.xtext.xtext.generator.BundleProjectConfig;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.StandardProjectConfig;
import org.eclipse.xtext.xtext.generator.XtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.XtextProjectConfig;

/**
 * @since 2.9
 */
@SuppressWarnings("all")
public class Generator2AdapterSetup {
  private final LanguageConfig languageConfig;
  
  private final XpandExecutionContext xpandContext;
  
  private final Naming naming;
  
  private Injector injector;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private Module additionalGeneratorBindings = new Module() {
    @Override
    public void configure(final Binder it) {
    }
  };
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private Module additionalLanguageBindings = new Module() {
    @Override
    public void configure(final Binder it) {
    }
  };
  
  public Generator2AdapterSetup(final LanguageConfig languageConfig, final XpandExecutionContext xpandContext, final Naming naming) {
    this.languageConfig = languageConfig;
    this.xpandContext = xpandContext;
    this.naming = naming;
  }
  
  public Injector getInjector() {
    Injector _xblockexpression = null;
    {
      boolean _equals = Objects.equal(this.injector, null);
      if (_equals) {
        Injector _createInjector = this.createInjector();
        this.injector = _createInjector;
      }
      _xblockexpression = this.injector;
    }
    return _xblockexpression;
  }
  
  private Injector createInjector() {
    final Procedure1<DefaultGeneratorModule> _function = new Procedure1<DefaultGeneratorModule>() {
      @Override
      public void apply(final DefaultGeneratorModule it) {
        XtextProjectConfig _createProjectConfig = Generator2AdapterSetup.this.createProjectConfig();
        it.setProject(_createProjectConfig);
        CodeConfig _createCodeConfig = Generator2AdapterSetup.this.createCodeConfig();
        it.setCode(_createCodeConfig);
      }
    };
    final DefaultGeneratorModule generatorModule = ObjectExtensions.<DefaultGeneratorModule>operator_doubleArrow(new DefaultGeneratorModule() {
      @Override
      public void configure(final Binder binder) {
        super.configure(binder);
        binder.install(Generator2AdapterSetup.this.additionalGeneratorBindings);
      }
    }, _function);
    final Injector generatorInjector = Guice.createInjector(generatorModule);
    XtextProjectConfig _project = generatorModule.getProject();
    _project.initialize(generatorInjector);
    CodeConfig _code = generatorModule.getCode();
    _code.initialize(generatorInjector);
    final IXtextGeneratorLanguage language = this.createLanguage(generatorInjector);
    final Module _function_1 = new Module() {
      @Override
      public void configure(final Binder it) {
        AnnotatedBindingBuilder<IXtextGeneratorLanguage> _bind = it.<IXtextGeneratorLanguage>bind(IXtextGeneratorLanguage.class);
        _bind.toInstance(language);
        AnnotatedBindingBuilder<Grammar> _bind_1 = it.<Grammar>bind(Grammar.class);
        Grammar _grammar = language.getGrammar();
        _bind_1.toInstance(_grammar);
        AnnotatedBindingBuilder<XtextGeneratorNaming> _bind_2 = it.<XtextGeneratorNaming>bind(XtextGeneratorNaming.class);
        NamingAdapter _namingAdapter = new NamingAdapter(Generator2AdapterSetup.this.naming);
        _bind_2.toInstance(_namingAdapter);
        it.install(Generator2AdapterSetup.this.additionalLanguageBindings);
      }
    };
    final Module languageModule = _function_1;
    return generatorInjector.createChildInjector(languageModule);
  }
  
  private XtextProjectConfig createProjectConfig() {
    StandardProjectConfig _standardProjectConfig = new StandardProjectConfig();
    final Procedure1<StandardProjectConfig> _function = new Procedure1<StandardProjectConfig>() {
      @Override
      public void apply(final StandardProjectConfig it) {
        it.setCreateEclipseMetaData(true);
        String _projectNameRt = Generator2AdapterSetup.this.naming.getProjectNameRt();
        it.setBaseName(_projectNameRt);
        Output _output = Generator2AdapterSetup.this.xpandContext.getOutput();
        Outlet _outlet = _output.getOutlet(Generator.PLUGIN_RT);
        final String runtimeRoot = _outlet.getPath();
        String _baseName = it.getBaseName();
        final int projectNameIndex = runtimeRoot.lastIndexOf(_baseName);
        if ((projectNameIndex >= 0)) {
          String _substring = runtimeRoot.substring(0, projectNameIndex);
          it.setRootPath(_substring);
        } else {
          it.setRootPath(runtimeRoot);
        }
        RuntimeProjectConfig _runtime = it.getRuntime();
        String _baseName_1 = it.getBaseName();
        _runtime.setName(_baseName_1);
        RuntimeProjectConfig _runtime_1 = it.getRuntime();
        _runtime_1.setRoot(runtimeRoot);
        RuntimeProjectConfig _runtime_2 = it.getRuntime();
        Output _output_1 = Generator2AdapterSetup.this.xpandContext.getOutput();
        Outlet _outlet_1 = _output_1.getOutlet(Generator.SRC);
        String _path = _outlet_1.getPath();
        _runtime_2.setSrc(_path);
        RuntimeProjectConfig _runtime_3 = it.getRuntime();
        Output _output_2 = Generator2AdapterSetup.this.xpandContext.getOutput();
        Outlet _outlet_2 = _output_2.getOutlet(Generator.SRC_GEN);
        String _path_1 = _outlet_2.getPath();
        _runtime_3.setSrcGen(_path_1);
        RuntimeProjectConfig _runtime_4 = it.getRuntime();
        Output _output_3 = Generator2AdapterSetup.this.xpandContext.getOutput();
        Outlet _outlet_3 = _output_3.getOutlet(Generator.MODEL);
        String _path_2 = _outlet_3.getPath();
        _runtime_4.setEcoreModel(_path_2);
        BundleProjectConfig _eclipsePlugin = it.getEclipsePlugin();
        _eclipsePlugin.setEnabled(true);
        BundleProjectConfig _eclipsePlugin_1 = it.getEclipsePlugin();
        String _projectNameUi = Generator2AdapterSetup.this.naming.getProjectNameUi();
        _eclipsePlugin_1.setName(_projectNameUi);
        BundleProjectConfig _eclipsePlugin_2 = it.getEclipsePlugin();
        Output _output_4 = Generator2AdapterSetup.this.xpandContext.getOutput();
        Outlet _outlet_4 = _output_4.getOutlet(Generator.PLUGIN_UI);
        String _path_3 = _outlet_4.getPath();
        _eclipsePlugin_2.setRoot(_path_3);
        BundleProjectConfig _eclipsePlugin_3 = it.getEclipsePlugin();
        Output _output_5 = Generator2AdapterSetup.this.xpandContext.getOutput();
        Outlet _outlet_5 = _output_5.getOutlet(Generator.SRC_UI);
        String _path_4 = _outlet_5.getPath();
        _eclipsePlugin_3.setSrc(_path_4);
        BundleProjectConfig _eclipsePlugin_4 = it.getEclipsePlugin();
        Output _output_6 = Generator2AdapterSetup.this.xpandContext.getOutput();
        Outlet _outlet_6 = _output_6.getOutlet(Generator.SRC_GEN_UI);
        String _path_5 = _outlet_6.getPath();
        _eclipsePlugin_4.setSrcGen(_path_5);
        BundleProjectConfig _genericIde = it.getGenericIde();
        _genericIde.setEnabled(true);
        BundleProjectConfig _genericIde_1 = it.getGenericIde();
        String _projectNameIde = Generator2AdapterSetup.this.naming.getProjectNameIde();
        _genericIde_1.setName(_projectNameIde);
        BundleProjectConfig _genericIde_2 = it.getGenericIde();
        Output _output_7 = Generator2AdapterSetup.this.xpandContext.getOutput();
        Outlet _outlet_7 = _output_7.getOutlet(Generator.PLUGIN_IDE);
        String _path_6 = _outlet_7.getPath();
        _genericIde_2.setRoot(_path_6);
        BundleProjectConfig _genericIde_3 = it.getGenericIde();
        Output _output_8 = Generator2AdapterSetup.this.xpandContext.getOutput();
        Outlet _outlet_8 = _output_8.getOutlet(Generator.SRC_IDE);
        String _path_7 = _outlet_8.getPath();
        _genericIde_3.setSrc(_path_7);
        BundleProjectConfig _genericIde_4 = it.getGenericIde();
        Output _output_9 = Generator2AdapterSetup.this.xpandContext.getOutput();
        Outlet _outlet_9 = _output_9.getOutlet(Generator.SRC_GEN_IDE);
        String _path_8 = _outlet_9.getPath();
        _genericIde_4.setSrcGen(_path_8);
      }
    };
    return ObjectExtensions.<StandardProjectConfig>operator_doubleArrow(_standardProjectConfig, _function);
  }
  
  private CodeConfig createCodeConfig() {
    CodeConfig _codeConfig = new CodeConfig();
    final Procedure1<CodeConfig> _function = new Procedure1<CodeConfig>() {
      @Override
      public void apply(final CodeConfig it) {
        String _lineDelimiter = Generator2AdapterSetup.this.naming.getLineDelimiter();
        it.setLineDelimiter(_lineDelimiter);
        String _fileHeader = Generator2AdapterSetup.this.naming.fileHeader();
        it.setFileHeader(_fileHeader);
      }
    };
    return ObjectExtensions.<CodeConfig>operator_doubleArrow(_codeConfig, _function);
  }
  
  private IXtextGeneratorLanguage createLanguage(final Injector generatorInjector) {
    XtextGeneratorLanguage _xtextGeneratorLanguage = new XtextGeneratorLanguage();
    final Procedure1<XtextGeneratorLanguage> _function = new Procedure1<XtextGeneratorLanguage>() {
      @Override
      public void apply(final XtextGeneratorLanguage it) {
        Grammar _grammar = Generator2AdapterSetup.this.languageConfig.getGrammar();
        Resource _eResource = _grammar.eResource();
        URI _uRI = _eResource.getURI();
        String _string = _uRI.toString();
        it.setGrammarUri(_string);
        Grammar _grammar_1 = Generator2AdapterSetup.this.languageConfig.getGrammar();
        Resource _eResource_1 = _grammar_1.eResource();
        ResourceSet _resourceSet = _eResource_1.getResourceSet();
        it.setResourceSet(_resourceSet);
        Grammar _grammar_2 = Generator2AdapterSetup.this.languageConfig.getGrammar();
        List<String> _fileExtensions = Generator2AdapterSetup.this.languageConfig.getFileExtensions(_grammar_2);
        String _join = IterableExtensions.join(_fileExtensions, ",");
        it.setFileExtensions(_join);
        generatorInjector.injectMembers(it);
        Grammar _grammar_3 = Generator2AdapterSetup.this.languageConfig.getGrammar();
        it.initialize(_grammar_3);
      }
    };
    return ObjectExtensions.<XtextGeneratorLanguage>operator_doubleArrow(_xtextGeneratorLanguage, _function);
  }
  
  public void setAdditionalGeneratorBindings(final Module additionalGeneratorBindings) {
    this.additionalGeneratorBindings = additionalGeneratorBindings;
  }
  
  public void setAdditionalLanguageBindings(final Module additionalLanguageBindings) {
    this.additionalLanguageBindings = additionalLanguageBindings;
  }
}

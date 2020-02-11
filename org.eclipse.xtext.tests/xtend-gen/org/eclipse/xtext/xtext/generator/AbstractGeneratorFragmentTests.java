/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.io.InputStream;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.ecoreInference.Xtext2EcoreTransformer;
import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorLanguage;
import org.eclipse.xtext.xtext.generator.StandardLanguage;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.junit.After;
import org.junit.Before;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractGeneratorFragmentTests extends AbstractXtextTests {
  public static class FragmentGeneratorModule extends DefaultGeneratorModule {
    private Grammar grammar;
    
    public FragmentGeneratorModule(final Grammar g) {
      this.grammar = g;
    }
    
    public Class<? extends XtextGeneratorNaming> bindNaming() {
      return XtextGeneratorNaming.class;
    }
    
    public void configureGrammar(final Binder binder) {
      binder.<Grammar>bind(Grammar.class).toInstance(this.grammar);
    }
    
    @Override
    public void configureXtextProjectConfig(final Binder binder) {
      StandardLanguage _standardLanguage = new StandardLanguage();
      AbstractGeneratorFragmentTests.lang = _standardLanguage;
      AbstractGeneratorFragmentTests.lang.initialize(this.grammar);
      binder.<IXtextGeneratorLanguage>bind(IXtextGeneratorLanguage.class).toInstance(AbstractGeneratorFragmentTests.lang);
    }
    
    public void configureIXtextProjectConfig(final Binder binder) {
      AnnotatedBindingBuilder<IXtextProjectConfig> _bind = binder.<IXtextProjectConfig>bind(IXtextProjectConfig.class);
      AbstractGeneratorFragmentTests.FakeProjectConfig _fakeProjectConfig = new AbstractGeneratorFragmentTests.FakeProjectConfig();
      _bind.toInstance(_fakeProjectConfig);
    }
  }
  
  public static class FakeProjectConfig extends StandardProjectConfig {
    @Override
    public RuntimeProjectConfig getRuntime() {
      return new RuntimeProjectConfig() {
        @Override
        public String getName() {
          return "projectName";
        }
        
        @Override
        public String getEcoreModelFolder() {
          return "rootFolder/ecoreFolder";
        }
        
        @Override
        public IXtextGeneratorFileSystemAccess getSrcGen() {
          return new XtextGeneratorFileSystemAccess("rootFolder/src-gen", false);
        }
        
        @Override
        public IXtextGeneratorFileSystemAccess getRoot() {
          return new XtextGeneratorFileSystemAccess("rootFolder", false);
        }
      };
    }
  }
  
  @Log
  public static class FakeEMFGeneratorFragment2 extends EMFGeneratorFragment2 {
    @Override
    protected GenModel getSaveAndReconcileGenModel(final Grammar grammar, final List<EPackage> packs, final ResourceSet rs) {
      return super.getSaveAndReconcileGenModel(grammar, packs, rs);
    }
    
    @Override
    protected void saveResource(final Resource resource) {
    }
    
    private static final Logger LOG = Logger.getLogger(FakeEMFGeneratorFragment2.class);
  }
  
  private GlobalRegistries.GlobalStateMemento globalStateMemento;
  
  private static StandardLanguage lang;
  
  @Before
  @Override
  public void setUp() {
    try {
      this.globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
      super.setUp();
      EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
      this.with(XtextStandaloneSetup.class);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  @Override
  public void tearDown() {
    try {
      super.tearDown();
      this.globalStateMemento.restoreGlobalState();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private ResourceSet rs = null;
  
  public <T extends AbstractXtextGeneratorFragment> T initializeFragmentWithGrammarFromStringWithXbase(final Class<T> fragmentClass, final String grammarString) {
    try {
      if ((this.rs == null)) {
        this.rs = this.<XtextResourceSet>get(XtextResourceSet.class);
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("grammar org.eclipse.xtext.xbase.Xbase with org.eclipse.xtext.common.Terminals");
      _builder.newLine();
      _builder.append("import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore");
      _builder.newLine();
      _builder.append("Model returns ecore::EClass : name=ID;");
      _builder.newLine();
      String _currentFileExtension = this.getCurrentFileExtension();
      String _plus = ("fakeXbase." + _currentFileExtension);
      this.getResource(this.getAsStream(_builder.toString()), URI.createURI(_plus));
      return this.<T>initializeFragmentWithGrammarFromString(fragmentClass, grammarString);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public <T extends AbstractXtextGeneratorFragment> T initializeFragmentWithGrammarFromString(final Class<T> fragmentClass, final String grammarString) {
    try {
      if ((this.rs == null)) {
        this.rs = this.<XtextResourceSet>get(XtextResourceSet.class);
      }
      final XtextResource resource = this.getResourceFromString(grammarString);
      EObject _head = IterableExtensions.<EObject>head(resource.getContents());
      final Grammar grammar = ((Grammar) _head);
      XtextRuntimeModule _xtextRuntimeModule = new XtextRuntimeModule();
      AbstractGeneratorFragmentTests.FragmentGeneratorModule _fragmentGeneratorModule = new AbstractGeneratorFragmentTests.FragmentGeneratorModule(grammar);
      final Injector generatorInjector = Guice.createInjector(
        Modules2.mixin(_xtextRuntimeModule, _fragmentGeneratorModule));
      final Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(grammar);
      transformer.transform();
      final AbstractGeneratorFragmentTests.FakeEMFGeneratorFragment2 emfGeneratorFragment = generatorInjector.<AbstractGeneratorFragmentTests.FakeEMFGeneratorFragment2>getInstance(AbstractGeneratorFragmentTests.FakeEMFGeneratorFragment2.class);
      emfGeneratorFragment.initialize(generatorInjector);
      emfGeneratorFragment.getSaveAndReconcileGenModel(grammar, transformer.getGeneratedPackages(), resource.getResourceSet());
      AbstractGeneratorFragmentTests.lang.setResourceSet(resource.getResourceSet());
      this.rs = null;
      return generatorInjector.<T>getInstance(fragmentClass);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String concatenationClientToString(final JavaFileAccess access) {
    return access.getContent().toString();
  }
  
  @Override
  public XtextResource doGetResource(final InputStream in, final URI uri) throws Exception {
    Resource _createResource = this.getResourceFactory().createResource(uri);
    final XtextResource resource = ((XtextResource) _createResource);
    this.rs.getResources().add(resource);
    resource.load(in, null);
    return resource;
  }
}

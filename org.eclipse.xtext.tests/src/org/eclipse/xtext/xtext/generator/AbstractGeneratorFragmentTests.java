/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xtext.ecoreInference.Xtext2EcoreTransformer;
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.RuntimeProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.junit.After;
import org.junit.Before;

import com.google.common.collect.Iterables;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Holger Schill - Initial contribution and API
 */
public abstract class AbstractGeneratorFragmentTests extends AbstractXtextTests {
	public static class FragmentGeneratorModule extends DefaultGeneratorModule {
		private Grammar grammar;

		public FragmentGeneratorModule(Grammar g) {
			this.grammar = g;
		}

		public Class<? extends XtextGeneratorNaming> bindNaming() {
			return XtextGeneratorNaming.class;
		}

		public void configureGrammar(Binder binder) {
			binder.bind(Grammar.class).toInstance(grammar);
		}

		@Override
		public void configureXtextProjectConfig(Binder binder) {
			lang = new StandardLanguage();
			lang.initialize(grammar);
			binder.bind(IXtextGeneratorLanguage.class).toInstance(lang);
		}

		public void configureIXtextProjectConfig(Binder binder) {
			binder.bind(IXtextProjectConfig.class).toInstance(new FakeProjectConfig());
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

	public static class FakeEMFGeneratorFragment2 extends EMFGeneratorFragment2 {

		// To access the method
		@Override
		protected GenModel getSaveAndReconcileGenModel(Grammar grammar, List<EPackage> packs, ResourceSet rs) {
			return super.getSaveAndReconcileGenModel(grammar, packs, rs);
		}

		@Override
		protected void saveResource(Resource resource) {
			// Don't save.
		}
	}

	private GlobalRegistries.GlobalStateMemento globalStateMemento;

	private static StandardLanguage lang;

	@Before
	@Override
	public void setUp() throws Exception {
		globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
		super.setUp();
		EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
		with(XtextStandaloneSetup.class);
	}

	@After
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		globalStateMemento.restoreGlobalState();
	}

	private ResourceSet rs = null;

	public <T extends AbstractXtextGeneratorFragment> T initializeFragmentWithGrammarFromStringWithXbase(
			Class<T> fragmentClass, String grammarString) throws Exception {
		if (rs == null) {
			rs = get(XtextResourceSet.class);
		}
		String model = 
				"grammar org.eclipse.xtext.xbase.Xbase with org.eclipse.xtext.common.Terminals\n" +
				"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
				"Model returns ecore::EClass : name=ID;\n";
		getResource(getAsStream(model), URI.createURI("fakeXbase." + getCurrentFileExtension()));
		return initializeFragmentWithGrammarFromString(fragmentClass, grammarString);
	}

	public <T extends AbstractXtextGeneratorFragment> T initializeFragmentWithGrammarFromString(Class<T> fragmentClass,
			String grammarString) throws Exception {
		if (rs == null) {
			rs = get(XtextResourceSet.class);
		}
		XtextResource resource = getResourceFromString(grammarString);
		Grammar grammar = (Grammar) Iterables.getFirst(resource.getContents(), null);
		Injector generatorInjector = Guice
				.createInjector(Modules2.mixin(new XtextRuntimeModule(), new FragmentGeneratorModule(grammar)));
		// Transform to EPackage
		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer(grammar);
		transformer.transform();
		FakeEMFGeneratorFragment2 emfGeneratorFragment = generatorInjector.getInstance(FakeEMFGeneratorFragment2.class);
		// Do EMF Setup etc.
		emfGeneratorFragment.initialize(generatorInjector);
		// Create GenModel out of generated EPackages
		emfGeneratorFragment.getSaveAndReconcileGenModel(grammar, transformer.getGeneratedPackages(),
				resource.getResourceSet());
		lang.setResourceSet(resource.getResourceSet());
		rs = null;
		return generatorInjector.getInstance(fragmentClass);
	}

	public String concatenationClientToString(JavaFileAccess access) {
		return access.getContent().toString();
	}

	@Override
	public XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		XtextResource resource = (XtextResource) getResourceFactory().createResource(uri);
		rs.getResources().add(resource);
		resource.load(in, null);
		return resource;
	}
}

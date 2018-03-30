/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Binder
import com.google.inject.Guice
import java.io.InputStream
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.xml.type.XMLTypePackage
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.XtextRuntimeModule
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.GlobalRegistries
import org.eclipse.xtext.testing.GlobalRegistries.GlobalStateMemento
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.xtext.ecoreInference.Xtext2EcoreTransformer
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.XtextGeneratorFileSystemAccess
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.model.project.RuntimeProjectConfig
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig
import org.junit.After
import org.junit.Before

/**
 * @author Holger Schill - Initial contribution and API
 */
abstract class AbstractGeneratorFragmentTests extends AbstractXtextTests {
	
	GlobalStateMemento globalStateMemento;
	var static StandardLanguage lang
	
	@Before
	override setUp() {
		globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
		super.setUp();
		EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
		with(XtextStandaloneSetup)
	}
	
	@After
	override tearDown() {
		super.tearDown()
		globalStateMemento.restoreGlobalState();
	}

	static class FragmentGeneratorModule extends DefaultGeneratorModule {
		Grammar grammar

		new(Grammar g) {
			this.grammar = g
		}

		def Class<? extends XtextGeneratorNaming> bindNaming() {
			return XtextGeneratorNaming
		}

		def void configureGrammar(Binder binder) {
			binder.bind(Grammar).toInstance(grammar)
		}

		override configureXtextProjectConfig(Binder binder) {
			lang = new StandardLanguage
			lang.initialize(grammar)
			binder.bind(IXtextGeneratorLanguage).toInstance(lang)
		}
		def void configureIXtextProjectConfig(Binder binder){
			binder.bind(IXtextProjectConfig).toInstance(new FakeProjectConfig)
		}
	}

	static class FakeProjectConfig extends StandardProjectConfig {

		override getRuntime() {
			new RuntimeProjectConfig() {

				override getName() {
					"projectName"
				}

				override getEcoreModelFolder() {
					"rootFolder/ecoreFolder"
				}

				override getSrcGen() {
					new XtextGeneratorFileSystemAccess("rootFolder/src-gen", false)
				}

				override getRoot() {
					new XtextGeneratorFileSystemAccess("rootFolder", false)
				}

			}
		}
	}
	@Log
	static class FakeEMFGeneratorFragment2 extends EMFGeneratorFragment2 {
	
		// To access the method
		
		override protected getSaveAndReconcileGenModel(Grammar grammar, List<EPackage> packs, ResourceSet rs) {
			super.getSaveAndReconcileGenModel(grammar, packs, rs)
		}
		
		override protected saveResource(Resource resource) {
			// Don't save.
		}
		
	}
	
	def <T extends AbstractXtextGeneratorFragment> T initializeFragmentWithGrammarFromString(Class<T> fragmentClass, String grammarString){
		val resource = getResourceFromString(grammarString)
		val grammar = resource.contents.head as Grammar
		val generatorInjector = Guice.createInjector(
			Modules2.mixin(new XtextRuntimeModule, new FragmentGeneratorModule(grammar)));
		// Transform to EPackage
		val transformer = new Xtext2EcoreTransformer(grammar)
		transformer.transform
		val emfGeneratorFragment = generatorInjector.getInstance(FakeEMFGeneratorFragment2)
		// Do EMF Setup etc.
		emfGeneratorFragment.initialize(generatorInjector)
		// Create GenModel out of generated EPackages
		emfGeneratorFragment.getSaveAndReconcileGenModel(grammar, transformer.generatedPackages, resource.resourceSet)
		lang.resourceSet = resource.resourceSet
		return generatorInjector.getInstance(fragmentClass);
	}
	
	def String concatenationClientToString(JavaFileAccess access) {
		return access.content.toString
	}	
	
	override XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		val rs = get(XtextResourceSet);
		rs.setClasspathURIContext(getClass());
		val resource = getResourceFactory().createResource(uri) as XtextResource
		rs.getResources().add(resource);
		resource.load(in, null);
		return resource;
	}
}
/*******************************************************************************
 * Copyright (c) 2015, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.junit

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.JUnitVersion
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*

/**
 * @since 2.14
 */
class JUnitFragment extends AbstractStubGeneratingFragment {
	
	@Inject extension XtextGeneratorNaming
	@Inject FileAccessFactory fileAccessFactory
	
	@Accessors(PUBLIC_SETTER)
	boolean useDeprecatedClasses
	
	@Accessors(PUBLIC_SETTER)
	boolean skipXbaseTestingPackage
	
	JUnitVersion junitVersion = JUnitVersion.JUNIT_4
	
	def void setJunitVersion (String version) {
		junitVersion = JUnitVersion.fromString(version)
	}
	
	def protected getTestingPackage() {
		if (useDeprecatedClasses)
			getUiTestingPackage()
		else
			"org.eclipse.xtext.testing"
	}
	
	protected def String getUiTestingPackage() {
		"org.eclipse.xtext.ui.testing"
	}
	
	def protected getXbaseTestingPackage() {
		if (skipXbaseTestingPackage)
			return ""
		if (useDeprecatedClasses)
			getXbaseUiTestingPackage()
		else
			"org.eclipse.xtext.xbase.testing"
	}
	
	protected def String getXbaseUiTestingPackage() {
		if (skipXbaseTestingPackage)
			return ""
		"org.eclipse.xtext.xbase.junit"
	}
	
	override generate() {
		if (projectConfig.runtimeTest.manifest !== null) {
			projectConfig.runtimeTest.manifest => [
				requiredBundles.addAll(
					testingPackage,
					xbaseTestingPackage,
					'org.eclipse.xtext.xbase.lib;bundle-version="'+projectConfig.runtime.xbaseLibVersionLowerBound+'"'
				)
				exportedPackages.add(grammar.runtimeTestBasePackage+";x-internal=true")
			]
		}
		if (projectConfig.eclipsePluginTest.manifest !== null) {
			projectConfig.eclipsePluginTest.manifest => [
				requiredBundles.addAll(
					testingPackage,
					xbaseTestingPackage,
					uiTestingPackage,
					xbaseUiTestingPackage,
					"org.eclipse.core.runtime",
					"org.eclipse.ui.workbench;resolution:=optional"
				)
				exportedPackages.add(grammar.eclipsePluginTestBasePackage+";x-internal=true")
			]
		}
		if (projectConfig.eclipsePlugin.manifest !== null) {
			projectConfig.eclipsePlugin.manifest.exportedPackages.add(eclipsePluginActivator.packageName)
		}
		
		generateInjectorProvider.writeTo(projectConfig.runtimeTest.srcGen)
		if (isGenerateStub)
			generateExampleRuntimeTest.writeTo(projectConfig.runtimeTest.src)
		if (projectConfig.eclipsePlugin.srcGen !== null)
			generateUiInjectorProvider.writeTo(projectConfig.eclipsePluginTest.srcGen)
	}
	
	def protected JavaFileAccess generateExampleRuntimeTest() {
		val xtextRunner = new TypeReference(testingPackage + ".XtextRunner")
		val runWith = new TypeReference("org.junit.runner.RunWith")
		val injectWith = new TypeReference(testingPackage + ".InjectWith")
		val extendWith = new TypeReference("org.junit.jupiter.api.^extension.ExtendWith")
		val injectionExtension = new TypeReference("org.eclipse.xtext.testing.extensions.InjectionExtension") 
		val parseHelper = new TypeReference(testingPackage + ".util.ParseHelper")
		val test = switch (junitVersion) {
			case JUnitVersion.JUNIT_4: new TypeReference("org.junit.Test")
			case JUnitVersion.JUNIT_5: new TypeReference("org.junit.jupiter.api.Test")
		}
		val assert = switch (junitVersion) {
			case JUnitVersion.JUNIT_4: new TypeReference("org.junit.Assert")
			case JUnitVersion.JUNIT_5: new TypeReference("org.junit.jupiter.api.Assertions")
		}
		val rootType = new TypeReference(grammar.rules.head.type.classifier as EClass, grammar.eResource.resourceSet)
		return fileAccessFactory.createXtendFile(exampleRuntimeTest, '''
			«IF junitVersion==JUnitVersion.JUNIT_4»
				@«runWith»(«xtextRunner»)
			«ENDIF»
			«IF junitVersion==JUnitVersion.JUNIT_5»
				@«extendWith»(«injectionExtension»)
			«ENDIF»
			@«injectWith»(«injectorProvider»)
			class «exampleRuntimeTest» {
				@«Inject»
				«parseHelper»<«rootType»> parseHelper
				
				@«test»
				def void loadModel() {
					val result = parseHelper.parse(''«»'
						Hello Xtext!
					''«»')
					«assert».assertNotNull(result)
					val errors = result.eResource.errors
					«IF junitVersion==JUnitVersion.JUNIT_4»
						«assert».assertTrue(''«»'Unexpected errors: «"\u00AB"»errors.join(", ")«"\u00BB"»''«»', errors.isEmpty)
					«ENDIF»
					«IF junitVersion==JUnitVersion.JUNIT_5»
						«assert».assertTrue(errors.isEmpty, ''«»'Unexpected errors: «"\u00AB"»errors.join(", ")«"\u00BB"»''«»')
					«ENDIF»
				}
			}
		''')
	}
	
	def protected exampleRuntimeTest() {
		new TypeReference(grammar.runtimeTestBasePackage, grammar.simpleName + "ParsingTest")
	}

	def protected JavaFileAccess generateInjectorProvider() {
		val file = fileAccessFactory.createJavaFile(injectorProvider)
		val globalRegistries = new TypeReference(testingPackage + ".GlobalRegistries")
		val globalStateMemento = new TypeReference(testingPackage, "GlobalRegistries.GlobalStateMemento")
		val iRegistryConfigurator = new TypeReference(testingPackage + ".IRegistryConfigurator")
		val classLoader = new TypeReference("java.lang.ClassLoader")
		val guice = new TypeReference("com.google.inject.Guice")
		file.content = '''
			public class «injectorProvider.simpleName» implements «iInjectorProvider», «iRegistryConfigurator» {
			
				protected «globalStateMemento» stateBeforeInjectorCreation;
				protected «globalStateMemento» stateAfterInjectorCreation;
				protected «Injector» injector;
			
				static {
					«globalRegistries».initializeDefaults();
				}
			
				@Override
				public «Injector» getInjector() {
					if (injector == null) {
						this.injector = internalCreateInjector();
						stateAfterInjectorCreation = «globalRegistries».makeCopyOfGlobalState();
					}
					return injector;
				}
			
				protected «Injector» internalCreateInjector() {
					return new «grammar.runtimeSetup»() {
						@Override
						public Injector createInjector() {
							return «guice».createInjector(createRuntimeModule());
						}
					}.createInjectorAndDoEMFRegistration();
				}
			
				protected «grammar.runtimeModule» createRuntimeModule() {
					// make it work also with Maven/Tycho and OSGI
					// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=493672
					return new «grammar.runtimeModule»() {
						@Override
						public «classLoader» bindClassLoaderToInstance() {
							return «injectorProvider.simpleName».class
									.getClassLoader();
						}
					};
				}
			
				@Override
				public void restoreRegistry() {
					stateBeforeInjectorCreation.restoreGlobalState();
					stateBeforeInjectorCreation = null;
				}
			
				@Override
				public void setupRegistry() {
					stateBeforeInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
					if (injector == null) {
						getInjector();
					}
					stateAfterInjectorCreation.restoreGlobalState();
				}
			}
		'''
		file
	}
	
	def protected TypeReference iInjectorProvider() {
		new TypeReference(testingPackage + ".IInjectorProvider")
	}

	def protected TypeReference injectorProvider() {
		new TypeReference(grammar.runtimeTestBasePackage, grammar.simpleName + "InjectorProvider")
	}

	def protected JavaFileAccess generateUiInjectorProvider() {
		val file = fileAccessFactory.createJavaFile(uiInjectorProvider)
		file.content = '''
			public class «uiInjectorProvider.simpleName» implements «iInjectorProvider» {
			
				@Override
				public «Injector» getInjector() {
					return «eclipsePluginActivator».getInstance().getInjector("«grammar.name»");
				}
			
			}
		'''
		file
	}

	def protected TypeReference uiInjectorProvider() {
		new TypeReference(grammar.eclipsePluginTestBasePackage, grammar.simpleName + "UiInjectorProvider")
	}
}
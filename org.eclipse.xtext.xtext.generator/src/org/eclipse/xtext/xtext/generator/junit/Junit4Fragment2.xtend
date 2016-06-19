package org.eclipse.xtext.xtext.generator.junit

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2

import static extension org.eclipse.xtext.GrammarUtil.*

class Junit4Fragment2 extends AbstractStubGeneratingFragment {
	
	@Inject extension XtextGeneratorNaming
	@Inject FileAccessFactory fileAccessFactory
	
	@Accessors(PUBLIC_SETTER)
	boolean useDeprecatedClasses
	
	def protected getTestingPackage() {
		if (useDeprecatedClasses)
			"org.eclipse.xtext.junit4"
		else
			"org.eclipse.xtext.testing"
	}
	
	override generate() {
		if (projectConfig.runtimeTest.manifest != null) {
			projectConfig.runtimeTest.manifest => [
				requiredBundles.addAll(
					testingPackage,
					"org.eclipse.xtext.xbase.lib"
				)
				exportedPackages.add(grammar.runtimeTestBasePackage)
			]
		}
		if (projectConfig.eclipsePluginTest.manifest != null) {
			projectConfig.eclipsePluginTest.manifest => [
				requiredBundles.addAll(
					"org.eclipse.core.runtime",
					"org.eclipse.ui.workbench;resolution:=optional"
				)
				exportedPackages.add(grammar.eclipsePluginTestBasePackage)
			]
		}
		if (projectConfig.eclipsePlugin.manifest != null) {
			projectConfig.eclipsePlugin.manifest.exportedPackages.add(eclipsePluginActivator.packageName)
		}
		
		#[
			projectConfig.runtimeTest.manifest,
			projectConfig.eclipsePluginTest.manifest
		].filterNull.forEach [
			importedPackages.addAll(
				"org.junit;version=\"4.5.0\"",
				"org.junit.runner;version=\"4.5.0\"",
				"org.junit.runner.manipulation;version=\"4.5.0\"",
				"org.junit.runner.notification;version=\"4.5.0\"",
				"org.junit.runners;version=\"4.5.0\"",
				"org.junit.runners.model;version=\"4.5.0\"",
				"org.hamcrest.core"
			)
		]
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
		val parseHelper = new TypeReference(testingPackage + ".util.ParseHelper")
		val test = new TypeReference("org.junit.Test")
		val assert = new TypeReference("org.junit.Assert")
		val rootType = new TypeReference(GenModelUtil2.getJavaTypeName(grammar.rules.head.type.classifier, grammar.eResource.resourceSet))
		return fileAccessFactory.createXtendFile(exampleRuntimeTest, '''
			@«runWith»(«xtextRunner»)
			@«injectWith»(«injectorProvider»)
			class «exampleRuntimeTest»{
			
				@«Inject»
				«parseHelper»<«rootType»> parseHelper
			
				@«test» 
				def void loadModel() {
					val result = parseHelper.parse(''«»'
						Hello Xtext!
					''«»')
					«assert».assertNotNull(result)
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
						stateBeforeInjectorCreation = «globalRegistries».makeCopyOfGlobalState();
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
				}
			
				@Override
				public void setupRegistry() {
					getInjector();
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
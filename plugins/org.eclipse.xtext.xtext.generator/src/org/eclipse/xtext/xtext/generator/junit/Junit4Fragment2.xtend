package org.eclipse.xtext.xtext.generator.junit

import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import com.google.inject.Inject
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.TypeReference
import com.google.inject.Injector
import static extension org.eclipse.xtext.GrammarUtil.*
import org.eclipse.emf.ecore.EObject

class Junit4Fragment2 extends AbstractGeneratorFragment2 {
	@Inject IXtextProjectConfig projectConfig
	@Inject extension XtextGeneratorNaming
	@Inject FileAccessFactory fileAccessFactory

	override generate() {
		projectConfig.runtimeTestManifest => [
			requiredBundles.addAll(
				"org.eclipse.xtext.junit4",
				"org.eclipse.xtext.xbase.lib"
			)
			exportedPackages.add(grammar.runtimeTestBasePackage)
		]

		projectConfig.eclipsePluginManifest => [
			requiredBundles.addAll(
				"org.eclipse.core.runtime",
				"org.eclipse.ui.workbench;resolution:=optional"
			)
			exportedPackages.add(grammar.eclipsePluginTestBasePackage)
		]
		#[
			projectConfig.runtimeTestManifest,
			projectConfig.eclipsePluginManifest
		].forEach [
			importedPackages.addAll(
				"org.junit.runner;version=\"4.5.0\"",
				"org.junit.runner.manipulation;version=\"4.5.0\"",
				"org.junit.runner.notification;version=\"4.5.0\"",
				"org.junit.runners;version=\"4.5.0\"",
				"org.junit.runners.model;version=\"4.5.0\"",
				"org.hamcrest.core"
			)
		]
		generateInjectorProvider.writeTo(projectConfig.runtimeTestSrcGen)
		generateExampleRuntimeTest.writeTo(projectConfig.eclipsePluginSrc)
		generateUiInjectorProvider.writeTo(projectConfig.eclipsePluginSrcGen)
	}
	
	def JavaFileAccess generateExampleRuntimeTest() {
		val file = fileAccessFactory.createJavaFile(injectorProvider)
		val xtextRunner = new TypeReference("org.eclipse.xtext.junit4.XtextRunner")
		val runWith = new TypeReference("org.junit.runner.RunWith")
		val injectWith = new TypeReference("org.eclipse.xtext.junit4.InjectWith")
		val parseHelper = new TypeReference("org.eclipse.xtext.junit4.util.ParseHelper")
		val test = new TypeReference("org.junit.Test")
		file.javaContent =  '''
			@«runWith»(«xtextRunner».class)
			@«injectWith»(«injectorProvider».class)
			public class «grammar.simpleName»ParsingTest {
			
				@«Inject»
				private «parseHelper»<«EObject»> parseHelper;
			
				@«test»
				public void loadModel() throws Exception {
					«EObject» result = parseHelper.parse("Hello Xtext!");
					assertNotNull(result);
				}
			
			}
		'''
		file
	}

	def JavaFileAccess generateInjectorProvider() {
		val file = fileAccessFactory.createJavaFile(injectorProvider)
		val globalRegistries = new TypeReference("org.eclipse.xtext.junit4.GlobalRegistries")
		val globalStateMemento = new TypeReference("org.eclipse.xtext.junit4.GlobalRegistries.GlobalStateMemento")
		val iRegistryConfigurator = new TypeReference("org.eclipse.xtext.junit4.IRegistryConfigurator")
		file.javaContent = '''
			public class «injectorProvider.simpleName» implements «iInjectorProvider», «iRegistryConfigurator» {
			
				protected «globalStateMemento» stateBeforeInjectorCreation;
				protected «globalStateMemento» stateAfterInjectorCreation;
				protected «Injector» injector;
			
				static {
					«globalRegistries».initializeDefaults();
				}
			
				@Override
				public «Injector» getInjector()	{
					if (injector == null) {
						stateBeforeInjectorCreation = «globalRegistries».makeCopyOfGlobalState();
						this.injector = internalCreateInjector();
						stateAfterInjectorCreation = «globalRegistries».makeCopyOfGlobalState();
					}
					return injector;
				}
			
				protected «Injector» internalCreateInjector() {
					return new «grammar.runtimeSetup»().createInjectorAndDoEMFRegistration();
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
	
	def TypeReference iInjectorProvider() {
		new TypeReference("org.eclipse.xtext.junit4.IInjectorProvider")
	}

	def TypeReference injectorProvider() {
		new TypeReference(grammar.runtimeTestBasePackage, grammar.simpleName + "InjectorProvider")
	}

	def JavaFileAccess generateUiInjectorProvider() {
		val file = fileAccessFactory.createJavaFile(uiInjectorProvider)
		file.javaContent = '''
			public class «uiInjectorProvider.simpleName» implements «iInjectorProvider» {
			
				@Override
				public «Injector» getInjector() {
					return «grammar.eclipsePluginActivator».getInstance().getInjector("«grammar.name»");
				}
			
			}
		'''
		file
	}

	def TypeReference uiInjectorProvider() {
		new TypeReference(grammar.eclipsePluginTestBasePackage, grammar.simpleName + "UiInjectorProvider")
	}
}
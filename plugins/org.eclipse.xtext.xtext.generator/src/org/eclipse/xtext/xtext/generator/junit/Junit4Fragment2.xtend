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
import org.eclipse.xtext.xtext.generator.util.GenModelUtil2

class Junit4Fragment2 extends AbstractGeneratorFragment2 {
	@Inject IXtextProjectConfig projectConfig
	@Inject extension XtextGeneratorNaming
	@Inject FileAccessFactory fileAccessFactory

	override generate() {
		if (projectConfig.runtimeTestManifest != null) {
			projectConfig.runtimeTestManifest => [
				requiredBundles.addAll(
					"org.eclipse.xtext.junit4",
					"org.eclipse.xtext.xbase.lib"
				)
				exportedPackages.add(grammar.runtimeTestBasePackage)
			]
		}
		if (projectConfig.eclipsePluginTestManifest != null) {
			projectConfig.eclipsePluginTestManifest => [
				requiredBundles.addAll(
					"org.eclipse.core.runtime",
					"org.eclipse.ui.workbench;resolution:=optional"
				)
				exportedPackages.add(grammar.eclipsePluginTestBasePackage)
			]
		}
		if (projectConfig.eclipsePluginManifest != null) {
			projectConfig.eclipsePluginManifest.exportedPackages.add(grammar.eclipsePluginActivator.packageName)
		}
		
		#[
			projectConfig.runtimeTestManifest,
			projectConfig.eclipsePluginTestManifest
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
		generateInjectorProvider.writeTo(projectConfig.runtimeTestSrcGen)
		generateExampleRuntimeTest.writeTo(projectConfig.runtimeTestSrc)
		generateUiInjectorProvider.writeTo(projectConfig.eclipsePluginTestSrcGen)
	}
	
	def JavaFileAccess generateExampleRuntimeTest() {
		val xtextRunner = new TypeReference("org.eclipse.xtext.junit4.XtextRunner")
		val runWith = new TypeReference("org.junit.runner.RunWith")
		val injectWith = new TypeReference("org.eclipse.xtext.junit4.InjectWith")
		val parseHelper = new TypeReference("org.eclipse.xtext.junit4.util.ParseHelper")
		val test = new TypeReference("org.junit.Test")
		val assert = new TypeReference("org.junit.Assert")
		val rootType = new TypeReference(GenModelUtil2.getJavaTypeName(grammar.rules.head.type.classifier, grammar.eResource.resourceSet))
		return fileAccessFactory.createXtendFile(exampleRuntimeTest, '''
			@«runWith»(«xtextRunner»)
			@«injectWith»(«injectorProvider»)
			class «exampleRuntimeTest»{
			
				@«Inject»
				«parseHelper»<«rootType»> parseHelper;
			
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
	
	def exampleRuntimeTest() {
		new TypeReference(grammar.runtimeTestBasePackage, grammar.simpleName + "ParsingTest")
	}

	def JavaFileAccess generateInjectorProvider() {
		val file = fileAccessFactory.createJavaFile(injectorProvider)
		val globalRegistries = new TypeReference("org.eclipse.xtext.junit4.GlobalRegistries")
		val globalStateMemento = new TypeReference("org.eclipse.xtext.junit4.GlobalRegistries.GlobalStateMemento")
		val iRegistryConfigurator = new TypeReference("org.eclipse.xtext.junit4.IRegistryConfigurator")
		file.content = '''
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
		file.content = '''
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
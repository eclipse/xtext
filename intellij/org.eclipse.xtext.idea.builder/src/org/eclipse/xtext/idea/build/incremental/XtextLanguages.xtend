package org.eclipse.xtext.idea.build.incremental

import com.google.inject.Injector
import java.util.Map
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.jetbrains.jps.service.JpsServiceManager

class XtextLanguages {

	static Map<String, LanguageAccess> languageAccesses

	static def getLanguageAccesses() {
		languageAccesses ?: (languageAccesses = createLanguageAccesses)
	}

	static def Map<String, LanguageAccess> createLanguageAccesses() {
		val result = newHashMap
		for (setup : JpsServiceManager.instance.getExtensions(ISetup)) {
			val injector = setup.createInjectorAndDoEMFRegistration
			val languageAccess = injector.createXtendLanguageAccess
			for (fileExtension : injector.getInstance(FileExtensionProvider).fileExtensions) {
				result.put(fileExtension, languageAccess)
			}
		}
		result
	}

	static def createXtendLanguageAccess(Injector injector) {
		val outputConfigurationProvider = injector.getInstance(IOutputConfigurationProvider)
		val resourceServiceProvider = injector.getInstance(IResourceServiceProvider)
		return new IdeaLanguageAccess(
			outputConfigurationProvider.outputConfigurations.toSet,
			resourceServiceProvider,
			true
		)
	}

}
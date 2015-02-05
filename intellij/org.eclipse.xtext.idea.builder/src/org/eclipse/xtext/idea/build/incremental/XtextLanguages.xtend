package org.eclipse.xtext.idea.build.incremental

import java.util.Map
import org.eclipse.xtend.core.XtendStandaloneSetup
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.resource.IResourceServiceProvider

class XtextLanguages {
	
	static Map<String, LanguageAccess> languageAccesses
	
	static def getLanguageAccesses() {
		languageAccesses ?: (languageAccesses = createLanguageAccesses) 
	}
	
	static def createLanguageAccesses() {
		// TODO: add other languages
		#{ 'xtend' -> createXtendLanguageAccess }
	}

	static def createXtendLanguageAccess() {
		val injector = new XtendStandaloneSetup().createInjectorAndDoEMFRegistration
		val outputConfigurationProvider = injector.getInstance(IOutputConfigurationProvider)
		val resourceServiceProvider = injector.getInstance(IResourceServiceProvider)
		return new LanguageAccess(outputConfigurationProvider.outputConfigurations.toSet,
			resourceServiceProvider, true)
	}
}


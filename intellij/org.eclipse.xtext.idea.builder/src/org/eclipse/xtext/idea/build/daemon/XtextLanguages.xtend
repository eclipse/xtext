/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import com.google.inject.Injector
import java.util.Map
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.jetbrains.jps.service.JpsServiceManager
import org.apache.log4j.Logger

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextLanguages {

	static val LOG = Logger.getLogger(org.eclipse.xtext.idea.build.daemon.XtextLanguages)
	
	static Map<String, LanguageAccess> languageAccesses

	static def getLanguageAccesses() {
		languageAccesses ?: (languageAccesses = createLanguageAccesses)
	}

	static def Map<String, LanguageAccess> createLanguageAccesses() {
		LOG.info("Initializing Xtext languages...")
		val result = newHashMap
		for (setup : JpsServiceManager.instance.getExtensions(ISetup)) {
			val injector = setup.createInjectorAndDoEMFRegistration
			val languageAccess = injector.createLanguageAccess
			for (fileExtension : injector.getInstance(FileExtensionProvider).fileExtensions) {
				result.put(fileExtension, languageAccess)
			}
		}
		LOG.info("...done.")
		result
	}

	static def createLanguageAccess(Injector injector) {
		val outputConfigurationProvider = injector.getInstance(IOutputConfigurationProvider)
		val resourceServiceProvider = injector.getInstance(IResourceServiceProvider)
		return new IdeaLanguageAccess(
			outputConfigurationProvider.outputConfigurations.toSet,
			resourceServiceProvider,
			true
		)
	}

}
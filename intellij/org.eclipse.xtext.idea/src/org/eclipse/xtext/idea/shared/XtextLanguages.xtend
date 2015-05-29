/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.shared

import com.google.inject.Singleton
import java.util.Map
import org.apache.log4j.Logger
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceServiceProvider

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
class XtextLanguages {

	static val LOG = Logger.getLogger(XtextLanguages)
	
	Map<String, LanguageAccess> languageAccesses

	synchronized def getLanguageAccesses() {
		languageAccesses ?: (languageAccesses = createLanguageAccesses)
	}

	private def Map<String, LanguageAccess> createLanguageAccesses() {
		LOG.info("Initializing Xtext languages...")
		val result = newHashMap
		for (rsp : IResourceServiceProvider.Registry.INSTANCE.extensionToFactoryMap.values.filter(IResourceServiceProvider)) {
			val languageAccess = rsp.createLanguageAccess
			for (fileExtension : rsp.get(FileExtensionProvider).fileExtensions) {
				result.put(fileExtension, languageAccess)
			}
		}
		LOG.info("...done.")
		result
	}

	private def createLanguageAccess(IResourceServiceProvider resourceServiceProvider) {
		val outputConfigurationProvider = resourceServiceProvider.get(IOutputConfigurationProvider)
		return new LanguageAccess(
			outputConfigurationProvider.outputConfigurations.toSet,
			resourceServiceProvider,
			true
		)
	}

}
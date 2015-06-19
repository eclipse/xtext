package org.eclipse.xtext.java.resource

import com.google.inject.ConfigurationException
import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceServiceProvider

class JavaResourceServiceProvider implements IResourceServiceProvider {
	
	@Inject Injector injector
	@Inject FileExtensionProvider extensionProvider
	
	override canHandle(URI uri) {
		return extensionProvider.fileExtensions.contains(uri.fileExtension)
	}
	
	override <T> get(Class<T> t) {
		try {
			return injector.getInstance(t)
		} catch (ConfigurationException e) {
			return null
		}
	}
	
	override getContainerManager() {
		get(IContainer.Manager)
	}
	
	override getEncodingProvider() {
		get(IEncodingProvider)
	}
	
	override getResourceDescriptionManager() {
		get(IResourceDescription.Manager)
	}
	
	override getResourceValidator() {
		null
	}
	
}
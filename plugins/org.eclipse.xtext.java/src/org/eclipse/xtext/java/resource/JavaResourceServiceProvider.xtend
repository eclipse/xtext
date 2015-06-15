package org.eclipse.xtext.java.resource

import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.emf.common.util.URI
import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.validation.IResourceValidator

class JavaResourceServiceProvider implements IResourceServiceProvider {
	
	@Inject Injector injector
	
	override canHandle(URI uri) {
		return uri.fileExtension == 'java'
	}
	
	override <T> get(Class<T> t) {
		injector.getInstance(t)
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
		get(IResourceValidator)
	}
	
}
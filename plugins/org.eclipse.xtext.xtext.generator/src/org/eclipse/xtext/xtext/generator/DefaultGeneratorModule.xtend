/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Binder
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.service.AbstractGenericModule

class DefaultGeneratorModule extends AbstractGenericModule {
	
	@Accessors
	XtextProjectConfig project = new StandardProjectConfig
	
	@Accessors
	CodeConfig code = new CodeConfig
	
	protected def void checkConfiguration(Issues issues) {
		project.checkConfiguration(issues)
	}
	
	def void configureXtextProjectConfig(Binder binder) {
		binder.bind(IXtextProjectConfig).toInstance(project)
	}
	
	def void configureCodeConfig(Binder binder) {
		binder.bind(CodeConfig).toInstance(code)
	}
	
	def void configureResourceSet(Binder binder) {
		binder.bind(ResourceSet).to(XtextResourceSet)
	}
	
	def void configureIEncodingProvider(Binder binder) {
		binder.bind(IEncodingProvider).toInstance(new IEncodingProvider.Runtime => [
			defaultEncoding = code.encoding
		])
	}
	
}
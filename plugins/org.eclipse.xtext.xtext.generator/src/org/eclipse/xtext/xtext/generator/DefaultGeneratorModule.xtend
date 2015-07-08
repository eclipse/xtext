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
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.xtext.generator.model.CodeConfig
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.model.WizardConfig
import org.eclipse.xtext.xtext.generator.model.XtextProjectConfig

class DefaultGeneratorModule extends AbstractGenericModule {
	
	@Accessors(PUBLIC_SETTER)
	XtextProjectConfig project
	
	@Accessors(PUBLIC_SETTER)
	CodeConfig code
	
	def XtextProjectConfig getProject() {
		if (project === null)
			project = new WizardConfig
		return project
	}
	
	def CodeConfig getCode() {
		if (code === null)
			code = new CodeConfig
		return code
	}
	
	protected def void checkConfiguration(XtextGenerator generator, Issues issues) {
		getProject.checkConfiguration(generator, issues)
	}
	
	def void configureXtextProjectConfig(Binder binder) {
		binder.bind(IXtextProjectConfig).toInstance(getProject)
	}
	
	def void configureCodeConfig(Binder binder) {
		binder.bind(CodeConfig).toInstance(getCode)
	}
	
	def void configureResourceSet(Binder binder) {
		binder.bind(ResourceSet).to(XtextResourceSet)
	}
	
	def void configureIEncodingProvider(Binder binder) {
		binder.bind(IEncodingProvider).toInstance(new IEncodingProvider.Runtime => [
			defaultEncoding = getCode.encoding
		])
	}
	
}
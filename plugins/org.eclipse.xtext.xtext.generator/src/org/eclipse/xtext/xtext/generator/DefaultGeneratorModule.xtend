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
import org.eclipse.xtext.parser.EclipseProjectPropertiesEncodingProvider
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.xtext.generator.model.CodeConfig
import org.eclipse.xtext.xtext.generator.model.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.model.WizardConfig
import org.eclipse.xtext.xtext.generator.model.XtextProjectConfig

class DefaultGeneratorModule extends AbstractGenericModule {
	
	@Accessors
	XtextProjectConfig project
	
	@Accessors
	CodeConfig code
	
	protected def checkConfiguration(XtextGenerator generator, Issues issues) {
		if (project !== null) {
			project.checkConfiguration(generator, issues)
		}
	}
	
	def configureXtextProjectConfig(Binder binder) {
		if (project === null)
			project = new WizardConfig
		binder.bind(IXtextProjectConfig).toInstance(project)
	}
	
	def configureCodeConfig(Binder binder) {
		if (code === null)
			code = new CodeConfig
		binder.bind(CodeConfig).toInstance(code)
	}
	
	def configureResourceSet(Binder binder) {
		binder.bind(ResourceSet).toInstance(new XtextResourceSet)
	}
	
	def Class<? extends IEncodingProvider> bindIEncodingProvider() {
		EclipseProjectPropertiesEncodingProvider
	}
	
}
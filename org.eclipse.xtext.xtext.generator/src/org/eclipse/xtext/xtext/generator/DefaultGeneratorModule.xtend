/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Binder
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.formatting.ILineSeparatorInformation
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig
import org.eclipse.xtext.xtext.generator.model.project.XtextProjectConfig

/**
 * An instance of this module is assigned to the {@code configuration} property of
 * {@link XtextGenerator}. It contains the {@link XtextProjectConfig project configuration}
 * and the {@link CodeConfig code configuration}. If you need to configure more aspects of
 * the generator, create a subclass and bind your custom configuration classes. For example,
 * in order to adapt the {@link XtextGeneratorNaming naming} of the generated code, use
 * the following:
 * <pre>
 * class MyGeneratorModule extends DefaultGeneratorModule {
 *     def Class&lt;? extends XtextGeneratorNaming&gt; bindXtextGeneratorNaming() {
 *         MyGeneratorNaming
 *     }
 * }
 * </pre>
 */
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
	
	def void configureLineSeparatorInformation(Binder binder) {
		binder.bind(ILineSeparatorInformation).toInstance[code.lineDelimiter]
	}
	
	def void configureIEncodingProvider(Binder binder) {
		binder.bind(IEncodingProvider).toInstance(new IEncodingProvider.Runtime => [
			defaultEncoding = code.encoding
		])
	}
	
}

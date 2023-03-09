/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.XtextProjectConfig;

import com.google.inject.Binder;

/**
 * An instance of this module is assigned to the {@code configuration} property
 * of {@link XtextGenerator}. It contains the {@link XtextProjectConfig project
 * configuration} and the {@link CodeConfig code configuration}. If you need to
 * configure more aspects of the generator, create a subclass and bind your
 * custom configuration classes. For example, in order to adapt the
 * {@link XtextGeneratorNaming naming} of the generated code, use the following:
 * 
 * <pre>
 * class MyGeneratorModule extends DefaultGeneratorModule {
 *     def Class&lt;? extends XtextGeneratorNaming&gt; bindXtextGeneratorNaming() {
 *         MyGeneratorNaming
 *     }
 * }
 * </pre>
 */
public class DefaultGeneratorModule extends AbstractGenericModule {
	private XtextProjectConfig project = new StandardProjectConfig();

	private CodeConfig code = new CodeConfig();

	protected void checkConfiguration(Issues issues) {
		project.checkConfiguration(issues);
	}

	public void configureXtextProjectConfig(Binder binder) {
		binder.bind(IXtextProjectConfig.class).toInstance(project);
	}

	public void configureCodeConfig(Binder binder) {
		binder.bind(CodeConfig.class).toInstance(code);
	}

	public void configureResourceSet(Binder binder) {
		binder.bind(ResourceSet.class).to(XtextResourceSet.class);
	}

	public void configureLineSeparatorInformation(Binder binder) {
		binder.bind(ILineSeparatorInformation.class).toInstance(() -> code.getLineDelimiter());
	}

	public void configureIEncodingProvider(Binder binder) {
		IEncodingProvider.Runtime runtime = new IEncodingProvider.Runtime();
		runtime.setDefaultEncoding(code.getEncoding());
		binder.bind(IEncodingProvider.class).toInstance(runtime);
	}

	public XtextProjectConfig getProject() {
		return project;
	}

	public void setProject(XtextProjectConfig project) {
		this.project = project;
	}

	public CodeConfig getCode() {
		return code;
	}

	public void setCode(CodeConfig code) {
		this.code = code;
	}
}

/*******************************************************************************
 * Copyright (c) 2020 Jan Rosczak and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.maven;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Sets.newLinkedHashSet;

import java.util.List;
import java.util.Set;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.eclipse.xtext.ISetup;

/**
 * Generates sources of all contributing {@link ISetup} language instances
 * 
 * @author Jan Rosczak - Initial contribution and API
 */
@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES, requiresDependencyResolution = ResolutionScope.COMPILE, threadSafe = true)
public class XtextGenerateMojo extends AbstractXtextGeneratorMojo {

	/**
	 * Project classpath.
	 */
	@Parameter(defaultValue = "${project.compileClasspathElements}", readonly = true, required = true)
	private List<String> classpathElements;

	@Override
	public Set<String> getClasspathElements() {
		Set<String> classpathElements = newLinkedHashSet();
		classpathElements.addAll(this.classpathElements);
		classpathElements.remove(getClassOutputDirectory());
		classpathElements.remove(getProject().getBuild().getTestOutputDirectory());
		Set<String> nonEmptyElements = newLinkedHashSet(filter(classpathElements, emptyStringFilter()));
		return nonEmptyElements;
	}

	@Override
	protected void configureMavenOutputs() {
		for (Language language : getLanguages()) {
			addCompileSourceRoots(language);
		}
	}
	
	@Override
	protected String getClassOutputDirectory() {
		return getProject().getBuild().getOutputDirectory();
	}
	
	/**
	 * Project source roots. List of folders, where the source models are
	 * located.<br>
	 * The default value is a reference to the project's
	 * ${project.compileSourceRoots}.<br>
	 * When adding a new entry the default value will be overwritten not extended.
	 */
	@Parameter(defaultValue = "${project.compileSourceRoots}", required = true)
	private List<String> sourceRoots;

	@Override
	protected List<String> getSourceRoots() {
		return sourceRoots;
	}

}
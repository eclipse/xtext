/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.maven;

import java.io.File;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.eclipse.xtext.generator.OutputConfiguration;

/**
 * @since 2.26
 * @author Heinrich Weichert
 *
 */
public abstract class AbstractXtextMojo extends AbstractMojo {

	/**
	 * Lock object to ensure thread-safety
	 */
	protected static final Object lock = new Object();

	/**
	 * The project itself. This parameter is set by maven.
	 */
	@Parameter(defaultValue = "${project}", readonly = true, required = true)
	private MavenProject project;

	@Parameter(required = true)
	private List<Language> languages;

	public MavenProject getProject() {
		return project;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	/**
	 * Resolves the given relative file-path to an absolute File inside the project's base directory
	 * 
	 * @param path Relative file path
	 * @return File with an absolute path
	 */
	protected File resolveFilePath(String path) {
		File file = new File(path);
		if (!file.isAbsolute()) {
			file = new File(project.getBasedir(), path);
		}
		return file;
	}

	protected void addCompileSourceRoots(Language language) {
		if (language.getOutputConfigurations() == null) {
			return;
		}
		for (OutputConfiguration configuration : language.getOutputConfigurations()) {
			for (String output : configuration.getOutputDirectories()) {
				getLog().debug("Adding output folder " + output + " to compile roots");
				project.addCompileSourceRoot(output);
			}
		}
	}

	protected void addTestCompileSourceRoots(Language language) {
		if (language.getOutputConfigurations() == null) {
			return;
		}
		for (OutputConfiguration configuration : language.getOutputConfigurations()) {
			for (String output : configuration.getOutputDirectories()) {
				getLog().debug("Adding output folder " + output + " to test compile roots");
				project.addTestCompileSourceRoot(output);
			}
		}
	}

}
/*******************************************************************************
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import com.google.inject.Inject;

public abstract class AbstractXtendMojo extends AbstractMojo {

	private static final Object lock = new Object();

	@Inject
	protected MavenLog4JConfigurator log4jConfigurator;

	/**
	 * The project itself. This parameter is set by maven.
	 */
	@Parameter(property="project", required=true)
	protected MavenProject project;

	/**
	 * Set this to true to skip compiling Xtend sources.
	 */
	@Parameter(property="skipXtend", defaultValue="false")
	protected boolean skipXtend;

	public AbstractXtendMojo() {
		injectMembers();
	}

	public void execute() throws MojoExecutionException, MojoFailureException {
		if (isSkipped()) {
			getLog().info("skipped.");
		} else {
			synchronized(lock) {
				log4jConfigurator.configureLog4j(getLog());
				internalExecute();
			}
		}
	}

	protected void injectMembers() {
		new XtendMavenStandaloneSetup().createInjectorAndDoEMFRegistration().injectMembers(this);
	}

	protected abstract void internalExecute() throws MojoExecutionException, MojoFailureException;

	protected boolean isSkipped() {
		return skipXtend;
	}

}

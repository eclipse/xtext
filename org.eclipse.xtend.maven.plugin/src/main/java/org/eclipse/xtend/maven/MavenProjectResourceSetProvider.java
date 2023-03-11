/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.maven;

import org.apache.maven.project.MavenProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt
 */
public class MavenProjectResourceSetProvider implements Provider<ResourceSet> {

	private MavenProject project;

	public MavenProjectResourceSetProvider(MavenProject project) {
		super();
		this.project = project;
	}

	public ResourceSet get() {
		ResourceSet rs = new XtextResourceSet();
		MavenProjectAdapter.install(rs, project);
		return rs;
	}
}

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
import org.eclipse.xtext.common.types.xtext.AbstractProjectAwareResourceDescriptionsProvider;

public class MavenProjectAwareResourceDescriptionsProvider extends AbstractProjectAwareResourceDescriptionsProvider {

	@Override
	protected String getProjectName(ResourceSet resourceSet) {
		MavenProject mavenProject = MavenProjectAdapter.get(resourceSet);
		return mavenProject.getBasedir().getName();
	}

}

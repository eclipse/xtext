/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.ui.resource.ProjectByResourceProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public class JdtAwareProjectByResourceProvider extends ProjectByResourceProvider {

	@Inject
	private IJavaProjectProvider javaProjectProvider;
	
	@Override
	public IProject getProjectContext(Resource resource) {
		IProject result = super.getProjectContext(resource);
		if (result != null) {
			return result;
		}
		IJavaProject javaProject = javaProjectProvider.getJavaProject(resource.getResourceSet());
		if (javaProject != null && javaProject.exists()) {
			return javaProject.getProject();
		}
		return null;
	}
	
}

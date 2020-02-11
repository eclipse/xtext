/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.xtext.ui;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.xtext.AbstractProjectAwareResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

/**
 * This specialization of the {@link ResourceDescriptionsProvider} filters locally defined elements from the resource descriptions that are
 * made available during the indexing phase.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public class ProjectAwareResourceDescriptionsProvider extends AbstractProjectAwareResourceDescriptionsProvider {
	@Inject
	private IJavaProjectProvider projectProvider;

	@Override
	protected String getProjectName(ResourceSet resourceSet) {
		final IJavaProject javaProject = projectProvider.getJavaProject(resourceSet);
		if (javaProject != null) {
			return javaProject.getElementName();
		}
		return null;
	}
}

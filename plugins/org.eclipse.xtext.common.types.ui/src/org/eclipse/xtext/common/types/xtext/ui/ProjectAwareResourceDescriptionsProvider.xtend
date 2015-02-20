/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.xtext.common.types.xtext.AbstractProjectAwareResourceDescriptionsProvider
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider

/**
 * This specialization of the {@link ResourceDescriptionsProvider} filters
 * locally defined elements from the resource descriptions that are made available
 * during the indexing phase.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
class ProjectAwareResourceDescriptionsProvider extends AbstractProjectAwareResourceDescriptionsProvider {
	
	@Inject IJavaProjectProvider projectProvider
	
	override protected getProjectName(ResourceSet resourceSet) {
		val javaProject = projectProvider.getJavaProject(resourceSet)
		return javaProject?.elementName
	}
}

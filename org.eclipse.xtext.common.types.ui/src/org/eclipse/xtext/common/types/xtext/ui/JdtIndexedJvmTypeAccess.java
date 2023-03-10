/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.containers.JavaProjectsState;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsState;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noreference This class is not intended to be referenced by clients.
 */
public class JdtIndexedJvmTypeAccess extends IndexedJvmTypeAccess {

	@Inject
	private IJavaProjectProvider javaProjectProvider;
	
	@Inject
	private JavaProjectsState javaProjectsState;
	
	@Inject
	private WorkspaceProjectsState plainProjectsState;
	
	@Override
	protected EObject findAccessibleType(String fragment, ResourceSet resourceSet,
			Iterator<IEObjectDescription> fromIndex) throws UnknownNestedTypeException {
		// we know that the iterator is not empty thus we can directly obtain the handles et al without additional guards
		IJavaProject javaProject = javaProjectProvider.getJavaProject(resourceSet);
		List<String> allVisibleContainerHandles = Lists.newArrayList(javaProjectsState.getVisibleContainerHandles(javaProject.getHandleIdentifier()));
		// some models are not in source folders thus we also use the WorkspaceProjectsState (e.g. relevant for Xcore)
		allVisibleContainerHandles.addAll(plainProjectsState.getVisibleContainerHandles(javaProject.getElementName()));
		List<String> visibleContainerHandles = allVisibleContainerHandles;
		IEObjectDescription bestDescription = null;
		while(fromIndex.hasNext() && !visibleContainerHandles.isEmpty()) {
			// find the description that is the best match, e.g. the one that is in the container closest to the first
			IEObjectDescription description = fromIndex.next();
			URI trimFragment = description.getEObjectURI().trimFragment();
			String handle = javaProjectsState.getContainerHandle(trimFragment);
			int idx = visibleContainerHandles.indexOf(handle);
			if (idx >= 0) {
				bestDescription = description;
				// reduce the search scope - only check containers that are better than the current
				visibleContainerHandles = allVisibleContainerHandles.subList(0, idx);
			}
		}
		if (bestDescription != null) {
			return getAccessibleType(bestDescription, fragment, resourceSet);
		}
		return null;
	}
	
}

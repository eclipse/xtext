/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
	@Override
	protected EObject findAccessibleType(String fragment, ResourceSet resourceSet,
			Iterator<IEObjectDescription> fromIndex) {
		// we know that the iterator is not empty thus we can directly obtain the handles et al without additional guards
		IJavaProject javaProject = javaProjectProvider.getJavaProject(resourceSet);
		List<String> visibleContainerHandles = javaProjectsState.getVisibleContainerHandles(javaProject.getHandleIdentifier());
		while(fromIndex.hasNext()) {
			IEObjectDescription description = fromIndex.next();
			URI trimFragment = description.getEObjectURI().trimFragment();
			String handle = javaProjectsState.getContainerHandle(trimFragment);
			if (visibleContainerHandles.contains(handle)) {
				return getAccessibleType(description, fragment, resourceSet);
			}
		}
		return null;
	}
	
}

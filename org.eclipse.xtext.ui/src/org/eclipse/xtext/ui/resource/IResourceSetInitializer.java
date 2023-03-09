/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.shared.contribution.SharedStateContribution;

import com.google.common.annotations.Beta;

/**
 * An initializer may configure the resource set according to the
 * specific semantics of the project. These initializers have to be
 * registered as a {@link SharedStateContribution} to participate
 * in the initialization of a resource set that is produced by the
 * builder, other languages or some other client of the {@link IResourceSetProvider}.
 * 
 * Clients may choose to implement the interface and use it for their
 * own purpose but usually its recommend to use a dedicated protocol or 
 * implementation for custom initialization logic.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 */
@Beta
public interface IResourceSetInitializer {

	/**
	 * Initializes the resource set in the context of the given project.
	 * If the resource set is an {@link XtextResourceSet}, the implementor
	 * may choose the set the {@link XtextResourceSet#setClasspathURIContext(Object) classpath context}.
	 * Clients should be careful to not override the settings of other clients, though.
	 */
	void initialize(ResourceSet resourceSet, IProject project);
	
}

/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.annotations.Beta;

/**
 * An initializer may configure the resource set according to the
 * specific semantics of the project.
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

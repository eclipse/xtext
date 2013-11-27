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

/**
 * TODO Javadoc
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 */
public interface IResourceSetInitializer {

	void initialize(ResourceSet resourceSet, IProject project);
	
}

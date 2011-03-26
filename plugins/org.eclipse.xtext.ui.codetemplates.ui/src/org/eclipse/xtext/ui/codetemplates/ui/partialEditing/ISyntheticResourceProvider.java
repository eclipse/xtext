/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.partialEditing;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codetemplates.ui.preferences.SyntheticResourceProvider;

import com.google.inject.ImplementedBy;

/**
 * The {@link ISyntheticResourceProvider} creates a resource that is not backed
 * up by an {@link org.eclipse.core.resources.IResource IResource} but may be
 * used on its own. The created resource will be contained in a newly created
 * {@link org.eclipse.xtext.resource.XtextResourceSet resource set}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(SyntheticResourceProvider.class)
public interface ISyntheticResourceProvider {
	
	/**
	 * Create a new resource. Implementors are free to decide whether the resource
	 * should be empty or whether its pre-populated with content. The resource has
	 * to be contained in a new resource set.
	 * @return a new resource that is contained in a new resource set.
	 */
	XtextResource createResource();
}
/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import org.eclipse.xtext.resource.XtextResource;

/**
 * The {@link IEditedResourceProvider} returns a new resource that is not necessarily 
 * backed up by an {@link org.eclipse.core.resources.IResource IResource}. The 
 * created resource has to be contained in a fully configured
 * {@link org.eclipse.xtext.resource.XtextResourceSet resource set}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.2
 */
public interface IEditedResourceProvider {

	/**
	 * Create a new resource. Implementors are free to decide whether the resource
	 * should be empty or whether its pre-populated with content. The resource has
	 * to be contained in a fully configured resource set.
	 * @return a new resource that is contained in a resource set.
	 */
	XtextResource createResource();
}
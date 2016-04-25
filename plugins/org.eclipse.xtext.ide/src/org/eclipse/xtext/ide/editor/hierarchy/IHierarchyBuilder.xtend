/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.hierarchy

import java.util.Collection
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.common.util.URI

/**
 * This class is used to build a hierarchy structure.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
interface IHierarchyBuilder {

	/**
	 * @returns root hierarchy nodes for the given URI; empty if the hierarchy cannot be built for the given URI
	 */
	def Collection<IHierarchyNode> buildRoots(URI rootURI, IProgressMonitor monitor)

	/**
	 * @returns child nodes for the given parent node; empty if {@link IHierarchyNode#mayHaveChildren} returns <code>false</code> for the parent 
	 */
	def Collection<IHierarchyNode> buildChildren(IHierarchyNode parent, IProgressMonitor monitor)

}

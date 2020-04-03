/*******************************************************************************
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.hierarchy;

import java.util.Collection;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

/**
 * This class is used to build a hierarchy structure.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public interface IHierarchyBuilder {

	/**
	 * @return root hierarchy nodes for the given URI; empty if the hierarchy cannot be built for the given URI
	 */
	Collection<IHierarchyNode> buildRoots(URI rootURI, IProgressMonitor monitor);

	/**
	 * @return child nodes for the given parent node; empty if {@link IHierarchyNode#mayHaveChildren} returns <code>false</code> for the parent 
	 */
	Collection<IHierarchyNode> buildChildren(IHierarchyNode parent, IProgressMonitor monitor);

}

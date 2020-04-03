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

import org.eclipse.xtext.ide.editor.navigation.INavigatable;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * Represents a hierarchy node.
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public interface IHierarchyNode extends INavigatable {
	/**
	 * @return an associated element that is used to build child nodes
	 */
	IEObjectDescription getElement();

	/**
	 * @return a parent; <code>null</code> if the node is a root
	 */
	IHierarchyNode getParent();

	/**
	 * @return references used to reach the node from a parent; empty if the node is a root
	 */
	Collection<IHierarchyNodeReference> getReferences();

	/**
	 * @return whether there is a parent (can be transitive) containing the same element as the node
	 */
	boolean isRecursive();

	/**
	 * @return whether the node may have children; e.g. a recursive node cannot have children
	 */
	boolean mayHaveChildren();
}

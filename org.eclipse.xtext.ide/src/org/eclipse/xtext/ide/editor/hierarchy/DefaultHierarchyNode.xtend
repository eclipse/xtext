/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.hierarchy

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.util.Wrapper

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
class DefaultHierarchyNode implements IHierarchyNode {

	@Accessors
	IHierarchyNode parent

	@Accessors(PUBLIC_SETTER)
	boolean mayHaveChildren

	@Accessors
	IEObjectDescription element

	@Accessors(PUBLIC_GETTER)
	val List<IHierarchyNodeReference> references = <IHierarchyNodeReference>newArrayList

	Wrapper<Boolean> recursive

	override getNavigationElement() {
		return references.head ?: element
	}

	override boolean isRecursive() {
		if (recursive === null)
			recursive = Wrapper.wrap(internalIsRecursive)
		return recursive.get
	}

	protected def boolean internalIsRecursive() {
		var node = parent
		while (node !== null) {
			if (node.element.EObjectURI == element.EObjectURI)
				return true
			node = node.parent
		}
		return false
	}

	override mayHaveChildren() {
		mayHaveChildren
	}

}

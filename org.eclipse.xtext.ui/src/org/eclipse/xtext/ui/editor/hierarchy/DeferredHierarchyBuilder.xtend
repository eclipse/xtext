/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import org.eclipse.core.runtime.IAdaptable
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.ui.progress.IDeferredWorkbenchAdapter
import org.eclipse.ui.progress.IElementCollector
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
class DeferredHierarchyBuilder implements IHierarchyBuilder {

	@Accessors
	IHierarchyBuilder hierarchyBuilder

	override buildRoots(URI rootURI, IProgressMonitor monitor) {
		hierarchyBuilder.buildRoots(rootURI, monitor).map[defer].filterNull.toList
	}

	override buildChildren(IHierarchyNode node, IProgressMonitor monitor) {
		hierarchyBuilder.buildChildren(node, monitor).map[defer].filterNull.toList
	}

	protected def IHierarchyNode defer(IHierarchyNode node) {
		if (node !== null)
			new DeferredHierarchyNode(node, this)
	}

	@FinalFieldsConstructor
	static class DeferredHierarchyNode implements IAdaptable, IDeferredWorkbenchAdapter, IHierarchyNode {

		@Delegate
		@Accessors
		val IHierarchyNode delegate
		extension val IHierarchyBuilder hierarchyBuilder

		override getAdapter(Class adapterType) {
			if (adapterType.isInstance(this))
				return this
		}

		override fetchDeferredChildren(Object object, IElementCollector collector, IProgressMonitor monitor) {
			val IHierarchyNode[] children = delegate.buildChildren(monitor)
			collector.add(children, monitor)
			collector.done
		}

		override getRule(Object object) {
			null
		}

		override isContainer() {
			return delegate.mayHaveChildren
		}

		override getChildren(Object o) {
			#[]
		}

		override getImageDescriptor(Object object) {
			null
		}

		override getLabel(Object o) {
			null
		}

		override getParent(Object o) {
			null
		}

	}

}

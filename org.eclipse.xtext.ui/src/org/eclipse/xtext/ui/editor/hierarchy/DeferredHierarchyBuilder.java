/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.progress.IDeferredWorkbenchAdapter;
import org.eclipse.ui.progress.IElementCollector;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeReference;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class DeferredHierarchyBuilder implements IHierarchyBuilder {

	public static class DeferredHierarchyNode implements IAdaptable, IDeferredWorkbenchAdapter, IHierarchyNode {

		private final IHierarchyNode delegate;

		private final IHierarchyBuilder hierarchyBuilder;

		public DeferredHierarchyNode(IHierarchyNode delegate, IHierarchyBuilder hierarchyBuilder) {
			this.delegate = delegate;
			this.hierarchyBuilder = hierarchyBuilder;
		}

		@Override
		public <T extends Object> T getAdapter(Class<T> adapterType) {
			if (adapterType.isInstance(this)) {
				return adapterType.cast(this);
			}
			return null;
		}

		@Override
		public void fetchDeferredChildren(Object object, IElementCollector collector, IProgressMonitor monitor) {
			IHierarchyNode[] children = hierarchyBuilder.buildChildren(delegate, monitor).toArray(new IHierarchyNode[0]);
			collector.add(children, monitor);
			collector.done();
		}

		@Override
		public ISchedulingRule getRule(Object object) {
			return null;
		}

		@Override
		public boolean isContainer() {
			return delegate.mayHaveChildren();
		}

		@Override
		public Object[] getChildren(Object o) {
			return new Object[] {};
		}

		@Override
		public ImageDescriptor getImageDescriptor(Object object) {
			return null;
		}

		@Override
		public String getLabel(Object o) {
			return null;
		}

		@Override
		public Object getParent(Object o) {
			return null;
		}

		public IHierarchyNode getDelegate() {
			return delegate;
		}

		@Override
		public IEObjectDescription getElement() {
			return delegate.getElement();
		}

		@Override
		public Object getNavigationElement() {
			return delegate.getNavigationElement();
		}

		@Override
		public IHierarchyNode getParent() {
			return delegate.getParent();
		}

		@Override
		public Collection<IHierarchyNodeReference> getReferences() {
			return delegate.getReferences();
		}

		@Override
		public boolean isRecursive() {
			return delegate.isRecursive();
		}

		@Override
		public boolean mayHaveChildren() {
			return delegate.mayHaveChildren();
		}
	}

	private IHierarchyBuilder hierarchyBuilder;

	public void setHierarchyBuilder(IHierarchyBuilder hierarchyBuilder) {
		this.hierarchyBuilder = hierarchyBuilder;
	}

	@Override
	public Collection<IHierarchyNode> buildRoots(URI rootURI, IProgressMonitor monitor) {
		return hierarchyBuilder.buildRoots(rootURI, monitor) //
				.stream() //
				.map(node -> defer(node)) //
				.filter(Objects::nonNull) //
				.collect(Collectors.toList());
	}

	@Override
	public Collection<IHierarchyNode> buildChildren(IHierarchyNode hierarchyNode, IProgressMonitor monitor) {
		return hierarchyBuilder.buildChildren(hierarchyNode, monitor) //
				.stream() //
				.map(node -> defer(node)) //
				.filter(Objects::nonNull) //
				.collect(Collectors.toList());
	}

	protected IHierarchyNode defer(IHierarchyNode node) {
		return node != null ? new DeferredHierarchyNode(node, this) : null;
	}

	public IHierarchyBuilder getHierarchyBuilder() {
		return hierarchyBuilder;
	}
}

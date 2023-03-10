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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyRoot;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyRoot;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public abstract class AbstractHierarchyViewPart extends ViewPart {

	private IHierarchyBuilder builder;

	private URI rootURI;

	public void refresh(IProgressMonitor monitor) {
		setRoot(createRoot(monitor));
	}

	protected IHierarchyRoot createRoot(IProgressMonitor monitor) {
		if (builder == null || rootURI == null)
			return IHierarchyRoot.EMPTY;

		Collection<IHierarchyNode> roots = builder.buildRoots(rootURI, monitor);
		if (roots.isEmpty()) {
			return IHierarchyRoot.EMPTY;
		}

		DefaultHierarchyRoot root = new DefaultHierarchyRoot();
		root.getRoots().addAll(roots);
		return root;
	}

	protected abstract void setRoot(IHierarchyRoot root);

	protected IHierarchyNode getSelectedNode(ISelection selection) {
		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
			Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
			if (selectedElement instanceof IHierarchyNode) {
				return (IHierarchyNode) selectedElement;
			}
		}
		return null;
	}

	protected <T extends IHierarchyBuilder> T getBuilder(Class<T> clazz) {
		if (clazz.isInstance(builder)) {
			return clazz.cast(builder);
		}

		if (builder instanceof DeferredHierarchyBuilder) {
			IHierarchyBuilder wrappedBuilder = ((DeferredHierarchyBuilder) builder).getHierarchyBuilder();
			if (clazz.isInstance(wrappedBuilder)) {
				return clazz.cast(wrappedBuilder);
			}
		}
		return null;
	}

	protected IHierarchyBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(IHierarchyBuilder builder) {
		this.builder = builder;
	}

	protected URI getRootURI() {
		return rootURI;
	}

	public void setRootURI(URI rootURI) {
		this.rootURI = rootURI;
	}
}

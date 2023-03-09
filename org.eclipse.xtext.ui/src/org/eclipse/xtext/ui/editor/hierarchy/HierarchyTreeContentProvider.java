/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import java.util.Objects;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.DeferredTreeContentManager;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyRoot;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class HierarchyTreeContentProvider implements ITreeContentProvider {

	private static final Object[] EMPTY_ARRAY = {};

	private final ViewPart viewPart;

	private DeferredTreeContentManager deferredTreeContentManager;

	public HierarchyTreeContentProvider(ViewPart viewPart) {
		this.viewPart = viewPart;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] children = deferredTreeContentManager.getChildren(parentElement);
		return children != null ? children : EMPTY_ARRAY;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof IHierarchyRoot) {
			return ((IHierarchyRoot) inputElement).getRoots().stream().filter(Objects::nonNull).toArray();
		}
		return EMPTY_ARRAY;
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof IHierarchyNode) {
			return ((IHierarchyNode) element).getParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return deferredTreeContentManager.mayHaveChildren(element);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (viewer instanceof AbstractTreeViewer) {
			deferredTreeContentManager = new DeferredTreeContentManager((AbstractTreeViewer) viewer, viewPart.getSite());
		}
	}
}

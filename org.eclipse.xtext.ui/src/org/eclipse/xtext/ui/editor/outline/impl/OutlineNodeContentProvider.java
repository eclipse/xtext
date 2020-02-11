/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * The JFace/SWT content provider. The tree of visible IOutlineNodes has already been pre-computed.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineNodeContentProvider implements ITreeContentProvider {

	private OutlineFilterAndSorter filterSorter;

	/**
	 * @since 2.2
	 */
	public void setFilterAndSorter(OutlineFilterAndSorter filterSorter) {
		this.filterSorter = filterSorter;
	}
	
	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		Assert.isLegal(newInput == null || newInput instanceof IOutlineNode);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return filterSorter.filterAndSort(asOutlineNode(parentElement).getChildren());
	}

	@Override
	public Object getParent(Object element) {
		return asOutlineNode(element).getParent();
	}

	@Override
	public boolean hasChildren(Object element) {
		return asOutlineNode(element).hasChildren();
	}

	protected IOutlineNode asOutlineNode(Object element) {
		Assert.isLegal(element instanceof IOutlineNode);
		return (IOutlineNode) element;
	}

}

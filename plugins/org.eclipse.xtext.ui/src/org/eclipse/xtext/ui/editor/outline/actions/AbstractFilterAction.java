/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author koehnlein - Initial contribution and API
 */
public abstract class AbstractFilterAction extends AbstractToggleAction {

	private TreeViewer treeViewer;

	private ViewerFilter viewerFilter;
	
	protected ViewerFilter getViewerFilter() {
		if(viewerFilter == null)
			viewerFilter = createViewerFilter();
		return viewerFilter;
	}
	
	protected abstract ViewerFilter createViewerFilter();

	@Override
	public void activate(OutlinePage outlinePage) {
		treeViewer = outlinePage.getTreeViewer();
		super.activate(outlinePage);
	}
	
	@Override
	protected void stateChanged(boolean newState) {
		List<ViewerFilter> filters = Lists.newArrayList();
		filters.addAll(Arrays.asList(treeViewer.getFilters()));
		if(newState)
			filters.add(getViewerFilter());
		else 
			filters.remove(getViewerFilter());
		treeViewer.setFilters(Iterables.toArray(filters, ViewerFilter.class));
	}
}

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.jface.viewers.StructuredSelection;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FilterContributionTest extends AbstractOutlineWorkbenchTest {

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		setFiltering(false);
	}
	
	@Test public void testFilterOutline() {
		treeViewer.expandAll();
		setFiltering(false);
		assertEquals(1, treeViewer.getTree().getItemCount());
		assertSame(modelNode, treeViewer.getTree().getItem(0));
		assertEquals(2, treeViewer.getTree().getItem(0).getItemCount());
		assertSame(oneNode, treeViewer.getTree().getItem(0).getItem(0));
		assertSame(fourNode, treeViewer.getTree().getItem(0).getItem(1));
		assertEquals(2, treeViewer.getTree().getItem(0).getItem(0).getItemCount());
		assertSame(twoNode, treeViewer.getTree().getItem(0).getItem(0).getItem(0));
		assertSame(threeNode, treeViewer.getTree().getItem(0).getItem(0).getItem(1));

		setFiltering(true);
		treeViewer.expandAll();
		assertEquals(1, treeViewer.getTree().getItemCount());
		assertSame(modelNode, treeViewer.getTree().getItem(0));
		assertEquals(1, treeViewer.getTree().getItem(0).getItemCount());
		assertSame(oneNode, treeViewer.getTree().getItem(0).getItem(0));
		assertEquals(1, treeViewer.getTree().getItem(0).getItem(0).getItemCount());
		assertSame(twoNode, treeViewer.getTree().getItem(0).getItem(0).getItem(0));
	}
	
	@Test public void testFilteringPreservesExpansionAndSelection() throws Exception {
		treeViewer.setExpandedElements(new Object[] {modelNode});
		treeViewer.setSelection(new StructuredSelection(oneNode));
		setFiltering(true);
		assertExpanded(treeViewer, modelNode);
		assertSelected(treeViewer, oneNode);
	}
	
	protected void setFiltering(boolean isFiltering) {
		preferenceStore.setValue(SampleFilterContribution.PREFERENCE_KEY, isFiltering);
	}
}

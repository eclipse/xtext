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
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SortContributionTest extends AbstractOutlineWorkbenchTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		setSorting(preferenceStore.getDefaultBoolean(SortOutlineContribution.PREFERENCE_KEY));
	}

	@Test public void testNoSort() throws Exception {
		setSorting(false);
		outlinePage.resetSyncer();
		treeViewer.expandAll();
		outlinePage.scheduleRefresh();
		outlinePage.waitForUpdate(ERROR_TIMEOUT);
		TreeItem[] rootItems = treeViewer.getTree().getItems();
		assertEquals(1, treeViewer.getTree().getItemCount());
		assertSame(modelNode, rootItems[0]);
		assertEquals(2, rootItems[0].getItemCount());
		TreeItem[] firstLevelItems = rootItems[0].getItems();
		assertSame(oneNode, firstLevelItems[0]);
		assertSame(fourNode, firstLevelItems[1]);
		assertEquals(2, firstLevelItems[0].getItemCount());
		TreeItem[] secondLevelItems = firstLevelItems[0].getItems();
		assertSame(twoNode, secondLevelItems[0]);
		assertSame(threeNode, secondLevelItems[1]);
	}

	@Test public void testSort() throws Exception {
		setSorting(true);
		outlinePage.resetSyncer();
		treeViewer.expandAll();
		outlinePage.scheduleRefresh();
		outlinePage.waitForUpdate(ERROR_TIMEOUT);

		TreeItem[] rootItems = treeViewer.getTree().getItems();
		assertEquals(1, treeViewer.getTree().getItemCount());
		assertSame(modelNode, rootItems[0]);
		assertEquals(2, rootItems[0].getItemCount());
		TreeItem[] firstLevelItems = rootItems[0].getItems();
		assertSame(fourNode, firstLevelItems[0]);
		assertSame(oneNode, firstLevelItems[1]);
		assertEquals(2, firstLevelItems[1].getItemCount());
		TreeItem[] secondLevelItems = firstLevelItems[1].getItems();
		assertSame(threeNode, secondLevelItems[0]);
		assertSame(twoNode, secondLevelItems[1]);
	}

	@Test public void testSortingPreservesSelectionAndExpansion() throws Exception {
		setSorting(false);
		outlinePage.resetSyncer();
		treeViewer.setExpandedElements(new Object[] { modelNode });
		treeViewer.setSelection(new StructuredSelection(fourNode));
		outlinePage.scheduleRefresh();
		outlinePage.waitForUpdate(ERROR_TIMEOUT);

		setSorting(true);
		outlinePage.resetSyncer();
		outlinePage.scheduleRefresh();
		outlinePage.waitForUpdate(ERROR_TIMEOUT);

		assertExpanded(treeViewer, modelNode);
		assertSelected(treeViewer, fourNode);
	}

	protected void setSorting(boolean isSorting) {
		preferenceStore.setValue(SortOutlineContribution.PREFERENCE_KEY, isSorting);
	}

}

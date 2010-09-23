/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.ToggleSortingAction;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineNodeComparer;

/**
 * @author koehnlein - Initial contribution and API
 */
public class SortOutlineTest extends AbstractOutlineUITest {

	protected IOutlineNodeComparer comparer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		comparer = new IOutlineNodeComparer.Default();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		preferenceStore.setValue(ToggleSortingAction.PREFERENCE_KEY,
				preferenceStore.getDefaultBoolean(ToggleSortingAction.PREFERENCE_KEY));
	}

	public void testNoSort() throws Exception {
		preferenceStore.setValue(ToggleSortingAction.PREFERENCE_KEY, false);
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

	public void testSort() throws Exception {
		preferenceStore.setValue(ToggleSortingAction.PREFERENCE_KEY, true);
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
	
	public void testSortingPreservesSelectionAndExpansion() throws Exception {
		preferenceStore.setValue(ToggleSortingAction.PREFERENCE_KEY, false);
		outlinePage.resetSyncer();
		treeViewer.setExpandedElements(new Object[] { modelNode });
		treeViewer.setSelection(new StructuredSelection(fourNode));
		outlinePage.scheduleRefresh();
		outlinePage.waitForUpdate(ERROR_TIMEOUT);
		
		preferenceStore.setValue(ToggleSortingAction.PREFERENCE_KEY, true);
		outlinePage.resetSyncer();
		outlinePage.scheduleRefresh();
		outlinePage.waitForUpdate(ERROR_TIMEOUT);

		assertExpanded(treeViewer, modelNode);
		assertSelected(treeViewer, fourNode);
	}

	protected void assertSame(IOutlineNode node, TreeItem treeItem) {
		assertTrue(treeItem.getData() instanceof IOutlineNode);
		assertTrue(comparer.equals(node, (IOutlineNode) treeItem.getData()));
	}
}

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
public class PreserveExpansionAndSelectionTest extends AbstractOutlineWorkbenchTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		treeViewer.setExpandedElements(new Object[] { modelNode, oneNode });
		treeViewer.setSelection(new StructuredSelection(fourNode));
		assertSelected(treeViewer, fourNode);
		assertExpanded(treeViewer, modelNode, oneNode);
	}

	@Test public void testChangeOtherNode() throws Exception {
		outlinePage.resetSyncer();
		document.replace(modelAsText.indexOf("two"), 3, "T");
		outlinePage.waitForUpdate(ERROR_TIMEOUT);
		assertSelected(treeViewer, fourNode);
		assertExpanded(treeViewer, modelNode, oneNode);
	}
	
	@Test public void testChangeSelection() throws Exception {
		outlinePage.resetSyncer();
		document.replace(modelAsText.indexOf("four"), 4, "F");
		outlinePage.waitForUpdate(ERROR_TIMEOUT);
		assertSelected(treeViewer);
		assertExpanded(treeViewer, modelNode, oneNode);
	}
	
	@Test public void testInsertBefore() throws Exception {
		outlinePage.resetSyncer();
		document.replace(modelAsText.indexOf("four"), 0, "threeAndHalf{} ");
		outlinePage.waitForUpdate(ERROR_TIMEOUT);
		assertSelected(treeViewer, fourNode);
		assertExpanded(treeViewer, modelNode, oneNode);
	}
	
	@Test public void testAppend() throws Exception {
		outlinePage.resetSyncer();
		document.replace(document.getLength(), 0, " five{}");
		outlinePage.waitForUpdate(ERROR_TIMEOUT);
		assertSelected(treeViewer, fourNode);
		assertExpanded(treeViewer, modelNode, oneNode);
	}
}

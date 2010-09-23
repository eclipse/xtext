/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.jface.viewers.StructuredSelection;

/**
 * @author koehnlein - Initial contribution and API
 */
public class PreserveExpansionAndSelectionTest extends AbstractOutlineUITest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		treeViewer.setExpandedElements(new Object[] { modelNode, oneNode });
		treeViewer.setSelection(new StructuredSelection(fourNode));
		assertSelected(treeViewer, fourNode);
		assertExpanded(treeViewer, modelNode, oneNode);
	}

	public void testChangeOtherNode() throws Exception {
		outlinePage.resetSyncer();
		document.replace(modelAsText.indexOf("two"), 3, "T");
		outlinePage.waitForUpdate(ERROR_TIMEOUT);
		assertSelected(treeViewer, fourNode);
		assertExpanded(treeViewer, modelNode, oneNode);
	}
	
	public void testChangeSelection() throws Exception {
		outlinePage.resetSyncer();
		document.replace(modelAsText.indexOf("four"), 4, "F");
		outlinePage.waitForUpdate(ERROR_TIMEOUT);
		assertSelected(treeViewer);
		assertExpanded(treeViewer, modelNode, oneNode);
	}
	
	public void testInsertBefore() throws Exception {
		outlinePage.resetSyncer();
		document.replace(modelAsText.indexOf("four"), 0, "threeAndHalf{} ");
		outlinePage.waitForUpdate(ERROR_TIMEOUT);
		assertSelected(treeViewer, fourNode);
		assertExpanded(treeViewer, modelNode, oneNode);
	}
	
	public void testAppend() throws Exception {
		outlinePage.resetSyncer();
		document.replace(document.getLength(), 0, " five{}");
		outlinePage.waitForUpdate(ERROR_TIMEOUT);
		assertSelected(treeViewer, fourNode);
		assertExpanded(treeViewer, modelNode, oneNode);
	}
}

/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.junit.Test;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class Bug379500Test extends AbstractOutlineWorkbenchTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		// We open a second Editor. Due to bug 379500 a singelton of
		// org.eclipse.xtext.ui.editor.outline.actions.IOutlineContribution.Composite
		// was used, so all outline actions only worked for the last recent opened editor.
		String modelAsText2 = "one { x {} y {} } z {}";
		IFile file2 = IResourcesSetupUtil.createFile("test/Bug379500Test.outlinetestlanguage", modelAsText2);
		openEditor(file2);
	}

	@Test
	public void testOutlineContribution() {
		// Now we focus the editor opened in the super class and hope
		// the filter action still works here.
		editor.getEditorSite().getPage().activate(editor);
		assertEquals("First opened editor doesn't became active", editor, editor.getEditorSite().getPage()
				.getActiveEditor());
		treeViewer.expandAll();

		setFiltering(false);
		// Without filter there should be two items
		assertEquals("Initially the tree view should contain two items. Check your test setUp.", 2, treeViewer
				.getTree().getItem(0).getItemCount());

		setFiltering(true);
		treeViewer.expandAll();
		// With a working filter there should be only one items
		assertEquals("Filter action does not work.", 1, treeViewer.getTree().getItem(0).getItemCount());
	}

	protected void setFiltering(boolean isFiltering) {
		preferenceStore.setValue(SampleFilterContribution.PREFERENCE_KEY, isFiltering);
	}
}

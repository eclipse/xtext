/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.tests.editor.outline.outlineTest.Model;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineSynchronisationTest extends AbstractOutlineWorkbenchTest {

	@Test
	@Ignore("Fails on CI Server with - TimeoutException: Timeout in Syncer")
	public void testRenameFile() throws Exception {
		IPath newPath = file.getFullPath().removeLastSegments(1).append("_new")
				.addFileExtension(file.getFileExtension());
		outlinePage.resetSyncer();
		file.move(newPath, true, null);
		outlinePage.waitForUpdate(ERROR_TIMEOUT);  // <= fails here
		assertFirstNodeName("one");

		outlinePage.resetSyncer();
		editor.getDocument().modify(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				((Model) state.getContents().get(0)).getElements().get(0).setName("new_one");
			}
		});
		outlinePage.waitForUpdate(ERROR_TIMEOUT);
		assertFirstNodeName("new_one");
	}

	protected void assertFirstNodeName(String firstNodeName) {
		Object input = treeViewer.getInput();
		assertTrue(input instanceof IOutlineNode);
		IOutlineNode node = ((IOutlineNode) input).getChildren().get(0).getChildren().get(0);
		assertEquals(firstNodeName, node.getText().toString());
	}

}

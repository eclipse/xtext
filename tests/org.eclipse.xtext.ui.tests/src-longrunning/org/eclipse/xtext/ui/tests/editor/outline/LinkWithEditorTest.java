/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import java.util.concurrent.TimeoutException;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.LinkWithEditorOutlineContribution;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class LinkWithEditorTest extends AbstractOutlineWorkbenchTest {

	private SyncingSelectionListener selectionSyncer;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		preferenceStore.setValue(LinkWithEditorOutlineContribution.PREFERENCE_KEY, true);
		selectionSyncer = new SyncingSelectionListener();
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		preferenceStore.setValue(LinkWithEditorOutlineContribution.PREFERENCE_KEY,
				preferenceStore.getDefaultBoolean(LinkWithEditorOutlineContribution.PREFERENCE_KEY));
	}

	@Test public void testTreeToText() throws Exception {
		IPostSelectionProvider editorSelectionProvider = (IPostSelectionProvider) editor.getSelectionProvider();
		editorSelectionProvider.addPostSelectionChangedListener(selectionSyncer);
		assertSelected(treeViewer);

		activate(editor);
		try {
			selectionSyncer.start();
			treeViewer.setSelection(new StructuredSelection(modelNode));
			selectionSyncer.awaitSignal(EXPECTED_TIMEOUT);
			fail("Selection from inactive part should not be linked");
		} catch (TimeoutException e) {
		}

		activate(outlineView);
		try {
			checkTreeSelectionToText(modelNode, modelAsText, selectionSyncer);
			checkTreeSelectionToText(oneNode, "one", selectionSyncer);
			checkTreeSelectionToText(twoNode, "two", selectionSyncer);
			checkTreeSelectionToText(threeNode, "three", selectionSyncer);
			checkTreeSelectionToText(fourNode, "four", selectionSyncer);
		} finally {
			editorSelectionProvider.removePostSelectionChangedListener(selectionSyncer);
		}
	}

	protected void checkTreeSelectionToText(IOutlineNode treeNode, String selectedText,
			SyncingSelectionListener selectionSyncer) throws Exception {
		selectionSyncer.start();
		treeViewer.setSelection(new StructuredSelection(treeNode));
		selectionSyncer.awaitSignal(ERROR_TIMEOUT);
		ISelection textSelection = editor.getSelectionProvider().getSelection();
		assertTrue(textSelection instanceof ITextSelection);
		assertEquals(selectedText, ((ITextSelection) textSelection).getText());
	}

	@Test public void testTextToTree() throws Exception {
		outlinePage.getSite().getSelectionProvider().addSelectionChangedListener(selectionSyncer);

		activate(outlineView);
		try {
			selectionSyncer.start();
			editor.getSelectionProvider().setSelection(new TextSelection(1, 1));
			selectionSyncer.awaitSignal(EXPECTED_TIMEOUT);
			fail("Selection from inactive part should not be linked");
		} catch (TimeoutException e) {
		}

		activate(editor);
		try {
			for (int offset = 0; offset < modelAsText.length(); ++offset) {
				selectionSyncer.start();
				editor.getSelectionProvider().setSelection(new TextSelection(offset, 1));
				selectionSyncer.awaitSignal(ERROR_TIMEOUT);
				assertSelected(treeViewer, expectedNodeAt(offset));
			}
		} finally {
			outlinePage.getSite().getSelectionProvider().removeSelectionChangedListener(selectionSyncer);
		}
	}

	protected IOutlineNode expectedNodeAt(int offset) {
		if (offset < modelAsText.indexOf("two"))
			return oneNode;
		if (offset < modelAsText.indexOf(" three"))
			return twoNode;
		if (offset < modelAsText.indexOf("three"))
			return oneNode;
		if (offset < modelAsText.indexOf(" } four"))
			return threeNode;
		if (offset < modelAsText.indexOf(" four"))
			return oneNode;
		if (offset < modelAsText.indexOf("four"))
			return modelNode;
		return fourNode;
	}

}

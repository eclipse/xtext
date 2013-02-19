/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineNodeComparer;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractOutlineWorkbenchTest extends AbstractEditorTest {

	protected static final int ERROR_TIMEOUT = 10000;
	protected static final int EXPECTED_TIMEOUT = 500;

	protected IOutlineNodeComparer nodeComparer = new IOutlineNodeComparer.Default();

	protected IFile file;
	protected XtextEditor editor;
	protected IXtextDocument document;
	protected IViewPart outlineView;
	protected SyncableOutlinePage outlinePage;
	protected TreeViewer treeViewer;

	protected String modelAsText;

	protected IOutlineNode modelNode;
	protected IOutlineNode oneNode;
	protected IOutlineNode twoNode;
	protected IOutlineNode threeNode;
	protected IOutlineNode fourNode;

	protected IPreferenceStore preferenceStore;
	protected IOutlineNodeComparer comparer;

	@SuppressWarnings("deprecation")
	@Override
	public void setUp() throws Exception {
		super.setUp();
		preferenceStore = new ScopedPreferenceStore(new InstanceScope(), getEditorId());
		comparer = new IOutlineNodeComparer.Default();
		modelAsText = "one { two {} three {} } four {}";
		file = IResourcesSetupUtil.createFile("test/test.outlinetestlanguage", modelAsText);
		editor = openEditor(file);
		document = editor.getDocument();
		outlineView = editor.getEditorSite().getPage().showView("org.eclipse.ui.views.ContentOutline");
		executeAsyncDisplayJobs();
		Object adapter = editor.getAdapter(IContentOutlinePage.class);
		assertTrue(adapter instanceof SyncableOutlinePage);
		outlinePage = (SyncableOutlinePage) adapter;
		outlinePage.resetSyncer();
		try {
			outlinePage.waitForUpdate(EXPECTED_TIMEOUT);
		} catch (TimeoutException e) {
			System.out.println("Expected timeout exceeded: "+EXPECTED_TIMEOUT);// timeout is OK here
		}
		treeViewer = outlinePage.getTreeViewer();
		assertSelected(treeViewer);
		assertExpanded(treeViewer);
		assertTrue(treeViewer.getInput() instanceof IOutlineNode);
		IOutlineNode rootNode = (IOutlineNode) treeViewer.getInput();
		List<IOutlineNode> children = rootNode.getChildren();
		assertEquals(1, children.size());
		modelNode = children.get(0);
		assertEquals(2, modelNode.getChildren().size());
		oneNode = modelNode.getChildren().get(0);
		assertEquals(2, oneNode.getChildren().size());
		twoNode = oneNode.getChildren().get(0);
		threeNode = oneNode.getChildren().get(1);
		fourNode = modelNode.getChildren().get(1);
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		editor.close(false);
		outlineView.getSite().getPage().hideView(outlineView);
		executeAsyncDisplayJobs();
	}

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.editor.outline.OutlineTestLanguage";
	}

	protected void assertExpanded(TreeViewer treeViewer, IOutlineNode... expectedExpansion) {
		Object[] expandedElements = treeViewer.getExpandedElements();
		assertEquals(expectedExpansion.length, expandedElements.length);
		OUTER: for (Object expandedObject : expandedElements) {
			assertTrue(expandedObject instanceof IOutlineNode);
			for (IOutlineNode expectedExpanded : expectedExpansion) {
				if (nodeComparer.equals((IOutlineNode) expandedObject, expectedExpanded))
					continue OUTER;
			}
			fail("Unexpected expansion" + expandedObject.toString());
		}
	}

	protected void assertSelected(TreeViewer treeViewer, IOutlineNode... expectedSelection) {
		ISelection selection = treeViewer.getSelection();
		assertTrue(selection instanceof IStructuredSelection);
		assertEquals(expectedSelection.length, ((IStructuredSelection) selection).size());
		OUTER: for (Iterator<?> i = ((IStructuredSelection) selection).iterator(); i.hasNext();) {
			Object selectedObject = i.next();
			assertTrue(selectedObject instanceof IOutlineNode);
			for (IOutlineNode expectedSelected : expectedSelection) {
				if (nodeComparer.equals((IOutlineNode) selectedObject, expectedSelected))
					continue OUTER;
			}
			fail("Unexpected selection " + selectedObject.toString());
		}
	}
	
	protected void assertSame(IOutlineNode node, TreeItem treeItem) {
		assertTrue(treeItem.getData() instanceof IOutlineNode);
		assertTrue(comparer.equals(node, (IOutlineNode) treeItem.getData()));
	}

	protected void activate(IWorkbenchPart part) {
		editor.getSite().getPage().activate(part);
	}

	protected void executeAsyncDisplayJobs() {
		while(Display.getCurrent().readAndDispatch()) {
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import static org.eclipse.xtext.ui.core.util.ResourceUtil.createFile;
import static org.eclipse.xtext.ui.core.util.ResourceUtil.createProject;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.AbstractEditorTest;
import org.eclipse.xtext.ui.core.editor.XtextEditor;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class OutlineViewTest extends AbstractEditorTest {

	private XtextEditor editor;
	private IProject project;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		closeWelcomePage();

		project = createProject("foo.outline");
		IFile file = createFile(project, "spielplatz.tst", "spielplatz 300 { \n" + "	kind (lennart 5) \n"
				+ "	kind (soeren 8) \n" + "}");
		editor = openEditor(file);
		assertNotNull(editor);
		XtextDocument document = (XtextDocument) editor.getDocument();
		assertNotNull(document);

		// make sure outline is available
		final IContentOutlinePage outlinePage = (IContentOutlinePage) editor.getAdapter(IContentOutlinePage.class);
		assertNotNull(outlinePage);

		// activate "Link with editor"
		LinkingHelper.setLinkingEnabled(true);
		assertTrue(LinkingHelper.isLinkingEnabled());

		sleep(500);
		Display.getDefault().readAndDispatch();
	}

	@Override
	protected void tearDown() throws Exception {
		Display.getDefault().readAndDispatch();
		editor.doSave(null);
		editor.close(true);
		project.delete(true, new NullProgressMonitor());
		sleep(500);
		super.tearDown();
	}

	public void testOutlineAvailable() throws PartInitException {
		ContentOutline outlineView = (ContentOutline) getActivePage().showView(IPageLayout.ID_OUTLINE);
		assertNotNull(outlineView);
	}

	public void testOutlineSyncToggle() {
		LinkingHelper.setLinkingEnabled(true);
		assertTrue(LinkingHelper.isLinkingEnabled());

		LinkingHelper.setLinkingEnabled(false);
		assertFalse(LinkingHelper.isLinkingEnabled());
	}

	/**
	 * This test ensures that the outline does not sync with the editor if
	 * "Link with Editor" is turned off.
	 */
	public void testUnlinkedEditorNavigation() throws Exception {
		// place cursor within "spielplatz"
		assertSynchronized(editor, 0, 1, 0);

		// turn OFF linking with editor!
		LinkingHelper.setLinkingEnabled(false);
		assertFalse(LinkingHelper.isLinkingEnabled());

		// get currently selected element in outline
		IStructuredSelection selection1 = (IStructuredSelection) getOutline().getSelection();
		URI uri1 = (URI) selection1.getFirstElement();

		// go to a different place.
		editor.selectAndReveal(20, 1);
		sleep(1000);

		// obtain selected model element in editor
		IStructuredSelection selection2 = (IStructuredSelection) getOutline().getSelection();
		URI uri2 = (URI) selection2.getFirstElement();

		// they must be equal
		assertEquals(uri1, uri2);
	}

	public void testSelectWholeTokenSyncEditorToOutline() throws Exception {
		// select "spielplatz"
		assertSynchronized(editor, 0, 0, "spielplatz".length());

		// select "kind"
		assertSynchronized(editor, 1, 19, "kind".length());
		// select whole node
		assertSynchronized(editor, 1, 19, "kind (lennart 5)".length());

		// select "kind"
		assertSynchronized(editor, 2, 38, "kind".length());
		// select whole node
		assertSynchronized(editor, 2, 38, "kind (soeren 8)".length());
	}

	public void testLeftBoundariesSyncEditorToOutline() throws Exception {
		// left of "spielplatz"
		assertSynchronized(editor, 0, 0, 0);

		// left of "kind" 1
		assertSynchronized(editor, 1, 19, 0);

		// left of "kind" 2
		assertSynchronized(editor, 2, 38, 0);
	}

	public void testRightBoundariesSyncEditorToOutline() throws Exception {
		// left of "spielplatz"
		assertSynchronized(editor, 0, "spielplatz".length(), 0);

		// left of "kind" 1
		assertSynchronized(editor, 1, 19 + "kind (lennart 5)".length(), 0);

		// left of "kind" 2
		assertSynchronized(editor, 2, 38 + "kind (soeren 8)".length(), 0);
	}

	public void testCursorWithinTokenSyncEditorToOutline() throws Exception {
		// place cursor within "spielplatz"
		assertSynchronized(editor, 0, 1, 0);
		assertSynchronized(editor, 0, 2, 0);
		assertSynchronized(editor, 0, 1, 1);

		// place within "kind" 1
		assertSynchronized(editor, 1, 20, 0);
		assertSynchronized(editor, 1, 21, 0);
		assertSynchronized(editor, 1, 20, 1);

		// place with "kind" 2
		assertSynchronized(editor, 2, 39, 0);
		assertSynchronized(editor, 2, 40, 0);
		assertSynchronized(editor, 2, 39, 1);

		assertSynchronized(editor, 2, 45, 0);
	}

	protected LeafNode getCurrentEditorNode() {
		XtextDocument document = (XtextDocument) editor.getDocument();

		ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
		assertNotNull(selection);

		int offset = selection.getOffset();
		System.out.println("OFFSET: " + offset);

		CompositeNode rootNode = document.readOnly(new UnitOfWork<CompositeNode>() {
			public CompositeNode exec(XtextResource resource) throws Exception {
				IParseResult parseResult = resource.getParseResult();
				Assert.isNotNull(parseResult);
				return parseResult.getRootNode();
			}
		});
		Assert.isNotNull(rootNode);

		LeafNode currentNodeByOffset = ParseTreeUtil.getCurrentNodeByOffset(rootNode, offset);
		return currentNodeByOffset;
	}

	protected void assertSynchronized(XtextEditor editor, int elementIndex, int offset, int length) {
		XtextDocument document = (XtextDocument) editor.getDocument();
		IContentOutlinePage outlinePage = getOutline();
		assertTrue(document.readOnly(new SyncEditorToOutlineAndCheckSelection(editor, elementIndex, outlinePage,
				offset, length)));
	}

	private IContentOutlinePage getOutline() {
		IContentOutlinePage outlinePage = (IContentOutlinePage) editor.getAdapter(IContentOutlinePage.class);
		return outlinePage;
	}

	private class SyncEditorToOutlineAndCheckSelection implements UnitOfWork<Boolean> {
		private final IContentOutlinePage outlinePage;
		private final XtextEditor editor;
		private final int length;
		private final int offset;
		private int elementIndex;

		public SyncEditorToOutlineAndCheckSelection(XtextEditor editor, int elementIndex,
				IContentOutlinePage outlinePage, int offset, int length) {
			this.editor = editor;
			this.elementIndex = elementIndex;
			this.outlinePage = outlinePage;
			this.offset = offset;
			this.length = length;
		}

		public Boolean exec(XtextResource resource) throws Exception {
			// select text fragment in editor and wait until outline syncs
			editor.selectAndReveal(offset, length);
			sleep(1000);

			// obtain selected model element in editor
			IStructuredSelection selection = (IStructuredSelection) outlinePage.getSelection();
			URI uri = (URI) selection.getFirstElement();
			List<EObject> contents = EcoreUtil2.eAllContentsAsList(resource);
			EObject objInEditor = contents.get(elementIndex);

			// just debugging purposes
			LeafNode currentEditorNode = getCurrentEditorNode();
			System.out.println("Selection [" + offset + ";" + length + "] yields node text ["
					+ currentEditorNode.getText() + "]");

			// obtain selected model element in outline
			EObject objInOutline = resource.getEObject(uri.fragment());

			// they must be equal
			return Boolean.valueOf(objInEditor.equals(objInOutline));
		}
	}

}

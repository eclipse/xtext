/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.navigation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeElementOpener;
import org.eclipse.xtext.ui.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.xbase.lib.Functions;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */

public class OpenEditorTest extends AbstractXtendUITestCase {
	
	private static final long SELECTION_TIMEOUT = 10000;

	@Inject
	private WorkbenchTestHelper workbenchTestHelper;

	@Inject
	private GlobalURIEditorOpener globalURIEditorOpener;

	@Inject
	private IDerivedResourceMarkers derivedResourceMarkers;

	@Inject
	private IOutlineTreeProvider treeProvider;

	@Inject
	private OutlineNodeElementOpener outlineNodeElementOpener;

	@Inject
	private IWorkbench workbench;

	private IJavaProject javaProject;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		workbenchTestHelper.createFile("outlinetest/Bar.java", "package outlinetest; public class Bar { public int bar; }");
		workbenchTestHelper.createFile("outlinetest/Foo.xtend", "package outlinetest class Foo extends Bar { public int foo }");
		IResourcesSetupUtil.waitForBuild();
		javaProject = JavaCore.create(workbenchTestHelper.getProject());
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		workbenchTestHelper.tearDown();
	}

	@Test public void testOpenEditors() throws Exception {
		IType bar = javaProject.findType("outlinetest.Bar");
		IEditorPart barEditor = globalURIEditorOpener.open(null, bar, true);
		assertEquals(JavaUI.ID_CU_EDITOR, barEditor.getEditorSite().getId());

		IType foo = javaProject.findType("outlinetest.Foo");
		IEditorPart fooJavaEditor = globalURIEditorOpener.open(null, bar, true);
		assertEquals(JavaUI.ID_CU_EDITOR, fooJavaEditor.getEditorSite().getId());

		IResource resource = foo.getResource();
		assertTrue(resource instanceof IFile);
		IMarker[] markers = derivedResourceMarkers.findDerivedResourceMarkers(resource);
		assertEquals(1, markers.length);
		String source = derivedResourceMarkers.getSource(markers[0]);
		assertNotNull(source);
		IEditorPart fooXtendEditor = globalURIEditorOpener.open(URI.createURI(source), foo, true);
		assertEquals("org.eclipse.xtend.core.Xtend", fooXtendEditor.getEditorSite().getId());
	}

	@Test public void testOpenFromOutline() throws Exception {
		XtextEditor bazXtendEditor = workbenchTestHelper.openEditor("outlinetest/Baz.xtend",
				"package outlinetest class Baz extends Foo { int baz }");
		IOutlineTreeProvider.ModeAware tp = (IOutlineTreeProvider.ModeAware) treeProvider;
		tp.setCurrentMode(tp.getOutlineModes().get(1));
		IOutlineNode outlineRoot = treeProvider.createRoot(bazXtendEditor.getDocument());
		IOutlineNode bazNode = outlineRoot.getChildren().get(1);
		assertEquals("Baz - outlinetest", bazNode.getText().toString());
		assertTrue(bazNode.getChildren().size() > 2);
		IOutlineNode baz = bazNode.getChildren().get(0);
		assertEquals("baz : int - Baz", baz.getText().toString());
		outlineNodeElementOpener.open(baz, bazXtendEditor.getInternalSourceViewer());
		assertActiveEditor("org.eclipse.xtend.core.Xtend", "Baz.xtend", "baz");
		IOutlineNode foo = bazNode.getChildren().get(1);
		assertEquals("foo : int - Foo", foo.getText().toString());
		outlineNodeElementOpener.open(foo, bazXtendEditor.getInternalSourceViewer());
		assertActiveEditor("org.eclipse.xtend.core.Xtend", "Foo.xtend", "foo");
		IOutlineNode bar = bazNode.getChildren().get(2);
		assertEquals("bar : int - Bar", bar.getText().toString());
		outlineNodeElementOpener.open(bar, bazXtendEditor.getInternalSourceViewer());
		assertActiveEditor(JavaUI.ID_CU_EDITOR, "Bar.java", "bar");
	}

	protected void assertActiveEditor(String expectedEditorID, String expectedEditorTitle, final String expectedSelection) {
		IEditorPart editorPart = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		assertEquals(expectedEditorTitle, editorPart.getTitle());
		IEditorSite editorSite = editorPart.getEditorSite();
		assertEquals(expectedEditorID, editorSite.getId());
		final ISelectionProvider selectionProvider = editorSite.getSelectionProvider();
		assertTrue(selectionProvider.getSelection() instanceof ITextSelection);
		
		// The selection may be updated asynchronously, so we may have to wait until the selection changes
		workbenchTestHelper.awaitUIUpdate(new Functions.Function0<Boolean>() {
			@Override
			public Boolean apply() {
				return expectedSelection.equals(((ITextSelection) selectionProvider.getSelection()).getText());
			}
		}, SELECTION_TIMEOUT);
		assertEquals(expectedSelection, ((ITextSelection) selectionProvider.getSelection()).getText());
	}
	
}

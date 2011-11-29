/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.navigation;

import junit.framework.Test;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.builder.DerivedResourceMarkers;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.ModeAwareOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeElementOpener;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OpenEditorTest extends AbstractXtend2UITestCase {

	public static Test suite() {
		return WorkbenchTestHelper.suite(OpenEditorTest.class);
	}

	@Inject
	private WorkbenchTestHelper workbenchTestHelper;

	@Inject
	private GlobalURIEditorOpener globalURIEditorOpener;

	@Inject
	private DerivedResourceMarkers derivedResourceMarkers;

	@Inject
	private IOutlineTreeProvider treeProvider;

	@Inject
	private OutlineNodeElementOpener outlineNodeElementOpener;

	@Inject
	private IWorkbench workbench;

	private IJavaProject javaProject;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		workbenchTestHelper.createFile("test/Bar.java", "package test; public class Bar { public int bar; }");
		workbenchTestHelper.createFile("test/Foo.xtend", "package test class Foo extends Bar { public int foo }");
		IResourcesSetupUtil.waitForAutoBuild();
		javaProject = JavaCore.create(workbenchTestHelper.getProject());
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		workbenchTestHelper.tearDown();
	}

	public void testOpenEditors() throws Exception {
		IType bar = javaProject.findType("test.Bar");
		IEditorPart barEditor = globalURIEditorOpener.open(null, bar, true);
		assertEquals(JavaUI.ID_CU_EDITOR, barEditor.getEditorSite().getId());

		IType foo = javaProject.findType("test.Foo");
		IEditorPart fooJavaEditor = globalURIEditorOpener.open(null, bar, true);
		assertEquals(JavaUI.ID_CU_EDITOR, fooJavaEditor.getEditorSite().getId());

		IResource resource = foo.getResource();
		assertTrue(resource instanceof IFile);
		IMarker[] markers = derivedResourceMarkers.findDerivedResourceMarkers((IFile) resource);
		assertEquals(1, markers.length);
		String source = derivedResourceMarkers.getSource(markers[0]);
		assertNotNull(source);
		IEditorPart fooXtendEditor = globalURIEditorOpener.open(URI.createURI(source), foo, true);
		assertEquals("org.eclipse.xtext.xtend2.Xtend2", fooXtendEditor.getEditorSite().getId());
	}

	public void testOpenFromOutline() throws Exception {
		XtextEditor bazXtendEditor = workbenchTestHelper.openEditor("test.Baz.xtend",
				"package test class Baz extends Foo { int baz }");
		ModeAwareOutlineTreeProvider tp = (ModeAwareOutlineTreeProvider) treeProvider;
		tp.setCurrentMode(tp.getOutlineModes().get(1));
		IOutlineNode outlineRoot = tp.createRoot(bazXtendEditor.getDocument());
		IOutlineNode bazNode = outlineRoot.getChildren().get(1);
		assertEquals("Baz", bazNode.getText().toString());
		assertTrue(bazNode.getChildren().size() > 2);
		IOutlineNode baz = bazNode.getChildren().get(0);
		assertEquals("baz : int", baz.getText().toString());
		outlineNodeElementOpener.open(baz, bazXtendEditor.getInternalSourceViewer());
		assertActiveEditor("org.eclipse.xtext.xtend2.Xtend2", "baz");
		IOutlineNode foo = bazNode.getChildren().get(2);
		assertEquals("foo : int - test.Foo", foo.getText().toString());
		outlineNodeElementOpener.open(foo, bazXtendEditor.getInternalSourceViewer());
		assertActiveEditor("org.eclipse.xtext.xtend2.Xtend2", "foo");
		IOutlineNode bar = bazNode.getChildren().get(4);
		assertEquals("bar : int - test.Bar", bar.getText().toString());
		outlineNodeElementOpener.open(bar, bazXtendEditor.getInternalSourceViewer());
		assertActiveEditor(JavaUI.ID_CU_EDITOR, "bar");
	}

	protected void assertActiveEditor(String expectedEditorID, String expectedSelection) {
		IEditorSite editorSite = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorSite();
		assertEquals(expectedEditorID, editorSite.getId());
		ISelection s = editorSite.getSelectionProvider().getSelection();
		assertTrue(s instanceof ITextSelection);
		assertEquals(expectedSelection, ((ITextSelection)s).getText());
	}
}

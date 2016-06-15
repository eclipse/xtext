/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.hover;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.tests.Activator;
import org.junit.Test;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class DispatchingEObjectTextHoverTest extends AbstractEditorTest {
	
	protected XtextEditor editor;
	
	protected IXtextDocument document;

	protected String modelAsText;
	
	private MockHover hover;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		modelAsText = "stuff mystuff stuff yourstuff refs mystuff // Comment";
		IFile file = IResourcesSetupUtil.createFile("test/test.testlanguage", modelAsText);
		editor = openEditor(file);
		document = editor.getDocument();
		hover = Activator.getInstance().getInjector(getEditorId()).getInstance(MockHover.class);
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		editor.close(false);
	}

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.TestLanguage";
	}

	@Test public void testNames () {	
		assertNull (hover.getHoverRegion(editor.getInternalSourceViewer(), 5));
		assertNull (hover.getHoverRegion(editor.getInternalSourceViewer(), 5));
		assertEquals(new Region (6,7), hover.getHoverRegion(editor.getInternalSourceViewer(), 6));
		assertEquals(new Region (6,7), hover.getHoverRegion(editor.getInternalSourceViewer(), 12));
		assertNull (hover.getHoverRegion(editor.getInternalSourceViewer(), 13));
	}

	@Test public void testCrossReferences () {
		assertNull (hover.getHoverRegion(editor.getInternalSourceViewer(), 34));
		assertEquals(new Region (35,7), hover.getHoverRegion(editor.getInternalSourceViewer(), 35));
		assertEquals(new Region (35,7), hover.getHoverRegion(editor.getInternalSourceViewer(), 41));
		assertNull (hover.getHoverRegion(editor.getInternalSourceViewer(), 43));
		assertEquals(new Region (35,7), hover.getHoverRegion(editor.getInternalSourceViewer(), 42));
	}

	protected void activate(IWorkbenchPart part) {
		editor.getSite().getPage().activate(part);
	}
	
	static class MockHover extends DispatchingEObjectTextHover {
		
		EObject hoverObject;

		@Override
		public Object getHoverInfo(EObject eObject, ITextViewer textViewer, IRegion hoverRegion) {
			hoverObject = eObject;
			return "test";
		}
	}
		
}

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
package org.eclipse.xtext.ui.tests.editor.hover.html;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.Region;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;
import org.eclipse.xtext.ui.editor.hover.html.XtextHtmlHover;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.AbstractEditorTest;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class XtextHtmlHoverTest extends AbstractEditorTest {

	protected XtextEditor editor;
	
	protected IXtextDocument document;

	protected String modelAsText;
	
	private XtextHtmlHover hover;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		modelAsText = "stuff mystuff\nstuff yourstuff";
		IFile file = IResourcesSetupUtil.createFile("test/test.testlanguage", modelAsText);
		editor = openEditor(file);
		document = editor.getDocument();
		hover = Activator.getInstance().getInjector(getEditorId()).getInstance(XtextHtmlHover.class);
		hover.setSourceViewer(editor.getInternalSourceViewer());
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		editor.close(false);
	}

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.TestLanguage";
	}

	@SuppressWarnings("deprecation")
	public void testNoHover () {	
		assertNull(hover.getHoverInfo(editor.getInternalSourceViewer(), new Region(0, 1)));
		assertNull(hover.getHoverInfo2(editor.getInternalSourceViewer(), new Region(0, 1)));
	}
	
	public void testHover () {	
		assertNotNull(hover.getHoverInfo2(editor.getInternalSourceViewer(), new Region(modelAsText.indexOf("mystuff"), 1)));
		XtextBrowserInformationControlInput ici = (XtextBrowserInformationControlInput) hover.getHoverInfo2(editor.getInternalSourceViewer(), new Region(modelAsText.indexOf("mystuff"), 1));
		assertNotNull(ici); 
		assertNotNull (ici.getInputElement());
		assertEquals ("mystuff", ici.getInputName());
		assertEquals(1894, ici.getHtml().length());
	}

	protected void activate(IWorkbenchPart part) {
		editor.getSite().getPage().activate(part);
	}
		
}

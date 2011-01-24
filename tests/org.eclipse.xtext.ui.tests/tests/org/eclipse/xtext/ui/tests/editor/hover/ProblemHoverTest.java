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

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.Region;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.AbstractEditorTest;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class ProblemHoverTest extends AbstractEditorTest {

	protected XtextEditor editor;
	
	protected IXtextDocument document;

	protected String modelAsText;
	
	private ProblemAnnotationHover hover;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		modelAsText = "stuff mystuff\nstuff yourstuff refs _mystuff stuff hisstuff refs _yourstuff// Comment";
		IFile file = IResourcesSetupUtil.createFile("test/test.testlanguage", modelAsText);
		editor = openEditor(file);
		document = editor.getDocument();
		hover = Activator.getInstance().getInjector(getEditorId()).getInstance(ProblemAnnotationHover.class);
		hover.setSourceViewer(editor.getInternalSourceViewer());
		List<Issue> issues = document.readOnly(new IUnitOfWork<List<Issue>, XtextResource>() {
			public List<Issue> exec(XtextResource state) throws Exception {
				return state.getResourceServiceProvider().getResourceValidator().validate(state, CheckMode.ALL, null);
			}	
		});
		MarkerCreator markerCreator =  Activator.getInstance().getInjector(getEditorId()).getInstance(MarkerCreator.class);
		for (Issue issue : issues) {
			markerCreator.createMarker(issue, file, MarkerTypes.forCheckType(issue.getType()));
		}
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
	public void testAnnotations () {	
		assertNull(hover.getHoverInfo(editor.getInternalSourceViewer(), new Region(34, 1)));
		assertEquals("Couldn't resolve reference to Stuff '_mystuff'.", hover.getHoverInfo(editor.getInternalSourceViewer(), new Region(35, 7)));
		
		//The order of annotations in the annotation model is not stable
		final String hoverInfo = hover.getHoverInfo(editor.getInternalSourceViewer(), 1);
		String expected1 = "Multiple markers at this line\n";
		String expected2 = "- Couldn't resolve reference to Stuff '_mystuff'.";
		String expected3 = "- Couldn't resolve reference to Stuff '_yourstuff'.";
		assertTrue(hoverInfo.startsWith(expected1));
		assertTrue(hoverInfo.contains(expected2));
		assertTrue(hoverInfo.contains(expected3));
	}

	protected void activate(IWorkbenchPart part) {
		editor.getSite().getPage().activate(part);
	}
		
}

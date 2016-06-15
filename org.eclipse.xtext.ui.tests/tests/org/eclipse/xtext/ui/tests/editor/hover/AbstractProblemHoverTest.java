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
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.AbstractProblemHover;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
public class AbstractProblemHoverTest extends AbstractEditorTest {

	protected XtextEditor editor;
	
	protected IXtextDocument document;

	protected String modelAsText;
	
	private MockHover hover;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		modelAsText = "stuff mystuff\nstuff yourstuff refs _mystuff// Comment";
		IFile file = IResourcesSetupUtil.createFile("test/test.testlanguage", modelAsText);
		editor = openEditor(file);
		document = editor.getDocument();
		hover = Activator.getInstance().getInjector(getEditorId()).getInstance(MockHover.class);
		hover.setSourceViewer(editor.getInternalSourceViewer());
		List<Issue> issues = document.readOnly(new IUnitOfWork<List<Issue>, XtextResource>() {
			@Override
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
	public void tearDown() throws Exception {
		super.tearDown();
		editor.close(false);
	}

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.TestLanguage";
	}

	@Test public void testAnnotations () {	
		assertEquals (0, hover.getAnnotations(0,0).size());
		assertEquals (0, hover.getAnnotations(1,34).size());
		assertEquals (1, hover.getAnnotations(1,35).size());
		assertEquals (1, hover.getAnnotations(1,43).size());
		assertEquals (0, hover.getAnnotations(1,44).size());
	}

	protected void activate(IWorkbenchPart part) {
		editor.getSite().getPage().activate(part);
	}
	
	static class MockHover extends AbstractProblemHover {
		
		@Override
		protected IRegion getHoverRegionInternal(int lineNumber, int offset) {
			return null;
		}

		@Override
		protected Object getHoverInfoInternal(ITextViewer textViewer, int lineNumber, int offset) {
			return null;
		}

	}
	
}

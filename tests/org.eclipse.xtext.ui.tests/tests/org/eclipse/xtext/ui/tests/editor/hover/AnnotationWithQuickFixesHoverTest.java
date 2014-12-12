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
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.hover.AnnotationWithQuickFixesHover;
import org.eclipse.xtext.ui.editor.hover.AnnotationWithQuickFixesHover.AnnotationInfo;
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
public class AnnotationWithQuickFixesHoverTest extends AbstractEditorTest {

	protected XtextEditor editor;

	protected IXtextDocument document;

	protected String modelAsText;

	private AnnotationWithQuickFixesHover hover;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		modelAsText = "stuff mystuff stuff yourstuff refs _mystuff stuff hisstuff refs _yourstuff";
		IFile file = IResourcesSetupUtil.createFile("test/test.testlanguage", modelAsText);
		editor = openEditor(file);
		document = editor.getDocument();
		hover = Activator.getInstance().getInjector(getEditorId()).getInstance(AnnotationWithQuickFixesHover.class);
		hover.setSourceViewer(editor.getInternalSourceViewer());
		List<Issue> issues = document.readOnly(new IUnitOfWork<List<Issue>, XtextResource>() {
			@Override
			public List<Issue> exec(XtextResource state) throws Exception {
				return state.getResourceServiceProvider().getResourceValidator().validate(state, CheckMode.ALL, null);
			}
		});
		assertEquals(2, issues.size());
		MarkerCreator markerCreator = Activator.getInstance().getInjector(getEditorId())
				.getInstance(MarkerCreator.class);
		for (Issue issue : issues) {
			markerCreator.createMarker(issue, file, MarkerTypes.forCheckType(issue.getType()));
		}

		if (Display.getCurrent().getActiveShell() != editor.getShell()) {
			System.out.println("Editor shell is not active. Active shell is: " + Display.getCurrent().getActiveShell());
			getWorkbenchWindow().getShell().forceActive();
			editor.getInternalSourceViewer().getTextWidget().forceFocus();
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

	@Test
	public void testNoAnnotations() {
		AnnotationWithQuickFixesHover.AnnotationInfo info = (AnnotationInfo) hover.getHoverInfo2(
				editor.getInternalSourceViewer(), new Region(1, 1));
		assertNull(info);
	}

	@Test
	public void testAnnotations() {
		AnnotationWithQuickFixesHover.AnnotationInfo info = (AnnotationInfo) hover.getHoverInfo2(
				editor.getInternalSourceViewer(), new Region(modelAsText.indexOf("_mystuff"), 1));
		assertNotNull(info);
		assertNotNull(info.annotation);
		assertEquals(3, info.getCompletionProposals().length);
	}

	protected void activate(IWorkbenchPart part) {
		editor.getSite().getPage().activate(part);
	}

}

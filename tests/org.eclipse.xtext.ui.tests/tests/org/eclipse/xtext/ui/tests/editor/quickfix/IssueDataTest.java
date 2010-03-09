/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.MarkerUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IssueUtil;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;
import org.eclipse.xtext.ui.tests.quickfix.validation.QuickfixCrossrefTestLanguageJavaValidator;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * @author koehnlein - Initial contribution and API
 */
public class IssueDataTest extends AbstractQuickfixTest {

	private static final String PROJECT_NAME = "quickfixtest";
	private static final String MODEL_FILE = "test.quickfixcrossreftestlanguage";
	private static final String MODEL_WITH_LINKING_ERROR = QuickfixCrossrefTestLanguageJavaValidator.TRIGGER_VALIDATION_ISSUE + "{}";


	public void testIssueData() throws Exception {
		XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, MODEL_WITH_LINKING_ERROR);
		IXtextDocument document = xtextEditor.getDocument();
		IResource file = xtextEditor.getResource();
		List<Issue> issues = getIssues(document);
		assertEquals(1, issues.size());
		Issue issue = issues.get(0);
		String[] expectedIssueData = new String[]{ QuickfixCrossrefTestLanguageJavaValidator.ISSUE_DATA_0,
			QuickfixCrossrefTestLanguageJavaValidator.ISSUE_DATA_1};
		assertTrue(Arrays.equals(expectedIssueData, issue.getData()));
		Thread.sleep(1000);
		
		IAnnotationModel annotationModel = xtextEditor.getDocumentProvider().getAnnotationModel(
				xtextEditor.getEditorInput());
		new AnnotationIssueProcessor(document, annotationModel, new IssueResolutionProvider.NullImpl());
		Iterator<?> annotationIterator = annotationModel.getAnnotationIterator();
		// filter QuickDiffAnnotations
		List<XtextAnnotation> annotations = Lists.newArrayList(Iterators.filter(annotationIterator, XtextAnnotation.class));
		assertEquals(annotations.toString(), 1, annotations.size());
		XtextAnnotation annotation = annotations.get(0);
		assertTrue(Arrays.equals(expectedIssueData, annotation.getIssueData()));
		IssueUtil issueUtil = new IssueUtil();
		issueUtil.setMarkerUtil(new MarkerUtil());
		Issue issueFromAnnotation = issueUtil.getIssueFromAnnotation(annotation);
		assertTrue(Arrays.equals(expectedIssueData, issueFromAnnotation.getData()));
		
		new MarkerCreator().createMarker(issue, file, MarkerTypes.FAST_VALIDATION);
		IMarker[] markers = file.findMarkers(MarkerTypes.FAST_VALIDATION, true, IResource.DEPTH_ZERO);
		assertEquals(1, markers.length);
		String attribute = (String) markers[0].getAttribute(Issue.DATA_KEY);
		assertNotNull(attribute);
		assertTrue(Arrays.equals(expectedIssueData, Strings.unpack(attribute)));

		Issue issueFromMarker = issueUtil.createIssue(markers[0]);
		assertTrue(Arrays.equals(expectedIssueData, issueFromMarker.getData()));
		
	}
	
}

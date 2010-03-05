/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.junit.util.JavaProjectSetupUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.quickfix.importUriUi.Element;
import org.eclipse.xtext.ui.tests.quickfix.importUriUi.Main;
import org.eclipse.xtext.ui.tests.quickfix.ui.quickfix.QuickfixCrossrefTestLanguageQuickfixProvider;
import org.eclipse.xtext.ui.tests.workbench.AbstractWorkbenchTest;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Jan Koehnlein
 */
public class LinkingErrorTest extends AbstractWorkbenchTest {

	private static final String MODEL_FILE = "test.quickfixcrossreftestlanguage";
	private static final String PROJECT_NAME = "quickfixtest";

	public void testQuickfixTurnaround() throws Exception {
		XtextEditor xtextEditor = openEditor();
		IXtextDocument document = xtextEditor.getDocument();

		List<Issue> issues = getIssues(document);
		assertFalse(issues.isEmpty());
		Issue issue = issues.get(0);
		assertNotNull(issue);
		IssueResolutionProvider quickfixProvider = getInjector().getInstance(IssueResolutionProvider.class);
		List<IssueResolution> resolutions = quickfixProvider.getResolutions(issue);

		assertEquals(1, resolutions.size());
		IssueResolution resolution = resolutions.get(0);
		assertEquals("Change to 'Bar'", resolution.getLabel());
		resolution.apply();
		issues = getIssues(document);
		assertTrue(issues.isEmpty());
		xtextEditor.close(false);
	}

	public void testSemanticIssueResolution() throws Exception {
		final XtextEditor editor = openEditor();
		URI uriToProblem = editor.getDocument().readOnly(new IUnitOfWork<URI, XtextResource>() {
			public URI exec(XtextResource state) throws Exception {
				Main main = (Main) state.getContents().get(0);
				Element element = main.getElements().get(1);
				return EcoreUtil.getURI(element);
			}
		});
		Issue.IssueImpl issue = new Issue.IssueImpl();
		issue.setUriToProblem(uriToProblem);
		issue.setCode(QuickfixCrossrefTestLanguageQuickfixProvider.SEMANTIC_FIX_ID);

		IssueResolutionProvider quickfixProvider = getInjector().getInstance(IssueResolutionProvider.class);
		List<IssueResolution> resolutions = quickfixProvider.getResolutions(issue);
		assertEquals(1, resolutions.size());
		IssueResolution issueResolution = resolutions.get(0);
		issueResolution.apply();
		editor.doSave(null);
		List<Issue> issues = getIssues(editor.getDocument());
		assertTrue(issues.isEmpty());
		editor.close(false);
	}

	private Injector getInjector() {
		return Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.quickfix.QuickfixCrossrefTestLanguage");
	}

	private XtextEditor openEditor() throws CoreException, PartInitException {
		String model = "Foo { ref Bor }\n" + "Bar { }";
		IJavaProject javaProject = JavaProjectSetupUtil.createJavaProject(PROJECT_NAME);
		IFile file = javaProject.getProject().getFile(MODEL_FILE);
		if (file.exists()) {
			file.delete(true, null);
		}
		file.create(new StringInputStream(model), true, null);
		file.refreshLocal(IResource.DEPTH_ONE, null);
		XtextEditor xtextEditor = (XtextEditor) IDE.openEditor(getActivePage(), file);
		xtextEditor.getDocument().set(model);
		return xtextEditor;
	}

	private List<Issue> getIssues(IXtextDocument document) {
		return document.readOnly(new IUnitOfWork<List<Issue>, XtextResource>() {
			public List<Issue> exec(XtextResource state) throws Exception {
				return state.getResourceServiceProvider().getResourceValidator().validate(state, CheckMode.ALL,
						null);
			}
		});
	}
}

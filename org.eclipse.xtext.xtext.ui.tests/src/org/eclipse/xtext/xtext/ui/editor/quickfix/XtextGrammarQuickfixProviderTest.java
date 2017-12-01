/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.quickfix;

import static org.eclipse.xtext.xtext.XtextConfigurableIssueCodes.*;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.internal.InternalBuilderTest;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xtext.XtextLinkingDiagnosticMessageProvider;
import org.eclipse.xtext.xtext.ui.Activator;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Michael Clay - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XtextGrammarQuickfixProviderTest extends AbstractXtextTests {

	private static final String PROJECT_NAME = "org.eclipse.xtext.ui.editor.quickfix";
	private static final String MODEL_FILE = "XtextGrammarQuickfixProviderTest.xtext";
	private static final String GRAMMAR_WITH_MISSING_RULE = Strings.concat("\n", Arrays.asList(
			"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
			"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"", "Model: elements+=AbstractElement;"));
	private static final String GRAMMAR_WITH_INVALID_MM_NAME = Strings.concat("\n", Arrays.asList(
			"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
			"generate MYDSL \"http://www.xtext.org/example/mydsl/MyDsl\"", "Model: a=ID;"));
	private static final String GRAMMAR_WITH_EMPTY_ENUM_LITERAL = Strings.concat("\n", Arrays.asList(
			"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
			"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"", "Model: a=ID;", "enum ABCD: A|B|C=''|D;"));
	private static final String GRAMMAR_WITH_SEVERAL_EMPTY_ENUM_LITERAL = Strings.concat("\n", Arrays.asList(
			"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
			"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"", "Model: a=ID;", "enum ABCD: A|B|C=''|D;", "enum B: B='';"));
	private static final String GRAMMAR_WITH_INVALID_ACTION_IN_UOG = Strings.concat("\n", Arrays.asList(
			"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
			"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"", "Model: a=ID;",
			"Modifier: {Modifier} static?='static' & final?='final';"));

	@Test
	public void testFixMissingRule() throws Exception {
		XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, GRAMMAR_WITH_MISSING_RULE);
		assertAndApplySingleResolution(xtextEditor, XtextLinkingDiagnosticMessageProvider.UNRESOLVED_RULE, 1,
				"Create rule 'AbstractElement'", false);
	}

	@Test
	public void testFixInvalidMetaModelName() throws Exception {
		XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, GRAMMAR_WITH_INVALID_MM_NAME);
		assertAndApplySingleResolution(xtextEditor, INVALID_METAMODEL_NAME, 1,
				"Fix metamodel name 'MYDSL'");
	}

	@Test
	public void testFixEmptyEnumLiteral() throws Exception {
		XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, GRAMMAR_WITH_EMPTY_ENUM_LITERAL);
		assertAndApplySingleResolution(xtextEditor, EMPTY_ENUM_LITERAL, 1, "Fix empty enum literal");
	}
	
	@Test
	public void testFixAllEmptyEnumLiteral() throws Exception {
		XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, GRAMMAR_WITH_SEVERAL_EMPTY_ENUM_LITERAL);
		assertAndApplyAllResolutions(xtextEditor, EMPTY_ENUM_LITERAL, 1, 2, "Fix empty enum literal");
	}

	@Test
	public void testFixInvalidAction() throws Exception {
		XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, GRAMMAR_WITH_INVALID_ACTION_IN_UOG);
		assertAndApplySingleResolution(xtextEditor, INVALID_ACTION_USAGE, 0, "Fix invalid action usage");
	}

	protected void assertAndApplySingleResolution(XtextEditor xtextEditor, String issueCode, int issueDataCount,
			String resolutionLabel) {
		assertAndApplySingleResolution(xtextEditor, issueCode, issueDataCount, resolutionLabel, true);
	}

	protected void assertAndApplySingleResolution(XtextEditor xtextEditor, String issueCode, int issueDataCount,
			String resolutionLabel, boolean isCleanAfterApply) {
		IssueResolutionProvider quickfixProvider = createInjector().getInstance(IssueResolutionProvider.class);
		IXtextDocument document = xtextEditor.getDocument();
		List<Issue> issues = getIssues(document);
		assertFalse(issues.isEmpty());
		Issue issue = issues.iterator().next();
		assertEquals(issueCode, issue.getCode());
		assertNotNull(issue.getData());
		assertEquals(issueDataCount, issue.getData().length);
		List<IssueResolution> resolutions = quickfixProvider.getResolutions(issue);

		assertEquals(1, resolutions.size());
		IssueResolution resolution = resolutions.iterator().next();
		assertEquals(resolutionLabel, resolution.getLabel());
		try {
			resolution.apply();
			assertEquals(getIssues(document).toString(), isCleanAfterApply, getIssues(document).isEmpty());
		} finally {
			// Save xtextEditor in any case. Otherwise test will stuck,
			// because the "save changed resource dialog" waits for user input.
			xtextEditor.doSave(new NullProgressMonitor());
		}
	}
	protected void assertAndApplyAllResolutions(XtextEditor xtextEditor, String issueCode, int issueDataCount, int issueCount,
			String resolutionLabel) throws CoreException {
		final Injector injector = createInjector();
		InternalBuilderTest.setAutoBuild(true);
		if (xtextEditor.isDirty()) {
			xtextEditor.doSave(new NullProgressMonitor());
		}
		InternalBuilderTest.fullBuild();

		IXtextDocument document = xtextEditor.getDocument();
		List<Issue> issues = getIssues(document);
		assertFalse("Document has no issues, but should.", issues.isEmpty());

		issues.iterator().forEachRemaining((issue) -> {
			assertEquals(issueCode, issue.getCode());
			assertNotNull(issue.getData());
			assertEquals(issueDataCount, issue.getData().length);
		});
		IResource resource = xtextEditor.getResource();
		IMarker[] problems = resource.findMarkers(MarkerTypes.FAST_VALIDATION, true, IResource.DEPTH_INFINITE);
		assertEquals("Resource should have " + issueCount + " error marker.", issueCount, problems.length);

		MarkerResolutionGenerator instance = injector.getInstance(MarkerResolutionGenerator.class);
		List<IMarkerResolution> resolutions = Lists.newArrayList(instance.getResolutions(problems[0]));
		assertEquals(1, resolutions.size());
		IMarkerResolution resolution = resolutions.iterator().next();
		assertTrue(resolution instanceof WorkbenchMarkerResolution);
		WorkbenchMarkerResolution workbenchResolution = (WorkbenchMarkerResolution) resolution;
		workbenchResolution.run(workbenchResolution.findOtherMarkers(problems), new NullProgressMonitor());
		InternalBuilderTest.cleanBuild();
		problems = resource.findMarkers(MarkerTypes.FAST_VALIDATION, true, IResource.DEPTH_INFINITE);
		assertEquals("Resource should have no error marker.", 0, problems.length);

	}

	protected XtextEditor newXtextEditor(String projectName, String modelFile, String model) throws CoreException,
			PartInitException {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
		IProject project = JavaProjectSetupUtil.createSimpleProject(PROJECT_NAME);
		IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
		IFile file = project.getProject().getFile(modelFile);
		if (file.exists()) {
			file.delete(true, null);
		}
		file.create(new StringInputStream(model), true, null);
		file.refreshLocal(IResource.DEPTH_ONE, null);
		XtextEditor xtextEditor = (XtextEditor) IDE.openEditor(getActivePage(), file);
		xtextEditor.getDocument().set(model);
		return xtextEditor;
	}

	protected List<Issue> getIssues(IXtextDocument document) {
		return document.readOnly(new IUnitOfWork<List<Issue>, XtextResource>() {
			@Override
			public List<Issue> exec(XtextResource state) throws Exception {
				return state.getResourceServiceProvider().getResourceValidator().validate(state, CheckMode.ALL, null);
			}
		});
	}

	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new XtextRuntimeModule(), new org.eclipse.xtext.xtext.ui.internal.XtextUIModuleInternal(
				Activator.getDefault()), new SharedStateModule()));
	}

	protected IWorkbenchPage getActivePage() {
		return getWorkbenchWindow().getActivePage();
	}

	protected IWorkbenchWindow getWorkbenchWindow() {
		return getWorkbench().getActiveWorkbenchWindow();
	}

	protected IWorkbench getWorkbench() {
		return PlatformUI.getWorkbench();
	}
}

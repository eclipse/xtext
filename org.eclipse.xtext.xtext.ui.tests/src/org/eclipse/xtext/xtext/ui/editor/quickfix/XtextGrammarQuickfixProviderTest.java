/*******************************************************************************
 * Copyright (c) 2010, 2018 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.quickfix;

import static java.util.Arrays.*;
import static org.eclipse.xtext.xtext.XtextConfigurableIssueCodes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.Job;
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
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xtext.RuleWithoutInstantiationInspector;
import org.eclipse.xtext.xtext.XtextLinkingDiagnosticMessageProvider;
import org.eclipse.xtext.xtext.ui.Activator;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Arne Deutsch - New test cases for fixAddAction and some refactoring
 */
@SuppressWarnings("restriction")
public class XtextGrammarQuickfixProviderTest extends AbstractXtextTests {

	private static final String PROJECT_NAME = "org.eclipse.xtext.ui.editor.quickfix";
	private static final String MODEL_FILE = "XtextGrammarQuickfixProviderTest.xtext";

	@Test
	public void testFixMissingRule() throws Exception {
		assertAndApplySingleResolution(editorForGrammar("Model: elements+=AbstractElement;"),
				XtextLinkingDiagnosticMessageProvider.UNRESOLVED_RULE, 1, "Create rule 'AbstractElement'", false);
	}

	@Test
	public void testFixInvalidMetaModelName() throws Exception {
		String model = Strings.concat("\n", Arrays.asList("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
				"generate MYDSL \"http://www.xtext.org/example/mydsl/MyDsl\"", "Model: a=ID;"));
		IProject project = newProject();
		IFile file = newModelFileInProject(project, MODEL_FILE, model);
		XtextEditor xtextEditor = (XtextEditor) IDE.openEditor(getActivePage(), file);
		xtextEditor.getDocument().set(model);
		assertAndApplySingleResolution(xtextEditor, INVALID_METAMODEL_NAME, 1, "Fix metamodel name 'MYDSL'");
	}

	@Test
	public void testFixEmptyEnumLiteral() throws Exception {
		assertAndApplySingleResolution(editorForGrammar("Model: a=ID;", "enum ABCD: A|B|C=''|D;"), EMPTY_ENUM_LITERAL, 1,
				"Fix empty enum literal");
	}

	@Test
	public void testFixAllEmptyEnumLiteral() throws Exception {
		assertAndApplyAllResolutions(editorForGrammar("Model: a=ID;", "enum ABCD: A|B|C=''|D;", "enum B: B='';"), EMPTY_ENUM_LITERAL, 1, 2,
				"Fix empty enum literal");
	}

	@Test
	public void testFixInvalidAction() throws Exception {
		assertAndApplySingleResolution(editorForGrammar("Model: a=ID;", "Modifier: {Modifier} static?='static' & final?='final';"),
				INVALID_ACTION_USAGE, 0, "Fix invalid action usage");
	}

	@Test
	public void fixAddActionToAlternativeToken() throws Exception {
		assertCleanAfterResolution(RuleWithoutInstantiationInspector.ISSUE_CODE, "Add actions to ensure object creation",
				asList("Model: greetings+=Greeting*;", "Greeting: name=ID | 'A';"));
	}

	@Test
	public void fixAddActionToAlternativeTokenList() throws Exception {
		assertCleanAfterResolution(RuleWithoutInstantiationInspector.ISSUE_CODE, "Add actions to ensure object creation",
				asList("Model: greetings+=Greeting*;", "Greeting: name=ID | 'A' 'B';"));
	}

	@Test
	public void fixAddActionToAlternativeUnassignedRule() throws Exception {
		assertCleanAfterResolution(RuleWithoutInstantiationInspector.ISSUE_CODE, "Add actions to ensure object creation",
				asList("Model: greetings+=Greeting*;", "Greeting: name=ID | INT;"));
	}

	@Test
	public void fixAddActionToOptionalAssignment() throws Exception {
		assertCleanAfterResolution(RuleWithoutInstantiationInspector.ISSUE_CODE, "Add actions to ensure object creation",
				asList("Model: greetings+=Greeting*;", "Greeting: name=ID?;"));
	}

	@Test
	public void fixAddActionToAlternativeOptionalAssignment() throws Exception {
		assertCleanAfterResolution(RuleWithoutInstantiationInspector.ISSUE_CODE, "Add actions to ensure object creation",
				asList("Model: greetings+=Greeting*;", "Greeting: name=ID | id=INT?;"));
	}

	@Test
	public void fixAddActionToAlternativeTokenWhereasOneHasAlreadyAnAction() throws Exception {
		assertCleanAfterResolution(RuleWithoutInstantiationInspector.ISSUE_CODE, "Add actions to ensure object creation",
				asList("Model: greetings+=Greeting*;", "Greeting: {Greeting} 'A' | 'B';"));
	}

	@Test
	public void fixAddActionToMultipleMissingActions() throws Exception {
		assertCleanAfterResolution(RuleWithoutInstantiationInspector.ISSUE_CODE, "Add actions to ensure object creation",
				asList("Model: greetings+=Greeting*;", "Greeting: name=ID | 'A' | {Greeting} 'B' | id=INT?;"));
	}

	@Test
	public void fixAddActionToComplexDeeplyNested() throws Exception {
		assertCleanAfterResolution(RuleWithoutInstantiationInspector.ISSUE_CODE, "Add actions to ensure object creation",
				asList("Model: greetings+=Greeting*;", "Greeting: (name=ID | 'A')? ('B' | id=INT?);"));
	}

	@Test
	public void fixAddActionToMultipleMissingActionsDeeplyNestedAlternative() throws Exception {
		assertCleanAfterResolution(RuleWithoutInstantiationInspector.ISSUE_CODE, "Add actions to ensure object creation",
				asList("Model: greetings+=Greeting*;", "Greeting: (name=ID | 'A') | ('B' | id=INT?);"));
	}

	@Test
	public void fixAddActionForRuleWithReturnsExpression() throws Exception {
		assertCleanAfterResolution(RuleWithoutInstantiationInspector.ISSUE_CODE, "Add actions to ensure object creation",
				asList("Model: greetings+=Greeting*;", "Greeting returns Test: name=ID | 'A';"));
	}

	@Test
	public void fixAddActionForGrammarWithAlias() throws Exception {
		String model = Strings.concat("\n",
				Arrays.asList("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
						"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\" as my",
						"Model returns my::Greeting: greetings+=Greeting*;", "Greeting returns my::Greeting: 'Hello' name=ID? '!';"));
		IProject project = newProject();
		IFile file = newModelFileInProject(project, MODEL_FILE, model);
		XtextEditor xtextEditor = (XtextEditor) IDE.openEditor(getActivePage(), file);
		xtextEditor.getDocument().set(model);
		assertAndApplySingleResolution(xtextEditor, RuleWithoutInstantiationInspector.ISSUE_CODE, 0,
				"Add actions to ensure object creation");
	}

	private void assertCleanAfterResolution(String issueCode, String resolutionLabel, List<String> grammarBodyContent)
			throws PartInitException, CoreException {
		assertAndApplySingleResolution(editorForGrammar(grammarBodyContent.toArray(new String[0])), issueCode, 0, resolutionLabel);
	}

	private void assertAndApplySingleResolution(XtextEditor xtextEditor, String issueCode, int issueDataCount, String resolutionLabel) {
		assertAndApplySingleResolution(xtextEditor, issueCode, issueDataCount, resolutionLabel, true);
	}

	private void assertAndApplySingleResolution(XtextEditor xtextEditor, String issueCode, int issueDataCount, String resolutionLabel,
			boolean isCleanAfterApply) {
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

	private void assertAndApplyAllResolutions(XtextEditor xtextEditor, String issueCode, int issueDataCount, int issueCount,
			String resolutionLabel) throws CoreException {
		final Injector injector = createInjector();
		InternalBuilderTest.setAutoBuild(true);
		if (xtextEditor.isDirty()) {
			xtextEditor.doSave(new NullProgressMonitor());
		}
		InternalBuilderTest.fullBuild();
		IXtextDocument document = xtextEditor.getDocument();
		validateInEditor(document);
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
		validateInEditor(document);
		MarkerResolutionGenerator instance = injector.getInstance(MarkerResolutionGenerator.class);
		List<IMarkerResolution> resolutions = Lists.newArrayList(instance.getResolutions(problems[0]));
		assertEquals(1, resolutions.size());
		IMarkerResolution resolution = resolutions.iterator().next();
		assertTrue(resolution instanceof WorkbenchMarkerResolution);
		WorkbenchMarkerResolution workbenchResolution = (WorkbenchMarkerResolution) resolution;
		IMarker primaryMarker = problems[0];
		List<IMarker> others = Lists.newArrayList(workbenchResolution.findOtherMarkers(problems));
		assertFalse(others.contains(primaryMarker));
		assertEquals(problems.length - 1, others.size());
		others.add(primaryMarker);
		workbenchResolution.run(others.toArray(new IMarker[others.size()]), new NullProgressMonitor());
		if (xtextEditor.isDirty()) {
			xtextEditor.doSave(null);
		}
		InternalBuilderTest.cleanBuild();
		problems = resource.findMarkers(MarkerTypes.FAST_VALIDATION, true, IResource.DEPTH_INFINITE);
		assertEquals("Resource should have no error marker.", 0, problems.length);

	}

	private void validateInEditor(IXtextDocument document) {
		Job validationJob = ((XtextDocument)document).getValidationJob();
		validationJob.schedule();
		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(ValidationJob.XTEXT_VALIDATION_FAMILY, new NullProgressMonitor());
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

	private XtextEditor editorForGrammar(String... bodyContent) throws PartInitException, CoreException {
		String model = grammarGeneratingModel(bodyContent);
		IProject project = newProject();
		IFile file = newModelFileInProject(project, MODEL_FILE, model);
		XtextEditor xtextEditor = (XtextEditor) IDE.openEditor(getActivePage(), file);
		xtextEditor.getDocument().set(model);
		return xtextEditor;
	}

	private String grammarGeneratingModel(String... bodyContent) {
		List<String> list = new ArrayList<>();
		list.add("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
		list.add("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
		list.addAll(Arrays.asList(bodyContent));
		return Strings.concat("\n", list);
	}

	private IProject newProject() throws CoreException {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
		IProject project = JavaProjectSetupUtil.createSimpleProject(PROJECT_NAME);
		IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
		return project;
	}

	private IFile newModelFileInProject(IProject project, String modelFile, String model) throws CoreException {
		IFile file = project.getFile(modelFile);
		if (file.exists()) {
			file.delete(true, null);
		}
		file.create(new StringInputStream(model), true, null);
		file.refreshLocal(IResource.DEPTH_ONE, null);
		return file;
	}

	private List<Issue> getIssues(IXtextDocument document) {
		return document.readOnly(new IUnitOfWork<List<Issue>, XtextResource>() {
			@Override
			public List<Issue> exec(XtextResource state) throws Exception {
				return state.getResourceServiceProvider().getResourceValidator().validate(state, CheckMode.ALL, null);
			}
		});
	}

	private Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new XtextRuntimeModule(),
				new org.eclipse.xtext.xtext.ui.internal.XtextUIModuleInternal(Activator.getDefault()), new SharedStateModule()));
	}

	private IWorkbenchPage getActivePage() {
		return getWorkbenchWindow().getActivePage();
	}

	private IWorkbenchWindow getWorkbenchWindow() {
		return getWorkbench().getActiveWorkbenchWindow();
	}

	private IWorkbench getWorkbench() {
		return PlatformUI.getWorkbench();
	}
}

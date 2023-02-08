/*******************************************************************************
 * Copyright (c) 2010, 2020 Michael Clay and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.quickfix;

import static java.util.Arrays.*;
import static org.eclipse.xtext.xtext.XtextConfigurableIssueCodes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xtext.RuleWithoutInstantiationInspector;
import org.eclipse.xtext.xtext.XtextLinkingDiagnosticMessageProvider;
import org.eclipse.xtext.xtext.ui.XtextUiInjectorProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Arne Deutsch - New test cases for fixAddAction and some refactoring
 * @author Tamas Miklossy - Refactoring
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextUiInjectorProvider.class)
public class XtextGrammarQuickfixProviderTest extends AbstractQuickfixTest {

	@Before
	public void assertEmptyWorkspace() {
		IProject[] allProjects = IResourcesSetupUtil.root().getProjects();
		Assert.assertEquals(0, allProjects.length);
	}

	@Test
	public void testFixMissingRule() throws Exception {
		assertAndApplySingleResolution(editorForGrammar("Model: elements+=AbstractElement;"),
				XtextLinkingDiagnosticMessageProvider.UNRESOLVED_RULE, 1, "Create rule 'AbstractElement'", false);
	}

	@Test
	public void testFixInvalidMetaModelName() throws Exception {
		String model = Strings.concat(System.lineSeparator(), Arrays.asList("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
				"generate MYDSL \"http://www.xtext.org/example/mydsl/MyDsl\"", "Model: a=ID;"));
		XtextEditor xtextEditor = openInEditor(model);
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
	public void testFixKeywordWithSpaces() throws Exception {
		assertAndApplySingleResolution(editorForGrammar("Model: ' a b c d ' a=ID;"), SPACES_IN_KEYWORD, 0,
				"Fix keyword with spaces");
	}

	@Test
	public void testFixEmptyKeywordWithSpaces() throws Exception {
		assertAndApplySingleResolution(editorForGrammar("Model: '   ' a=ID;"), SPACES_IN_KEYWORD, 0,
				"Fix keyword with spaces");
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
		String model = Strings.concat(System.lineSeparator(),
				Arrays.asList("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
						"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\" as my",
						"Model returns my::Greeting: greetings+=Greeting*;", "Greeting returns my::Greeting: 'Hello' name=ID? '!';"));
		XtextEditor xtextEditor = openInEditor(model);
		assertAndApplySingleResolution(xtextEditor, RuleWithoutInstantiationInspector.ISSUE_CODE, 0,
				"Add actions to ensure object creation");
	}

	@Test
	public void testConvertTerminalFragmentToTerminalRule() throws Exception {
		assertAndApplySingleResolution(editorForGrammar("Model: abc=ABC;", "terminal fragment ABC: 'a';"),
				INVALID_TERMINAL_FRAGMENT_RULE_REFERENCE, 0, "Convert terminal fragment to terminal rule");
	}
	
	@Test
	public void testConvertTerminalFragmentWithInlineCommentToTerminalRule() throws Exception {
		assertAndApplySingleResolution(editorForGrammar("Model: abc=ABC;", "terminal fragment/*comment*/ABC: 'a';"),
				INVALID_TERMINAL_FRAGMENT_RULE_REFERENCE, 0, "Convert terminal fragment to terminal rule");
	}
	
	@Test
	public void testFixInvalidHiddenToken() throws Exception {
		assertAndApplySingleResolution(editorForGrammar("Model hidden(ABC): a=ID;", "terminal fragment ABC: 'a';"),
				INVALID_HIDDEN_TOKEN_FRAGMENT, 1, "Remove hidden token definition");
	}
	
	@Test
	public void testFixInvalidHiddenTokenInGrammarDefinition() throws Exception {
		String model = Strings.concat(System.lineSeparator(),
				Arrays.asList("grammar org.xtext.example.mydsl.MyDsl hidden(ABC)",
						"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"", 
						"import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore",
						"Model: pqr=PQR;", "terminal fragment ABC: 'a';", "terminal PQR: 'p';"));

		XtextEditor xtextEditor = openInEditor(model);
		assertAndApplySingleResolution(xtextEditor, INVALID_HIDDEN_TOKEN_FRAGMENT, 1,
				"Remove hidden token definition");
	}
	
	@Test
	public void testFixInvalidEnumRuleHiddenToken() throws Exception {
		assertAndApplySingleResolution(editorForGrammar("Model hidden(ABC): a=ID;", "enum ABC: A|B|C;"), INVALID_HIDDEN_TOKEN, 1,
				"Remove hidden token definition");
	}

	@Test
	public void testFixInvalidParserRuleHiddenToken() throws Exception {
		assertAndApplySingleResolution(editorForGrammar("Model hidden(Greeting): a=ID;", "Greeting: name=ID;"), INVALID_HIDDEN_TOKEN, 1,
				"Remove hidden token definition");
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
		IXtextDocument document = xtextEditor.getDocument();
		List<Issue> issues = getIssues(document);
		assertFalse(issues.toString(), issues.isEmpty());
		Optional<Issue> issue = issues.stream().filter(i -> issueCode.equals(i.getCode())).findFirst();
		assertTrue(issue.isPresent());
		assertNotNull(issue.get().getData());
		assertEquals(issueDataCount, issue.get().getData().length);
		List<IssueResolution> resolutions = issueResolutionProvider.getResolutions(issue.get());
		resolutions = resolutions.stream().filter(resolution -> resolutionLabel.equals(resolution.getLabel())).collect(Collectors.toList());
		assertFalse(resolutions.isEmpty());
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
		return openInEditor(grammarGeneratingModel(bodyContent));
	}
	
	private XtextEditor openInEditor(String content) {
		IFile file = dslFile(getProjectName(), getFileName(), getFileExtension(), content);
		return openInEditor(file);
	}

	private String grammarGeneratingModel(String... bodyContent) {
		List<String> list = new ArrayList<>();
		list.add("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
		list.add("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
		list.addAll(Arrays.asList(bodyContent));
		return Strings.concat(System.lineSeparator(), list);
	}

	private List<Issue> getIssues(IXtextDocument document) {
		return document.readOnly(new IUnitOfWork<List<Issue>, XtextResource>() {
			@Override
			public List<Issue> exec(XtextResource state) throws Exception {
				return state.getResourceServiceProvider().getResourceValidator().validate(state, CheckMode.ALL, null);
			}
		});
	}
}

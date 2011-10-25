/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.quickfix;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xtext.XtextLinkingDiagnosticMessageProvider;
import org.eclipse.xtext.xtext.XtextValidator;
import org.eclipse.xtext.xtext.ui.Activator;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class XtextGrammarQuickfixProviderTest extends AbstractXtextTests {

	private static final String PROJECT_NAME = "org.eclipse.xtext.ui.editor.quickfix";
	private static final String MODEL_FILE = "XtextGrammarQuickfixProviderTest.xtext";
	private static final String GRAMMAR_WITH_MISSING_RULE = Strings.concat("\n", Arrays.asList(
			"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
			"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"", 
			"Model: elements+=AbstractElement;"));
	private static final String GRAMMAR_WITH_INVALID_MM_NAME = Strings.concat("\n", Arrays.asList(
			"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
			"generate MYDSL \"http://www.xtext.org/example/mydsl/MyDsl\"", 
			"Model: a=ID;"));
//	private static final String GRAMMAR_WITH_INVALID_MM_ALIAS = Strings.concat("\n", Arrays.asList(
//			"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
//			"import '" + EcorePackage.eINSTANCE.getNsURI() + "' as ecore\n" +
//			"import '" + XtextPackage.eINSTANCE.getNsURI() + "' as ecore\n" +
//			"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"", 
//			"Model: a=ID;"));
	private static final String GRAMMAR_WITH_EMPTY_ENUM_LITERAL = Strings.concat("\n", Arrays.asList(
			"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
			"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"", 
			"Model: a=ID;",
			"enum ABCD: A|B|C=''|D;"));
	private static final String GRAMMAR_WITH_INVALID_ACTION_IN_UOG = Strings.concat("\n", Arrays.asList(
			"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals",
			"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"", 
			"Model: a=ID;",
			"Modifier: {Modifier} static?='static' & final?='final';"));
	
	public void testFixMissingRule() throws Exception {
		XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, GRAMMAR_WITH_MISSING_RULE);
		assertAndApplySingleResolution(xtextEditor, XtextLinkingDiagnosticMessageProvider.UNRESOLVED_RULE, 1,
				"Create rule 'AbstractElement'", false);
	}
	
//	see https://bugs.eclipse.org/bugs/show_bug.cgi?id=324566
//	public void testFixInvalidMetaModelAlias() throws Exception {
//		XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, GRAMMAR_WITH_INVALID_MM_ALIAS);
//		assertAndApplySingleResolution(xtextEditor, XtextValidator.INVALID_METAMODEL_ALIAS, 1,
//				"Remove 'ecore' alias");
//	}

	public void testFixInvalidMetaModelName() throws Exception {
		XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, GRAMMAR_WITH_INVALID_MM_NAME);
		assertAndApplySingleResolution(xtextEditor, XtextValidator.INVALID_METAMODEL_NAME, 1,
				"Fix metamodel name 'MYDSL'");
	}
	
	public void testFixEmptyEnumLiteral() throws Exception {
		XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, GRAMMAR_WITH_EMPTY_ENUM_LITERAL);
		assertAndApplySingleResolution(xtextEditor, XtextValidator.EMPTY_ENUM_LITERAL, 1,
				"Fix empty enum literal");
	}
	
	public void testFixInvalidAction() throws Exception {
		XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, GRAMMAR_WITH_INVALID_ACTION_IN_UOG);
		assertAndApplySingleResolution(xtextEditor, XtextValidator.INVALID_ACTION_USAGE, 0,
				"Fix invalid action usage");
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
		resolution.apply();
		assertEquals(getIssues(document).toString(), isCleanAfterApply, getIssues(document).isEmpty());
		xtextEditor.doSave(new NullProgressMonitor());

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
			public List<Issue> exec(XtextResource state) throws Exception {
				return state.getResourceServiceProvider().getResourceValidator().validate(state, CheckMode.ALL, null);
			}
		});
	}

	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new XtextRuntimeModule(), new org.eclipse.xtext.ui.XtextUiModule(
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

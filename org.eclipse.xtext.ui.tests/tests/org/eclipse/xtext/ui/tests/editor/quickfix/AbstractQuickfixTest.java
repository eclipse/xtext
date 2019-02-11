/*******************************************************************************
 * Copyright (c) 2010, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.source.TextInvocationContext;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator2;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator;
import org.eclipse.xtext.ui.editor.quickfix.WorkbenchMarkerResolutionAdapter;
import org.eclipse.xtext.ui.testing.AbstractWorkbenchTest;
import org.eclipse.xtext.ui.testing.util.AnnotatedTextToString;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractQuickfixTest extends AbstractWorkbenchTest {

	private static boolean WAS_AUTOBUILD;

	@BeforeClass
	public static void beforeClass() throws Exception {
		WAS_AUTOBUILD = IResourcesSetupUtil.setAutobuild(false);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		IResourcesSetupUtil.setAutobuild(WAS_AUTOBUILD);
	}

	protected XtextEditor newXtextEditor(String projectName, String modelFile, String model) throws CoreException, PartInitException {
		IJavaProject javaProject = JavaProjectSetupUtil.createJavaProject(projectName);
		IFile file = createFile(javaProject.getProject(), modelFile, model);
		XtextEditor xtextEditor = (XtextEditor) IDE.openEditor(getActivePage(), file);
		return xtextEditor;
	}

	protected XtextEditor newXtextEditor(IProject project, String modelFile, String model) throws CoreException, PartInitException {
		IFile file = createFile(project, modelFile, model);
		XtextEditor xtextEditor = (XtextEditor) IDE.openEditor(getActivePage(), file);
		return xtextEditor;
	}

	protected IFile createFile(IProject project, String modelFile, String model) throws CoreException {
		IFile file = project.getFile(modelFile);
		if (file.exists()) {
			file.delete(true, null);
		}
		file.create(new StringInputStream(model), true, null);
		file.refreshLocal(IResource.DEPTH_ONE, null);
		return file;
	}

	protected IProject createGeneralXtextProject(String name) {
		IProject project;
		try {
			project = IResourcesSetupUtil.createProject(name);
			IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
			IResourcesSetupUtil.addBuilder(project, XtextProjectHelper.BUILDER_ID);
			return project;
		} catch (InvocationTargetException | CoreException | InterruptedException e) {
			Exceptions.sneakyThrow(e);
			return null;
		}
	}
	
	protected ICompletionProposal[] computeQuickAssistProposals(XtextEditor editor, String text) {
		int idx = editor.getDocument().get().indexOf(text);
		return computeQuickAssistProposals(editor, idx);
	}
	
	protected ICompletionProposal[] computeQuickAssistProposals(XtextEditor editor, int offset) {
		IResourcesSetupUtil.waitForBuild();
		XtextSourceViewer sourceViewer = (XtextSourceViewer) editor.getInternalSourceViewer();
		QuickAssistAssistant quickAssistAssistant = (QuickAssistAssistant) sourceViewer.getQuickAssistAssistant();
		IQuickAssistProcessor quickAssistProcessor = quickAssistAssistant.getQuickAssistProcessor();
		ICompletionProposal[] quickAssistProposals = quickAssistProcessor
				.computeQuickAssistProposals(new TextInvocationContext(sourceViewer, offset, -1));
		return quickAssistProposals;
	}

	protected Injector getInjector() {
		return TestsActivator.getInstance().getInjector("org.eclipse.xtext.ui.tests.quickfix.QuickfixCrossrefTestLanguage");
	}

	protected List<Issue> getIssues(IXtextDocument document) {
		return document.readOnly(new IUnitOfWork<List<Issue>, XtextResource>() {
			@Override
			public List<Issue> exec(XtextResource state) throws Exception {
				return state.getResourceServiceProvider().getResourceValidator().validate(state, CheckMode.ALL, null);
			}
		});
	}

	protected IMarker[] getMarkers(IFile file) {
		IResourcesSetupUtil.waitForBuild();
		try {
			return file.findMarkers(MarkerTypes.FAST_VALIDATION, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			Exceptions.sneakyThrow(e);
			return null;
		}
	}

	protected void assertContentsAndMarkers(IFile file, CharSequence expectation) {
		assertContentsAndMarkers(file, getMarkers(file), expectation);
	}

	protected void assertContentsAndMarkers(IFile file, IMarker[] markers, CharSequence expectation) {
		String actual = new AnnotatedTextToString().withFile(file).withMarkers(markers).toString().trim();
		String exp = expectation.toString().trim();
		Assert.assertEquals(Strings.toUnixLineSeparator(exp), Strings.toUnixLineSeparator(actual));
	}

	protected void applyQuickfixOnMultipleMarkers(IMarker[] markers) {
		MarkerResolutionGenerator generator = getInjector().getInstance(MarkerResolutionGenerator.class);
		IMarker primaryMarker = markers[0];
		IMarkerResolution[] resolutions = generator.getResolutions(primaryMarker);
		Assert.assertEquals(1, resolutions.length);
		assertTrue(resolutions[0] instanceof WorkbenchMarkerResolution);
		WorkbenchMarkerResolution resolution = (WorkbenchMarkerResolution) resolutions[0];
		List<IMarker> others = Lists.newArrayList(resolution.findOtherMarkers(markers));
		assertFalse(others.contains(primaryMarker));
		assertEquals(markers.length - 1, others.size());
		others.add(primaryMarker);
		resolution.run(others.toArray(new IMarker[others.size()]), new NullProgressMonitor());
	}

	protected void applyQuickfixOnSingleMarkers(IMarker marker) {
		IMarkerResolutionGenerator2 generator = getInjector().getInstance(MarkerResolutionGenerator.class);
		IMarkerResolution[] resolutions = generator.getResolutions(marker);
		Assert.assertEquals(1, resolutions.length);
		IMarkerResolution resolution = resolutions[0];
		resolution.run(marker);
	}
}

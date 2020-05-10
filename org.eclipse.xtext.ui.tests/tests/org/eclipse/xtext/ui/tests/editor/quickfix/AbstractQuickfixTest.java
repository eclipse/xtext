/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.source.TextInvocationContext;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator2;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.AnnotatedTextToString;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
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
public abstract class AbstractQuickfixTest extends AbstractEditorTest {

	private static boolean WAS_AUTOBUILD;

	@BeforeClass
	public static void beforeClass() throws Exception {
		WAS_AUTOBUILD = IResourcesSetupUtil.setAutobuild(false);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		IResourcesSetupUtil.setAutobuild(WAS_AUTOBUILD);
	}
	
	protected IFile dslFile(String projectName, String fileName, CharSequence content) {
		return dslFile(projectName, fileName, getFileExtension(), content);
	}

	@Override
	protected String getEditorId() {
		XtextEditorInfo editorInfo = getInjector().getInstance(XtextEditorInfo.class);
		return editorInfo.getEditorId();
	}

	protected String getFileExtension() {
		FileExtensionProvider fileExtensionProvider = getInjector().getInstance(FileExtensionProvider.class);
		return fileExtensionProvider.getPrimaryFileExtension();
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
		long seed = new Random().nextLong();
		// System out is intended so that the seed used can be recovered on failures
		System.out.println(seed);
		Collections.shuffle(others, new Random(seed));
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

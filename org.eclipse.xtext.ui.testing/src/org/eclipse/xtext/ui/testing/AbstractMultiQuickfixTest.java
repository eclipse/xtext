/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.testing;

import java.util.Arrays;
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
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator;
import org.eclipse.xtext.ui.testing.util.AnnotatedTextToString;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import com.google.common.annotations.Beta;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.23
 */
@Beta
public abstract class AbstractMultiQuickfixTest extends AbstractEditorTest {

	@Inject
	protected MarkerResolutionGenerator markerResolutionGenerator;

	@Inject
	protected FileExtensionProvider fileExtensionProvider;

	private static boolean WAS_AUTOBUILD;

	@BeforeClass
	public static void beforeClass() throws Exception {
		WAS_AUTOBUILD = IResourcesSetupUtil.setAutobuild(false);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		IResourcesSetupUtil.setAutobuild(WAS_AUTOBUILD);
	}

	/**
	 * Test that the multi-quickfixes work as expected.
	 * 
	 * @param initialText
	 *            the initial DSL text.
	 * @param initialTextWithMarkers
	 *            the initial DSL text enhanced by the recognized marker information.
	 * @param resultTextWithMarkers
	 *            the result DSL text enhanced by the recognized marker information after applying all the quickfixes.
	 */
	public void testMultiQuickfix(CharSequence initialText, CharSequence initialTextWithMarkers, CharSequence resultTextWithMarkers) {
		// Given
		IFile file = dslFile(initialText);
		IMarker[] markers = getMarkers(file);
		assertContentsAndMarkers(file, markers, initialTextWithMarkers);
		
		// When
		applyQuickfixOnMultipleMarkers(markers);
		
		// Then
		assertContentsAndMarkers(file, resultTextWithMarkers);
	}

	protected IFile dslFile(CharSequence content) {
		return dslFile(getProjectName(), getFileName(), getFileExtension(), content);
	}

	protected String getProjectName() {
		return "MultiQuickfixTestProject";
	}

	protected String getFileName() {
		return "multiquickfix";
	}

	protected String getFileExtension() {
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
		IMarker primaryMarker = markers[0];
		IMarkerResolution[] resolutions = markerResolutionGenerator.getResolutions(primaryMarker);
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
		IMarkerResolution[] resolutions = markerResolutionGenerator.getResolutions(marker);
		Assert.assertEquals(1, resolutions.length);
		IMarkerResolution resolution = resolutions[0];
		resolution.run(marker);
	}
	
	/**
	 * @since 2.25
	 */
	protected IMarker getFirstMarker(IMarker[] markers) {
		IMarker firstMarker = Iterables.getFirst(IterableExtensions.sortBy(Arrays.asList(markers), (IMarker it) -> {
			try {
				return ((Integer) it.getAttribute(IMarker.CHAR_START));
			} catch (CoreException e) {
				throw Exceptions.sneakyThrow(e);
			}
		}), null);
		return firstMarker;
	}
}

/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix

import com.google.inject.Injector
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.ui.PlatformUI
import org.eclipse.xtext.junit4.internal.InternalBuilderTest
import org.eclipse.xtext.ui.MarkerTypes
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.quickfix.MarkerResolutionGenerator
import org.eclipse.xtext.ui.editor.quickfix.WorkbenchMarkerResolutionAdapter
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil
import org.junit.Test

import static org.eclipse.xtext.junit4.internal.InternalBuilderTest.*

/**
 * @author dhuebner - Initial contribution and API
 */
class MultiQuickFixTest extends AbstractQuickfixTest {

	private static final String PROJECT_NAME = "quickfixtest";
	private static final String MODEL_FILE = "test.quickfixcrossreftestlanguage";
	private static final String MODEL_WITH_WARNINGS = '''
	"no doc"
	Foo { ref Bor }
	"no doc" Bor { }'''
	private static final String MODEL_WITH_WARNINGS_2 = '''
	"bad doc"
	Foo { ref Bor }
	"bad doc"
	Bor { }'''

	@Test
	def void testMultiIssueResolution() throws Exception {
		val expectedIssues = 4
		var Injector injector = getInjector()
		var MarkerResolutionGenerator resolutionGenerator = injector.getInstance(MarkerResolutionGenerator)

		val XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, MODEL_WITH_WARNINGS_2)
		val resource = xtextEditor.getResource()
		closeXtextEditor(xtextEditor)
		IResourcesSetupUtil.addBuilder(resource.project, XtextProjectHelper.BUILDER_ID)
		IResourcesSetupUtil.addNature(resource.project, XtextProjectHelper.NATURE_ID)
		createFile('''other_«MODEL_FILE»''', MODEL_WITH_WARNINGS_2, resource.getProject())

		var problems = collectMarkers(resource)
		assertEquals(expectedIssues, problems.length)

		val resolutions = resolutionGenerator.getResolutions(problems.get(0))
		assertEquals(1, resolutions.length)
		assertTrue(resolutions.get(0) instanceof WorkbenchMarkerResolutionAdapter)
		val allMarkers = ((resolutions.get(0) as WorkbenchMarkerResolutionAdapter)).findOtherMarkers(problems)
		assertEquals(expectedIssues, allMarkers.length)

		((resolutions.get(0) as WorkbenchMarkerResolutionAdapter)).run(allMarkers, new NullProgressMonitor())

		val findMarkers = collectMarkers(resource)
		assertEquals(0, findMarkers.length)
	}

	def closeXtextEditor(XtextEditor editor) {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editor, true);
		while (PlatformUI.getWorkbench().getActiveWorkbenchWindow().activePage.activeEditor !== null) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(true);
			println("wait for close")
			Thread.sleep(100)
		}
	}

	protected def IMarker[] collectMarkers(IResource resource) {
		InternalBuilderTest.autoBuild = true
		IResourcesSetupUtil.reallyWaitForAutoBuild
		val markers = resource.getProject().findMarkers(MarkerTypes.FAST_VALIDATION, true, IResource.DEPTH_INFINITE)
		InternalBuilderTest.autoBuild = false
		return markers
	}

	@Test
	def void testPreInitializedIssueResolution() throws Exception {

		var Injector injector = getInjector()
		var MarkerResolutionGenerator resolutionGenerator = injector.getInstance(MarkerResolutionGenerator)
		val XtextEditor xtextEditor = newXtextEditor(PROJECT_NAME, MODEL_FILE, MODEL_WITH_WARNINGS)
		val resource = xtextEditor.getResource()

		closeXtextEditor(xtextEditor)
		IResourcesSetupUtil.addNature(resource.project, XtextProjectHelper.NATURE_ID)
		IResourcesSetupUtil.addBuilder(resource.project, XtextProjectHelper.BUILDER_ID)

		createFile('''other_«MODEL_FILE»''', MODEL_WITH_WARNINGS, resource.getProject())

		var problems = collectMarkers(resource)
		assertEquals(4, problems.length)

		val resolutions = resolutionGenerator.getResolutions(problems.get(0))
		assertEquals(1, resolutions.length)
		assertTrue(resolutions.get(0) instanceof WorkbenchMarkerResolutionAdapter)
		val allMarkers = ((resolutions.get(0) as WorkbenchMarkerResolutionAdapter)).findOtherMarkers(problems)
		assertEquals(4, allMarkers.length)

		((resolutions.get(0) as WorkbenchMarkerResolutionAdapter)).run(allMarkers, new NullProgressMonitor())

		val findMarkers = collectMarkers(resource)
		assertEquals(0, findMarkers.length)
	}
}

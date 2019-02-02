/*******************************************************************************
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.testing

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput
import org.eclipse.jface.text.IRegion
import org.eclipse.jface.text.ITextHoverExtension2
import org.eclipse.jface.text.Region
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.hover.IEObjectHover
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil

import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.addNature

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.16
 */
abstract class AbstractHoverTest extends AbstractEditorTest {

	@Inject protected IEObjectHover eObjectHover

	@Inject protected extension SyncUtil
	@Inject protected extension FileExtensionProvider

	/**
	 * Test that the expected text appears in a popup window while hovering over a certain text in a given DSL text.
	 * 
	 * @param it the initial DSL text.
	 * @param hoverText the text you are hovering over.
	 * @param hoverContent the text that is expected to be part of the hover popup.
	 */
	def void hasHoverOver(CharSequence it, String hoverText, String hoverContent) {
		hasHoverOver(new Region(toString.indexOf(hoverText), hoverText.length), hoverContent)
	}

	/**
	 * Test that the expected text appears in a popup window while hovering over a certain region in a given DSL text.
	 * 
	 * @param it the initial DSL text.
	 * @param hoverRegion the region you are hovering over.
	 * @param hoverContent the text that is expected to be part of the hover popup.
	 */
	def void hasHoverOver(CharSequence it, IRegion hoverRegion, String hoverContent) {
		// given
		dslFile.
		// when
		hoveringOver(hoverRegion).
		// then
		hoverPopupHasContent(hoverContent)
	}

	protected def IFile dslFile(CharSequence content) {
		val file = IResourcesSetupUtil.createFile(projectName, fileName, fileExtension, content.toString)

		/*
		 * TODO: find a better (with good performance) solution
		 * to set the Xtext nature on the test project.
		 */
		val project = file.project
		if(!project.hasNature(XtextProjectHelper.NATURE_ID)) {
			project.addNature(XtextProjectHelper.NATURE_ID)
		}

		file
	}

	protected def String getProjectName() {
		"HoverTestProject"
	}

	protected def String getFileName() {
		"hover"
	}

	protected def String getFileExtension() {
		primaryFileExtension
	}

	protected def XtextEditor openInEditor(IFile dslFile) {
		/*
		 * wait for the cross-reference resolution
		 */
		waitForBuild(new NullProgressMonitor)
		dslFile.openEditor
	}

	protected def BrowserInformationControlInput hoveringOver(IFile dslFile, IRegion hoverRegion) {
		val editor = dslFile.openInEditor
		val textHover = eObjectHover as ITextHoverExtension2
		textHover.getHoverInfo2(editor.internalSourceViewer, hoverRegion) as BrowserInformationControlInput
	}

	protected def void hoverPopupHasContent(BrowserInformationControlInput info, String expectedHoverContent) {
		assertNotNull("No hover found!", info)
		val actualHoverContent = info.html
		assertTrue('''
			Could not find the text '«expectedHoverContent»' in the hover popup:
				«actualHoverContent»
		''', actualHoverContent.contains(expectedHoverContent))
	}
}
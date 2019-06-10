/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.testing

import com.google.common.annotations.Beta
import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.testing.AbstractEditorTest
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil

import static extension java.util.regex.Pattern.quote
import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.addNature

/**
 * @author miklossy - Initial contribution and API
 * @since 2.19
 */
@Beta
abstract class AbstractFoldingTest extends AbstractEditorTest {

	@Inject protected extension FileExtensionProvider
	@Inject protected extension IFoldingRegionProvider

	/**
	 * Special symbol indicating the beginning of a folding region.
	 */
	def String b() '''[>'''

	/**
	 * Special symbol indicating the end of a folding region.
	 */
	def String e() '''<]'''

	/**
	 * Test that the expected folding regions are present on a given DSL text.
	 *
	 * @param it The DSL text where the expected folding regions are enclosed by the {@link #b() b} and {@link #e() e} symbols.
	 */
	def void testFoldingRegions(CharSequence it) {
		// given
		dslFile.
		// when
		openInEditor.
		// then
		foldingRegionsArePresent(it)
	}

	protected def IFile dslFile(CharSequence text) {
		val file = IResourcesSetupUtil.createFile(projectName, fileName, fileExtension, text.content)

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
		"FoldingTestProject"
	}

	protected def String getFileName() {
		"folding"
	}

	protected def String getFileExtension() {
		primaryFileExtension
	}

	protected def String getContent(CharSequence text) {
		text.toString.replaceAll(b.quote, "").replaceAll(e.quote, "")
	}

	protected def IXtextDocument openInEditor(IFile dslFile) {
		val document = dslFile.openEditor.document
		document.assertNotNull
		document
	}

	protected def foldingRegionsArePresent(IXtextDocument document, CharSequence expected) {
		val actual = document.insertFoldingRegionMarkers
		expected.toString.trim.assertEquals(actual)
	}

	protected def insertFoldingRegionMarkers(IXtextDocument document) {
		val lineSeparator = System.lineSeparator
		val lines = document.get.split(lineSeparator).toList

		for (foldingRegion : document.foldingRegions) {
			// insert the beginning folding region marker at the beginning of the corresponding line
			val startLine = document.getLineOfOffset(foldingRegion.offset)
			lines.set(startLine, b + lines.get(startLine))

			// insert the end folding region marker at the end of the corresponding line
			val endLine = document.getLineOfOffset(foldingRegion.offset + foldingRegion.length) - 1
			lines.set(endLine, lines.get(endLine) + e)
		}

		lines.join(lineSeparator)
	}
}

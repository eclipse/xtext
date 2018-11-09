/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.testing

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.linking.lazy.LazyLinkingResource
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.XtextEditorInfo
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.validation.Issue

import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.addNature

/**
 * @author miklossy - Initial contribution and API
 * @since 2.16
 */
abstract class AbstractQuickfixTest extends AbstractEditorTest {

	@Inject protected Injector injector
	@Inject protected XtextEditorInfo editorInfo
	@Inject protected IResourceSetProvider resourceSetProvider

	@Inject protected extension SyncUtil
	@Inject protected extension IResourceValidator
	@Inject protected extension FileExtensionProvider
	@Inject protected extension IssueResolutionProvider
	
	protected IProject project

	override protected getEditorId() {
		editorInfo.getEditorId
	}

	/**
	 * Test that the expected quickfixes are offered on a given validation issue in a given DSL text.
	 *
	 * @param it The initial DSL text.
	 * @param issueCode The code of the validation issue to that the offered quickfixes are to test.
	 * @param quickfixes The quickfixes that are expected to be offered on the given <code>issueCode</code>.
	 * Each expected quickfix should be described by the following triple:
	 * <ol>
	 * 	<li>the quickfix label</li>
	 * 	<li>the quickfix description</li>
	 * 	<li>the DSL text after the quickfix application</li>
	 * </ol>
	 */
	def void testQuickfixesOn(CharSequence it, String issueCode, Quickfix... quickfixes) {
		// given
		dslFile.
		// when
		openInEditor.
		// then
		quickfixesAreOffered(issueCode, quickfixes)
	}

	protected def IFile dslFile(CharSequence content) {
		val file = IResourcesSetupUtil.createFile(projectName, fileName, fileExtension, content.toString)

		/*
		 * TODO: find a better (with good performance) solution
		 * to set the Xtext nature on the test project.
		 */
		project = file.project
		if(!project.hasNature(XtextProjectHelper.NATURE_ID)) {
			project.addNature(XtextProjectHelper.NATURE_ID)
		}

		file
	}

	protected def String getProjectName() {
		"QuickfixTestProject"
	}

	protected def String getFileName() {
		"quickfix"
	}

	protected def String getFileExtension() {
		primaryFileExtension
	}

	protected def XtextEditor openInEditor(IFile dslFile) {
		/*
		 * wait for the cross-reference resolution
		 */
		new NullProgressMonitor().waitForBuild
		dslFile.openEditor
	}

	protected def void quickfixesAreOffered(XtextEditor editor, String issueCode, Quickfix... expected) {
		val document = editor.document
		val originalText = document.get
		val issue = document.getValidationIssue(issueCode)

		val actualIssueResolutions = issue.getResolutions
		assertEquals("The number of quickfixes does not match!", expected.size, actualIssueResolutions.size)
		for (i : 0..< actualIssueResolutions.size) {
			val actualIssueResolution = actualIssueResolutions.get(i)
			val expectedIssueResolution = expected.get(i)
			expectedIssueResolution.label.assertEquals(actualIssueResolution.label)
			expectedIssueResolution.description.assertEquals(actualIssueResolution.description)
			expectedIssueResolution.result.assertIssueResolutionResult(actualIssueResolution, originalText)
		}
	}

	protected def Issue getValidationIssue(IXtextDocument document, String issueCode) {
		val issues = document.readOnly [
			validate(CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl)
		]

		val issueCandidates = issues.filter[code == issueCode]
		assertEquals("There should be one '" + issueCode + "' validation issue!", 1, issueCandidates.size)
		issueCandidates.head
	}

	protected def void assertIssueResolutionResult(String expectedResult, IssueResolution actualIssueResolution, String originalText) {
		/*
		 * manually create an IModificationContext with an XtextDocument and call the
		 * apply method of the actualIssueResolution with that IModificationContext
		 */
		val document = originalText.getDocument
		val modificationContext = new TestModificationContext
		modificationContext.document = document
		new IssueResolution(actualIssueResolution.label, actualIssueResolution.description,
			actualIssueResolution.image, modificationContext, actualIssueResolution.modification,
			actualIssueResolution.relevance).apply
		val actualResult = document.get
		expectedResult.assertEquals(actualResult)
	}

	private static class TestModificationContext implements IModificationContext {
		IXtextDocument doc

		override getXtextDocument() {
			doc
		}

		override getXtextDocument(URI uri) {
			doc
		}

		def setDocument(IXtextDocument doc) {
			this.doc = doc
		}

	}

	@Data
	protected static class Quickfix {
		String label
		String description
		String result
	}

	/**
	 * The implementation of the following helper methods are taken from the
	 * org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder class.
	 */
	protected def IXtextDocument getDocument(String model) {
		val xtextResource = model.getXtextResource
		val document = injector.getInstance(XtextDocument)
		document.set(model)
		document.setInput(xtextResource)
		document
	}

	protected def XtextResource getXtextResource(String model) {
		val in = new StringInputStream(Strings.emptyIfNull(model))
		val uri = URI.createURI("") // creating an in-memory EMF Resource
		
		val rs = resourceSetProvider.get(project)
		val resource = injector.getInstance(IResourceFactory).createResource(uri)
		rs.resources += resource
		resource.load(in, null)
		if (resource instanceof LazyLinkingResource) {
			resource.resolveLazyCrossReferences(CancelIndicator.NullImpl)
		} else {
			EcoreUtil.resolveAll(resource)
		}
		resource as XtextResource
	}
}
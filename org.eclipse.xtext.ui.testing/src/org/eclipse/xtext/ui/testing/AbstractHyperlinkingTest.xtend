/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.testing

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jdt.core.IType
import org.eclipse.jface.text.IRegion
import org.eclipse.jface.text.Region
import org.eclipse.jface.text.hyperlink.IHyperlink
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil
import org.eclipse.xtext.util.concurrent.IUnitOfWork

import static extension org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.addNature

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.17
 */
abstract class AbstractHyperlinkingTest extends AbstractEditorTest {

	@Inject protected extension IHyperlinkHelper
	@Inject protected extension FileExtensionProvider
	@Inject protected extension IQualifiedNameProvider
	@Inject protected extension SyncUtil

	@Inject protected IResourceSetProvider resourceSetProvider

	protected IProject project

	// position marker
	protected val c = '''<|>'''

	/**
	 * Tests that the user can navigate to the target element in a DSL text when activating the hyperlink on a certain region.
	 * 
	 * @param it
	 *            The DSL text. The text must contain the {@link #c} special symbols twice indicating the beginning and the end of the
	 *            region wehre the hyperlink navigation gets activated.
	 * @param hyperlinkTarget
	 *            The fully qualified name of the expected target element.
	 */
	def void hasHyperlinkTo(CharSequence it, String hyperlinkTarget) {
		hasHyperlinkTo(hyperlinkRegion, hyperlinkTarget)
	}

	/**
	 * Tests that the user can navigate to the target element in a DSL text when activating the hyperlink on a certain region.
	 * 
	 * @param it The initial DSL text.
	 * @param hyperlinkRegion The region where the hyperlink navigation gets activated.
	 * @param hyperlinkTarget The fully qualified name of the expected target element.
	 */
	def void hasHyperlinkTo(CharSequence it, IRegion hyperlinkRegion, String hyperlinkTarget) {
		// given
		dslFile.
		// when
		hyperlinkingOn(hyperlinkRegion.offset).
		// then
		hyperlinkIsOffered(hyperlinkRegion, hyperlinkTarget)
	}

	protected def IFile dslFile(CharSequence text) {
		val content = text.toString.replace(c, "")
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

	protected def IHyperlink[] hyperlinkingOn(IFile dslFile, int offset) {
		val editor = dslFile.openInEditor
		val document = editor.internalSourceViewer.document as IXtextDocument
		val resource = document.readOnly(new IUnitOfWork<XtextResource, XtextResource>(){

			override exec(XtextResource state) {
				state
			}
			
		})

		resource.createHyperlinksByOffset(offset, true)
	}

	protected def XtextEditor openInEditor(IFile dslFile) {
		/*
		 * wait for the cross-reference resolution
		 */
		waitForBuild(new NullProgressMonitor)
		dslFile.openEditor
	}

	protected def void hyperlinkIsOffered(IHyperlink[] hyperlinks, IRegion expectedRegion, String expectedHyperlinkTarget) {
		assertNotNull("No hyperlinks found!", hyperlinks)
		assertEquals(1, hyperlinks.length)
		val hyperlink = hyperlinks.head
		
		expectedRegion.assertEquals(hyperlink.hyperlinkRegion)
		expectedHyperlinkTarget.assertEquals(hyperlink.target)
	}

	protected def dispatch String target(JdtHyperlink hyperlink) {
		val javaElement = hyperlink.javaElement
		assertTrue(javaElement instanceof IType)
		(javaElement as IType).fullyQualifiedName
	}

	protected def dispatch String target(XtextHyperlink hyperlink) {
		val resourceSet = resourceSetProvider.get(project)
		val eObject = resourceSet.getEObject(hyperlink.URI, true)
		eObject.fullyQualifiedName.toString
	}

	protected def dispatch String target(IHyperlink hyperlink) {
		fail("Unsupported hyperlink " + hyperlink.class)
		null
	}

	protected def String getProjectName() {
		"HyperlinkingTestProject"
	}

	protected def String getFileName() {
		"hyperlinking"
	}

	protected def String getFileExtension() {
		primaryFileExtension
	}

	protected def IRegion hyperlinkRegion(CharSequence input) {
		val text = input.toString
		val first = text.indexOf(c)
		if (first==-1) {
			fail('''Can't locate the first position symbol '«c»' in the input text''')
		}
		val second = text.lastIndexOf(c)
		if (first==second) {
			fail('''Can't locate the second position symbol '«c»' in the input text''')
		}
		val offset = first
		val length = second - first - c.length
		new Region(offset, length)
	}
}
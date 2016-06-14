/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import org.eclipse.jface.text.IDocumentPartitioner
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.junit.Test
import org.eclipse.xtext.xbase.ui.editor.actions.ImportsAwareClipboardAction
import org.eclipse.ui.texteditor.ITextEditor
import java.util.ResourceBundle
import org.eclipse.jface.text.IDocument
import org.eclipse.xtext.xbase.ui.editor.XbaseEditorMessages
import org.eclipse.jface.text.ITextOperationTarget

/**
 * @author dhuebner - Initial contribution and API
 */
class ImportAwareActionTest extends AbstractXtendUITestCase {
	XtextDocument document

	override void setUp() throws Exception {
		super.setUp()
		document = get(XtextDocument)
		var IDocumentPartitioner partitioner = get(IDocumentPartitioner)
		partitioner.connect(document)
		document.setDocumentPartitioner(partitioner)
	}

	override void tearDown() throws Exception {
		document = null
		super.tearDown()
	}

	@Test
	public def void testShouldAddImportsComment() {
		assertTrue(wouldAddImport(
			"|/*
			 *
			 */
			class Simple {
			}"
		))
		assertFalse(wouldAddImport(
			"/*|
			 *
			 */
			class Simple {
			}"
		))
		assertTrue(wouldAddImport(
			"/*
			 *
			 */|
			class Simple {
			}"
		))
		assertTrue(wouldAddImport(
			"/**|
			 * 
			 */
			class Simple {
			}"
		))
		assertTrue(wouldAddImport(
			"
			/**
			 * 
			 */|
			class Simple {
			}"
		))
		assertFalse(wouldAddImport(
			"class Simple {
				// sl comment|
				String s2 = 'd'
			}"
		))
		assertTrue(wouldAddImport(
			"class Simple {
				// sl comment
				String s2 = 'd'
			}|"
		))
		assertFalse(wouldAddImport(
			"class Simple {
				// sl comment
				String s2 = 'd'
			}
			//sl comment|"
		))
	}

	@Test
	public def void testShouldAddImportsString() {
		assertFalse(wouldAddImport(
			"class Simple {
				String s2 = '|d'
			}"
		))
		assertTrue(wouldAddImport(
			"
			class Simple {
				// sl comment
				String s2 = |'d'
				String s3 = '''«s2» «s2»'''
			}"
		))
		assertTrue(wouldAddImport(
			"
			class Simple {
				String s2 = 'd'|
				String s3 = '''«s2» «s2»'''
			}"
		))
	}

	@Test
	public def void testShouldAddImportsRichString() {
		assertFalse(wouldAddImport(
			"
			class Simple {
				String s2 = 'd'
				String s3 = '''|«s2» «s2»'''
			}"
		))
		assertFalse(wouldAddImport(
			"
			class Simple {
				String s2 = 'd'
				String s3 = '''|«s2» «s2»'''
			}"
		))
		assertTrue(wouldAddImport(
			"
			class Simple {
				String s2 = 'd'
				String s3 = '''«|s2» «s2»'''
			}"
		))
		assertTrue(wouldAddImport(
			"
			class Simple {
				String s2 = 'd'
				String s3 = '''«s2» «s2»'''|
			}"
		))
		assertTrue(wouldAddImport(
			"
			class Simple {
				String s2 = 'd'
				String s3 = |'''«s2» «s2»'''
			}"
		))
	}

	def boolean wouldAddImport(String string) {
		val index = string.indexOf('|')
		document.set(string.replace('|', ''))
		val action = new ImportsAwareTestClipboardAction()
		action.shouldAddImports(document, index)
	}

	static final class ImportsAwareTestClipboardAction extends ImportsAwareClipboardAction {
		new() {
			this(XbaseEditorMessages.bundleForConstructedKeys, "", null, ITextOperationTarget.PASTE)
		}

		new(ResourceBundle bundle, String prefix, ITextEditor editor, int operationCode) {
			super(bundle, prefix, editor, operationCode)
		}

		override public shouldAddImports(IDocument document, int caretOffset) {
			super.shouldAddImports(document, caretOffset)
		}

	}
}

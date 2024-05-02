/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.highlighting

import com.google.inject.Inject
import org.eclipse.swt.widgets.Display
import org.eclipse.text.edits.ReplaceEdit
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingPresenter
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Ignore("https://github.com/eclipse/xtext-xtend/issues/880")
class HighlightingReconcilerTest extends AbstractXtendUITestCase {
	
	static val VALIDATION_TIMEOUT = 10000L
	
	@Inject extension WorkbenchTestHelper helper
	
	@Before def void start() {
		closeWelcomePage
	}
	
	@After def void close() {
		helper.tearDown
	}
	
	/**
	 *  @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=449948
	 */
	@Test def void testHighlightingRace() {
		val model = '''
			class Foo {
			  
			}
		'''
		val editor = openEditor("Foo.xtend", model)
		val document = editor.document
		new ReplaceEdit(model.indexOf('  '), 2, '  static val foo = 3').apply(document)
		document.readOnly[
			// toggle reconciling, triggers highlighting.
			// highlighting reconciler calculates positions and queues a job apply them 
			// later in the Display thread, which we currently block
		]
		new ReplaceEdit(model.indexOf('  '), 0, '  ').apply(document)
		document.readOnly[
			// toggle reconciling, queues second highlighting job
		]
		while(Display.getDefault.readAndDispatch) {
			// yield to the queued highlighting update jobs
			// - the first one should be skipped, as it refers to an outdated document state
			// - the second one should be executed
		}
		val highlighterCategory = document.positionCategories.findFirst[startsWith(HighlightingPresenter.canonicalName)]
		val semanticSnippets = document.getPositions(highlighterCategory).map[document.get(offset, length)]
		// this fails if the first highlighting job hasn't been skipped
		assertEquals('Highlighting regions broken', 3, semanticSnippets.size)
		assertEquals('Foo', semanticSnippets.head)
		assertEquals('foo', semanticSnippets.tail.head)
		assertEquals('3', semanticSnippets.lastOrNull)
	}
	
	@Test def void testOpenedEditorHasSemanticHighlighting() {
		val model = '''
			class Foo {
			  static val foo = ''
			}
		'''
		val editor = openEditor("Foo.xtend", model)
		val document = editor.document
//		document.readOnly[
//			// toggle reconciling, queues second highlighting job
//		]
		awaitUIUpdate([
			val highlighterCategory = document.positionCategories.findFirst[startsWith(HighlightingPresenter.canonicalName)]
			val semanticSnippets = document.getPositions(highlighterCategory).map[document.get(offset, length)]
			semanticSnippets.size > 0
		],VALIDATION_TIMEOUT)
		val highlighterCategory = document.positionCategories.findFirst[startsWith(HighlightingPresenter.canonicalName)]
		val semanticSnippets = document.getPositions(highlighterCategory).map[document.get(offset, length)]
		// this fails if the first highlighting job didn't color the document
		assertEquals('Highlighting regions broken ' + semanticSnippets.join(','), 2, semanticSnippets.size)
		assertEquals('Foo', semanticSnippets.head)
		assertEquals('foo', semanticSnippets.lastOrNull)
	}
}
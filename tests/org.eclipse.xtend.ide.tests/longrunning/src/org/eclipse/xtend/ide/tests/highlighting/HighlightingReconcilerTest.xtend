/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.highlighting

import com.google.inject.Inject
import org.eclipse.swt.widgets.Display
import org.eclipse.text.edits.ReplaceEdit
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingPresenter
import org.junit.After
import org.junit.Test

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class HighlightingReconcilerTest extends AbstractXtendUITestCase {
	
	@Inject extension WorkbenchTestHelper helper
	
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
		assertEquals('Highlighting regions broken', 2, semanticSnippets.size)
		assertEquals('foo', semanticSnippets.head)
		assertEquals('3', semanticSnippets.last)
	}
}
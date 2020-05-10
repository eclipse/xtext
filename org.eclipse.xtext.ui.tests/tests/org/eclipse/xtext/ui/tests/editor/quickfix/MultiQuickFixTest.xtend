/*******************************************************************************
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix

import org.eclipse.core.resources.IMarker
import org.junit.Test

/**
 * @author dhuebner - Initial contribution and API
 */
class MultiQuickFixTest extends AbstractQuickfixTest {

	@Test
	def void testFixMultipleMarkers() throws Exception {
		val resource = dslFile("myProject", "test", '''
			"no doc"
			Foo { ref Bor }
			"no doc" Bor { }
		''')
		val markers = getMarkers(resource)
		assertContentsAndMarkers(resource, markers, '''
			<0<"no doc">0>
			Foo { ref Bor }
			<1<"no doc">1> Bor { }
			----------------------
			0: message=multiFixableIssue
			1: message=multiFixableIssue
		''')

		applyQuickfixOnMultipleMarkers(markers)
		assertContentsAndMarkers(resource, '''
			"Better documentation"
			Foo { ref Bor }
			"Better documentation" Bor { }
			------------------------------
			(no markers found)
		''')
	}

	@Test
	def void testFixSingleMarker() throws Exception {
		val resource = dslFile("myProject", "test", '''
			"no doc"
			Foo { ref Bor }
			"no doc" Bor { }
		''')
		val markers = getMarkers(resource)
		assertContentsAndMarkers(resource, markers, '''
			<0<"no doc">0>
			Foo { ref Bor }
			<1<"no doc">1> Bor { }
			----------------------
			0: message=multiFixableIssue
			1: message=multiFixableIssue
		''')
		val firstMarker = markers.sortBy[it.getAttribute(IMarker.CHAR_START) as Integer].head
		applyQuickfixOnSingleMarkers(firstMarker)
		assertContentsAndMarkers(resource, '''
			"Better documentation"
			Foo { ref Bor }
			<0<"no doc">0> Bor { }
			----------------------
			0: message=multiFixableIssue
		''')
	}

	@Test
	def void testQuickAssist() throws Exception {
		val dslFile = dslFile("myProject", "test", '''
			"no doc"
			Foo { ref Bor }
			"no doc" Bor { }
		''')
		val editor = dslFile.openEditor
		val proposals = computeQuickAssistProposals(editor, 1)
		assertEquals('''Multi fix'''.toString, proposals.map[displayString].join("\n"))
		proposals.head.apply(editor.document)
		assertEquals('''
			"Better documentation"
			Foo { ref Bor }
			"no doc" Bor { }
		'''.toString, editor.document.get)
	}
}

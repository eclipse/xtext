/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
		val resource = createGeneralXtextProject("myProject").createFile("test.quickfixcrossreftestlanguage", '''
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
		val resource = createGeneralXtextProject("myProject").createFile("test.quickfixcrossreftestlanguage", '''
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
		val editor = createGeneralXtextProject("myProject").newXtextEditor("test.quickfixcrossreftestlanguage", '''
			"no doc"
			Foo { ref Bor }
			"no doc" Bor { }
		''')
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

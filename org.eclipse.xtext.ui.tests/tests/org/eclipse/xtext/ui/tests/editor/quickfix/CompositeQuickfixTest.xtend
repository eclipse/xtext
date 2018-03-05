/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix

import org.junit.Test
import org.eclipse.core.resources.IMarker

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class CompositeQuickfixTest extends AbstractQuickfixTest {
	
	@Test
	def void testSimpleFixMultipleMarkers() throws Exception {
		val resource = createGeneralXtextProject("myProject").createFile("test.quickfixcrossreftestlanguage", '''
			"bad doc"
			Foo { ref Bor }
			"bad doc"
			Bor { }
		''')
		val markers = getMarkers(resource)
		assertContentsAndMarkers(resource, markers, '''
			<0<"bad doc">0>
			Foo { ref Bor }
			<1<"bad doc">1>
			Bor { }
			---------------
			0: message=multiFixableIssue2
			1: message=multiFixableIssue2
		''')

		applyQuickfixOnMultipleMarkers(markers)
		assertContentsAndMarkers(resource, '''
			"not bad doc"
			Foo { ref Bor }
			"not bad doc"
			Bor { }
			---------------
			(no markers found)
		''')
	}
	
	@Test
	def void testSimpleSingleMarker() throws Exception {
		val resource = createGeneralXtextProject("myProject").createFile("test.quickfixcrossreftestlanguage", '''
			"bad doc"
			Foo { ref Bor }
			"bad doc"
			Bor { }
		''')
		val markers = getMarkers(resource)
		assertContentsAndMarkers(resource, markers, '''
			<0<"bad doc">0>
			Foo { ref Bor }
			<1<"bad doc">1>
			Bor { }
			---------------
			0: message=multiFixableIssue2
			1: message=multiFixableIssue2
		''')
		val firstMarker = markers.sortBy[it.getAttribute(IMarker.CHAR_START) as Integer].head
		applyQuickfixOnSingleMarkers(firstMarker)
		assertContentsAndMarkers(resource, '''
			"not bad doc"
			Foo { ref Bor }
			<0<"bad doc">0>
			Bor { }
			---------------
			0: message=multiFixableIssue2
		''')
	}
	
	@Test
	def void testSimpleQuickAssist() throws Exception {
		val editor = createGeneralXtextProject("myProject").newXtextEditor("test.quickfixcrossreftestlanguage", '''
			"bad doc"
			Foo { ref Bor }
			"bad doc"
			Bor { }
		''')
		val proposals = computeQuickAssistProposals(editor, 1)
		assertEquals('''Multi fix 2'''.toString, proposals.map[displayString].join("\n"))
		proposals.head.apply(editor.document)
		assertEquals('''
			"not bad doc"
			Foo { ref Bor }
			"bad doc"
			Bor { }
		'''.toString, editor.document.get)
	}
	
	
	@Test
	def void testMultiFixMultipleMarkers() throws Exception {
		val resource = createGeneralXtextProject("myProject").createFile("test.quickfixcrossreftestlanguage", '''
			c {	badname { foo {} } }
			a {	badname { bar {} } }
			b {	badname { baz {} } }
		''')
		val markers = getMarkers(resource)
		assertContentsAndMarkers(resource, markers, '''
			<0<c>0> {	badname { foo {} } }
			<1<a>1> {	badname { bar {} } }
			<2<b>2> {	badname { baz {} } }
			---------------------------------
			0: message=badNameInSubelements
			1: message=badNameInSubelements
			2: message=badNameInSubelements
		''')

		applyQuickfixOnMultipleMarkers(markers)
		assertContentsAndMarkers(resource, '''
			newElement { } c {	goodname { foo {} } }
			newElement { } a {	goodname { bar {} } }
			newElement { } b {	goodname { baz {} } }
			-------------------------------------------
			(no markers found)
		''')
	}

	@Test
	def void testMultiFixSingleMarker() throws Exception {
		val resource = createGeneralXtextProject("myProject").createFile("test.quickfixcrossreftestlanguage", '''
			c {	badname { foo {} } }
			a {	badname { bar {} } }
		''')
		val markers = getMarkers(resource)
		assertContentsAndMarkers(resource, markers, '''
			<0<c>0> {	badname { foo {} } }
			<1<a>1> {	badname { bar {} } }
			---------------------------------
			0: message=badNameInSubelements
			1: message=badNameInSubelements
		''')
		val firstMarker = markers.sortBy[it.getAttribute(IMarker.CHAR_START) as Integer].head
		applyQuickfixOnSingleMarkers(firstMarker)
		assertContentsAndMarkers(resource, '''
			newElement { } c {	goodname { foo {} } }
			<0<a>0> {	badname { bar {} } }
			-------------------------------------------
			0: message=badNameInSubelements
		''')
	}
	
	@Test
	def void testMultiQuickAssist() throws Exception {
		val editor = createGeneralXtextProject("myProject").newXtextEditor("test.quickfixcrossreftestlanguage", '''
			c {	badname { foo {} } }
			a {	badname { bar {} } }
		''')
		val proposals = computeQuickAssistProposals(editor, 1)
		assertEquals('''Fix Bad Names'''.toString, proposals.map[displayString].join("\n"))
		proposals.head.apply(editor.document)
		assertEquals('''
			newElement { } c {	goodname { foo {} } }
			a {	badname { bar {} } }
		'''.toString, editor.document.get)
	}

}

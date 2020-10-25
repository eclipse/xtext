/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.xmleditor

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.ui.tests.xmleditor.simplexml.XmlDocument
import org.eclipse.xtext.ui.tests.xmleditor.tests.XmlInjectorProvider
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(XmlInjectorProvider)
class XmlParsingTest {

	@Inject extension ParseHelper<XmlDocument>
	@Inject extension ValidationTestHelper

	@Test def test001() throws Exception {
		''''''
		.parse.assertNoErrors
	}

	@Test def test002() throws Exception {
		'''<a/>'''
		.parse.assertNoErrors
	}

	@Test def test003() throws Exception {
		'''<a b=""/>'''
		.parse.assertNoErrors
	}

	@Test def test004() throws Exception {
		'''<a b="c"/>'''
		.parse.assertNoErrors
	}

	@Test def test005() throws Exception {
		'''<a b='c'/>'''
		.parse.assertNoErrors
	}

	@Test def test006() throws Exception {
		'''<a b="c" d='e'/>'''
		.parse.assertNoErrors
	}

	@Test def test007() throws Exception {
		'''<a b='c' d="e"/>'''
		.parse.assertNoErrors
	}

	@Test def test008() throws Exception {
		'''<a></a>'''
		.parse.assertNoErrors
	}

	@Test def test009() throws Exception {
		'''<a b="c"></a>'''
		.parse.assertNoErrors
	}

	@Test def test010() throws Exception {
		'''<a b='c'></a>'''
		.parse.assertNoErrors
	}
	
	@Test def test011() throws Exception {
		'''<a b='c' d="e"></a>'''
		.parse.assertNoErrors
	}

	@Test def test012() throws Exception {
		'''<a b="c" d='e'></a>'''
		.parse.assertNoErrors
	}

	@Test def test013() throws Exception {
		'''<a>text</a>'''
		.parse.assertNoErrors
	}

	@Test def test014() throws Exception {
		'''<a b="c">text</a>'''
		.parse.assertNoErrors
	}

	@Test def test015() throws Exception {
		'''
			<a>
				<b>text</b>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test016() throws Exception {
		'''
			<a>
				<b/>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test017() throws Exception {
		'''
			<a b="c">
				<d e="f"/>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test018() throws Exception {
		'''
			<a>
				<b>c</b>
				<d>e</d>
				<f/>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test019() throws Exception {
		'''
			<a>
				<b>
				<c/>
				<d>e</d>
				</b>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test020() throws Exception {
		'''
			<a>
				<b>
					<c>d</c>
					<d/>
				</b>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test021() throws Exception {
		'''
			<a>
				<b>
					<c>d</c>
					<d e='f'/>
					<g>h</g>
				</b>
			</a>
		'''.parse.assertNoErrors
	}
}

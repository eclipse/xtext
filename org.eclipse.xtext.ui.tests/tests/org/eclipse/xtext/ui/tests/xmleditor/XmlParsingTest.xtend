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

	@Test def test001() {
		''''''
		.parse.assertNoErrors
	}

	@Test def test002() {
		'''<a/>'''
		.parse.assertNoErrors
	}

	@Test def test003() {
		'''<a b=""/>'''
		.parse.assertNoErrors
	}

	@Test def test004() {
		'''<a b="c"/>'''
		.parse.assertNoErrors
	}

	@Test def test005() {
		'''<a b='c'/>'''
		.parse.assertNoErrors
	}

	@Test def test006() {
		'''<a b="c" d='e'/>'''
		.parse.assertNoErrors
	}

	@Test def test007() {
		'''<a b='c' d="e"/>'''
		.parse.assertNoErrors
	}

	@Test def test008() {
		'''<a></a>'''
		.parse.assertNoErrors
	}

	@Test def test009() {
		'''<a b="c"></a>'''
		.parse.assertNoErrors
	}

	@Test def test010() {
		'''<a b='c'></a>'''
		.parse.assertNoErrors
	}
	
	@Test def test011() {
		'''<a b='c' d="e"></a>'''
		.parse.assertNoErrors
	}

	@Test def test012() {
		'''<a b="c" d='e'></a>'''
		.parse.assertNoErrors
	}

	@Test def test013() {
		'''<a>text</a>'''
		.parse.assertNoErrors
	}

	@Test def test014() {
		'''<a b="c">text</a>'''
		.parse.assertNoErrors
	}

	@Test def test015() {
		'''
			<a>
				<b>text</b>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test016() {
		'''
			<a>
				<b/>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test017() {
		'''
			<a b="c">
				<d e="f"/>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test018() {
		'''
			<a>
				<b>c</b>
				<d>e</d>
				<f/>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test019() {
		'''
			<a>
				<b>
				<c/>
				<d>e</d>
				</b>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test020() {
		'''
			<a>
				<b>
					<c>d</c>
					<d/>
				</b>
			</a>
		'''.parse.assertNoErrors
	}

	@Test def test021() {
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

package org.eclipse.xtext.ui.tests.xmleditor

import org.junit.Rule
import org.junit.Test
import org.junit.rules.Timeout

abstract class AbstractXmlLexerTest extends AbstractLexerTest {

	@Rule public val timeout = Timeout.seconds(2)

	@Test def test001() throws Exception {
		''''''.assertLexing('''''')
	}

	@Test def test002() throws Exception {
		'''
			<a/>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_TAG_EMPTY_CLOSE '/>'
		''')
	}

	@Test def test003() throws Exception {
		'''
			<a b=""/>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			RULE_STRING '""'
			RULE_TAG_EMPTY_CLOSE '/>'
		''')
	}

	@Test def test004() throws Exception {
		'''
			<a b="c"/>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			RULE_STRING '"c"'
			RULE_TAG_EMPTY_CLOSE '/>'
		''')
	}

	@Test def test005() throws Exception {
		'''
			<a b='c'/>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			RULE_STRING ''c''
			RULE_TAG_EMPTY_CLOSE '/>'
		''')
	}

	@Test def test006() throws Exception {
		'''
			<a b="c" d='e'/>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			RULE_STRING '"c"'
			RULE_WS ' '
			RULE_ID 'd'
			RULE_ATTR_EQ '='
			RULE_STRING ''e''
			RULE_TAG_EMPTY_CLOSE '/>'
		''')
	}

	@Test def test007() throws Exception {
		'''
			<a b='c' d="e"/>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			RULE_STRING ''c''
			RULE_WS ' '
			RULE_ID 'd'
			RULE_ATTR_EQ '='
			RULE_STRING '"e"'
			RULE_TAG_EMPTY_CLOSE '/>'
		''')
	}

	@Test def test008() throws Exception {
		'''
			<a></a>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test009() throws Exception {
		'''
			<a b="c"></a>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			RULE_STRING '"c"'
			RULE_TAG_CLOSE '>'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test010() throws Exception {
		'''
			<a b='c'></a>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			RULE_STRING ''c''
			RULE_TAG_CLOSE '>'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test011() throws Exception {
		'''
			<a b='c' d="e"></a>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			RULE_STRING ''c''
			RULE_WS ' '
			RULE_ID 'd'
			RULE_ATTR_EQ '='
			RULE_STRING '"e"'
			RULE_TAG_CLOSE '>'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test012() throws Exception {
		'''
			<a b="c" d='e'></a>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			RULE_STRING '"c"'
			RULE_WS ' '
			RULE_ID 'd'
			RULE_ATTR_EQ '='
			RULE_STRING ''e''
			RULE_TAG_CLOSE '>'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test013() throws Exception {
		'''
			<a>text</a>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA 'text'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test014() throws Exception {
		'''
			<a b="c">text</a>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			RULE_STRING '"c"'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA 'text'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test015() throws Exception {
		'''
			<a>
				<b>text</b>
			</a>
		'''.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'b'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA 'text'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'b'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
			'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test016() throws Exception {
		'''
			<a>
				<b/>
			</a>
		'''.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'b'
			RULE_TAG_EMPTY_CLOSE '/>'
			RULE_PCDATA '
			'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test017() throws Exception {
		'''
			<a b="c">
				<d e="f"/>
			</a>
		'''.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			RULE_STRING '"c"'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'd'
			RULE_WS ' '
			RULE_ID 'e'
			RULE_ATTR_EQ '='
			RULE_STRING '"f"'
			RULE_TAG_EMPTY_CLOSE '/>'
			RULE_PCDATA '
			'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test018() throws Exception {
		'''
			<a>
				<b>c</b>
				<d>e</d>
				<f/>
			</a>
		'''.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'b'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA 'c'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'b'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'd'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA 'e'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'd'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'f'
			RULE_TAG_EMPTY_CLOSE '/>'
			RULE_PCDATA '
			'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test019() throws Exception {
		'''
			<a>
				<b>
				<c/>
				<d>e</d>
				</b>
			</a>
		'''.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'b'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'c'
			RULE_TAG_EMPTY_CLOSE '/>'
			RULE_PCDATA '
				'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'd'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA 'e'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'd'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'b'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
			'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test020() throws Exception {
		'''
			<a>
				<b>
					<c>d</c>
					<d/>
				</b>
			</a>
		'''.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'b'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
					'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'c'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA 'd'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'c'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
					'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'd'
			RULE_TAG_EMPTY_CLOSE '/>'
			RULE_PCDATA '
				'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'b'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
			'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
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
		'''.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'b'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
					'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'c'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA 'd'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'c'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
					'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'd'
			RULE_WS ' '
			RULE_ID 'e'
			RULE_ATTR_EQ '='
			RULE_STRING ''f''
			RULE_TAG_EMPTY_CLOSE '/>'
			RULE_PCDATA '
					'
			RULE_TAG_START_OPEN '<'
			RULE_ID 'g'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA 'h'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'g'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
				'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'b'
			RULE_TAG_CLOSE '>'
			RULE_PCDATA '
			'
			RULE_TAG_END_OPEN '</'
			RULE_ID 'a'
			RULE_TAG_CLOSE '>'
		''')
	}

	@Test def test022() throws Exception {
		'''
			<a b="/>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_WS ' '
			RULE_ID 'b'
			RULE_ATTR_EQ '='
			0 '"'
			RULE_TAG_EMPTY_CLOSE '/>'
		''')
	}
}

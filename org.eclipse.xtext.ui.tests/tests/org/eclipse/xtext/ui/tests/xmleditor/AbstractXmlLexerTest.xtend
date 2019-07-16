package org.eclipse.xtext.ui.tests.xmleditor

import org.junit.Rule
import org.junit.Test
import org.junit.rules.Timeout

abstract class AbstractXmlLexerTest extends AbstractLexerTest {

	@Rule public val timeout = Timeout.seconds(2)

	@Test def test001() {
		''''''.assertLexing('''''')
	}

	@Test def test002() {
		'''
			<a/>
		'''
		.assertLexing('''
			RULE_TAG_START_OPEN '<'
			RULE_ID 'a'
			RULE_TAG_EMPTY_CLOSE '/>'
		''')
	}

	@Test def test003() {
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

	@Test def test004() {
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

	@Test def test005() {
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

	@Test def test006() {
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

	@Test def test007() {
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

	@Test def test008() {
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

	@Test def test009() {
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

	@Test def test010() {
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

	@Test def test011() {
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

	@Test def test012() {
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

	@Test def test013() {
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

	@Test def test014() {
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

	@Test def test015() {
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

	@Test def test016() {
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

	@Test def test017() {
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

	@Test def test018() {
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

	@Test def test019() {
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

	@Test def test020() {
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

	@Test def test021() {
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

	@Test def test022() {
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

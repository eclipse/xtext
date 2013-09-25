package org.xpect.tests

import java.io.FileReader

import java.util.Map
import org.antlr.runtime.ANTLRStringStream
import org.antlr.runtime.Token
import org.junit.Test
import org.xpect.lexer.XpectRT

import static extension com.google.common.io.CharStreams.*
import org.junit.Assert

class LexerTest {

	@Test def testSimple() {
		val actual = lex('''// XPECT_SETUP foo END_SETUP''')
		val expected = '''
			RULE_ANY_OTHER '/'
			RULE_ANY_OTHER '/'
			RULE_ANY_OTHER ' '
			KEYWORD 'XPECT_SETUP'
			RULE_WS ' '
			RULE_ID 'foo'
			RULE_WS ' '
			KEYWORD 'END_SETUP'
		'''
		assertEquals(expected, actual)
	}

	@Test def testX() {
		val actual = lex('''X''')
		val expected = '''
			RULE_ANY_OTHER 'X'
		'''
		assertEquals(expected, actual)
	}

	@Test def testXP() {
		val actual = lex('''XP''')
		val expected = '''
			RULE_ANY_OTHER 'X'
			RULE_ANY_OTHER 'P'
		'''
		assertEquals(expected, actual)
	}

	@Test def testXPE() {
		val actual = lex('''XPE''')
		val expected = '''
			RULE_ANY_OTHER 'X'
			RULE_ANY_OTHER 'P'
			RULE_ANY_OTHER 'E'
		'''
		assertEquals(expected, actual)
	}

	@Test def testXPEC() {
		val actual = lex('''XPEC''')
		val expected = '''
			RULE_ANY_OTHER 'X'
			RULE_ANY_OTHER 'P'
			RULE_ANY_OTHER 'E'
			RULE_ANY_OTHER 'C'
		'''
		assertEquals(expected, actual)
	}

	@Test def testXPECT() {
		val actual = lex('''XPECT''')
		val expected = '''
			KEYWORD 'XPECT'
		'''
		assertEquals(expected, actual)
	}

	def private String lex(CharSequence text) {
		val names = tokenNames()
		val lexer = new XpectRT(new ANTLRStringStream(text.toString))
		val result = newArrayList
		while (true) {
			val token = lexer.nextToken
			if (token == Token::EOF_TOKEN)
				return result.join("\n")
			result += (names.get(token.type) ?: token.type) + " '" + token.text + "'"
		}
	}

	def private Map<Integer, String> tokenNames() {
		val file = "../org.xpect/src-gen/org/xpect/lexer/XpectRT.tokens"
		val result = <Integer, String>newLinkedHashMap
		for (line : new FileReader(file).readLines) {
			val s = line.split("=")
			val name = s.get(0)
			result.put(Integer::parseInt(s.get(1)), if(name.startsWith("KEYWORD")) "KEYWORD" else name)
		}
		result
	}

	def private assertEquals(CharSequence expt, CharSequence act) {
		Assert::assertEquals(expt.toString.trim, act.toString.trim)
	}

}

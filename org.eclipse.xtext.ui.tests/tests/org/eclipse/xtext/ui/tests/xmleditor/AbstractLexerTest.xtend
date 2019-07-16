package org.eclipse.xtext.ui.tests.xmleditor

import com.google.inject.Inject
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.util.Map
import org.antlr.runtime.ANTLRStringStream
import org.antlr.runtime.Lexer
import org.antlr.runtime.Token
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider

import static extension com.google.common.io.CharStreams.readLines
import static extension org.junit.Assert.assertEquals

/** 
 * The implementation of the following helper methods is mainly taken from
 * the org.eclipse.xpect.tests.LexerTest class of the Eclipse Xpect project.
 */
abstract class AbstractLexerTest {

	@Inject extension IAntlrTokenFileProvider

	protected def assertLexing(CharSequence modelAsText, CharSequence expected) {
		val actual = lexer.lex(antlrTokenFile, modelAsText.toString.trim)
		expected.toString.trim.assertEquals(actual.toString.trim)
	}

	protected def abstract Lexer lexer()
	
	protected def lex(Lexer lexer, InputStream tokensStream, CharSequence text) {
		val tokenNames = tokenNames(new InputStreamReader(tokensStream))
		lexerResult(lexer, tokenNames, text)
	}

	private def lexerResult(Lexer lexer, Map<Integer, String> tokenNames, CharSequence text) {
		lexer.setCharStream(new ANTLRStringStream(text.toString))
		val result = newArrayList
		while (true) {
			val token = lexer.nextToken
			if (token === Token.EOF_TOKEN) {
				return result.join(System.lineSeparator)
			}
			result += (tokenNames.get(token.type) ?: token.type) + " '" + token.text + "'"
		}
	}

	private def tokenNames(Reader tokensReader) {
		val result = <Integer, String>newLinkedHashMap
		val	lines = tokensReader.readLines

		for (line : lines) {
			val s = line.split("=")
			val name = s.get(0)
			val index = Integer.parseInt(s.get(1))
			result.put(index, if(name.startsWith("KEYWORD")) "KEYWORD" else name)
		}

		result
	}
}

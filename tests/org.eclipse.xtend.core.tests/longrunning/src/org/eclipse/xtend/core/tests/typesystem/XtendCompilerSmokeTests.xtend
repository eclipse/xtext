/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.antlr.runtime.ANTLRStringStream
import org.antlr.runtime.CommonToken
import org.antlr.runtime.Token
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
import org.eclipse.xtend.core.tests.compiler.XtendCompilerTest
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.junit.typesystem.Oven

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractXtendCompilerSmokeTest extends XtendCompilerTest {
	
	@Inject extension Oven
	
	override assertCompilesTo(CharSequence input, CharSequence expected, GeneratorConfig config) {
		assertNonSmoking(input)
	}
	
	protected def void assertNonSmoking(CharSequence input) throws Exception

	protected def void processFile(String input) {
		input.fireproof
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipLastCharactersXtendCompilerSmokeTest extends AbstractXtendCompilerSmokeTest {
	
	override void assertNonSmoking(CharSequence input) throws Exception {
		val string = input.toString
		for(i: 0..input.length - 1) {
			processFile(string.substring(0, i))
		}
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipFirstCharactersXtendCompilerSmokeTest extends AbstractXtendCompilerSmokeTest {
	
	override void assertNonSmoking(CharSequence input) throws Exception {
		val string = input.toString
		for(i: 0..input.length - 1) {
			processFile(string.substring(i))
		}
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipCharacterInBetweenXtendCompilerSmokeTest extends AbstractXtendCompilerSmokeTest {
	
	override void assertNonSmoking(CharSequence input) throws Exception {
		val string = input.toString
		if (input.length > 1) {
			for(i: 0..input.length - 2) {
				processFile(string.substring(0, i) + string.substring(i+1))
			}
		}
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipThreeCharactersInBetweenXtendCompilerSmokeTest extends AbstractXtendCompilerSmokeTest {
	
	override void assertNonSmoking(CharSequence input) throws Exception {
		val string = input.toString
		if (input.length > 1) {
			for(i: 0..input.length - 4) {
				processFile(string.substring(0, i) + string.substring(i+3))
			}
		}
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipTokensInBetweenXtendCompilerSmokeTest extends AbstractXtendCompilerSmokeTest {
	
	Provider<? extends Lexer> lexerProvider = [| new InternalXtendLexer(null) ]
	
	override void assertNonSmoking(CharSequence input) throws Exception {
		val string = input.toString
		val List<CommonToken> tokenList = newArrayList();
		{
			val lexer = lexerProvider.get();
			lexer.setCharStream(new ANTLRStringStream(string));
			var token = lexer.nextToken();
			while (token != Token::EOF_TOKEN) {
				tokenList.add(token as CommonToken);
				token = lexer.nextToken();
			}
		}
		for (token : tokenList) {
			val int start = token.getStartIndex();
			val length = token.getText().length();
			processFile(string.substring(0, start) + string.substring(start + length));
		}		
	}
	
}


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipNodesInBetweenXtendCompilerSmokeTest extends AbstractXtendCompilerSmokeTest {
	
	override file(String string, boolean validate) throws Exception {
		val resource = resourceSet.createResource(URI::createURI("abcdefg.xtend"))
		resource.load(new StringInputStream(string), null)
		val file = resource.contents.head as XtendFile
		return file
	}
	
	override void assertNonSmoking(CharSequence input) throws Exception {
		val string = input.toString
		val file = string.file(false)
		if (file != null) {
			val resource = file.eResource as XtextResource
			val rootNode = resource.parseResult.rootNode
			var ReplaceRegion region;
			for(node: rootNode.asTreeIterable) {
				val offset = node.totalOffset
				val length = node.totalLength
				if (length != 0) {
					if (region == null || region.offset != offset || region.length != length) {
						region = new ReplaceRegion(offset, length, "")
						val builder = new StringBuilder(rootNode.text)
						region.applyTo(builder)
						processFile(builder.toString)
					}
				}
			}
		}
	}
	
}


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
import org.eclipse.xtend.core.tests.compiler.CompilerBug410767Test
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.junit.typesystem.Oven
import org.junit.Test
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractCompilerBug410767SmokeTest extends CompilerBug410767Test {
	
	@Inject extension Oven
	
	override assertCompilesTo(CharSequence input, CharSequence expected, GeneratorConfig config) {
		assertNonSmoking(input)
	}
	
	protected def void assertNonSmoking(CharSequence input) throws Exception

	protected def void processFile(String input) {
		input.fireproof
	}
	
	// the following cases are pretty much identical to the original 4 tests
	// but try to mimic a lot of duplicate names and identifier conflicts in the
	// oven
	
	@Test
	def test_05() {
		// see test_01
		assertCompilesTo('''
			class C1 {
				def m(C11<?> p) {
					p.toMap
				}
			}
			interface C11<C1> extends C111<C11<C11<C1>>> {}
			interface C111<C1> {
				def java.util.Map<C1, C1> toMap()
			}
		''', '''
			import java.util.Map;
			
			@SuppressWarnings("all")
			public class C1 {
			  public Map<C11<C11<? extends Object>>,C11<C11<? extends Object>>> m(final C11<? extends Object> p) {
			    Map<C11<C11<? extends Object>>,C11<C11<? extends Object>>> _map = p.toMap();
			    return _map;
			  }
			}
		''')
	}
	
	@Test
	def test_06() {
		assertCompilesTo('''
			abstract class C1<CC1> implements C11<CC1> {
				def m() {
					toMap
				}
			}
			interface C11<C1> extends C12<C1> {}
			interface C12<C2> extends C13<C2, C12<C2>> {}
			interface C13<C1, C2> extends C14<C1, C11<C1>> {}
			interface C14<C1,C2> {
				def C13<C1, C2> toMap()
			}
		''', '''
			@SuppressWarnings("all")
			public abstract class C1<CC1 extends Object> implements C11<CC1> {
			  public C13<CC1,C11<CC1>> m() {
			    C13<CC1,C11<CC1>> _map = this.toMap();
			    return _map;
			  }
			}
		''')
	}
	
	@Test
	def test_07() {
		assertCompilesTo('''
			abstract class C<CC> implements C1<CC> {
				def m(C<? extends String> p) {
					p.toMap
				}
			}
			interface C1<CC> extends C11<CC> {}
			interface C11<CC> extends C111<CC, C11<CC>> {}
			interface C111<CC, CC1> extends C1111<CC, C1<CC>> {}
			interface C1111<CC, CC1> {
				def C111<CC,CC1> toMap()
			}
		''', '''
			@SuppressWarnings("all")
			public abstract class C<CC extends Object> implements C1<CC> {
			  public C111<? extends String,? extends C1<? extends String>> m(final C<? extends String> p) {
			    C111<? extends String,? extends C1<? extends String>> _map = p.toMap();
			    return _map;
			  }
			}
		''')
	}
	
	@Test
	def test_08() {
		// see test_04
		assertCompilesTo('''
			class C {
				def m(C1<?> p) {
					p.toMap
				}
			}
			interface C1<C> extends C11<C> {}
			interface C11<C> extends C111<C, C11<C>> {}
			interface C111<C, C1> extends C1111<C, C1<C>> {}
			interface C1111<CC1, C11> {
				def C111<CC1, C11> toMap()
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public C111<? extends Object,C11<? extends Object>> m(final C1<? extends Object> p) {
			    C111<? extends Object,C11<? extends Object>> _map = p.toMap();
			    return _map;
			  }
			}
		''')
	}
	
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipLastCharactersCompilerBug410767SmokeTest extends AbstractCompilerBug410767SmokeTest {
	
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
class SkipFirstCharactersCompilerBug410767SmokeTest extends AbstractCompilerBug410767SmokeTest {
	
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
class SkipCharacterInBetweenCompilerBug410767SmokeTest extends AbstractCompilerBug410767SmokeTest {
	
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
class SkipThreeCharactersInBetweenCompilerBug410767SmokeTest extends AbstractCompilerBug410767SmokeTest {
	
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
class SkipTokensInBetweenCompilerBug410767SmokeTest extends AbstractCompilerBug410767SmokeTest {
	
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
class SkipNodesInBetweenCompilerBug410767SmokeTest extends AbstractCompilerBug410767SmokeTest {
	
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



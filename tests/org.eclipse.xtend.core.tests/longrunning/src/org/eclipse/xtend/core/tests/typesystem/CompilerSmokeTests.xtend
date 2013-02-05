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
import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider
import org.eclipse.xtend.core.tests.compiler.AbstractCompilerTest
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.xbase.XClosure
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.CompoundReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.TypeData
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
abstract class AbstractXtendCompilerSmokeTest extends AbstractXtendCompilerTest {
	
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
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
abstract class AbstractCompilerSmokeTest extends AbstractCompilerTest {
	
	@Inject extension Oven
	
	override testBug_350932_13() throws Exception {
		val code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    val x = if (true) return Boolean::FALSE x\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n"
		assertNonSmoking(code)
	}
	
	override testBug_350932_14() throws Exception {
		val code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    val x = if (true) return Boolean::FALSE else null x\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n"
		assertNonSmoking(code)
	}
	
	override testBug_352849_02() throws Exception {
		val code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val result1 = seq.addAll2(strings)\n" +
				"		val Collection<String> test1 = result1\n" + 
				"		val result2 = strings.addAll3(seq)\n" +
				"		val Collection<String> test2 = result2\n" + 
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <T> Collection<T> addAll3(Iterable<? extends T> elements, Collection<? super T> collection){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}"
		assertNonSmoking(code)
	}
	
	override testBug343096_01() throws Exception {
		compileJavaCode("x.Y",
				"package x class Y {" +
				"def <T> bug343096() {\n" + 
				"  [T t|switch t {\n" + 
				"    case t : bug343096\n" + 
				"  }]" + 
				"}}")
	}
	
	@Ignore
	@Test
	override testData_03() throws Exception {
		assertNonSmoking("package foo @Data class Bar { val myFlag = true }")
	}
	
	override protected compileToJavaCode(String xtendCode) {
		assertNonSmoking(xtendCode)
		return super.compileToJavaCode(xtendCode)
	}
	
	protected def void assertNonSmoking(CharSequence input) throws Exception
	
	protected def void processFile(String input) {
		input.fireproof
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Oven extends Assert {
	
	@Inject
	IBatchTypeResolver typeResolver
	
	@Inject extension ReflectExtensions
	
	@Inject extension ParseHelper<XtendFile>
	
	
	def void fireproof(String input) throws Exception {
		try {
			val file = input.parse
			val resolvedTypes = typeResolver.resolveTypes(file)
			assertNotNull(resolvedTypes)
			if (file != null) {
				for(content: file.eAllContents.toIterable) {
					switch(content) {
						XSwitchExpression: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
							if (content.localVarName != null) {
								assertIdentifiableTypeIsResolved(content, resolvedTypes)
							}
						}
						XAbstractFeatureCall: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
							if (content.implicitReceiver != null) {
								assertExpressionTypeIsResolved(content.implicitReceiver, resolvedTypes)
							}
							if (content.implicitFirstArgument != null) {
								assertExpressionTypeIsResolved(content.implicitFirstArgument, resolvedTypes)
							}
						}
						XClosure: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
							if (content.implicitParameter != null) {
								assertIdentifiableTypeIsResolved(content.implicitParameter, resolvedTypes)
							}
						}
						XExpression: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
						}
						XCasePart : { /* skip */}
						JvmIdentifiableElement: {
							assertIdentifiableTypeIsResolved(content, resolvedTypes)
						}
					}
				}
			}
		} catch(Throwable t) {
			t.printStackTrace
			println(input)
			throw new RuntimeException("Expression was: '" + input + '"', t)
		}
	}
	
	def void assertExpressionTypeIsResolved(XExpression expression, IResolvedTypes types) {
		val internalTypes = types.invoke('delegate')
		val type = switch(internalTypes) {
			CompoundReentrantTypeResolver: {
				val delegate = internalTypes.invoke("getDelegate", expression)
				if (delegate instanceof RootResolvedTypes)
					delegate.invoke("getTypeData", expression, Boolean::FALSE) as TypeData
			} 
			default: internalTypes.invoke("getTypeData", expression, Boolean::FALSE) as TypeData
		}
		assertNotNull("Type is not resolved. Expression: " + expression.toString, type)
	}
	
	def void assertIdentifiableTypeIsResolved(JvmIdentifiableElement identifiable, IResolvedTypes types) {
		if (identifiable.simpleName == null)
			return;
		val type = types.getActualType(identifiable)
		assertNotNull(identifiable.toString, type)
		assertNotNull(identifiable.toString + " / " + type, type.identifier)	
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipLastCharacters extends AbstractXtendCompilerSmokeTest {
	
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
class SkipFirstCharacters extends AbstractXtendCompilerSmokeTest {
	
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
class SkipCharacterInBetween extends AbstractXtendCompilerSmokeTest {
	
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
class SkipTokensInBetween extends AbstractXtendCompilerSmokeTest {
	
	@Inject
	Provider<Lexer> lexerProvider
	
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
class SkipNodesInBetween extends AbstractXtendCompilerSmokeTest {
	
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
						val builder = new StringBuilder(input)
						region.applyTo(builder)
						processFile(builder.toString)
					}
				}
			}
		}
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SkipLastCharacters2 extends AbstractCompilerSmokeTest {
	
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
class SkipFirstCharacters2 extends AbstractCompilerSmokeTest {
	
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
class SkipCharacterInBetween2 extends AbstractCompilerSmokeTest {
	
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
class SkipTokensInBetween2 extends AbstractCompilerSmokeTest {
	
	@Inject
	Provider<Lexer> lexerProvider
	
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
class SkipNodesInBetween2 extends AbstractCompilerSmokeTest {
	
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
						val builder = new StringBuilder(input)
						region.applyTo(builder)
						processFile(builder.toString)
					}
				}
			}
		}
	}
	
}
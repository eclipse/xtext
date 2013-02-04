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
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.parser.antlr.Lexer
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.typesystem.internal.CompoundReentrantTypeResolver
import org.eclipse.xtext.xbase.typesystem.internal.TypeData
import org.junit.runner.RunWith
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes
import org.eclipse.xtext.xbase.XClosure

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
abstract class AbstractXtendCompilerSmokeTest extends AbstractXtendCompilerTest {
	
	@Inject
	IBatchTypeResolver typeResolver
	
	override assertCompilesTo(CharSequence input, CharSequence expected, GeneratorConfig config) {
		assertNonSmoking(input)
	}
	
	override file(String string, boolean validate) throws Exception {
		val resource = resourceSet.createResource(URI::createURI("abcdefg.xtend"))
		resource.load(new StringInputStream(string), null)
		val file = resource.contents.head as XtendFile
		return file
	}
	
	def void assertNonSmoking(CharSequence input) throws Exception

	def void processFile(String input) throws Exception {
		try {
			val file = file(input, false);
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
						}
						XClosure: {
							assertExpressionTypeIsResolved(content, resolvedTypes)
							if (content.implicitParameter != null)
								assertIdentifiableTypeIsResolved(content.implicitParameter, resolvedTypes)
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
	
	@Inject extension ReflectExtensions
	
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
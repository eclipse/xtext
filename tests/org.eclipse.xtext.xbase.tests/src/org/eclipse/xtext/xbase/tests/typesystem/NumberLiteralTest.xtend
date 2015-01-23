/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.junit.Test

/**
 * Negative literals are not considered since they are parsed as unary expressions, so we
 * don't use as test inputs Short.MIN_VALUE, nor Byte.MIN_VALUE, which are negative values.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
class NumberLiteralTest extends AbstractXbaseTestCase {
	
	@Inject
	IBatchTypeResolver typeResolver
	
	def void resolvesNumberLiteralsWithExpectationsTo(String literal, String expectedType, String expectedResult) {
		val block = expression('''{ val «expectedType» i = «literal» }''') as XBlockExpression
		val varDecl = block.expressions.last as XVariableDeclaration
		val resolvedTypes = typeResolver.resolveTypes(varDecl)
		val rightExpressionType = resolvedTypes.getActualType(varDecl.right as XNumberLiteral)
		assertEquals(expectedResult, rightExpressionType.type.simpleName)
	}
	
	@Test def void testWithNoExpectationResolveAsInt() {
		resolvesNumberLiteralsWithExpectationsTo("10", "", "int")
	}

	@Test def void testWithIntExpectationResolveAsInt() {
		resolvesNumberLiteralsWithExpectationsTo("10", "int", "int")
	}

	@Test def void testWithByteExpectationResolveAsByte() {
		resolvesNumberLiteralsWithExpectationsTo("10", "byte", "byte")
	}

	@Test def void testWithByteExpectationResolveAsByteWithMaxByte() {
		resolvesNumberLiteralsWithExpectationsTo((Byte.MAX_VALUE as int)+"", "byte", "byte")
	}

	@Test def void testWithByteExpectationResolveAsIntWithMaxBytePlusOne() {
		resolvesNumberLiteralsWithExpectationsTo((Byte.MAX_VALUE as int)+1+"", "byte", "int")
	}

	@Test def void testWithShortExpectationResolveAsShort() {
		resolvesNumberLiteralsWithExpectationsTo("10", "short", "short")
	}

	@Test def void testWithShortExpectationResolveAsShortWithMaxShort() {
		resolvesNumberLiteralsWithExpectationsTo((Short.MAX_VALUE as int)+"", "short", "short")
	}

	@Test def void testWithShortExpectationResolveAsIntWithMaxShortPlusOne() {
		resolvesNumberLiteralsWithExpectationsTo((Short.MAX_VALUE as int)+1+"", "short", "int")
	}

	@Test def void testWithCharExpectationResolveAsChar() {
		resolvesNumberLiteralsWithExpectationsTo("10", "char", "char")
	}
	
	@Test def void testWithCharExpectationResolveAsCharWithCharacterMaxValue() {
		resolvesNumberLiteralsWithExpectationsTo((Character.MAX_VALUE as int)+"", "char", "char")
	}

	@Test def void testWithCharExpectationResolveAsCharWithCharacterMinValue() {
		resolvesNumberLiteralsWithExpectationsTo((Character.MIN_VALUE as int)+"", "char", "char")
	}

	@Test def void testWithCharExpectationResolveAsIntWithCharacterMaxValuePlusOne() {
		resolvesNumberLiteralsWithExpectationsTo(((Character.MAX_VALUE as int)+1)+"", "char", "int")
	}

}
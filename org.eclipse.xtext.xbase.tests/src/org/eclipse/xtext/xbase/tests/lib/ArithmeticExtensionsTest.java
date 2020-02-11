/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.LongExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class ArithmeticExtensionsTest extends AbstractXbaseTestCase {

	@Inject
	private Primitives primitives;

	@Inject
	private IBatchTypeResolver typeResolver;
	
	protected Primitives getPrimitives() {
		return primitives;
	}
	
	@Test public void testPrimitiveBooleanBindings() throws Exception {
		XExpression expression = expression("{!true||false&&true==false!=true}", true);
		assertOnlyPrimitiveOperationsBound(expression);
	}

	@Test public void testPrimitiveIntBindings() throws Exception {
		XExpression expression = expression("{-1+2**3*4/5%6<9}", true);
		assertOnlyPrimitiveOperationsBound(expression);
	}
	@Test public void testPrimitiveIntBindings_01() throws Exception {
		XExpression expression = expression("{10<=11}", true);
		assertOnlyPrimitiveOperationsBound(expression);
	}
	@Test public void testPrimitiveIntBindings_02() throws Exception {
		XExpression expression = expression("{12>13}", true);
		assertOnlyPrimitiveOperationsBound(expression);
	}
	@Test public void testPrimitiveIntBindings_03() throws Exception {
		XExpression expression = expression("{13>=14}", true);
		assertOnlyPrimitiveOperationsBound(expression);
	}
	@Test public void testPrimitiveIntBindings_04() throws Exception {
		XExpression expression = expression("{15!=16}", true);
		assertOnlyPrimitiveOperationsBound(expression);
	}
	@Test public void testPrimitiveIntBindings_05() throws Exception {
		XExpression expression = expression("{17==18}", true);
		assertOnlyPrimitiveOperationsBound(expression);
	}

	@Test public void testPrimitiveDoubleBindings() throws Exception {
		XExpression expression = expression("{val double x=1; -x+x**x*x/x%x<x}", true); 
		assertOnlyPrimitiveOperationsBound(expression);
	}
	@Test public void testPrimitiveDoubleBindings_01() throws Exception {
		XExpression expression = expression("{val double x=1; x<=x }", true); 
		assertOnlyPrimitiveOperationsBound(expression);
	}
	@Test public void testPrimitiveDoubleBindings_02() throws Exception {
		XExpression expression = expression("{val double x=1; x>x}", true); 
		assertOnlyPrimitiveOperationsBound(expression);
	}
	@Test public void testPrimitiveDoubleBindings_03() throws Exception {
		XExpression expression = expression("{val double x=1; x>=x}", true); 
		assertOnlyPrimitiveOperationsBound(expression);
	}
	@Test public void testPrimitiveDoubleBindings_04() throws Exception {
		XExpression expression = expression("{val double x=1; x!=x}", true); 
		assertOnlyPrimitiveOperationsBound(expression);
	}
	@Test public void testPrimitiveDoubleBindings_05() throws Exception {
		XExpression expression = expression("{val double x=1; x==x}", true); 
		assertOnlyPrimitiveOperationsBound(expression);
	}
	
	protected void assertOnlyPrimitiveOperationsBound(XExpression expression) {
		boolean operationsFound = false;
		for (XAbstractFeatureCall featureCall : EcoreUtil2.eAllOfType(expression, XAbstractFeatureCall.class)) {
			JvmIdentifiableElement feature = featureCall.getFeature();
			if (feature instanceof JvmOperation) {
				for (JvmFormalParameter parameter : ((JvmOperation) feature).getParameters()) {
					operationsFound = true;
					assertTrue(parameter.getParameterType().getIdentifier(),
							primitives.isPrimitive(parameter.getParameterType()));
				}
			}
		}
		assertTrue("No operations found", operationsFound);
	}
	
	@Test public void testBinaryPromotion_0() throws Exception {
		XExpression expression = expression("{" +
				"  val float x = Float::parseFloat('1')" +
				"  val double y = 1" +
				"  x + y" +
				"}", true);
		assertEquals("double", getType(expression).getIdentifier());
	}
	
	protected LightweightTypeReference getType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getActualType(expression);
	}

	@Test public void testBinaryPromotion_1() throws Exception {
		XExpression expression = expression("{" +
				"  val long x = Long::parseLong('1')" +
				"  val float y = 1" +
				"  x - y" +
				"}", true);
		assertEquals("float", getType(expression).getIdentifier());
	}

	@Test public void testBinaryPromotion_2() throws Exception {
		XExpression expression = expression("{" +
				"  val int x = Integer::parseInt('1')" +
				"  val long y = 1" +
				"  x * y" +
				"}", true);
		assertEquals("long", getType(expression).getIdentifier());
	}

	@Test public void testBinaryPromotion_3() throws Exception {
		XExpression expression = expression("{" +
				"  val short x = Short::parseShort('1')" +
				"  val int y = 1" +
				"  x / y" +
				"}", true);
		assertEquals("int", getType(expression).getIdentifier());
	}

	@Test public void testBinaryPromotion_4() throws Exception {
		XExpression expression = expression("{" +
				"  val char x = '1'.charAt(0)" +
				"  val short y = Short::parseShort('1')" +
				"  x % y" +
				"}", true);
		assertEquals("int", getType(expression).getIdentifier());
	}

	@Test public void testBinaryPromotion_5() throws Exception {
		XExpression expression = expression("{" +
				"  val char x = '1'.charAt(0)" +
				"  val byte y = Byte::parseByte('1')" +
				"  x % y" +
				"}", true);
		assertEquals("int", getType(expression).getIdentifier());
	}

	@Test public void testBinaryPromotion_6() throws Exception {
		XExpression expression = expression("{" +
				"  val x = new Byte('1')" +
				"  val y = new Double('1')" +
				"  x + y" +
				"}", true);
		assertEquals("double", getType(expression).getIdentifier());
	}

	@Test public void testBinaryPromotion_7() throws Exception {
		XExpression expression = expression("{" +
				"  val x = new Byte('1')" +
				"  val float y = 1" +
				"  x - y" +
				"}", true);
		assertEquals("float", getType(expression).getIdentifier());
	}

	@Test public void testBinaryPromotion_8() throws Exception {
		XExpression expression = expression("{" +
				"  val x = Byte::parseByte('1')" +
				"  val y = new Long('1')" +
				"  x * y" +
				"}", true);
		assertEquals("long", getType(expression).getIdentifier());
	}

	@Test public void testShiftOperators_0() {
		assertEquals(0x80000000, IntegerExtensions.shiftLeft(0x1, 31));
		assertEquals(0xffffffff, IntegerExtensions.shiftRight(0x80000000, 31));
		assertEquals(0x1, IntegerExtensions.shiftRightUnsigned(0x80000000, 31));
	}

	@Test public void testShiftOperators_1() {
		assertEquals(0x8000000000000000L, LongExtensions.shiftLeft(0x1L, 63));
		assertEquals(0xffffffffffffffffL, LongExtensions.shiftRight(0x8000000000000000L, 63));
		assertEquals(0x1L, LongExtensions.shiftRightUnsigned(0x8000000000000000L, 63));
	}

	@Test public void testBigIntegerAllOperationsBound() throws Exception {
		XExpression expression = expression("{val a=1bi; -a+a-a*a/a%a}", true);
		assertEquals("java.math.BigInteger", getType(expression).getIdentifier());
	}

	@Test public void testBigDecimalAllOperationsBound() throws Exception {
		XExpression expression = expression("{val a=1bd; -a+a-a*a/a}", true);
		assertEquals("java.math.BigDecimal", getType(expression).getIdentifier());
	}
	
	@Ignore
	@Test(timeout=400) public void testManyOperations_01() throws Exception {
		XExpression expression = expression("{-1+2**3*4/5%6<9+-1+2**3*4/5%6<9+-1+2**3*4/5%6<9-1+2**3*4/5%6<9-1+2**3*4/5%6<9-1+2**3*4/5%6<9}", true);
		assertOnlyPrimitiveOperationsBound(expression);
	}
}

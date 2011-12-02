/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NumberExtensionsTest extends AbstractXbaseTestCase {

	@Inject
	private Primitives primitives;

	@Inject
	private ITypeProvider typeProvider;
	
	public void testPrimitiveBooleanBindings() throws Exception {
		XExpression expression = expression("{!true||false&&true==false!=true}", true);
		assertOnlyPrimitveOperationsBound(expression);
	}

	public void testPrimitiveIntBindings() throws Exception {
		XExpression expression = expression("{-1+2**3*4/5%6<9 10<=11 12>13 13>=14 15!=16 17==18}", true);
		assertOnlyPrimitveOperationsBound(expression);
	}

	public void testPrimitiveDoubleBindings() throws Exception {
		XExpression expression = expression("{val double x=1; -x+x**x*x/x<x  x<=x x>x x>=x x!=x x==x}", true); 
		assertOnlyPrimitveOperationsBound(expression);
	}
	
	protected void assertOnlyPrimitveOperationsBound(XExpression expression) {
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

	public void testShiftOperators() {
		assertEquals(0x80000000, IntegerExtensions.shiftLeft(0x1, 31));
		assertEquals(0xffffffff, IntegerExtensions.shiftRight(0x80000000, 31));
		assertEquals(0x1, IntegerExtensions.shiftRightUnsigned(0x80000000, 31));
	}

	public void testBigIntegerAllOperationsBound() throws Exception {
		XExpression expression = expression("{val a=new java.math.BigInteger(1); -a+a-a*a/a%a}", true);
		assertEquals("java.math.BigInteger", typeProvider.getType(expression).getIdentifier());
	}

	public void testBigDecimalAllOperationsBound() throws Exception {
		XExpression expression = expression("{val a=new java.math.BigDecimal(1); -a+a-a*a/a}", true);
		assertEquals("java.math.BigDecimal", typeProvider.getType(expression).getIdentifier());
	}
}

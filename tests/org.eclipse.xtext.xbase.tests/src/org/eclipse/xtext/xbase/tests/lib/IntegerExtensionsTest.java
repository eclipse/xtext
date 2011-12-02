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

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class IntegerExtensionsTest extends AbstractXbaseTestCase {

	@Inject
	private Primitives primitives;
	
	public void testPrimitiveBindings_0() throws Exception {
		XExpression expression = expression("!(-1+2**3*4/5%6||7&&8)", true);
		assertOnlyPrimitveOperationsBound(expression);
	}

	public void testPrimitiveBindings_1() throws Exception {
		XExpression expression = expression("1<2", true);
		assertOnlyPrimitveOperationsBound(expression);
	}

	public void testPrimitiveBindings_2() throws Exception {
		XExpression expression = expression("1<=2", true);
		assertOnlyPrimitveOperationsBound(expression);
	}

	public void testPrimitiveBindings_3() throws Exception {
		XExpression expression = expression("1>2", true);
		assertOnlyPrimitveOperationsBound(expression);
	}

	public void testPrimitiveBindings_4() throws Exception {
		XExpression expression = expression("1>=2", true);
		assertOnlyPrimitveOperationsBound(expression);
	}

	public void testPrimitiveBindings_5() throws Exception {
		XExpression expression = expression("1==2", true);
		assertOnlyPrimitveOperationsBound(expression);
	}

	protected void assertOnlyPrimitveOperationsBound(XExpression expression) {
		for(XAbstractFeatureCall featureCall: EcoreUtil2.eAllOfType(expression, XAbstractFeatureCall.class)) {
			JvmIdentifiableElement feature = featureCall.getFeature();
			assertTrue(feature instanceof JvmOperation);
			for(JvmFormalParameter parameter: ((JvmOperation)feature).getParameters()) {
				assertTrue(parameter.getParameterType().getIdentifier(), primitives.isPrimitive(parameter.getParameterType()));
			}
		}
	}
	
	public void testNot() {
		assertEquals(0x55555555, IntegerExtensions.operator_not(0xaaaaaaaa));
		assertEquals(0xaaaaaaaa, IntegerExtensions.operator_not(0x55555555));
		assertEquals(-1, IntegerExtensions.operator_not(0));
		assertEquals(0, IntegerExtensions.operator_not(-1));
	}
	
}

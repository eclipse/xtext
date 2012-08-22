/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib

import com.google.inject.Inject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XbasePackage$Literals
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver

import static org.junit.Assert.*
import org.junit.Test
import org.junit.Ignore

class BatchArithmeticExtensionTest extends ArithmeticExtensionsTest {
	
	@Inject extension IBatchTypeResolver 
	
	override protected expression(CharSequence string, boolean resolve) throws Exception {
		if (resolve) {
			val result = super.expression(string, false)
			result.resolveTypes
			return result
		} else {
			super.expression(string, resolve)
		}
	}
	
	override protected assertOnlyPrimitveOperationsBound(XExpression expression) {
		EcoreUtil2::eAllOfType(expression, typeof(XAbstractFeatureCall)).forEach [
			val feature = eGet(XbasePackage$Literals::XABSTRACT_FEATURE_CALL__FEATURE, false) as JvmIdentifiableElement
			assertFalse(feature.eIsProxy)
		]
		super.assertOnlyPrimitveOperationsBound(expression)
	}
	
	@Ignore
	@Test(timeout=400) def void testManyOperations_01() throws Exception {
		val expression = expression("{-1+2**3*4/5%6<9+-1+2**3*4/5%6<9+-1+2**3*4/5%6<9-1+2**3*4/5%6<9-1+2**3*4/5%6<9-1+2**3*4/5%6<9}", true);
		assertOnlyPrimitveOperationsBound(expression);
	}
	
}
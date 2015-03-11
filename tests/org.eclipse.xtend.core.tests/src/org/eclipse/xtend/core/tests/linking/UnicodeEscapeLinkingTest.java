/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking;

import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnicodeEscapeLinkingTest extends AbstractXtendTestCase {

	@Inject
	private IXtendJvmAssociations associator;
	
	@Test public void testIdentifiersWithUnicode_01() throws Exception {
		XtendClass clazz = clazz(
				  "class A {\n"
				+ " String a\n"
				+ " def m() {\n" 
				+ "	    \\u0061\n" 
				+ "	}\n"
				+ "}");
		XFeatureCall call = (XFeatureCall) ((XBlockExpression)((XtendFunction)clazz.getMembers().get(1)).getExpression()).getExpressions().get(0);
		JvmIdentifiableElement feature = call.getFeature();
		assertFalse(feature.eIsProxy());
		assertSame(feature, associator.getJvmField((XtendField) clazz.getMembers().get(0)));
	}
	
	@Test public void testIdentifiersWithUnicode_02() throws Exception {
		XtendClass clazz = clazz(
				  "class A {\n"
				+ " String \\u0061\n"
				+ " def m() {\n" 
				+ "	    a\n" 
				+ "	}\n"
				+ "}");
		XFeatureCall call = (XFeatureCall) ((XBlockExpression)((XtendFunction)clazz.getMembers().get(1)).getExpression()).getExpressions().get(0);
		JvmIdentifiableElement feature = call.getFeature();
		assertFalse(feature.eIsProxy());
		assertSame(feature, associator.getJvmField((XtendField) clazz.getMembers().get(0)));
	}

}

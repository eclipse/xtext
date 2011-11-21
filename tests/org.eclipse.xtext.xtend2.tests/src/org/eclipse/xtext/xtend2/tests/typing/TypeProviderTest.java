/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.typing;

import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendConstructor;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeProviderTest extends AbstractXtend2TestCase {

	@Inject
	private ITypeProvider typeProvider;
	
	@Override
	protected XtendFile file(String string) throws Exception {
		return file(string, true);
	}
	
	public void testReturnTypeInConstructor() throws Exception {
		XtendConstructor constructor = constructor(
				"new() {\n" + 
				"	''.toString\n" + 
				"}\n");
		XBlockExpression body = (XBlockExpression) constructor.getExpression();
		assertEquals("void", typeProvider.getExpectedType(body).getIdentifier());
		assertEquals("void", typeProvider.getExpectedReturnType(body, true).getIdentifier());
		XMemberFeatureCall toString = (XMemberFeatureCall) body.getExpressions().get(0);
		assertEquals("void", typeProvider.getExpectedType(toString).getIdentifier());
		assertEquals("void", typeProvider.getExpectedReturnType(toString, true).getIdentifier());
	}
	
	public void testTypeOfSuperInConstructor() throws Exception {
		XtendConstructor constructor = constructor(
				"new() {\n" + 
				"	super()\n" + 
				"}\n");
		XBlockExpression body = (XBlockExpression) constructor.getExpression();
		XFeatureCall superCall = (XFeatureCall) body.getExpressions().get(0);
		assertEquals("void", typeProvider.getExpectedType(superCall).getIdentifier());
		assertEquals("void", typeProvider.getExpectedReturnType(superCall, true).getIdentifier());
		assertEquals("void", typeProvider.getType(superCall).getIdentifier());
	}
	
	public void testTypeOfThisInConstructor() throws Exception {
		XtendConstructor constructor = constructor(
				"new(int a) {\n" + 
				"	this()\n" + 
				"}\n" +
				"new() {}");
		XBlockExpression body = (XBlockExpression) constructor.getExpression();
		XFeatureCall thisCall = (XFeatureCall) body.getExpressions().get(0);
		assertEquals("void", typeProvider.getExpectedType(thisCall).getIdentifier());
		assertEquals("void", typeProvider.getExpectedReturnType(thisCall, true).getIdentifier());
		assertEquals("void", typeProvider.getType(thisCall).getIdentifier());
	}

}

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.serializer;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SerializerTest extends AbstractXbaseTestCase {
	
	public void testSerialize() throws IOException {
		Resource resource = newResource("(java.lang.String)'foo'");
		XCastedExpression casted = (XCastedExpression) resource.getContents().get(0);
		
		XbaseFactory factory = XbaseFactory.eINSTANCE;
		XClosure closure = factory.createXClosure();
		XStringLiteral stringLiteral = factory.createXStringLiteral();
		stringLiteral.setValue("value");
		closure.setExpression(stringLiteral);
		XInstanceOfExpression instanceOfExpression = factory.createXInstanceOfExpression();
		instanceOfExpression.setExpression(closure);
		instanceOfExpression.setType(casted.getType().getType());
		resource.getContents().clear();
		resource.getContents().add(instanceOfExpression);
		Serializer serializer = get(Serializer.class);
		String string = serializer.serialize(instanceOfExpression);
		// TODO: The expection is wrong
		assertEquals("| \"value\" instanceof String", string);
//		assertEquals("|'value'; instanceof java.lang.String", string);
	}

}

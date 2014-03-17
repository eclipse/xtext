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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SerializerTest extends AbstractXbaseTestCase {
	
	@Inject
	private IIndentationInformation indent;
	
	@Test public void testSerialize_01() throws IOException {
		Resource resource = newResource("'foo' as String");
		XCastedExpression casted = (XCastedExpression) resource.getContents().get(0);
		
		XbaseFactory factory = XbaseFactory.eINSTANCE;
		XClosure closure = factory.createXClosure();
		XStringLiteral stringLiteral = factory.createXStringLiteral();
		stringLiteral.setValue("value");
		XBlockExpression blockExpression = factory.createXBlockExpression();
		blockExpression.getExpressions().add(stringLiteral);
		closure.setExpression(blockExpression);
		closure.setExplicitSyntax(true);
		XInstanceOfExpression instanceOfExpression = factory.createXInstanceOfExpression();
		instanceOfExpression.setExpression(closure);
		instanceOfExpression.setType(EcoreUtil.copy(casted.getType()));
		resource.getContents().clear();
		resource.getContents().add(instanceOfExpression);
		ISerializer serializer = get(ISerializer.class);
		String string = serializer.serialize(instanceOfExpression);
		assertEquals("[| \"value\"] instanceof String", string);
	}
	
	@Test public void testSerialize_02() throws IOException {
		Resource resource = newResource("'foo' as String");
		XCastedExpression casted = (XCastedExpression) resource.getContents().get(0);
		
		XbaseFactory factory = XbaseFactory.eINSTANCE;
		XIfExpression ifExpression = factory.createXIfExpression();
		ifExpression.setIf(factory.createXBooleanLiteral());
		XStringLiteral stringLiteral = factory.createXStringLiteral();
		stringLiteral.setValue("value");
		ifExpression.setThen(stringLiteral);
		XInstanceOfExpression instanceOfExpression = factory.createXInstanceOfExpression();
		instanceOfExpression.setExpression(ifExpression);
		instanceOfExpression.setType(EcoreUtil.copy(casted.getType()));
		resource.getContents().clear();
		resource.getContents().add(instanceOfExpression);
		ISerializer serializer = get(ISerializer.class);
		String string = serializer.serialize(instanceOfExpression);
		// TODO expectation is wrong --> I've (MEY) fixed the expectation, please verify 
//		assertEquals("if ( false ) \"value\" instanceof String", string);
		assertEquals("(if(false)" + Strings.newLine() + indent.getIndentString() + "\"value\") instanceof String", string);
	}

}

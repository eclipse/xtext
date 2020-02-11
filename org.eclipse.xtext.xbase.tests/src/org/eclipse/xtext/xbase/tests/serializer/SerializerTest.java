/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.serializer;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SerializerTest extends AbstractXbaseTestCase {
	@Inject private ParseHelper<XInstanceOfExpression> parseHelper;
	
	@Test public void testSerialize_01() throws Exception {
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
		assertEquals("[|\"value\"] instanceof String", string);
		
		XInstanceOfExpression parsedExpression = parseHelper.parse(string);
		assertTrue(EcoreUtil.equals(instanceOfExpression, parsedExpression));
	}
	
	@Test public void testSerialize_02() throws Exception {
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
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=464846
		assertEquals("( if(false) \"value\" ) instanceof String", string);
		
		XInstanceOfExpression parsedExpression = parseHelper.parse(string);
		assertTrue(EcoreUtil.equals(instanceOfExpression, parsedExpression));
	}
	
	@Test public void testSerialize_ExtrasIssue164() throws Exception {
		DerivedStateAwareResource resource = (DerivedStateAwareResource) newResource("org.eclipse.xtext.xbase.tests.serializer.SerializerTest.Demo.demo");
		XMemberFeatureCall call = (XMemberFeatureCall) resource.getContents().get(0);
		ISerializer serializer = get(ISerializer.class);
		call.eAdapters().clear();
		String string = serializer.serialize(call);
		assertEquals("org.eclipse.xtext.xbase.tests.serializer.SerializerTest.Demo.demo", string);
	}
	
	@Test public void testSerialize_ExtrasIssue164_02() throws Exception {
		DerivedStateAwareResource resource = (DerivedStateAwareResource) newResource("org.eclipse.xtext.xbase.tests.serializer.SerializerTest.Demo.getDemo2(1)");
		XMemberFeatureCall call = (XMemberFeatureCall) resource.getContents().get(0);
		ISerializer serializer = get(ISerializer.class);
		call.eAdapters().clear();
		String string = serializer.serialize(call);
		assertEquals("org.eclipse.xtext.xbase.tests.serializer.SerializerTest.Demo.getDemo2(1)", string);
	}
	
	public static class Demo {
		public static String getDemo() {
			return "Demo";
		}
		public static String getDemo2(int value) {
			return "Demo";
		}
	}

}

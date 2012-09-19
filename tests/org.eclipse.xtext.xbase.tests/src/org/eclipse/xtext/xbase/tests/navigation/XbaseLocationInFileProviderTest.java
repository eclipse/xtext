/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.navigation;

import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.After;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseLocationInFileProviderTest extends AbstractXbaseTestCase {

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@After
	public void tearDown() throws Exception {
		locationInFileProvider = null;
	}
	
	@Override
	protected XExpression expression(CharSequence string) throws Exception {
		return super.expression(string, false);
	}
	
	@SuppressWarnings("unchecked")
	protected <Result extends XExpression> Result castedExpression(String string) throws Exception {
		return (Result) expression(string);
	}
	
	@Test public void testFeatureCall_01() throws Exception {
		String text = "newArrayList('a')";
		XFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(featureCall);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals(text, significant);
	}
	
	@Test public void testFeatureCall_02() throws Exception {
		String text = "<String>newArrayList('a')";
		XFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(featureCall);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals(text.substring(text.indexOf('>') + 1), significant);
	}
	
	@Test public void testFeatureCall_03() throws Exception {
		String text = "String::valueOf('a')";
		XFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(featureCall);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals(text.substring(text.indexOf('v')), significant);
	}
	
	@Test public void testFeatureCall_04() throws Exception {
		String text = "String::<Invalid>valueOf('a')";
		XFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(featureCall);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals(text.substring(text.indexOf('>') + 1), significant);
	}
	
	@Test public void testFeatureCall_05() throws Exception {
		String text = "((newArrayList('a')))";
		XFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getFullTextRegion(featureCall);
		String textRegion = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("newArrayList('a')", textRegion);
	}
	
	@Test public void testStaticFeatureCall_01() throws Exception {
		String text = "String::<Invalid>valueOf('a')";
		XFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(featureCall, XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("String", significant);
	}
	
	@Test public void testStaticFeatureCall_02() throws Exception {
		String text = "java::util::Collection::emptyList";
		XFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(featureCall, XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("java::util::Collection", significant);
	}
	
	@Test public void testStaticFeatureCall_03() throws Exception {
		String text = "String::<Invalid>valueOf('a')";
		XFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getFullTextRegion(featureCall, XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("String::", significant);
	}
	
	@Test public void testStaticFeatureCall_04() throws Exception {
		String text = "java::util::Collection::emptyList";
		XFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getFullTextRegion(featureCall, XbasePackage.Literals.XFEATURE_CALL__DECLARING_TYPE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("java::util::Collection::", significant);
	}
	
	@Test public void testMemberFeatureCall_01() throws Exception {
		String text = "'a'.toString";
		XMemberFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(featureCall);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals(text.substring(text.indexOf('.') + 1) , significant);
	}
	
	@Test public void testMemberFeatureCall_02() throws Exception {
		String text = "'a'?.toString";
		XMemberFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(featureCall);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals(text.substring(text.indexOf('.') + 1) , significant);
	}
	
	@Test public void testMemberFeatureCall_03() throws Exception {
		String text = "'a'*.toString";
		XMemberFeatureCall featureCall = castedExpression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(featureCall);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals(text.substring(text.indexOf('.') + 1) , significant);
	}
	
	@Test public void testQualifiedAssignment_01() throws Exception {
		String text = "'a'.doesNotExist = 'b'";
		XAssignment assignment = castedExpression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(assignment);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals(text.substring(text.indexOf('.') + 1) , significant);
	}
	
	@Test public void testAssignment_rhs_01() throws Exception {
		String text = "a = b";
		XAssignment assignment = (XAssignment) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(assignment, XbasePackage.Literals.XASSIGNMENT__VALUE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("b", significant);
	}
	
	@Test public void testAssignment_rhs_02() throws Exception {
		String text = "a = b += c";
		XAssignment assignment = (XAssignment) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(assignment, XbasePackage.Literals.XASSIGNMENT__VALUE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("b += c", significant);
	}
	
	@Test public void testAssignment_rhs_03() throws Exception {
		String text = "a = b += c";
		XBinaryOperation assignment = (XBinaryOperation) ((XAssignment) expression(text)).getValue();
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(assignment, XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("c", significant);
	}
	
	@Test public void testAssignment_rhs_04() throws Exception {
		String text = "a = b += c";
		XBinaryOperation assignment = (XBinaryOperation) ((XAssignment) expression(text)).getValue();
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(assignment, XbasePackage.Literals.XBINARY_OPERATION__LEFT_OPERAND, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("b", significant);
	}
	
	@Test public void testAssignment_rhs_05() throws Exception {
		String text = "a = b += c = d";
		XAssignment assignment = (XAssignment) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(assignment, XbasePackage.Literals.XASSIGNMENT__VALUE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("b += c = d", significant);
	}
	
	@Test public void testBinaryOperation_01() throws Exception {
		String text = "a + b + c + d";
		XBinaryOperation operation = (XBinaryOperation) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(operation, XbasePackage.Literals.XBINARY_OPERATION__LEFT_OPERAND, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("a + b + c", significant);
	}
	
	@Test public void testBinaryOperation_02() throws Exception {
		String text = "a + b + c + d";
		XBinaryOperation operation = (XBinaryOperation) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(operation, XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("d", significant);
	}
	
	@Test public void testBinaryOperation_03() throws Exception {
		String text = "a - b - c + d";
		XBinaryOperation operation = (XBinaryOperation) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(operation, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("+", significant);
	}
	
}

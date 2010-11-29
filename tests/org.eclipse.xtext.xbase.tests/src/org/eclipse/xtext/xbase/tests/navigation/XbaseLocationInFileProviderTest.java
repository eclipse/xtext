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
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseLocationInFileProviderTest extends AbstractXbaseTestCase {

	private ILocationInFileProvider locationInFileProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		locationInFileProvider = get(ILocationInFileProvider.class);
	}
	
	@Override
	protected void tearDown() throws Exception {
		locationInFileProvider = null;
		super.tearDown();
	}
	
	@Override
	protected XExpression expression(String string) throws Exception {
		return super.expression(string, false);
	}
	
	public void testAssignment_rhs_01() throws Exception {
		String text = "a = b";
		XAssignment assignment = (XAssignment) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(assignment, XbasePackage.Literals.XASSIGNMENT__VALUE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("b", significant);
	}
	
	public void testAssignment_rhs_02() throws Exception {
		String text = "a = b += c";
		XAssignment assignment = (XAssignment) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(assignment, XbasePackage.Literals.XASSIGNMENT__VALUE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("b += c", significant);
	}
	
	public void testAssignment_rhs_03() throws Exception {
		String text = "a = b += c";
		XAssignment assignment = (XAssignment) ((XAssignment) expression(text)).getValue();
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(assignment, XbasePackage.Literals.XASSIGNMENT__VALUE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("c", significant);
	}
	
	public void testAssignment_rhs_04() throws Exception {
		String text = "a = b += c";
		XAssignment assignment = (XAssignment) ((XAssignment) expression(text)).getValue();
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(assignment, XbasePackage.Literals.XASSIGNMENT__ASSIGNABLE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("b", significant);
	}
	
	public void testAssignment_rhs_05() throws Exception {
		String text = "a = b += c = d";
		XAssignment assignment = (XAssignment) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(assignment, XbasePackage.Literals.XASSIGNMENT__VALUE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("b += c = d", significant);
	}
	
	public void testBinaryOperation_01() throws Exception {
		String text = "a + b + c + d";
		XBinaryOperation operation = (XBinaryOperation) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(operation, XbasePackage.Literals.XBINARY_OPERATION__LEFT_OPERAND, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("a + b + c", significant);
	}
	
	public void testBinaryOperation_02() throws Exception {
		String text = "a + b + c + d";
		XBinaryOperation operation = (XBinaryOperation) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(operation, XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("d", significant);
	}
	
	public void testBinaryOperation_03() throws Exception {
		String text = "a - b - c + d";
		XBinaryOperation operation = (XBinaryOperation) expression(text);
		ITextRegion region = locationInFileProvider.getSignificantTextRegion(operation, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0);
		String significant = text.substring(region.getOffset(), region.getOffset() + region.getLength());
		assertEquals("+", significant);
	}
	
}

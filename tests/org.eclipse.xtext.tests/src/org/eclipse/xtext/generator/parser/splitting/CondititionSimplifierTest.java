/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.splitting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.parser.antlr.splitting.ConditionSimplifier;
import org.eclipse.xtext.generator.parser.antlr.splitting.SimpleExpressionsStandaloneSetup;
import org.eclipse.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.util.EmfFormatter;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CondititionSimplifierTest extends AbstractXtextTests {

	private ConditionSimplifier conditionSimplifier;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(SimpleExpressionsStandaloneSetup.class);
		conditionSimplifier = new ConditionSimplifier();
	}
	
	public void testAorA() throws Exception {
		String model = "if (a||a) {";
		String expectation = "if (a) {";
		check(expectation, model);
	}
	
	public void testAandA() throws Exception {
		String model = "if (a&&a) {";
		String expectation = "if (a) {";
		check(expectation, model);
	}
	
	public void testNotNotA() throws Exception {
		String model = "if (!(!a)) {";
		String expectation = "if (a) {";
		check(expectation, model);
	}
	
	public void testAorAandB() throws Exception {
		String model = "if (a||a&&b) {";
		String expectation = "if (a) {";
		check(expectation, model);
	}
	
	public void testAandBorA() throws Exception {
		String model = "if (a&&b||a) {";
		String expectation = "if (a) {";
		check(expectation, model);
	}
	
	public void testAandBorAandB() throws Exception {
		String model = "if (a&&b||a&&b) {";
		String expectation = "if (a&&b) {";
		check(expectation, model);
	}

	public void check(String expectation, String model) throws Exception {
		EObject parsedModel = getModel(model);
		EObject parsedExpectation = getModel(expectation);
		conditionSimplifier.simplify((IfCondition) parsedModel);
		String formattedModel = EmfFormatter.objToStr(parsedModel);
		String formattedExpectation = EmfFormatter.objToStr(parsedExpectation);
		assertEquals(formattedExpectation, formattedModel);
	}
	
}

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipsecon.example.interpreter;

import org.eclipse.xtext.example.arithmetics.ArithmeticsStandaloneSetup;
import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.example.arithmetics.arithmetics.Statement;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.eclipse.xtext.junit.AbstractXtextTests;


public class CalculatorTest extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new ArithmeticsStandaloneSetup());
	}
	
	public void testSimple() throws Exception {
		check(6,"1 + 2 + 3");
		check(0,"1 + 2 - 3");
		check(5,"1 * 2 + 3");
		check(-4,"1 - 2 - 3");
		check(1.5,"1 / 2 * 3");
	}
	
	protected void check(String result,String expression) throws Exception {
		assertEquals(result,evaluate(getStatement(expression)).toString());
	}
	protected void check(int result,String expression) throws Exception {
		check(result+"",expression);
	}
	protected void check(double result,String expression) throws Exception {
		check(result+"",expression);
	}

	protected Statement getStatement(String string) throws Exception {
		Module model = (Module) getModel("module test "+string+";");
		Statement statement = model.getStatements().get(0);
		return statement;
	}

	private Object evaluate(Statement statement) {
		return new Calculator().evaluate(((Evaluation)statement).getExpression());
	}
}

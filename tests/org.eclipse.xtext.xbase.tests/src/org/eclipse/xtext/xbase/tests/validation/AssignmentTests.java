/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class AssignmentTests extends AbstractXbaseValidationTest {

	public void testAssignmentToVal() throws Exception {
		XExpression expression = expression("{ val x = true; x = false }");
		assertError(expression, XbasePackage.Literals.XASSIGNMENT, XbaseJavaValidator.ASSIGNMENT_TO_FINAL, "Assignment", "final", "variable");
	}
	
	public void testAssignmentToParameter() throws Exception {
		XExpression expression = expression("[foo|foo=false]");
		assertError(expression, XbasePackage.Literals.XASSIGNMENT, XbaseJavaValidator.ASSIGNMENT_TO_FINAL, "Assignment", "final", "parameter");
	}
	
}

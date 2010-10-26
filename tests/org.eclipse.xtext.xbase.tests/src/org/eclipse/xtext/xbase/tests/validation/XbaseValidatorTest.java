/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.typing.ITypeConformanceComputer.*;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.typing.AbstractXbaseValidatonTest;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class XbaseValidatorTest extends AbstractXbaseValidatonTest  {

	@Inject
	protected XbaseJavaValidator validator;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		validator.setMessageAcceptor(this);
		errors = Lists.newArrayList();
	}

	public void testTypeErrorsAreDetected() throws Exception {
		XExpression expression = expression("(java.lang.Boolean) 'foo'", true);
		validator.checkTypes(expression);
		assertError(XbasePackage.Literals.XSTRING_LITERAL, ISSUE_NON_CONFORMANT_TYPES, "java.lang.Boolean",
				"java.lang.String");
	}

}

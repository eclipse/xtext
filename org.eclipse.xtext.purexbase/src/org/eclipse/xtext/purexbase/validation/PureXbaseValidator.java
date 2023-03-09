/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.validation;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XExpression;

/**
 * This class contains custom validation rules.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class PureXbaseValidator extends AbstractPureXbaseValidator {

//	public static final INVALID_NAME = 'invalidName'
//
//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital",
//					PureXbasePackage.Literals.GREETING__NAME,
//					INVALID_NAME);
//		}
//	}

	@Check
	@Override
	public void checkInnerExpressions(XExpression expr) {
		// disabled since pure xbase is meant to be a playground
	}

}

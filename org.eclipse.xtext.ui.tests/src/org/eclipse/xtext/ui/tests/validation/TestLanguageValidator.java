/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.validation;

import org.eclipse.xtext.ui.tests.foo.FooPackage;
import org.eclipse.xtext.ui.tests.foo.Stuff;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;

/**
 * This class contains custom validation rules.
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class TestLanguageValidator extends AbstractTestLanguageValidator {

	@Check(CheckType.EXPENSIVE)
	public void checkTypeNameStartsWithCapital(Stuff stuff) {
		if ("foo".equalsIgnoreCase(stuff.getName())) {
			error("Invalid Stuff name", FooPackage.Literals.STUFF__NAME);
		}
	}

}

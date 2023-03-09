/*
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.validation;

import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration;
import org.eclipse.xtext.validation.Check;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.*;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class TestLanguageValidator extends AbstractTestLanguageValidator {
	
	public static final String INVALID_NAME = "invalidName";
	public static final String UNSORTED_MEMBERS = "unsorted_members";
	public static final String MULTILINE_PROBLEM = "multiline_problem";

	@Check
	public void checkGreetingStartsWithCapital(TypeDeclaration type) {
		if (!Character.isUpperCase(type.getName().charAt(0))) {
			warning("Name should start with a capital", 
					TestLanguagePackage.Literals.ABSTRACT_ELEMENT__NAME,
					INVALID_NAME);
		}
	}
	
	@Check
	public void checkMembersAreSorted(TypeDeclaration type) {
		if (!sortBy(type.getMembers(), e -> e.getName()).equals(type.getMembers())) {
			warning(
				"Members should be in alphabetic order.",
				TestLanguagePackage.Literals.ABSTRACT_ELEMENT__NAME,
				UNSORTED_MEMBERS
			);
		}
	}
	
	@Check
	public void checkWithMultilineError(TypeDeclaration type) {
		if (type.getName().startsWith("Multiline")) {
			warning("Test Validation to mark the whole type", null, MULTILINE_PROBLEM);
		}
	}
	
}

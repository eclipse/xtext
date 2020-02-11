/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.validation

import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration
import org.eclipse.xtext.validation.Check

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class TestLanguageValidator extends AbstractTestLanguageValidator {
	
	public static val INVALID_NAME = 'invalidName'
	public static val UNSORTED_MEMBERS = 'unsorted_members'
	public static val MULTILINE_PROBLEM = 'multiline_problem'

	@Check
	def checkGreetingStartsWithCapital(TypeDeclaration type) {
		if (!Character.isUpperCase(type.name.charAt(0))) {
			warning('Name should start with a capital', 
					TestLanguagePackage.Literals.ABSTRACT_ELEMENT__NAME,
					INVALID_NAME)
		}
	}
	
	@Check
	def checkMembersAreSorted(TypeDeclaration type) {
		if (type.members.sortBy[name] != type.members) {
			warning(
				'Members should be in alphabetic order.',
				TestLanguagePackage.Literals.ABSTRACT_ELEMENT__NAME,
				UNSORTED_MEMBERS
			)
		}
	}
	
	@Check
	def checkWithMultilineError(TypeDeclaration type) {
		if (type.name.startsWith("Multiline")) {
			warning("Test Validation to mark the whole type", null, MULTILINE_PROBLEM)
		}
	}
	
}

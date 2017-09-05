/*
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	@Check
	def checkGreetingStartsWithCapital(TypeDeclaration type) {
		if (!Character.isUpperCase(type.name.charAt(0))) {
			warning('Name should start with a capital', 
					TestLanguagePackage.Literals.TYPE_DECLARATION__NAME,
					INVALID_NAME)
		}
	}
	
	@Check
	def checkMembersAreSorted(TypeDeclaration type) {
		if (type.members.sortBy[name] != type.members) {
			warning(
				'Members should be in alphabetic order.',
				TestLanguagePackage.Literals.TYPE_DECLARATION__NAME,
				UNSORTED_MEMBERS
			)
		}
	}
	
}

/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.conversion.ValueConverterException

import static org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity.*
import static org.eclipse.xtext.util.Strings.equal

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@ImplementedBy(RuleBasedNameValidator)
interface IRenameNameValidator {

	def void validate(EObject target, String newName, RefactoringIssueAcceptor issues)

	class RuleBasedNameValidator implements IRenameNameValidator {

		@Inject IValueConverterService valueConverterService

		override validate(EObject target, String newName, RefactoringIssueAcceptor issues) {
			try {
				var String value = getNameAsValue(newName)
				var String text = getNameAsText(value)
				if (!equal(text, newName)) {
					issues.add(ERROR, '''Illegal name: '«newName»'. Consider using '«text»' instead.''')
				}
			} catch (ValueConverterException e) {
				issues.add(FATAL, '''Illegal name: «e?.message»''')
			}
		}

		protected def String getNameAsText(String nameAsValue) {
			valueConverterService.toString(nameAsValue, ruleName)
		}

		protected def String getNameAsValue(String nameAsText) {
			return valueConverterService.toValue(nameAsText, ruleName, null).toString()
		}

		protected def getRuleName() {
			'ID'
		}
	}
}

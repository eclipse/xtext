/*******************************************************************************
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;

import static org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity.*;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@ImplementedBy(IRenameNameValidator.RuleBasedNameValidator.class)
public interface IRenameNameValidator {

	void validate(EObject target, String newName, RefactoringIssueAcceptor issues);

	class RuleBasedNameValidator implements IRenameNameValidator {

		@Inject private IValueConverterService valueConverterService;

		@Override
		public void validate(EObject target, String newName, RefactoringIssueAcceptor issues) {
			try {
				getNameAsValue(newName);
			} catch (ValueConverterException e) {
				issues.add(FATAL, "Illegal name: " + e.getMessage());
			}
		}

		protected String getNameAsText(String nameAsValue) {
			return valueConverterService.toString(nameAsValue, getRuleName());
		}

		protected String getNameAsValue(String nameAsText) {
			return valueConverterService.toValue(nameAsText, getRuleName(), null).toString();
		}

		protected String getRuleName() {
			return "ID";
		}
	}
}

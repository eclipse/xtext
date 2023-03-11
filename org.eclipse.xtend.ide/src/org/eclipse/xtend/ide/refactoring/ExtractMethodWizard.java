/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExtractMethodWizard extends RefactoringWizard {

	private ExtractMethodUserInputPage userInputPage;

	public static class Factory {
		@Inject
		private Provider<ExtractMethodUserInputPage> inputPageProvider;
		
		public ExtractMethodWizard create(Refactoring refactoring) {
			return new ExtractMethodWizard(refactoring, inputPageProvider.get());
		}
	}

	protected ExtractMethodWizard(Refactoring refactoring, ExtractMethodUserInputPage userInputPage) {
		super(refactoring, RefactoringWizard.DIALOG_BASED_USER_INTERFACE);
		this.userInputPage = userInputPage;
	}

	@Override
	protected void addUserInputPages() {
		userInputPage.setRefactoring((ExtractMethodRefactoring) getRefactoring());
		addPage(userInputPage);
	}
	
	@Override
	public String getWindowTitle() {
		return "Extract Method";
	}
}

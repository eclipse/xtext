/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.ltk.core.refactoring.RefactoringTickProvider;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class DefaultRenameRefactoringProvider implements IRenameRefactoringProvider {
	@Inject
	private Provider<AbstractRenameProcessor> processorProvider;

	public RenameRefactoring getRenameRefactoring(IRenameElementContext renameElementContext) {
		AbstractRenameProcessor processor = processorProvider.get();
		if (processor != null) {
			processor.initialize(renameElementContext);
			return new RenameRefactoring(processor) {
				@Override
				protected RefactoringTickProvider doGetRefactoringTickProvider() {
					return new RefactoringTickProvider(1, 200, 1, 1);
				}
			};
		}
		return null;
	}

}
/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.refactoring.IRenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.IRenameElementRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.IRenameElementStrategy;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class DefaultRenameElementRefactoringProvider implements IRenameElementRefactoringProvider {
	@Inject
	private Provider<IRenameElementProcessor> processorProvider;

	@Inject 
	private IRenameElementStrategy.Provider strategyProvider;
	
	public RenameRefactoring getRenameRefactoring(IEObjectDescription element) {
		IRenameElementProcessor processor = processorProvider.get();
		if (processor != null) {
			IRenameElementStrategy strategy = strategyProvider.get(element);
			processor.initialize(element, strategy);
			return new RenameRefactoring((RenameProcessor) processor);
		}
		return null;
	}

}
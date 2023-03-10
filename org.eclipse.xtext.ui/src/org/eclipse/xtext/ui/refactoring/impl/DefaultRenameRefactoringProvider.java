/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.core.runtime.Assert;
import org.eclipse.ltk.core.refactoring.RefactoringTickProvider;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultRenameRefactoringProvider implements IRenameRefactoringProvider {
	@Inject
	private Provider<AbstractRenameProcessor> processorProvider;

	@Override
	public ProcessorBasedRefactoring getRenameRefactoring(IRenameElementContext renameElementContext) {
		RenameProcessor processor = getRenameProcessor(renameElementContext);
		if (processor != null) {
			return new RenameRefactoring(processor);
		}
		return null;
	}
	
	@Override
	public RenameProcessor getRenameProcessor(IRenameElementContext renameElementContext) {
		AbstractRenameProcessor processor = processorProvider.get();
		if (processor != null && processor.initialize(renameElementContext)) {
			return processor;
		}
		return null;
	}
	
	protected static class RenameRefactoring extends ProcessorBasedRefactoring {

		private RenameProcessor fProcessor;

		public RenameRefactoring(RenameProcessor processor) {
			super(processor);
			Assert.isNotNull(processor);
			fProcessor= processor;
		}

		@Override
		public RefactoringProcessor getProcessor() {
			return fProcessor;
		}
		
		@Override
		protected RefactoringTickProvider doGetRefactoringTickProvider() {
			// some geeky fun with progress markers
			return new RefactoringTickProvider(1, 200, 1, 1);
		}
	}

}
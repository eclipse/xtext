/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.internal.corext.refactoring.rename.JavaRenameProcessor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.xtext.common.types.ui.refactoring.participant.TextChangeCombiner;

/**
 * A refactoring that combines its changes. 
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class ChangeCombiningRenameRefactoring extends ProcessorBasedRefactoring {
	
	private TextChangeCombiner textChangeCombiner;

	public ChangeCombiningRenameRefactoring(RefactoringProcessor processor, TextChangeCombiner textChangeCombiner) {
		super(processor);
		this.textChangeCombiner = textChangeCombiner;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException {
		return textChangeCombiner.combineChanges(super.createChange(pm));
	}

	@Override
	public void setProcessor(RefactoringProcessor processor) {
		if(processor instanceof CombinedJvmJdtRenameProcessor) {
			for(JavaRenameProcessor subProcessor: ((CombinedJvmJdtRenameProcessor) processor).getSubProcessors()) {
				// LTK's API made RefactoringProcessor.setRefactoring package private
				// such that we cannot override it in CombinedJvmJdtRenameProcessor. We have to set
				// the processors iteratively from the refactoring side !? 
				super.setProcessor(subProcessor);
			}
		}
		super.setProcessor(processor);
	}
}

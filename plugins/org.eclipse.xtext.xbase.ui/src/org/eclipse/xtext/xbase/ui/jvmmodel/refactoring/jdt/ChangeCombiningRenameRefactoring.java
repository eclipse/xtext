/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.xtext.common.types.ui.refactoring.participant.TextChangeCombiner;

/**
 * A refactoring that combines its changes.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
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
		if (processor instanceof CombinedJvmJdtRenameProcessor)
			((CombinedJvmJdtRenameProcessor) processor).setRefactoring(this);
		else
			super.setProcessor(processor);
	}
}

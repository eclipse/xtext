/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;

import com.google.inject.ImplementedBy;

/**
 * A common interface for JDT's {@link org.eclipse.jdt.internal.corext.refactoring.tagging.INameUpdating} and Xtext's
 * {@link AbstractRenameProcessor}. 
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IRenameProcessorAdapter {

	@ImplementedBy(DefaultFactory.class)
	interface Factory {
		IRenameProcessorAdapter create(RenameProcessor renameProcessor);
	}

	String getOriginalName();

	String getNewName();

	void setNewName(String newName);

	RefactoringStatus validateNewName(String newName);
	
	RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws Exception; 
	
	RefactoringStatus checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws Exception;
	
	Change createChange(IProgressMonitor pm) throws Exception;
	

	class DefaultFactory implements Factory {
		public IRenameProcessorAdapter create(RenameProcessor renameProcessor) {
			if (renameProcessor instanceof IRenameProcessorAdapter) {
				return (IRenameProcessorAdapter) renameProcessor;
			}
			throw new IllegalArgumentException("Cannot adapt " + notNull(renameProcessor)
					+ " to IRenameProcessorAdapter");
		}
	}
}
/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;

import com.google.inject.ImplementedBy;

/**
 * A common interface for JDT's {@link org.eclipse.jdt.internal.corext.refactoring.tagging.INameUpdating} and Xtext's
 * {@link AbstractRenameProcessor}. 
 * 
 * @author koehnlein - Initial contribution and API
 */
public interface IRenameProcessorAdapter {

	@ImplementedBy(DefaultFactory.class)
	interface Factory {
		IRenameProcessorAdapter create(ProcessorBasedRefactoring renameRefactoring);
	}

	String getOriginalName();

	String getNewName();

	void setNewName(String newName);

	RefactoringStatus validateNewName(String newName);

	class DefaultFactory implements Factory {
		public IRenameProcessorAdapter create(ProcessorBasedRefactoring renameRefactoring) {
			if (renameRefactoring.getProcessor() instanceof IRenameProcessorAdapter) {
				return (IRenameProcessorAdapter) renameRefactoring.getProcessor();
			}
			throw new IllegalArgumentException("Cannot adapt " + notNull(renameRefactoring)
					+ " to IRenameProcessorAdapter");
		}
	}
}
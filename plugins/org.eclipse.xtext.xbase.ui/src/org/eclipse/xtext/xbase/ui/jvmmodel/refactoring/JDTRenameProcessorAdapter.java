/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.internal.corext.refactoring.tagging.INameUpdating;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.xtext.ui.refactoring.IRenameProcessorAdapter;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JDTRenameProcessorAdapter implements IRenameProcessorAdapter {

	public static class Factory extends IRenameProcessorAdapter.DefaultFactory {
		@Override
		public IRenameProcessorAdapter create(ProcessorBasedRefactoring renameRefactoring) {
			RefactoringProcessor processor = renameRefactoring.getProcessor();
			if(processor instanceof INameUpdating) 
				return new JDTRenameProcessorAdapter((INameUpdating) processor);
			return super.create(renameRefactoring);
		}
	}
	
	private final INameUpdating processor;

	public JDTRenameProcessorAdapter(INameUpdating processor) {
		this.processor = processor;
	}

	public String getOriginalName() {
		return processor.getCurrentElementName();
	}

	public String getNewName() {
		return processor.getNewElementName();
	}

	public void setNewName(String newName) {
		processor.setNewElementName(newName);
	}

	public RefactoringStatus validateNewName(String newName) {
		try {
			return processor.checkNewElementName(newName);
		} catch(CoreException exc) {
			throw new WrappedException(exc);
		}
	}
}

/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.internal.corext.refactoring.rename.JavaRenameProcessor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.xtext.ui.refactoring.IRenameProcessorAdapter;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JavaRenameProcessorAdapter implements IRenameProcessorAdapter {

	public static class Factory extends IRenameProcessorAdapter.DefaultFactory {
		@Override
		public IRenameProcessorAdapter create(RenameProcessor processor) {
			if(processor instanceof JavaRenameProcessor) 
				return new JavaRenameProcessorAdapter((JavaRenameProcessor) processor);
			return super.create(processor);
		}
	}
	
	private final JavaRenameProcessor processor;

	public JavaRenameProcessorAdapter(JavaRenameProcessor processor) {
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

	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws Exception {
		return processor.checkInitialConditions(pm);
	}

	public RefactoringStatus checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context) throws Exception {
		return processor.checkFinalConditions(pm, context);
	}

	public Change createChange(IProgressMonitor pm) throws Exception {
		return processor.createChange(pm);
	}
	
	public RefactoringStatus validateNewName(String newName) {
		try {
			return processor.checkNewElementName(newName);
		} catch(CoreException exc) {
			throw new WrappedException(exc);
		}
	}
}

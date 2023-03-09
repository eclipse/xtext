/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelJdtRenameParticipantContext;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * TODO: introduce a binding annotation XbaseRenameParticipant 
 */
public class JdtRenameRefactoringParticipantProcessor extends RenameElementProcessor {

	@Inject
	private IJvmModelAssociations associations;

	@Override
	public boolean initialize(IRenameElementContext renameElementContext) {
		Assert.isLegal(renameElementContext instanceof JvmModelJdtRenameParticipantContext);
		return super.initialize(renameElementContext);
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		RefactoringStatus status = preCheckInitialConditions(pm);
		if(status.hasError())
			return status;
		return super.checkInitialConditions(pm);
	}

	/**
	 * Subclasses can decide to override this to allow specific multi-refactorings.
	 * 
	 * @since 2.4
	 */
	protected RefactoringStatus preCheckInitialConditions(IProgressMonitor pm) throws CoreException {
		if (associations.getJvmElements(getTargetElement()).size() > 1) {
			StatusWrapper statusWrapper = getStatusProvider().get();
			statusWrapper.add(ERROR,
					"Rename from here will not be complete. Try to rename {0} instead.",
					getTargetElement());
			statusWrapper.merge(super.checkInitialConditions(pm));
			return statusWrapper.getRefactoringStatus();
		}
		return new RefactoringStatus();
	}
}

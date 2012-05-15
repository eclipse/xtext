/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelJdtRenameParticipantContext;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.OperatorMappingUtil;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JdtRenameRefactoringParticipantProcessor extends RenameElementProcessor {

	@Inject
	private IJvmModelAssociations associations;

	@Inject
	private OperatorMappingUtil operatorMappingUtil;

	@Override
	public boolean initialize(IRenameElementContext renameElementContext) {
		Assert.isLegal(renameElementContext instanceof JvmModelJdtRenameParticipantContext);
		return super.initialize(renameElementContext);
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		if (associations.getJvmElements(getTargetElement()).size() > 1) {
			StatusWrapper statusWrapper = getStatusProvider().get();
			statusWrapper.add(ERROR,
					"Cannot rename single inferred element. Please rename source element {0} instead",
					getTargetElement());
			statusWrapper.merge(super.checkInitialConditions(pm));
			return statusWrapper.getRefactoringStatus();
		}
		return super.checkInitialConditions(pm);
	}
}

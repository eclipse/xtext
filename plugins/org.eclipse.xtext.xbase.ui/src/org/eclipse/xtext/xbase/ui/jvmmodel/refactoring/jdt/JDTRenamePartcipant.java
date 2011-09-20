/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.xtext.Constants;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @deprecated JDT refactoring participation is now handled centrally by the {@link org.eclipse.xtext.common.types.ui.refactoring.participant.JdtRenameParticipant}
 */
@Deprecated
public class JDTRenamePartcipant extends RenameParticipant {

	private static final Logger LOG = Logger.getLogger(JDTRenamePartcipant.class);
	
	@Inject@Named(Constants.LANGUAGE_NAME)
	private String languageName; 
	
	@Override
	protected boolean initialize(Object element) {
		LOG.error("Xbase's JDTRenameParticipant has been deprecated. Remove the registration from the plugin.xml of " + languageName + ".ui");
		return false;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws OperationCanceledException {
		return null;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return null;
	}

}

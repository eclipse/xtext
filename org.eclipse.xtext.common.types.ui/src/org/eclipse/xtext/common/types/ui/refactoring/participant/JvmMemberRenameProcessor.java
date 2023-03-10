/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring.participant;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * A rename processor capable of updating references to JvmElements.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmMemberRenameProcessor extends RenameElementProcessor {
	
	@Override
	public boolean initialize(IRenameElementContext renameElementContext) {
		if(!(renameElementContext instanceof JdtRenameParticipantContext))
			return false;
		return super.initialize(renameElementContext);
	}
	
	@Override
	protected ResourceSet createResourceSet(IRenameElementContext renameElementContext) {
		return getResourceSetProvider().get(
				((JdtRenameParticipantContext) renameElementContext).getRenamedJavaElement().getJavaProject()
						.getProject());
	}

	@Override
	protected boolean isValidTargetFile(Resource resource, StatusWrapper status) {
		// don't check, there is no file
		return true;
	}

}

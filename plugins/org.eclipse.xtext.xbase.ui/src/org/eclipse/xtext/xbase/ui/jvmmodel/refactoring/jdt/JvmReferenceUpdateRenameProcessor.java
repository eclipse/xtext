/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JvmReferenceUpdateRenameProcessor extends RenameElementProcessor {
	
	@Override
	protected ResourceSet createResourceSet(IRenameElementContext renameElementContext) {
		return getResourceSetProvider().get(
				((RenameJvmReferenceContext) renameElementContext).getReferencedJavaElement().getJavaProject()
						.getProject());
	}

	@Override
	protected void checkTargetFile(Resource resource) {
		// don't check, there is no file
	}

	@Override
	protected IRenameStrategy createRenameElementStrategy(EObject targetElement,
			IRenameElementContext renameElementContext) {
		return new JvmMemberRenameStrategy((JvmMember)targetElement);
	}
}

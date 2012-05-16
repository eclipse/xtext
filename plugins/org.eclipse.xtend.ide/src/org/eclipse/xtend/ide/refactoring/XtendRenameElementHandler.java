/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelRenameElementHandler;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendRenameElementHandler extends JvmModelRenameElementHandler {

	@Override
	protected EObject getDeclarationTarget(EObject targetElement) {
		EObject declarationTarget = super.getDeclarationTarget(targetElement);
		if(declarationTarget instanceof XtendConstructor)
			return declarationTarget.eContainer();
		else 
			return declarationTarget;
	}
}

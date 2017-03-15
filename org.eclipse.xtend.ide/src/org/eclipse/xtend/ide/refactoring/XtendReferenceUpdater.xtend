/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring

import org.eclipse.xtext.xbase.ui.refactoring.XbaseReferenceUpdater
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtend.core.xtend.AnonymousClass

/**
 * @author Jan Koehnlein - Initial contribution and API
 * 
 * @since 2.12
 */
class XtendReferenceUpdater extends XbaseReferenceUpdater {
	
	override protected createReferenceUpdate(EObject referringElement, URI referringResourceURI, EReference reference, int indexInList, EObject newTargetElement, IRefactoringUpdateAcceptor updateAcceptor) {
		// Anonymous classes report two references to the constructor of the superclass.
		// Filter one of them to avoid duplicate text edits. 
		if(referringElement instanceof XConstructorCall && referringElement.eContainer() instanceof AnonymousClass && newTargetElement instanceof JvmType) {
			return;
		}
		super.createReferenceUpdate(referringElement, referringResourceURI, reference, indexInList, newTargetElement, updateAcceptor)
	}
	
}
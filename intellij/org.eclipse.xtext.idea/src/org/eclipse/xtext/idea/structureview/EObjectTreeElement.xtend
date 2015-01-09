/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.structureview

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.PsiModelAssociations

/**
 * @author kosyakov - Initial contribution and API
 */
class EObjectTreeElement extends AbstractStructureViewTreeElement {

	@Inject
	PsiModelAssociations psiModelAssociations

	@Accessors
	EObject object
	
	override getValue() {
		object
	}

	override protected getInternalNavigationElement() {
		psiModelAssociations.getPsiElement(object)
	}

	override protected getObjectToPresent() {
		object
	}

	override equals(Object obj) {
		if (this === obj) {
			true
		} else if (obj instanceof EObjectTreeElement) {
			object == obj.object
		} else {
			false
		}
	}

	override hashCode() {
		object.hashCode
	}

}
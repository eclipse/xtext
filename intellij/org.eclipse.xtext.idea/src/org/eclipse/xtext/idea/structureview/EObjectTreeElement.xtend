/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.structureview

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.PsiModelAssociations

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class EObjectTreeElement extends AbstractStructureViewTreeElement {

	@Inject
	PsiModelAssociations psiModelAssociations

	URI uri

	@Accessors
	EObject object

	def void setObject(EObject object) {
		this.object = object
		this.uri = object.URI
	}

	override getValue() {
		uri
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
			uri == obj.uri
		} else {
			false
		}
	}

	override hashCode() {
		uri.hashCode
	}

}
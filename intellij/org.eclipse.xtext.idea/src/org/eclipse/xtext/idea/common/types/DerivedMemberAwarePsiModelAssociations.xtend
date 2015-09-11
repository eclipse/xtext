/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.common.types

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.psi.PsiModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class DerivedMemberAwarePsiModelAssociations extends PsiModelAssociations {

	@Inject
	extension IJvmModelAssociations jvmModelAssociations

	override getPsiElement(EObject object) {
		if (object == null)
			return null	
		
		val psiElement = super.getPsiElement(convertToSource(object))
		if (psiElement == null)
			// TODO: a hack just to be symmetric with Eclipse in the case if a primary source element is not set
			object.eContainer.psiElement
		else
			psiElement
	}

	protected def convertToSource(EObject object) {
		object.primarySourceElement ?: object
	}

}
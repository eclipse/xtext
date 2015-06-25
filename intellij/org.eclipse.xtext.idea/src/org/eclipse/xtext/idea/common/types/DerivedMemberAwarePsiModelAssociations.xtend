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
		super.getPsiElement(object.primarySourceElement ?: object)
	}

}
/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.jvmmodel

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.psi.PsiElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class PsiLogicalContainerProvider implements IPsiLogicalContainerProvider {

	@Inject
	extension IPsiModelAssociations

	@Inject
	ILogicalContainerProvider logicalContainerProvider

	override getNearestLogicalContainer(PsiElement expr) {
		expr.EObject.nearestLogicalContainer
	}

	override getNearestLogicalContainer(EObject expr) {
		logicalContainerProvider.getNearestLogicalContainer(expr).psiElement
	}

}
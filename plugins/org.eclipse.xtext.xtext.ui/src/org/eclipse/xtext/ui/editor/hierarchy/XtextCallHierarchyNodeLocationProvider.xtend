/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNodeLocationProvider

import static extension org.eclipse.xtext.GrammarUtil.*

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Singleton
class XtextCallHierarchyNodeLocationProvider extends DefaultHierarchyNodeLocationProvider {

	override getTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		val assignment = owner.containingAssignment
		if (assignment !== null)
			return assignment.textRegion

		return super.getTextRegion(owner, feature, indexInList)
	}

}

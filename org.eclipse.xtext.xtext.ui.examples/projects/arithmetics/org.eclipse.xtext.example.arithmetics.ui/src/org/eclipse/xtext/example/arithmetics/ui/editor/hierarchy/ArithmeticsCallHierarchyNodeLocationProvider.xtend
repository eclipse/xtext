/*******************************************************************************
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy

import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.example.arithmetics.arithmetics.FunctionCall
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyNodeLocationProvider

@Singleton
class ArithmeticsCallHierarchyNodeLocationProvider extends DefaultHierarchyNodeLocationProvider {

	override getTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		if (owner instanceof FunctionCall) {
			val textRegion = locationInFileProvider.getFullTextRegion(owner)
			return owner.toTextRegionWithLineInformation(textRegion)
		}

		return super.getTextRegion(owner, feature, indexInList)
	}

}

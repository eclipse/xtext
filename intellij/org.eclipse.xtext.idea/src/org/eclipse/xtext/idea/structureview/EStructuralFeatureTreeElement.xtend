/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.structureview

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.lib.annotations.Accessors

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

/**
 * @author kosyakov - Initial contribution and API
 */
class EStructuralFeatureTreeElement extends AbstractStructureViewTreeElement {

	@Accessors
	EObject owner

	@Accessors
	EStructuralFeature feature
	
	override getValue() {
		owner -> feature
	}

	override protected getInternalNavigationElement() {
		owner.findNodesForFeature(feature).map[leafNodes].flatten.filter[!hidden].head.ASTNodes.map[psi].head
	}

	override protected getObjectToPresent() {
		owner
	}

	override equals(Object obj) {
		if (this === obj) {
			true
		} else if (obj instanceof EStructuralFeatureTreeElement) {
			owner == obj.owner && feature == obj.feature
		} else {
			false
		}
	}

	override hashCode() {
		owner.hashCode * feature.hashCode
	}

}
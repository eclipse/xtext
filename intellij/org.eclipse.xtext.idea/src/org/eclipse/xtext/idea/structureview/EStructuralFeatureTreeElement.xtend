/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.structureview

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.lib.annotations.Accessors

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

/**
 * @author kosyakov - Initial contribution and API
 */
class EStructuralFeatureTreeElement extends AbstractStructureViewTreeElement {
	
	URI uri

	@Accessors
	EObject owner

	@Accessors
	EStructuralFeature feature
	
	override getValue() {
		uri -> feature
	}
	
	def void setOwner(EObject owner) {
		this.owner = owner
		this.uri = owner.URI
	}

	override protected getInternalNavigationElement() {
		owner.findNodesForFeature(feature).map[leafNodes].flatten.filter[!hidden].head.ASTNode.psi
	}

	override protected getObjectToPresent() {
		owner
	}

	override equals(Object obj) {
		if (this === obj) {
			true
		} else if (obj instanceof EStructuralFeatureTreeElement) {
			uri == obj.uri && feature == obj.feature
		} else {
			false
		}
	}

	override hashCode() {
		uri.hashCode * feature.hashCode
	}

}
/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.Property
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author kosyakov - Initial contribution and API
 */
class AssociationHierarchyBuilder extends DefaultCallHierarchyBuilder {

	@Inject
	extension IJvmModelAssociations

	@Inject
	AssociationHierarchyNodeLocationProvider associationHierarchyNodeLocationProvider

	override protected getHierarchyNodeLocationProvider() {
		associationHierarchyNodeLocationProvider
	}

	override protected findDeclaration(URI objectURI) {
		val description = objectURI.description
		if (description?.EClass.jvmType) {
			return readOnly(description.EObjectURI) [ targetElement |
				val sourceElement = targetElement.primarySourceElement
				if (sourceElement?.eClass.entity)
					return sourceElement.description
			]
		}
		if (description?.EClass.entity)
			return description

		return readOnly(objectURI) [ object |
			object.getContainerOfType(Entity).description
		]
	}

	override protected filterReference(IReferenceDescription reference) {
		if (reference === null || !reference.EReference.EType.jvmType)
			return false

		return readOnly(reference.sourceEObjectUri) [ referenceOwner |
			referenceOwner?.getContainerOfType(Property)?.getContainerOfType(Entity) !== null
		]
	}

	protected def isJvmType(EClassifier type) {
		TypesPackage.Literals.JVM_TYPE.isAssignable(type)
	}

	protected def isEntity(EClassifier type) {
		DomainmodelPackage.Literals.ENTITY.isAssignable(type)
	}

}

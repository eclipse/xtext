/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.Property
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder
import org.eclipse.xtext.resource.IEObjectDescription
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

	override protected getRootDeclaration(IEObjectDescription declaration) {
		if (declaration?.EClass.entity)
			return declaration

		if (declaration?.EClass.jvmType) {
			return resourceAccess.readOnly(declaration.EObjectURI) [
				val sourceElement = getEObject(declaration.EObjectURI, true).primarySourceElement
				if (sourceElement?.eClass.entity)
					return indexData.getExportedObjectsByObject(sourceElement).head
			]
		}
		return null
	}

	override protected getDeclaration(IReferenceDescription reference) {
		switch type : reference?.EReference?.EType {
			EClass case type.jvmType: {
				return resourceAccess.readOnly(reference.containerEObjectURI) [
					val referenceOwner = getEObject(reference.containerEObjectURI, true)
					val entity = referenceOwner.getContainerOfType(Property).getContainerOfType(Entity)
					if (entity !== null)
						return indexData.getExportedObjectsByObject(entity).head
				]
			}
		}
	}

	protected def isJvmType(EClass type) {
		TypesPackage.Literals.JVM_TYPE.isAssignableFrom(type)
	}

	protected def isEntity(EClass type) {
		DomainmodelPackage.Literals.ENTITY.isAssignableFrom(type)
	}

}

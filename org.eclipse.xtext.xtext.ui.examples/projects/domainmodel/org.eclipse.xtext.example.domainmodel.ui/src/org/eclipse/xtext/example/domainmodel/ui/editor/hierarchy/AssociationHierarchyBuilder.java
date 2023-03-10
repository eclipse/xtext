/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeLocationProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author kosyakov - Initial contribution and API
 */
public class AssociationHierarchyBuilder extends DefaultCallHierarchyBuilder {
	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Inject
	private AssociationHierarchyNodeLocationProvider associationHierarchyNodeLocationProvider;

	@Override
	protected IHierarchyNodeLocationProvider getHierarchyNodeLocationProvider() {
		return associationHierarchyNodeLocationProvider;
	}

	@Override
	protected IEObjectDescription findDeclaration(URI objectURI) {
		IEObjectDescription description = getDescription(objectURI);
		if (description != null) {
			EClass eClass = description.getEClass();
			if (isJvmType(eClass)) {
				return readOnly(description.getEObjectURI(), (EObject targetElement) -> {
					EObject sourceElement = jvmModelAssociations.getPrimarySourceElement(targetElement);
					if (sourceElement != null) {
						if (isEntity(sourceElement.eClass())) {
							return getDescription(sourceElement);
						}
					}
					return null;
				});
			}
			if (isEntity(eClass)) {
				return description;
			}
		}
		return readOnly(objectURI, (EObject object) -> {
			return getDescription(EcoreUtil2.getContainerOfType(object, Entity.class));
		});
	}

	@Override
	protected boolean filterReference(IReferenceDescription reference) {
		if (reference == null || !isJvmType(reference.getEReference().getEType())) {
			return false;
		}
		return readOnly(reference.getSourceEObjectUri(), (EObject referenceOwner) -> {
			if (referenceOwner != null) {
				Property container = EcoreUtil2.getContainerOfType(referenceOwner, Property.class);
				if (container != null) {
					Entity entity = EcoreUtil2.getContainerOfType(container, Entity.class);
					return entity != null;
				}
			}
			return false;
		});
	}

	protected boolean isJvmType(EClassifier type) {
		return isAssignable(TypesPackage.Literals.JVM_TYPE, type);
	}

	protected boolean isEntity(EClassifier type) {
		return isAssignable(DomainmodelPackage.Literals.ENTITY, type);
	}
}

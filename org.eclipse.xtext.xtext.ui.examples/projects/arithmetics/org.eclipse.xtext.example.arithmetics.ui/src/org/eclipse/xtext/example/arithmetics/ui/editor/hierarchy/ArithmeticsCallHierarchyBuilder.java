/**
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.example.arithmetics.arithmetics.AbstractDefinition;
import org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeLocationProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;

import com.google.inject.Inject;

public class ArithmeticsCallHierarchyBuilder extends DefaultCallHierarchyBuilder {
	@Inject
	private ArithmeticsCallHierarchyNodeLocationProvider arithmeticsCallHierarchyNodeLocationProvider;

	@Override
	protected IHierarchyNodeLocationProvider getHierarchyNodeLocationProvider() {
		return arithmeticsCallHierarchyNodeLocationProvider;
	}

	@Override
	protected IEObjectDescription findDeclaration(URI objectURI) {
		IEObjectDescription description = this.getDescription(objectURI);
		EClass eClass = null;
		if (description != null) {
			eClass = description.getEClass();
		}
		if (this.isDefinition(eClass)) {
			return description;
		}
		return readOnly(objectURI, (EObject object) -> {
			AbstractDefinition abstractDefinition = EcoreUtil2.getContainerOfType(object, AbstractDefinition.class);
			return getDescription(abstractDefinition);
		});
	}

	@Override
	protected boolean filterReference(IReferenceDescription reference) {
		return reference != null && isDefinition(reference.getEReference().getEType());
	}

	protected boolean isDefinition(EClassifier type) {
		return isAssignable(ArithmeticsPackage.Literals.ABSTRACT_DEFINITION, type);
	}
}

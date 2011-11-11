/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class DefaultJvmModelRenameStrategy extends DefaultRenameStrategy {

	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Override
	public void applyDeclarationChange(String newName, ResourceSet resourceSet) {
		super.applyDeclarationChange(newName, resourceSet);
		setInferredJvmElementName(newName, resourceSet);
	}

	@Override
	public void revertDeclarationChange(ResourceSet resourceSet) {
		super.revertDeclarationChange(resourceSet);
		setInferredJvmElementName(getOriginalName(), resourceSet);
	}

	protected void setInferredJvmElementName(String newName, ResourceSet resourceSet) {
		EObject renamedElement = resourceSet.getEObject(getTargetElementNewURI(), false);
		setInferredJvmElementName(newName, renamedElement);
	}

	protected void setInferredJvmElementName(String name, EObject renamedElement) {
		if (renamedElement.eResource() instanceof DerivedStateAwareResource) {
			DerivedStateAwareResource resource = (DerivedStateAwareResource) renamedElement.eResource();
			resource.discardDerivedState();
			resource.installDerivedState(false);
		}
	}
	
	protected IJvmModelAssociations getJvmModelAssociations() {
		return jvmModelAssociations;
	}
	
}

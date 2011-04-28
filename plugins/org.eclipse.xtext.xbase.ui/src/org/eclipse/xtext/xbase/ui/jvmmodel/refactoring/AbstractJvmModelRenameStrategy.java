/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public abstract class AbstractJvmModelRenameStrategy extends DefaultRenameStrategy {

	private IJvmModelAssociations jvmModelAssociations;

	protected AbstractJvmModelRenameStrategy(EObject targetElement, ILocationInFileProvider locationInFileProvider, IJvmModelAssociations xtend2jvmAssociations) {
		super(targetElement, locationInFileProvider);
		this.jvmModelAssociations = xtend2jvmAssociations;
	}

	@Override
	protected void resolveProxies(ResourceSet resourceSet) {
		for(int i=0; i< resourceSet.getResources().size(); ++i) {
			Resource resource = resourceSet.getResources().get(i);
			if(!(resource instanceof TypeResource))
				EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
		}
	}
	
	@Override
	public void applyDeclarationChange(String newName, ResourceSet resourceSet) {
		super.applyDeclarationChange(newName, resourceSet);
		setInferredJvmElementName(newName, resourceSet);
	}

	@Override
	public void revertDeclarationChange(ResourceSet resourceSet) {
		super.revertDeclarationChange(resourceSet);
		setInferredJvmElementName(originalName, resourceSet);
	}

	protected void setInferredJvmElementName(String newName, ResourceSet resourceSet) {
		EObject renamedElement = resourceSet.getEObject(targetElementNewURI, false);
		setInferredJvmElementName(newName, renamedElement);
	}

	protected abstract void setInferredJvmElementName(String name, EObject renamedSourceElement);
	
	protected IJvmModelAssociations getJvmModelAssociations() {
		return jvmModelAssociations;
	}
}

/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public abstract class AbstractJvmModelRenameStrategy extends DefaultRenameStrategy {

	private IJvmModelAssociations jvmModelAssociations;

	protected AbstractJvmModelRenameStrategy(EObject targetElement, EAttribute nameAttribute, ITextRegion originalNameRegion,
			String nameRuleName, IValueConverterService valueConverterService, IJvmModelAssociations xtend2jvmAssociations) {
		super(targetElement, nameAttribute, originalNameRegion, nameRuleName, valueConverterService);
		this.jvmModelAssociations = xtend2jvmAssociations;
	}

	/**
	 * @deprecated exists for backwards compatibility reasons only and will be removed in Xtext 2.1
	 */
	@Deprecated
	protected AbstractJvmModelRenameStrategy(EObject targetElement,
			ILocationInFileProvider locationInFileProvider,
			IJvmModelAssociations jvmModelAssociations) {
		super(targetElement, locationInFileProvider);
		this.jvmModelAssociations = jvmModelAssociations;
	}

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

	protected abstract void setInferredJvmElementName(String name, EObject renamedSourceElement);
	
	protected IJvmModelAssociations getJvmModelAssociations() {
		return jvmModelAssociations;
	}
}

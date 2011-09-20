/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import static org.eclipse.ltk.core.refactoring.RefactoringStatus.*;

import java.io.IOException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;

import com.google.inject.Inject;

/**
 * Generic rename strategy for EMF resources. For {@link XtextResource}s you should rather use the
 * {@link DefaultRenameStrategy}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class EmfResourceRenameStrategy extends AbstractRenameStrategy {

	@Inject
	private EmfResourceChangeUtil changeUtil;
	
	public void createDeclarationUpdates(String newName, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor) {
		Resource targetResource = resourceSet.getResource(getTargetElementOriginalURI().trimFragment(), false);
		EcoreUtil.resolveAll(targetResource);
		applyDeclarationChange(newName, resourceSet);
		try {
			changeUtil.addSaveAsUpdate(targetResource, updateAcceptor);
		} catch (IOException exc) {
			updateAcceptor.getRefactoringStatus().add(ERROR, exc.getMessage());
		}
	}
	
	@Override
	protected EAttribute getNameAttribute(EObject targetElement) {
		if (targetElement instanceof ENamedElement) {
			return EcorePackage.Literals.ENAMED_ELEMENT__NAME;
		}
		return null;
	}
}

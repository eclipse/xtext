/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.io.IOException;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.0
 */
public class EmfResourceRenameStrategy extends AbstractRenameStrategy {

	public static class Provider implements IRenameStrategy.Provider {
		
		@Inject
		private EmfResourceChangeUtil changeUtil;

		public IRenameStrategy get(EObject targetEObject, IRenameElementContext renameElementContext) {
			if(targetEObject instanceof ENamedElement)
				return new EmfResourceRenameStrategy((ENamedElement) targetEObject, changeUtil);
			else 
				return null;
		}
	}

	private EmfResourceChangeUtil changeUtil;

	protected EmfResourceRenameStrategy(ENamedElement targetEObject, EmfResourceChangeUtil changeUtil) {
		super(targetEObject);
		this.changeUtil = changeUtil;
	}

	public void createDeclarationUpdates(String newName, ResourceSet resourceSet, IRefactoringUpdateAcceptor updateAcceptor) {
		applyDeclarationChange(newName, resourceSet);
		Resource targetResource = resourceSet.getResource(targetElementOriginalURI.trimFragment(), false);
		try {
			changeUtil.addSaveAsUpdate(targetResource, updateAcceptor);
		} catch(IOException exc) {
			throw new RefactoringStatusException(exc, true);
		}
	}
}

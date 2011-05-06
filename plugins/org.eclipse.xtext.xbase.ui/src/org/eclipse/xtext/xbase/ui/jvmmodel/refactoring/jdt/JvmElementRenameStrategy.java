/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameStrategy;
import org.eclipse.xtext.util.SimpleAttributeResolver;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JvmElementRenameStrategy extends AbstractRenameStrategy {

	protected static final SimpleAttributeResolver<EObject, String> simpleNameResolver = SimpleAttributeResolver.newResolver(
			String.class, "simpleName");

	protected JvmElementRenameStrategy(EObject targetElement) {
		super(targetElement);
	}

	public void createDeclarationUpdates(String newName, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor) {
	}

	@Override
	protected EAttribute getNameAttribute(EObject eObject) {
		EAttribute eAttribute = super.getNameAttribute(eObject);
		if (eAttribute != null)
			return eAttribute;
		else
			return simpleNameResolver.getAttribute(eObject);
	}
	
	@Override
	protected void resolveProxies(ResourceSet resourceSet) {
		// don't resolve proxies
	}
}

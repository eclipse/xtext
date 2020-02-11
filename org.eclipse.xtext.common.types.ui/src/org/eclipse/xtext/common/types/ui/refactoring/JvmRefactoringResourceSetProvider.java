/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.refactoring;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;

import com.google.inject.Inject;

/**
 * Configures the resource set used during refactoring for JVM type awareness.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmRefactoringResourceSetProvider extends RefactoringResourceSetProvider {

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	@Override
	protected void configure(ResourceSet resourceSet) {
		super.configure(resourceSet);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
	}
}

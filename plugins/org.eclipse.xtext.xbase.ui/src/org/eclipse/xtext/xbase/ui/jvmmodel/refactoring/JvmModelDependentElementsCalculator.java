/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelDependentElementsCalculator extends DefaultDependentElementsCalculator {

	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Override
	public List<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		List<URI> dependentElementURIs = super.getDependentElementURIs(baseElement, monitor);
		addURIsIfNotNull(dependentElementURIs, jvmModelAssociations.getJvmElements(baseElement));
		return dependentElementURIs;
	}

	protected void addURIsIfNotNull(List<URI> dependentElementURIs, Iterable<EObject> dependentElements) {
		for (EObject dependentElement : dependentElements) {
			URI elementURI = EcoreUtil.getURI(dependentElement);
			if (elementURI != null)
				dependentElementURIs.add(elementURI);
		}
	}
}

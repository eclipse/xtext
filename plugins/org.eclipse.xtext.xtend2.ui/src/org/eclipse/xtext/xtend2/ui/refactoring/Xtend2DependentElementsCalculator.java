/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.refactoring;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2DependentElementsCalculator extends DefaultDependentElementsCalculator {

	@Override
	public List<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		List<URI> dependentElementURIs = super.getDependentElementURIs(baseElement, monitor);
		if (baseElement instanceof XtendClass)
			addURIIfNotNull(dependentElementURIs, ((XtendClass) baseElement).getInferredJvmType());
		else if(baseElement instanceof XtendMember)
			addURIIfNotNull(dependentElementURIs, ((XtendMember) baseElement).getInferredJvmMember());
		return dependentElementURIs;
	}

	protected void addURIIfNotNull(List<URI> dependentElementURIs, EObject dependentElement) {
		if (dependentElement != null) {
			URI elementURI = EcoreUtil.getURI(dependentElement);
			if (elementURI != null)
				dependentElementURIs.add(elementURI);
		}
	}

}

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
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringStatusException;
import org.eclipse.xtext.xtend2.linking.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2DependentElementsCalculator extends DefaultDependentElementsCalculator {

	@Inject
	private IXtend2JvmAssociations xtend2jvmAssociations;

	@Override
	public List<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		if (baseElement instanceof XtendFunction) {
			for (JvmOperation inferredOperation : xtend2jvmAssociations.getAssociatedElements(baseElement,
					JvmOperation.class)) {
				if (xtend2jvmAssociations.getAssociatedElements(inferredOperation).size() > 1)
					throw new RefactoringStatusException("Cannot refactor polymorphic dispatch method", true);
			}
		}
		List<URI> dependentElementURIs = super.getDependentElementURIs(baseElement, monitor);
		addURIsIfNotNull(dependentElementURIs, xtend2jvmAssociations.getInferredJvmElements(baseElement));
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

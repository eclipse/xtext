/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import static com.google.common.collect.Iterables.*;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
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
		addJvmConstructorURIs(dependentElementURIs, baseElement);
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		return dependentElementURIs;
	}

	protected void addURIsIfNotNull(List<URI> dependentElementURIs, Iterable<? extends EObject> dependentElements) {
		for (EObject dependentElement : dependentElements) {
			addJvmConstructorURIs(dependentElementURIs, dependentElement);
			URI elementURI = EcoreUtil.getURI(dependentElement);
			if (elementURI != null && !elementURI.isRelative() && !dependentElementURIs.contains(elementURI))
				dependentElementURIs.add(elementURI);
		}
	}
	
	protected void addJvmConstructorURIs(List<URI> dependentElementURIs, EObject baseElement) {
		if(baseElement instanceof JvmDeclaredType) {
			addURIsIfNotNull(dependentElementURIs, filter(((JvmDeclaredType) baseElement).getMembers(), JvmConstructor.class));
		}
	}
	
	protected IJvmModelAssociations getJvmModelAssociations() {
		return jvmModelAssociations;
	}
}

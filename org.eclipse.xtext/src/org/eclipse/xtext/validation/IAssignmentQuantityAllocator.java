/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ISyntaxConstraint;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider.IConcreteSyntaxDiagnostic;
import org.eclipse.xtext.validation.impl.AssignmentQuantityAllocator;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(AssignmentQuantityAllocator.class)
public interface IAssignmentQuantityAllocator {
	interface IQuantities {

		Map<ISyntaxConstraint, Integer> getAssignmentQuantities();

		Integer getAssignmentQuantity(ISyntaxConstraint assignement);

		EObject getEObject();

		Map<EStructuralFeature, Integer> getFeatureQuantities();

		Integer getFeatureQuantity(EStructuralFeature feat);

		Map<EStructuralFeature, Collection<ISyntaxConstraint>> groupByFeature();

	}

	IQuantities getAssignmentQuantities(EObject obj, ISyntaxConstraint rule, List<IConcreteSyntaxDiagnostic> acceptor); // TODO: use IDiagnAcceptor

	int getFeatureQuantity(EObject obj, EStructuralFeature feat);
}

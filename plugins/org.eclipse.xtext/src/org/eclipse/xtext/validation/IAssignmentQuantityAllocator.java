/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	public interface IQuantities {

		public Map<ISyntaxConstraint, Integer> getAssignmentQuantities();

		public Integer getAssignmentQuantity(ISyntaxConstraint assignement);

		public EObject getEObject();

		public Map<EStructuralFeature, Integer> getFeatureQuantities();

		public Integer getFeatureQuantity(EStructuralFeature feat);

		public Map<EStructuralFeature, Collection<ISyntaxConstraint>> groupByFeature();

	}

	public IQuantities getAssignmentQuantities(EObject obj, ISyntaxConstraint rule,
			List<IConcreteSyntaxDiagnostic> acceptor); // TODO: use IDiagnAcceptor

	public int getFeatureQuantity(EObject obj, EStructuralFeature feat);
}

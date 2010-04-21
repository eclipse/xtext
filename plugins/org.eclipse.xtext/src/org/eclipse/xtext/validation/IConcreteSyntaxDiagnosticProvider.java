/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ISyntaxConstraint;
import org.eclipse.xtext.validation.impl.ConcreteSyntaxDiagnosticProvider;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(ConcreteSyntaxDiagnosticProvider.class)
public interface IConcreteSyntaxDiagnosticProvider {

	public interface IConcreteSyntaxDiagnostic extends Diagnostic {
	}

	public static final int ERROR_ASSIGNMENT_MISSING = 7;

	public static final int ERROR_FEATURE_MISSING = 6;

	public static final int ERROR_LIST_TOO_FEW = 4;

	public static final int ERROR_LIST_TOO_MANY = 5;

	public static final int ERROR_LIST_UNDECIDEABLE = 3;

	public static final int ERROR_VALUE_PROHIBITED = 2;

	public static final int ERROR_VALUE_REQUIRED = 1;

	public static final int ERROR_WRONG_TYPE = 7;

	public IConcreteSyntaxDiagnostic createAssignmentMissingDiagnostic(ISyntaxConstraint rule, EObject source,
			EStructuralFeature feature, Set<ISyntaxConstraint> involved);

	public IConcreteSyntaxDiagnostic createFeatureDiagnostic(ISyntaxConstraint rule, EObject source, EStructuralFeature feature,
			int actual, int min, int max, Set<ISyntaxConstraint> involved);

	public IConcreteSyntaxDiagnostic createFeatureMissingDiagnostic(ISyntaxConstraint rule, EObject source, ISyntaxConstraint element,
			Set<ISyntaxConstraint> involved);

	public IConcreteSyntaxDiagnostic createObjectDiagnostic(ISyntaxConstraint rule, EObject source, Set<ISyntaxConstraint> involved);
}

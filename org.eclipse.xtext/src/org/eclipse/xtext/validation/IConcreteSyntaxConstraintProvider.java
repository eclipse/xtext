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
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.validation.impl.ConcreteSyntaxConstraintProvider;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(ConcreteSyntaxConstraintProvider.class)
public interface IConcreteSyntaxConstraintProvider {
	enum ConstraintType {
		ACTION, ALTERNATIVE, ASSIGNMENT, GROUP
	}

	interface ISyntaxConstraint {

		boolean dependsOn(ISyntaxConstraint ele);

		ISyntaxConstraint findCommonContainer(ISyntaxConstraint obj1);

		EStructuralFeature getAssignmentFeature(EClass clazz);

		String getAssignmentName();

		String getCardinality();

		ISyntaxConstraint getContainer();

		List<ISyntaxConstraint> getContents();

		AbstractElement getGrammarElement();

		Set<EClass> getSemanticTypes();

		Set<EClass> getSemanticTypesToCheck();

		ConstraintType getType();

		boolean isMultiple();

		boolean isOptional();

		boolean isRoot();

		String toString(final Map<ISyntaxConstraint, String> postfix);

	}

	ISyntaxConstraint getConstraint(ParserRule rule);

	Collection<ISyntaxConstraint> getConstraints(EClass cls);
}

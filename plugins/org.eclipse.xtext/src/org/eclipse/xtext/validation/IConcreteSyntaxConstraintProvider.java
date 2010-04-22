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
	public enum ConstraintType {
		ACTION, ALTERNATIVE, ASSIGNMENT, GROUP
	}

	public interface ISyntaxConstraint {

		public boolean dependsOn(ISyntaxConstraint ele);

		public ISyntaxConstraint findCommonContainer(ISyntaxConstraint obj1);

		public EStructuralFeature getAssignmentFeature(EClass clazz);

		public String getAssignmentName();

		public String getCardinality();

		public ISyntaxConstraint getContainer();

		public List<ISyntaxConstraint> getContents();

		public AbstractElement getGrammarElement();

		public Set<EClass> getSemanticTypes();

		public Set<EClass> getSemanticTypesToCheck();

		public ConstraintType getType();

		public boolean isMultiple();

		public boolean isOptional();

		public boolean isRoot();

		public String toString(final Map<ISyntaxConstraint, String> postfix);

	}

	public ISyntaxConstraint getConstraint(ParserRule rule);

	public Collection<ISyntaxConstraint> getConstraints(EClass cls);
}

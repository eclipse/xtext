/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IAstRegion extends ISequentialRegion {

	/**
	 * @return The grammar element used to parse this semantic region. Can be an {@link RuleCall},
	 *         {@link CrossReference}, or {@link Keyword}.
	 */
	EObject getGrammarElement();

	/**
	 * The AST-Element represented by this IEObjectRegion.
	 */
	EObject getSemanticElement();

	/**
	 * @since 2.13
	 */
	IEObjectRegion getContainingRegion();

	/**
	 * @since 2.13
	 */
	EStructuralFeature getContainingFeature();

	/**
	 * @since 2.13
	 */
	int getIndexInContainingFeature();
}

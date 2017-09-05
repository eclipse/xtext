/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IAstRegion extends ISequentialRegion {

	/**
	 * @return The grammar element used to parse this semantic region. Can be an {@link RuleCall}, {@link CrossReference}, or
	 *         {@link Keyword}.
	 */
	EObject getGrammarElement();

	/**
	 * The AST-Element represented by this IEObjectRegion.
	 */
	EObject getSemanticElement();
}

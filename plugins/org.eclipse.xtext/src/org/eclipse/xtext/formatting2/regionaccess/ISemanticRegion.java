/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

/**
 * Represents the value of an {@link EAttribute}, {@link CrossReference}, or {@link Keyword} inside a text document.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @see IHiddenRegion
 * @see ITextRegionAccess
 * 
 * @since 2.8
 */
public interface ISemanticRegion extends ISequentialRegion {

	/**
	 * @return The grammar element used to parse this semantic region. Can be an {@link RuleCall},
	 *         {@link CrossReference}, or {@link Keyword}.
	 */
	AbstractElement getGrammarElement();

	/**
	 * The EObject this semantic region belongs to.
	 */
	EObject getSemanticElement();
}
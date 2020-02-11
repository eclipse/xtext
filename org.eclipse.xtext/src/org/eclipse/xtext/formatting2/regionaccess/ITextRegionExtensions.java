/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;

/**
 * This class is a facade on top of an {@link ITextRegionAccess}.
 * 
 * It provides convenience methods to be used by formatters that are implemented in the Xtend programming language.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ITextRegionExtensions {

	ISemanticRegionsFinder allRegionsFor(EObject semanticElement);

	Iterable<ISemanticRegion> allSemanticRegions(EObject semanticElement);

	ITextRegionAccess getTextRegionAccess();

	/**
	 * @return the {@link RuleCall} or the assigned {@link Action} that led to the construction of this EObject. For the model's root
	 *         element, the {@link ParserRule} is returned.
	 */
	EObject grammarElement(EObject semanticElement);

	ISemanticRegionFinder immediatelyFollowing(EObject semanticElement);

	ISemanticRegionFinder immediatelyPreceding(EObject semanticElement);

	/**
	 * @return true, if the EObject's text range contains a line-wrap ("\n"). The EObject's text range reaches from the beginning of its
	 *         first semantic region to the end of its last semantic region.
	 */
	boolean isMultiline(EObject semanticElement);

	/**
	 * @return the {@link IHiddenRegion} that follows after the EObject's last {@link ISemanticRegion}.
	 * 
	 * @see #previousHiddenRegion(EObject)
	 */
	IHiddenRegion nextHiddenRegion(EObject semanticElement);

	/**
	 * @return the {@link IHiddenRegion} that precedes the EObject's first {@link ISemanticRegion}.
	 * 
	 * @see #nextHiddenRegion(EObject)
	 */
	IHiddenRegion previousHiddenRegion(EObject semanticElement);

	ISemanticRegionsFinder regionFor(EObject semanticElement);

	/**
	 * @return a text region that reaches from the beginning of its first semantic region to the end of its last semantic region.
	 */

	IEObjectRegion regionForEObject(EObject semanticElement);

	Iterable<ISemanticRegion> semanticRegions(EObject semanticElement);

}

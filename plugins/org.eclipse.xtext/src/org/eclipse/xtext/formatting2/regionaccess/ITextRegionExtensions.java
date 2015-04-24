/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ITextRegionExtensions {

	ISemanticRegionsFinder allRegionsFor(EObject object);

	Iterable<ISemanticRegion> allSemanticRegions(EObject object);

	ITextRegionAccess getTextRegionAccess();

	/**
	 * @return the {@link RuleCall} or the assigned {@link Action} that led to the construction of this EObject. For the
	 *         model's root element, the {@link ParserRule} is returned.
	 */
	EObject grammarElement(EObject obj);

	ISemanticRegionFinder immediatelyFollowing(EObject owner);

	ISemanticRegionFinder immediatelyPreceding(EObject owner);

	/**
	 * @return true, if the EObject's text range contains a line-wrap ("\n"). The EObject's text range reaches from the
	 *         beginning of its first semantic region to the end of its last semantic region.
	 */
	boolean isMultiline(EObject object);

	/**
	 * @return the {@link IHiddenRegion} that follows after the EObject's last {@link ISemanticRegion}.
	 * 
	 * @see #previousHiddenRegion(EObject)
	 */
	IHiddenRegion nextHiddenRegion(EObject owner);

	/**
	 * @return the {@link IHiddenRegion} that precedes the EObject's first {@link ISemanticRegion}.
	 * 
	 * @see #nextHiddenRegion(EObject)
	 */
	IHiddenRegion previousHiddenRegion(EObject owner);

	ISemanticRegionsFinder regionFor(EObject object);

	/**
	 * @return a text region that reaches from the beginning of its first semantic region to the end of its last
	 *         semantic region.
	 */

	IEObjectRegion regionForEObject(EObject object);

	Iterable<ISemanticRegion> semanticRegions(EObject object);

}

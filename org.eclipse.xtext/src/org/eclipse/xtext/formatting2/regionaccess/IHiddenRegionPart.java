/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.TerminalRule;

/**
 * Common interface for {@link IWhitespace} and {@link IComment}.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IHiddenRegionPart extends ITextSegment {

	/**
	 * @return The grammar element the parser used to parse this {@link IWhitespace} or {@link IComment}. This should be
	 *         an {@link TerminalRule} for tokens the grammar defined as 'hidden'. May be another grammar element if the
	 *         construction of the {@link ITextRegionAccess} has been customized.
	 */
	EObject getGrammarElement();

	/**
	 * @return the {@link IHiddenRegion} this {@link IWhitespace} or {@link IComment} is a member of.
	 */
	IHiddenRegion getHiddenRegion();

	/**
	 * @return The next following {@link IWhitespace} or {@link IComment} inside the same {@link IHiddenRegion}. Null if
	 *         the current {@link IHiddenRegionPart} is the last element inside its {@link IHiddenRegion}.
	 */
	IHiddenRegionPart getNextHiddenPart();

	/**
	 * @return The leading {@link IWhitespace} or {@link IComment} inside the same {@link IHiddenRegion}. Null if the
	 *         current {@link IHiddenRegionPart} is the first element inside its {@link IHiddenRegion}.
	 */
	IHiddenRegionPart getPreviousHiddenPart();

	/**
	 * @see IHiddenRegionPartAssociator for custom behaviour.
	 * 
	 * @since 2.14
	 * 
	 * @return A hint whether the whitespace or comment belongs to the previous or next semantic element or neither of
	 *         them.
	 */
	HiddenRegionPartAssociation getAssociation();
}
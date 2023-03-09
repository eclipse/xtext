/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import java.util.List;

/**
 * <p>
 * Represents and groups all {@link IWhitespace} and {@link IComment comments} between two {@link ISemanticRegion
 * semantic regions}. May be empty.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @see IComment
 * @see IWhitespace
 * @see ISemanticRegion
 * @see ITextRegionAccess
 * 
 * @since 2.8
 */
public interface IHiddenRegion extends ISequentialRegion {

	/**
	 * @return true, if {@link #getParts()} contains at least one {@link IComment}.
	 */
	boolean containsComment();

	/**
	 * @return all {@link IWhitespace white spaces} and {@link IComment comments} that belong to this
	 *         {@link IHiddenRegion}.
	 */
	List<IHiddenRegionPart> getParts();

	/**
	 * @return true, if there is no information about whitespace in this {@link IHiddenRegion}. This is the case if
	 *         there is no node model for this HiddenRegion. There may be no node model during serialization if a
	 *         semantic model has been constructed or modified programmatically.
	 */
	boolean isUndefined();

	/**
	 * @return returns a list that starts with whitespace, ends with whitespace and contains a sequence of strictly
	 *         alternating whitespace- and comment-regions.
	 */
	List<ITextSegment> getAlternatingMergedSpaceAndComments();

	List<ITextSegment> getMergedSpaces();
}
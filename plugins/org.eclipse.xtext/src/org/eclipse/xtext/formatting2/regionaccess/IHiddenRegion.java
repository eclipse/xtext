/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

import java.util.List;

/**
 * Represents and groups all {@link IWhitespace} and {@link IComment}s between two {@link ISemanticRegion}s. May be
 * empty.
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
	 * @return all {@link IWhitespace}s and {@link IComment}s that belong to this {@link IHiddenRegion}.
	 */
	List<IHiddenRegionPart> getParts();

	/**
	 * @return true, if there is no information about whitespace in this {@link IHiddenRegion}. This is the case if
	 *         there is no node model for this HiddenRegion. There may be no node model during serialization if a
	 *         semantic model has been constructed or modified programmatically.
	 */
	boolean isUndefined();
}
/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

/**
 * <p>
 * Common interface for {@link IHiddenRegion} and {@link ISemanticRegion}.
 * </p>
 * 
 * <p>
 * {@link IHiddenRegion} and {@link ISemanticRegion} are arranged strictly alternating in a linked list. This interface
 * provides the method to navigate that list.
 * </p>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISequentialRegion extends ITextSegment {

	ISemanticRegionFinder immediatelyFollowing();

	ISemanticRegionFinder immediatelyPreceding();

	IHiddenRegion getNextHiddenRegion();

	ISemanticRegion getNextSemanticRegion();

	ISequentialRegion getNextSequentialRegion();

	IHiddenRegion getPreviousHiddenRegion();

	ISemanticRegion getPreviousSemanticRegion();

	ISequentialRegion getPreviousSequentialRegion();
}

/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

/**
 * 
 * Instances describe one difference between an {@link ITextRegionAccessDiff} and its
 * {@link ITextRegionAccessDiff#getOriginalTextRegionAccess()}.
 * 
 * Instances are returned by {@link ITextRegionAccessDiff#getRegionDifferences()}.
 * 
 * Instances are created by {@link ITextRegionDiffBuilder}.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.13
 */
public interface ITextSegmentDiff {

	ITextSegment getModifiedFirstRegion();

	ITextSegment getModifiedLastRegion();

	/**
	 * @since 2.14
	 */
	ITextSegment getModifiedRegion();

	ITextSegment getOriginalFirstRegion();

	ITextSegment getOriginalLastRegion();

	/**
	 * @since 2.14
	 */
	ITextSegment getOriginalRegion();
}
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

import org.eclipse.xtext.util.ITextRegion;

/**
 * A text segment describes a part of a document and carries a few more information, e.g. about the current indentation
 * level.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public interface ITextSegment extends Comparable<ITextSegment>, ITextRegion {
	int getEndOffset();

	int getLineCount();

	List<ILineRegion> getLineRegions();

	String getText();

	ITextRegionAccess getTextRegionAccess();

	boolean isMultiline();

	@Override
	ITextSegment merge(ITextRegion region);

	ITextReplacement replaceWith(String text);
}

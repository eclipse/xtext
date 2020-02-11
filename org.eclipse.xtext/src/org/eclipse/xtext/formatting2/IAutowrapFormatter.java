/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * A strategy for formatting that is to be applied on auto wrapping.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @see IHiddenRegionFormatter#setOnAutowrap(IAutowrapFormatter)
 */
public interface IAutowrapFormatter {
	/**
	 * Called if the region is supposed to be wrapped.
	 */
	void format(ITextSegment region, IHiddenRegionFormatting wrapped, IFormattableDocument document);
}
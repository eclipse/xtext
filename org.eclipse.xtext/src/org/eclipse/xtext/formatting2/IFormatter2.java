/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionRewriter;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;

/**
 * <p>
 * Use this interface to invoke a formatter.
 * </p>
 * 
 * <p>
 * An Xtext language should have an implementation for this interface bound in its runtime module.
 * </p>
 * 
 * @see org.eclipse.xtext.formatting2 The package org.eclipse.xtext.formatting2 for an introduction to formatting
 * @see AbstractFormatter2 The base class {@code AbstractFormatter2} to implement your own formatter.
 * @see FormatterRequest The class {@code FormatterRequest} to specify what and how sould be formatted.
 * @see ITextRegionRewriter to apply replacements to a CharSequence or String.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.8
 */
public interface IFormatter2 {

	/**
	 * Execute the formatter.
	 */
	List<ITextReplacement> format(FormatterRequest request);

}

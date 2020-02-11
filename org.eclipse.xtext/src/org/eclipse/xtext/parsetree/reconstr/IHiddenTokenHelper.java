/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultHiddenTokenHelper;

import com.google.inject.ImplementedBy;

/**
 * @author meysholdt - Initial contribution and API
 */
@ImplementedBy(DefaultHiddenTokenHelper.class)
public interface IHiddenTokenHelper {

	boolean isWhitespace(AbstractRule rule);

	boolean isComment(AbstractRule rule);

	/**
	 * see {@link #getWhitespaceRuleFor(ParserRule, String)}
	 */
	@Deprecated
	AbstractRule getWhitespaceRuleFor(String whitespace);

	// is called when the formatter inserts whitespace
	AbstractRule getWhitespaceRuleFor(ParserRule context, String whitespace);
}

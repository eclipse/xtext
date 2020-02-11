/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractHiddenTokenHelper implements IHiddenTokenHelper {

	@Override
	@SuppressWarnings("deprecation")
	public AbstractRule getWhitespaceRuleFor(ParserRule context, String whitespace) {
		return getWhitespaceRuleFor(whitespace);
	}

}

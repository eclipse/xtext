/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultHiddenTokenHelper;

import com.google.inject.ImplementedBy;

/**
 * @author meysholdt - Initial contribution and API
 */
@ImplementedBy(DefaultHiddenTokenHelper.class)
public interface IHiddenTokenHelper {

	boolean isWhitespace(AbstractRule rule);

	boolean isComment(AbstractRule rule);

	// is called when the formatter inserts whitespace
	AbstractRule getWhitespaceRuleFor(String whitespace);
}

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;

/**
 * @author meysholdt - Initial contribution and API
 */
public class AbstractHiddenTokenHelper implements IHiddenTokenHelper {

	public AbstractRule getWhitespaceRuleFor(String whitespace) {
		return null;
	}

	public boolean isComment(AbstractRule rule) {
		return false;
	}

	public boolean isWhitespace(AbstractRule rule) {
		return false;
	}

}

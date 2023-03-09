/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseKeywordSerializer extends AbstractKeywordSerializer {

	@Override
	public boolean isValid(EObject context, Keyword keyword, Object value, IErrorAcceptor errorAcceptor) {
		if (value instanceof String)
			return keyword.getValue().equalsIgnoreCase((String)value);
		return false;
	}

}
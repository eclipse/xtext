/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseKeywordSerializer extends AbstractKeywordSerializer {

	public boolean isValid(EObject context, Keyword keyword, Object value, IErrorAcceptor errorAcceptor) {
		if (value instanceof String)
			return keyword.getValue().equalsIgnoreCase((String)value);
		return false;
	}

}
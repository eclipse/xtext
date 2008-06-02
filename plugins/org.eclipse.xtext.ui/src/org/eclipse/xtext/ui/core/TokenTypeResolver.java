/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import org.eclipse.xtext.parser.ITokenTypes;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class TokenTypeResolver {
	// TODO implementation
	public static String getTokenType(LeafNode node) {
		return ITokenTypes.ANYOTHER;
	}
}

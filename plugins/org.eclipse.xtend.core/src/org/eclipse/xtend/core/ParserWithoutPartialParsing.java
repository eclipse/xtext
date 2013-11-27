/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core;

import org.eclipse.xtend.core.parser.antlr.XtendParser;

import com.google.inject.Singleton;

/**
 * Disable partial parsing for Xtend. The partial parsing regions
 * almost always covered the complete file anyway and it is conceptually
 * hard to get the lookahead right.
 * 
 * @since 2.5
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class ParserWithoutPartialParsing extends XtendParser {

	@Override
	protected boolean isReparseSupported() {
		return false;
	}
	
}

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.eclipse.xtext.parser.IParseError;
import org.eclipse.xtext.parser.IParseErrorHandler;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class QuietErrorHandler implements IParseErrorHandler {
	public void handleParserError(IParseError error) {
		// we must overwrite this because the default Handler throws
		// exceptions
	}
}
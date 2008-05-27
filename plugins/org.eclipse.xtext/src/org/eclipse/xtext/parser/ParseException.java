/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;


/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
@SuppressWarnings("serial")
public class ParseException extends RuntimeException {

	private IParseError error;

	public ParseException(IParseError error) {
		if (error==null)
			throw new NullPointerException();
		this.error = error;
	}

	public IParseError getParseError() {
		return error;
	}
	
	@Override
	public String getMessage() {
		return this.error.getMessage();
	}
}

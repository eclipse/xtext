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
 */
@SuppressWarnings("serial")
public class ParseException extends RuntimeException {

	public ParseException(String message) {
		super(message);
	}

	public ParseException(String message, Exception re) {
		super(message,re);
	}

}

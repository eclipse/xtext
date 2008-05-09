/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.core.parser;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
@SuppressWarnings("serial")
public class ParseException extends RuntimeException {

	private int length;
	private int offset;
	private String text;
	private String message;

	public ParseException(int offset, int length, String text, String message) {
		this.length = length;
		this.offset = offset;
		this.text = text;
		this.message = message;
	}

	public int getLength() {
		return length;
	}

	public int getOffset() {
		return offset;
	}

	public String getText() {
		return text;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}

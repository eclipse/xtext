/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
@SuppressWarnings("serial")
public class ParseException extends RuntimeException {

	private AbstractNode node;
	private String message;

	public ParseException(AbstractNode node, String message) {
		this.node = node;
		this.message = message;
	}

	public int getLength() {
		return node.length();
	}

	public int getOffset() {
		return node.offset();
	}

	public String getText() {
		return node.serialize();
	}

	public AbstractNode getNode() {
		return node;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}

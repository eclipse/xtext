/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tokentype;

import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public abstract class TokenTypeDef implements ITokenTypeDef {
	private String id;
	private String name;

	/**
	 * @param id
	 */
	public TokenTypeDef(String id) {
		this(id, null);
	}

	/**
	 * @param id
	 * @param name
	 */
	public TokenTypeDef(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.tokentype.ITokenTypeDef#getId()
	 */
	public String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.tokentype.ITokenTypeDef#match(org.eclipse.xtext.
	 * parsetree.LeafNode)
	 */
	public abstract boolean match(LeafNode node);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.tokentype.ITokenTypeDef#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.tokentype.ITokenTypeDef#defaultTextStyle()
	 */
	public TextStyle defaultTextStyle() {
		return new TextStyle();
	}

}

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
	private TextStyle textStyle;

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
		this(id, name, new TextStyle(null, null, null));
	}

	/**
	 * @param id
	 * @param name
	 * @param textStyle
	 */
	public TokenTypeDef(String id, String name, TextStyle textStyle) {
		this.id = id;
		this.name = name;
		this.textStyle = textStyle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.tokentype.ITokenTypeDef#textStyleCopy()
	 */
	public TextStyle textStyleCopy() {
		return textStyle.copy();
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

	/**
	 * @param textStyle
	 *            the textStyle to set
	 */
	public void setTextStyle(TextStyle textStyle) {
		this.textStyle = textStyle;
	}

}

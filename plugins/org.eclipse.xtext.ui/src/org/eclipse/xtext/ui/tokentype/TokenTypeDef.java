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
	 * @param name
	 * @param textStyle
	 */
	public TokenTypeDef(String id, String name, TextStyle textStyle) {
		this.id = id;
		this.name = name;
		this.textStyle = textStyle;
	}

	/**
	 * @param id
	 * @param tokenType
	 */
	public TokenTypeDef(String id) {
		this.id = id;
	}

	/**
	 * @return the textStyle
	 */
	public TextStyle getTextStyle() {
		return textStyle;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	public abstract boolean match(LeafNode node);

	/**
	 * @param name
	 * 		the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param textStyle
	 * 		the textStyle to set
	 */
	public void setTextStyle(TextStyle textStyle) {
		this.textStyle = textStyle;
	}
}

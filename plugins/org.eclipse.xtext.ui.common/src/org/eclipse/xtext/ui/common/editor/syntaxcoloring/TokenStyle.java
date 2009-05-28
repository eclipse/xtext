/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class TokenStyle implements ITokenStyle {

	private String name;
	private String id;
	private TextStyle defaultTextStyle;
	
	public TokenStyle(String name, String id, TextStyle defaultTextStyle) {
		super();
		this.name = name;
		this.id = id;
		this.defaultTextStyle = defaultTextStyle;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokentype.ITokenType#getDefaultTextStyle()
	 */
	public TextStyle getDefaultTextStyle() {
		return defaultTextStyle;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokentype.ITokenType#getID()
	 */
	public String getID() {
		return id;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokentype.ITokenType#getName()
	 */
	public String getName() {
		return name;
	}

}
